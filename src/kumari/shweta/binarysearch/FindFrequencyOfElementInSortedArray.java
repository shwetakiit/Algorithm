/**
 * @author Shweta Kumari
 *2024-07-24
 */
package kumari.shweta.binarysearch;

/**
 * Find Frequency of K element in sorted array using binary search TC ->O(log2N)
 * SC ->O(1)
 **/
public class FindFrequencyOfElementInSortedArray {

	public int findNumberOfOccurance(int arr[], int k) {

		int firstOccurance = findIndexOfFirstOccurance(arr, k);
		int lastOccurance = findIndexOfLastOccurance(arr, k);
		return lastOccurance - firstOccurance + 1;

	}

	private int findIndexOfLastOccurance(int[] arr, int k) {

		int left = 0, right = arr.length - 1;
		int lastOccuranceIdx = -1;

		while (left <= right) {

			int mid = (left + right) / 2;
			if (arr[mid] == k) {
				lastOccuranceIdx = mid;
				left = mid + 1;
			} else if (arr[mid] < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return lastOccuranceIdx;
	}

	private int findIndexOfFirstOccurance(int[] arr, int k) {
		int left = 0;
		int right = arr.length - 1;
		int firstOccuranceIdx = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == k) {
				firstOccuranceIdx = mid;
				right = mid - 1;
			} else if (arr[mid] < k) {
				left = mid + 1;

			} else {
				right = mid - 1;
			}

		}
		return firstOccuranceIdx;
	}

	public static void main(String[] args) {
		FindFrequencyOfElementInSortedArray obj = new FindFrequencyOfElementInSortedArray();
		int arr[] = { -5, -5, -3, 0, 0, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 15, 15 };
		int frequency = obj.findNumberOfOccurance(arr, 5);
		System.out.println("Total occurance of given element in array is " + frequency);

	}
}
