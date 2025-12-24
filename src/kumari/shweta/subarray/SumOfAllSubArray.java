/**
 * @author Shweta Kumari
 *2025-12-24
 */
package kumari.shweta.subarray;

public class SumOfAllSubArray {

	// Brute force approach TC --> O(N^3) SC -> O(1)
	public static void findSumOfAllSubArray(int arr[]) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = i; j < arr.length; j++) {

				int sum = 0;

				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				System.out.println("all sub array sum from index " + i + "to  index " + j + " " + sum);
			}
		}

	}

	// With Prefix sum approach TC --> O(N^2) SC --> O(N)

	public static void subOfAllSubArrayWithPrefix(int arr[]) {

		int pf[] = buildPrefixSum(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {

				int sum = 0;
				if (i == 0) {
					sum = pf[j];
				} else {
					sum = pf[j] - pf[i - 1];
				}

				System.out.println("sub array sum from index " + i + " to index  " + j + " " + sum);
			}
		}

	}

	private static int[] buildPrefixSum(int arr[]) {

		int pf[] = new int[arr.length];
		pf[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			pf[i] = pf[i - 1] + arr[i];
		}

		return pf;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 8, 9 };
		findSumOfAllSubArray(arr);

		System.out.println("\n\n\n");

		subOfAllSubArrayWithPrefix(arr);
	}
}
