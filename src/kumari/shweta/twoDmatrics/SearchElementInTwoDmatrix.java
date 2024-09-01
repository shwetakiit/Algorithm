/**
 * @author Shweta Kumari
 *2024-08-31
 */
package kumari.shweta.twoDmatrics;

/*
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

Input 
*Input : mat[][] = { {1, 5, 9},
                    {14, 20, 21},
                    {30, 34, 43} }
        x = 14
        
 Output true
*
*/


public class SearchElementInTwoDmatrix {
	
	
	/**
	  1. Column row wise binary search to find in which row we can find element.
	  2. Apply binary search column wise on found row .  
	  
	**/
	
	public boolean findTargetElement(int arr[][], int target) {

		int low = 0;
		int high = arr.length - 1; // no of row in matrix
		int colIdx = arr[0].length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;
			if (arr[mid][0] == target || arr[mid][colIdx] == target) {

				return true;

			} else if (target > arr[mid][0] && target < arr[mid][colIdx]) {
				return BinarySearch(arr, mid, target);
			}

			if (arr[mid][0] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return false;// If target is beyond the range of matrix

	}

	/**
	 * @param arr
	 * @param mid
	 * @param target
	 */
	private boolean BinarySearch(int[][] arr, int row, int target) {

		int low = 0;
		int high = arr[0].length - 1;
		while (low <= high) {

			int mid = (low + high) / 2;
			if (arr[row][mid] == target) {
				return true;
			} else if (arr[row][mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return false;

	}

	public static void main(String[] args) {

		SearchElementInTwoDmatrix obj = new SearchElementInTwoDmatrix();

		int mat[][] = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 }, { 45, 60, 75 } };

		int target = 75;
		boolean isFound = obj.findTargetElement(mat, target);
		System.out.println("is target element found? " + isFound);
	}
}
