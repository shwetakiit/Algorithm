/**
 * @author Shweta Kumari
 *2024-02-18
 */
package kumari.shweta.dynamicprogramming;

import java.util.Arrays;

/*
Given a string A, partition A such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of A.
Input aba -->output 0 
*/

public class PolindromPartioning {

	int findMinimumCut(String str) {
		
		int N= str.length();
		int dp[][] = new int[N][N];//	Intialize dp with -1
		for(int[] row:dp) { 
			
			Arrays.fill(row, -1);
		}
		
		int noOfCut= minCut(str,0,N-1,dp);
		
		return noOfCut;
		
	}
	
	/**
	 * @param str
	 * @param i
	 * @param j
	 * @param dp
	 * @return
	 */
	private int minCut(String str, int si, int ei, int[][] dp) {
		Integer   cut=Integer.MAX_VALUE;
		if(  si>=ei ||checkPolindrom(str,si,ei)==true)
		{
			return 0;
		}
		if(dp[si][ei]!=-1) {
			return dp[si][ei];
		}
		for(int cp=si;cp<ei;cp++) {
			if(checkPolindrom(str, si,cp)==true) {
				cut=Math.min(cut, 1+minCut(str,cp+1, ei,dp));
				
			}
			
		}
		dp[si][ei]=cut;
		return dp[si][ei];
	}



	/**
	 * @param str
	 * @param si
	 * @param ei
	 * @return
	 */
	private boolean checkPolindrom(String str, int si, int ei) {
		while(si<ei) {
			if(str.charAt(si)!=str.charAt(ei)) {
				return false;
			} 
			si++;
			ei--;
		}
		return true;
	}

	public static void main(String[] args) {
		PolindromPartioning obj = new PolindromPartioning();
		String str = "cbcacbbc";
		String str1="abbcbc";
		int minCut=obj.findMinimumCut(str1);
		System.out.println("Minium cut to partition polindrom substring is "+minCut);
		
	}
}

