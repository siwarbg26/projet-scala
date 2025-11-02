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

  // Parse une expression complète
  private def parseExpr(): Term =
    currentToken match
      case LET => parseLetInfix()
      case _ => parseFix()

  // Parse fix
  private def parseFix(): Term =
    currentToken match
      case FIX =>
        currentToken = nextToken()
        val name = currentToken match
          case IDENT(id) => id
          case _ => throw new Exception(s"Expected identifier after fix, got: $currentToken")
        currentToken = nextToken()
        val body = parseFix()  // Associativité à droite
        Fix(name, body)
      case _ => parseFun()

  // Parse une fonction anonyme
  private def parseFun(): Term =
    currentToken match
      case FUN =>
        currentToken = nextToken()
        val param = currentToken match
          case IDENT(id) => id
          case _ => throw new Exception(s"Expected parameter name, got: $currentToken")
        currentToken = nextToken()
        if currentToken != ARROW then
          throw new Exception(s"Expected '->', got: $currentToken")
        currentToken = nextToken()
        val body = parseFun()  // Associativité à droite
        Fun(param, body)
      case IFZ => parseIfzInfix()
      case _ => parseApp()

  // Parse application
  private def parseApp(): Term =
    var left = parseAddSub()
    while currentToken match
      case LPAR | IDENT(_) | NUMBER(_) => true
      case _ => false
    do
      val right = parseAddSub()
      left = App(left, right)
    left

  // Parse un ifz en syntaxe infixe
  private def parseIfzInfix(): Term =
    currentToken = nextToken()
    val cond = parseApp()  // ← CHANGEMENT : parseApp() au lieu de parseAddSub()

    if currentToken != THEN then
      throw new Exception(s"Expected 'then', got: $currentToken")

    currentToken = nextToken()
    val thenBranch = parseApp()  // ← CHANGEMENT : parseApp()

    if currentToken != ELSE then
      throw new Exception(s"Expected 'else', got: $currentToken")

    currentToken = nextToken()
    val elseBranch = parseApp()  // ← CHANGEMENT : parseApp()

    IfZero(cond, thenBranch, elseBranch)

  // Parse addition et soustraction
  private def parseAddSub(): Term =
    var left = parseMulDiv()
    while currentToken == PLUS || currentToken == MINUS do
      val op = if currentToken == PLUS then Plus else Minus
      currentToken = nextToken()
      val right = parseMulDiv()
      left = BinaryTerm(op, left, right)
    left

  // Parse multiplication et division
  private def parseMulDiv(): Term =
    var left = parsePrimary()
    while currentToken == MULTIPLY || currentToken == DIVIDE do
      val op = if currentToken == MULTIPLY then Times else Div
      currentToken = nextToken()
      val right = parsePrimary()
      left = BinaryTerm(op, left, right)
    left

  // Parse un terme primaire
  private def parsePrimary(): Term =
    currentToken match
      case NUMBER(n) =>
        currentToken = nextToken()
        Number(n)
      case IDENT(name) =>
        currentToken = nextToken()
        Var(name)
      case LPAR =>
        currentToken = nextToken()
        parseParenthesized()
      case _ =>
        throw new Exception(s"Unexpected token: $currentToken")

  // Parse une expression entre parenthèses
  private def parseParenthesized(): Term =
    val result = currentToken match
      case PLUS | MINUS | MULTIPLY | DIVIDE =>
        val op = currentToken match
          case PLUS => Plus
          case MINUS => Minus
          case MULTIPLY => Times
          case DIVIDE => Div
        currentToken = nextToken()
        val exp1 = parseExpr()
        val exp2 = parseExpr()
        BinaryTerm(op, exp1, exp2)
      case IFZ =>
        currentToken = nextToken()
        val cond = parseExpr()
        if currentToken != THEN then
          throw new Exception(s"Expected 'then', got: $currentToken")
        currentToken = nextToken()
        val thenBranch = parseExpr()
        if currentToken != ELSE then
          throw new Exception(s"Expected 'else', got: $currentToken")
        currentToken = nextToken()
        val elseBranch = parseExpr()
        IfZero(cond, thenBranch, elseBranch)
      case _ =>
        parseExpr()

    if currentToken != RPAR then
      throw new Exception(s"Expected ')', got: $currentToken")
    currentToken = nextToken()
    result

  // Parse un let en syntaxe infixe
  private def parseLetInfix(): Term =
    currentToken = nextToken()
    val name = currentToken match
      case IDENT(id) => id
      case _ => throw new Exception(s"Expected identifier, got: $currentToken")

    currentToken = nextToken()
    if currentToken != EQUALS then
      throw new Exception(s"Expected '=', got: $currentToken")

    currentToken = nextToken()
    val value = parseFix()  // Tout sauf let

    if currentToken != IN then
      throw new Exception(s"Expected 'in', got: $currentToken")

    currentToken = nextToken()
    val body = parseExpr()

    Let(name, value, body)
