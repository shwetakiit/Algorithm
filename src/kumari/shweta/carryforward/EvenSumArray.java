/**
 * @author Shweta Kumari
 *2025-10-10
 */
package kumari.shweta.carryforward;

/**
 * You are given  an integer Array A.Decide whether it is possible to divide 
 * the array into one or more sub array of even length  such that first  and last element 
 * of all sub array will be even.
 * Return "Yes" if it is possible , otherwise  return "NO" (Without Quotes)
 *
 */
public class EvenSumArray {

	/**
	 * TC -> O(N) SC -> O(1)
	 */
	private static String divideEvenSubArray(int[] arr) {
		int N = arr.length;
		if (arr.length % 2 == 0 && arr[0] % 2 == 0 && arr[arr.length - 1] % 2 == 0) {
			return "YES";
		}
		return "NO";

	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 8, 6 };
		int arr1[] = { 2, 4, 8, 7, 6 };

		System.out.println(divideEvenSubArray(arr));
		System.out.println(divideEvenSubArray(arr1));
	}
}
