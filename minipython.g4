grammar minipython;

program: (stmt)* EOF                # stmtsLabel;

stmt: funcdef                       # funcdefLabel
    | classdef                      # classdefLabel
    | assign_stmt                   # assign_stmtLabel
    | while_stmt                    # while_stmtLabel
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

while_stmt: 'while' (expr | '(' expr ')' ) ':' stmt_block END;

branch_stmt: if_stmt elif_stmt* else_stmt? END;
if_stmt: 'if' (expr | '(' expr ')' ) ':' stmt_block;
elif_stmt: 'elif' (expr | '(' expr ')' ) ':' stmt_block; 
else_stmt: 'else' ':' stmt_block;

expr: atom                          # atomLabel
    | plusminusop expr              # unaryplusminusopLabel
    | expr muldivop expr            # muldivopLabel
    | expr plusminusop expr         # plusminusopLabel
    | expr comop expr               # comopLabel
    | notop expr                    # notopLabel
    | expr andop expr               # andopLabel
    | expr orop expr                # oroplabel
    ;

muldivop: '*'                       # mulLabel 
    | '/'                           # divLabel
    ;
plusminusop: '+'                    # plusLabel 
    |  '-'                          # minusLabel
    ;
comop: '<'                          # ltLabel
    | '<='                          # lteLabel
    | '>'                           # gtLabel
    | '>='                          # gteLabel 
    | '!='                          # neqLabel 
    | '=='                          # eqLabel
    ;
notop: 'not';
andop: 'and';
orop: 'or';


atom: NAME ('.' NAME)* '(' expr? (',' expr)* ')'        # callLabel
    | NAME ('.' NAME)+                                  # attrLabel
    | INTEGER                                           # numberLabel
    | NAME                                              # nameLabel
    | STRING                                            # stringLabel
    | BOOLEAN                                           # booleanLabel
    ;

/*lexer*/
WHITESPACE: [ \t\r\n]+ -> skip;
COMMENT: ('#' ~[e] ~[\r\n]* '\r'? '\n'| '#' . ~[n] ~[\r\n]* '\r'? '\n' |'#' . . ~[d] ~[\r\n]* '\r'? '\n' | '#' | '#end' ~[\r\n] ~[\r\n]* '\r'? '\n' ) -> skip;
END: '#end';
//COMMENT: '#' .*? -> skip;
BOOLEAN: 'True' | 'False';
NAME: [a-zA-Z_][a-zA-Z0-9_]*;
STRING: '"' ('\u0000'..'\u007F')*? '"' | '\'' ('\u0000'..'\u007F')*? '\'';
INTEGER: [1-9][0-9]* | '0'+;
    
