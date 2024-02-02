/**
 * @author Shweta Kumari
 *2024-02-01
 */
package kumari.shweta.dynamicprogramming;

/**
 
   Problem Description
   Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
   ' ? ' : Matches any single character.
   ' * ' : Matches any sequence of characters (including the empty sequence).
   The matching should cover the entire input string (not partial).

  Output Format
  Return 1 if the patterns match else return 0.
  
  **/
public class WildCardPatternMatching {

	int checkMatchingWithPattern(String s1, String s2, int i, int j, int dp[][]) {
		// Base cases
		if (i < 0 && j < 0) { //If String and matching pattern string both are empty 
			return 1;
		}
		if (j < 0 && i >= 0) { //If String is not empty but matching pattern string is empty 
			return 0;
		}
		if (i < 0 && j >= 0) {
			for (int x = 0; x <= j; x++) {
				char ch = s2.charAt(x);
				if (ch != '*') {
					return 0;
				}
			}
			return 1;
		}

		if (dp[i][j] != -1) {// If result is already calculated
			return dp[i][j];
		}

		// High level code
		if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?') {//If matchi

			int res = checkMatchingWithPattern(s1, s2, i - 1, j - 1, dp);
			dp[i][j] = res;
			return res;
		}

		if (s2.charAt(j) == '*') {
			int a = checkMatchingWithPattern(s1, s2, i - 1, j, dp);
			int b = checkMatchingWithPattern(s1, s2, i, j - 1, dp);

			if (a == 1 || b == 1) {
				dp[i][j] = 1;
				return 1;
			}
		}

		dp[i][j] = 0;
		return 0;

	}

	public static void main(String[] args) {
		WildCardPatternMatching obj = new WildCardPatternMatching();
		// Case 1:
		// String s1="xbbzz";
		// String s2="x*z***?";
		// Case 2:
		final String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		final String s2 = "a**************************************************************************************";

		// To optimize and avoid heap memory error if consecutive multiple * is there
		// covert in single *.
		StringBuilder st = new StringBuilder();
		// Add first character
		st.append(s2.charAt(0));
		for (int i = 1; i < s2.length(); i++) {
			if (s2.charAt(i) == '*' && s2.charAt(i - 1) == '*') {
				continue;
			} else {
				st.append(s2.charAt(i));
			}

		}

		int N = s1.length();
		int M = st.toString().length();

		int dp[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = -1;
			}
		}
		int isMatched = obj.checkMatchingWithPattern(s1, st.toString(), N - 1, M - 1, dp);
		System.out.println("Is string s1 matched with pattern matching string s2  yes :1 no :0  result is " + isMatched);

	}

}
