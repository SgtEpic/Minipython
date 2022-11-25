package antlr;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link minipythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface minipythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link minipythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(minipythonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(minipythonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(minipythonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(minipythonParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#funcdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdef(minipythonParser.FuncdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#classdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdef(minipythonParser.ClassdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(minipythonParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(minipythonParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#branch_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch_stmt(minipythonParser.Branch_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(minipythonParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#elif_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif_stmt(minipythonParser.Elif_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#else_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_stmt(minipythonParser.Else_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#expression_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_stmt(minipythonParser.Expression_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(minipythonParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(minipythonParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#logic_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_or(minipythonParser.Logic_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#logic_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_and(minipythonParser.Logic_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(minipythonParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(minipythonParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(minipythonParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(minipythonParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(minipythonParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(minipythonParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(minipythonParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(minipythonParser.ArgumentsContext ctx);
}