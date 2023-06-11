/**
 * @author Shweta Kumari
 *2023-06-11
 */
package kumari.shweta.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortingUsingStack {

	public static Stack<Integer> sortUsingTwoStack(List<Integer> input) {

		Stack<Integer> tempStack = new Stack<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < input.size(); i++) {
			stack.push(input.get(i));
		}

		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (!tempStack.isEmpty() && temp < tempStack.peek()) {
				int poppedElement = tempStack.pop();
				stack.push(poppedElement);
			}
			tempStack.push(temp);
		}
		return tempStack;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 1, 7, 9);
		Stack<Integer> resStack = sortUsingTwoStack(list);
		System.out.println(resStack);
	}
}
