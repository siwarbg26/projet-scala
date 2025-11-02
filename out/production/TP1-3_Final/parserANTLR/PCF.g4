grammar PCF;

term : letExp
     | addSub
     ;

letExp : LET ID EQUALS term IN term ;

ifzExp : IFZ term THEN term ELSE term ;

addSub : mulDiv ((PLUS | MINUS) mulDiv)* ;

mulDiv : primary ((TIMES | DIV) primary)* ;

primary : NUMBER
        | ID
        | ifzExp
        | LPAR term RPAR
        | LPAR IFZ term THEN term ELSE term RPAR
        | LPAR (PLUS | MINUS | TIMES | DIV) term term RPAR
        ;

// Tokens (mots-clés avant ID)
LET    : 'let' ;
IN     : 'in' ;
IFZ    : 'ifz' ;
THEN   : 'then' ;
ELSE   : 'else' ;
EQUALS : '=' ;
PLUS   : '+' ;
MINUS  : '-' ;
TIMES  : '*' ;
DIV    : '/' ;
LPAR   : '(' ;
RPAR   : ')' ;

NUMBER : [0-9]+ ;
ID     : [a-zA-Z][a-zA-Z0-9]* ;
WS     : [ \t\r\n]+ -> skip ;
