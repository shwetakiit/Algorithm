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

1 <= size(A), size(B) <= 10^6



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

		int freqA[] = new int[26]; // If Any character then we should take array of size 128 as per total Ascii and to find index we should not subtract  0(First Ascii of null)  eg freq[ch-0]--> freq[ch] 
		int freqB[] = new int[26];

		int N = B.length();

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
		while (right < A.length()) {

			if (compaire(freqA, freqB)) { // If frequency of A is available in frequency in B then try to release the character from freqB to make minimum length

				ans = Math.min(ans, right - left + 1);
				result = A.substring(left, right + 1);
				freqA[(A.charAt(left)) - 'a']--; // Release the character
				left++;
			} else { // If frequency of A is less in freqB then try to Acquire new element from String  B

				right++;
				if (right == A.length()) {
					break;
				}
				freqA[(A.charAt(right)) - 'a']++; // Acquire new character

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
		for (int i = 0; i < freqB.length; i++) {
			if (freqA[i] < freqB[i]) {
				return false;
			}

		}
		return true;

	}

	// Second way use HashMap instead of Array .In Array we need to find index  alphanumeric data for each uppercase,lowecase character/alphabet/numeric

	public String findMinLengthSubstring(String A, String B) {

		Map<Character, Integer> freqA = new HashMap<>();
		Map<Character, Integer> freqB = new HashMap<>();
		int M = A.length();
		int N = B.length();

		if (N > M) { // Eadge case , If length of String B is more then length of String A so we can't create String window of length B in String A .
			return "";
		}
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
		int minWindow = Integer.MAX_VALUE;
		int startIdx = -1;
		int endIdx = -1;
		while (right < M) {

			if (compaireWithCount(freqA, freqB)) {

				ans = Math.min(ans, right - left + 1);
				int currentWindow = right - left + 1;
				if (currentWindow < minWindow) {
					minWindow = currentWindow;
					startIdx = left;
					endIdx = right;
					result = A.substring(startIdx, endIdx + 1);
				}

				freqA.put(A.charAt(left), freqA.get(A.charAt(left)) - 1);
				left++;
			} else {
				right++;
				if (right == M) {
					break;
				}

				if (freqA.get(A.charAt(right)) != null) {
					freqA.put(A.charAt(right), freqA.get(A.charAt(right)) + 1);
				} else {

					freqA.put(A.charAt(right), 1);
				}

			}

		}
		System.out.println(result);

		return result;

	}

	private boolean compaireWithCount(Map<Character, Integer> freqA, Map<Character, Integer> freqB) {
		for (Character ch : freqB.keySet()) {
			if (freqA.get(ch) == null || freqA.get(ch) < freqB.get(ch)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		String A = "xatybaxacta";
		String B = "abca";

		String A2 = "o";
		String B2 = "w";
		
		WindowString obj = new WindowString();
		int result = obj.findMimumLengthSubstring(A, B);

		System.out.println(
				"Minimum length of sub string from Stribg B which contain all character of String A is " + result);

		String A1 = "ADOBECODEBANC";
		String B1 = "ABC";

		String out = obj.findMinLengthSubstring(A1, B1);
		System.out.println("Minimum length of substring wich contain String  " + out);
	}

}
