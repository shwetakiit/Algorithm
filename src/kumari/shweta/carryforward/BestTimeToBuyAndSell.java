/**
 * @author Shweta Kumari
 *2025-12-11
 */
package kumari.shweta.carryforward;

/*Problem Description
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.
Problem Constraints
0 <= A.size() <= 700000
1 <= A[i] <= 10^7
Input Format The first and the only argument is an array of integers, A.
Output Format Return an integer, representing the maximum possible profit.
Example Input
Input 1: A = [1, 2] Expected Output - 1
Input 2: A = [1, 4, 5, 2, 4] Expected Output -4*/

public class BestTimeToBuyAndSell {

	public static void findMaxProfit(int stockPrice[]) {

		int N = stockPrice.length;
		if (N < 2) { // Need at least 2 days to make profit.
			return;
		}

		int maxProfit = 0;
		int maxStockPrice = stockPrice[N - 1];
		int buyDay = -1;
		int sellDay = N - 1;

		for (int i = N - 2; i >= 0; i--) {
			if (stockPrice[i] > maxStockPrice) {
				maxStockPrice = stockPrice[i];

			}

			int profit = maxStockPrice - stockPrice[i];
			if (profit > maxProfit) {
				maxProfit = profit;

			}
		}

		if (maxProfit > 0) {

			System.out.println("Max profit " + maxProfit);
		} else {
			System.out.println("No profitable transaction possible");
		}

	}

	public static void main(String[] args) {

		int stockPrice[] = new int[] { 7, 1, 5, 3, 6, 4 };
		findMaxProfit(stockPrice);
	}
}
