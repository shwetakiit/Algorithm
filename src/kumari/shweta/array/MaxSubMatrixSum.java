/**
 * @author Shweta Kumari
 *2025-07-16
 */
package kumari.shweta.array;


/**
 * Given a matrix with dimensions N*M .Find max-submatrix sum , where submtarix 
 * starts from oth row and ends at N-1 th row .
 * 
 * eg N=3 M=6 
 * int arr[][]={{-3,2,3,4-6,4},{5,5,-5,2,2,-7},{-4,-3,1,-1,1,4}};
 * 
 * output --> 8 of sub matrix {{2,3,4},{5,-5,2},{-3,1,-1}}
 * 
 * 
 *
 */
public class MaxSubMatrixSum {

	static int findMaxSumOfSubMatrix(int arr[][]) {
		int rowSum[] = new int[arr[0].length];

		for (int j = 0; j < arr[0].length; j++) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {

				sum += arr[i][j];
				rowSum[j] = sum;
			}
		}

		for (int i = 0; i < rowSum.length; i++) {
			System.out.print(rowSum[i] + " ");
		}

		System.out.println();

		// Now find max sum of subarray from rowSum array.

		int maxSum = rowSum[0];
		int currentSum = rowSum[0];
		for (int i = 1; i < rowSum.length; i++) {

			if (currentSum < 0) {
				currentSum = 0;
			}
			currentSum = currentSum + rowSum[i];
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int arr[][] = { { -3, 2, 3, 4, -6, 4 }, { 5, 5, -5, 2, 2, -7 }, { -4, -3, 1, -1, 1, 4 } };

		System.out.println("Maximum sum of sub matrix  " + findMaxSumOfSubMatrix(arr));
	}
}
