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
		WHITESPACE=1, COMMENT=2, ASSIGN=3, OR=4, AND=5, EQ=6, NEQ=7, LT=8, GT=9,
		LTE=10, GTE=11, PLUS=12, MINUS=13, STAR=14, DIVIDE=15, NOT=16, SUPER=17,
		DOT=18, COMMA=19, COLON=20, L_PAREN=21, R_PAREN=22, L_BRACKET=23, R_BRACKET=24,
		IMPORT=25, FROM=26, DEF=27, CLASS=28, WHILE=29, IF=30, ELIF=31, ELSE=32,
		RETURN=33, END=34, TRUE=35, FALSE=36, NAME=37, STRING=38, NUMBER=39;
	public static final int
		RULE_program = 0, RULE_import_statement = 1, RULE_file_import = 2, RULE_member_import = 3,
		RULE_statement = 4, RULE_block = 5, RULE_parameters = 6, RULE_funcdef = 7,
		RULE_classdef = 8, RULE_return_stmt = 9, RULE_while_stmt = 10, RULE_branch_stmt = 11,
		RULE_if_stmt = 12, RULE_elif_stmt = 13, RULE_else_stmt = 14, RULE_name = 15,
		RULE_expression_stmt = 16, RULE_expression = 17, RULE_assignment = 18,
		RULE_logic_or = 19, RULE_logic_and = 20, RULE_equality = 21, RULE_comparison = 22,
		RULE_term = 23, RULE_factor = 24, RULE_unary = 25, RULE_call = 26, RULE_primary = 27,
		RULE_list_expression = 28, RULE_arguments = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "import_statement", "file_import", "member_import", "statement",
			"block", "parameters", "funcdef", "classdef", "return_stmt", "while_stmt",
			"branch_stmt", "if_stmt", "elif_stmt", "else_stmt", "name", "expression_stmt",
			"expression", "assignment", "logic_or", "logic_and", "equality", "comparison",
			"term", "factor", "unary", "call", "primary", "list_expression", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'='", "'or'", "'and'", "'=='", "'!='", "'<'", "'>'",
			"'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'not'", "'super'", "'.'",
			"','", "':'", "'('", "')'", "'['", "']'", "'import'", "'from'", "'def'",
			"'class'", "'while'", "'if'", "'elif'", "'else'", "'return'", "'#end'",
			"'True'", "'False'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "COMMENT", "ASSIGN", "OR", "AND", "EQ", "NEQ", "LT",
			"GT", "LTE", "GTE", "PLUS", "MINUS", "STAR", "DIVIDE", "NOT", "SUPER",
			"DOT", "COMMA", "COLON", "L_PAREN", "R_PAREN", "L_BRACKET", "R_BRACKET",
			"IMPORT", "FROM", "DEF", "CLASS", "WHILE", "IF", "ELIF", "ELSE", "RETURN",
			"END", "TRUE", "FALSE", "NAME", "STRING", "NUMBER"
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT || _la==FROM) {
				{
				{
				setState(60);
				import_statement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1075765800960L) != 0) {
				{
				{
				setState(66);
				statement();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				file_import();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
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
			setState(78);
			match(IMPORT);
			setState(79);
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
			setState(81);
			match(FROM);
			setState(82);
			match(NAME);
			setState(83);
			match(IMPORT);
			setState(84);
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
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				funcdef();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				classdef();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				while_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(89);
				branch_stmt();
				}
				break;
			case PLUS:
			case MINUS:
			case STAR:
			case NOT:
			case SUPER:
			case L_PAREN:
			case L_BRACKET:
			case TRUE:
			case FALSE:
			case NAME:
			case STRING:
			case NUMBER:
				enterOuterAlt(_localctx, 5);
				{
				setState(90);
				expression_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(91);
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
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1075765800960L) != 0) {
				{
				{
				setState(94);
				statement();
				}
				}
				setState(99);
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
			setState(100);
			name();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(101);
				match(COMMA);
				setState(102);
				name();
				}
				}
				setState(107);
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
			setState(108);
			match(DEF);
			setState(109);
			match(NAME);
			setState(110);
			match(L_PAREN);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR || _la==NAME) {
				{
				setState(111);
				parameters();
				}
			}

			setState(114);
			match(R_PAREN);
			setState(115);
			match(COLON);
			setState(116);
			block();
			setState(117);
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
			setState(119);
			match(CLASS);
			setState(120);
			match(NAME);
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				{
				setState(121);
				match(L_PAREN);
				setState(122);
				match(NAME);
				setState(123);
				match(R_PAREN);
				}
				}
				break;
			case 2:
				{
				setState(124);
				match(L_PAREN);
				setState(125);
				match(R_PAREN);
				}
				break;
			}
			setState(128);
			match(COLON);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEF) {
				{
				{
				setState(129);
				funcdef();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
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
			setState(137);
			match(RETURN);
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(138);
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
			setState(141);
			match(WHILE);
			setState(142);
			expression_stmt();
			setState(143);
			match(COLON);
			setState(144);
			block();
			setState(145);
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
			setState(147);
			if_stmt();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(148);
				elif_stmt();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(154);
				else_stmt();
				}
			}

			setState(157);
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
			setState(159);
			match(IF);
			setState(160);
			expression_stmt();
			setState(161);
			match(COLON);
			setState(162);
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
			setState(164);
			match(ELIF);
			setState(165);
			expression_stmt();
			setState(166);
			match(COLON);
			setState(167);
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
			setState(169);
			match(ELSE);
			setState(170);
			match(COLON);
			setState(171);
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
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(173);
				match(STAR);
				}
			}

			setState(176);
			match(NAME);
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(177);
				match(L_BRACKET);
				setState(178);
				_la = _input.LA(1);
				if ( !(_la==NAME || _la==NUMBER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(179);
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
			setState(182);
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
			setState(184);
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
		public Logic_orContext logic_or() {
			return getRuleContext(Logic_orContext.class,0);
		}
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
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(186);
					call();
					setState(187);
					match(DOT);
					}
					break;
				}
				setState(191);
				name();
				setState(192);
				match(ASSIGN);
				setState(193);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				logic_or();
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
		enterRule(_localctx, 38, RULE_logic_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			logic_and();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR) {
				{
				setState(199);
				match(OR);
				setState(200);
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
		enterRule(_localctx, 40, RULE_logic_and);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			equality();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AND) {
				{
				setState(204);
				match(AND);
				setState(205);
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
		enterRule(_localctx, 42, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			comparison();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ || _la==NEQ) {
				{
				setState(209);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
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
		enterRule(_localctx, 44, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			term();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0) {
				{
				setState(214);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
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
		enterRule(_localctx, 46, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			factor();
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(219);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(220);
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
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
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
		enterRule(_localctx, 48, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			unary();
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(224);
				_la = _input.LA(1);
				if ( !(_la==STAR || _la==DIVIDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(225);
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
	public static class UnaryContext extends ParserRuleContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(minipythonParser.NOT, 0); }
		public TerminalNode PLUS() { return getToken(minipythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(minipythonParser.MINUS, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_unary);
		int _la;
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 77824L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(229);
				unary();
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
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				call();
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
		enterRule(_localctx, 52, RULE_call);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			primary();
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(241);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case L_PAREN:
						{
						setState(234);
						match(L_PAREN);
						setState(236);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065162600448L) != 0) {
							{
							setState(235);
							arguments();
							}
						}

						setState(238);
						match(R_PAREN);
						}
						break;
					case DOT:
						{
						setState(239);
						match(DOT);
						setState(240);
						name();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 54, RULE_primary);
		int _la;
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_BRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				list_expression();
				}
				break;
			case STAR:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				name();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				match(STRING);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
				match(FALSE);
				}
				break;
			case L_PAREN:
				enterOuterAlt(_localctx, 7);
				{
				setState(252);
				match(L_PAREN);
				setState(253);
				expression();
				setState(254);
				match(R_PAREN);
				}
				break;
			case SUPER:
				enterOuterAlt(_localctx, 8);
				{
				setState(256);
				match(SUPER);
				setState(257);
				match(L_PAREN);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065162600448L) != 0) {
					{
					setState(258);
					arguments();
					}
				}

				setState(261);
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
		enterRule(_localctx, 56, RULE_list_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(L_BRACKET);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 1065162600448L) != 0) {
				{
				setState(265);
				arguments();
				}
			}

			setState(268);
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
		enterRule(_localctx, 58, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			expression();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(271);
				match(COMMA);
				setState(272);
				expression();
				}
				}
				setState(277);
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
		"\u0004\u0001\'\u0117\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0005\u0000"+
		">\b\u0000\n\u0000\f\u0000A\t\u0000\u0001\u0000\u0005\u0000D\b\u0000\n"+
		"\u0000\f\u0000G\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0003\u0001M\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004]\b\u0004"+
		"\u0001\u0005\u0005\u0005`\b\u0005\n\u0005\f\u0005c\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006h\b\u0006\n\u0006\f\u0006k\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007q\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u007f\b\b\u0001\b\u0001"+
		"\b\u0005\b\u0083\b\b\n\b\f\b\u0086\t\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0003\t\u008c\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u0096\b\u000b\n\u000b\f\u000b\u0099\t\u000b"+
		"\u0001\u000b\u0003\u000b\u009c\b\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0003\u000f"+
		"\u00af\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00b5\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00be\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00c5\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u00ca\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u00cf\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u00d4\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u00d9\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00de\b"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u00e3\b\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u00e8\b\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u00ed\b\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u00f2\b\u001a\n\u001a\f\u001a\u00f5\t\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u0104\b\u001b\u0001\u001b\u0003\u001b\u0107\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u010b\b\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0112\b\u001d\n\u001d\f\u001d"+
		"\u0115\t\u001d\u0001\u001d\u0000\u0000\u001e\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:\u0000\u0006\u0002\u0000%%\'\'\u0001\u0000\u0006\u0007\u0001\u0000"+
		"\b\u000b\u0001\u0000\f\r\u0001\u0000\u000e\u000f\u0002\u0000\f\r\u0010"+
		"\u0010\u0121\u0000?\u0001\u0000\u0000\u0000\u0002L\u0001\u0000\u0000\u0000"+
		"\u0004N\u0001\u0000\u0000\u0000\u0006Q\u0001\u0000\u0000\u0000\b\\\u0001"+
		"\u0000\u0000\u0000\na\u0001\u0000\u0000\u0000\fd\u0001\u0000\u0000\u0000"+
		"\u000el\u0001\u0000\u0000\u0000\u0010w\u0001\u0000\u0000\u0000\u0012\u0089"+
		"\u0001\u0000\u0000\u0000\u0014\u008d\u0001\u0000\u0000\u0000\u0016\u0093"+
		"\u0001\u0000\u0000\u0000\u0018\u009f\u0001\u0000\u0000\u0000\u001a\u00a4"+
		"\u0001\u0000\u0000\u0000\u001c\u00a9\u0001\u0000\u0000\u0000\u001e\u00ae"+
		"\u0001\u0000\u0000\u0000 \u00b6\u0001\u0000\u0000\u0000\"\u00b8\u0001"+
		"\u0000\u0000\u0000$\u00c4\u0001\u0000\u0000\u0000&\u00c6\u0001\u0000\u0000"+
		"\u0000(\u00cb\u0001\u0000\u0000\u0000*\u00d0\u0001\u0000\u0000\u0000,"+
		"\u00d5\u0001\u0000\u0000\u0000.\u00da\u0001\u0000\u0000\u00000\u00df\u0001"+
		"\u0000\u0000\u00002\u00e7\u0001\u0000\u0000\u00004\u00e9\u0001\u0000\u0000"+
		"\u00006\u0106\u0001\u0000\u0000\u00008\u0108\u0001\u0000\u0000\u0000:"+
		"\u010e\u0001\u0000\u0000\u0000<>\u0003\u0002\u0001\u0000=<\u0001\u0000"+
		"\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@E\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"BD\u0003\b\u0004\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000"+
		"EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000HI\u0005\u0000\u0000\u0001I\u0001\u0001"+
		"\u0000\u0000\u0000JM\u0003\u0004\u0002\u0000KM\u0003\u0006\u0003\u0000"+
		"LJ\u0001\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000M\u0003\u0001\u0000"+
		"\u0000\u0000NO\u0005\u0019\u0000\u0000OP\u0005%\u0000\u0000P\u0005\u0001"+
		"\u0000\u0000\u0000QR\u0005\u001a\u0000\u0000RS\u0005%\u0000\u0000ST\u0005"+
		"\u0019\u0000\u0000TU\u0005%\u0000\u0000U\u0007\u0001\u0000\u0000\u0000"+
		"V]\u0003\u000e\u0007\u0000W]\u0003\u0010\b\u0000X]\u0003\u0014\n\u0000"+
		"Y]\u0003\u0016\u000b\u0000Z]\u0003 \u0010\u0000[]\u0003\u0012\t\u0000"+
		"\\V\u0001\u0000\u0000\u0000\\W\u0001\u0000\u0000\u0000\\X\u0001\u0000"+
		"\u0000\u0000\\Y\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\["+
		"\u0001\u0000\u0000\u0000]\t\u0001\u0000\u0000\u0000^`\u0003\b\u0004\u0000"+
		"_^\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000b\u000b\u0001\u0000\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000di\u0003\u001e\u000f\u0000ef\u0005\u0013\u0000\u0000"+
		"fh\u0003\u001e\u000f\u0000ge\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\r\u0001\u0000"+
		"\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0005\u001b\u0000\u0000mn\u0005"+
		"%\u0000\u0000np\u0005\u0015\u0000\u0000oq\u0003\f\u0006\u0000po\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"rs\u0005\u0016\u0000\u0000st\u0005\u0014\u0000\u0000tu\u0003\n\u0005\u0000"+
		"uv\u0005\"\u0000\u0000v\u000f\u0001\u0000\u0000\u0000wx\u0005\u001c\u0000"+
		"\u0000x~\u0005%\u0000\u0000yz\u0005\u0015\u0000\u0000z{\u0005%\u0000\u0000"+
		"{\u007f\u0005\u0016\u0000\u0000|}\u0005\u0015\u0000\u0000}\u007f\u0005"+
		"\u0016\u0000\u0000~y\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0084\u0005\u0014\u0000\u0000\u0081\u0083\u0003\u000e\u0007\u0000\u0082"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005\"\u0000\u0000\u0088\u0011\u0001\u0000\u0000\u0000\u0089\u008b"+
		"\u0005!\u0000\u0000\u008a\u008c\u0003 \u0010\u0000\u008b\u008a\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u0013\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005\u001d\u0000\u0000\u008e\u008f\u0003 \u0010"+
		"\u0000\u008f\u0090\u0005\u0014\u0000\u0000\u0090\u0091\u0003\n\u0005\u0000"+
		"\u0091\u0092\u0005\"\u0000\u0000\u0092\u0015\u0001\u0000\u0000\u0000\u0093"+
		"\u0097\u0003\u0018\f\u0000\u0094\u0096\u0003\u001a\r\u0000\u0095\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009b"+
		"\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009c"+
		"\u0003\u001c\u000e\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0005\"\u0000\u0000\u009e\u0017\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"\u001e\u0000\u0000\u00a0\u00a1\u0003 \u0010\u0000\u00a1\u00a2\u0005\u0014"+
		"\u0000\u0000\u00a2\u00a3\u0003\n\u0005\u0000\u00a3\u0019\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005\u001f\u0000\u0000\u00a5\u00a6\u0003 \u0010\u0000"+
		"\u00a6\u00a7\u0005\u0014\u0000\u0000\u00a7\u00a8\u0003\n\u0005\u0000\u00a8"+
		"\u001b\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005 \u0000\u0000\u00aa\u00ab"+
		"\u0005\u0014\u0000\u0000\u00ab\u00ac\u0003\n\u0005\u0000\u00ac\u001d\u0001"+
		"\u0000\u0000\u0000\u00ad\u00af\u0005\u000e\u0000\u0000\u00ae\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b4\u0005%\u0000\u0000\u00b1\u00b2\u0005\u0017"+
		"\u0000\u0000\u00b2\u00b3\u0007\u0000\u0000\u0000\u00b3\u00b5\u0005\u0018"+
		"\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u001f\u0001\u0000\u0000\u0000\u00b6\u00b7\u0003\"\u0011"+
		"\u0000\u00b7!\u0001\u0000\u0000\u0000\u00b8\u00b9\u0003$\u0012\u0000\u00b9"+
		"#\u0001\u0000\u0000\u0000\u00ba\u00bb\u00034\u001a\u0000\u00bb\u00bc\u0005"+
		"\u0012\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c0\u0003\u001e\u000f\u0000\u00c0\u00c1\u0005"+
		"\u0003\u0000\u0000\u00c1\u00c2\u0003$\u0012\u0000\u00c2\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c5\u0003&\u0013\u0000\u00c4\u00bd\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5%\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c9\u0003(\u0014\u0000\u00c7\u00c8\u0005\u0004\u0000\u0000\u00c8"+
		"\u00ca\u0003&\u0013\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\'\u0001\u0000\u0000\u0000\u00cb\u00ce\u0003"+
		"*\u0015\u0000\u00cc\u00cd\u0005\u0005\u0000\u0000\u00cd\u00cf\u0003(\u0014"+
		"\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf)\u0001\u0000\u0000\u0000\u00d0\u00d3\u0003,\u0016\u0000\u00d1"+
		"\u00d2\u0007\u0001\u0000\u0000\u00d2\u00d4\u0003*\u0015\u0000\u00d3\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4+\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d8\u0003.\u0017\u0000\u00d6\u00d7\u0007\u0002"+
		"\u0000\u0000\u00d7\u00d9\u0003,\u0016\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9-\u0001\u0000\u0000\u0000"+
		"\u00da\u00dd\u00030\u0018\u0000\u00db\u00dc\u0007\u0003\u0000\u0000\u00dc"+
		"\u00de\u0003.\u0017\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0001\u0000\u0000\u0000\u00de/\u0001\u0000\u0000\u0000\u00df\u00e2\u0003"+
		"2\u0019\u0000\u00e0\u00e1\u0007\u0004\u0000\u0000\u00e1\u00e3\u00030\u0018"+
		"\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e31\u0001\u0000\u0000\u0000\u00e4\u00e5\u0007\u0005\u0000\u0000"+
		"\u00e5\u00e8\u00032\u0019\u0000\u00e6\u00e8\u00034\u001a\u0000\u00e7\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e83\u0001"+
		"\u0000\u0000\u0000\u00e9\u00f3\u00036\u001b\u0000\u00ea\u00ec\u0005\u0015"+
		"\u0000\u0000\u00eb\u00ed\u0003:\u001d\u0000\u00ec\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ee\u00f2\u0005\u0016\u0000\u0000\u00ef\u00f0\u0005\u0012\u0000"+
		"\u0000\u00f0\u00f2\u0003\u001e\u000f\u0000\u00f1\u00ea\u0001\u0000\u0000"+
		"\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f45\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f6\u0107\u00038\u001c\u0000\u00f7\u0107\u0003\u001e\u000f\u0000\u00f8"+
		"\u0107\u0005\'\u0000\u0000\u00f9\u0107\u0005&\u0000\u0000\u00fa\u0107"+
		"\u0005#\u0000\u0000\u00fb\u0107\u0005$\u0000\u0000\u00fc\u00fd\u0005\u0015"+
		"\u0000\u0000\u00fd\u00fe\u0003\"\u0011\u0000\u00fe\u00ff\u0005\u0016\u0000"+
		"\u0000\u00ff\u0107\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u0011\u0000"+
		"\u0000\u0101\u0103\u0005\u0015\u0000\u0000\u0102\u0104\u0003:\u001d\u0000"+
		"\u0103\u0102\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0107\u0005\u0016\u0000\u0000"+
		"\u0106\u00f6\u0001\u0000\u0000\u0000\u0106\u00f7\u0001\u0000\u0000\u0000"+
		"\u0106\u00f8\u0001\u0000\u0000\u0000\u0106\u00f9\u0001\u0000\u0000\u0000"+
		"\u0106\u00fa\u0001\u0000\u0000\u0000\u0106\u00fb\u0001\u0000\u0000\u0000"+
		"\u0106\u00fc\u0001\u0000\u0000\u0000\u0106\u0100\u0001\u0000\u0000\u0000"+
		"\u01077\u0001\u0000\u0000\u0000\u0108\u010a\u0005\u0017\u0000\u0000\u0109"+
		"\u010b\u0003:\u001d\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0005\u0018\u0000\u0000\u010d9\u0001\u0000\u0000\u0000\u010e\u0113\u0003"+
		"\"\u0011\u0000\u010f\u0110\u0005\u0013\u0000\u0000\u0110\u0112\u0003\""+
		"\u0011\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000"+
		"\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000"+
		"\u0000\u0000\u0114;\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000"+
		"\u0000\u001e?EL\\aip~\u0084\u008b\u0097\u009b\u00ae\u00b4\u00bd\u00c4"+
		"\u00c9\u00ce\u00d3\u00d8\u00dd\u00e2\u00e7\u00ec\u00f1\u00f3\u0103\u0106"+
		"\u010a\u0113";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
