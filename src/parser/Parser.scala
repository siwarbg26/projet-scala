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
      case IFZ => parseIfzInfix()
      case _ => parseAddSub()

  // Parse un ifz en syntaxe infixe
  private def parseIfzInfix(): Term =
    currentToken = nextToken()
    val cond = parseAddSub() // ← Changez parseExpr() en parseAddSub()

    if currentToken != THEN then
      throw new Exception(s"Expected 'then', got: $currentToken")

    currentToken = nextToken()
    val thenBranch = parseAddSub() // ← Changez parseExpr() en parseAddSub()

    if currentToken != ELSE then
      throw new Exception(s"Expected 'else', got: $currentToken")

    currentToken = nextToken()
    val elseBranch = parseAddSub() // ← Changez parseExpr() en parseAddSub()

    IfZero(cond, thenBranch, elseBranch)
  // Parse une expression complète (let a la priorité la plus basse)
  

  // Parse addition et soustraction (priorité basse)
  private def parseAddSub(): Term =
    var left = parseMulDiv()
    while currentToken == PLUS || currentToken == MINUS do
      val op = if currentToken == PLUS then Plus else Minus
      currentToken = nextToken()
      val right = parseMulDiv()
      left = BinaryTerm(op, left, right)
    left

  // Parse multiplication et division (priorité haute)
  private def parseMulDiv(): Term =
    var left = parsePrimary()
    while currentToken == MULTIPLY || currentToken == DIVIDE do
      val op = if currentToken == MULTIPLY then Times else Div
      currentToken = nextToken()
      val right = parsePrimary()
      left = BinaryTerm(op, left, right)
    left

  // Parse un terme primaire (nombre, variable, expression entre parenthèses)
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

  // Parse une expression entre parenthèses
  private def parseParenthesized(): Term =
    val result = currentToken match
      // Opérations binaires préfixes : (+ 1 2)
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

      // ifz préfixe : (ifz cond then else)
      case IFZ =>
        currentToken = nextToken()
        val cond = parseExpr()
        val thenBranch = parseExpr()
        val elseBranch = parseExpr()
        IfZero(cond, thenBranch, elseBranch)

      // let entre parenthèses : (let x = 1 in body)
      case LET =>
        parseLetInfix()

      // Expression infixe entre parenthèses : (1 + 2) ou (x)
      case _ =>
        parseExpr()

    // Consomme la parenthèse fermante
    if currentToken != RPAR then
      throw new Exception(s"Expected ), got: $currentToken")
    currentToken = nextToken()
    result

  // Parse un let en syntaxe infixe : let x = 1 in x + 1
  private def parseLetInfix(): Term =
    currentToken = nextToken()
    val name = currentToken match
      case IDENT(id) => id
      case _ => throw new Exception(s"Expected identifier, got: $currentToken")

    currentToken = nextToken()
    if currentToken != EQUALS then
      throw new Exception(s"Expected '=', got: $currentToken")

    currentToken = nextToken()
    val value = parseExpr()

    if currentToken != IN then
      throw new Exception(s"Expected 'in', got: $currentToken")

    currentToken = nextToken()
    val body = parseExpr()

    Let(name, value, body)
