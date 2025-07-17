/**
 * @author Shweta Kumari
 *2025-07-16
 */
package kumari.shweta.array;

/**
 * 1)Given a matrix with dimensions N*M .Find max-submatrix sum , where
 * submtarix starts from oth row and ends at N-1 th row .
 * 
 * eg N=3 M=6 int arr[][]={{-3,2,3,4-6,4},{5,5,-5,2,2,-7},{-4,-3,1,-1,1,4}};
 * 
 * output --> 8 of sub matrix {{2,3,4},{5,-5,2},{-3,1,-1}}
 * 
 * 2) Given a mtrix .Find max sub-matrix sum Note : Where Submatrix Start at
 * row=0 and can end anywhere . Input N=4 M=6 int
 * arr[]={{2,-4,1,3,-1,2},{1,3,2,-7,3,3},{0,-1,1,3,4,-7},{1,-1,-6,4,-4,6}}
 * Output ->  10 
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

	/*
	 *  Question 2:
	 *  TC -> O(N+M)   N no of row and M no of column
	 *  SC -> O(M)
	 */
	public static int maximumSumOfSubMatrix(int arr[][]) {
		int rowSum[] = new int[arr[0].length];
		int result = arr[0][0];

		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr[0].length; i++) {

				rowSum[i] += arr[j][i];
			}

			/*
			 * for (int k = 0; k < arr[0].length; k++) {
			 *  System.out.print(" " + rowSum[k]);}
			 * int oneRowMax = kadanes(rowSum); System.out.println(oneRowMax);
			 */
			result = Math.max(result, kadanes(rowSum));

		}
		return result;

	}

	/**
	 * @param rowSum
	 * @return
	 */
	private static int kadanes(int[] rowSum) {

		int currentSum = rowSum[0];
		int maxSum = rowSum[0];
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

		int mat[][] = { { 2, -4, 1, 3, -1, 2 }, { 1, 3, 2, -7, 3, 3 }, { 0, -1, 1, 3, 4, -7 },
				{ 1, -1, -6, 4, -4, 6 } };
		System.out.println("Mxium sub of sub mtraix start from row 0 and end anywhere" + maximumSumOfSubMatrix(mat));
	}
}
