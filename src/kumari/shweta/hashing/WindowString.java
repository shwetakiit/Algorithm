/**
 * @author Shweta Kumari
 *2024-09-29
 */
package kumari.shweta.hashing;

import java.util.HashMap;
import java.util.Map;

/*

Problem Description

Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )



Problem Constraints

1 <= size(A), size(B) <= 106



Input Format

The first argument is a string A.
The second argument is a string B.
Output Format
Return a string denoting the minimum window.
Example Input
Input 1:
 A = "ADOBECODEBANC"
 B = "ABC"
Input 2:
 A = "Aa91b"
 B = "ab"
Example Output
Output 1:
 "BANC"
Output 2: "a91b"
*/
public class WindowString {

	public int findMimumLengthSubstring(String A, String B) {
		A = A.toLowerCase();
		B = B.toLowerCase();

		int freqA[] = new int[26];
		int freqB[] = new int[26];

		int N = A.length();

		for (int i = 0; i < N; i++) {

			char ch = A.charAt(i);
			freqA[ch - 'a'] += 1;
		}

		// Add first N character from String B

		for (int i = 0; i < N; i++) {
			char ch = B.charAt(i);
			freqB[ch - 'a'] += 1;
		}

		int left = 0, right = N - 1;
		int ans = Integer.MAX_VALUE;
		String result = "";
		while (right < B.length()) {

			if (compaire(freqA, freqB)) { // If freqeuncy of A is available in Freqency in B then try to release the
											// chacater from freqB to make minimum length

				ans = Math.min(ans, right - left + 1);
				result = B.substring(left, right + 1);
				freqB[(B.charAt(left)) - 'a']--; // Release the character
				left++;
			} else { // If freqency of A is less in freqB then try to Acquire new element from String
						// B

				right++;
				if (right == B.length()) {
					break;
				}
				freqB[(B.charAt(right)) - 'a']++; // Acquire new character

			}

		}

		System.out.println(result);
		return ans;

	}

	/**
	 * @param freqA
	 * @param freqB
	 * @return
	 */
	private boolean compaire(int[] freqA, int[] freqB) {
		for (int i = 0; i < freqA.length; i++) {
			if (freqA[i] > freqB[i]) {
				return false;
			}

		}
		return true;

	}

	// Second way use HashMap instead of freqency Array becase we can't find index
	// of array freqencyArray with [ch-'a]
	// In case letters are mix of Uppercase ,lowercase and numeric
	public String findMinLengthSubstring(String A, String B) {
		Map<Character, Integer> freqA = new HashMap<>();
		Map<Character, Integer> freqB = new HashMap<>();
		int N = A.length();
		int M = B.length();

		for (int i = 0; i < N; i++) {
			if (freqA.containsKey(A.charAt(i))) {
				freqA.put(A.charAt(i), freqA.get(A.charAt(i)) + 1);
			} else {
				freqA.put(A.charAt(i), 1);
			}
		}

		for (int i = 0; i < N; i++) {
			if (freqB.containsKey(B.charAt(i))) {
				freqB.put(B.charAt(i), freqB.get(B.charAt(i)) + 1);
			} else {
				freqB.put(B.charAt(i), 1);
			}
		}

		int left = 0, right = N - 1;
		String result = "";
		int ans = Integer.MAX_VALUE;

		while (right < M) {

			if (compaireWithCount(freqA, freqB)) {
				result = B.substring(left, right + 1);
				ans = Math.min(ans, right - left + 1);

				freqB.put(B.charAt(left), freqB.get(B.charAt(left)) - 1);
				left++;
			} else {
				right++;
				if (right == M) {
					break;
				}

				if (freqB.get(B.charAt(right)) != null) {
					freqB.put(B.charAt(right), freqB.get(B.charAt(right)) + 1);
				} else {

					freqB.put(B.charAt(right), 1);
				}

			}

		}
		System.out.println("Length of substring of B which contains all A " + ans);

		return result;
	}

	/**
	 * @param freqA
	 * @param freqB
	 * @return
	 */
	private boolean compaireWithCount(Map<Character, Integer> freqA, Map<Character, Integer> freqB) {
		for (Character ch : freqA.keySet()) {
			if (freqB.get(ch) == null || freqB.get(ch) < freqA.get(ch)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		String A = "abca";
		String B = "xatybaxacta";

		String A1 = "ABC";
		String B1 = "ADOBECODEBANC";

		String A2 = "o";
		String B2 = "w";
		WindowString obj = new WindowString();
		int result = obj.findMimumLengthSubstring(A1, B1);

		System.out.println(
				"Minimum length of sub string from Stribg B which contain all character of String A is " + result);

		String out = obj.findMinLengthSubstring(A1, B1);
		System.out.println("Minimum length of substring wich contain String  A" + out);
	}

}
