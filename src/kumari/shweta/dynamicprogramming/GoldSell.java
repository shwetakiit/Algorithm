/**
 * @author Shweta Kumari
 *2025-05-06
 */
package kumari.shweta.dynamicprogramming;


/*
You have N ornaments made of gold placed in a row. You have been given an array of N 
positive integers representing the base price of each ornament. Each day, you can choose to
sell either the leftmost or the rightmost gold ornament. If you sell an ornament on the Kth day,
its price becomes K times its base price. Your task is to find and return an integer value 
representing the maximum amount you can earn by selling all of these gold ornaments.
Note: You sell exactly one gold ornament each day.
Input Specification:
input1: An integer value N representing the number of gold ornaments.
input2: An integer array of size N representing the base price of each ornament.
Output Specification:
Return an integer value representing the maximum amount you can earn by selling all of the gold ornaments.
Example 1:
input1 : 5
input2: (2,4,6,2,5)
Output: 64

Explanation :Here optimal way to sell ornament is following 
 On Day1 we sell left most ornament (with a base price of 2 and Its effective price =1*2
 On Day2 we sell the right most ornament (With a base price of 5 and its effective price 2*5=10
 On Day3 we sell the right most ornament (With a base price of 2 and its effective price is 3*2)
 On Day 4 we sell left most ornament (with base of price 4 and effective  price 4*4=16)
 On Day5  we sell remaining  ornament(with base price of 6 and effective price 5*6=30
 The total amount obtained =2+10+6+16+30=64
 hence 64 is returned output 


*/
public class GoldSell {

	public static int sellGold(int input1, int[] input2) {

		int[][] dp = new int[input1][input1];
		for (int len = 1; len <= input1; len++) {
			for (int i = 0; i <= input1 - len; i++) {
				int j = i + len - 1;
				int day = input1 - len + 1;
				if (i == j) {
					dp[i][j] = input2[i] * day;
				} else {
					dp[i][j] = Math.max(input2[i] * day + dp[i + 1][j], input2[j] * day + dp[i][j - 1]);
				}
			}
		}
		return dp[0][input1 - 1];
	}

	public static void main(String[] args) {

		int basePrice[] = { 2, 4, 6, 2, 5 };
		int noOfGold = 5;
		System.out.println("Maximum price " + sellGold(noOfGold, basePrice));

	}
}
