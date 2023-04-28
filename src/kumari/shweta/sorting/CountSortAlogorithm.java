/**
 * @author Shweta Kumari
 *2023-04-28
 */
package kumari.shweta.sorting;


/*Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
 Problem Constraints
1 <= |A| <= 105
1 <= A[i] <= 105
Note : It should be stable sort for example if duplicate elements are there then sorting order of duplicate 
element should maintain 
range of element in array is [1,10) excluding 10  
Input arr[]={7,3,7,4,5,3,1,2,2,3,7,6,9}

*/

public class CountSortAlogorithm {

	public static int[] countSort(int arr[]) {

		/*
		 * If range is not given then we need to find max and min element to decide
		 * index for frequency , Here range is given [1,10) so no need to find min and
		 * max
		 */

		/* Find the frequency for each element of array arr[] */
		int freq[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			int idx = arr[i];
			freq[idx]++;
		}

		/*
		 * Prefix sum on array of frequency to find the position of each element in
		 * sorted array to maintain the stability of sorting
		 */
		for (int i = 1; i < 10; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}

		int result[] = new int[arr.length];
		// Traversing array from right to left for sorting to maintain stability
		for (int i = arr.length - 1; i >= 0; i--) {
			int val = arr[i];
			int idx = freq[val] - 1;
			result[idx] = val;
			freq[val]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = result[i];
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 7, 3, 7, 4, 5, 3, 1, 2, 2, 3, 7, 6, 9 };
		int result[] = countSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
