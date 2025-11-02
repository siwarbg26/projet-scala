package parserANTLR

import scala.jdk.CollectionConverters._
import ast.*
import ast.Term.*
import ast.Op.*

class ASTVisitor[AST] extends PCFBaseVisitor[AST] :

  override def visitTerm(ctx: PCFParser.TermContext): AST =
    if (ctx.NUMBER() != null) then
      Number(ctx.NUMBER().getText.toInt).asInstanceOf[AST]
    else if (ctx.ID() != null) then
      Var(ctx.ID().getText).asInstanceOf[AST]
    else
      visit(ctx.parExp())

  override def visitParExp(ctx: PCFParser.ParExpContext): AST =
    if (ctx.ifzExp() != null) then
      visit(ctx.ifzExp())
    else if (ctx.letExp() != null) then
      visit(ctx.letExp())
    else if (ctx.prefixBinary() != null) then
      visit(ctx.prefixBinary())
    else
      visit(ctx.parInfix())

  override def visitIfzExp(ctx: PCFParser.IfzExpContext): AST =
    val terms = ctx.term().asScala.toList
    val List(cond, thenBranch, elseBranch) =
      terms.map(t => visit(t).asInstanceOf[Term])
    IfZero(cond, thenBranch, elseBranch).asInstanceOf[AST]

  override def visitPrefixBinary(ctx: PCFParser.PrefixBinaryContext): AST =
    val op = ctx.getText.charAt(0) match
      case '+' => Plus
      case '-' => Minus
      case '*' => Times
      case '/' => Div
    val terms = ctx.term().asScala.toList
    val List(exp1, exp2) = terms.map(t => visit(t).asInstanceOf[Term])
    BinaryTerm(op, exp1, exp2).asInstanceOf[AST]
