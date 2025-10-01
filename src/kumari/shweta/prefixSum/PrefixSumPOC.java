/**
 * @author Shweta Kumari
 *2025-10-01
 */
package kumari.shweta.prefixSum;
import java.util.Arrays;
import java.util.List;

/**
 *Query of size N and Q queries which start from s and end at e find the sum of element from s to e.
 *Note both s and e should be include.
 */
public class PrefixSumPOC {

	
	/**
	 * @param arr
	 * @param q
	 * @param queries
	 * 
	 * TC -> O(N+Q)
	 * SC -> O(N)  --Because we have take extra space prefixSum[] of size N .
	 * If we modify the input array for prefix calculation then SC --> O(1)
	 */
	private static void sumOfElementFromStartIdxToEndIdx(int[] arr, int q, List<List<Integer>> queries) {

		int prefixSum[] = new int[arr.length];

		// Build prefix sum array

		prefixSum[0] = arr[0];
		for (int i = 1; i < arr.length - 1; i++) { // N times
			prefixSum[i] = prefixSum[i - 1] + arr[i];

		}

		// Process each query

		for (int j = 0; j < q; j++) { // Q times
			int sum = 0;
			int s = queries.get(j).get(0);
			int e = queries.get(j).get(1);
			sum = prefixSum[e] - (s > 0 ? prefixSum[s - 1] : 0);
			System.out.println("sum from " + s + " index to " + e + " index is " + sum);
		}

	}

	public static void main(String[] args) {

		int arr[] = { -3, 6, 2, 4, 5, 2, 8, -9, 3, 1 };
		int Q = 4;
		List<List<Integer>> queries = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 7), Arrays.asList(4, 8),
				Arrays.asList(0, 2));
		sumOfElementFromStartIdxToEndIdx(arr, Q, queries);

	}
}
