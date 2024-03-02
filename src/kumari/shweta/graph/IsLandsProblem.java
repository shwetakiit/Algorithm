/**
 * @author Shweta Kumari
 *2024-03-02
 */
package kumari.shweta.graph;

import java.util.Arrays;

/*Problem Description
 Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
 More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
*/
public class IsLandsProblem {

	int findNoOfIsland(int arr[][]) {

		int dx[] = { -1, 0, 1, 0 }; // Total Four possible neighbour to check (-1,0) top ,(0,-1)left ,(1,0)
									// bottom,(0,1)right
		int dy[] = { 0, -1, 0, 1 };

		int col = arr[0].length;
		int row = arr.length;
		int count = 0;
		int visited[][] = new int[arr.length][arr[0].length];
		// 0 -node is not visited .1- node is visited

		for (int node[] : visited) {
			Arrays.fill(node, 0);// Intialize visited as 0
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 1 && visited[i][j] == 0) {
					dfs(arr, i, j, visited, dx, dy, row, col);
					count++;
				}
			}
		}

		return count;

	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 * @param visisted
	 */
	private void dfs(int[][] arr, int i, int j, int[][] visisted, int dx[], int dy[], int row, int col) {
		visisted[i][j] = 1; // First marked starting source as visited
		for (int k = 0; k < dx.length; k++) { //Check all four direction

			int ni = i + dx[k];
			int nj = j + dy[k];

			if (ni >= 0 && ni < row && nj >= 0 && nj < col && arr[ni][nj] == 1 && visisted[ni][nj] == 0) {
				dfs(arr, ni, nj, visisted, dx, dy, row, col);
			}
		}

	}

	public static void main(String[] args) {
		IsLandsProblem obj = new IsLandsProblem();
		int matrix[][] = { { 1, 1, 0, 0, 1 }, 
				           { 0, 1, 0, 1, 0 }, 
				           { 1, 0, 0, 1, 1 }, 
				           { 1, 1, 0, 0, 0 },
				           { 1, 0, 1, 1, 1 } };
		int totalIslands = obj.findNoOfIsland(matrix);
		System.out.println("Total Istand in given matrix is " + totalIslands);

	}

}
