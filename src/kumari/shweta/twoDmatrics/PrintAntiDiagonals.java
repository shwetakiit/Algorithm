/**
 * @author Shweta Kumari
 *2023-03-24
 */
package kumari.shweta.twoDmatrics;

/*Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
* Constraints 1<= N <= 1000 1<= A[i][j] <= 1e9
* Only argument is a 2D array A of size N * N.
* Output ->Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
   The vacant spaces in the grid should be assigned to 0.

input ->
1 2 3  --> 3*3 input 
4 5 6
7 8 9
output ->
1 0 0   --(2*3-1)*3 -->5*3 result 
2 4 0
3 5 7
6 8 0
9 0 0 
*/
public class PrintAntiDiagonals {
	static void printDiagonal(int i, int j, int arr[][], int A[][], int row) {
		int k = 0;
		while (i < A.length && j >= 0) {
			arr[row][k] = A[i][j];
			k++;
			i++;
			j--;
		}
	}

	static int[][] result(int[][] A) {
		int row = A.length * 2 - 1, col = A[0].length; // Square matrix row==col
		int arr[][] = new int[row][col];
		int rowIndex = -1; // arr[rowIndex][].

		// Fixed first row and print all antidiagonals element

		for (int j = 0; j < A[0].length; j++) {
			rowIndex++;
			printDiagonal(0, j, arr, A, rowIndex);
		}

		// Fixed last column i.e col-1
		for (int i = 1; i < col; i++) {
			rowIndex++;
			printDiagonal(i, col - 1, arr, A, rowIndex);

		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int result[][] = result(arr);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
