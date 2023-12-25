/**
 * @author Shweta Kumari
 *2023-12-24
 */
package kumari.shweta.dynamicprogramming;

/**
 * Given matrix of n*m .Find total no of way to reach from (0,0) to (n-1,m-1)
 * 
 */

public class FindTotalWaysToReachLastCorner {
	
	//Top down approach 

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
		if (row == 0 || col == 0) { //If Do not move stand at the same point .
			return 1;
		}

		if (dp[row - 1][col - 1] != -1) {
			return dp[row - 1][col - 1];
		}
		dp[row - 1][col - 1] = totalWaysToReachLastCorner(row - 1, col, dp)
				+ totalWaysToReachLastCorner(row, col - 1, dp);

		return dp[row - 1][col - 1];
	}

	public static void main(String[] args) {
		FindTotalWaysToReachLastCorner obj = new FindTotalWaysToReachLastCorner();
		int result = obj.ways(2, 2);
		System.out.println("Total ways to reach from left corner (0,0) to last corner (n-1,m-1) is " + result);

	}
}
