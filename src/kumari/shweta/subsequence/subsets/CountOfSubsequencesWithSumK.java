/**
 * @author Shweta Kumari
 *2024-11-02
 */
package kumari.shweta.subsequence.subsets;

import java.util.ArrayList;
import java.util.List;

public class CountOfSubsequencesWithSumK {

// TC -> O(2^N *N)  SC ->O(1)
	public int noOfSubSequence(int arr[], int k) {

		int N = arr.length;
		int range = (int) Math.pow(2, N); // all possible binary arrangement of given array element to set and unset
		int result = 0;
		System.out.println("Subsequence of sum " + k);
		for (int i = 0; i < range; i++) {
			int sum = 0;
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					list.add(arr[j]);
					sum = sum + arr[j];

				}
			}

			if (sum == k) {
				System.out.println(list);
				result++;
			}

		}

		return result;
	}

	public static void main(String[] args) {

		int arr[] = { -1, 4, 6, 7, 3, 2 };
		CountOfSubsequencesWithSumK o = new CountOfSubsequencesWithSumK();
		int result = o.noOfSubSequence(arr, 10);

		System.out.println("Count of subsequence is ?" + result);
	}

}
