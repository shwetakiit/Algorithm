/**
 * @author Shweta Kumari
 *2024-08-02
 */
package kumari.shweta.binarysearch;

/**
 * Given two sorted array . Find K'th Position of element If we can merged in
 * sorted form.
 * 
 */

public class FindIndexPositionOfElementInMergedSorted {

	// TC -> O(log (max- min) *(log N+logM) SC -> O(1)
	public int indexPositionOfElememntInMergedSorted(int A[], int B[], int k) {

		int N = A.length;
		int M = B.length;
		int ans = 0;
		int min = Math.min(A[0], B[0]);
		int max = Math.max(A[N - 1], B[M - 1]);

		int left = min;
		int right = max;

		while (left <= right) {

			int mid = (left + right) / 2;
			int x = countOfSmallerElement(A, mid);
			x += countOfSmallerElement(B, mid);
			if (x <= k) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return ans;

	}
	
	//Find count of element smaller than than mid element using Binary search.

	private int countOfSmallerElement(int[] a, int element) {

		int count = 0;

		int left = 0;
		int right = a.length - 1;

		while (left <= right) {

			int mid = (left + right) / 2;
			if (a[mid] < element) {
				count = mid + 1;
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return count;
	}

	public static void main(String[] args) {

		FindIndexPositionOfElementInMergedSorted obj = new FindIndexPositionOfElementInMergedSorted();

		int A[] = { 3, 8, 9, 11, 24, 40 };
		int B[] = { 5, 18, 27, 35 };
		int k = 4;
		int result = obj.indexPositionOfElememntInMergedSorted(A, B, k);

		System.out.println("Result is " + result);
	}

}
