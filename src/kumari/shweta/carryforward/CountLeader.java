/**
 * @author Shweta Kumari
 *2025-10-08
 */
package kumari.shweta.carryforward;

/**
 * 
 *
 */
public class CountLeader {
	
	/**
	 * @param arr
	 * TC -> O(N^2)
	 * SC ->O(1)
	 */
	private static int countLeaderBruteForceApproach(int[] arr) {
		
		if(arr==null || arr.length==0) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= arr[i]) {
					flag = false;
					break;

				}
			}
			if (flag) {
				count++;
			}
		}
		return count;

	}

	/**
	 * TC -> O(N) SC -> O(1)
	 */
	private static int countOfLeader(int[] arr) {
	
		if(arr==null || arr.length==0) {
			return 0;
		}
		
		int count = 1; // Last element is always leader so count=1
		int max = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max) {
				count++;
				max = arr[i];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 1, 3, 7, 4, 5 };
		System.out.println("Leader count " + countOfLeader(arr));
		System.out.println("Leader count " + countLeaderBruteForceApproach(arr));
		}
}
