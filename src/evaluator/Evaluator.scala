package evaluator

import ast.Term
import ast.Term.*
import ast.Op
import ast.Op.*
case class InterpretationException(message: String) extends Exception(message)
object Evaluator :
  type Env = Map[String, Int]
  def eval(exp: Term, e: Env = Map()): Int = exp match
    case Number(value) => value
    case Var(name) => e.getOrElse(name, throw InterpretationException(s"Variable non définie: $name"))
    case Let(name, t1, t2) =>
     val v1 = eval(t1, e)
     eval(t2, e + (name -> v1))
    case  IfZero(cond, zBranch, nzBranch) =>
      if eval(cond,e) == 0 then eval(zBranch,e) else eval(nzBranch,e)
    case BinaryTerm(op, exp1, exp2) =>
      val v1 = eval(exp1,e)
      val v2 = eval(exp2,e)
      op match
        case Plus  => v1 + v2
        case Minus => v1 - v2
        case Times => v1 * v2
        case Div   => v1 / v2

    

