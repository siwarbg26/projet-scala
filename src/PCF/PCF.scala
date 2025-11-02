package PCF

import evaluator.Evaluator.eval
import scala.io.StdIn
import java.io.{FileInputStream, InputStream, ByteArrayInputStream}
import lexer.Lexer
import parser.Parser

object PCF:
  def main(args: Array[String]): Unit =
    val in: InputStream =
      if args.isEmpty then
        val input = StdIn.readLine()
        ByteArrayInputStream(input.getBytes())
      else
        FileInputStream(args(0))

    Lexer(in)
    val exp = Parser.parse(Lexer.nextToken())
    val token = Lexer.nextToken()
    if token != lexer.Token.EOF then
      throw new Exception(s"Unexpected token $token after parsing complete expression $exp")
    println(s"==> ${eval(exp)}")
