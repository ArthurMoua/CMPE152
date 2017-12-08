grammar TLM;  // A custom language with heavy influence from Pascal

@header {
    import wci.intermediate.*;
    import wci.intermediate.symtabimpl.*;
}

program   : header mainBlock '.' ;
header    : PROGRAM IDENTIFIER ';' ;
mainBlock : block;
block     : declarations compoundStmt ;

declarations : VAR declList ';' ;
declList     : decl ( ';' decl )* ;
decl         : varList ':' typeId ;
varList      : varId ( ',' varId )* ;
varId        : IDENTIFIER ;
typeId       : IDENTIFIER ;

compoundStmt : BEGIN stmtList END ;

stmt : compoundStmt
     | assignmentStmt
     | ifStmt
     | whileStmt
     | drawStmt
     ;
     
stmtList       : stmt ( ';' stmt )* ;
assignmentStmt : variable ':=' expr ;

variable : IDENTIFIER ;

drawStmt : drawObj '(' variable ',' variable ',' variable ',' variable ')'	# drawObjExpr ;

ifStmt : IF expr THEN stmt (ELSE stmt) ;

whileStmt : WHILE expr DO stmt ;

expr locals [ TypeSpec type = null ]
    : expr mulDivOp expr   # mulDivExpr
    | expr addSubOp expr   # addSubExpr
    | expr INEQ expr       # INEQExpr
    | number               # unsignedNumberExpr
    | signedNumber         # signedNumberExpr
    | variable             # variableExpr
    | '(' expr ')'         # parenExpr
    ;
     
mulDivOp : MUL_OP | DIV_OP ;
addSubOp : ADD_OP | SUB_OP ;
     
signedNumber locals [ TypeSpec type = null ] 
    : sign number 
    ;
sign : ADD_OP | SUB_OP ;

number locals [ TypeSpec type = null ]
    : INTEGER    # integerConst
    | FLOAT      # floatConst
    ;
    
drawObj : SHAPE ;

SHAPE : 'square'
	  | 'circle'
	  | 'line'
	  ;

WHILE: 'while';
DO   : 'do'   ;

INEQ: EQ_OP
	| NE_OP 
	| LT_OP
	| LE_EQ
	| GT_OP 
	| GE_EQ
	;

EQ_OP : '='  ;
NE_OP : '<>' ;
LT_OP : '<'  ;
GT_OP : '>'  ;
LE_EQ : '<=' ;
GE_EQ : '>=' ;

PROGRAM : 'PROGRAM' ;
VAR     : 'VAR' ;
BEGIN   : 'BEGIN' ;
END     : 'END' ;

IF  : 'if'  ;
THEN: 'then';
ELSE: 'else';

IDENTIFIER : [a-zA-Z][a-zA-Z0-9]* ;
INTEGER    : [0-9]+ ;
FLOAT      : [0-9]+ '.' [0-9]+ ;

MUL_OP :   '*' ;
DIV_OP :   '/' ;
ADD_OP :   '+' ;
SUB_OP :   '-' ;

NEWLINE : '\r'? '\n' -> skip  ;
WS      : [ \t]+ -> skip ; 