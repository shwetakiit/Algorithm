/**
 * @author Shweta Kumari
 *2024-01-16
 */
package kumari.shweta.sorting;

/**
 *Problem Description
 *Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
 *Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
 * Problem Constraints 1 <= N <= 1000 0 <= A[i] <= 106
 *
 *Output Format ->Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.
 *
 **/
public class RodCutting {

	int maxValue(int prices[]) {

		int lengthOfRod = prices.length;
		int dp[] = new int[lengthOfRod + 1]; // Store the maximum selling price with corresponding length of rod.
		dp[0] = 0; // For zero length cost is 0.

		for (int i = 1; i <= lengthOfRod; i++) {
			dp[i] = prices[i - 1];
		}
		for (int i = 2; i <= lengthOfRod; i++) {
			int left = 0;
			int right = i;
			while (left <= right) {
				dp[i] = Math.max(dp[i], dp[left] + dp[right]);
				left++;
				right--;

			}

		}
		return dp[lengthOfRod];
	}

	public static void main(String[] args) {
		RodCutting obj = new RodCutting();
		int prices[] = { 1, 4, 2, 5, 6 };
		int maxSellingPrice = obj.maxValue(prices);
		System.out.println("Maxium selling price to sell the complete rod is " + maxSellingPrice);

	}

}
