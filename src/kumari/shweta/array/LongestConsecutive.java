/**
 * @author Shweta Kumari
 *2024-10-06
 */
package kumari.shweta.array;

/**
 * Given a binary string A .It is allowed to do at most one replacement of 0 with 1 .
 * Find the length of longest consecutive 1's that can be achieved .
 * 
 * Eg Input A --> 01110110110 
 * Output replace zero at index 4 will create the longest consecutive string of 1 
 * Output -6
 * 
 * Eg Input A -> 11101111011000111011
 * Output Replace 0  with 1 at index 3  will give longest consecutive string .
 * output 8 
 *
 */
public class LongestConsecutive {

	// TC ->O(N)

	public int lengthOfLongestConsecutive(String str) {
		int ans = 0;
		int N = str.length();
		for (int i = 0; i < N; i++) {

			if (str.charAt(i) == '0') {

				int j = i - 1;
				int ls = 0;

				while (j >= 0 && str.charAt(j) == '1') { // Count 1 in left hand side .
					ls++;
					j--;
				}

				j = i + 1;
				int rs = 0;

				while (j < N && str.charAt(j) == '1') { // Count 1 in right hand side .
					rs++;
					j++;
				}

				ans = Math.max(ans, ls + rs + 1);

			}

		}

		if (ans == 0) { // If string str has no '0' only '1'
			ans = N;
		}

		return ans;
	}

	public static void main(String[] args) {

		String string = "01110110110";
		LongestConsecutive obj = new LongestConsecutive();
		int longestString = obj.lengthOfLongestConsecutive(string);
		System.out.println("Length of longest consecutive string with 1 is  " + longestString);

	}

}
