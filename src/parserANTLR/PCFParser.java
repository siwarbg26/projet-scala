// Generated from C:/Users/siwar/Desktop/compil tp/TP1-3_Final/src/parserANTLR/PCF.g4 by ANTLR 4.13.2
package parserANTLR;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PCFParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET=1, IN=2, IFZ=3, THEN=4, ELSE=5, EQUALS=6, PLUS=7, MINUS=8, TIMES=9, 
		DIV=10, LPAR=11, RPAR=12, NUMBER=13, ID=14, WS=15;
	public static final int
		RULE_term = 0, RULE_letExp = 1, RULE_ifzExp = 2, RULE_addSub = 3, RULE_mulDiv = 4, 
		RULE_primary = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"term", "letExp", "ifzExp", "addSub", "mulDiv", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'let'", "'in'", "'ifz'", "'then'", "'else'", "'='", "'+'", "'-'", 
			"'*'", "'/'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET", "IN", "IFZ", "THEN", "ELSE", "EQUALS", "PLUS", "MINUS", 
			"TIMES", "DIV", "LPAR", "RPAR", "NUMBER", "ID", "WS"
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
	public String getGrammarFileName() { return "PCF.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PCFParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public LetExpContext letExp() {
			return getRuleContext(LetExpContext.class,0);
		}
		public AddSubContext addSub() {
			return getRuleContext(AddSubContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_term);
		try {
			setState(14);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				letExp();
				}
				break;
			case IFZ:
			case LPAR:
			case NUMBER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				addSub();
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
	public static class LetExpContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(PCFParser.LET, 0); }
		public TerminalNode ID() { return getToken(PCFParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(PCFParser.EQUALS, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode IN() { return getToken(PCFParser.IN, 0); }
		public LetExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterLetExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitLetExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitLetExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetExpContext letExp() throws RecognitionException {
		LetExpContext _localctx = new LetExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_letExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(LET);
			setState(17);
			match(ID);
			setState(18);
			match(EQUALS);
			setState(19);
			term();
			setState(20);
			match(IN);
			setState(21);
			term();
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
	public static class IfzExpContext extends ParserRuleContext {
		public TerminalNode IFZ() { return getToken(PCFParser.IFZ, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode THEN() { return getToken(PCFParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(PCFParser.ELSE, 0); }
		public IfzExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifzExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterIfzExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitIfzExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitIfzExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfzExpContext ifzExp() throws RecognitionException {
		IfzExpContext _localctx = new IfzExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ifzExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(IFZ);
			setState(24);
			term();
			setState(25);
			match(THEN);
			setState(26);
			term();
			setState(27);
			match(ELSE);
			setState(28);
			term();
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
	public static class AddSubContext extends ParserRuleContext {
		public List<MulDivContext> mulDiv() {
			return getRuleContexts(MulDivContext.class);
		}
		public MulDivContext mulDiv(int i) {
			return getRuleContext(MulDivContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(PCFParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(PCFParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(PCFParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(PCFParser.MINUS, i);
		}
		public AddSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddSubContext addSub() throws RecognitionException {
		AddSubContext _localctx = new AddSubContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_addSub);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			mulDiv();
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(32);
					mulDiv();
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
	public static class MulDivContext extends ParserRuleContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(PCFParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(PCFParser.TIMES, i);
		}
		public List<TerminalNode> DIV() { return getTokens(PCFParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(PCFParser.DIV, i);
		}
		public MulDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDiv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulDivContext mulDiv() throws RecognitionException {
		MulDivContext _localctx = new MulDivContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mulDiv);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			primary();
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(39);
					_la = _input.LA(1);
					if ( !(_la==TIMES || _la==DIV) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(40);
					primary();
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		public TerminalNode NUMBER() { return getToken(PCFParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(PCFParser.ID, 0); }
		public IfzExpContext ifzExp() {
			return getRuleContext(IfzExpContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PCFParser.LPAR, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(PCFParser.RPAR, 0); }
		public TerminalNode IFZ() { return getToken(PCFParser.IFZ, 0); }
		public TerminalNode THEN() { return getToken(PCFParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(PCFParser.ELSE, 0); }
		public TerminalNode PLUS() { return getToken(PCFParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PCFParser.MINUS, 0); }
		public TerminalNode TIMES() { return getToken(PCFParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(PCFParser.DIV, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primary);
		int _la;
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				ifzExp();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(LPAR);
				setState(50);
				term();
				setState(51);
				match(RPAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				match(LPAR);
				setState(54);
				match(IFZ);
				setState(55);
				term();
				setState(56);
				match(THEN);
				setState(57);
				term();
				setState(58);
				match(ELSE);
				setState(59);
				term();
				setState(60);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(62);
				match(LPAR);
				setState(63);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(64);
				term();
				setState(65);
				term();
				setState(66);
				match(RPAR);
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

	public static final String _serializedATN =
		"\u0004\u0001\u000fG\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0003\u0000\u000f\b\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\"\b"+
		"\u0003\n\u0003\f\u0003%\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004*\b\u0004\n\u0004\f\u0004-\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005E\b\u0005\u0001\u0005\u0000\u0000\u0006"+
		"\u0000\u0002\u0004\u0006\b\n\u0000\u0003\u0001\u0000\u0007\b\u0001\u0000"+
		"\t\n\u0001\u0000\u0007\nH\u0000\u000e\u0001\u0000\u0000\u0000\u0002\u0010"+
		"\u0001\u0000\u0000\u0000\u0004\u0017\u0001\u0000\u0000\u0000\u0006\u001e"+
		"\u0001\u0000\u0000\u0000\b&\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000"+
		"\u0000\f\u000f\u0003\u0002\u0001\u0000\r\u000f\u0003\u0006\u0003\u0000"+
		"\u000e\f\u0001\u0000\u0000\u0000\u000e\r\u0001\u0000\u0000\u0000\u000f"+
		"\u0001\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001\u0000\u0000\u0011"+
		"\u0012\u0005\u000e\u0000\u0000\u0012\u0013\u0005\u0006\u0000\u0000\u0013"+
		"\u0014\u0003\u0000\u0000\u0000\u0014\u0015\u0005\u0002\u0000\u0000\u0015"+
		"\u0016\u0003\u0000\u0000\u0000\u0016\u0003\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0005\u0003\u0000\u0000\u0018\u0019\u0003\u0000\u0000\u0000\u0019"+
		"\u001a\u0005\u0004\u0000\u0000\u001a\u001b\u0003\u0000\u0000\u0000\u001b"+
		"\u001c\u0005\u0005\u0000\u0000\u001c\u001d\u0003\u0000\u0000\u0000\u001d"+
		"\u0005\u0001\u0000\u0000\u0000\u001e#\u0003\b\u0004\u0000\u001f \u0007"+
		"\u0000\u0000\u0000 \"\u0003\b\u0004\u0000!\u001f\u0001\u0000\u0000\u0000"+
		"\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000"+
		"\u0000$\u0007\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&+\u0003"+
		"\n\u0005\u0000\'(\u0007\u0001\u0000\u0000(*\u0003\n\u0005\u0000)\'\u0001"+
		"\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000"+
		"+,\u0001\u0000\u0000\u0000,\t\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000.E\u0005\r\u0000\u0000/E\u0005\u000e\u0000\u00000E\u0003\u0004\u0002"+
		"\u000012\u0005\u000b\u0000\u000023\u0003\u0000\u0000\u000034\u0005\f\u0000"+
		"\u00004E\u0001\u0000\u0000\u000056\u0005\u000b\u0000\u000067\u0005\u0003"+
		"\u0000\u000078\u0003\u0000\u0000\u000089\u0005\u0004\u0000\u00009:\u0003"+
		"\u0000\u0000\u0000:;\u0005\u0005\u0000\u0000;<\u0003\u0000\u0000\u0000"+
		"<=\u0005\f\u0000\u0000=E\u0001\u0000\u0000\u0000>?\u0005\u000b\u0000\u0000"+
		"?@\u0007\u0002\u0000\u0000@A\u0003\u0000\u0000\u0000AB\u0003\u0000\u0000"+
		"\u0000BC\u0005\f\u0000\u0000CE\u0001\u0000\u0000\u0000D.\u0001\u0000\u0000"+
		"\u0000D/\u0001\u0000\u0000\u0000D0\u0001\u0000\u0000\u0000D1\u0001\u0000"+
		"\u0000\u0000D5\u0001\u0000\u0000\u0000D>\u0001\u0000\u0000\u0000E\u000b"+
		"\u0001\u0000\u0000\u0000\u0004\u000e#+D";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}