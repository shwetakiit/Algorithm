/**
 * @author Shweta Kumari
 *2023-06-10
 */
package kumari.shweta.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Find sum of (Max-Min) of all subarrays
 * Input -->  arr[] =[2,5,8] output ->8 
 */
public class FindSumOfMaxMinusMinOfSubArrays {

	/* Next smaller element in left hand side of input array element */
	public static List<Integer> nextSmallerElementIndexLeftSide(List<Integer> input) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.size(); i++) {
			while (!stack.isEmpty() && input.get(stack.peek()) > input.get(i)) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			stack.push(i);
		}
		return result;
	}

	/* Next smaller element in right hand side of input array element */
	public static List<Integer> nextSmallerElementIndexRightSide(List<Integer> input) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int size = input.size();
		for (int i = input.size() - 1; i >= 0; i--) {
			while (!stack.isEmpty() && input.get(stack.peek()) > input.get(i)) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result.add(size);
			} else {
				result.add(stack.peek());
			}
			stack.push(i);
		}
		Collections.reverse(result);
		return result;
	}

	/* Next greater element in left hand side of input array element */
	public static List<Integer> nextGreaterElementIndextLeftSide(List<Integer> input) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.size(); i++) {
			while (!stack.isEmpty() && input.get(stack.peek()) <= input.get(i)) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			stack.push(i);
		}
		return result;

	}

	/* Next greater element in right hand side of input array element */
	public static List<Integer> nextGreaterElementIndexRightSide(List<Integer> input) {
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int size = input.size();
		for (int i = input.size() - 1; i >= 0; i--) {
			while (!stack.isEmpty() && input.get(stack.peek()) <= input.get(i)) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result.add(size);
			} else {
				result.add(stack.peek());
			}
			stack.push(i);
		}
		Collections.reverse(result);
		return result;
	}

	public static int sumOfMaxMinusMin(List<Integer> input) {

		List<Integer> leftSmaller = nextSmallerElementIndexLeftSide(input);
		List<Integer> rightSmaller = nextSmallerElementIndexRightSide(input);
		List<Integer> leftGreater = nextGreaterElementIndextLeftSide(input);
		List<Integer> rightGreater = nextGreaterElementIndexRightSide(input);

		int size = input.size();
		int maxSum = 0;
		int minSum = 0;

		// Find sum of max element for all subarrays using contribution technique
		for (int i = 0; i < size; i++) {

			maxSum += input.get(i) * (i - leftGreater.get(i)) * (rightGreater.get(i) - i);
			minSum += input.get(i) * (i - leftSmaller.get(i)) * (rightSmaller.get(i) - i);

		}
		return maxSum - minSum;
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(4, 7, 3, 8);
		int result = sumOfMaxMinusMin(input);
		System.out.println("Sum of max-min of all subarrays " + result);

	}
}
