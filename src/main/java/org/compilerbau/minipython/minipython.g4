grammar minipython;

program: (stmt)* EOF                # stmtsLabel;

stmt: funcdef                       # funcdefLabel
    | classdef                      # classdefLabel
    | assign_stmt                   # assign_stmtLabel
    | while_stmt                    # while_stmtLabel_1
    | branch_stmt                   # branch_stmtLabel
    | expr                          # exprLabel
    | return_stmt                   # return_stmtLabel
    ;
  

stmt_block: (stmt)*                 # stmt_blockLabel;

funcdef: 'def' NAME '(' arg_list ')' ':' stmt_block END; 
classdef: 'class' NAME ('(' NAME ')')? ':' stmt_block END;
arg_list: (NAME (',' NAME)*)?;

return_stmt: 'return' expr;
assign_stmt: NAME ('.' NAME)* '=' expr;

while_stmt: 'while' expr ':' stmt_block END             # while_stmtLabel
        | 'while' '(' expr ')' ':' stmt_block END       # while_stmt_bracketsLabel
        ;

branch_stmt: if_stmt elif_stmt* else_stmt? END;

if_stmt: 'if' expr ':' stmt_block                       # if_stmtLabel 
        | 'if' '(' expr ')' ':' stmt_block              # if_stmt_bracketsLabel
        ;
elif_stmt: 'elif'  expr ':' stmt_block                  # elif_stmtLabel 
        | 'elif' '(' expr ')' ':' stmt_block            # elif_stmt_bracketsLabel
        ;
else_stmt: 'else' ':' stmt_block;

expr: unaryop expr                  # unaryopLabel
    | expr multop expr              # multLabel
    | expr addop expr               # addLabel
    | expr compop expr               # comLabel
    | 'not' expr                    # notLabel
    | expr 'and' expr               # andLabel
    | expr 'or' expr                # orlabel
    | atom                          # atomLabel
    ;

unaryop: '+' | '-';
multop: '*' | '/';
addop: '+' | '-' ;
compop: '<' | '<=' | '>' | '>=' | '!=' | '==';
logicunaryop: 'not';

atom: NAME ('.' NAME)* '(' expr? (',' expr)* ')'        # callLabel
    | NAME ('.' NAME)+                                  # attrLabel
    | INTEGER                                           # numberLabel
    | NAME                                              # nameLabel
    | STRING                                            # stringLabel
    | BOOLEAN                                           # booleanLabel
    ;

/*lexer*/
UNARYOP: '+' | '-';
MULTOP: '*' | '/';
ADDOP: '+' | '-' ;
COMOP: '<' | '<=' | '>' | '>=' | '!=' | '==';
NOT: 'not';
LOGICANDOP: 'and';
LOGICOROP: 'or';
WHITESPACE: [ \t\r\n]+ -> skip;
COMMENT: ('#' ~[e] ~[\r\n]* '\r'? '\n'| '#' . ~[n] ~[\r\n]* '\r'? '\n' |'#' . . ~[d] ~[\r\n]* '\r'? '\n' | '#' | '#end' ~[\r\n] ~[\r\n]* '\r'? '\n' ) -> skip;
END: '#end';
//COMMENT: '#' .*? -> skip;
BOOLEAN: 'True' | 'False';
NAME: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' ('\u0000'..'\u007F')*? '"' | '\'' ('\u0000'..'\u007F')*? '\'';
INTEGER: [1-9][0-9]* | '0'+;
