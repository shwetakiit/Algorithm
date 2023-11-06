/**
 * @author Shweta Kumari
 *2023-11-06
 */
package kumari.shweta.dynamicprogramming;

import java.util.Arrays;

/*
 *  Problem Description
   You are climbing a staircase and it takes A steps to reach the top.
   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
   Return the number of distinct ways modulo 1000000007
   
   Problem Constraints
   1 <= N <= 10pow5
   
   Input Format :
   The first and the only argument contains an integer A, the number of steps.

   Output Format
   Return an integer, representing the number of ways to reach the top.
   
   Example input No of steps 3 output  output total 3 way --(1,1,1),(1,1,2),(2,1,1)   
  
 * 
 */
public class ClimbingStairs {

	int result = 0;

	int wayToReachTop(int N) {
		int dp[] = new int[N + 1];
		Arrays.fill(dp, -1); // Initially fill storage array with -1
		int totalWay = stepsToReach(N, dp);

		return totalWay;

	}

	/**
	 * Top down approach of Dynamic programming which is optimizing the recursive
	 * call by storing the function call result
	 * 
	 * @param n
	 * @param dp
	 * @return
	 */
	private int stepsToReach(int n, int dp[]) {
		if (n ==1) { // If n=1 only one step then return 1 way if n=2 then there is two to reach
						// (1,1) steps or 2 step at a time
			return 1;
		}
		if(n==2) {
			return 2;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		result = stepsToReach(n - 1, dp) + stepsToReach(n - 2, dp);
		dp[n] = result;
		return result;
	}

	public static void main(String[] args) {

		ClimbingStairs obj = new ClimbingStairs();
		int totalWay = obj.wayToReachTop(4);
		System.out.println("Total way to reach on top of stair is " + totalWay);
	}
}
