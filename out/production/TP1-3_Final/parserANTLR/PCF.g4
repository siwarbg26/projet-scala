grammar PCF;

term
  : parExp
  | NUMBER
  | ID
  ;

parExp
  : '(' ( ifzExp
        | letExp
        | prefixBinary
        | parInfix
        ) ')'
  ;

ifzExp
  : 'ifz' term term term
  ;

letExp
  : 'let' ID '=' term 'in' term
  ;

prefixBinary
  : ('+' | '-' | '*' | '/') term term
  ;

parInfix
  : term (('+' | '-' | '*' | '/') term)+
  ;

// lexer
NUMBER : [0-9]+ ;
ID     : [a-zA-Z][a-zA-Z0-9_]* ;
WS     : [ \t\r\n]+ -> skip ;
