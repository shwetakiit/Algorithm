/**
 * @author Shweta Kumari
 *2023-12-27
 */
package kumari.shweta.dynamicprogramming;
/**
Problem Description
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.
Problem Constraints
1 <= M, N <= 500
-100 <= A[i] <= 100
Input Format
First and only argument is a 2D integer array A denoting the grid of size M x N.
Output Format
Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.

Input :
mat[][] = { { -3, 2, 4, -5 }, { -6, 5, -4, 6 }, { -15, -7, 5, -2 }, { 2, 10, -3, -4 } };
Output is 4
* 
*/
public class DungeonPrincessProblem {

	int findMiniumHealth(int mat[][]) {

		int row = mat.length;
		int col = mat[0].length;
		int dp[][] = new int[row][col];

		int minimumHealth = solve(mat, dp, row, col);
		return minimumHealth;

	}

	/**
	 * @param mat
	 * @param dp
	 * @param i
	 * @param j
	 * @return
	 */
	private int solve(int[][] mat, int[][] dp, int row, int col) {

		if (mat[row - 1][col - 1] >= 0) {

			dp[row - 1][col - 1] = 1;

		} else {

			dp[row - 1][col - 1] = Math.abs(mat[row - 1][col - 1]) + 1;

		}

		for (int i = row - 2; i >= 0; i--) { // Fill last row
			dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - mat[i][col - 1]);
		}
		for (int j = col - 2; j >= 0; j--) { // Fill last column
			dp[row - 1][j] = Math.max(1, dp[row - 1][j + 1] - mat[row - 1][j]);
		}

		for (int i = row - 2; i >= 0; i--) { // Fill all left row and column
			for (int j = col - 2; j >= 0; j--) {

				int x = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - mat[i][j]);
				dp[i][j] = x;
			}
		}

		// Filled DP grid with evaluated health value.

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[0][0]; // Return first row first column element which contains evaluated minimum health point.
	}

	public static void main(String[] args) {
		DungeonPrincessProblem obj = new DungeonPrincessProblem();
		int mat[][] = { { -3, 2, 4, -5 }, { -6, 5, -4, 6 }, { -15, -7, 5, -2 }, { 2, 10, -3, -4 } };
		int minimumHealth = obj.findMiniumHealth(mat);
		System.out.println("Minimum health point required to save princess" + minimumHealth);

	}

}
