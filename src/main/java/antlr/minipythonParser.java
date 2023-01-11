// Generated from java-escape by ANTLR 4.11.1
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class minipythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, COMMENT=2, ASSIGN=3, ASSIGNPLUS=4, ASSIGNMINUS=5, ASSIGNSTAR=6,
		ASSIGNDIVIDE=7, OR=8, AND=9, EQ=10, NEQ=11, LT=12, GT=13, LTE=14, GTE=15,
		PLUS=16, MINUS=17, STAR=18, DIVIDE=19, INCREMENT=20, DECREMENT=21, NOT=22,
		SUPER=23, DOT=24, COMMA=25, COLON=26, L_PAREN=27, R_PAREN=28, L_BRACKET=29,
		R_BRACKET=30, IMPORT=31, FROM=32, DEF=33, CLASS=34, WHILE=35, IF=36, ELIF=37,
		ELSE=38, RETURN=39, LAMBDA=40, END=41, TRUE=42, FALSE=43, NAME=44, STRING=45,
		NUMBER=46;
	public static final int
		RULE_program = 0, RULE_import_statement = 1, RULE_file_import = 2, RULE_member_import = 3,
		RULE_statement = 4, RULE_block = 5, RULE_parameters = 6, RULE_funcdef = 7,
		RULE_classdef = 8, RULE_return_stmt = 9, RULE_while_stmt = 10, RULE_branch_stmt = 11,
		RULE_if_stmt = 12, RULE_elif_stmt = 13, RULE_else_stmt = 14, RULE_name = 15,
		RULE_expression_stmt = 16, RULE_expression = 17, RULE_assignment = 18,
		RULE_lambda = 19, RULE_lambda_fn = 20, RULE_logic_or = 21, RULE_logic_and = 22,
		RULE_equality = 23, RULE_comparison = 24, RULE_term = 25, RULE_factor = 26,
		RULE_not = 27, RULE_inc_dec = 28, RULE_unary = 29, RULE_call = 30, RULE_primary = 31,
		RULE_list_expression = 32, RULE_arguments = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "import_statement", "file_import", "member_import", "statement",
			"block", "parameters", "funcdef", "classdef", "return_stmt", "while_stmt",
			"branch_stmt", "if_stmt", "elif_stmt", "else_stmt", "name", "expression_stmt",
			"expression", "assignment", "lambda", "lambda_fn", "logic_or", "logic_and",
			"equality", "comparison", "term", "factor", "not", "inc_dec", "unary",
			"call", "primary", "list_expression", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'='", "'+='", "'-='", "'*='", "'/='", "'or'", "'and'",
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'",
			"'++'", "'--'", "'not'", "'super'", "'.'", "','", "':'", "'('", "')'",
			"'['", "']'", "'import'", "'from'", "'def'", "'class'", "'while'", "'if'",
			"'elif'", "'else'", "'return'", "'lambda'", "'#end'", "'True'", "'False'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "COMMENT", "ASSIGN", "ASSIGNPLUS", "ASSIGNMINUS",
			"ASSIGNSTAR", "ASSIGNDIVIDE", "OR", "AND", "EQ", "NEQ", "LT", "GT", "LTE",
			"GTE", "PLUS", "MINUS", "STAR", "DIVIDE", "INCREMENT", "DECREMENT", "NOT",
			"SUPER", "DOT", "COMMA", "COLON", "L_PAREN", "R_PAREN", "L_BRACKET",
			"R_BRACKET", "IMPORT", "FROM", "DEF", "CLASS", "WHILE", "IF", "ELIF",
			"ELSE", "RETURN", "LAMBDA", "END", "TRUE", "FALSE", "NAME", "STRING",
			"NUMBER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public minipythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(minipythonParser.EOF, 0); }
		public List<Import_statementContext> import_statement() {
			return getRuleContexts(Import_statementContext.class);
		}
		public Import_statementContext import_statement(int i) {
			return getRuleContext(Import_statementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT || _la==FROM) {
				{
				{
				setState(68);
				import_statement();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 138118245580800L) != 0) {
				{
				{
				setState(74);
				statement();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Import_statementContext extends ParserRuleContext {
		public File_importContext file_import() {
			return getRuleContext(File_importContext.class,0);
		}
		public Member_importContext member_import() {
			return getRuleContext(Member_importContext.class,0);
		}
		public Import_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterImport_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitImport_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitImport_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_statementContext import_statement() throws RecognitionException {
		Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_import_statement);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				file_import();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				member_import();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_importContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(minipythonParser.IMPORT, 0); }
		public TerminalNode NAME() { return getToken(minipythonParser.NAME, 0); }
		public File_importContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_import; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterFile_import(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitFile_import(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitFile_import(this);
			else return visitor.visitChildren(this);
		}
	}

	public final File_importContext file_import() throws RecognitionException {
		File_importContext _localctx = new File_importContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_file_import);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(IMPORT);
			setState(87);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Member_importContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(minipythonParser.FROM, 0); }
		public List<TerminalNode> NAME() { return getTokens(minipythonParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(minipythonParser.NAME, i);
		}
		public TerminalNode IMPORT() { return getToken(minipythonParser.IMPORT, 0); }
		public Member_importContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_import; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterMember_import(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitMember_import(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitMember_import(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_importContext member_import() throws RecognitionException {
		Member_importContext _localctx = new Member_importContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_member_import);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(FROM);
			setState(90);
			match(NAME);
			setState(91);
			match(IMPORT);
			setState(92);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public FuncdefContext funcdef() {
			return getRuleContext(FuncdefContext.class,0);
		}
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Branch_stmtContext branch_stmt() {
			return getRuleContext(Branch_stmtContext.class,0);
		}
		public Expression_stmtContext expression_stmt() {
			return getRuleContext(Expression_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				funcdef();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				classdef();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				while_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				branch_stmt();
				}
				break;
			case PLUS:
			case MINUS:
			case STAR:
			case INCREMENT:
			case DECREMENT:
			case NOT:
			case SUPER:
			case L_PAREN:
			case L_BRACKET:
			case LAMBDA:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING:
			case NUMBER:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				expression_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 138118245580800L) != 0) {
				{
				{
				setState(102);
				statement();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(minipythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(minipythonParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(108);
			name();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(109);
				match(COMMA);
				setState(110);
				name();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncdefContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(minipythonParser.DEF, 0); }
		public TerminalNode NAME() { return getToken(minipythonParser.NAME, 0); }
		public TerminalNode L_PAREN() { return getToken(minipythonParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(minipythonParser.R_PAREN, 0); }
		public TerminalNode COLON() { return getToken(minipythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(minipythonParser.END, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FuncdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterFuncdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitFuncdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitFuncdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncdefContext funcdef() throws RecognitionException {
		FuncdefContext _localctx = new FuncdefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(DEF);
			setState(117);
			match(NAME);
			setState(118);
			match(L_PAREN);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR || _la==NAME) {
				{
				setState(119);
				parameters();
				}
			}

			setState(122);
			match(R_PAREN);
			setState(123);
			match(COLON);
			setState(124);
			block();
			setState(125);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassdefContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(minipythonParser.CLASS, 0); }
		public List<TerminalNode> NAME() { return getTokens(minipythonParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(minipythonParser.NAME, i);
		}
		public TerminalNode COLON() { return getToken(minipythonParser.COLON, 0); }
		public TerminalNode END() { return getToken(minipythonParser.END, 0); }
		public TerminalNode L_PAREN() { return getToken(minipythonParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(minipythonParser.R_PAREN, 0); }
		public List<FuncdefContext> funcdef() {
			return getRuleContexts(FuncdefContext.class);
		}
		public FuncdefContext funcdef(int i) {
			return getRuleContext(FuncdefContext.class,i);
		}
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterClassdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitClassdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitClassdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(CLASS);
			setState(128);
			match(NAME);
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				{
				setState(129);
				match(L_PAREN);
				setState(130);
				match(NAME);
				setState(131);
				match(R_PAREN);
				}
				}
				break;
			case 2:
				{
				setState(132);
				match(L_PAREN);
				setState(133);
				match(R_PAREN);
				}
				break;
			}
			setState(136);
			match(COLON);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(137);
				funcdef();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(minipythonParser.RETURN, 0); }
		public Expression_stmtContext expression_stmt() {
			return getRuleContext(Expression_stmtContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(RETURN);
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(146);
				expression_stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(minipythonParser.WHILE, 0); }
		public Expression_stmtContext expression_stmt() {
			return getRuleContext(Expression_stmtContext.class,0);
		}
		public TerminalNode COLON() { return getToken(minipythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode END() { return getToken(minipythonParser.END, 0); }
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(WHILE);
			setState(150);
			expression_stmt();
			setState(151);
			match(COLON);
			setState(152);
			block();
			setState(153);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Branch_stmtContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public TerminalNode END() { return getToken(minipythonParser.END, 0); }
		public List<Elif_stmtContext> elif_stmt() {
			return getRuleContexts(Elif_stmtContext.class);
		}
		public Elif_stmtContext elif_stmt(int i) {
			return getRuleContext(Elif_stmtContext.class,i);
		}
		public Else_stmtContext else_stmt() {
			return getRuleContext(Else_stmtContext.class,0);
		}
		public Branch_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterBranch_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitBranch_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitBranch_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Branch_stmtContext branch_stmt() throws RecognitionException {
		Branch_stmtContext _localctx = new Branch_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_branch_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			if_stmt();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(156);
				elif_stmt();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(162);
				else_stmt();
				}
			}

			setState(165);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(minipythonParser.IF, 0); }
		public Expression_stmtContext expression_stmt() {
			return getRuleContext(Expression_stmtContext.class,0);
		}
		public TerminalNode COLON() { return getToken(minipythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(IF);
			setState(168);
			expression_stmt();
			setState(169);
			match(COLON);
			setState(170);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Elif_stmtContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(minipythonParser.ELIF, 0); }
		public Expression_stmtContext expression_stmt() {
			return getRuleContext(Expression_stmtContext.class,0);
		}
		public TerminalNode COLON() { return getToken(minipythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elif_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterElif_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitElif_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitElif_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Elif_stmtContext elif_stmt() throws RecognitionException {
		Elif_stmtContext _localctx = new Elif_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elif_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(ELIF);
			setState(173);
			expression_stmt();
			setState(174);
			match(COLON);
			setState(175);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_stmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(minipythonParser.ELSE, 0); }
		public TerminalNode COLON() { return getToken(minipythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterElse_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitElse_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitElse_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_stmtContext else_stmt() throws RecognitionException {
		Else_stmtContext _localctx = new Else_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_else_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ELSE);
			setState(178);
			match(COLON);
			setState(179);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(minipythonParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(minipythonParser.NAME, i);
		}
		public TerminalNode STAR() { return getToken(minipythonParser.STAR, 0); }
		public TerminalNode L_BRACKET() { return getToken(minipythonParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(minipythonParser.R_BRACKET, 0); }
		public TerminalNode NUMBER() { return getToken(minipythonParser.NUMBER, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(181);
				match(STAR);
				}
			}

			setState(184);
			match(NAME);
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(185);
				match(L_BRACKET);
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(187);
				match(R_BRACKET);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_stmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterExpression_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitExpression_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitExpression_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_stmtContext expression_stmt() throws RecognitionException {
		Expression_stmtContext _localctx = new Expression_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(minipythonParser.ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode DOT() { return getToken(minipythonParser.DOT, 0); }
		public TerminalNode NAME() { return getToken(minipythonParser.NAME, 0); }
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public TerminalNode ASSIGNPLUS() { return getToken(minipythonParser.ASSIGNPLUS, 0); }
		public TerminalNode ASSIGNMINUS() { return getToken(minipythonParser.ASSIGNMINUS, 0); }
		public TerminalNode ASSIGNSTAR() { return getToken(minipythonParser.ASSIGNSTAR, 0); }
		public TerminalNode ASSIGNDIVIDE() { return getToken(minipythonParser.ASSIGNDIVIDE, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignment);
		int _la;
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(194);
					call();
					setState(195);
					match(DOT);
					}
					break;
				}
				setState(199);
				name();
				setState(200);
				match(ASSIGN);
				setState(201);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(203);
					call();
					setState(204);
					match(DOT);
					}
					break;
				}
				setState(208);
				match(NAME);
				setState(209);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
				lambda();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				lambda();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaContext extends ParserRuleContext {
		public List<Logic_orContext> logic_or() {
			return getRuleContexts(Logic_orContext.class);
		}
		public Logic_orContext logic_or(int i) {
			return getRuleContext(Logic_orContext.class,i);
		}
		public TerminalNode IF() { return getToken(minipythonParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(minipythonParser.ELSE, 0); }
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public Lambda_fnContext lambda_fn() {
			return getRuleContext(Lambda_fnContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_lambda);
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case STAR:
			case INCREMENT:
			case DECREMENT:
			case NOT:
			case SUPER:
			case L_PAREN:
			case L_BRACKET:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				logic_or();
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(215);
					match(IF);
					setState(216);
					logic_or();
					setState(217);
					match(ELSE);
					setState(218);
					lambda();
					}
					break;
				}
				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				lambda_fn();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lambda_fnContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(minipythonParser.LAMBDA, 0); }
		public TerminalNode COLON() { return getToken(minipythonParser.COLON, 0); }
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Lambda_fnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_fn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterLambda_fn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitLambda_fn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitLambda_fn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_fnContext lambda_fn() throws RecognitionException {
		Lambda_fnContext _localctx = new Lambda_fnContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_lambda_fn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(LAMBDA);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR || _la==NAME) {
				{
				setState(226);
				parameters();
				}
			}

			setState(229);
			match(COLON);
			setState(230);
			lambda();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_orContext extends ParserRuleContext {
		public Logic_andContext logic_and() {
			return getRuleContext(Logic_andContext.class,0);
		}
		public TerminalNode OR() { return getToken(minipythonParser.OR, 0); }
		public Logic_orContext logic_or() {
			return getRuleContext(Logic_orContext.class,0);
		}
		public Logic_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterLogic_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitLogic_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitLogic_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_orContext logic_or() throws RecognitionException {
		Logic_orContext _localctx = new Logic_orContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_logic_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			logic_and();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(233);
				match(OR);
				setState(234);
				logic_or();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_andContext extends ParserRuleContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public TerminalNode AND() { return getToken(minipythonParser.AND, 0); }
		public Logic_andContext logic_and() {
			return getRuleContext(Logic_andContext.class,0);
		}
		public Logic_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterLogic_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitLogic_and(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitLogic_and(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_andContext logic_and() throws RecognitionException {
		Logic_andContext _localctx = new Logic_andContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_logic_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			equality();
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(238);
				match(AND);
				setState(239);
				logic_and();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public TerminalNode EQ() { return getToken(minipythonParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(minipythonParser.NEQ, 0); }
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			comparison();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ || _la==NEQ) {
				{
				setState(243);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(244);
				equality();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode LT() { return getToken(minipythonParser.LT, 0); }
		public TerminalNode GT() { return getToken(minipythonParser.GT, 0); }
		public TerminalNode LTE() { return getToken(minipythonParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(minipythonParser.GTE, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			term();
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0) {
				{
				setState(248);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(249);
				comparison();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(minipythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(minipythonParser.MINUS, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			factor();
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(253);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(254);
				term();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode STAR() { return getToken(minipythonParser.STAR, 0); }
		public TerminalNode DIVIDE() { return getToken(minipythonParser.DIVIDE, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			not();
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(258);
				_la = _input.LA(1);
				if ( !(_la==STAR || _la==DIVIDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(259);
				factor();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(minipythonParser.NOT, 0); }
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public Inc_decContext inc_dec() {
			return getRuleContext(Inc_decContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_not);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				match(NOT);
				setState(263);
				not();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				inc_dec();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				unary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Inc_decContext extends ParserRuleContext {
		public Inc_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inc_dec; }

		public Inc_decContext() { }
		public void copyFrom(Inc_decContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PREFIXContext extends Inc_decContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(minipythonParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(minipythonParser.DECREMENT, 0); }
		public PREFIXContext(Inc_decContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterPREFIX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitPREFIX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitPREFIX(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class POSTFIXContext extends Inc_decContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(minipythonParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(minipythonParser.DECREMENT, 0); }
		public POSTFIXContext(Inc_decContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterPOSTFIX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitPOSTFIX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitPOSTFIX(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inc_decContext inc_dec() throws RecognitionException {
		Inc_decContext _localctx = new Inc_decContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_inc_dec);
		int _la;
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCREMENT:
			case DECREMENT:
				_localctx = new PREFIXContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				_la = _input.LA(1);
				if ( !(_la==INCREMENT || _la==DECREMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(269);
				call();
				}
				break;
			case STAR:
			case SUPER:
			case L_PAREN:
			case L_BRACKET:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING:
			case NUMBER:
				_localctx = new POSTFIXContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				call();
				setState(271);
				_la = _input.LA(1);
				if ( !(_la==INCREMENT || _la==DECREMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(minipythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(minipythonParser.MINUS, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(275);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(278);
			call();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<TerminalNode> L_PAREN() { return getTokens(minipythonParser.L_PAREN); }
		public TerminalNode L_PAREN(int i) {
			return getToken(minipythonParser.L_PAREN, i);
		}
		public List<TerminalNode> R_PAREN() { return getTokens(minipythonParser.R_PAREN); }
		public TerminalNode R_PAREN(int i) {
			return getToken(minipythonParser.R_PAREN, i);
		}
		public List<TerminalNode> DOT() { return getTokens(minipythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(minipythonParser.DOT, i);
		}
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_call);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			primary();
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(288);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case L_PAREN:
						{
						setState(281);
						match(L_PAREN);
						setState(283);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 137439640748032L) != 0) {
							{
							setState(282);
							arguments();
							}
						}

						setState(285);
						match(R_PAREN);
						}
						break;
					case DOT:
						{
						setState(286);
						match(DOT);
						setState(287);
						name();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public List_expressionContext list_expression() {
			return getRuleContext(List_expressionContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(minipythonParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(minipythonParser.STRING, 0); }
		public TerminalNode TRUE() { return getToken(minipythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(minipythonParser.FALSE, 0); }
		public TerminalNode L_PAREN() { return getToken(minipythonParser.L_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(minipythonParser.R_PAREN, 0); }
		public TerminalNode SUPER() { return getToken(minipythonParser.SUPER, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primary);
		int _la;
		try {
			setState(309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				list_expression();
				}
				break;
			case STAR:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				name();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(296);
				match(STRING);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(297);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(298);
				match(FALSE);
				}
				break;
			case L_PAREN:
				enterOuterAlt(_localctx, 7);
				{
				setState(299);
				match(L_PAREN);
				setState(300);
				expression();
				setState(301);
				match(R_PAREN);
				}
				break;
			case SUPER:
				enterOuterAlt(_localctx, 8);
				{
				setState(303);
				match(SUPER);
				setState(304);
				match(L_PAREN);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 137439640748032L) != 0) {
					{
					setState(305);
					arguments();
					}
				}

				setState(308);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_expressionContext extends ParserRuleContext {
		public TerminalNode L_BRACKET() { return getToken(minipythonParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(minipythonParser.R_BRACKET, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterList_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitList_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitList_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_expressionContext list_expression() throws RecognitionException {
		List_expressionContext _localctx = new List_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_list_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(L_BRACKET);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 137439640748032L) != 0) {
				{
				setState(312);
				arguments();
				}
			}

			setState(315);
			match(R_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(minipythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(minipythonParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof minipythonListener ) ((minipythonListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof minipythonVisitor ) return ((minipythonVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			expression();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(318);
				match(COMMA);
				setState(319);
				expression();
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u0146\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0005"+
		"\u0000F\b\u0000\n\u0000\f\u0000I\t\u0000\u0001\u0000\u0005\u0000L\b\u0000"+
		"\n\u0000\f\u0000O\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0003\u0001U\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004e\b\u0004"+
		"\u0001\u0005\u0005\u0005h\b\u0005\n\u0005\f\u0005k\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006p\b\u0006\n\u0006\f\u0006s\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007y\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0087\b\b\u0001\b\u0001"+
		"\b\u0005\b\u008b\b\b\n\b\f\b\u008e\t\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0003\t\u0094\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u009e\b\u000b\n\u000b\f\u000b\u00a1\t\u000b"+
		"\u0001\u000b\u0003\u000b\u00a4\b\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0003\u000f"+
		"\u00b7\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00bd\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00c6\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00cf\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00d5\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00dd\b\u0013\u0001\u0013\u0003\u0013\u00e0\b"+
		"\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u00e4\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00ec"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00f1\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00f6\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u00fb\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0100\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u0105\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u010b\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u0112\b\u001c\u0001\u001d\u0003\u001d\u0115\b"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u011c\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u0121"+
		"\b\u001e\n\u001e\f\u001e\u0124\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0133\b\u001f"+
		"\u0001\u001f\u0003\u001f\u0136\b\u001f\u0001 \u0001 \u0003 \u013a\b \u0001"+
		" \u0001 \u0001!\u0001!\u0001!\u0005!\u0141\b!\n!\f!\u0144\t!\u0001!\u0000"+
		"\u0000\"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@B\u0000\u0007\u0002\u0000,,..\u0001"+
		"\u0000\u0004\u0007\u0001\u0000\n\u000b\u0001\u0000\f\u000f\u0001\u0000"+
		"\u0010\u0011\u0001\u0000\u0012\u0013\u0001\u0000\u0014\u0015\u0154\u0000"+
		"G\u0001\u0000\u0000\u0000\u0002T\u0001\u0000\u0000\u0000\u0004V\u0001"+
		"\u0000\u0000\u0000\u0006Y\u0001\u0000\u0000\u0000\bd\u0001\u0000\u0000"+
		"\u0000\ni\u0001\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000\u000et\u0001"+
		"\u0000\u0000\u0000\u0010\u007f\u0001\u0000\u0000\u0000\u0012\u0091\u0001"+
		"\u0000\u0000\u0000\u0014\u0095\u0001\u0000\u0000\u0000\u0016\u009b\u0001"+
		"\u0000\u0000\u0000\u0018\u00a7\u0001\u0000\u0000\u0000\u001a\u00ac\u0001"+
		"\u0000\u0000\u0000\u001c\u00b1\u0001\u0000\u0000\u0000\u001e\u00b6\u0001"+
		"\u0000\u0000\u0000 \u00be\u0001\u0000\u0000\u0000\"\u00c0\u0001\u0000"+
		"\u0000\u0000$\u00d4\u0001\u0000\u0000\u0000&\u00df\u0001\u0000\u0000\u0000"+
		"(\u00e1\u0001\u0000\u0000\u0000*\u00e8\u0001\u0000\u0000\u0000,\u00ed"+
		"\u0001\u0000\u0000\u0000.\u00f2\u0001\u0000\u0000\u00000\u00f7\u0001\u0000"+
		"\u0000\u00002\u00fc\u0001\u0000\u0000\u00004\u0101\u0001\u0000\u0000\u0000"+
		"6\u010a\u0001\u0000\u0000\u00008\u0111\u0001\u0000\u0000\u0000:\u0114"+
		"\u0001\u0000\u0000\u0000<\u0118\u0001\u0000\u0000\u0000>\u0135\u0001\u0000"+
		"\u0000\u0000@\u0137\u0001\u0000\u0000\u0000B\u013d\u0001\u0000\u0000\u0000"+
		"DF\u0003\u0002\u0001\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HM\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000JL\u0003\b\u0004\u0000KJ\u0001\u0000"+
		"\u0000\u0000LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"PQ\u0005\u0000\u0000\u0001Q\u0001\u0001\u0000\u0000\u0000RU\u0003\u0004"+
		"\u0002\u0000SU\u0003\u0006\u0003\u0000TR\u0001\u0000\u0000\u0000TS\u0001"+
		"\u0000\u0000\u0000U\u0003\u0001\u0000\u0000\u0000VW\u0005\u001f\u0000"+
		"\u0000WX\u0005,\u0000\u0000X\u0005\u0001\u0000\u0000\u0000YZ\u0005 \u0000"+
		"\u0000Z[\u0005,\u0000\u0000[\\\u0005\u001f\u0000\u0000\\]\u0005,\u0000"+
		"\u0000]\u0007\u0001\u0000\u0000\u0000^e\u0003\u000e\u0007\u0000_e\u0003"+
		"\u0010\b\u0000`e\u0003\u0014\n\u0000ae\u0003\u0016\u000b\u0000be\u0003"+
		" \u0010\u0000ce\u0003\u0012\t\u0000d^\u0001\u0000\u0000\u0000d_\u0001"+
		"\u0000\u0000\u0000d`\u0001\u0000\u0000\u0000da\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000e\t\u0001\u0000\u0000"+
		"\u0000fh\u0003\b\u0004\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u000b\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lq\u0003\u001e\u000f\u0000"+
		"mn\u0005\u0019\u0000\u0000np\u0003\u001e\u000f\u0000om\u0001\u0000\u0000"+
		"\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000r\r\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005"+
		"!\u0000\u0000uv\u0005,\u0000\u0000vx\u0005\u001b\u0000\u0000wy\u0003\f"+
		"\u0006\u0000xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z{\u0005\u001c\u0000\u0000{|\u0005\u001a\u0000\u0000"+
		"|}\u0003\n\u0005\u0000}~\u0005)\u0000\u0000~\u000f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005\"\u0000\u0000\u0080\u0086\u0005,\u0000\u0000\u0081"+
		"\u0082\u0005\u001b\u0000\u0000\u0082\u0083\u0005,\u0000\u0000\u0083\u0087"+
		"\u0005\u001c\u0000\u0000\u0084\u0085\u0005\u001b\u0000\u0000\u0085\u0087"+
		"\u0005\u001c\u0000\u0000\u0086\u0081\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u008c\u0005\u001a\u0000\u0000\u0089\u008b"+
		"\u0003\u000e\u0007\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e"+
		"\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005)\u0000\u0000\u0090\u0011\u0001"+
		"\u0000\u0000\u0000\u0091\u0093\u0005\'\u0000\u0000\u0092\u0094\u0003 "+
		"\u0010\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0013\u0001\u0000\u0000\u0000\u0095\u0096\u0005#\u0000"+
		"\u0000\u0096\u0097\u0003 \u0010\u0000\u0097\u0098\u0005\u001a\u0000\u0000"+
		"\u0098\u0099\u0003\n\u0005\u0000\u0099\u009a\u0005)\u0000\u0000\u009a"+
		"\u0015\u0001\u0000\u0000\u0000\u009b\u009f\u0003\u0018\f\u0000\u009c\u009e"+
		"\u0003\u001a\r\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u00a1\u0001"+
		"\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a4\u0003\u001c\u000e\u0000\u00a3\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0005)\u0000\u0000\u00a6\u0017\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0005$\u0000\u0000\u00a8\u00a9\u0003 \u0010\u0000"+
		"\u00a9\u00aa\u0005\u001a\u0000\u0000\u00aa\u00ab\u0003\n\u0005\u0000\u00ab"+
		"\u0019\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005%\u0000\u0000\u00ad\u00ae"+
		"\u0003 \u0010\u0000\u00ae\u00af\u0005\u001a\u0000\u0000\u00af\u00b0\u0003"+
		"\n\u0005\u0000\u00b0\u001b\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005&"+
		"\u0000\u0000\u00b2\u00b3\u0005\u001a\u0000\u0000\u00b3\u00b4\u0003\n\u0005"+
		"\u0000\u00b4\u001d\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005\u0012\u0000"+
		"\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bc\u0005,\u0000\u0000"+
		"\u00b9\u00ba\u0005\u001d\u0000\u0000\u00ba\u00bb\u0007\u0000\u0000\u0000"+
		"\u00bb\u00bd\u0005\u001e\u0000\u0000\u00bc\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u001f\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0003\"\u0011\u0000\u00bf!\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0003$\u0012\u0000\u00c1#\u0001\u0000\u0000\u0000\u00c2\u00c3\u0003"+
		"<\u001e\u0000\u00c3\u00c4\u0005\u0018\u0000\u0000\u00c4\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003\u001e"+
		"\u000f\u0000\u00c8\u00c9\u0005\u0003\u0000\u0000\u00c9\u00ca\u0003$\u0012"+
		"\u0000\u00ca\u00d5\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003<\u001e\u0000"+
		"\u00cc\u00cd\u0005\u0018\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005,\u0000\u0000\u00d1"+
		"\u00d2\u0007\u0001\u0000\u0000\u00d2\u00d5\u0003&\u0013\u0000\u00d3\u00d5"+
		"\u0003&\u0013\u0000\u00d4\u00c5\u0001\u0000\u0000\u0000\u00d4\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5%\u0001\u0000"+
		"\u0000\u0000\u00d6\u00dc\u0003*\u0015\u0000\u00d7\u00d8\u0005$\u0000\u0000"+
		"\u00d8\u00d9\u0003*\u0015\u0000\u00d9\u00da\u0005&\u0000\u0000\u00da\u00db"+
		"\u0003&\u0013\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00d7\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001"+
		"\u0000\u0000\u0000\u00de\u00e0\u0003(\u0014\u0000\u00df\u00d6\u0001\u0000"+
		"\u0000\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\'\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e3\u0005(\u0000\u0000\u00e2\u00e4\u0003\f\u0006\u0000"+
		"\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\u001a\u0000\u0000"+
		"\u00e6\u00e7\u0003&\u0013\u0000\u00e7)\u0001\u0000\u0000\u0000\u00e8\u00eb"+
		"\u0003,\u0016\u0000\u00e9\u00ea\u0005\b\u0000\u0000\u00ea\u00ec\u0003"+
		"*\u0015\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec+\u0001\u0000\u0000\u0000\u00ed\u00f0\u0003.\u0017\u0000"+
		"\u00ee\u00ef\u0005\t\u0000\u0000\u00ef\u00f1\u0003,\u0016\u0000\u00f0"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1"+
		"-\u0001\u0000\u0000\u0000\u00f2\u00f5\u00030\u0018\u0000\u00f3\u00f4\u0007"+
		"\u0002\u0000\u0000\u00f4\u00f6\u0003.\u0017\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6/\u0001\u0000\u0000"+
		"\u0000\u00f7\u00fa\u00032\u0019\u0000\u00f8\u00f9\u0007\u0003\u0000\u0000"+
		"\u00f9\u00fb\u00030\u0018\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fb1\u0001\u0000\u0000\u0000\u00fc\u00ff"+
		"\u00034\u001a\u0000\u00fd\u00fe\u0007\u0004\u0000\u0000\u00fe\u0100\u0003"+
		"2\u0019\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000"+
		"\u0000\u0000\u01003\u0001\u0000\u0000\u0000\u0101\u0104\u00036\u001b\u0000"+
		"\u0102\u0103\u0007\u0005\u0000\u0000\u0103\u0105\u00034\u001a\u0000\u0104"+
		"\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105"+
		"5\u0001\u0000\u0000\u0000\u0106\u0107\u0005\u0016\u0000\u0000\u0107\u010b"+
		"\u00036\u001b\u0000\u0108\u010b\u00038\u001c\u0000\u0109\u010b\u0003:"+
		"\u001d\u0000\u010a\u0106\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b7\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0007\u0006\u0000\u0000\u010d\u0112\u0003<\u001e\u0000"+
		"\u010e\u010f\u0003<\u001e\u0000\u010f\u0110\u0007\u0006\u0000\u0000\u0110"+
		"\u0112\u0001\u0000\u0000\u0000\u0111\u010c\u0001\u0000\u0000\u0000\u0111"+
		"\u010e\u0001\u0000\u0000\u0000\u01129\u0001\u0000\u0000\u0000\u0113\u0115"+
		"\u0007\u0004\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0003<\u001e\u0000\u0117;\u0001\u0000\u0000\u0000\u0118\u0122\u0003>"+
		"\u001f\u0000\u0119\u011b\u0005\u001b\u0000\u0000\u011a\u011c\u0003B!\u0000"+
		"\u011b\u011a\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u0121\u0005\u001c\u0000\u0000"+
		"\u011e\u011f\u0005\u0018\u0000\u0000\u011f\u0121\u0003\u001e\u000f\u0000"+
		"\u0120\u0119\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000"+
		"\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000"+
		"\u0122\u0123\u0001\u0000\u0000\u0000\u0123=\u0001\u0000\u0000\u0000\u0124"+
		"\u0122\u0001\u0000\u0000\u0000\u0125\u0136\u0003@ \u0000\u0126\u0136\u0003"+
		"\u001e\u000f\u0000\u0127\u0136\u0005.\u0000\u0000\u0128\u0136\u0005-\u0000"+
		"\u0000\u0129\u0136\u0005*\u0000\u0000\u012a\u0136\u0005+\u0000\u0000\u012b"+
		"\u012c\u0005\u001b\u0000\u0000\u012c\u012d\u0003\"\u0011\u0000\u012d\u012e"+
		"\u0005\u001c\u0000\u0000\u012e\u0136\u0001\u0000\u0000\u0000\u012f\u0130"+
		"\u0005\u0017\u0000\u0000\u0130\u0132\u0005\u001b\u0000\u0000\u0131\u0133"+
		"\u0003B!\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000"+
		"\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0136\u0005\u001c"+
		"\u0000\u0000\u0135\u0125\u0001\u0000\u0000\u0000\u0135\u0126\u0001\u0000"+
		"\u0000\u0000\u0135\u0127\u0001\u0000\u0000\u0000\u0135\u0128\u0001\u0000"+
		"\u0000\u0000\u0135\u0129\u0001\u0000\u0000\u0000\u0135\u012a\u0001\u0000"+
		"\u0000\u0000\u0135\u012b\u0001\u0000\u0000\u0000\u0135\u012f\u0001\u0000"+
		"\u0000\u0000\u0136?\u0001\u0000\u0000\u0000\u0137\u0139\u0005\u001d\u0000"+
		"\u0000\u0138\u013a\u0003B!\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u0139"+
		"\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b"+
		"\u013c\u0005\u001e\u0000\u0000\u013cA\u0001\u0000\u0000\u0000\u013d\u0142"+
		"\u0003\"\u0011\u0000\u013e\u013f\u0005\u0019\u0000\u0000\u013f\u0141\u0003"+
		"\"\u0011\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000"+
		"\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000"+
		"\u0000\u0000\u0143C\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000"+
		"\u0000$GMTdiqx\u0086\u008c\u0093\u009f\u00a3\u00b6\u00bc\u00c5\u00ce\u00d4"+
		"\u00dc\u00df\u00e3\u00eb\u00f0\u00f5\u00fa\u00ff\u0104\u010a\u0111\u0114"+
		"\u011b\u0120\u0122\u0132\u0135\u0139\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
