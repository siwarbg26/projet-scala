package parserANTLRv2

import java.io.InputStream
import ast.Term
import parserANTLR.{ASTVisitor, ConcreteParser}

object AbstractParser :
  def analyze(in: InputStream): Term =
    val concreteTree = ConcreteParser.analyze(in)
    val visitor = new ASTVisitor
    visitor.visit(concreteTree).asInstanceOf[Term]
 
