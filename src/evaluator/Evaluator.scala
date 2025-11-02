package evaluator

import ast.Term
import ast.Term.*
import ast.Op.*

object Evaluator:
  def eval(t: Term, env: Map[String, Term] = Map()): Int =
    t match
      case Number(value) => value

      case BinaryTerm(op, exp1, exp2) =>
        val v1 = eval(exp1, env)
        val v2 = eval(exp2, env)
        op match
          case Plus => v1 + v2
          case Minus => v1 - v2
          case Times => v1 * v2
          case Div => v1 / v2

      case IfZero(cond, zBranch, nzBranch) =>
        if eval(cond, env) == 0 then
          eval(zBranch, env)
        else
          eval(nzBranch, env)

      case Var(name) =>
        env.get(name) match
          case Some(Number(value)) => value
          case Some(_) => throw new Exception(s"Variable $name is not a number")
          case None => throw new Exception(s"Undefined variable: $name")

      case Let(name, value, body) =>
        val evaluatedValue = eval(value, env)
        eval(body, env + (name -> Number(evaluatedValue)))

      case Fun(_, _) =>
        throw new Exception("Cannot evaluate a function to an integer")

      case App(func, arg) =>
        val argValue = Number(eval(arg, env))  // ← Évalue l'argument
        func match
          case Fun(param, body) =>
            eval(body, env + (param -> argValue))  // ← Substitue le paramètre
          case _ =>
            val funcValue = eval(func, env)
            throw new Exception(s"Cannot apply non-function: $funcValue")
