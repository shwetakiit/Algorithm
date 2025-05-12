/**
 * @author Shweta Kumari
 *2025-05-11
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.PriorityQueue;

/*
Problem Description
Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.
Problem Constraints

1 <= N <= 10^4
0 <= B <= 10^4
1 <= A[i] <= 10^4
Input Format

The first argument is an integer array A.
The second argument is an integer B.
Output Format
Return an integer denoting the minimum possible largest element after B operations.
Example Input
Input 1:
 A = [1, 2, 3, 4] 
 B = 3
Input 2:
 A = [5, 1, 4, 2] 
 B = 5
Example Output
Output 1: 4
Output 2: 5
*/

class Pair1 {

	int value;
	int index;

	Pair1(int value, int index) {
		this.value = value;
		this.index = index;
	}

}

public class MinimumLargestElement {

	/**
	 * @param list
	 * @param B
	 */
	private static int findMinimumLargestElement(ArrayList<Integer> list, int B) {

		int N = list.size();
		ArrayList<Integer> currentState = (ArrayList<Integer>) list.clone();
		PriorityQueue<Pair1> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
		for (int i = 0; i < N; i++) {
			pq.add(new Pair1(list.get(i) + list.get(i), i));
		}

		while (B > 0) {
			if (pq.isEmpty())
				return -1;

			Pair1 minPair = pq.poll();
			currentState.set(minPair.index, currentState.get(minPair.index) + list.get(minPair.index));
			pq.add(new Pair1(currentState.get(minPair.index) + list.get(minPair.index), minPair.index));
			B--;
		}

		int minMaxElement = Integer.MIN_VALUE;
		for (int j = 0; j < N; j++) {
			minMaxElement = Math.max(minMaxElement, currentState.get(j));
		}
		return minMaxElement;

	}

	public static void main(String[] args) {

		int arr[] = { 8, 6, 4, 2 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, 6, 4, 2));
		int B = 8;
		int result = findMinimumLargestElement(list, B);
		System.out.println("Result is" + result);

	}

}
