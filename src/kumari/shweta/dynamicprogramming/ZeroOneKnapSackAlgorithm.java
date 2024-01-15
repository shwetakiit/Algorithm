/**
 * @author Shweta Kumari
 *2024-01-15
 */
package kumari.shweta.dynamicprogramming;

import java.util.Arrays;
/*
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
   Also given an integer C which represents knapsack capacity.
   Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
   NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

   Problem Constraints
   1 <= N <= 500
   1 <= C, B[i] <= 106
   1 <= A[i] <= 50

   Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
   Input -> weight[6, 10, 12] value[10, 20, 30] Capacity =50
   Output 22. Explanation -choose subset [20,30] 20+30 <=Capacity and so weight for this subset value is 10+12->22  
 * 
 */

public class ZeroOneKnapSackAlgorithm {

	public int solve(int value[], int wt[], int W) {

		int total = Arrays.stream(value).sum(); // Sum of all element of array values
		int dp[][] = new int[value.length + 1][total + 1];

		for (int i = 0; i <= total; i++) { // Fill first row of DP matrix with infinity
			dp[0][i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= value.length; i++) { // Fill first column of DP matrix with 0.
			dp[i][0] = 0;
		}

		for (int i = 1; i <= value.length; i++) {

			for (int j = 1; j <= total; j++) {
				if (value[i - 1] <= j && dp[i - 1][j - value[i - 1]] != Integer.MAX_VALUE) { // Infinity+ any number is -infinity to avoid this handled in if condition.
					dp[i][j] = Math.min(dp[i - 1][j], wt[i - 1] + dp[i - 1][j - value[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		int result = 0;

		for (int j = total; j >= 0; j--) {

			if (dp[value.length][j] <= W) {
				result = j;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		ZeroOneKnapSackAlgorithm obj = new ZeroOneKnapSackAlgorithm();
		int value[] = { 2, 1, 3 };
		int wt[] = { 3, 2, 4 };
		int W = 7;
		int result = obj.solve(value, wt, W);
		System.out.println(result);
	}
}
