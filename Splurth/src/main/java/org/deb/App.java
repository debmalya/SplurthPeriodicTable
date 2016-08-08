package org.deb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

		boolean a2zOnlyElementName = elementName.matches("[a-z]*");
		boolean a2zOnlySymbolName = symbol.matches("[a-z][a-z]");

		// a-z letter only
		if (!a2zOnlyElementName || !a2zOnlySymbolName) {
			return false;
		}

		// All chemical symbols must be exactly two letters.
		if (symbol.length() != 2) {
			return false;
		}

		// Checking whether first character exists or not.
		char firstChar = symbol.charAt(0);
		if (elementName.indexOf(firstChar) == -1) {
			return false;
		}

		// two letters must appear in order in the element name
		return elementName.indexOf(firstChar) < elementName.lastIndexOf(symbol
				.charAt(1));
	}

	/**
	 * Given an element name, find the valid symbol for that name that's first
	 * in alphabetical order.
	 * 
	 * @param elementName
	 * @return valid symbol which's first in alphabetical order.
	 */
	public static String findValidSymbol(String elementName) {
		List<String> allPossibleSymbols = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elementName.length() - 1; i++) {

			for (int j = i + 1; j < elementName.length(); j++) {

				sb.append(Character.toUpperCase(elementName.charAt(i)));
				sb.append(Character.toLowerCase(elementName.charAt(j)));
				allPossibleSymbols.add(sb.toString());
				sb.delete(0, 2);
			}
		}
		String[] symbols = allPossibleSymbols.toArray(new String[0]);
		Arrays.sort(symbols);
		return symbols[0];
	}

	/**
	 * Given an element name, find the number of distinct valid symbols for that
	 * name.
	 * 
	 * @param elementName
	 * @return valid symbol which's first in alphabetical order.
	 */
	public static int countDistinctSymbol(String elementName) {
		Set<String> allPossibleSymbols = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < elementName.length() - 1; i++) {

			for (int j = i + 1; j < elementName.length(); j++) {
				sb.append(Character.toUpperCase(elementName.charAt(i)));
				sb.append(Character.toLowerCase(elementName.charAt(j)));
				allPossibleSymbols.add(sb.toString());
				sb.delete(0, 2);
			}
		}

		return allPossibleSymbols.size();
	}
}
