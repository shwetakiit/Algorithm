/**
 * @author Shweta Kumari
 *2023-05-13
 */
package kumari.shweta.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /,% Each string may be an integer or an operator.
Input :  A =   ["2", "1", "+", "3", "*"] output  9 
Input :  A = ["4", "13", "5", "/", "+"] output 6
*/
public class EvalueExpresson {
	public static int evalRPN(List<String> A) {

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < A.size(); i++) {
			String str = A.get(i);
			switch (str) {
			case "+":
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				stack.push(operand1 + operand2);
				break;
			case "-":
				operand2 = stack.pop();
				operand1 = stack.pop();
				stack.push(operand1 - operand2);
				break;
			case "*":
				operand2 = stack.pop();
				operand1 = stack.pop();
				stack.push(operand1 * operand2);
				break;
			case "/":
				operand2 = stack.pop();
				operand1 = stack.pop();
				stack.push(operand1 / operand2);
				break;
			case "%":
				operand2 = stack.pop();
				operand1 = stack.pop();
				stack.push(operand1 % operand2);
				break;
			default:
				stack.push(Integer.valueOf(str));
				break;
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {

		List<String> input = Arrays.asList("2", "2", "/");
		int result = evalRPN(input);
		System.out.println("Evalued value is " + result);
	}
}
