/**
 * @author Shweta Kumari
 *2024-08-16
 */
package kumari.shweta.searching;

/**
 * Given arr[N] with sorted distinct elements .Count all the pairs (i,j) such
 * that arr[i]+arr[j]=k and i!=j
 *
 */
public class PairSum {

	public int countPair(int arr[], int K) {
		int i = 0;
		int count = 0;
		int j = arr.length - 1;
		while (i <= j) {
			if (arr[i] + arr[j] == K) {
				count++;
				i++;
				j--;
			} else if (arr[i] + arr[j] < K) {
				i++;
			} else {
				j--;
			}
		}

		return count;

	}

	public static void main(String[] args) {

		int arr[] = { -3, 0, 1, 3, 6, 8, 11, 14, 18, 25 };
		int k = 17;
		PairSum obj = new PairSum();
		int count = obj.countPair(arr, k);
		System.out.println("No of pairs is " + count);
	}
}
