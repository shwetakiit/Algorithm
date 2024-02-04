/**
 * @author Shweta Kumari
 *2024-02-04
 */
package kumari.shweta.dynamicprogramming;

/**
 * Problem Description
 * Find the longest increasing subsequence of a given array of integers, A.
 * In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order,
 *  and in which the subsequence is as long as possible.In this case, return the length of the longest increasing subsequence.
 */
import java.util.Arrays;

/* Recursive approach*/

public class LongestIncreasingSubsequence {

	int findLongestSubsequence(int arr[]) {

		int ans = 1;
		int dp[] = new int[arr.length];
		Arrays.fill(dp, -1);

		for (int i = 0; i < arr.length; i++) {
			ans = Math.max(ans, findLIS(arr, i, dp));
		}

		return ans;
	}

	private int findLIS(int[] arr, int i, int[] dp) {

		int maxiumSub = 0;
		if (dp[i] != -1) {
			return dp[i];
		}
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i]) {
				maxiumSub = Math.max(maxiumSub, findLIS(arr, j, dp));
			}
		}
		dp[i] = maxiumSub + 1;
		return maxiumSub + 1;
	}

	/* Iterative approach */

	int findLISIterative(int arr[]) {
		int result = 1;
		int dp[] = new int[arr.length];
		dp[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			result = Math.max(result, dp[i]);
		}
		return result;

	}

	public static void main(String[] args) {

		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		// Recursive approach
		int lis = obj.findLongestSubsequence(arr);
		System.out.println("Longest increasing subsequence " + lis);

		// Iterative approach
		int result = obj.findLISIterative(arr);
		System.out.println("Longest increasing subsequence with iterative approach " + result);
	}
}
