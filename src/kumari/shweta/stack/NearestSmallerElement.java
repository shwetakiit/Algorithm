/**
 * @author Shweta Kumari
 *2023-05-20
 */
package kumari.shweta.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/*For given array find nearest smaller  element in left hand side . Eg arr[]={4, 6, 10, 11, 7, 6, 3, 5}
 *If  there is no nearest smaller element in left hand side use default value -1
 *Output --> [-1, 4, 6, 10, 6, 4, -1, 3]
 */

public class NearestSmallerElement {
	/*
	 * Brute force approach TC-> O(N^2) SC-> O(1)
	 */
	public static List<Integer> prevSmallerBF(List<Integer> input) {

		List<Integer> result = new ArrayList<>(input.size());
		result.add(-1);
		for (int i = 1; i < input.size(); i++) {
			boolean found = false;
			for (int j = i - 1; j >= 0; j--) {
				if (input.get(j) < input.get(i)) {
					result.add(input.get(j));
					found = true;
					break;
				}
			}
			if (!found) {
				result.add(-1);
			}
		}

		return result;
	}
	
	//TC ->O(n) SC -> O(n)
	public static List<Integer> prevSmaller(List<Integer> input) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>(input.size());

		for (int i = 0; i < input.size(); i++) {
			// Pop all greater than equal element from stack
			while (!stack.isEmpty() && (stack.peek() >= input.get(i))) {
				stack.pop();
			}
			// Update result
			if (stack.isEmpty() == true) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			//Push element in stack
			stack.push(input.get(i));
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(4, 6, 10, 11, 7, 6, 3, 5);
		List<Integer> result = prevSmaller(input);
		System.out.println("Corresponding nearest element for each element " + result);
		List<Integer> bfResult = prevSmallerBF(input);
		System.out.println("Corresponding nearest element for each element  "+bfResult);
	}
}
