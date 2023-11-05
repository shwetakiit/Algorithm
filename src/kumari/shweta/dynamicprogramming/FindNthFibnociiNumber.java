/**
 * @author Shweta Kumari
 *2023-11-05
 */
package kumari.shweta.dynamicprogramming;

/**
 * Find nth fibnoccii no using dynamic programming -> Don't call recursive function for  those element for that we have already result .
 *
 */

public class FindNthFibnociiNumber {
	int result = 0;

	int fib(int N, int dp[]) {
		if (N <= 1) {
			return N;
		}
		// If already solved then don't solve it again
		if (dp[N] != -1) {
			return dp[N];
		}
		result = fib(N - 1, dp) + fib(N - 2, dp);
		dp[N] = result;
		return result;
	}

	public static void main(String[] args) {
		int N = 5;
		int dp[] = { -1, -1, -1, -1, -1, -1 }; // 5 -> 0,1,1,2,3,5 total 6 fibnocii and 5th one is 5 so size of array is
												// N+1
		FindNthFibnociiNumber obj = new FindNthFibnociiNumber();
		int nthFib = obj.fib(N, dp);
		System.out.println("Nth Fibnocci number is " + nthFib);
	}
}
