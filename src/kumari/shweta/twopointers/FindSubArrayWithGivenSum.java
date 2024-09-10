/**
 * @author Shweta Kumari
 *2024-09-10
 */
package kumari.shweta.twopointers;

import java.util.ArrayList;


/*
 * Problem Description Given an array of positive integers A and an integer B,
 * find and return first continuous subarray which adds to B.
 * If the answer does not exist return an array with a single integer "-1".
 * First sub-array means the sub-array for which starting index in minimum.
 * 
 * Problem Constraints 1 <= length of the array <= 100000 1 <= A[i] <= 109 1 <=
 * B <= 109
 * 
 * Input Format The first argument given is the integer array A.
 * 
 * The second argument given is integer B.
 * 
 * Output Format Return the first continuous sub-array which adds to B and if
 * the answer does not exist return an array with a single integer "-1".
 *
 * Example Input Input 1:
 *  A = [1, 2, 3, 4, 5] B = 5 Input 2:
 *  A = [5, 10, 20, 100, 105] B = 110
 * Example Output
 * Output 1:  [2, 3] 
 * Output 2: [-1]
 * Example Explanation Explanation 1:
 * 
 * [2, 3] sums up to 5. Explanation 2:
 * 
 * No subarray sums up to required number.
 */
public class FindSubArrayWithGivenSum {

	public ArrayList<Integer> findSubArray(int arr[], int target) {

		int prefixSum[] = new int[arr.length];
		findPrefixSum(arr, prefixSum);
		int i = 0;
		int j = 1;

		ArrayList<Integer> subArrayList = new ArrayList<>();

		if (prefixSum[1] - prefixSum[0] == target) {// Edge case handled which is going to miss in while loop .
			subArrayList.add(arr[1]);
		}

		while (j < arr.length) {

			int diff = 0;
			if (i == 0) {
				diff = prefixSum[j];

			} else {
				diff = prefixSum[j] - prefixSum[i - 1];
			}

			if (diff == target) {

				for (int k = i; k <= j; k++) {

					subArrayList.add(arr[k]);

				}
				break;
			} else if (diff < target) {
				j++;
			} else {
				i++;
				if (i == j) {
					j++;
				}
			}
		}

		if (subArrayList.size() == 0) {
			subArrayList.add(-1);
		}

		return subArrayList;

	}

	/**
	 * @param arr
	 * @param prefixSum
	 */
	private void findPrefixSum(int[] arr, int[] pf) {

		pf[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			pf[i] = pf[i - 1] + arr[i];
		}

	}

	public static void main(String[] args) {
		FindSubArrayWithGivenSum obj = new FindSubArrayWithGivenSum();

		// int arr[]= {1, 2, 3, 4, 5};
		// int target=5;

		int arr[] = { 1, 1000 };
		int target = 1000;

		System.out.println(obj.findSubArray(arr, target));
	}
}
