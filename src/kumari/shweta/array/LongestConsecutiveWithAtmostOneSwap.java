/**
 * @author Shweta Kumari
 *2024-10-07
 */
package kumari.shweta.array;

/*

Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.

Input Format
The only argument given is string A.
Output Format
Return the length of the longest consecutive 1’s that can be achieved.
Constraints
1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example
Input 1:
    A = "111000"
Output 1:
    3
Input 2:
    A = "111011101"
Output 2:
    7
    
*/

public class LongestConsecutiveWithAtmostOneSwap {

	// TC -> O(N)
	public int longestConsecutiveWithOneSwap(String str) {

		int totalCount = 0;
		int N = str.length();
		int result = 0;

		for (int i = 0; i < N; i++) {

			if (str.charAt(i) == '1') {
				totalCount++;
			}
		}

		if (totalCount == 0) { // If String has no 1
			return 0;
		}
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == '0') {
				int j = i - 1;
				int ls = 0, rs = 0;
				while (j >= 0 && str.charAt(j) == '1') { // Left count of 1 for this 0
					ls++;
					j--;
				}

				j = i + 1;

				while (j < N && str.charAt(j) == '1') { // Right count of 1 for this 0
					rs++;
					j++;
				}

				if ((ls + rs) == totalCount) { // If string like 1110111 If only one 0
					result = Math.max(result, (ls + rs));
				} else {
					result = Math.max(result, (ls + rs + 1)); // Left count +right count + 1 swapped which comes from other sequence
				}

			}

		}

		if (result == 0) {
			return N;
		}

		return result;
	}

	public static void main(String[] args) {

		LongestConsecutiveWithAtmostOneSwap obj = new LongestConsecutiveWithAtmostOneSwap();

		String input1 = "110101011";
		String input2 = "1110111";

		int result = obj.longestConsecutiveWithOneSwap(input1);

		System.out.println("Longest consecutive string length is " + result);

	}

}
