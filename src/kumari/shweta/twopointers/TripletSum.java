/**
 * @author Shweta Kumari
 *2024-08-29
 */
package kumari.shweta.twopointers;

/*
 Given arr[N]  with sorted distinct elements find triplet
 (i,j,k) such that arr[i]+arr[j]+arr[k]=sum 14.(i!=j!=k)
*/

public class TripletSum {

	/*Note : Sort this array first If It is not in sorted form 
	
	TC-> O(N^2) 
	
	*/
	public int tripletCount(int arr[], int target) {

		// Arrays.sort(arr)
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			int pairSum = target - arr[i];

			count = count + findPairSumCount(arr, pairSum, i, arr[i]);
		}

		return count;

	}

	/**
	 * @param arr
	 * @param pairSum
	 * @param i
	 */
	private int findPairSumCount(int[] arr, int pairSum, int fixPointIdx, int firstElement) {

		int i = fixPointIdx + 1;
		int j = arr.length - 1;

		int count = 0;
		while (i < j) {
			if (arr[i] + arr[j] == pairSum) {
				System.out.println("Triplet is {" + firstElement + "," + arr[i] + "," + arr[j] + "}");
				count++;
				i++;
				j--;

			} else if (arr[i] + arr[j] < pairSum) {
				i++;
			} else {
				j--;
			}
		}

		return count;

	}

	public static void main(String[] args) {

		TripletSum obj = new TripletSum();
		int arr[] = { -8, -4, -3, -1, 2, 3, 5, 7, 9 };
		int sum = 14;
		int count = obj.tripletCount(arr, sum);
		System.out.println("Pair count is " + count);
	}
}
