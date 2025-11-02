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

  // Parse une expression complète (peut contenir des opérations binaires infixes)
  private def parseExpr(): Term =
    val left = parsePrimary()
    parseBinaryRest(left)

  // Parse les opérations binaires infixes avec la bonne priorité
  private def parseBinaryRest(left: Term): Term =
    currentToken match
      case PLUS | MINUS | MULTIPLY | DIVIDE =>
        val op = currentToken match
          case PLUS => Plus
          case MINUS => Minus
          case MULTIPLY => Times
          case DIVIDE => Div
        currentToken = nextToken()
        val right = parsePrimary()
        val term = BinaryTerm(op, left, right)
        parseBinaryRest(term)
      case _ => left

  // Parse un terme primaire (nombre, variable, expression entre parenthèses, let)
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

      case LET =>
        parseLetInfix()

      case _ => throw new Exception(s"Unexpected token: $currentToken")

  // Parse une expression entre parenthèses (peut être préfixe ou infixe)
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

      // let préfixe : (let x 1 (+ x 1))
      case LET =>
        parseLetPrefix()

      // Expression infixe entre parenthèses : (1 + 2)
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

  // Parse un let en syntaxe préfixe : (let x 1 body)
  private def parseLetPrefix(): Term =
    currentToken = nextToken()
    val name = currentToken match
      case IDENT(id) => id
      case _ => throw new Exception(s"Expected identifier, got: $currentToken")

    currentToken = nextToken()
    val value = parseExpr()
    val body = parseExpr()

    Let(name, value, body)
