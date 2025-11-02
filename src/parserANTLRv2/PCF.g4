grammar PCF;

exp: '(' exp ')'                             # ParExp
   | NUMBER                                  # Number
   |  exp OP1 exp                            # BinaryExp1
   |  exp OP2 exp                            # BinaryExp2
   | 'ifz' exp 'then' exp 'else' exp          # IfZero
   ;

NUMBER: '0' | [1-9][0-9]* ;
OP2: '+' | '-' ;
OP1:  '*' | '/' ;
WS: ('\n' | '\r' | '\t' | ' ') -> skip;