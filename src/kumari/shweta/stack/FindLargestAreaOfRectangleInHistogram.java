/**
 * @author Shweta Kumari
 *2023-06-05
 */
package kumari.shweta.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the i'th histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000000
input  A = [2, 1, 5, 6, 2, 3] output 10 
input A = [2,1,4,7,5,2,1,3,4,5,6,4,3,2,3,1,5,6,4,2] output 20 
*/

//TC O(N) , SC O(N)
public class FindLargestAreaOfRectangleInHistogram {

	List<Integer> leftSmaller;
	List<Integer> rightSmaller;

	FindLargestAreaOfRectangleInHistogram() {
		leftSmaller = new ArrayList<>();
		rightSmaller = new ArrayList<>();
	}

	public List<Integer> findLeftSmaller(List<Integer> input) {

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.size(); i++) {
			while (!stack.isEmpty() && (input.get(stack.peek()) >= input.get(i))) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				/*
				 * If element is first element in input list so index for that element is 0 so
				 * next left side element index would be -1
				 */
				leftSmaller.add(-1);
			} else {
				leftSmaller.add(stack.peek());
			}
			stack.push(i);
		}
		return leftSmaller;

	}

	public List<Integer> findRightSmaller(List<Integer> input) {

		Stack<Integer> stack = new Stack<>();
		for (int i = input.size() - 1; i >= 0; i--) {
			while (!stack.isEmpty() && (input.get(stack.peek()) >= input.get(i))) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				/*
				 * For last element of input --There is no right side element but what should be
				 * index of right smaller element ? index of next smaller element should be
				 * input.size() element should be input.size()
				 */
				rightSmaller.add(input.size());
			} else {
				rightSmaller.add(stack.peek());
			}
			stack.push(i);
		}
		Collections.reverse(rightSmaller);
		return rightSmaller;

	}

	public int largestArea(List<Integer> heightOfHistograms) {
		findLeftSmaller(heightOfHistograms);
		findRightSmaller(heightOfHistograms);
		int result = 0;
		for (int i = 0; i < heightOfHistograms.size(); i++) {
			int heightOfHistogram = heightOfHistograms.get(i);
			int maxWidthPossible = heightOfHistogram * (rightSmaller.get(i) - leftSmaller.get(i) - 1);
			result = Math.max(result, maxWidthPossible);
		}
		return result;
	}

	public static void main(String[] args) {

		FindLargestAreaOfRectangleInHistogram largestArea = new FindLargestAreaOfRectangleInHistogram();
		List<Integer> heightOfHistograms = Arrays.asList(2, 1, 4, 7, 5, 2, 1, 3, 4, 5, 6, 4, 3, 2, 3, 1, 5, 6, 4, 2);
		// List<Integer> heightOfHistograms = Arrays.asList(2, 1, 5, 6, 2, 3);
		int area = largestArea.largestArea(heightOfHistograms);
		System.out.println("Area is " + area);
	}
}
