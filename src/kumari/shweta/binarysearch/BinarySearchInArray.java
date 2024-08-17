/**
 * @author Shweta Kumari
 *2024-07-23
 */
package kumari.shweta.binarysearch;

public class BinarySearchInArray {

	// TC ->O(logN)
	public static int findElementInSortedArray(int arr[], int k) {

		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {

			int mid = (left + right) / 2; // For huge data use mid= left+(right-left)/2
			if (arr[mid] == k) {
				return mid;
			} else if (arr[mid] < k) {
				left = mid + 1;

			} else {
				right = mid - 1;
			}
		}

		return -1;

	}

	public static void main(String[] args) {

		int arr[] = { 3, 6, 9, 12, 14, 19, 20, 23, 25, 27 };
		int k = findElementInSortedArray(arr, 20);
		System.out.println("Element foundt at " + k);
	}
}
