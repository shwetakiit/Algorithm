/**
 * @author Shweta Kumari
 *2024-07-17
 */
package kumari.shweta.sorting;

/**
 * Radix sort -> Sort in pass and start from first right element of each element
 * in array and second pass second right element so on ..
 */

public class RadixSort {

	public static void radixSort(int arr[]) {

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		int exp = 1;
		while (max > 0) {
			max = max / 10;
			countSort(arr, exp);
			exp = exp * 10;

		}

		for (int val : arr)
			System.out.print(val + " ");
	}

	private static void countSort(int[] arr, int exp) {
		int n = arr.length;
		int freq[] = new int[10];// Range of digits from [0,9] count frequency of each element available in arr

		// 1.Create the frequency array for elements of array
		for (int i = 0; i < n; i++) {

			int digit = (arr[i] / exp) % 10; // We are sorting with digit Ex. all elements of right most digit should be
												// sorted first/
			freq[digit]++;

		}

		// 2.Covert Frequency array into prefix sum array
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}

		// 3.Traverse on the original array from right to left and try to update result
		int result[] = new int[arr.length];
		for (int i = n - 1; i >= 0; i--) {
			int digit = (arr[i] / exp) % 10;
			int pos = freq[digit];
			result[pos - 1] = arr[i];
			freq[digit]--; // Reduce the frequency by 1 because one digit is placed on correct index.

		}

		for (int i = 0; i < result.length; i++) {
			arr[i] = result[i];
		}

	}

	// Copy your answer in original array.
	public static void main(String[] args) {
		int arr[] = { 170, 79, 608, 721, 9, 99, 199, 10 };
		radixSort(arr);
	}
}
