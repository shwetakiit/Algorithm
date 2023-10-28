/**
 * @author Shweta Kumari
 *2023-10-28
 */
package kumari.shweta.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
The N-queens puzzle is the problem of placing N queens on an N×N chessboard such that no two queens attack each other.
   
Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.
Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.

Problem Constraints
1 <= A <= 10
Input Format
First argument is an integer A denoting the size of chessboard
Output Format
Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

Input :3  , We can't place 3 queen in 3*3 chessboard without killing nearest queen ,Only 2 queen can be places so no solution for this 
Input 2: , We can't place 2 queen in 2*2 Chessboard without killing any queen , Only we can place 1 queen but required to place 2 queen so no solution for this 
*/

public class ChessQueen {

	List<ArrayList<String>> result = new ArrayList<>();

	public List<ArrayList<String>> placeQueen(int size) {

		char mat[][] = new char[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				mat[i][j] = '.';
			}
		}
		nQueens(mat, 0, size);
		return result;
	}

	/**
	 * @param mat
	 * @param i
	 * @param size
	 */
	private void nQueens(char[][] mat, int row, int size) {
		if (row == size) {
			result.add(convert(mat));
			return;

		}

		for (int col = 0; col < size; col++) {
			if (isQueenSafe(mat, row, col, size) == true) {
				mat[row][col] = 'Q';
				nQueens(mat, row + 1, size);
				mat[row][col] = '.';
			}
		}

	}

	/**
	 * @param mat
	 * @return
	 */
	private ArrayList<String> convert(char[][] mat) {

		int n = mat.length;
		ArrayList<String> as = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 'Q') {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			as.add(sb.toString());
		}
		return as;
	}

	/**
	 * @param mat
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean isQueenSafe(char[][] mat, int row, int col, int size) {
		for (int i = 0; i < row; i++) {
			if (mat[i][col] == 'Q')
				return false;
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (mat[i][j] == 'Q')
				return false;
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < size; i--, j++) {
			if (mat[i][j] == 'Q')
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		// Test case 1 :If Chessboard is 1*1
		ChessQueen obj1 = new ChessQueen();
		System.out.println("Chess board is 1*1");
		List<ArrayList<String>> result1 = obj1.placeQueen(1);
		System.out.println(
				"Found" + result1.size() + " solutions to place queens without killing other queens" + result1);

		// Test case 2: If Chessboard is 2*2
		ChessQueen obj2 = new ChessQueen();
		System.out.println("Chess board is 2*2");
		List<ArrayList<String>> result2 = obj2.placeQueen(2);
		System.out.println(
				"Found" + result2.size() + " solutions to place queens without killing other queens" + result2);

		// Test case 3 : If Chessboard is 3*3
		ChessQueen obj3 = new ChessQueen();
		System.out.println("Chess board is 3*3");
		List<ArrayList<String>> result3 = obj3.placeQueen(3);
		System.out.println(
				"Found" + result3.size() + " solutions to place queens without killing other queens" + result3);

		// Test case 4: If Chessboard is 4*4
		ChessQueen obj4 = new ChessQueen();
		System.out.println("Chess board is 4*4");
		List<ArrayList<String>> result4 = obj4.placeQueen(4);
		System.out.println(
				"Found" + result4.size() + " solutions to place queens without killing other queens" + result4);

	}
}
