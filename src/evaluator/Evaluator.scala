package evaluator

import ast.Term
import ast.Term.*
import ast.Op.*

object Evaluator:
  enum Value:
    case IntValue(value: Int)
    case Closure(param: String, body: Term, env: Env)

  import Value.*

  // Déplacer IceCube ici
  case class IceCube(x: String, t: Term, e: Env)

  type Env = Map[String, Value | IceCube]

  def eval(t: Term, env: Env = Map.empty): Value =
    t match
      case Number(n) => IntValue(n)

      case Var(x) =>
        env.get(x) match
          case Some(v: IntValue) => v
          case Some(c: Closure) => c
          case Some(ice: IceCube) =>
            eval(ice.t, ice.e + (ice.x -> ice))
          case None => throw new Exception(s"Variable non liée: $x")

      case BinaryTerm(op, e1, e2) =>
        val v1 = eval(e1, env)
        val v2 = eval(e2, env)
        (v1, v2) match
          case (IntValue(n1), IntValue(n2)) =>
            op match
              case Plus => IntValue(n1 + n2)
              case Minus => IntValue(n1 - n2)
              case Times => IntValue(n1 * n2)
              case Div =>
                if n2 == 0 then throw new Exception("Division par zéro")
                else IntValue(n1 / n2)
          case _ => throw new Exception("Opération sur non-entiers")

      case IfZero(cond, zBranch, nzBranch) =>
        eval(cond, env) match
          case IntValue(0) => eval(zBranch, env)
          case IntValue(_) => eval(nzBranch, env)
          case _ => throw new Exception("Condition ifz non entière")

      case Let(name, value, body) =>
        val v = eval(value, env)
        eval(body, env + (name -> v))

      case Fun(param, body) =>
        Closure(param, body, env)

      case App(func, arg) =>
        eval(func, env) match
          case Closure(param, body, closureEnv) =>
            val argVal = eval(arg, env)
            eval(body, closureEnv + (param -> argVal))
          case _ => throw new Exception("Application d'un non-closure")

      case Fix(name, body) =>
        eval(body, env + (name -> IceCube(name, body, env)))
