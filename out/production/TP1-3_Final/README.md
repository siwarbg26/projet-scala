# Projet PCF.scala 

## Auteurs
- Siwar Ben Gharsallah 
- Skander Chayoukhi


## Description générale

Ce projet implémente un interpréteur pour le langage PCF (Programming Computable Functions), incluant :
- **Analyse lexicale** 
- **Analyse syntaxique** 
- **Évaluation** avec fermetures et récursion
- **Inférence de types** (système monomorphe)

## Remarques générales / choix divergents
- Respect global des consignes du TP.
- Ajustement de `PCF.scala` : seule modification significative du comportement interactif dans PCF.scala (lecture jusqu'à une ligne vide) pour faciliter les tests interactifs. Le reste suit l'énoncé.
    - Code ajouté :
```scala
// fichier: `src/PCF/PCF.scala` 
val in: InputStream =
if args.isEmpty then
// Lire jusqu'à une ligne vide
val lines = Iterator.continually(StdIn.readLine())
.takeWhile(line => line != null && line.trim.nonEmpty)
.mkString(" ")
ByteArrayInputStream(lines.getBytes())
else
FileInputStream(args(0))
   ``` 
- Parser : problème et correction
  - Symptôme détecté par tests (exemples problématiques) :
      - `let count = fix f fun n -> ifz n then 0 else f (n - 1) in count 2`
         
           - Erreur : fix non reconnu comme valeur valide d'un let
           - Cause : parseLetInfix() appelait parseExpr() pour la valeur, qui n'acceptait pas fix dans ce contexte
      - `let fact = fix f fun n -> ifz n then 1 else n * f (n - 1) in fact 3`
          - Erreur : Cannot apply Times to non-integers
          - Cause : Mauvaise priorité des opérateurs dans le corps du ifz → n * f (n - 1) parsé comme (n * f) (n - 1) au lieu de n * (f (n - 1))

      - `let multiply = fix m fun a -> fun b -> ifz a then 0 else b + m (a - 1) b in multiply 3 4`
          - Erreur : Application curryfiée m (a - 1) b mal parsée
          - Cause : parseApp() ne gérait pas correctement les applications successives (left-associative)

    - Corrections appliquées :
      #### 1.   Ajout de parseLetValue() — Parsing des valeurs de let (Accepte fix et fun comme valeurs d'un let, tout en évitant les récursions infinies.)
    ```scala
    // fichier: `src/parser/Parser.scala`
    private def parseLetValue(): Term =
           currentToken match
           case FUN => parseFunBody()  // ← Permet fun comme valeur
           case FIX => parseFixBody()  // ← Permet fix comme valeur
           case IFZ => parseIfzBody()
           case _ => parseMulDiv()
    ```
     #### 2. Ajout de parseFixBody() et parseFuxBody() — Parsing du corps de fix et fun
    ```scala
     
    private def parseFixBody(): Term =
      currentToken = nextToken()
      val param = currentToken match
        case IDENT(name) => name
        case _ => throw new Exception("Expected variable name after 'fix'")
    
      currentToken = nextToken()
      val body = parseLetValue() // ← Utilise parseLetValue au lieu de parseExpr
      Fix(param, body)
    ```
    ###  Meme changement pour parseFunBody()

     #### 3. Ajout de parseMulDivForIfz() et parseAppForIfz() — Hiérarchie correcte dans ifz
       - Problème : n * f (n - 1) parsé comme (n * f) (n - 1)
    ```scala
    
    private def parseMulDivForIfz(): Term =
      var left = parseAppForIfz()  // ← Parse les applications en premier
      while currentToken == MULTIPLY || currentToken == DIVIDE do
        val op = if currentToken == MULTIPLY then Times else Div
        currentToken = nextToken()
        val right = parseAppForIfz()
        left = BinaryTerm(op, left, right)
      left
    
    private def parseAppForIfz(): Term =
      var left = parsePrimary()  // ← Commence par parsePrimary
      while currentToken match
        case NUMBER(_) | IDENT(_) | LPAR => true
        case PLUS | MINUS | MULTIPLY | DIVIDE | IN | THEN | ELSE | EOF => false  // ← S'arrête aux opérateurs
        case _ => false
      do
        val arg = parsePrimary()
        left = App(left, arg)
      left
    
    ```
      - Résultat : n * f (n - 1) est maintenant parsé correctement comme BinaryTerm(Times, Var("n"), App(Var("f"), BinaryTerm(Minus, Var("n"), Number(1)))).
    <hr></hr>


## Ce qui fonctionne
- Analyse syntaxique et construction de l'AST (parser).
- Evaluator (interprète) pour tous les programmes PCF vert, bleu , rouge et noir.
- Tous les tests fournis dans l'énoncé des Tps ont été exécutés avec succès.
- Tests de typage simples fournis dans `src/typer/TyperSimpleTest.scala` .

## Réponse à la section 5 (Défi)
- Question : que se passe-t-il si on écrit une fonction `fun x -> x` et qu'on l'applique ensuite à des arguments de types différents ?
- Réponse  :
  - Si l'algorithme de typage est monomorphe (unification simple sans généralisation au `let`), la variable de type pour `x` est instanciée lors de la première utilisation et la fonction devient *monomorphisée* : une deuxième application sur un type différent provoquera une erreur de typage (conflit d'unification).

## Utilisation des outils d'IA générative
- ChatGPT : 
    - utilisé pour corriger la fonction `main` dans `PCF.scala` (lecture jusqu'à une ligne vide) .
    -  a aidé au diagnostic et à la résolution des problèmes observés dans les trois derniers tests « pcf noir » (erreurs du type "Cannot apply Times to non-integers", cas limites d'ifz/fix/applications).
    -  a aidé à structurer de tests simples pour valider le module de typage .


