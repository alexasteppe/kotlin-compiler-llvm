// Generated from KotlinLexerParser.g4 by ANTLR 4.10.1

import symtab.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KotlinLexerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUN=1, IF=2, ELSE=3, PRINT=4, PRINTLN=5, VAR=6, INT=7, STRING=8, RETURN=9, 
		READ=10, WHILE=11, ARRAY=12, ARRAYOF=13, DOT=14, COMMA=15, LPAREN=16, 
		RPAREN=17, LSQUARE=18, RSQUARE=19, LCURL=20, RCURL=21, MULT=22, DIV=23, 
		ADD=24, SUB=25, INCR=26, DECR=27, COLON=28, SEMICOLON=29, ASSIGNMENT=30, 
		LANGLE=31, RANGLE=32, LE=33, GE=34, EXCL_EQ=35, EQEQ=36, SINGLE_QUOTE=37, 
		Identifier=38, IntegerLiteral=39, CharacterLiteral=40, StringLiteral=41, 
		DelimitedComment=42, LineComment=43, WS=44, NL=45;
	public static final int
		RULE_start = 0, RULE_block = 1, RULE_statement = 2, RULE_re_assignment = 3, 
		RULE_print = 4, RULE_expr = 5, RULE_ifStatement = 6, RULE_while = 7, RULE_comparison = 8, 
		RULE_variableDeclaration = 9, RULE_arrayDeclaration = 10, RULE_type = 11, 
		RULE_functionArgument = 12, RULE_functionDefinition = 13, RULE_functionCall = 14, 
		RULE_returnStatement = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "block", "statement", "re_assignment", "print", "expr", "ifStatement", 
			"while", "comparison", "variableDeclaration", "arrayDeclaration", "type", 
			"functionArgument", "functionDefinition", "functionCall", "returnStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fun'", "'if'", "'else'", "'print'", "'println'", "'var'", "'Int'", 
			"'String'", "'return'", "'readLine'", "'while'", "'Array'", "'arrayOf'", 
			"'.'", "','", "'('", "')'", "'['", "']'", "'{'", "'}'", "'*'", "'/'", 
			"'+'", "'-'", "'++'", "'--'", "':'", "';'", "'='", "'<'", "'>'", "'<='", 
			"'>='", "'!='", "'=='", "'''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUN", "IF", "ELSE", "PRINT", "PRINTLN", "VAR", "INT", "STRING", 
			"RETURN", "READ", "WHILE", "ARRAY", "ARRAYOF", "DOT", "COMMA", "LPAREN", 
			"RPAREN", "LSQUARE", "RSQUARE", "LCURL", "RCURL", "MULT", "DIV", "ADD", 
			"SUB", "INCR", "DECR", "COLON", "SEMICOLON", "ASSIGNMENT", "LANGLE", 
			"RANGLE", "LE", "GE", "EXCL_EQ", "EQEQ", "SINGLE_QUOTE", "Identifier", 
			"IntegerLiteral", "CharacterLiteral", "StringLiteral", "DelimitedComment", 
			"LineComment", "WS", "NL"
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
	public String getGrammarFileName() { return "KotlinLexerParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KotlinLexerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode EOF() { return getToken(KotlinLexerParser.EOF, 0); }
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(32);
				functionDefinition();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
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

	public static class BlockContext extends ParserRuleContext {
		public Scope scope;
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
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUN) | (1L << IF) | (1L << PRINT) | (1L << VAR) | (1L << RETURN) | (1L << READ) | (1L << WHILE) | (1L << LPAREN) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
				{
				{
				setState(40);
				statement();
				}
				}
				setState(45);
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

	public static class StatementContext extends ParserRuleContext {
		public Re_assignmentContext re_assignment() {
			return getRuleContext(Re_assignmentContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode READ() { return getToken(KotlinLexerParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				re_assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				print();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				while_();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				functionDefinition();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				returnStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				functionCall();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(53);
				variableDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(54);
				arrayDeclaration();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(55);
				expr(0);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(56);
				comparison();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(57);
				match(READ);
				setState(58);
				match(LPAREN);
				setState(59);
				match(RPAREN);
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

	public static class Re_assignmentContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode Identifier() { return getToken(KotlinLexerParser.Identifier, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(KotlinLexerParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LSQUARE() { return getToken(KotlinLexerParser.LSQUARE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(KotlinLexerParser.IntegerLiteral, 0); }
		public TerminalNode RSQUARE() { return getToken(KotlinLexerParser.RSQUARE, 0); }
		public Re_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_re_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterRe_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitRe_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitRe_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Re_assignmentContext re_assignment() throws RecognitionException {
		Re_assignmentContext _localctx = new Re_assignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_re_assignment);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(Identifier);
				setState(63);
				match(ASSIGNMENT);
				setState(64);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(Identifier);
				setState(66);
				match(LSQUARE);
				setState(67);
				match(IntegerLiteral);
				setState(68);
				match(RSQUARE);
				setState(69);
				match(ASSIGNMENT);
				setState(70);
				expr(0);
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(KotlinLexerParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(KotlinLexerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KotlinLexerParser.COMMA, i);
		}
		public TerminalNode Identifier() { return getToken(KotlinLexerParser.Identifier, 0); }
		public TerminalNode LSQUARE() { return getToken(KotlinLexerParser.LSQUARE, 0); }
		public TerminalNode IntegerLiteral() { return getToken(KotlinLexerParser.IntegerLiteral, 0); }
		public TerminalNode RSQUARE() { return getToken(KotlinLexerParser.RSQUARE, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_print);
		int _la;
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(73);
				match(PRINT);
				setState(74);
				match(LPAREN);
				setState(75);
				expr(0);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(76);
					match(COMMA);
					setState(77);
					expr(0);
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				match(RPAREN);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(PRINT);
				setState(86);
				match(LPAREN);
				setState(87);
				match(Identifier);
				setState(88);
				match(LSQUARE);
				setState(89);
				match(IntegerLiteral);
				setState(90);
				match(RSQUARE);
				setState(91);
				match(RPAREN);
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

	public static class ExprContext extends ParserRuleContext {
		public Token oper;
		public TerminalNode IntegerLiteral() { return getToken(KotlinLexerParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(KotlinLexerParser.StringLiteral, 0); }
		public TerminalNode Identifier() { return getToken(KotlinLexerParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public TerminalNode READ() { return getToken(KotlinLexerParser.READ, 0); }
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public TerminalNode LSQUARE() { return getToken(KotlinLexerParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(KotlinLexerParser.RSQUARE, 0); }
		public TerminalNode MULT() { return getToken(KotlinLexerParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(KotlinLexerParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(KotlinLexerParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(KotlinLexerParser.SUB, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(95);
				match(IntegerLiteral);
				}
				break;
			case 2:
				{
				setState(96);
				match(StringLiteral);
				}
				break;
			case 3:
				{
				setState(97);
				match(Identifier);
				}
				break;
			case 4:
				{
				setState(98);
				match(LPAREN);
				setState(99);
				expr(0);
				setState(100);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(102);
				match(READ);
				setState(103);
				match(LPAREN);
				setState(104);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(105);
				while_();
				}
				break;
			case 7:
				{
				setState(106);
				match(Identifier);
				setState(107);
				match(LSQUARE);
				setState(108);
				match(IntegerLiteral);
				setState(109);
				match(RSQUARE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(113);
						((ExprContext)_localctx).oper = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((ExprContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(114);
						expr(10);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(116);
						((ExprContext)_localctx).oper = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(117);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(KotlinLexerParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public List<TerminalNode> LCURL() { return getTokens(KotlinLexerParser.LCURL); }
		public TerminalNode LCURL(int i) {
			return getToken(KotlinLexerParser.LCURL, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> RCURL() { return getTokens(KotlinLexerParser.RCURL); }
		public TerminalNode RCURL(int i) {
			return getToken(KotlinLexerParser.RCURL, i);
		}
		public TerminalNode ELSE() { return getToken(KotlinLexerParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(IF);
			setState(124);
			match(LPAREN);
			setState(125);
			comparison();
			setState(126);
			match(RPAREN);
			setState(127);
			match(LCURL);
			setState(128);
			block();
			setState(129);
			match(RCURL);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(130);
				match(ELSE);
				setState(131);
				match(LCURL);
				setState(132);
				block();
				setState(133);
				match(RCURL);
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

	public static class WhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(KotlinLexerParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public TerminalNode LCURL() { return getToken(KotlinLexerParser.LCURL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(KotlinLexerParser.RCURL, 0); }
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(WHILE);
			setState(138);
			match(LPAREN);
			setState(139);
			comparison();
			setState(140);
			match(RPAREN);
			setState(141);
			match(LCURL);
			setState(142);
			block();
			setState(143);
			match(RCURL);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GE() { return getToken(KotlinLexerParser.GE, 0); }
		public TerminalNode RANGLE() { return getToken(KotlinLexerParser.RANGLE, 0); }
		public TerminalNode LE() { return getToken(KotlinLexerParser.LE, 0); }
		public TerminalNode LANGLE() { return getToken(KotlinLexerParser.LANGLE, 0); }
		public TerminalNode EQEQ() { return getToken(KotlinLexerParser.EQEQ, 0); }
		public TerminalNode EXCL_EQ() { return getToken(KotlinLexerParser.EXCL_EQ, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comparison);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				expr(0);
				setState(146);
				match(GE);
				setState(147);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				expr(0);
				setState(150);
				match(RANGLE);
				setState(151);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				expr(0);
				setState(154);
				match(LE);
				setState(155);
				expr(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				expr(0);
				setState(158);
				match(LANGLE);
				setState(159);
				expr(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				expr(0);
				setState(162);
				match(EQEQ);
				setState(163);
				expr(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(165);
				expr(0);
				setState(166);
				match(EXCL_EQ);
				setState(167);
				expr(0);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(KotlinLexerParser.VAR, 0); }
		public TerminalNode Identifier() { return getToken(KotlinLexerParser.Identifier, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(KotlinLexerParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode READ() { return getToken(KotlinLexerParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(KotlinLexerParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(VAR);
			setState(172);
			match(Identifier);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(173);
				match(COLON);
				}
			}

			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==STRING) {
				{
				setState(176);
				type();
				}
			}

			setState(179);
			match(ASSIGNMENT);
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(180);
				expr(0);
				}
				break;
			case 2:
				{
				setState(181);
				match(READ);
				setState(182);
				match(LPAREN);
				setState(183);
				match(RPAREN);
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

	public static class ArrayDeclarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(KotlinLexerParser.VAR, 0); }
		public TerminalNode Identifier() { return getToken(KotlinLexerParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(KotlinLexerParser.COLON, 0); }
		public TerminalNode ARRAY() { return getToken(KotlinLexerParser.ARRAY, 0); }
		public TerminalNode LANGLE() { return getToken(KotlinLexerParser.LANGLE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RANGLE() { return getToken(KotlinLexerParser.RANGLE, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(KotlinLexerParser.ASSIGNMENT, 0); }
		public TerminalNode ARRAYOF() { return getToken(KotlinLexerParser.ARRAYOF, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public FunctionArgumentContext functionArgument() {
			return getRuleContext(FunctionArgumentContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(VAR);
			setState(187);
			match(Identifier);
			setState(188);
			match(COLON);
			setState(189);
			match(ARRAY);
			setState(190);
			match(LANGLE);
			setState(191);
			type();
			setState(192);
			match(RANGLE);
			setState(193);
			match(ASSIGNMENT);
			setState(194);
			match(ARRAYOF);
			setState(195);
			match(LPAREN);
			setState(196);
			functionArgument();
			setState(197);
			match(RPAREN);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(KotlinLexerParser.INT, 0); }
		public TerminalNode STRING() { return getToken(KotlinLexerParser.STRING, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class FunctionArgumentContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(KotlinLexerParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(KotlinLexerParser.Identifier, i);
		}
		public List<TerminalNode> COLON() { return getTokens(KotlinLexerParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(KotlinLexerParser.COLON, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(KotlinLexerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(KotlinLexerParser.COMMA, i);
		}
		public FunctionArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterFunctionArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitFunctionArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitFunctionArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentContext functionArgument() throws RecognitionException {
		FunctionArgumentContext _localctx = new FunctionArgumentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionArgument);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(201);
					match(Identifier);
					}
				}

				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(204);
					match(COLON);
					}
				}

				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT || _la==STRING) {
					{
					setState(207);
					type();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(218);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(210);
					match(Identifier);
					}
					break;
				case 2:
					{
					setState(211);
					expr(0);
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COLON) {
						{
						setState(212);
						match(COLON);
						}
					}

					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==INT || _la==STRING) {
						{
						setState(215);
						type();
						}
					}

					}
					break;
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(220);
					match(COMMA);
					setState(229);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						setState(221);
						match(Identifier);
						}
						break;
					case 2:
						{
						setState(222);
						expr(0);
						setState(224);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COLON) {
							{
							setState(223);
							match(COLON);
							}
						}

						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==INT || _la==STRING) {
							{
							setState(226);
							type();
							}
						}

						}
						break;
					}
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public Scope scope;
		public TerminalNode FUN() { return getToken(KotlinLexerParser.FUN, 0); }
		public TerminalNode Identifier() { return getToken(KotlinLexerParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public FunctionArgumentContext functionArgument() {
			return getRuleContext(FunctionArgumentContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public TerminalNode LCURL() { return getToken(KotlinLexerParser.LCURL, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(KotlinLexerParser.RCURL, 0); }
		public TerminalNode COLON() { return getToken(KotlinLexerParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(FUN);
			setState(239);
			match(Identifier);
			setState(240);
			match(LPAREN);
			setState(241);
			functionArgument();
			setState(242);
			match(RPAREN);
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(243);
				match(COLON);
				}
			}

			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==STRING) {
				{
				setState(246);
				type();
				}
			}

			setState(249);
			match(LCURL);
			setState(250);
			block();
			setState(251);
			match(RCURL);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(KotlinLexerParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(KotlinLexerParser.LPAREN, 0); }
		public FunctionArgumentContext functionArgument() {
			return getRuleContext(FunctionArgumentContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(KotlinLexerParser.RPAREN, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(Identifier);
			setState(254);
			match(LPAREN);
			setState(255);
			functionArgument();
			setState(256);
			match(RPAREN);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(KotlinLexerParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLexerParserListener ) ((KotlinLexerParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLexerParserVisitor ) return ((KotlinLexerParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(RETURN);
			setState(259);
			expr(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0106\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0005\u0001*\b\u0001\n\u0001\f\u0001-\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003H\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004O\b\u0004\n\u0004\f\u0004R\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004]\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005o\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"w\b\u0005\n\u0005\f\u0005z\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0088\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00aa"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0003\t\u00af\b\t\u0001\t\u0003\t\u00b2\b"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b9\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0003\f\u00cb\b\f\u0001"+
		"\f\u0003\f\u00ce\b\f\u0001\f\u0003\f\u00d1\b\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u00d6\b\f\u0001\f\u0003\f\u00d9\b\f\u0003\f\u00db\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00e1\b\f\u0001\f\u0003\f\u00e4\b\f\u0003"+
		"\f\u00e6\b\f\u0005\f\u00e8\b\f\n\f\f\f\u00eb\t\f\u0003\f\u00ed\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00f5\b\r\u0001\r\u0003"+
		"\r\u00f8\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0000\u0001\n\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0003\u0001\u0000\u0016\u0017"+
		"\u0001\u0000\u0018\u0019\u0001\u0000\u0007\b\u0123\u0000#\u0001\u0000"+
		"\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004<\u0001\u0000\u0000\u0000"+
		"\u0006G\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\nn\u0001\u0000"+
		"\u0000\u0000\f{\u0001\u0000\u0000\u0000\u000e\u0089\u0001\u0000\u0000"+
		"\u0000\u0010\u00a9\u0001\u0000\u0000\u0000\u0012\u00ab\u0001\u0000\u0000"+
		"\u0000\u0014\u00ba\u0001\u0000\u0000\u0000\u0016\u00c7\u0001\u0000\u0000"+
		"\u0000\u0018\u00ec\u0001\u0000\u0000\u0000\u001a\u00ee\u0001\u0000\u0000"+
		"\u0000\u001c\u00fd\u0001\u0000\u0000\u0000\u001e\u0102\u0001\u0000\u0000"+
		"\u0000 \"\u0003\u001a\r\u0000! \u0001\u0000\u0000\u0000\"%\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001"+
		"\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&\'\u0005\u0000\u0000\u0001"+
		"\'\u0001\u0001\u0000\u0000\u0000(*\u0003\u0004\u0002\u0000)(\u0001\u0000"+
		"\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000.=\u0003\u0006\u0003\u0000/=\u0003\b\u0004\u00000=\u0003\f\u0006"+
		"\u00001=\u0003\u000e\u0007\u00002=\u0003\u001a\r\u00003=\u0003\u001e\u000f"+
		"\u00004=\u0003\u001c\u000e\u00005=\u0003\u0012\t\u00006=\u0003\u0014\n"+
		"\u00007=\u0003\n\u0005\u00008=\u0003\u0010\b\u00009:\u0005\n\u0000\u0000"+
		":;\u0005\u0010\u0000\u0000;=\u0005\u0011\u0000\u0000<.\u0001\u0000\u0000"+
		"\u0000</\u0001\u0000\u0000\u0000<0\u0001\u0000\u0000\u0000<1\u0001\u0000"+
		"\u0000\u0000<2\u0001\u0000\u0000\u0000<3\u0001\u0000\u0000\u0000<4\u0001"+
		"\u0000\u0000\u0000<5\u0001\u0000\u0000\u0000<6\u0001\u0000\u0000\u0000"+
		"<7\u0001\u0000\u0000\u0000<8\u0001\u0000\u0000\u0000<9\u0001\u0000\u0000"+
		"\u0000=\u0005\u0001\u0000\u0000\u0000>?\u0005&\u0000\u0000?@\u0005\u001e"+
		"\u0000\u0000@H\u0003\n\u0005\u0000AB\u0005&\u0000\u0000BC\u0005\u0012"+
		"\u0000\u0000CD\u0005\'\u0000\u0000DE\u0005\u0013\u0000\u0000EF\u0005\u001e"+
		"\u0000\u0000FH\u0003\n\u0005\u0000G>\u0001\u0000\u0000\u0000GA\u0001\u0000"+
		"\u0000\u0000H\u0007\u0001\u0000\u0000\u0000IJ\u0005\u0004\u0000\u0000"+
		"JK\u0005\u0010\u0000\u0000KP\u0003\n\u0005\u0000LM\u0005\u000f\u0000\u0000"+
		"MO\u0003\n\u0005\u0000NL\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000"+
		"\u0000RP\u0001\u0000\u0000\u0000ST\u0005\u0011\u0000\u0000T]\u0001\u0000"+
		"\u0000\u0000UV\u0005\u0004\u0000\u0000VW\u0005\u0010\u0000\u0000WX\u0005"+
		"&\u0000\u0000XY\u0005\u0012\u0000\u0000YZ\u0005\'\u0000\u0000Z[\u0005"+
		"\u0013\u0000\u0000[]\u0005\u0011\u0000\u0000\\I\u0001\u0000\u0000\u0000"+
		"\\U\u0001\u0000\u0000\u0000]\t\u0001\u0000\u0000\u0000^_\u0006\u0005\uffff"+
		"\uffff\u0000_o\u0005\'\u0000\u0000`o\u0005)\u0000\u0000ao\u0005&\u0000"+
		"\u0000bc\u0005\u0010\u0000\u0000cd\u0003\n\u0005\u0000de\u0005\u0011\u0000"+
		"\u0000eo\u0001\u0000\u0000\u0000fg\u0005\n\u0000\u0000gh\u0005\u0010\u0000"+
		"\u0000ho\u0005\u0011\u0000\u0000io\u0003\u000e\u0007\u0000jk\u0005&\u0000"+
		"\u0000kl\u0005\u0012\u0000\u0000lm\u0005\'\u0000\u0000mo\u0005\u0013\u0000"+
		"\u0000n^\u0001\u0000\u0000\u0000n`\u0001\u0000\u0000\u0000na\u0001\u0000"+
		"\u0000\u0000nb\u0001\u0000\u0000\u0000nf\u0001\u0000\u0000\u0000ni\u0001"+
		"\u0000\u0000\u0000nj\u0001\u0000\u0000\u0000ox\u0001\u0000\u0000\u0000"+
		"pq\n\t\u0000\u0000qr\u0007\u0000\u0000\u0000rw\u0003\n\u0005\nst\n\b\u0000"+
		"\u0000tu\u0007\u0001\u0000\u0000uw\u0003\n\u0005\tvp\u0001\u0000\u0000"+
		"\u0000vs\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000y\u000b\u0001\u0000\u0000\u0000"+
		"zx\u0001\u0000\u0000\u0000{|\u0005\u0002\u0000\u0000|}\u0005\u0010\u0000"+
		"\u0000}~\u0003\u0010\b\u0000~\u007f\u0005\u0011\u0000\u0000\u007f\u0080"+
		"\u0005\u0014\u0000\u0000\u0080\u0081\u0003\u0002\u0001\u0000\u0081\u0087"+
		"\u0005\u0015\u0000\u0000\u0082\u0083\u0005\u0003\u0000\u0000\u0083\u0084"+
		"\u0005\u0014\u0000\u0000\u0084\u0085\u0003\u0002\u0001\u0000\u0085\u0086"+
		"\u0005\u0015\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0082"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\r\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005\u000b\u0000\u0000\u008a\u008b\u0005"+
		"\u0010\u0000\u0000\u008b\u008c\u0003\u0010\b\u0000\u008c\u008d\u0005\u0011"+
		"\u0000\u0000\u008d\u008e\u0005\u0014\u0000\u0000\u008e\u008f\u0003\u0002"+
		"\u0001\u0000\u008f\u0090\u0005\u0015\u0000\u0000\u0090\u000f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0003\n\u0005\u0000\u0092\u0093\u0005\"\u0000"+
		"\u0000\u0093\u0094\u0003\n\u0005\u0000\u0094\u00aa\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0003\n\u0005\u0000\u0096\u0097\u0005 \u0000\u0000\u0097"+
		"\u0098\u0003\n\u0005\u0000\u0098\u00aa\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0003\n\u0005\u0000\u009a\u009b\u0005!\u0000\u0000\u009b\u009c\u0003"+
		"\n\u0005\u0000\u009c\u00aa\u0001\u0000\u0000\u0000\u009d\u009e\u0003\n"+
		"\u0005\u0000\u009e\u009f\u0005\u001f\u0000\u0000\u009f\u00a0\u0003\n\u0005"+
		"\u0000\u00a0\u00aa\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\n\u0005\u0000"+
		"\u00a2\u00a3\u0005$\u0000\u0000\u00a3\u00a4\u0003\n\u0005\u0000\u00a4"+
		"\u00aa\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003\n\u0005\u0000\u00a6\u00a7"+
		"\u0005#\u0000\u0000\u00a7\u00a8\u0003\n\u0005\u0000\u00a8\u00aa\u0001"+
		"\u0000\u0000\u0000\u00a9\u0091\u0001\u0000\u0000\u0000\u00a9\u0095\u0001"+
		"\u0000\u0000\u0000\u00a9\u0099\u0001\u0000\u0000\u0000\u00a9\u009d\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a1\u0001\u0000\u0000\u0000\u00a9\u00a5\u0001"+
		"\u0000\u0000\u0000\u00aa\u0011\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"\u0006\u0000\u0000\u00ac\u00ae\u0005&\u0000\u0000\u00ad\u00af\u0005\u001c"+
		"\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0\u00b2\u0003\u0016"+
		"\u000b\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b8\u0005\u001e"+
		"\u0000\u0000\u00b4\u00b9\u0003\n\u0005\u0000\u00b5\u00b6\u0005\n\u0000"+
		"\u0000\u00b6\u00b7\u0005\u0010\u0000\u0000\u00b7\u00b9\u0005\u0011\u0000"+
		"\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b9\u0013\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0006\u0000"+
		"\u0000\u00bb\u00bc\u0005&\u0000\u0000\u00bc\u00bd\u0005\u001c\u0000\u0000"+
		"\u00bd\u00be\u0005\f\u0000\u0000\u00be\u00bf\u0005\u001f\u0000\u0000\u00bf"+
		"\u00c0\u0003\u0016\u000b\u0000\u00c0\u00c1\u0005 \u0000\u0000\u00c1\u00c2"+
		"\u0005\u001e\u0000\u0000\u00c2\u00c3\u0005\r\u0000\u0000\u00c3\u00c4\u0005"+
		"\u0010\u0000\u0000\u00c4\u00c5\u0003\u0018\f\u0000\u00c5\u00c6\u0005\u0011"+
		"\u0000\u0000\u00c6\u0015\u0001\u0000\u0000\u0000\u00c7\u00c8\u0007\u0002"+
		"\u0000\u0000\u00c8\u0017\u0001\u0000\u0000\u0000\u00c9\u00cb\u0005&\u0000"+
		"\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ce\u0005\u001c\u0000"+
		"\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00d1\u0003\u0016\u000b"+
		"\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00ed\u0001\u0000\u0000\u0000\u00d2\u00db\u0005&\u0000\u0000"+
		"\u00d3\u00d5\u0003\n\u0005\u0000\u00d4\u00d6\u0005\u001c\u0000\u0000\u00d5"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d9\u0003\u0016\u000b\u0000\u00d8"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00db\u0001\u0000\u0000\u0000\u00da\u00d2\u0001\u0000\u0000\u0000\u00da"+
		"\u00d3\u0001\u0000\u0000\u0000\u00db\u00e9\u0001\u0000\u0000\u0000\u00dc"+
		"\u00e5\u0005\u000f\u0000\u0000\u00dd\u00e6\u0005&\u0000\u0000\u00de\u00e0"+
		"\u0003\n\u0005\u0000\u00df\u00e1\u0005\u001c\u0000\u0000\u00e0\u00df\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e4\u0003\u0016\u000b\u0000\u00e3\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e5\u00dd\u0001\u0000\u0000\u0000\u00e5\u00de\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00dc\u0001"+
		"\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ca\u0001"+
		"\u0000\u0000\u0000\u00ec\u00da\u0001\u0000\u0000\u0000\u00ed\u0019\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ef\u0005\u0001\u0000\u0000\u00ef\u00f0\u0005"+
		"&\u0000\u0000\u00f0\u00f1\u0005\u0010\u0000\u0000\u00f1\u00f2\u0003\u0018"+
		"\f\u0000\u00f2\u00f4\u0005\u0011\u0000\u0000\u00f3\u00f5\u0005\u001c\u0000"+
		"\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f8\u0003\u0016\u000b"+
		"\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\u0014\u0000"+
		"\u0000\u00fa\u00fb\u0003\u0002\u0001\u0000\u00fb\u00fc\u0005\u0015\u0000"+
		"\u0000\u00fc\u001b\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005&\u0000\u0000"+
		"\u00fe\u00ff\u0005\u0010\u0000\u0000\u00ff\u0100\u0003\u0018\f\u0000\u0100"+
		"\u0101\u0005\u0011\u0000\u0000\u0101\u001d\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0005\t\u0000\u0000\u0103\u0104\u0003\n\u0005\u0000\u0104\u001f"+
		"\u0001\u0000\u0000\u0000\u001b#+<GP\\nvx\u0087\u00a9\u00ae\u00b1\u00b8"+
		"\u00ca\u00cd\u00d0\u00d5\u00d8\u00da\u00e0\u00e3\u00e5\u00e9\u00ec\u00f4"+
		"\u00f7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}