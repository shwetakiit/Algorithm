/**
 * @author Shweta Kumari
 *2023-10-29
 */
package kumari.shweta.backtracking;

/*Write a program to solve a Sudoku puzzle by filling the empty cells.
 *Empty cells are indicated by the character 0 You may assume that there will be only one unique
 *solution.
 * Problem Constraints N = 9 i.e. -Fill no in Sudoku from 1 to 9 
 **/
public class Sudoku {

	boolean solveSudoku(int mat[][], int i, int j, int N) {

		if (j == 9) { // If first row completely filled means column index reached after last index  , Then move to next row on and zeroth column
			i++;    //Move to next row 
			j = 0;  //Move to 0th Column
		}

		if (i == 9) { //Base case --If row reached at 9 after last row, means all row has filled and Sudoku filling completed.
			return true;
		}

		if (mat[i][j] != 0) { //If any column in particular row is already filled ,Skip that column move to next column with recursive call.
			if (solveSudoku(mat, i, j + 1, N) == true) {
				return true;
			}
		} else {

			for (int x = 1; x <= 9; x++) {

				if (isValid(mat, i, j, x) == true) {
					mat[i][j] = x;
					if (solveSudoku(mat, i, j + 1, N) == true) {
						return true;
					}

					mat[i][j] = 0;

				}
			}

		}
		return false;
	}

	/**
	 * @param mat
	 * @param i
	 * @param j
	 * @param x
	 * @return
	 */
	private boolean isValid(int[][] mat, int row, int col, int x) {

		int N = mat.length;
		for (int i = 0; i < N; i++) {
			if (mat[i][col] == x || mat[row][i] == x) { //check if x is already present in this row or in this column then marked this field as invalid for filling data
				return false;
			}
		}
   //Find top left of 3*3 grid to check is there [1-9] element available in 3*3 grid.
		row = row - (row % 3);
		col = col - (col % 3);
		for (int i = 0; i < 3; i++) {   //Grid level validation 
			for (int j = 0; j < 3; j++) {
				if (mat[row + i][col + j] == x) {  //Check If x is present in this grid then marked this field of this 3*3 grid is invalid for filling data and return false 
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Sudoku obj = new Sudoku();
		int mat[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
				        { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				        { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				        { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				        { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
				        { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				        { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
				        { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				        { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
				      };

		boolean isSolved = obj.solveSudoku(mat, 0, 0, mat.length);
		System.out.println("Is Sudoku solved? " + isSolved);

		System.out.println("Print Filled Sudoku");

		for (int k = 0; k < mat.length; k++) {
			for (int l = 0; l < mat.length; l++) {
				System.out.print(mat[k][l]);
			}
			System.out.println();
		}
	}
}
