/**
 * @author Shweta Kumari
 *2025-07-04
 */
package kumari.shweta.array;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Shweta Kumari
 *
 */

/**
 * Intially all element of an arr[N] are 0 . Then you are given Q queries .Every query contains
 * index and value.Increment elements from ith index by value.Return final state of arr[].
 * eg .input arr[] of size 6 
 *   queries :
 *   index value 
 *     1    5
 *     3   -2
 *     4    3
 *
 **/
public class StateOfArray {


	
	/**
	 *  TC --> O(Q+N)
	 *  SC --> O(1)
	 * @param arr
	 * @param queries
	 */
	private static void findStateOfArray(int[] arr, Map<Integer, Integer> queries) {

		for (int index : queries.keySet()) {
			arr[index] += queries.get(index);
		}

		for (int i = 1; i < arr.length; i++) { //Apply prefix sum
			arr[i] = arr[i - 1] + arr[i];

		}

		// Final state of array
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int[] arr = new int[6];
		Map<Integer, Integer> queries = new HashMap<>() {
			{
				put(1, 5);
				put(3, -2);
				put(4, 3);

			}
		};

		findStateOfArray(arr, queries);
	}
}
