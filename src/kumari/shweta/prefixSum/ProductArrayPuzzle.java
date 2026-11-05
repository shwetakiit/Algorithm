/**
 * @author Shweta Kumari
 *2026-11-05
 */
package kumari.shweta.prefixSum;

/**

Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
Input Format
The only argument given is the integer array A.
Output Format
Return the product array.
Constraints
2 <= length of the array <= 1000
1 <= A[i] <= 10
For Example
Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]
Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]
 */


public class ProductArrayPuzzle {
	
	//TC --> O(N) SC -> O(N>

	public static void solve(int arr[]) {

		int N = arr.length;
		int prefix[] = new int[arr.length];
		int suffix[] = new int[arr.length];
		int result[] = new int[arr.length];
		prefix[0] = 1;
		suffix[N - 1] = 1;

		for (int i = 1; i < N; i++) {
			prefix[i] = prefix[i - 1] * arr[i - 1];
		}

		for (int i = N - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * arr[i + 1];
		}

		for (int i = 0; i < N; i++) {
			result[i] = prefix[i] * suffix[i];
		}

		for (int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, };
		solve(arr);
	}
}
