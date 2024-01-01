/**
 * @author Shweta Kumari
 *2024-01-01
 */
package kumari.shweta.dynamicprogramming;

/*Problem Description
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.

Problem Constraints
1 <= A <= 1000 1 <= |B| <= 1000 1 <= B[i] <= 1000 1 <= C[i] <= 1000

Input Format
Array of happiness and Weight of each happiness and total Capacity 

Output Format
Return the maximum value that fills the knapsack completely

Eg. Input  Happiness [2,3,5] Weight[3,4,7] W=8 
Output 6 
Explanation Take happiness 3 two times of weight 4  so total Happiness 3+3 and Weight 4+4

**/

public class UnboundedKnapSack {

	// TC O(N*W) Where N is length of happiness array and Weight is W.

	int findMaxHappiness(int h[], int w[], int W) {
		
		int dp[][] = new int[h.length + 1][W + 1];
		for (int i = 0; i <= h.length; i++) {

			for (int j = 0; j <= W; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= h.length; i++) {
			for (int j = 1; j <= W; j++) {
				dp[i][j] = dp[i - 1][j];
				if (i <= w.length && j - w[i - 1] >= 0) {
					dp[i][j] = Math.max(0 + dp[i - 1][j], h[i - 1] + dp[i][j - w[i - 1]]);
				}
			}
		}

		return dp[h.length][W];
	}

	public static void main(String[] args) {
		// int h[] = {8,5,12};
		// int w[] = {3,2,4};
		// Capacity=5

		int h[] = { 2, 3, 5 };
		int w[] = { 3, 4, 7 };
		int capacity = 8;
		UnboundedKnapSack obj = new UnboundedKnapSack();
		int maxHappiness = obj.findMaxHappiness(h, w, capacity);
		System.out.println("Find Maximum happiness " + maxHappiness);

	}
}
