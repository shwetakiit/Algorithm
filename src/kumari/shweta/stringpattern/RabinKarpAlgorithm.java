/**
 * @author Shweta Kumari
 *2024-10-03
 */
package kumari.shweta.stringpattern;

/*

Problem Description

Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of occurrences of B in A.


Problem Constraints

1 <= M <= N <= 105



Input Format

Two argument A and B are strings


Output Format

Return an integer denoting the number of occurrences of B in A
Example Input
Input 1:A = "acbac"  B = "ac"
Input 2: A = "aaaa" B = "aa"
Example Output Output 1: 2 Output 2: 3
Example Explanation
For Input 1:
The string "ac" occurs twice in "acbac".
For Input 2:
The string "aa" occurs thrice in "aaaa".

*/
public class RabinKarpAlgorithm {

	int findOccuranceOfBinA(String A, String B) {

		int mod = (int) 1e9 + 7;

		int n = A.length();
		int m = B.length();

		int BWieght = 0;
		int window = 0;
		int p = 29;
		for (int i = 0; i < m; i++) {

			char Bch = B.charAt(i);
			char Ach = A.charAt(i);
			BWieght = (BWieght + ((Bch - 'a' + 1) * (int) Math.pow(29, m - i - 1))) % mod;
			window = (window + ((Ach - 'a' + 1) * (int) Math.pow(29, m - i - 1))) % mod;

		}

		int index = m;
		int answer = 0;
		if (window == BWieght) {
			answer++;
		}

		while (index < n) {

			int Hnew = (window - (A.charAt(index - m) - 'a' + 1) * (int) Math.pow(29, m - 1)) * 29;
			window = Hnew + (A.charAt(index) - 'a' + 1);

			if (window == BWieght) {
				answer++;

			}
			index++;
		}

		return answer;
	}

	public static void main(String[] args) {

		RabinKarpAlgorithm obj = new RabinKarpAlgorithm();

		String A = "acbac";
		String B = "ac";

		int countOccurance = obj.findOccuranceOfBinA(A, B);

		System.out.println("Occurance " + countOccurance);

	}

}
