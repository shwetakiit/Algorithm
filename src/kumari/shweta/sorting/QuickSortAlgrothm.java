/**
 * @author Shweta Kumari
 *2023-04-23
 */
package kumari.shweta.sorting;

public class QuickSortAlgrothm {
	static void quickSort(int arr[], int startIdx, int endIdx) {
		// base case
		if (startIdx >= endIdx) {
			return;
		}
		int pivotIdx = partition(arr, startIdx, endIdx);
		quickSort(arr, startIdx, pivotIdx - 1);
		quickSort(arr, pivotIdx + 1, endIdx);
	}

	/**
	 * @param arr
	 * @param startIdx
	 * @param endIdx
	 * @return
	 */
	private static int partition(int[] arr, int startIdx, int endIdx) {
		int pivot = arr[endIdx], j = startIdx;
		for (int i = startIdx; i <= endIdx; i++) {
			if (arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;

			}
		}
		int temp = arr[endIdx];
		arr[endIdx] = arr[j];
		arr[j] = temp;

		return j;
	}

	public static void main(String[] args) {
		int arr[] = { 7, 3, 2, 5, 1, 6, 4 };
		int startIdx = 0;
		int endIdx = arr.length - 1;
		quickSort(arr, startIdx, endIdx);
		for (int i = startIdx; i <= endIdx; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
