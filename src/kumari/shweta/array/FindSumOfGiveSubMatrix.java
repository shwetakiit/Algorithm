/**
 * @author Shweta Kumari
 *2025-07-14
 */
package kumari.shweta.array;


/**
 * 
 *Given a matrix of Size N*M .Calculate sum of all Submatrix sums.
 *
 */
public class FindSumOfGiveSubMatrix {

	//TC --> O(N*M)  SC --> O(1)
	public static int sumOfAllSubMatrix(int arr[][]) {
		int N = arr.length;
		int M = arr[0].length;
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.println(arr[i][j] + "  *  " + ((i + 1) * (j + 1) * (N - i) * (M - j)));
				result += (arr[i][j] * (i + 1) * (j + 1) * (N - i) * (M - j));
			}
		}

		return result;

	}

	public static void main(String[] args) {
		int arr[][] = { { 3, 1 }, { -1, -2 }, { 2, 4 } };
		int result = sumOfAllSubMatrix(arr);
		System.out.println("Sum of all summatrix sum is " + result);

	}

}
