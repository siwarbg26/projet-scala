// Generated from C:/Users/siwar/Desktop/compil tp/TP1-3_Final/src/parserANTLR/PCF.g4 by ANTLR 4.13.2
package parserANTLR;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PCFParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PCFVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PCFParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PCFParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCFParser#parExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExp(PCFParser.ParExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCFParser#ifzExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfzExp(PCFParser.IfzExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCFParser#letExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExp(PCFParser.LetExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCFParser#prefixBinary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixBinary(PCFParser.PrefixBinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCFParser#parInfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParInfix(PCFParser.ParInfixContext ctx);
}