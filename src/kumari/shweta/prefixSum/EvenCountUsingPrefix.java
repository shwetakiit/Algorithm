/**
 * @author Shweta Kumari
 *2025-10-03
 */
package kumari.shweta.prefixSum;

import java.util.Arrays;
import java.util.List;


/**
 *Given an array of size of size N and Q queries [start ,end ] .Find the count of even numbers in the given range.
 *
 *
 */
public class EvenCountUsingPrefix {

	/**
	 * @param arr
	 * @param queries
	 * TC -> O(Q*N)
	 */
	private static void findEvenCount(int[] arr, List<List<Integer>> queries) {

		int N = arr.length;
		int pfEvenCount[] = new int[N];

		if (arr[0] % 2 == 0) {
			pfEvenCount[0] = 1;
		}

		for (int i = 1; i < N; i++) {
			pfEvenCount[i] = pfEvenCount[i - 1];
			if (arr[i] % 2 == 0) {
				pfEvenCount[i]++;
			}
		}

		for (List<Integer> query : queries) {
			int sIndx = query.get(0);
			int eIndx = query.get(1);
			int count = pfEvenCount[eIndx] - (sIndx > 0 ? pfEvenCount[sIndx - 1] : 0);
			System.out.println("Even count start from index" + sIndx + " to end index  " + eIndx + " is" + count);

		}

	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 3, 7, 9, 8, 6, 5, 4, 9 };
		List<List<Integer>> queries = Arrays.asList(Arrays.asList(3, 7), Arrays.asList(1, 8), Arrays.asList(0, 6));
		findEvenCount(arr, queries);

	}
}


