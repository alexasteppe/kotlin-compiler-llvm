lexer grammar KotlinLexer;

fragment Letter : [A-Za-z]+;
fragment IntDigit : [0-9]+;
fragment IntDigitNoZero : [1-9]+;
fragment EscID : '\\' ('t' | 'b' | 'r' | 'n' | '\'' | '"' | '\\' | '$')+;
fragment UnicodeID : [\p{Alpha}\p{General_Category=Other_Letter}] [\p{Alnum}\p{General_Category=Other_Letter}]* ;
fragment IDs : EscID | UnicodeID;


FUN: 'fun';
IF: 'if';
ELSE: 'else';
PRINT: 'print';
PRINTLN: 'println';
VAR: 'var';
INT: 'Int';
STRING: 'String';
RETURN: 'return';
READ: 'readLine';
WHILE: 'while';
ARRAY: 'Array';
ARRAYOF: 'arrayOf';


DOT: '.';
COMMA: ',';
LPAREN: '(';
RPAREN: ')';
LSQUARE: '[';
RSQUARE: ']';
LCURL: '{';
RCURL: '}';
MULT: '*';
DIV: '/';
ADD: '+';
SUB: '-';
INCR: '++';
DECR: '--';
COLON: ':';
SEMICOLON: ';';
ASSIGNMENT: '=';
LANGLE: '<';
RANGLE: '>';
LE: '<=';
GE: '>=';
EXCL_EQ: '!=';
EQEQ: '==';
SINGLE_QUOTE: '\'';

Identifier :
     (Letter | '_') (Letter | '_' | IntDigit IntDigitNoZero)* | '`' ~([\r\n] | '`')+ '`';

IntegerLiteral :
    ('-')? IntDigitNoZero (IntDigit | '_')* IntDigit | IntDigit;

CharacterLiteral :
    '\'' (IDs | ~[\n\r'\\]) '\'';

StringLiteral :
     ('"' .*? '"') | ('"' .*? '"');

DelimitedComment
    :  '/*' ( DelimitedComment | . )*? '*/'
      -> channel(HIDDEN)
    ;

LineComment
    : '//' ~[\r\n]*
      -> channel(HIDDEN)
    ;

WS : [ \t\r\n]+ -> skip ;

NL: '\n' | '\r' '\n'?;