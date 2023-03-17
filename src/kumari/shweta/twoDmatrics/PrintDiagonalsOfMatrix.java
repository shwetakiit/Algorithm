/**
 * @author Shweta Kumari
 *2023-03-17
 */
package kumari.shweta.twoDmatrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Print all diagonals of matrix 
 * For example : Matrix [[1,2,3,4][5,6,7,8][9,10,11,12][13,14,15,16]]
 * Output [[1][2,5][3,6,9][4,7,10,13][8,11,14][12,15][16]]
 */
public class PrintDiagonalsOfMatrix {
	static List<Integer> printDiagonals(int i, int j, List<List<Integer>> matrix, List<Integer> result) {

		while (i < matrix.size() && j >= 0) {

			result.add(matrix.get(i).get(j));
			i++;
			j--;
		}
		return result;

	}

	static List<List<Integer>> listOfDiagonals(List<List<Integer>> matrix) {

		List<List<Integer>> result = new ArrayList<>();
		int row = matrix.size();
		int col = matrix.get(0).size();
		// fix 0th row and print all diagonals 0 to M-1 Column Assume N*M matrix
		for (int j = 0; j < col; j++) {
			List<Integer> diagonal = new ArrayList<>();
			List<Integer> diagIntegers = printDiagonals(0, j, matrix, diagonal);
			result.add(diagIntegers);
		}
		// Fixed M-1(last) column Print right side diagonal from row 1 to N-1 (Excluding
		// 0th row diagonal at column M-1)
		for (int i = 1; i < row; i++) {
			List<Integer> diagonal = new ArrayList<>();
			List<Integer> dIntegers = printDiagonals(i, col - 1, matrix, diagonal);
			result.add(dIntegers);
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> matrixList = Arrays.asList(
				new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
				new ArrayList<>(Arrays.asList(5, 6, 7, 8)), 
				new ArrayList<>(Arrays.asList(9, 10, 11, 12)),
				new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
		List<List<Integer>> result = listOfDiagonals(matrixList);
		System.out.println("List of all Diagonals  in matrix " + result);
	}
}
