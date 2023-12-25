/**
 * @author Shweta Kumari
 *2023-12-24
 */
package kumari.shweta.dynamicprogramming;

import java.util.Arrays;

/**
 * Given matrix of n*m .Find total no of way to reach from (0,0) to (n-1,m-1) if
 * 2*2 matrix so Total way to reach at last corner is 6 ways h-> horizontal move
 * v->Vertical move -- {hhvv,hvhv,vvhh,vhhv,vhvh,hvvh}
 */

public class FindTotalWaysToReachLastCorner {

	// Top down approach

	int ways(int row, int col) {

		int arr[][] = new int[row][col];
		int dp[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dp[i][j] = -1;
			}
		}
		int totalways = totalWaysToReachLastCorner(row, col, dp);

		return totalways;
	}

	/**
	 * @param row
	 * @param col
	 * @param dp
	 * @return
	 */
	private int totalWaysToReachLastCorner(int row, int col, int[][] dp) {
		if (row == 0 || col == 0) { // If Do not move stand at the same point .
			return 1;
		}

		if (dp[row - 1][col - 1] != -1) {
			return dp[row - 1][col - 1];
		}
		dp[row - 1][col - 1] = totalWaysToReachLastCorner(row - 1, col, dp)
				+ totalWaysToReachLastCorner(row, col - 1, dp);

		return dp[row - 1][col - 1];
	}

	// Optimized bottom-up approach
	private int bottomUpApproachToReachLastCorner(int row, int col) {

		int dp[][] = new int[row][col];
		for (int i = 1; i <= col; i++) {
			dp[0][i - 1] = 1;
		}
		for (int j = 1; j <= row; j++) {
			dp[j - 1][0] = 1;
		}

		int totalWay = buttomUpApproach(row, col, dp);

		return totalWay;

	}

	/**
	 * @param row
	 * @param col
	 * @return
	 */
	private int buttomUpApproach(int row, int col, int dp[][]) {
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

			}
		}
		return dp[row - 1][col - 1];
	}

	// Optimized bottom up approach using one dimensional

	private int totalWaysUsingOneDimentionalStorage(int row, int col) {
		int dp[] = new int[col];
		Arrays.fill(dp, 1);
		int totalWays = totalWaysWithOneDimensional(row, col, dp);

		return totalWays;
	}

	/**
	 * @param row
	 * @param col
	 * @param dp
	 * @return
	 */
	private int totalWaysWithOneDimensional(int row, int col, int[] dp) {

		for (int j = 1; j < row; j++) {
			for (int i = 1; i < col; i++) {
				dp[i] = dp[i - 1] + dp[i];
			}
		}
		return dp[col - 1];
	}

	public static void main(String[] args) {
		FindTotalWaysToReachLastCorner obj = new FindTotalWaysToReachLastCorner();
		int result = obj.ways(4, 5);
		System.out.println("Total ways to reach from left corner (0,0) to last corner (n-1,m-1) is " + result);

		// Bottom Up approach
		int totalWays = obj.bottomUpApproachToReachLastCorner(6, 5);
		System.out.println("Total ways to reach from left corner (0,0) to last corner (n-1,m-1) is " + totalWays);

		// Bottom up approach using single dimension storage and prefix sum.
		int ways = obj.totalWaysUsingOneDimentionalStorage(6, 5);
		System.out.println("Total ways to reach from left corner (0,0) to last corner (n-1,m-1) is " + ways);
	}
}
