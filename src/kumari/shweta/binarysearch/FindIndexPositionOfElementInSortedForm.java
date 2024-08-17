/**
 * @author Shweta Kumari
 *2024-07-31
 */
package kumari.shweta.searching;

/**
 * Given N distinct elements in array and array is unsorted .Find element at Kth
 * index position in its sorted form.
 *
 * input {11,24,,18,3,5,27,34,9,40} K=4; So Ans is 18 If we arrange in sorted
 * form .
 */
public class FindIndexPositionOfElementInSortedForm {

	// TC -> O(N)+N*O(logN)
	public int findElementAtKthPosition(int arr[], int k) {

		int max = findMaxElementInArray(arr);
		int min = findMinElementInArray(arr);

		int left = min;
		int right = max;
		int ans = Integer.MIN_VALUE;
		while (left <= right) {

			int mid = (left + right) / 2;
			int count = countOfSmallerElement(arr, mid); // TC O(N)
			if (count == k) {
				ans = mid;
				left = mid + 1; // Found answer but check for better answer If there is duplicate no right to this because this is first from left side.
			} else if (count < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	private int countOfSmallerElement(int[] arr, int mid) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < mid) {
				count++;
			}
		}
		return count;
	}

	private int findMinElementInArray(int[] arr) {

		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < min) {
				min = arr[i];
			}
		}

		return min;
	}

	private int findMaxElementInArray(int[] arr) {

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max;
	}

	public static void main(String[] args) {
		FindIndexPositionOfElementInSortedForm obj = new FindIndexPositionOfElementInSortedForm();

		int arr[] = { 11, 24, 18, 3, 5, 27, 34, 9, 40 };
		int k = 4;

		int result = obj.findElementAtKthPosition(arr, k);

		System.out.println(result + "should be at  " + k + "th position in sorted form");

	}

}
