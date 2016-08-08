package org.deb;

/**
 * All chemical symbols must be exactly two letters, so B is not a valid symbol
 * for Boron.
 * 
 * Both letters in the symbol must appear in the element name, but the first
 * letter of the element name does not necessarily need to appear in the symbol.
 * So Hg is not valid for Mercury, but Cy is.
 * 
 * The two letters must appear in order in the element name. So Vr is valid for
 * Silver, but Rv is not. To be clear, both Ma and Am are valid for Magnesium,
 * because there is both an a that appears after an m, and an m that appears
 * after an a.
 * 
 * If the two letters in the symbol are the same, it must appear twice in the
 * element name. So Nn is valid for Xenon, but Xx and Oo are not.
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	/**
	 * 
	 * Write a function that, given two strings, one an element name and one a
	 * proposed symbol for that element, determines whether the symbol follows
	 * the rules. If you like, you may parse the program's input and output the
	 * result, but this is not necessary.
	 * 
	 * The symbol will have exactly two letters. Both element name and symbol
	 * will contain only the letters a-z. Both the element name and the symbol
	 * will have their first letter capitalized, with the rest lowercase.
	 * 
	 * @param elementName
	 *            Element name.
	 * @param symbol
	 *            proposed symbol
	 * @return true if the symbol follows the rule, false otherwise.
	 */
	public static boolean followsRule(String elementName, String symbol) {
		elementName = elementName.toLowerCase();
		symbol = symbol.toLowerCase();
		if (symbol.length() != 2){
			return false;
		}
		return elementName.indexOf(symbol.charAt(0)) < elementName.lastIndexOf(symbol.charAt(1));
	}
}
