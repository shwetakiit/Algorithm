/**
 * 
 */
package kumari.shweta.stack;

import java.util.Stack;

/**
 * @author skumari
 *
 */

public class StringValidation {

	private String givenString;

	public StringValidation(String StringValidation) {

		givenString = StringValidation;

	}

	public boolean Validate() {

		boolean result = true;
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < givenString.length(); i++) {

			Character currentString = this.givenString.charAt(i);
			if (currentString == '(' || currentString == '[' || currentString == '{') {

				stack.push(currentString);
			} else if (currentString == ')' || currentString == ']' || currentString == '}')
		     	{
				if (stack.isEmpty()) {
					result = false;
				} else {
					Character previous = stack.peek();
					if ((previous == '(' && currentString == ')') || (previous == '[' && currentString == ']')
							|| (previous == '{' && currentString == '}')) {
						stack.pop();

					} else {
						result = false;
					}

				}
		} 
		
		
		}
		if(!stack.isEmpty()) {
			result=false;
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println("Enter String");
		java.util.Scanner sc = new java.util.Scanner(System.in);

		String string = sc.nextLine();
		StringValidation obj = new StringValidation(string);
		obj.Validate();
		System.out.println("Is it valaid Straing" + obj.Validate());

	}

}
