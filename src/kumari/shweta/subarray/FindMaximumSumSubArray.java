/**
 * @author Shweta Kumari
 *2024-10-15
 */
package kumari.shweta.subarray;

/*
Problem Description
You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.

Problem Constraints

1 <= A <= 10^3
1 <= B <= 10^9
1 <= C[i] <= 10^6
Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.
Output Format
Return a single integer which denotes the maximum sum.
Example Input
Input 1: A = 5 B = 12 C = [2, 1, 3, 4, 5]
Input 2: A = 3 B = 1 C = [2, 2, 2]


Example Output
Output 1: 12
Output 2:  0

Example Explanation

Explanation 1:
We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
Explanation 2:

All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0.
*/


public class FindMaximumSumSubArray {

	// TC --O(N^2) SC ->O(1)
	/**
	 * @param arr
	 * @param target
	 */
	private int maximumSumOfSubArray(int[] arr, int target) {

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum = sum + arr[j];
				if (sum == target) {
					result = sum;
					return result;
				} else if (sum <= target && sum > result) {
					result = sum;
				}
			}
		}

		return result;

	}

	public static void main(String[] args) {

		FindMaximumSumSubArray obj = new FindMaximumSumSubArray();
		int arr[] = { 2, 1, 3, 4, 5 };
		int target = 12;

		int result = obj.maximumSumOfSubArray(arr, target);
		System.out.println(result);
	}

}
