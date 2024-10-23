/**
 * @author Shweta Kumari
 *2024-10-22
 */
package kumari.shweta.string;


public class LengthOfLongestPolindromSubString {

	// First check String is polindrom or not

	boolean isPolindrom(String str, int leftIdx, int rightIdx) {

		int i = leftIdx;
		int j = rightIdx;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	/*
	 * Brute force approach --Consider all substring and check is it polindrom If yes ,
	 *check Is it longest polindrom TC -> O(N^3)
	 */
	int longestPolidrom(String str) {

		int result = Integer.MIN_VALUE;
		int startIdx = 0;
		int endIdx = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {

				if (isPolindrom(str, i, j)) {

					if (result < (j - i + 1)) {
						result = (j - i + 1);
						startIdx = i;
						endIdx = j;
					}

					// result = Math.max(result, j - i + 1);

				}
			}
		}
		System.out.println(str.substring(startIdx, endIdx + 1));
		return result;

	}
	
	
	public int expandPolindrom(String str, int leftIdx, int rightIdx, StringBuilder longestPolindrom, int result) {

		while (leftIdx >= 0 && rightIdx < str.length() && str.charAt(leftIdx) == str.charAt(rightIdx)) {
			leftIdx--;
			rightIdx++;
		}

		if (result < (rightIdx - leftIdx - 1)) {

			longestPolindrom.setLength(0);
			longestPolindrom.append(str.substring(leftIdx + 1, rightIdx));
		}
		return rightIdx - leftIdx - 1;
	}
	
	
	/*
	 * Optimized approach in TC ->O(N^2)
	 */

	public int longestPolindromSubString(String str) {

		int N = str.length();
		int result = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder();

		// If Index point is even
		for (int i = 0; i < N; i++) {
			result = Math.max(result, expandPolindrom(str, i, i, sb, result));
		}

		// If index point is odd

		for (int i = 0; i < N - 1; i++) {
			result = Math.max(result, expandPolindrom(str, i, i + 1, sb, result));
		}

		System.out.println("Longest polindrom is " + sb.toString());

		return result;

	}

	public static void main(String[] args) {

		// String str = "abb";
		String str = "abacab";

		LengthOfLongestPolindromSubString o = new LengthOfLongestPolindromSubString();

		System.out.println("Longest polindrom length is " + o.longestPolidrom(str));

		System.out.println("Longest polindrom aptimized is " + o.longestPolindromSubString(str));

	}

}
