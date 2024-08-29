/**
 * @author Shweta Kumari
 *2024-08-28
 */
package kumari.shweta.binarysearch;

/*
 * Problem Description Given a sorted array of integers A of size N and an
 * integer B, where array A is rotated at some pivot unknown beforehand.
 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1,2].
 * 
 * Your task is to search for the target value B in the array. If found, return
 * its index; otherwise, return -1.
 * You can assume that no duplicates exist in the array.
 * NOTE: You are expected to solve this problem with a time complexity of
 * O(log(N)).
 * 
 * Problem Constraints 1 <= N <= 1000000 1 <= A[i] <= 109 All elements in A are
 * Distinct.
 * 
 * Input Format The First argument given is the integer array A. The Second
 * argument given is the integer B.
 * 
 * Output Format Return index of B in array A, otherwise return -1
 * 
 * Example Input Input 1:
 * 
 * A = [4, 5, 6, 7, 0, 1, 2, 3] B = 4 Input 2:

  A : [ 9, 10, 3, 5, 6, 8 ] B : 5
 * 
 * 
 * Example Output Output 1: 0 
 * Output 2:  3
 * 
 * Example Explanation Explanation 1:
 * Target 4 is found at index 0 in A. Explanation 2:
 * Target 5 is found at index 3 in A.
 */
public class SearchInRotatedSortedArray {

	/*
	 * Apply Binary search to find min or Pivot element Rotated element is available
	 * before pivot index so split in two sub array and Apply binary search on any
	 * of sub array ->If target value is less that arr[0] got to search in right sub
	 * array . If target value is greater than arr[0] go to right sub array.
	 */

	// TC -O(log n) SC -O(1)
	int searchTarget(int arr[], int target) {

		int low = 0;
		int high = arr.length - 1;
		int pivot = pivotBinarySearch(low, high, arr, target);

		if (arr[pivot] == target) {
			return pivot;
		}

		if (arr[0] <= target) {// After rotation we can see all element in right sub array is less than arr[0]
								// and If target is greater than arr[0] only we need to search in left sub array

			return binarySearch(arr, 0, pivot - 1, target);
		}

		return binarySearch(arr, pivot + 1, arr.length - 1, target);
	}

	int binarySearch(int arr[], int low, int high, int target) {

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	/**
	 * @param low
	 * @param high
	 * @param arr
	 * @return
	 */
	private int pivotBinarySearch(int low, int high, int[] arr, int target) {

		while (low <= high) {

			if (low == high) { // Current array is already in sorted array in ascending order after rotation .

				return low;
			}

			int mid = (low + high) / 2;
			if (arr[mid] > arr[high]) {// Mid is in range of rotated sub array but or pivot in right sub array. so move
										// to right half
				low = mid + 1;
			} else
				high = mid; // Don't use high =mid-1 , We will loss mid data .It may be smallest element.
		}

		return low;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int target = 3;

		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		int index = obj.searchTarget(arr, target);
		System.out.println("Searched index is" + index);

	}

}
