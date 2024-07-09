/**
 * @author Shweta Kumari
 *2024-07-09
 */
package kumari.shweta.backtracking;

/*Given a number n, the task is to generate all possible n pairs of balanced parentheses.
* Examples: 
 Input: n=1
Output: {}
Explanation: This the only sequence of balanced parenthesis formed using 1 pair of balanced parenthesis.

Input : n=2
Output: {}{}
{{}}
Explanation: This the only two sequences of balanced parenthesis formed using 2 pair of balanced parenthesis. 
 **/
public class AllBalacedParenthesis {

	private static void printValidParenthesis(char[] result, int n) {
		if (n > 0) {
			printParenthesis(result, n, 0, 0, 0);
		}

	}
	
	//TC ->O(2^N) possibility for { and } for N SC ->O(N) 

	private static void printParenthesis(char[] result, int n, int pos, int open, int close) {

		// Base case If close reached to n means all valid parenthesis are considered
		// .Print it .
		if (close == n) {

			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
		} else {
			if (open < n) {
				result[pos] = '{';
				printParenthesis(result, n, pos + 1, open + 1, close);

			}
			if (open > close) {
				result[pos] = '}';
				printParenthesis(result, n, pos + 1, open, close + 1);
			}

		}

	}

	public static void main(String[] args) {

		int n = 3;
		char result[] = new char[2 * n];
		printValidParenthesis(result, n);

	}
}
