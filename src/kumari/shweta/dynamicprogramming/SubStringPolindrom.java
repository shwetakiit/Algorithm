/**
 * @author Shweta Kumari
 *2024-02-11
 */
package kumari.shweta.dynamicprogramming;

/*Given a string A consisting of lowercase English alphabets. 
Your task is to find how many substrings of A are palindrome.
The substrings with different start indexes or end indexes are counted as different substrings even
if they consist of same characters.
Returned output is a matrix for each sub string of row index is start index of sub string and col index is end Index of substring
with filled value 1 for polindrom 0  not polindrom -1 invalid index for substring
*/
public class SubStringPolindrom {

	int[][] isSubStringPolindrom(String str) {
		int N = str.length();
		int dp[][] = new int[N][N];// 1 -> If Polindrom 0-> If not Polindrom ,-1 -> Invalid index

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
	  
		for (int gap = 0; gap < N; gap++) { // Gap 0 -> length of substring 1 ,gap 1 ->Length of substring 2 ,gap 2
											// -Length 3 , gap 3 -Length of substring 4

			int startIndex = 0;
			int endIndex = gap;
			while (endIndex < N) {
				if (gap == 0) { // Gap 0 mean diagonal element of dp grid and at diagonal index only one element one element is always polindrom.
					dp[startIndex][endIndex] = 1;
				} else if (gap == 1) {
					if (str.charAt(startIndex) == str.charAt(endIndex)) {
						dp[startIndex][endIndex] = 1;
					} else {
						dp[startIndex][endIndex] = 0;
					}
				} else {
					if (str.charAt(startIndex) != str.charAt(endIndex)) {
						dp[startIndex][endIndex] = 0;
					} else {
						dp[startIndex][endIndex] = dp[startIndex + 1][endIndex - 1];
					}

				}
				startIndex++;
				endIndex++;
			}
		}

		return dp;
	}

	public static void main(String[] args) {

		String string = "abac";
		SubStringPolindrom obj = new SubStringPolindrom();
		int dp[][] = new int[string.length()][string.length()];
		dp = obj.isSubStringPolindrom(string);
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < string.length(); j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println();

		}
	}
}
