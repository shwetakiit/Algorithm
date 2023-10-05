/**
 * @author Shweta Kumari
 *2023-10-05
 */
package kumari.shweta.backtracking;

/**
 * Check if It is possible to go from top left to bottom right cell in a Maze with blocked Cell 
 * We can't cross the same path  multiple time , We can go through the only clear path 
 * Note : arr[n][m] --> 1 path is blocked, 0 path is clear   2  path is already visited 
 */
public class RatInMaze {

	boolean checkPossibleWay(int arr[][]) {

		int N = arr.length;
		int M = arr[0].length;
		boolean isPossible = check(arr, 0, 0, N, M);
		return isPossible;
	}

	boolean check(int arr[][], int i, int j, int N, int M) {

		if (i == N - 1 && j == M - 1) {
			return true;
		}
		if (i < 0 || j < 0 || i >= N || j >= M || arr[i][j] == 2 || arr[i][j] == 1) {
			return false;

		}
		arr[i][j] = 2; // Mark i and j as visited

		return (check(arr, i - 1, j, N, M) || check(arr, i, j - 1, N, M) || check(arr, i + 1, j, N, M)
				|| check(arr, i, j + 1, N, M));

	}

	public static void main(String[] args) {

		RatInMaze obj = new RatInMaze();
		int arr[][] = { { 0, 0, 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0, 1, 0 }, { 0, 1, 0, 0, 1, 0, 0 },
				{ 0, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1, 0 } };

		boolean isPossibleToMove = obj.checkPossibleWay(arr);
		System.out.println("Is it possible to move from left to right corner " + isPossibleToMove);
	}
}
