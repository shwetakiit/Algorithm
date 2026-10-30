/**
 * @author Shweta Kumari
 *2026-10-30
 */
package kumari.shweta.array;

/**
 * @author Shweta Kumari
 *
 */

/**
 * 
 * Given an array of N elements .Find Count of pairs (i,j) where i & j are
 * indices such that arr[i]+arr[j]=k i!=j i<j
 * 
 * eg 1 {8,-2,1,4,3,6,8} K =10 Output --> 1 pair (4,6} eg 2
 * {3,5,2,1,-3,7,8,15,6,13} K=10 output -3 {3,7}{2,8}{-3,13}
 *
 */
public class CountPair {

	// TC -O(N^2) This is brute force approach .. will optimize this using two
	// pointer approach
	// SC -- O(1)
	public static int countPair(int arr[], int K) {
		int count = 0;
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[i] + arr[j] == K) {
					count++;
				}
			}
		}

		return count;

	}
	public static void main(String[] args) {

		int arr[] = { 2, 7, 3, 14, 6, 1, 0, 10, 14 };
		int K = 20;
		System.out.println("Pair with sum " + K + " is " + countPair(arr, K));
	}
}
