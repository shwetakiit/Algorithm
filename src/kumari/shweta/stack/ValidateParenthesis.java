/**
 * @author Shweta Kumari
 *2024-08-19
 */
package kumari.shweta.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Check whether given sequence of parenthesis is valid or not. input - "[]{}()"
 * --Valid "({)}" --Invalid ([{]) --Invalid
 *
 * Return true if parenthesis is valid otherwise false
 */
public class ValidateParenthesis {
	Map<Character, Character> map;

	public ValidateParenthesis() {
		map = new HashMap<>();
	}

	/**
	 * 
	 */
	private boolean validateParenthesis(String str) {

		Stack<Character> stack = new Stack<>();

		storeParethesisPair(map);

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') { // Opening parenthesis push in stack
				stack.push(ch);
			} else { // Closing parenthesis

				if (stack.size() == 0) {// Closing parenthesis is more than opening -invalid
					return false;
				} else if (map.get(ch) != stack.peek()) { // If opening parenthesis in stack is not same with closing
															// parenthesis
					return false;
				} else {
					stack.pop();
				}

			}

		}

		return stack.isEmpty();
	}

	private void storeParethesisPair(Map<Character, Character> map) {
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');
	}

	public static void main(String[] args) {
		// String str="[]{}()" ;
		String str = "([{])";
		ValidateParenthesis obj = new ValidateParenthesis();
		boolean isValid = obj.validateParenthesis(str);
		System.out.println("Is given parenthesis is valid ?" + isValid);
	}
}
