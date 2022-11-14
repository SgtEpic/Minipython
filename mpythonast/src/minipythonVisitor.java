// Generated from java-escape by ANTLR 4.11.1
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
	 * Visit a parse tree produced by the {@code stmtsLabel}
	 * labeled alternative in {@link minipythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtsLabel(minipythonParser.StmtsLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcdefLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdefLabel(minipythonParser.FuncdefLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classdefLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdefLabel(minipythonParser.ClassdefLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmtLabel(minipythonParser.Assign_stmtLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmtLabel(minipythonParser.While_stmtLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code branch_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBranch_stmtLabel(minipythonParser.Branch_stmtLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLabel(minipythonParser.ExprLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmtLabel(minipythonParser.Return_stmtLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmt_blockLabel}
	 * labeled alternative in {@link minipythonParser#stmt_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_blockLabel(minipythonParser.Stmt_blockLabelContext ctx);
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
	 * Visit a parse tree produced by {@link minipythonParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(minipythonParser.Arg_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(minipythonParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_stmt(minipythonParser.Assign_stmtContext ctx);
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
	 * Visit a parse tree produced by the {@code comopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComopLabel(minipythonParser.ComopLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotopLabel(minipythonParser.NotopLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oroplabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOroplabel(minipythonParser.OroplabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomLabel(minipythonParser.AtomLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryplusminusopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryplusminusopLabel(minipythonParser.UnaryplusminusopLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code muldivopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuldivopLabel(minipythonParser.MuldivopLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusminusopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusminusopLabel(minipythonParser.PlusminusopLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndopLabel(minipythonParser.AndopLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulLabel}
	 * labeled alternative in {@link minipythonParser#muldivop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulLabel(minipythonParser.MulLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code divLabel}
	 * labeled alternative in {@link minipythonParser#muldivop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivLabel(minipythonParser.DivLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusLabel}
	 * labeled alternative in {@link minipythonParser#plusminusop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusLabel(minipythonParser.PlusLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusLabel}
	 * labeled alternative in {@link minipythonParser#plusminusop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusLabel(minipythonParser.MinusLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtLabel(minipythonParser.LtLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lteLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLteLabel(minipythonParser.LteLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gtLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtLabel(minipythonParser.GtLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gteLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGteLabel(minipythonParser.GteLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neqLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeqLabel(minipythonParser.NeqLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqLabel(minipythonParser.EqLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#notop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotop(minipythonParser.NotopContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#andop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndop(minipythonParser.AndopContext ctx);
	/**
	 * Visit a parse tree produced by {@link minipythonParser#orop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrop(minipythonParser.OropContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallLabel(minipythonParser.CallLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attrLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrLabel(minipythonParser.AttrLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLabel(minipythonParser.NumberLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nameLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameLabel(minipythonParser.NameLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLabel(minipythonParser.StringLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLabel(minipythonParser.BooleanLabelContext ctx);
}