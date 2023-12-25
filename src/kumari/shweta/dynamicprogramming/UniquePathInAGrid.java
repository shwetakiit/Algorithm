/**
 * @author Shweta Kumari
 *2023-12-25
 */
package kumari.shweta.dynamicprogramming;

/*
 * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). 
   At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
   Now consider if some obstacles are added to the grids. 
   Return the total number unique paths from (1, 1) to (n, m).

   Note: 
   1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
   2. Given Source Point and Destination points are 1-based index.
 */
public class UniquePathInAGrid {

	private int totalUniqePathToReach(int mat[][]) {

		int row = mat.length;
		int col = mat[0].length;
		int dp[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dp[i][j] = -1;
			}
		}
		int totalWay = findUniquePath(mat, row - 1, col - 1, dp);
		return totalWay;
	}

	/**
	 * @param mat
	 * @param row
	 * @param col
	 * @return
	 */
	private int findUniquePath(int[][] mat, int i, int j, int dp[][]) {

		if (i < 0 || j < 0) { // If matrix doesn't exist
			return 0;
		}
		if (mat[i][j] == 1) { // If found path blocker in matrix
			return 0;
		}
		if (i == 0 && j == 0) { // If only one cell in matrix so don't move stand there
			return 1;
		}
		if (dp[i][j] == -1) {

			dp[i][j] = findUniquePath(mat, i - 1, j, dp) + findUniquePath(mat, i, j - 1, dp);

		}
		return dp[i][j];
	}

	public static void main(String[] args) {

		UniquePathInAGrid obj = new UniquePathInAGrid();

		int mat[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int mat1[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };

		int totalWay = obj.totalUniqePathToReach(mat);
		System.out.println("Total ways to reach from (0,0) to last right corner(n,m) " + totalWay);

		int noOfWay = obj.totalUniqePathToReach(mat1);
		System.out.println("Total ways to reach from (0,0) to last right corner(n,m) " + noOfWay);
	}
}
