package main;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class minipythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, WHITESPACE=27, COMMENT=28, END=29, BOOLEAN=30, NAME=31, 
		STRING=32, INTEGER=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "WHITESPACE", "COMMENT", "END", "BOOLEAN", "NAME", "STRING", 
			"INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'('", "')'", "':'", "'class'", "','", "'return'", "'.'", 
			"'='", "'while'", "'if'", "'elif'", "'else'", "'*'", "'/'", "'+'", "'-'", 
			"'<'", "'<='", "'>'", "'>='", "'!='", "'=='", "'not'", "'and'", "'or'", 
			null, null, "'#end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "WHITESPACE", "COMMENT", "END", "BOOLEAN", "NAME", 
			"STRING", "INTEGER"
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


	public minipythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "minipython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000!\u0110\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0004\u001a"+
		"\u0098\b\u001a\u000b\u001a\f\u001a\u0099\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00a1\b\u001b\n\u001b\f\u001b"+
		"\u00a4\t\u001b\u0001\u001b\u0003\u001b\u00a7\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00ae\b\u001b\n"+
		"\u001b\f\u001b\u00b1\t\u001b\u0001\u001b\u0003\u001b\u00b4\b\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u00bc\b\u001b\n\u001b\f\u001b\u00bf\t\u001b\u0001\u001b\u0003\u001b"+
		"\u00c2\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00cd\b\u001b"+
		"\n\u001b\f\u001b\u00d0\t\u001b\u0001\u001b\u0003\u001b\u00d3\b\u001b\u0001"+
		"\u001b\u0003\u001b\u00d6\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u00e8\b\u001d\u0001\u001e\u0001\u001e\u0005\u001e\u00ec"+
		"\b\u001e\n\u001e\f\u001e\u00ef\t\u001e\u0001\u001f\u0001\u001f\u0005\u001f"+
		"\u00f3\b\u001f\n\u001f\f\u001f\u00f6\t\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0005\u001f\u00fb\b\u001f\n\u001f\f\u001f\u00fe\t\u001f\u0001\u001f"+
		"\u0003\u001f\u0101\b\u001f\u0001 \u0001 \u0005 \u0105\b \n \f \u0108\t"+
		" \u0001 \u0004 \u010b\b \u000b \f \u010c\u0003 \u010f\b \u0002\u00f4\u00fc"+
		"\u0000!\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!\u0001"+
		"\u0000\t\u0003\u0000\t\n\r\r  \u0001\u0000ee\u0002\u0000\n\n\r\r\u0001"+
		"\u0000nn\u0001\u0000dd\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u0000"+
		"19\u0001\u000009\u0124\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0000A\u0001\u0000\u0000\u0000\u0001C\u0001\u0000\u0000\u0000\u0003"+
		"G\u0001\u0000\u0000\u0000\u0005I\u0001\u0000\u0000\u0000\u0007K\u0001"+
		"\u0000\u0000\u0000\tM\u0001\u0000\u0000\u0000\u000bS\u0001\u0000\u0000"+
		"\u0000\rU\u0001\u0000\u0000\u0000\u000f\\\u0001\u0000\u0000\u0000\u0011"+
		"^\u0001\u0000\u0000\u0000\u0013`\u0001\u0000\u0000\u0000\u0015f\u0001"+
		"\u0000\u0000\u0000\u0017i\u0001\u0000\u0000\u0000\u0019n\u0001\u0000\u0000"+
		"\u0000\u001bs\u0001\u0000\u0000\u0000\u001du\u0001\u0000\u0000\u0000\u001f"+
		"w\u0001\u0000\u0000\u0000!y\u0001\u0000\u0000\u0000#{\u0001\u0000\u0000"+
		"\u0000%}\u0001\u0000\u0000\u0000\'\u0080\u0001\u0000\u0000\u0000)\u0082"+
		"\u0001\u0000\u0000\u0000+\u0085\u0001\u0000\u0000\u0000-\u0088\u0001\u0000"+
		"\u0000\u0000/\u008b\u0001\u0000\u0000\u00001\u008f\u0001\u0000\u0000\u0000"+
		"3\u0093\u0001\u0000\u0000\u00005\u0097\u0001\u0000\u0000\u00007\u00d5"+
		"\u0001\u0000\u0000\u00009\u00d9\u0001\u0000\u0000\u0000;\u00e7\u0001\u0000"+
		"\u0000\u0000=\u00e9\u0001\u0000\u0000\u0000?\u0100\u0001\u0000\u0000\u0000"+
		"A\u010e\u0001\u0000\u0000\u0000CD\u0005d\u0000\u0000DE\u0005e\u0000\u0000"+
		"EF\u0005f\u0000\u0000F\u0002\u0001\u0000\u0000\u0000GH\u0005(\u0000\u0000"+
		"H\u0004\u0001\u0000\u0000\u0000IJ\u0005)\u0000\u0000J\u0006\u0001\u0000"+
		"\u0000\u0000KL\u0005:\u0000\u0000L\b\u0001\u0000\u0000\u0000MN\u0005c"+
		"\u0000\u0000NO\u0005l\u0000\u0000OP\u0005a\u0000\u0000PQ\u0005s\u0000"+
		"\u0000QR\u0005s\u0000\u0000R\n\u0001\u0000\u0000\u0000ST\u0005,\u0000"+
		"\u0000T\f\u0001\u0000\u0000\u0000UV\u0005r\u0000\u0000VW\u0005e\u0000"+
		"\u0000WX\u0005t\u0000\u0000XY\u0005u\u0000\u0000YZ\u0005r\u0000\u0000"+
		"Z[\u0005n\u0000\u0000[\u000e\u0001\u0000\u0000\u0000\\]\u0005.\u0000\u0000"+
		"]\u0010\u0001\u0000\u0000\u0000^_\u0005=\u0000\u0000_\u0012\u0001\u0000"+
		"\u0000\u0000`a\u0005w\u0000\u0000ab\u0005h\u0000\u0000bc\u0005i\u0000"+
		"\u0000cd\u0005l\u0000\u0000de\u0005e\u0000\u0000e\u0014\u0001\u0000\u0000"+
		"\u0000fg\u0005i\u0000\u0000gh\u0005f\u0000\u0000h\u0016\u0001\u0000\u0000"+
		"\u0000ij\u0005e\u0000\u0000jk\u0005l\u0000\u0000kl\u0005i\u0000\u0000"+
		"lm\u0005f\u0000\u0000m\u0018\u0001\u0000\u0000\u0000no\u0005e\u0000\u0000"+
		"op\u0005l\u0000\u0000pq\u0005s\u0000\u0000qr\u0005e\u0000\u0000r\u001a"+
		"\u0001\u0000\u0000\u0000st\u0005*\u0000\u0000t\u001c\u0001\u0000\u0000"+
		"\u0000uv\u0005/\u0000\u0000v\u001e\u0001\u0000\u0000\u0000wx\u0005+\u0000"+
		"\u0000x \u0001\u0000\u0000\u0000yz\u0005-\u0000\u0000z\"\u0001\u0000\u0000"+
		"\u0000{|\u0005<\u0000\u0000|$\u0001\u0000\u0000\u0000}~\u0005<\u0000\u0000"+
		"~\u007f\u0005=\u0000\u0000\u007f&\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005>\u0000\u0000\u0081(\u0001\u0000\u0000\u0000\u0082\u0083\u0005>"+
		"\u0000\u0000\u0083\u0084\u0005=\u0000\u0000\u0084*\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0005!\u0000\u0000\u0086\u0087\u0005=\u0000\u0000\u0087,"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005=\u0000\u0000\u0089\u008a\u0005"+
		"=\u0000\u0000\u008a.\u0001\u0000\u0000\u0000\u008b\u008c\u0005n\u0000"+
		"\u0000\u008c\u008d\u0005o\u0000\u0000\u008d\u008e\u0005t\u0000\u0000\u008e"+
		"0\u0001\u0000\u0000\u0000\u008f\u0090\u0005a\u0000\u0000\u0090\u0091\u0005"+
		"n\u0000\u0000\u0091\u0092\u0005d\u0000\u0000\u00922\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005o\u0000\u0000\u0094\u0095\u0005r\u0000\u0000\u0095"+
		"4\u0001\u0000\u0000\u0000\u0096\u0098\u0007\u0000\u0000\u0000\u0097\u0096"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0006\u001a\u0000\u0000\u009c6\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005#\u0000\u0000\u009e\u00a2\b\u0001"+
		"\u0000\u0000\u009f\u00a1\b\u0002\u0000\u0000\u00a0\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7\u0005\r\u0000\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00d6\u0005\n\u0000\u0000\u00a9"+
		"\u00aa\u0005#\u0000\u0000\u00aa\u00ab\t\u0000\u0000\u0000\u00ab\u00af"+
		"\b\u0003\u0000\u0000\u00ac\u00ae\b\u0002\u0000\u0000\u00ad\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005"+
		"\r\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00d6\u0005\n\u0000"+
		"\u0000\u00b6\u00b7\u0005#\u0000\u0000\u00b7\u00b8\t\u0000\u0000\u0000"+
		"\u00b8\u00b9\t\u0000\u0000\u0000\u00b9\u00bd\b\u0004\u0000\u0000\u00ba"+
		"\u00bc\b\u0002\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c2\u0005\r\u0000\u0000\u00c1\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c3\u00d6\u0005\n\u0000\u0000\u00c4\u00d6\u0005#"+
		"\u0000\u0000\u00c5\u00c6\u0005#\u0000\u0000\u00c6\u00c7\u0005e\u0000\u0000"+
		"\u00c7\u00c8\u0005n\u0000\u0000\u00c8\u00c9\u0005d\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\u00ce\b\u0002\u0000\u0000\u00cb\u00cd\b"+
		"\u0002\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d3\u0005\r\u0000\u0000\u00d2\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d6\u0005\n\u0000\u0000\u00d5\u009d\u0001\u0000\u0000"+
		"\u0000\u00d5\u00a9\u0001\u0000\u0000\u0000\u00d5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00d5\u00c4\u0001\u0000\u0000\u0000\u00d5\u00c5\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0006\u001b\u0000"+
		"\u0000\u00d88\u0001\u0000\u0000\u0000\u00d9\u00da\u0005#\u0000\u0000\u00da"+
		"\u00db\u0005e\u0000\u0000\u00db\u00dc\u0005n\u0000\u0000\u00dc\u00dd\u0005"+
		"d\u0000\u0000\u00dd:\u0001\u0000\u0000\u0000\u00de\u00df\u0005T\u0000"+
		"\u0000\u00df\u00e0\u0005r\u0000\u0000\u00e0\u00e1\u0005u\u0000\u0000\u00e1"+
		"\u00e8\u0005e\u0000\u0000\u00e2\u00e3\u0005F\u0000\u0000\u00e3\u00e4\u0005"+
		"a\u0000\u0000\u00e4\u00e5\u0005l\u0000\u0000\u00e5\u00e6\u0005s\u0000"+
		"\u0000\u00e6\u00e8\u0005e\u0000\u0000\u00e7\u00de\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e2\u0001\u0000\u0000\u0000\u00e8<\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ed\u0007\u0005\u0000\u0000\u00ea\u00ec\u0007\u0006\u0000\u0000\u00eb"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee"+
		">\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f4"+
		"\u0005\"\u0000\u0000\u00f1\u00f3\u0002\u0000\u007f\u0000\u00f2\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u0101\u0005"+
		"\"\u0000\u0000\u00f8\u00fc\u0005\'\u0000\u0000\u00f9\u00fb\u0002\u0000"+
		"\u007f\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00ff\u0101\u0005\'\u0000\u0000\u0100\u00f0\u0001\u0000\u0000"+
		"\u0000\u0100\u00f8\u0001\u0000\u0000\u0000\u0101@\u0001\u0000\u0000\u0000"+
		"\u0102\u0106\u0007\u0007\u0000\u0000\u0103\u0105\u0007\b\u0000\u0000\u0104"+
		"\u0103\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000\u0000\u0106"+
		"\u0104\u0001\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107"+
		"\u010f\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000\u0000\u0109"+
		"\u010b\u00050\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u0102"+
		"\u0001\u0000\u0000\u0000\u010e\u010a\u0001\u0000\u0000\u0000\u010fB\u0001"+
		"\u0000\u0000\u0000\u0013\u0000\u0099\u00a2\u00a6\u00af\u00b3\u00bd\u00c1"+
		"\u00ce\u00d2\u00d5\u00e7\u00ed\u00f4\u00fc\u0100\u0106\u010c\u010e\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}