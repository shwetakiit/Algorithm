/**
 * @author Shweta Kumari
 *2025-07-06
 */
package kumari.shweta.array;

import java.util.Arrays;
import java.util.List;

/**
 * Intially all element of arr[] are 0.Given Q queries .Every query contains
 * [s,e,val] .Increment elements from s to e by val.Return the final state of
 * arr[] arr[10]={0,0,0,0,0,0,0,0,0,0}.
 */

class Triplet<A, B, C> {

	private A startIdx;
	private B endIdx;
	private C value;

	/**
	 * @param startIdx
	 * @param endIdx
	 * @param value
	 */
	public Triplet(A startIdx, B endIdx, C value) {

		this.startIdx = startIdx;
		this.endIdx = endIdx;
		this.value = value;
	}

	/**
	 * @return the startIdx
	 */
	public A getStartIdx() {
		return startIdx;
	}

	/**
	 * @return the endIdx
	 */
	public B getEndIdx() {
		return endIdx;
	}

	/**
	 * @return the value
	 */
	public C getValue() {
		return value;
	}

}

public class StateofArray2 {

	/**
	 * TC --> O(Q+N)
	 * SC ->O(1)
	 * @param arr
	 * @param queries
	 */
	public static void findFinalStateOfArray(int arr[], List<Triplet<Integer, Integer, Integer>> queries) {

		for (int i = 0; i < queries.size(); i++) {  //Q times 
			arr[queries.get(i).getStartIdx()] += queries.get(i).getValue();
			if (queries.get(i).getEndIdx() + 1 < arr.length) {
				arr[queries.get(i).getEndIdx() + 1] -= queries.get(i).getValue();

			}
		}

		// Cover arr[] --> prefix sum array
		for (int i = 1; i < arr.length; i++) {  // N times 
			arr[i] = arr[i - 1] + arr[i];
		}

		System.out.println("Final state of array is ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

	}

	public static void main(String[] args) {

		int[] arr = new int[10];
		Triplet<Integer, Integer, Integer> obj1 = new Triplet(3, 6, 3);
		Triplet<Integer, Integer, Integer> obj2 = new Triplet(2, 7, -3);
		Triplet<Integer, Integer, Integer> obj3 = new Triplet(1, 9, 4);
		List<Triplet<Integer, Integer, Integer>> queries = Arrays.asList(obj1, obj2, obj3);
		findFinalStateOfArray(arr, queries);
	}

}
