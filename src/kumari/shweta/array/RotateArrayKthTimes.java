/**
 * @author Shweta Kumari
 *2026-11-02
 */
package kumari.shweta.array;

/**
 * Given the array of Size N .Rotate your array k times clockwise arr
 * [-1,2,3,6,5,4,8} K=1 [8,-1,2,3,6,5,4] K=2 [4,8,-1,2,3,6,5] K=3
 * [5,4,8,-1,2,3,6]
 * 
 * Output --> [5,4,8,-1,2,3,6]
 *
 */
public class RotateArrayKthTimes {
	// SC --O(1) TC -> O(N)
	private static void rotateClockWise(int arr[], int K) {

		int N = arr.length;
		arr = reverseArrayWithoutUsingExtraSpace(arr, 0, N - 1); // TC O(N/2)
		arr = reverseArrayWithoutUsingExtraSpace(arr, 0, K - 1); // TC O(K/2)

		arr = reverseArrayWithoutUsingExtraSpace(arr, K, N - 1); // TC O(N-K/2)

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * @param arr
	 * @param startIdx
	 * @param endIdx
	 */
	private static int[] reverseArrayWithoutUsingExtraSpace(int[] arr, int i, int j) {

		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		return arr;
	}

	public static void main(String[] args) {

		int arr[] = { -1, 2, 3, 6, 5, 4, 8 };
		int k = 3;
		rotateClockWise(arr, k);

	}
}
