/**
 * @author Shweta Kumari
 *2023-05-02
 */
package kumari.shweta.subsequence.subsets;

/*Problem Description
Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".
Problem Constraints 1. 1 <= |A| <= 105  2. A only contains lowercase alphabets.
Input 1: A = "abcdsfhjagj"  output aa
input 2 : A = "ksdjgha"    ouput da
*/
public class LittlePonyandTwoSubsequences {
	public static String stringlexicographicMinSubsequence(String A) {

		char first = 'z';
		char second = 'z';
		int idx = -1;
		for (int i = 0; i < A.length() - 1; i++) {
			if (first > A.charAt(i)) {
				first = A.charAt(i);
				idx = i;
			}
		}
		for (int i = idx + 1; i < A.length(); i++) {
			if (second > A.charAt(i)) {
				second = A.charAt(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		sb.append(second);
		return sb.toString();
	}

	public static void main(String[] args) {
		String result = stringlexicographicMinSubsequence("ksdjgha");
		System.out.println("Result is " + result);
	}
}
