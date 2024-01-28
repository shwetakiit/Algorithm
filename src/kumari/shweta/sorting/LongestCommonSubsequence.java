/**
 * @author Shweta Kumari
 *2024-01-28
 */

/*
 * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
   You need to return the length of such longest common subsequence.
   Input  A = "abbcdgf"  B = "bbadcgf"  Output Longest common string is bbcgf 
 */
package kumari.shweta.sorting;

public class LongestCommonSubsequence {
	int LCS(String s1, String s2, int i, int j, int dp[][]) {

		if (i <= 0 || j <= 0) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //If last character of both substring are equals then add +1 to count of longest subString length
			dp[i][j] = 1 + LCS(s1, s2, i - 1, j - 1, dp);
		} else {  
			dp[i][j] = Math.max(LCS(s1, s2, i - 1, j, dp), LCS(s1, s2, i, j - 1, dp));
		}
		return dp[i][j];
	}

	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "aebd";
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s2.length(); i++) {
			dp[1][i] = 0;
		}
		for (int i = 0; i <= s1.length(); i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				dp[i][j] = -1;
			}
		}

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		 
		int longestSubString = obj.LCS(s1, s2, s1.length(), s2.length(), dp);
		System.out.println("Longest sub string " + longestSubString);
	}

}
