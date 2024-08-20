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

	private boolean validateParenthesis(String str) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') { // Opening parenthesis push in stack
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') { // Closing parenthesis

				if (stack.size() == 0) {// Closing parenthesis is more than opening -invalid
					return false;
				} else { // If opening parenthesis in stack is not same with closing parenthesis

					char temp = stack.pop();

					if (!matchParethesisPair(ch, temp)) { // If matching is true then we need to iterate till last
															// expression .
						return false;
					}
				}

			}

		}

		return stack.isEmpty();
	}

	private boolean matchParethesisPair(char element, char top) {

		if (top == '(' && element == ')') {
			return true;
		}
		if (top == '{' && element == '}') {
			return true;
		}
		if (top == '[' && element == ']') {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		String str1 = "[]{}()";
		String str2 = "([{])";
		String str3 = "[A/(B-C)*D]";
		String str4="A*(B-C)}+D";
		String str5 ="[A+B-(C%D}]";
		
		ValidateParenthesis obj = new ValidateParenthesis();
		boolean isValid = obj.validateParenthesis(str5);
		System.out.println("Is given parenthesis is valid ?" + isValid);
	}
}
