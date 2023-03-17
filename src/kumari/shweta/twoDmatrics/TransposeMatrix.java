/**
 * @author Shweta Kumari
 *2023-03-17
 */
package kumari.shweta.twoDmatrics;

public class TransposeMatrix {

	static int[][] transposeOfMatrix(int A[][]) {
		int row = A.length;
		int col = A[0].length;
		// If matrix is square matrix solve by swap no extra space required TC O(ROW^2)
		// SC=O(1)
		if (row == col) {
			for (int i = 0; i < row; i++) {
				for (int j = i + 1; j < row; j++) {
					int temp = A[i][j];
					A[i][j] = A[j][i];
					A[j][i] = temp;
				}
			}
			return A;
		} // If matrix is Rectangle matrix extra space required for transpose TC O(ROW*COL),SC O(ROW*COL)
		else {
			int result[][] = new int[col][row];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					result[j][i] = A[i][j];
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		int sqrMatrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rectMatrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		System.out.println("Transpose of square matrix");
		int result[][] = transposeOfMatrix(sqrMatrix);
		for (int i = 0; i < result[0].length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}

		System.out.println("Transpose of Reactangle matrix");
		int resultRecMatrix[][] = transposeOfMatrix(rectMatrix);
		for (int i = 0; i < resultRecMatrix.length; i++) {
			for (int j = 0; j < resultRecMatrix[0].length; j++) {
				System.out.print(resultRecMatrix[i][j]);
			}
			System.out.println();
		}
	}
}
