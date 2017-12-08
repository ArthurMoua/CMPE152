// Generated from TLM.g4 by ANTLR 4.4

    import wci.intermediate.*;
    import wci.intermediate.symtabimpl.*;

import org.antlr.v4.runtime.misc.NotNull;
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
	 * Visit a parse tree produced by {@link TLMParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(@NotNull TLMParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerConst(@NotNull TLMParser.IntegerConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(@NotNull TLMParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(@NotNull TLMParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code drawObjExpr}
	 * labeled alternative in {@link TLMParser#drawStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawObjExpr(@NotNull TLMParser.DrawObjExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull TLMParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#varId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarId(@NotNull TLMParser.VarIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(@NotNull TLMParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#addSubOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOp(@NotNull TLMParser.AddSubOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExpr(@NotNull TLMParser.VariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INEQExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINEQExpr(@NotNull TLMParser.INEQExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#drawObj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawObj(@NotNull TLMParser.DrawObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#signedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNumber(@NotNull TLMParser.SignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#compoundStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStmt(@NotNull TLMParser.CompoundStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull TLMParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#assignmentStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(@NotNull TLMParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(@NotNull TLMParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(@NotNull TLMParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(@NotNull TLMParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatConst}
	 * labeled alternative in {@link TLMParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatConst(@NotNull TLMParser.FloatConstContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull TLMParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(@NotNull TLMParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#declList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclList(@NotNull TLMParser.DeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull TLMParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(@NotNull TLMParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#mainBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainBlock(@NotNull TLMParser.MainBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#typeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeId(@NotNull TLMParser.TypeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#mulDivOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivOp(@NotNull TLMParser.MulDivOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unsignedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumberExpr(@NotNull TLMParser.UnsignedNumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(@NotNull TLMParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull TLMParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signedNumberExpr}
	 * labeled alternative in {@link TLMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedNumberExpr(@NotNull TLMParser.SignedNumberExprContext ctx);
}