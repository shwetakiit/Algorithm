/**
 * @author Shweta Kumari
 *2025-07-06
 */
package kumari.shweta.array;

/**
 * Given N array elements .Calculate maximum sub-array sum. arr[-3,2,4,-1,3,-4,3]
 * Output 8 is sum of sub array [2,4,-1,3]
 */
public class MaxmiumSubArraySum {
	
	/**
	 * TC ->O(N)  SC ->O(1)
	 * @param arr
	 * @return
	 */

	public static int findMaximumSubarraySum(int arr[]) {

		int sum = 0;
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum > result) {
				result = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		int arr[] = { -3, 2, 4, -1, 3, -4, 3 };
		int maxSumOfSubarry = findMaximumSubarraySum(arr);
		System.out.println("Maximum sum of sub array " + maxSumOfSubarry);

	}
}
