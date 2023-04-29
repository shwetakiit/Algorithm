/**
 * @author Shweta Kumari
 *2023-04-29
 */
package kumari.shweta.sorting;

public class CountSortWithNegativeNumber {
	private static int[] countSort(int arr[]) {
		int N = arr.length;
		int min = arr[0], max = arr[0];

		// Find max and min element in array

		for (int i = 1; i < N; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}

		// Create frequency array for each element of arr[]

		int range = max - min + 1;
		int freqency[] = new int[range];
		for (int i = 0; i < N; i++) {
			int val = arr[i];
			freqency[val - min]++;
		}
		// prefix sum of frequency to find correct position of each element after
		// sorting and maintain stability
		for (int i = 1; i < range; i++) {
			freqency[i] = freqency[i - 1] + freqency[i];
		}
		int result[] = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			int val = arr[i];
			int idx = freqency[val - min] - 1; // frequency[val-min] is position for element and freqency[val-min]-1 is
												// index
			result[idx] = val;
			freqency[val - min]--;
		}

		for (int i = 0; i < N; i++) {
			arr[i] = result[i];
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 5, -7, -3, 5, 2, 1, -2, 6, 4, -1, 2 };
		int result[] = countSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
