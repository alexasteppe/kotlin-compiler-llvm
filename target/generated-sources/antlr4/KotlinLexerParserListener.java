// Generated from KotlinLexerParser.g4 by ANTLR 4.10.1

import symtab.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KotlinLexerParser}.
 */
public interface KotlinLexerParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(KotlinLexerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(KotlinLexerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(KotlinLexerParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(KotlinLexerParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(KotlinLexerParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(KotlinLexerParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#re_assignment}.
	 * @param ctx the parse tree
	 */
	void enterRe_assignment(KotlinLexerParser.Re_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#re_assignment}.
	 * @param ctx the parse tree
	 */
	void exitRe_assignment(KotlinLexerParser.Re_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(KotlinLexerParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(KotlinLexerParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(KotlinLexerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(KotlinLexerParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(KotlinLexerParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(KotlinLexerParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(KotlinLexerParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(KotlinLexerParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(KotlinLexerParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(KotlinLexerParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(KotlinLexerParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(KotlinLexerParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(KotlinLexerParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(KotlinLexerParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(KotlinLexerParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(KotlinLexerParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgument(KotlinLexerParser.FunctionArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#functionArgument}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgument(KotlinLexerParser.FunctionArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(KotlinLexerParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(KotlinLexerParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(KotlinLexerParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link KotlinLexerParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(KotlinLexerParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link KotlinLexerParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(KotlinLexerParser.ReturnStatementContext ctx);
}