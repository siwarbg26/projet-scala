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
		LET=1, IN=2, FUN=3, ARROW=4, IFZ=5, THEN=6, ELSE=7, EQUALS=8, PLUS=9, 
		MINUS=10, TIMES=11, DIV=12, LPAR=13, RPAR=14, NUMBER=15, ID=16, WS=17;
	public static final int
		RULE_term = 0, RULE_letExp = 1, RULE_funExp = 2, RULE_ifzExp = 3, RULE_addSub = 4, 
		RULE_app = 5, RULE_mulDiv = 6, RULE_primary = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"term", "letExp", "funExp", "ifzExp", "addSub", "app", "mulDiv", "primary"
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
		public FunExpContext funExp() {
			return getRuleContext(FunExpContext.class,0);
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
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				letExp();
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				funExp();
				}
				break;
			case IFZ:
			case LPAR:
			case NUMBER:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(18);
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
			setState(21);
			match(LET);
			setState(22);
			match(ID);
			setState(23);
			match(EQUALS);
			setState(24);
			term();
			setState(25);
			match(IN);
			setState(26);
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
	public static class FunExpContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(PCFParser.FUN, 0); }
		public TerminalNode ID() { return getToken(PCFParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(PCFParser.ARROW, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FunExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterFunExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitFunExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitFunExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunExpContext funExp() throws RecognitionException {
		FunExpContext _localctx = new FunExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(FUN);
			setState(29);
			match(ID);
			setState(30);
			match(ARROW);
			setState(31);
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
		enterRule(_localctx, 6, RULE_ifzExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(IFZ);
			setState(34);
			term();
			setState(35);
			match(THEN);
			setState(36);
			term();
			setState(37);
			match(ELSE);
			setState(38);
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
		public List<AppContext> app() {
			return getRuleContexts(AppContext.class);
		}
		public AppContext app(int i) {
			return getRuleContext(AppContext.class,i);
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
		enterRule(_localctx, 8, RULE_addSub);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			app();
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(41);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(42);
					app();
					}
					} 
				}
				setState(47);
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
	public static class AppContext extends ParserRuleContext {
		public List<MulDivContext> mulDiv() {
			return getRuleContexts(MulDivContext.class);
		}
		public MulDivContext mulDiv(int i) {
			return getRuleContext(MulDivContext.class,i);
		}
		public AppContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_app; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitApp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitApp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppContext app() throws RecognitionException {
		AppContext _localctx = new AppContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_app);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			mulDiv();
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					mulDiv();
					}
					} 
				}
				setState(54);
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
		enterRule(_localctx, 12, RULE_mulDiv);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			primary();
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56);
					_la = _input.LA(1);
					if ( !(_la==TIMES || _la==DIV) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(57);
					primary();
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
		enterRule(_localctx, 14, RULE_primary);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				ifzExp();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				match(LPAR);
				setState(67);
				term();
				setState(68);
				match(RPAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(LPAR);
				setState(71);
				match(IFZ);
				setState(72);
				term();
				setState(73);
				match(THEN);
				setState(74);
				term();
				setState(75);
				match(ELSE);
				setState(76);
				term();
				setState(77);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				match(LPAR);
				setState(80);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7680L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(81);
				term();
				setState(82);
				term();
				setState(83);
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
		"\u0004\u0001\u0011X\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0014\b\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004,\b\u0004\n\u0004\f\u0004/\t"+
		"\u0004\u0001\u0005\u0001\u0005\u0005\u00053\b\u0005\n\u0005\f\u00056\t"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006;\b\u0006\n\u0006"+
		"\f\u0006>\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007V\b\u0007\u0001\u0007\u0000\u0000\b\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0000\u0003\u0001\u0000\t\n\u0001\u0000\u000b\f\u0001\u0000\t"+
		"\fY\u0000\u0013\u0001\u0000\u0000\u0000\u0002\u0015\u0001\u0000\u0000"+
		"\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006!\u0001\u0000\u0000\u0000"+
		"\b(\u0001\u0000\u0000\u0000\n0\u0001\u0000\u0000\u0000\f7\u0001\u0000"+
		"\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010\u0014\u0003\u0002\u0001"+
		"\u0000\u0011\u0014\u0003\u0004\u0002\u0000\u0012\u0014\u0003\b\u0004\u0000"+
		"\u0013\u0010\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000"+
		"\u0013\u0012\u0001\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005\u0001\u0000\u0000\u0016\u0017\u0005\u0010\u0000\u0000"+
		"\u0017\u0018\u0005\b\u0000\u0000\u0018\u0019\u0003\u0000\u0000\u0000\u0019"+
		"\u001a\u0005\u0002\u0000\u0000\u001a\u001b\u0003\u0000\u0000\u0000\u001b"+
		"\u0003\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0003\u0000\u0000\u001d"+
		"\u001e\u0005\u0010\u0000\u0000\u001e\u001f\u0005\u0004\u0000\u0000\u001f"+
		" \u0003\u0000\u0000\u0000 \u0005\u0001\u0000\u0000\u0000!\"\u0005\u0005"+
		"\u0000\u0000\"#\u0003\u0000\u0000\u0000#$\u0005\u0006\u0000\u0000$%\u0003"+
		"\u0000\u0000\u0000%&\u0005\u0007\u0000\u0000&\'\u0003\u0000\u0000\u0000"+
		"\'\u0007\u0001\u0000\u0000\u0000(-\u0003\n\u0005\u0000)*\u0007\u0000\u0000"+
		"\u0000*,\u0003\n\u0005\u0000+)\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\t\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u000004\u0003\f\u0006\u000013\u0003\f"+
		"\u0006\u000021\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u000045\u0001\u0000\u0000\u00005\u000b\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u00007<\u0003\u000e\u0007\u000089\u0007\u0001"+
		"\u0000\u00009;\u0003\u000e\u0007\u0000:8\u0001\u0000\u0000\u0000;>\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=\r\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?V\u0005\u000f\u0000"+
		"\u0000@V\u0005\u0010\u0000\u0000AV\u0003\u0006\u0003\u0000BC\u0005\r\u0000"+
		"\u0000CD\u0003\u0000\u0000\u0000DE\u0005\u000e\u0000\u0000EV\u0001\u0000"+
		"\u0000\u0000FG\u0005\r\u0000\u0000GH\u0005\u0005\u0000\u0000HI\u0003\u0000"+
		"\u0000\u0000IJ\u0005\u0006\u0000\u0000JK\u0003\u0000\u0000\u0000KL\u0005"+
		"\u0007\u0000\u0000LM\u0003\u0000\u0000\u0000MN\u0005\u000e\u0000\u0000"+
		"NV\u0001\u0000\u0000\u0000OP\u0005\r\u0000\u0000PQ\u0007\u0002\u0000\u0000"+
		"QR\u0003\u0000\u0000\u0000RS\u0003\u0000\u0000\u0000ST\u0005\u000e\u0000"+
		"\u0000TV\u0001\u0000\u0000\u0000U?\u0001\u0000\u0000\u0000U@\u0001\u0000"+
		"\u0000\u0000UA\u0001\u0000\u0000\u0000UB\u0001\u0000\u0000\u0000UF\u0001"+
		"\u0000\u0000\u0000UO\u0001\u0000\u0000\u0000V\u000f\u0001\u0000\u0000"+
		"\u0000\u0005\u0013-4<U";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}