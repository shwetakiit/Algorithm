/**
 * @author Shweta Kumari
 *2023-11-08
 */
package kumari.shweta.dynamicprogramming;

import java.util.Arrays;

/**
 *Problem Description
 *Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 *Problem Constraints 1 <= A <= 105
 *Input Format - First and only argument is an integer A. 
 *Output Format -Return an integer denoting the minimum count.
 */
public class MiniumNoOfSqaure {
	
	
	public int minPerfectSqaure(int num) {
		int dp[] = new int[num+1];
		Arrays.fill(dp,-1);
        int result=Integer.MAX_VALUE;
        int ans = 0;
        ans=
		minPfSqaure(num,dp,result);
        return ans;
		
	}
	/**
	 * @param num
	 * @param dp
	 * @return
	 */
	private int minPfSqaure(int num, int[] dp,int result) {
		if(num==0) {
			return 0;
		}
		if(dp[num]!=-1) {
			return dp[num];
		}
		
		for(int i =1;i*i<=num;i++) {
			result=Math.min(result,minPfSqaure(num-(i*i),dp,result));
		}
		dp[num]=result+1;
		return result+1;
	}
	public static void main(String[] args) {
		MiniumNoOfSqaure obj = new MiniumNoOfSqaure();
		int result=obj.minPerfectSqaure(12);
		System.out.println("Minimum no of perfect square is "+result);
		}

}
