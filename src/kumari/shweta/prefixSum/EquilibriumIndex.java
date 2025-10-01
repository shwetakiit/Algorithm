/**
 * @author Shweta Kumari
 *2025-10-02
 */
package kumari.shweta.prefixSum;
/**
 * 
 * Array of Size N .Find any equilibrium index.
 *
 *Index is said to be equilibrium index of sum of element to left = sum of element to  right.
 *If multiple answer , just need any one .
 */

public class EquilibriumIndex {

	
	/**
	 * TC --> O(N)
	 * SC --> O(N) 
	 */
	public static int findEquilibriumIndex(int arr[]) {

		int prefixSum[] = new int[arr.length];
		prefixSum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];

		}

		for (int i = 0; i < arr.length; i++) {

			int leftSum = i == 0 ? 0 : prefixSum[i - 1];
			int rightSum = prefixSum[arr.length - 1] - prefixSum[i];
			if (leftSum == rightSum) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		// int arr[]= {1,2,3,4,8,10};
		int arr[] = { 0, -1, 1 };
		int equilibriumIdx = findEquilibriumIndex(arr);
		System.out.println("Find equilibrium index " + equilibriumIdx);
	}
}
