grammar minipython;

program: statement* EOF;

statement: funcdef
    | classdef
    | while_stmt
    | branch_stmt
    | expression_stmt
    | return_stmt
    ;

block: statement*;
parameters: (NAME (COMMA NAME)*);

funcdef: DEF NAME L_PAREN parameters? R_PAREN COLON block END;

//methoddef: DEF NAME L_PAREN parameters R_PAREN COLON block END;
//methodblock: (methoddef | classdef | while_stmt | branch_stmt | expression_stmt)*;
classdef: CLASS NAME (( L_PAREN NAME R_PAREN ) | L_PAREN R_PAREN)? COLON funcdef* END;

return_stmt: RETURN expression_stmt?;
while_stmt: WHILE expression_stmt COLON block END;
branch_stmt: if_stmt elif_stmt* else_stmt? END;
if_stmt: IF expression_stmt COLON block;
elif_stmt: ELIF expression_stmt COLON block;
else_stmt: ELSE COLON block;

expression_stmt: expression;
expression: assignment;
assignment: (call DOT)? NAME ASSIGN assignment | logic_or;
logic_or: logic_and (OR logic_or )?;
logic_and: equality (AND logic_and )?;
equality: comparison ( ( EQ | NEQ ) equality )?;
comparison: term ( ( LT | GT | LTE | GTE ) comparison )?;
term: factor ( ( PLUS | MINUS ) term )?;
factor: unary( ( STAR | DIVIDE ) factor )?;
unary: ( NOT | PLUS | MINUS ) unary | call;
call: primary ( L_PAREN arguments? R_PAREN | DOT NAME)*;
primary: NAME | NUMBER | STRING | TRUE | FALSE | L_PAREN expression R_PAREN | SUPER DOT NAME;

arguments: expression (COMMA expression)*;


/*lexer*/
WHITESPACE: [ \t\r\n]+ -> skip;
COMMENT: ('#' ~[e] ~[\r\n]* '\r'? '\n'| '#' . ~[n] ~[\r\n]* '\r'? '\n' |'#' . . ~[d] ~[\r\n]* '\r'? '\n' | '#' | '#end' ~[\r\n] ~[\r\n]* '\r'? '\n' ) -> skip;
//COMMENT: '#' .*? -> skip;

ASSIGN: '=';
OR: 'or';
AND: 'and';
EQ: '==';
NEQ: '!=';
LT: '<';
GT: '>';
LTE: '<=';
GTE: '>=';
PLUS: '+';
MINUS: '-';
STAR: '*';
DIVIDE: '/';
NOT: 'not';
SUPER: 'super()';
DOT: '.';
COMMA: ',';
COLON: ':';
L_PAREN: '(';
R_PAREN: ')';

DEF: 'def';
CLASS: 'class';
WHILE: 'while';
IF: 'if';
ELIF: 'elif';
ELSE: 'else';
RETURN: 'return';

END: '#end';
TRUE: 'True';
FALSE: 'False';
NAME: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' ('\u0000'..'\u007F')*? '"' | '\'' ('\u0000'..'\u007F')*? '\'';
NUMBER: [1-9][0-9]* | '0'+;

