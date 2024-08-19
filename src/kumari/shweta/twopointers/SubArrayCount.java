/**
 * @author Shweta Kumari
 *2024-08-19
 */
package kumari.shweta.twopointers;

/*
 * Given an array of +ve integer , find count of sub arrays with sum=k.
 * 
 * input []={3,2,5,1,8,6,2,10} k=15 
 * 
 * Output pair [1,8,6]  only one pair with sum 15 i.e. result -1 
 */
public class SubArrayCount {

	/*
	 * 1.Find Prefixsum of array elements 2. Apply Binary search to find pair with
	 * differences K
	 */
	private static int findCountOfSubArray(int[] arr, int k) {

		int prefixSum[] = new int[arr.length];

		findPrefixSum(arr, prefixSum);
		int i = 0;
		int j = 1;
		int count = 0;
		while (j < arr.length) {
			int diff = 0;
			if (i == 0) {
				diff = prefixSum[j];
			} else {
				diff = prefixSum[j] - prefixSum[i - 1];
			}

			if (diff == k) {
				//System.out.println(prefixSum[j] + " ," + prefixSum[i-1]);
				i++;
				j++;
				count++;
			} else if (diff < k) {
				j++;
			} else {
				i++;
				if (i == j) {//While iteration ,i should not be equal to J .If equal increase J 
					j++;
				}
			}
		}

		return count;

	}

	/**
	 * Find prefix sum of array element
	 * 
	 * @param arr
	 * @return
	 */

	private static void findPrefixSum(int[] arr, int pf[]) {

		pf[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			pf[i] = pf[i - 1] + arr[i];
		}
	}

	public static void main(String[] args) {

		int arr[] = { 3, 2, 5, 1, 8, 6, 2, 10 };
		int k = 15;
		int paircount = findCountOfSubArray(arr, k);
		System.out.println("Pair count is " + paircount);
	}

}
