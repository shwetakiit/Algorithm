/**
 * @author Shweta Kumari
 *2024-10-22
 */
package kumari.shweta.string;


/**
 * Find length of Longest Polindrom ;
 * @author Shweta Kumari
 *
 */

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
	 * Brute force approach --Consider all substring and check is it polindrom If
	 * yes ,check Is it longest polindrom TC -> O(N^3)
	 */
	int longestPolidrom(String str) {

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {

				if (isPolindrom(str, i, j)) {

					result = Math.max(result, j - i + 1);

				}
			}
		}
		return result;

	}

	public static void main(String[] args) {

		String str = "aaaabaaa";

		LengthOfLongestPolindromSubString o = new LengthOfLongestPolindromSubString();

		System.out.println("Longest polindrom length is " + o.longestPolidrom(str));

	}

}
