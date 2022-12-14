// Generated from java-escape by ANTLR 4.11.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link minipythonParser}.
 */
public interface minipythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link minipythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(minipythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(minipythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void enterImport_statement(minipythonParser.Import_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#import_statement}.
	 * @param ctx the parse tree
	 */
	void exitImport_statement(minipythonParser.Import_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#file_import}.
	 * @param ctx the parse tree
	 */
	void enterFile_import(minipythonParser.File_importContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#file_import}.
	 * @param ctx the parse tree
	 */
	void exitFile_import(minipythonParser.File_importContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#member_import}.
	 * @param ctx the parse tree
	 */
	void enterMember_import(minipythonParser.Member_importContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#member_import}.
	 * @param ctx the parse tree
	 */
	void exitMember_import(minipythonParser.Member_importContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(minipythonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(minipythonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(minipythonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(minipythonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(minipythonParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(minipythonParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(minipythonParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(minipythonParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#classdef}.
	 * @param ctx the parse tree
	 */
	void enterClassdef(minipythonParser.ClassdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#classdef}.
	 * @param ctx the parse tree
	 */
	void exitClassdef(minipythonParser.ClassdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(minipythonParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(minipythonParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(minipythonParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(minipythonParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#branch_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBranch_stmt(minipythonParser.Branch_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#branch_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBranch_stmt(minipythonParser.Branch_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(minipythonParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(minipythonParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#elif_stmt}.
	 * @param ctx the parse tree
	 */
	void enterElif_stmt(minipythonParser.Elif_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#elif_stmt}.
	 * @param ctx the parse tree
	 */
	void exitElif_stmt(minipythonParser.Elif_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#else_stmt}.
	 * @param ctx the parse tree
	 */
	void enterElse_stmt(minipythonParser.Else_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#else_stmt}.
	 * @param ctx the parse tree
	 */
	void exitElse_stmt(minipythonParser.Else_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(minipythonParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(minipythonParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#expression_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpression_stmt(minipythonParser.Expression_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#expression_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpression_stmt(minipythonParser.Expression_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(minipythonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(minipythonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(minipythonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(minipythonParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(minipythonParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(minipythonParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#lambda_fn}.
	 * @param ctx the parse tree
	 */
	void enterLambda_fn(minipythonParser.Lambda_fnContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#lambda_fn}.
	 * @param ctx the parse tree
	 */
	void exitLambda_fn(minipythonParser.Lambda_fnContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#logic_or}.
	 * @param ctx the parse tree
	 */
	void enterLogic_or(minipythonParser.Logic_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#logic_or}.
	 * @param ctx the parse tree
	 */
	void exitLogic_or(minipythonParser.Logic_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#logic_and}.
	 * @param ctx the parse tree
	 */
	void enterLogic_and(minipythonParser.Logic_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#logic_and}.
	 * @param ctx the parse tree
	 */
	void exitLogic_and(minipythonParser.Logic_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(minipythonParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(minipythonParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(minipythonParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(minipythonParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(minipythonParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(minipythonParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(minipythonParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(minipythonParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(minipythonParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(minipythonParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PREFIX}
	 * labeled alternative in {@link minipythonParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void enterPREFIX(minipythonParser.PREFIXContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PREFIX}
	 * labeled alternative in {@link minipythonParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void exitPREFIX(minipythonParser.PREFIXContext ctx);
	/**
	 * Enter a parse tree produced by the {@code POSTFIX}
	 * labeled alternative in {@link minipythonParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void enterPOSTFIX(minipythonParser.POSTFIXContext ctx);
	/**
	 * Exit a parse tree produced by the {@code POSTFIX}
	 * labeled alternative in {@link minipythonParser#inc_dec}.
	 * @param ctx the parse tree
	 */
	void exitPOSTFIX(minipythonParser.POSTFIXContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(minipythonParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(minipythonParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(minipythonParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(minipythonParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(minipythonParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(minipythonParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#list_expression}.
	 * @param ctx the parse tree
	 */
	void enterList_expression(minipythonParser.List_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#list_expression}.
	 * @param ctx the parse tree
	 */
	void exitList_expression(minipythonParser.List_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(minipythonParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(minipythonParser.ArgumentsContext ctx);
}
