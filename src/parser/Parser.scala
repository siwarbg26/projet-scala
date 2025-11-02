package parser
import ast.Term
import Term.*
import ast.Op.*
import lexer.Token
import lexer.Token.*
import lexer.Lexer.nextToken

object Parser:
  private def expectRPAR(): Unit =
    val token = nextToken()
    if token != RPAR then
      throw new Exception(s"Expected ), got: $token")

  def parse(token: Token): Term =
    token match
      case NUMBER(value) => Number(value)
      case IDENT(name) => Var(name)  // Déplacé ici
      case LPAR => parseCompositeTerm(nextToken())
      case _ => throw new Exception(s"Unexpected token: $token")

  def parseCompositeTerm(token2: Token): Term =
    token2 match
      case PLUS =>
        val exp1 = parse(nextToken())
        val exp2 = parse(nextToken())
        expectRPAR()
        BinaryTerm(Plus, exp1, exp2)
      case MINUS =>
        val exp1 = parse(nextToken())
        val exp2 = parse(nextToken())
        expectRPAR()
        BinaryTerm(Minus, exp1, exp2)
      case MULTIPLY =>
        val exp1 = parse(nextToken())
        val exp2 = parse(nextToken())
        expectRPAR()
        BinaryTerm(Times, exp1, exp2)
      case DIVIDE =>
        val exp1 = parse(nextToken())
        val exp2 = parse(nextToken())
        expectRPAR()
        BinaryTerm(Div, exp1, exp2)
      case IFZ =>
        val exp1 = parse(nextToken())
        val exp2 = parse(nextToken())
        val exp3 = parse(nextToken())
        expectRPAR()
        IfZero(exp1, exp2, exp3)
      case LET =>
        nextToken() match
          case IDENT(name) =>
            val t1 = parse(nextToken())
            val t2 = parse(nextToken())
            expectRPAR()
            Let(name, t1, t2)
          case t => throw new Exception(s"Expected identifier, got: $t")
      case _ => throw new Exception(s"Unexpected token: $token2")
