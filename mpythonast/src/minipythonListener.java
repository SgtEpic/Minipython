// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link minipythonParser}.
 */
public interface minipythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code stmtsLabel}
	 * labeled alternative in {@link minipythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterStmtsLabel(minipythonParser.StmtsLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtsLabel}
	 * labeled alternative in {@link minipythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitStmtsLabel(minipythonParser.StmtsLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcdefLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFuncdefLabel(minipythonParser.FuncdefLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcdefLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFuncdefLabel(minipythonParser.FuncdefLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classdefLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterClassdefLabel(minipythonParser.ClassdefLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classdefLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitClassdefLabel(minipythonParser.ClassdefLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmtLabel(minipythonParser.Assign_stmtLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmtLabel(minipythonParser.Assign_stmtLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmtLabel(minipythonParser.While_stmtLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmtLabel(minipythonParser.While_stmtLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code branch_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBranch_stmtLabel(minipythonParser.Branch_stmtLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code branch_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBranch_stmtLabel(minipythonParser.Branch_stmtLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprLabel(minipythonParser.ExprLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprLabel(minipythonParser.ExprLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmtLabel(minipythonParser.Return_stmtLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return_stmtLabel}
	 * labeled alternative in {@link minipythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmtLabel(minipythonParser.Return_stmtLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmt_blockLabel}
	 * labeled alternative in {@link minipythonParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void enterStmt_blockLabel(minipythonParser.Stmt_blockLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmt_blockLabel}
	 * labeled alternative in {@link minipythonParser#stmt_block}.
	 * @param ctx the parse tree
	 */
	void exitStmt_blockLabel(minipythonParser.Stmt_blockLabelContext ctx);
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
	 * Enter a parse tree produced by {@link minipythonParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(minipythonParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(minipythonParser.Arg_listContext ctx);
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
	 * Enter a parse tree produced by {@link minipythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(minipythonParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(minipythonParser.Assign_stmtContext ctx);
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
	 * Enter a parse tree produced by the {@code comopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComopLabel(minipythonParser.ComopLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComopLabel(minipythonParser.ComopLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotopLabel(minipythonParser.NotopLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotopLabel(minipythonParser.NotopLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oroplabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOroplabel(minipythonParser.OroplabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oroplabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOroplabel(minipythonParser.OroplabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomLabel(minipythonParser.AtomLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomLabel(minipythonParser.AtomLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryplusminusopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryplusminusopLabel(minipythonParser.UnaryplusminusopLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryplusminusopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryplusminusopLabel(minipythonParser.UnaryplusminusopLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code muldivopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMuldivopLabel(minipythonParser.MuldivopLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code muldivopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMuldivopLabel(minipythonParser.MuldivopLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusminusopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusminusopLabel(minipythonParser.PlusminusopLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusminusopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusminusopLabel(minipythonParser.PlusminusopLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndopLabel(minipythonParser.AndopLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andopLabel}
	 * labeled alternative in {@link minipythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndopLabel(minipythonParser.AndopLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulLabel}
	 * labeled alternative in {@link minipythonParser#muldivop}.
	 * @param ctx the parse tree
	 */
	void enterMulLabel(minipythonParser.MulLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulLabel}
	 * labeled alternative in {@link minipythonParser#muldivop}.
	 * @param ctx the parse tree
	 */
	void exitMulLabel(minipythonParser.MulLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divLabel}
	 * labeled alternative in {@link minipythonParser#muldivop}.
	 * @param ctx the parse tree
	 */
	void enterDivLabel(minipythonParser.DivLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divLabel}
	 * labeled alternative in {@link minipythonParser#muldivop}.
	 * @param ctx the parse tree
	 */
	void exitDivLabel(minipythonParser.DivLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusLabel}
	 * labeled alternative in {@link minipythonParser#plusminusop}.
	 * @param ctx the parse tree
	 */
	void enterPlusLabel(minipythonParser.PlusLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusLabel}
	 * labeled alternative in {@link minipythonParser#plusminusop}.
	 * @param ctx the parse tree
	 */
	void exitPlusLabel(minipythonParser.PlusLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusLabel}
	 * labeled alternative in {@link minipythonParser#plusminusop}.
	 * @param ctx the parse tree
	 */
	void enterMinusLabel(minipythonParser.MinusLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusLabel}
	 * labeled alternative in {@link minipythonParser#plusminusop}.
	 * @param ctx the parse tree
	 */
	void exitMinusLabel(minipythonParser.MinusLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void enterLtLabel(minipythonParser.LtLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void exitLtLabel(minipythonParser.LtLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lteLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void enterLteLabel(minipythonParser.LteLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lteLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void exitLteLabel(minipythonParser.LteLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void enterGtLabel(minipythonParser.GtLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void exitGtLabel(minipythonParser.GtLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gteLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void enterGteLabel(minipythonParser.GteLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gteLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void exitGteLabel(minipythonParser.GteLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neqLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void enterNeqLabel(minipythonParser.NeqLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neqLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void exitNeqLabel(minipythonParser.NeqLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void enterEqLabel(minipythonParser.EqLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqLabel}
	 * labeled alternative in {@link minipythonParser#comop}.
	 * @param ctx the parse tree
	 */
	void exitEqLabel(minipythonParser.EqLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#notop}.
	 * @param ctx the parse tree
	 */
	void enterNotop(minipythonParser.NotopContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#notop}.
	 * @param ctx the parse tree
	 */
	void exitNotop(minipythonParser.NotopContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#andop}.
	 * @param ctx the parse tree
	 */
	void enterAndop(minipythonParser.AndopContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#andop}.
	 * @param ctx the parse tree
	 */
	void exitAndop(minipythonParser.AndopContext ctx);
	/**
	 * Enter a parse tree produced by {@link minipythonParser#orop}.
	 * @param ctx the parse tree
	 */
	void enterOrop(minipythonParser.OropContext ctx);
	/**
	 * Exit a parse tree produced by {@link minipythonParser#orop}.
	 * @param ctx the parse tree
	 */
	void exitOrop(minipythonParser.OropContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterCallLabel(minipythonParser.CallLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitCallLabel(minipythonParser.CallLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attrLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAttrLabel(minipythonParser.AttrLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attrLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAttrLabel(minipythonParser.AttrLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberLabel(minipythonParser.NumberLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberLabel(minipythonParser.NumberLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nameLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNameLabel(minipythonParser.NameLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nameLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNameLabel(minipythonParser.NameLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringLabel(minipythonParser.StringLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringLabel(minipythonParser.StringLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLabel(minipythonParser.BooleanLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLabel}
	 * labeled alternative in {@link minipythonParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLabel(minipythonParser.BooleanLabelContext ctx);
}