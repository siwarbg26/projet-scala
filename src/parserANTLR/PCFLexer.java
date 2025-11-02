// Generated from C:/Users/siwar/Desktop/compil tp/TP1-3_Final/src/parserANTLR/PCF.g4 by ANTLR 4.13.2
package parserANTLR;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PCFLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, IN=2, FUN=3, ARROW=4, IFZ=5, THEN=6, ELSE=7, EQUALS=8, PLUS=9, 
		MINUS=10, TIMES=11, DIV=12, LPAR=13, RPAR=14, NUMBER=15, ID=16, WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LET", "IN", "FUN", "ARROW", "IFZ", "THEN", "ELSE", "EQUALS", "PLUS", 
			"MINUS", "TIMES", "DIV", "LPAR", "RPAR", "NUMBER", "ID", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'in'", "'fun'", "'->'", "'ifz'", "'then'", "'else'", 
			"'='", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "IN", "FUN", "ARROW", "IFZ", "THEN", "ELSE", "EQUALS", "PLUS", 
			"MINUS", "TIMES", "DIV", "LPAR", "RPAR", "NUMBER", "ID", "WS"
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


	public PCFLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PCF.g4"; }

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
		"\u0004\u0000\u0011`\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0004\u000eO\b\u000e\u000b\u000e\f\u000eP\u0001\u000f\u0001"+
		"\u000f\u0005\u000fU\b\u000f\n\u000f\f\u000fX\t\u000f\u0001\u0010\u0004"+
		"\u0010[\b\u0010\u000b\u0010\f\u0010\\\u0001\u0010\u0001\u0010\u0000\u0000"+
		"\u0011\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011\u0001\u0000\u0004\u0001\u000009\u0002"+
		"\u0000AZaz\u0003\u000009AZaz\u0003\u0000\t\n\r\r  b\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0001#\u0001\u0000\u0000\u0000\u0003\'\u0001\u0000\u0000\u0000\u0005"+
		"*\u0001\u0000\u0000\u0000\u0007.\u0001\u0000\u0000\u0000\t1\u0001\u0000"+
		"\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\r:\u0001\u0000\u0000\u0000"+
		"\u000f?\u0001\u0000\u0000\u0000\u0011A\u0001\u0000\u0000\u0000\u0013C"+
		"\u0001\u0000\u0000\u0000\u0015E\u0001\u0000\u0000\u0000\u0017G\u0001\u0000"+
		"\u0000\u0000\u0019I\u0001\u0000\u0000\u0000\u001bK\u0001\u0000\u0000\u0000"+
		"\u001dN\u0001\u0000\u0000\u0000\u001fR\u0001\u0000\u0000\u0000!Z\u0001"+
		"\u0000\u0000\u0000#$\u0005l\u0000\u0000$%\u0005e\u0000\u0000%&\u0005t"+
		"\u0000\u0000&\u0002\u0001\u0000\u0000\u0000\'(\u0005i\u0000\u0000()\u0005"+
		"n\u0000\u0000)\u0004\u0001\u0000\u0000\u0000*+\u0005f\u0000\u0000+,\u0005"+
		"u\u0000\u0000,-\u0005n\u0000\u0000-\u0006\u0001\u0000\u0000\u0000./\u0005"+
		"-\u0000\u0000/0\u0005>\u0000\u00000\b\u0001\u0000\u0000\u000012\u0005"+
		"i\u0000\u000023\u0005f\u0000\u000034\u0005z\u0000\u00004\n\u0001\u0000"+
		"\u0000\u000056\u0005t\u0000\u000067\u0005h\u0000\u000078\u0005e\u0000"+
		"\u000089\u0005n\u0000\u00009\f\u0001\u0000\u0000\u0000:;\u0005e\u0000"+
		"\u0000;<\u0005l\u0000\u0000<=\u0005s\u0000\u0000=>\u0005e\u0000\u0000"+
		">\u000e\u0001\u0000\u0000\u0000?@\u0005=\u0000\u0000@\u0010\u0001\u0000"+
		"\u0000\u0000AB\u0005+\u0000\u0000B\u0012\u0001\u0000\u0000\u0000CD\u0005"+
		"-\u0000\u0000D\u0014\u0001\u0000\u0000\u0000EF\u0005*\u0000\u0000F\u0016"+
		"\u0001\u0000\u0000\u0000GH\u0005/\u0000\u0000H\u0018\u0001\u0000\u0000"+
		"\u0000IJ\u0005(\u0000\u0000J\u001a\u0001\u0000\u0000\u0000KL\u0005)\u0000"+
		"\u0000L\u001c\u0001\u0000\u0000\u0000MO\u0007\u0000\u0000\u0000NM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"PQ\u0001\u0000\u0000\u0000Q\u001e\u0001\u0000\u0000\u0000RV\u0007\u0001"+
		"\u0000\u0000SU\u0007\u0002\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001"+
		"\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"W \u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000Y[\u0007\u0003\u0000"+
		"\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0006"+
		"\u0010\u0000\u0000_\"\u0001\u0000\u0000\u0000\u0004\u0000PV\\\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}