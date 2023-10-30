/**
 * @author Shweta Kumari
 *2023-10-29
 */
package kumari.shweta.backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Shweta Kumari
 *
 */
public class SudokuProblem {

	List<ArrayList<Character>> prepareSudokuMatrix(List<String> list){
		List<ArrayList<Character>> sudokuMatrix = new ArrayList<>();
		for(String s : list) {
		  
			ArrayList<Character> sudoList = new ArrayList<>();
			for(int i =0;i<s.length();i++) {
				sudoList.add(s.charAt(i));
			}
			sudokuMatrix.add(sudoList);
			
		}
		System.out.println(sudokuMatrix);
		return sudokuMatrix;
	}
	
	
	public void solveSudoku(List<ArrayList<Character>> sudokuMatrix ) {
		
		sudoku(sudokuMatrix,0,0,sudokuMatrix.size());
	}
	/**
	 * @param sudokuMatrix
	 * @param i
	 * @param j
	 * @param size
	 */
	private boolean sudoku(List<ArrayList<Character>> sudokuMatrix, int i, int j, int size) {

		if (j == 9) { // If first row completely filled means column index reached after last index  , Then move to next row on and zeroth column
			i++;    //Move to next row 
			j = 0;  //Move to 0th Column
		}

		if (i == 9) { //Base case --If row reached at 9 after last row, means all row has filled and Sudoku filling completed.
			return true;
		}

		if (sudokuMatrix.get(i).get(j)!= '.') { //If any column in particular row is already filled ,Skip that column move to next column with recursive call.
			if (sudoku(sudokuMatrix, i, j + 1, size) == true) {
				return true;
			}
		} else {

			for (int x = 1; x <= 9; x++) {

				if (isValid(sudokuMatrix, i, j, x) == true) {
				ArrayList<Character> row=	sudokuMatrix.get(i);
				row.set(j, (char)(x+'0'));
				
					if (sudoku(sudokuMatrix, i, j + 1, size) == true) {
						return true;
					}
					row.set(j,'.');
				
				

				}
			}

		}
		return false;
		
	}


	/**
	 * @param sudokuMatrix
	 * @param i
	 * @param j
	 * @param x
	 * @return
	 */
	private boolean isValid(List<ArrayList<Character>> sudokuMatrix, int row, int col, int x) {
		char c =(char)(x+'0');
		for(int i =0;i<sudokuMatrix.size();i++) {
			if(sudokuMatrix.get(i).get(col)==c || sudokuMatrix.get(row).get(i)==c) {
				return false;
			}
		}
		//Find row and column of top left corner of 3*3 grid matrix
		row =row-(row%3); 
		col=col-(col%3);
		for(int i =0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(sudokuMatrix.get(row+i).get(col+j)==x) {
					return false;
				}
			}
		}
		
		return true;
	}


	public static void main(String[] args) {
		
		SudokuProblem obj = new SudokuProblem();
		List<String> strList= new ArrayList<>();
	    strList.add("53..7....");
	    strList.add("6..195...");
	    strList.add(".98....6.");
	    strList.add("8...6...3");
	    strList.add("4..8.3..1");
	    strList.add("7...2...6");
	    strList.add(".6....28.");
	    strList.add("...419..5");
	    strList.add("....8..79");
		List<ArrayList<Character>> sudoku = obj.prepareSudokuMatrix(strList);
		System.out.println("Unsolved given sudoku is ");
		obj.solveSudoku(sudoku);
		System.out.println("Solved sudoku is ..");
		System.out.println(sudoku);
		}
	}
