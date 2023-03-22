/**
 * @author Shweta Kumari
 *2023-03-22 2:25:32 pm
 */
package kumari.shweta.twoDmatrics;
/*Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
 * 1 <= A <= 1000  First and only argument is integer A  
 * if A=2 it will generate 2*2 matrix and elements in matrix is 1 ,2 3,4 
 * if A-5 it will generate 5*5 Matrix and elements in matrix is 1,2,3 .....15 
 * Elements in matrix row wise for A=2 is [ [1, 2], [4, 3] ]
 * Elements in matrix row wise for A=5 is [ [1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9] ]
 */
public class SpiralMatrixPrint {
	static int[][] sprialPrintSqaureMatrix(int A) {
		int top_row = 0, bottom_row = A - 1, left_col = 0, right_col = A - 1;
		int x = 1;
		int arr[][] = new int[A][A];

		while ((x <= A * A) || (top_row <= bottom_row && left_col <= right_col)) {

			// Print top row --Fixed top row go from left to right column wise
			for (int j = left_col; j <= right_col; j++) {
				arr[top_row][j] = x;
				x++;
			}

			top_row++;
			// Print right column -> Fixed right column go from top to bottom row wise
			for (int i = top_row; i <= bottom_row; i++) {
				arr[i][right_col] = x;
				x++;
			}
			right_col--;
			// Print bottom row --> Fixed bottom row go from right column to left column
			for (int j = right_col; j >= left_col; j--) {
				arr[bottom_row][j] = x;
				x++;
			}
			bottom_row--;
			// Print left column --> Fixed left column go from bottom row to top row
			for (int i = bottom_row; i >= top_row; i--) {
				arr[i][left_col] = x;
				x++;
			}
			left_col++;

		}
		return arr;

	}

	public static void main(String[] args) {

		sprialPrintSqaureMatrix(5);
		int result[][] = new int[5][5];
		result = sprialPrintSqaureMatrix(5);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
