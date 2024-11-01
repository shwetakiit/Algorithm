/**
 * @author Shweta Kumari
 *2024-11-01
 */
package kumari.shweta.slidingwindow;

import java.util.Map;

/*
Given a string s, find the length of the longest substring without repeating characters. 

Examples:

Input: “ABCBC”
Output: 3
Explanation: The longest substring without repeating characters is “ABC”

Input: “AAA”
Output: 1
Explanation: The longest substring without repeating characters is “A”

Input: “GEEKSFORGEEKS”
Output: 7 
Explanation: The longest substrings without repeating characters are “EKSFORG” and “KSFORGE”, with lengths of 7.

 */
public class LengthOfLongestSubString {

	// TC --> O(N) SC --> O(1)--Accurate space is O(256)
	public int findLengthOfLongestString(String str) {

		boolean[] visited = new boolean[256]; // Total Ascii character are 256.

		if (str.length() <= 1) {
			return str.length();
		}

		int maxLength = Integer.MIN_VALUE;

		int startIdx = 0;
		int endIdx = 0;

		while (endIdx < str.length()) {

			while (visited[str.charAt(endIdx)]) {
				visited[str.charAt(startIdx)] = false;
				startIdx++;
			}
			visited[str.charAt(endIdx)] = true;
			maxLength = Math.max(maxLength, (endIdx - startIdx + 1));
			endIdx++;

		}

		return maxLength;
	}

	public static void main(String[] args) {

		LengthOfLongestSubString obj = new LengthOfLongestSubString();
		String string = "abcbadbd";
		System.out.println("Max length of Substring is" + obj.findLengthOfLongestString(string));

	}
}
