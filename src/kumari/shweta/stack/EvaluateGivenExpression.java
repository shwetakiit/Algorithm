/**
 * @author Shweta Kumari
 *2024-08-21
 */
package kumari.shweta.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 1.Convert in postfix. 
 * 2.Evaluate postfix expression.
 */
public class EvaluateGivenExpression {

	public int evaluatePostFix(List<Character> expression) {
		Stack<Integer> operand = new Stack<>();
		for (int i = 0; i < expression.size(); i++) {

			char ch = expression.get(i);

			switch (ch) {
			case '+':
				Integer operand2 = operand.pop();
				Integer operand1 = operand.pop();
				operand.push(operand1 + operand2);
				break;
			case '-':
				operand2 = operand.pop();
				operand1 = operand.pop();
				operand.push(operand1 - operand2);
				break;
			case '*':
				operand2 = operand.pop();
				operand1 = operand.pop();
				operand.push(operand1 * operand2);
				break;
			case '/':
				operand2 = operand.pop();
				operand1 = operand.pop();
				operand.push(operand1 / operand2);
				break;
			case '%':
				operand2 = operand.pop();
				operand1 = operand.pop();
				operand.push(operand1 % operand2);
				break;
			default:
				operand.push(Character.getNumericValue(ch));
				break;
			}
		}

		return operand.pop();

	}

	public List<Character> infixToPostFix(String str) {

		Stack<Character> stack = new Stack<>();
		List<Character> postfix = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			switch (ch) {

			case '(':
				stack.push(ch);

				break;

			case ')':

				if (!stack.isEmpty()) {
					char top;
					while ((top = stack.pop()) != '(') {
						postfix.add(top);
					}

				} else {
					System.out.println("Expression is invalid");
				}

				break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '^':
				while (!stack.isEmpty() && operatorPriority(stack.peek()) >= operatorPriority(ch)) {

					postfix.add(stack.pop());

				}
				stack.push(ch);
				break;
			default: // If an operand comes
				postfix.add(ch);
				break;
			}

		}
		while (!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
		System.out.println(postfix);
		return postfix;

	}

	public int operatorPriority(char symbol) {
		switch (symbol) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
		case '%':
			return 2;
		case '^':
			return 3;
		default:
			return 0; // If symbol is ()
		}

	}

	public static void main(String[] args) {
		EvaluateGivenExpression obj = new EvaluateGivenExpression();
		String str1 = "1+4*(4/2)-4*6";
		String str2 = "A^B*C/(D*E-F)";
		List<Character> postFixExp = obj.infixToPostFix(str1);
		int value = obj.evaluatePostFix(postFixExp);
		System.out.println("Postfix expression value " + value);

	}
}
