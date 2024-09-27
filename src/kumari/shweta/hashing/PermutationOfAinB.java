/**
 * @author Shweta Kumari
 *2024-09-27
 */
package kumari.shweta.hashing;


/*
Problem Description
You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
Problem Constraints
1 <= N < M <= 105
Input Format
Given two arguments, A and B of type String.
Output Format
Return a single integer, i.e., number of permutations of A present in B as a substring.
Example Input
Input 1:
 A = "abc"
 B = "abcbacabc"
Input 2:
 A = "aca"
 B = "acaa"
 
Output 1: 5
Output 2:2
*/

public class PermutationOfAinB {
	
	public int noOfPremutaionAinB(String A, String B) {

		int[] freqA = new int[26];
		int[] freqB = new int[26];

		for (int i = 0; i < A.length(); i++) {

			char ch = A.charAt(i);
			freqA[ch - 'a'] += 1;

		}

		for (int i = 0; i < A.length(); i++) { // First window of sub string from index 0 to A.length in B

			char ch = B.charAt(i);
			freqB[ch - 'a'] += 1;

		}

		int count = 0;

		if (compare(freqA, freqB)) {
			count++;
		}

		for (int i = A.length(); i < B.length(); i++) { // Index start from size of A because first substring we have
														// already checked .
			freqB[B.charAt(i) - 'a']++;
			freqB[B.charAt(i - A.length()) - 'a']--;
			if (compare(freqA, freqB)) {
				count = count + 1;
			}

		}

		return count;

	}

	private boolean compare(int[] freqA, int[] freqB) {

		for (int i = 0; i < freqA.length; i++) {
			if (freqA[i] != freqB[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String A = "abcd";
		String B = "bacdgabcda";
		PermutationOfAinB obj = new PermutationOfAinB();
		int countPair = obj.noOfPremutaionAinB(A, B);
		System.out.println("No of permutation" + countPair);
	}
}
