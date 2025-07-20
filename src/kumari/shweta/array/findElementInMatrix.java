/**
 * @author Shweta Kumari
 *2025-07-20
 */
package kumari.shweta.array;

import javax.naming.spi.DirStateFactory.Result;

/**
 * @author Shweta Kumari
 *
 */
public class findElementInMatrix {
	
	
	/**
	 * @param arr
	 * TC --> O(n+m) SC -> O(1)
	 */
	private static boolean findKthElment(int[][] arr, int k) {

		int n = arr.length;
		int m = arr[0].length;

		boolean found = true;
		int r = 0;
		int c = m - 1;
		while (r < n && c >= 0) {
			if (arr[r][c] == k) { // If k is found
				found=true;
				return found;
			} else if (arr[r][c] > k) { // If K is lesser than current element move left in that row.
				c--;
			} else { // If K is greater than current element move down next row
				r++;
			}
		}

		return found;
	}

	public static void main(String[] args) {
		int arr[][] = { { -1, 2, 4, 5, 9, 11 }, 
				        { 1, 4, 7, 8, 10, 14 }, 
				        { 3, 7, 9, 10, 12, 18 },
				        { 6, 10, 12, 14, 16, 20 }, 
				        { 9, 13, 16, 19, 22, 24 }, 
				        { 11, 15, 19, 21, 24, 27 },
				        { 14, 20, 25, 29, 31, 39 }, 
				        { 18, 24, 29, 32, 34, 42 } 
				        };

		int k = 30;

		System.out.println(" is " + k + " Found " + findKthElment(arr, k));

	}
}
