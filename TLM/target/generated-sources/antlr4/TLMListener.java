// Generated from TLM.g4 by ANTLR 4.4

    import wci.intermediate.*;
    import wci.intermediate.symtabimpl.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TLMParser}.
 */
public interface TLMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TLMParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull TLMParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull TLMParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerConst(@NotNull TLMParser.IntegerConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerConst(@NotNull TLMParser.IntegerConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(@NotNull TLMParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(@NotNull TLMParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(@NotNull TLMParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(@NotNull TLMParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code drawObjExpr}
	 * labeled alternative in {@link TLMParser#drawStmt}.
	 * @param ctx the parse tree
	 */
	void enterDrawObjExpr(@NotNull TLMParser.DrawObjExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code drawObjExpr}
	 * labeled alternative in {@link TLMParser#drawStmt}.
	 * @param ctx the parse tree
	 */
	void exitDrawObjExpr(@NotNull TLMParser.DrawObjExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull TLMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull TLMParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#varId}.
	 * @param ctx the parse tree
	 */
	void enterVarId(@NotNull TLMParser.VarIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#varId}.
	 * @param ctx the parse tree
	 */
	void exitVarId(@NotNull TLMParser.VarIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(@NotNull TLMParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(@NotNull TLMParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOp(@NotNull TLMParser.AddSubOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOp(@NotNull TLMParser.AddSubOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariableExpr(@NotNull TLMParser.VariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariableExpr(@NotNull TLMParser.VariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INEQExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterINEQExpr(@NotNull TLMParser.INEQExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INEQExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitINEQExpr(@NotNull TLMParser.INEQExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#drawObj}.
	 * @param ctx the parse tree
	 */
	void enterDrawObj(@NotNull TLMParser.DrawObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#drawObj}.
	 * @param ctx the parse tree
	 */
	void exitDrawObj(@NotNull TLMParser.DrawObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void enterSignedNumber(@NotNull TLMParser.SignedNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void exitSignedNumber(@NotNull TLMParser.SignedNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStmt(@NotNull TLMParser.CompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStmt(@NotNull TLMParser.CompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull TLMParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull TLMParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(@NotNull TLMParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(@NotNull TLMParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(@NotNull TLMParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(@NotNull TLMParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(@NotNull TLMParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(@NotNull TLMParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(@NotNull TLMParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(@NotNull TLMParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 */
	void enterFloatConst(@NotNull TLMParser.FloatConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 */
	void exitFloatConst(@NotNull TLMParser.FloatConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull TLMParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull TLMParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(@NotNull TLMParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(@NotNull TLMParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#declList}.
	 * @param ctx the parse tree
	 */
	void enterDeclList(@NotNull TLMParser.DeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#declList}.
	 * @param ctx the parse tree
	 */
	void exitDeclList(@NotNull TLMParser.DeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull TLMParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull TLMParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(@NotNull TLMParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(@NotNull TLMParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void enterMainBlock(@NotNull TLMParser.MainBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#mainBlock}.
	 * @param ctx the parse tree
	 */
	void exitMainBlock(@NotNull TLMParser.MainBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#typeId}.
	 * @param ctx the parse tree
	 */
	void enterTypeId(@NotNull TLMParser.TypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#typeId}.
	 * @param ctx the parse tree
	 */
	void exitTypeId(@NotNull TLMParser.TypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#mulDivOp}.
	 * @param ctx the parse tree
	 */
	void enterMulDivOp(@NotNull TLMParser.MulDivOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#mulDivOp}.
	 * @param ctx the parse tree
	 */
	void exitMulDivOp(@NotNull TLMParser.MulDivOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unsignedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedNumberExpr(@NotNull TLMParser.UnsignedNumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unsignedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedNumberExpr(@NotNull TLMParser.UnsignedNumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(@NotNull TLMParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(@NotNull TLMParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLMParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull TLMParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLMParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull TLMParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code signedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSignedNumberExpr(@NotNull TLMParser.SignedNumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code signedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSignedNumberExpr(@NotNull TLMParser.SignedNumberExprContext ctx);
}