// Generated from TLM.g4 by ANTLR 4.7

    import wci.intermediate.*;
    import wci.intermediate.symtabimpl.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TLMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TLMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TLMParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TLMParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(TLMParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#mainBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainBlock(TLMParser.MainBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(TLMParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(TLMParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#declList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclList(TLMParser.DeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(TLMParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(TLMParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#varId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarId(TLMParser.VarIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeId(TLMParser.TypeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#compoundStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmt(TLMParser.CompoundStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(TLMParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(TLMParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#assignmentStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(TLMParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(TLMParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code drawObjExpr}
	 * labeled alternative in {@link TLMParser#drawStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawObjExpr(TLMParser.DrawObjExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(TLMParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(TLMParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(TLMParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(TLMParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INEQExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINEQExpr(TLMParser.INEQExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unsignedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumberExpr(TLMParser.UnsignedNumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(TLMParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(TLMParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNumberExpr(TLMParser.SignedNumberExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#mulDivOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivOp(TLMParser.MulDivOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#addSubOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOp(TLMParser.AddSubOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#signedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNumber(TLMParser.SignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(TLMParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConst(TLMParser.IntegerConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatConst(TLMParser.FloatConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#drawObj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawObj(TLMParser.DrawObjContext ctx);
}