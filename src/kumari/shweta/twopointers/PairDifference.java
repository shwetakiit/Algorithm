/**
 * @author Shweta Kumari
 *2024-08-18
 */
package kumari.shweta.twopointers;



import java.util.Arrays;

/*
 * Given arr n with sorted distinct elements count of all the pairs (i,j) such
 * that arr[j]-arr[i]==k and i!=j
 */
class PairDifference {

	public static int pairCount(int arr[], int K) {

		int i = 0, j = 1;
		int count = 0;
		Arrays.sort(arr);

		while (j < arr.length) {
			if (arr[j] - arr[i] == K) {
				i++;
				j++;
				count++;
			} else if (arr[j] - arr[i] < K) {

				j++;
			} else {
				i++;
				if (i == j) {
					j++;
				}
			}
		}

		return count;

	}

	public static void main(String[] args) {

		int arr[] = { -3, 0, 1, 3, 6, 8, 11, 14, 18, 25, 30 };
		int K = 5;
		int countPair = pairCount(arr, K);
		System.out.println("No of pair with difference K is " + countPair);

	}
}
