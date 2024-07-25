/**
 * @author Shweta Kumari
 *2024-07-25
 */
package kumari.shweta.searching;

/**
 * Given Unsorted Array of N distinct elements .Find Any local Minima Note Local
 * Minima is element smaller than adjacent element.
 *
 */
public class FindLocalMinimaUsingBS {

	//TC ->O(Log2N) SC->O(1)
	public static int findLocalMinima(int arr[]) {
		int N = arr.length;

		if (N == 1) {
			return arr[0];
		}
		if (arr[0] < arr[1]) {

			return arr[0];

		}
		if (arr[N - 1] < arr[N - 2]) {

			return arr[N - 1];

		}
		int left = 1;
		int right = arr.length - 2;
		while (left <= right) {

			int mid = (left + right) / 2;
			if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
				return arr[mid];
			} else if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 9, 8, 7, 3, 6, 4, 1, 5 };
		int localMinima = findLocalMinima(arr);
		System.out.println("Local minima is " + localMinima);
	}

}
