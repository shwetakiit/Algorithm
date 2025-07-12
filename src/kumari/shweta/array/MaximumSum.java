/**
 * @author Shweta Kumari
 *2025-07-13
 */
package kumari.shweta.array;

/*
Problem Description
Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.
Problem Constraints

1 <= N <= 106
-1000 <= A[i] <= 1000

Input Format
The first and the only argument contains an integer array, A.
Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.
Example Input
Input 1:A = [1, 2, 3, 4, -10] 
Input 2: A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 

Example Output
Output 1: 10 
Output 2: 6 
*/


public class MaximumSum {

	/**
	 * @param arr
	 * @return
	 * TC->O(N) SC-->O(1)
	 */
	private static int findMaxSum(int[] arr) {
		int currentSum = arr[0];
		int maxSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (currentSum < 0) {
				currentSum = 0;
			}
			currentSum = currentSum + arr[i];

			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, -10 };
		int result = findMaxSum(arr);
		System.out.println("Maximum sum of contiguous array is " + result);
	}
}
