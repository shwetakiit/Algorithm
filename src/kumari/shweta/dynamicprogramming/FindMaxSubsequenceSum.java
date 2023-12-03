/**
 *@author Shweta Kumari
 * 2023-12-03
 */
package kumari.shweta.dynamicprogramming;

import java.util.Arrays;

/**
 * Given an array.Find max subsequence sum. Note :You are not allowed to pick
 * the adjacent element. eg input arr[9,4,13] output --> 9+13 -->22
 * arr[9,4,13,24] output --> 9+24 ->33
 *
 *TC ->O(N) sc -> O(N)
 */
public class FindMaxSubsequenceSum {

	int maxSubSequenceSum(int arr[]) {
		int dp[] = new int[arr.length];
		Arrays.fill(dp, Integer.MIN_VALUE);
		int result = maxSum(arr, arr.length - 1, dp);
		return result;
	}

	/**
	 * @param arr
	 * @param i
	 * @param dp
	 * @return
	 */
	private int maxSum(int[] arr, int i, int[] dp) {

		if (i < 0) { // Base case
			return 0;
		}

		if (dp[i] != Integer.MIN_VALUE) {
			return dp[i];
		}

		int fun1 = 0 + maxSum(arr, i - 1, dp); // If we have not selected i element so next element will be i-1 and add zero because we didn't select i element
		int fun2 = arr[i] + maxSum(arr, i - 2, dp);// If we have selected i element so next element will be i-2 and add selected i element
		int ans = Math.max(fun1, fun2);
		dp[i] = ans;
		return ans;
	}

	public static void main(String[] args) {

		FindMaxSubsequenceSum obj = new FindMaxSubsequenceSum();

		int arr[] = { 9, 4, 13 };
		int arr1[] = { -9, 4, 13, 24 };
		int result1 = obj.maxSubSequenceSum(arr);
		int result2 = obj.maxSubSequenceSum(arr1);
		System.out.println("Max subsequence sum for test1" + result1);
		System.out.println("Max subsequence sum  for test2" + result2);
	}
}
