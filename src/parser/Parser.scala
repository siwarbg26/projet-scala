package parser

import ast.Term
import Term.*
import ast.Op.*
import lexer.Token
import lexer.Token.*
import lexer.Lexer.nextToken

object Parser:
  private var currentToken: Token = _

  def parse(token: Token): Term =
    currentToken = token
    parseExpr()

  private def parseExpr(): Term =
    currentToken match
      case LET => parseLetInfix()
      case FUN => parseFun()
      case FIX => parseFix()
      case IFZ => parseIfzInfix()
      case _ => parseApp()

  private def parseLetValue(): Term =
    currentToken match
      case FUN => parseFunBody()
      case FIX => parseFixBody()
      case IFZ => parseIfzBody()
      case _ => parseMulDiv()

  private def parseFix(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception("Expected variable name after 'fix'")

    currentToken = nextToken()
    val body = parseExpr()
    Fix(param, body)

  private def parseFixBody(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception("Expected variable name after 'fix'")

    currentToken = nextToken()
    val body = parseLetValue()
    Fix(param, body)

  private def parseFun(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception(s"Expected parameter name, got: $currentToken")

    currentToken = nextToken()
    if currentToken != ARROW then
      throw new Exception(s"Expected '->', got: $currentToken")

    currentToken = nextToken()
    val body = parseExpr()
    Fun(param, body)

  private def parseFunBody(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception(s"Expected parameter name, got: $currentToken")

    currentToken = nextToken()
    if currentToken != ARROW then
      throw new Exception(s"Expected '->', got: $currentToken")

    currentToken = nextToken()
    val body = parseLetValue()
    Fun(param, body)

  private def parseIfzInfix(): Term =
    currentToken = nextToken()
    val cond = parseAddSub()

    if currentToken != THEN then
      throw new Exception(s"Expected 'then', got: $currentToken")

    currentToken = nextToken()
    val thenBranch = parseAddSub()

    if currentToken != ELSE then
      throw new Exception(s"Expected 'else', got: $currentToken")

    currentToken = nextToken()
    val elseBranch = parseAddSub()

    IfZero(cond, thenBranch, elseBranch)

  private def parseIfzBody(): Term =
    currentToken = nextToken()
    val cond = parseMulDiv()

    if currentToken != THEN then
      throw new Exception(s"Expected 'then', got: $currentToken")

    currentToken = nextToken()
    val thenBranch = parseAddSubForIfz()

    if currentToken != ELSE then
      throw new Exception(s"Expected 'else', got: $currentToken")

    currentToken = nextToken()
    val elseBranch = parseAddSubForIfz()

    IfZero(cond, thenBranch, elseBranch)

  private def parseAddSubForIfz(): Term =
    var left = parseMulDivForIfz()
    while currentToken == PLUS || currentToken == MINUS do
      val op = if currentToken == PLUS then Plus else Minus
      currentToken = nextToken()
      val right = parseMulDivForIfz()
      left = BinaryTerm(op, left, right)
    left

  private def parseMulDivForIfz(): Term =
    var left = parseAppForIfz()
    while currentToken == MULTIPLY || currentToken == DIVIDE do
      val op = if currentToken == MULTIPLY then Times else Div
      currentToken = nextToken()
      val right = parseAppForIfz()
      left = BinaryTerm(op, left, right)
    left

  private def parseAppForIfz(): Term =
    var left = parsePrimary()
    while currentToken match
      case NUMBER(_) | IDENT(_) | LPAR => true
      case PLUS | MINUS | MULTIPLY | DIVIDE | IN | THEN | ELSE | EOF => false
      case _ => false
    do
      val arg = parsePrimary()
      left = App(left, arg)
    left

  private def parseApp(): Term =
    var left = parseAddSub()
    while currentToken match
      case NUMBER(_) | IDENT(_) | LPAR => true
      case _ => false
    do
      val arg = parseAddSub()
      left = App(left, arg)
    left

  private def parseAddSub(): Term =
    var left = parseMulDiv()
    while currentToken == PLUS || currentToken == MINUS do
      val op = if currentToken == PLUS then Plus else Minus
      currentToken = nextToken()
      val right = parseMulDiv()
      left = BinaryTerm(op, left, right)
    left

  private def parseMulDiv(): Term =
    var left = parsePrimary()
    while currentToken == MULTIPLY || currentToken == DIVIDE do
      val op = if currentToken == MULTIPLY then Times else Div
      currentToken = nextToken()
      val right = parsePrimary()
      left = BinaryTerm(op, left, right)
    left

  private def parsePrimary(): Term =
    currentToken match
      case NUMBER(value) =>
        currentToken = nextToken()
        Number(value)

      case IDENT(name) =>
        currentToken = nextToken()
        Var(name)

      case LPAR =>
        currentToken = nextToken()
        parseParenthesized()

      case _ => throw new Exception(s"Unexpected token: $currentToken")

  private def parseParenthesized(): Term =
    val result = currentToken match
      case PLUS =>
        currentToken = nextToken()
        val exp1 = parseExpr()
        val exp2 = parseExpr()
        BinaryTerm(Plus, exp1, exp2)

      case MINUS =>
        currentToken = nextToken()
        val exp1 = parseExpr()
        val exp2 = parseExpr()
        BinaryTerm(Minus, exp1, exp2)

      case MULTIPLY =>
        currentToken = nextToken()
        val exp1 = parseExpr()
        val exp2 = parseExpr()
        BinaryTerm(Times, exp1, exp2)

      case DIVIDE =>
        currentToken = nextToken()
        val exp1 = parseExpr()
        val exp2 = parseExpr()
        BinaryTerm(Div, exp1, exp2)

      case IFZ =>
        currentToken = nextToken()
        val cond = parseExpr()
        val thenBranch = parseExpr()
        val elseBranch = parseExpr()
        IfZero(cond, thenBranch, elseBranch)

      case LET =>
        parseLetInfix()

      case _ =>
        parseExpr()

    if currentToken != RPAR then
      throw new Exception(s"Expected ), got: $currentToken")
    currentToken = nextToken()
    result

  private def parseLetInfix(): Term =
    currentToken = nextToken()
    val name = currentToken match
      case IDENT(id) => id
      case _ => throw new Exception(s"Expected identifier, got: $currentToken")

    currentToken = nextToken()
    if currentToken != EQUALS then
      throw new Exception(s"Expected '=', got: $currentToken")

    currentToken = nextToken()
    val value = parseLetValue()

    if currentToken != IN then
      throw new Exception(s"Expected 'in', got: $currentToken")

    currentToken = nextToken()
    val body = parseExpr()

    Let(name, value, body)

