// Generated from KotlinLexerParser.g4 by ANTLR 4.10.1

import symtab.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link KotlinLexerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface KotlinLexerParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(KotlinLexerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(KotlinLexerParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(KotlinLexerParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#re_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRe_assignment(KotlinLexerParser.Re_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(KotlinLexerParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(KotlinLexerParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(KotlinLexerParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(KotlinLexerParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(KotlinLexerParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(KotlinLexerParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(KotlinLexerParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(KotlinLexerParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#functionArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgument(KotlinLexerParser.FunctionArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(KotlinLexerParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link KotlinLexerParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(KotlinLexerParser.ReturnStatementContext ctx);
}