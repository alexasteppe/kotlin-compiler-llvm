parser grammar KotlinLexerParser;
options { tokenVocab = KotlinLexer; }

@header {
import symtab.*;
}


start returns [Scope scope]
    : functionDefinition* EOF;


block returns [Scope scope]
    : statement*
    ;

statement
    : re_assignment
     | print
     | ifStatement
     | while
     | functionDefinition
     | returnStatement
     | functionCall
     | variableDeclaration
     | arrayDeclaration
     | expr
     | comparison
     | READ LPAREN RPAREN
    ;

re_assignment returns [Scope scope]
    : Identifier ASSIGNMENT expr
    | Identifier LSQUARE IntegerLiteral RSQUARE ASSIGNMENT expr
    ;

print
    : (PRINT LPAREN expr (COMMA expr)* RPAREN)
    | PRINT LPAREN Identifier LSQUARE IntegerLiteral RSQUARE RPAREN
    ;

expr
    : expr oper=(MULT | DIV) expr
    | expr oper=(ADD | SUB) expr
    | IntegerLiteral
    | StringLiteral
    | Identifier
    | LPAREN expr RPAREN
    | READ LPAREN RPAREN
    | while
    | Identifier LSQUARE IntegerLiteral RSQUARE
    ;



ifStatement //done
    : IF LPAREN comparison RPAREN LCURL block RCURL (ELSE LCURL block RCURL)?
    ;

while: WHILE LPAREN comparison
       RPAREN
       LCURL
       block
       RCURL
       ;

comparison //done
    : expr GE expr
    | expr RANGLE expr
    | expr LE expr
    | expr LANGLE expr
    | expr EQEQ expr
    | expr EXCL_EQ expr
    ;

variableDeclaration
    : VAR Identifier COLON? type? ASSIGNMENT (expr | READ LPAREN RPAREN)
    ;

arrayDeclaration
    : VAR Identifier COLON ARRAY LANGLE type RANGLE ASSIGNMENT ARRAYOF LPAREN functionArgument RPAREN
    ;

type
    : INT | STRING
    ;

functionArgument
    : (Identifier? COLON? type?) | ((Identifier | expr COLON? type?) (COMMA (Identifier | expr COLON? type?))*)
    ;

functionDefinition returns [Scope scope]
    :
     FUN Identifier LPAREN functionArgument RPAREN COLON? type? LCURL block RCURL
    ;

functionCall
    :
    Identifier LPAREN functionArgument RPAREN
    ;

returnStatement
    :
    RETURN expr
    ;
