/**
 * @author Shweta Kumari
 *2025-12-18
 */
package kumari.shweta.carryforward;
/**
 * 
 * 
 * You are given a string S, and you have to find all the amazing substrings of S.An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U) 
 * Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
Arg 1: A single String, For e.g 'anagram'
 * 
 */



public class AmazingSubArray {

	public static int amazingSubArray(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isVolwel(str.charAt(i))) {
				count = (count + (str.length() - i)) % 10003;
			}
		}

		return count;

	}

	public static boolean isVolwel(Character ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U') {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String string = "ABEC";
		System.out.println("Count amazing charater" + amazingSubArray(string));
	}
}
