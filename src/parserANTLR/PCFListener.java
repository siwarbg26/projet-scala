// Generated from C:/Users/siwar/Desktop/compil tp/TP1-3_Final/src/parserANTLR/PCF.g4 by ANTLR 4.13.2
package parserANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PCFParser}.
 */
public interface PCFListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PCFParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCFParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PCFParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCFParser#parExp}.
	 * @param ctx the parse tree
	 */
	void enterParExp(PCFParser.ParExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCFParser#parExp}.
	 * @param ctx the parse tree
	 */
	void exitParExp(PCFParser.ParExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCFParser#ifzExp}.
	 * @param ctx the parse tree
	 */
	void enterIfzExp(PCFParser.IfzExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCFParser#ifzExp}.
	 * @param ctx the parse tree
	 */
	void exitIfzExp(PCFParser.IfzExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCFParser#letExp}.
	 * @param ctx the parse tree
	 */
	void enterLetExp(PCFParser.LetExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCFParser#letExp}.
	 * @param ctx the parse tree
	 */
	void exitLetExp(PCFParser.LetExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCFParser#prefixBinary}.
	 * @param ctx the parse tree
	 */
	void enterPrefixBinary(PCFParser.PrefixBinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCFParser#prefixBinary}.
	 * @param ctx the parse tree
	 */
	void exitPrefixBinary(PCFParser.PrefixBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCFParser#parInfix}.
	 * @param ctx the parse tree
	 */
	void enterParInfix(PCFParser.ParInfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCFParser#parInfix}.
	 * @param ctx the parse tree
	 */
	void exitParInfix(PCFParser.ParInfixContext ctx);
}