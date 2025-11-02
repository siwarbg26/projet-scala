//package parser
//
//import ast.Term
//import Term.*
//import ast.Op.*
//import lexer.Token
//import lexer.Token.*
//import lexer.Lexer.nextToken
//
//object Parser:
//  private var currentToken: Token = _
//
//  def parse(token: Token): Term =
//    currentToken = token
//    parseExpr()
//
//  // Parse une expression complète
//  private def parseExpr(): Term =
//    currentToken match
//      case LET => parseLetInfix()
//      case FUN => parseFun()
//      case FIX => parseFix()
//      case IFZ => parseIfzInfix()
//      case _ => parseApp()
//
//  // Nouvelle méthode : parse une valeur de let (s'arrête à 'in')
//
//  private def parseLetValue(): Term =
//    currentToken match
//      case FUN => parseFunBody()
//      case FIX => parseFixBody()
//      case IFZ => parseIfzForLet()
//      case _ => parseMulDiv()
//
//
//
//  private def parseFix(): Term =
//      currentToken = nextToken()
//      val param = currentToken match
//        case IDENT(name) => name
//        case _ => throw new Exception("Expected variable name after 'fix'")
//
//      currentToken = nextToken()
//      val body = parseExpr() // ← fix associatif à droite
//
//      Fix(param, body)
//
//  private def parseFixBody(): Term =
//    currentToken = nextToken()
//    val param = currentToken match
//      case IDENT(name) => name
//      case _ => throw new Exception("Expected variable name after 'fix'")
//
//    currentToken = nextToken()
//    val body = parseLetValue()
//
//    Fix(param, body)
//
//
//
//  // Parse une fonction anonyme : fun x -> x + 1
//  private def parseFun(): Term =
//    currentToken = nextToken()
//    val param = currentToken match
//      case IDENT(name) => name
//      case _ => throw new Exception(s"Expected parameter name, got: $currentToken")
//
//    currentToken = nextToken()
//    if currentToken != ARROW then
//      throw new Exception(s"Expected '->', got: $currentToken")
//
//    currentToken = nextToken()
//    val body = parseExpr() // ← fun associatif à droite
//
//    Fun(param, body)
//
//
//  private def parseFunBody(): Term =
//    currentToken = nextToken()
//    val param = currentToken match
//      case IDENT(name) => name
//      case _ => throw new Exception(s"Expected parameter name, got: $currentToken")
//
//    currentToken = nextToken()
//    if currentToken != ARROW then
//      throw new Exception(s"Expected '->', got: $currentToken")
//
//    currentToken = nextToken()
//    val body = parseLetValue() // ← S'arrête à 'in'
//
//    Fun(param, body)
//
//  // Parse application (priorité haute, associatif à gauche)
//  private def parseApp(): Term =
//    var left = parseAddSub()
//    while currentToken match
//      case NUMBER(_) | IDENT(_) | LPAR => true
//      case _ => false
//    do
//      val arg = parseAddSub()
//      left = App(left, arg)
//    left
//
//  // Parse un ifz en syntaxe infixe
//  private def parseIfzInfix(): Term =
//    currentToken = nextToken()
//    val cond = parseAddSub() // ← Changez parseExpr() en parseAddSub()
//
//    if currentToken != THEN then
//      throw new Exception(s"Expected 'then', got: $currentToken")
//
//    currentToken = nextToken()
//    val thenBranch = parseAddSub() // ← Changez parseExpr() en parseAddSub()
//
//    if currentToken != ELSE then
//      throw new Exception(s"Expected 'else', got: $currentToken")
//
//    currentToken = nextToken()
//    val elseBranch = parseAddSub() // ← Changez parseExpr() en parseAddSub()
//
//    IfZero(cond, thenBranch, elseBranch)
//  // Parse une expression complète (let a la priorité la plus basse)
//
//
//  // Version pour let (parse sans applications)
//  private def parseIfzForLet(): Term =
//    currentToken = nextToken()
//    val cond = parseMulDiv() // ← Change ici
//    if currentToken != THEN then
//      throw new Exception(s"Expected 'then', got: $currentToken")
//    currentToken = nextToken()
//    val thenBranch = parseMulDiv() // ← Change ici
//    if currentToken != ELSE then
//      throw new Exception(s"Expected 'else', got: $currentToken")
//    currentToken = nextToken()
//    val elseBranch = parseMulDiv() // ← Change ici
//    IfZero(cond, thenBranch, elseBranch)
//
//
//
//  // Parse addition et soustraction (priorité basse)
//  private def parseAddSub(): Term =
//    var left = parseMulDiv()
//    while currentToken == PLUS || currentToken == MINUS do
//      val op = if currentToken == PLUS then Plus else Minus
//      currentToken = nextToken()
//      val right = parseMulDiv()
//      left = BinaryTerm(op, left, right)
//    left
//
//  // Parse multiplication et division (priorité haute)
//  private def parseMulDiv(): Term =
//    var left = parsePrimary()
//    while currentToken == MULTIPLY || currentToken == DIVIDE do
//      val op = if currentToken == MULTIPLY then Times else Div
//      currentToken = nextToken()
//      val right = parsePrimary()
//      left = BinaryTerm(op, left, right)
//    left
//
//  // Parse un terme primaire (nombre, variable, expression entre parenthèses)
//  private def parsePrimary(): Term =
//    currentToken match
//      case NUMBER(value) =>
//        currentToken = nextToken()
//        Number(value)
//
//      case IDENT(name) =>
//        currentToken = nextToken()
//        Var(name)
//
//      case LPAR =>
//        currentToken = nextToken()
//        parseParenthesized()
//
//      case _ => throw new Exception(s"Unexpected token: $currentToken")
//
//  // Parse une expression entre parenthèses
//  private def parseParenthesized(): Term =
//    val result = currentToken match
//      // Opérations binaires préfixes : (+ 1 2)
//      case PLUS =>
//        currentToken = nextToken()
//        val exp1 = parseExpr()
//        val exp2 = parseExpr()
//        BinaryTerm(Plus, exp1, exp2)
//
//      case MINUS =>
//        currentToken = nextToken()
//        val exp1 = parseExpr()
//        val exp2 = parseExpr()
//        BinaryTerm(Minus, exp1, exp2)
//
//      case MULTIPLY =>
//        currentToken = nextToken()
//        val exp1 = parseExpr()
//        val exp2 = parseExpr()
//        BinaryTerm(Times, exp1, exp2)
//
//      case DIVIDE =>
//        currentToken = nextToken()
//        val exp1 = parseExpr()
//        val exp2 = parseExpr()
//        BinaryTerm(Div, exp1, exp2)
//
//      // ifz préfixe : (ifz cond then else)
//      case IFZ =>
//        currentToken = nextToken()
//        val cond = parseExpr()
//        val thenBranch = parseExpr()
//        val elseBranch = parseExpr()
//        IfZero(cond, thenBranch, elseBranch)
//
//      // let entre parenthèses : (let x = 1 in body)
//      case LET =>
//        parseLetInfix()
//
//      // Expression infixe entre parenthèses : (1 + 2) ou (x)
//      case _ =>
//        parseExpr()
//
//    // Consomme la parenthèse fermante
//    if currentToken != RPAR then
//      throw new Exception(s"Expected ), got: $currentToken")
//    currentToken = nextToken()
//    result
//
//  // Parse un let en syntaxe infixe : let x = 1 in x + 1
//  private def parseLetInfix(): Term =
//    currentToken = nextToken()
//    val name = currentToken match
//      case IDENT(id) => id
//      case _ => throw new Exception(s"Expected identifier, got: $currentToken")
//
//    currentToken = nextToken()
//    if currentToken != EQUALS then
//      throw new Exception(s"Expected '=', got: $currentToken")
//
//    currentToken = nextToken()
//    val value = parseLetValue()
//
//    if currentToken != IN then
//      throw new Exception(s"Expected 'in', got: $currentToken")
//
//    currentToken = nextToken()
//    val body = parseExpr()
//
//    Let(name, value, body)
//
//
//
//

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

  // ══════════════════════════════════════════════════════
  // Parse une expression complète
  // ══════════════════════════════════════════════════════
  private def parseExpr(): Term =
    currentToken match
      case LET => parseLetInfix()
      case FUN => parseFun()
      case FIX => parseFix()
      case IFZ => parseIfzInfix()
      case _ => parseApp()

  // ══════════════════════════════════════════════════════
  // Parse une valeur de let (s'arrête à 'in')
  // ══════════════════════════════════════════════════════
  private def parseLetValue(): Term =
    currentToken match
      case FUN => parseFunBody()
      case FIX => parseFixBody()
      case IFZ => parseIfzBody()  // ← Changement ici
      case _ => parseMulDiv()

  // ══════════════════════════════════════════════════════
  // Parse une expression sans let (pour branches de ifz)
  // ══════════════════════════════════════════════════════
//  private def parseNonLet(): Term =
//    currentToken match
//      case FUN => parseFun()
//      case FIX => parseFix()
//      case IFZ => parseIfzInfix()
//      case _ => parseApp()

  // ══════════════════════════════════════════════════════
  // Fix : Versions pour contextes différents
  // ══════════════════════════════════════════════════════
  private def parseFix(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception("Expected variable name after 'fix'")

    currentToken = nextToken()
    val body = parseExpr()
    Fix(param, body)

  private def parseFixBody(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception("Expected variable name after 'fix'")

    currentToken = nextToken()
    val body = parseLetValue()
    Fix(param, body)

  // ══════════════════════════════════════════════════════
  // Fun : Versions pour contextes différents
  // ══════════════════════════════════════════════════════
  private def parseFun(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception(s"Expected parameter name, got: $currentToken")

    currentToken = nextToken()
    if currentToken != ARROW then
      throw new Exception(s"Expected '->', got: $currentToken")

    currentToken = nextToken()
    val body = parseExpr()
    Fun(param, body)

  private def parseFunBody(): Term =
    currentToken = nextToken()
    val param = currentToken match
      case IDENT(name) => name
      case _ => throw new Exception(s"Expected parameter name, got: $currentToken")

    currentToken = nextToken()
    if currentToken != ARROW then
      throw new Exception(s"Expected '->', got: $currentToken")

    currentToken = nextToken()
    val body = parseLetValue()
    Fun(param, body)

  // ══════════════════════════════════════════════════════
  // Ifz : Versions pour contextes différents
  // ══════════════════════════════════════════════════════
  private def parseIfzInfix(): Term =
    currentToken = nextToken()
    val cond = parseAddSub()

    if currentToken != THEN then
      throw new Exception(s"Expected 'then', got: $currentToken")

    currentToken = nextToken()
    val thenBranch = parseAddSub()

    if currentToken != ELSE then
      throw new Exception(s"Expected 'else', got: $currentToken")

    currentToken = nextToken()
    val elseBranch = parseAddSub()

    IfZero(cond, thenBranch, elseBranch)

  private def parseIfzBody(): Term =
    currentToken = nextToken()
    val cond = parseMulDiv()

    if currentToken != THEN then
      throw new Exception(s"Expected 'then', got: $currentToken")

    currentToken = nextToken()
    val thenBranch = parseAddSubForIfz()

    if currentToken != ELSE then
      throw new Exception(s"Expected 'else', got: $currentToken")

    currentToken = nextToken()
    val elseBranch = parseAddSubForIfz()

    IfZero(cond, thenBranch, elseBranch)

  private def parseAddSubForIfz(): Term =
    var left = parseMulDivForIfz()
    while currentToken == PLUS || currentToken == MINUS do
      val op = if currentToken == PLUS then Plus else Minus
      currentToken = nextToken()
      val right = parseMulDivForIfz()
      left = BinaryTerm(op, left, right)
    left

  private def parseMulDivForIfz(): Term =
    var left = parseAppForIfz()
    while currentToken == MULTIPLY || currentToken == DIVIDE do
      val op = if currentToken == MULTIPLY then Times else Div
      currentToken = nextToken()
      val right = parseAppForIfz()
      left = BinaryTerm(op, left, right)
    left

  private def parseAppForIfz(): Term =
    var left = parsePrimary()
    while currentToken match
      case NUMBER(_) | IDENT(_) | LPAR => true
      case PLUS | MINUS | MULTIPLY | DIVIDE | IN | THEN | ELSE | EOF => false
      case _ => false
    do
      val arg = parsePrimary()
      left = App(left, arg)
    left


  // ══════════════════════════════════════════════════════
  // Application (priorité haute, associatif à gauche)
  // ══════════════════════════════════════════════════════
  private def parseApp(): Term =
    var left = parseAddSub()
    while currentToken match
      case NUMBER(_) | IDENT(_) | LPAR => true
      case _ => false
    do
      val arg = parseAddSub()
      left = App(left, arg)
    left

  // ══════════════════════════════════════════════════════
  // Opérations arithmétiques (+ et -)
  // ══════════════════════════════════════════════════════
  private def parseAddSub(): Term =
    var left = parseMulDiv()
    while currentToken == PLUS || currentToken == MINUS do
      val op = if currentToken == PLUS then Plus else Minus
      currentToken = nextToken()
      val right = parseMulDiv()
      left = BinaryTerm(op, left, right)
    left

  // ══════════════════════════════════════════════════════
  // Opérations arithmétiques (* et /)
  // ══════════════════════════════════════════════════════
  private def parseMulDiv(): Term =
    var left = parsePrimary()
    while currentToken == MULTIPLY || currentToken == DIVIDE do
      val op = if currentToken == MULTIPLY then Times else Div
      currentToken = nextToken()
      val right = parsePrimary()
      left = BinaryTerm(op, left, right)
    left

  // ══════════════════════════════════════════════════════
  // Termes primaires
  // ══════════════════════════════════════════════════════
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

  // ══════════════════════════════════════════════════════
  // Expressions entre parenthèses
  // ══════════════════════════════════════════════════════
  private def parseParenthesized(): Term =
    val result = currentToken match
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

      case IFZ =>
        currentToken = nextToken()
        val cond = parseExpr()
        val thenBranch = parseExpr()
        val elseBranch = parseExpr()
        IfZero(cond, thenBranch, elseBranch)

      case LET =>
        parseLetInfix()

      case _ =>
        parseExpr()

    if currentToken != RPAR then
      throw new Exception(s"Expected ), got: $currentToken")
    currentToken = nextToken()
    result

  // ══════════════════════════════════════════════════════
  // Let (notation infixe)
  // ══════════════════════════════════════════════════════
  private def parseLetInfix(): Term =
    currentToken = nextToken()
    val name = currentToken match
      case IDENT(id) => id
      case _ => throw new Exception(s"Expected identifier, got: $currentToken")

    currentToken = nextToken()
    if currentToken != EQUALS then
      throw new Exception(s"Expected '=', got: $currentToken")

    currentToken = nextToken()
    val value = parseLetValue()

    if currentToken != IN then
      throw new Exception(s"Expected 'in', got: $currentToken")

    currentToken = nextToken()
    val body = parseExpr()

    Let(name, value, body)

