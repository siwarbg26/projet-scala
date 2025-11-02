package PCF

import evaluator.Evaluator.eval
import evaluator.Evaluator.Value.*
import scala.io.StdIn
import java.io.{FileInputStream, InputStream, ByteArrayInputStream}
import lexer.Lexer
import parser.Parser

object PCF:
  def main(args: Array[String]): Unit =
    val in: InputStream =
      if args.isEmpty then
        // Lire jusqu'à une ligne vide
        val lines = Iterator.continually(StdIn.readLine())
          .takeWhile(line => line != null && line.trim.nonEmpty)
          .mkString(" ")
        ByteArrayInputStream(lines.getBytes())
      else
        FileInputStream(args(0))

    Lexer(in)
    val exp = Parser.parse(Lexer.nextToken())
    val token = Lexer.nextToken()
    if token != lexer.Token.EOF then
      throw new Exception(s"Unexpected token $token after parsing complete expression $exp")

    val result = eval(exp)
    result match
      case IntValue(n) => println(s"==> $n")
      case Closure(_, _, _) => println("==> <function>")
