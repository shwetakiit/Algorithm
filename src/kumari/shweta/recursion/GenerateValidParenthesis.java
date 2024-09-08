/**
 * @author Shweta Kumari
 *2024-09-08
 */
package kumari.shweta.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
Problem Constraints
1 <= A <= 10
Input Format
First and only argument is integer A.
Output Format
Return a sorted list of all possible parenthesis.
Example Input
Input 1:
A = 3
Input 2:
A = 1
Example Output
Output 1:
[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:
[ "()" ]
Example Explanation
Explanation 1:
All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.*/
public class GenerateValidParenthesis {

	
	//TC --> O(2^N) 
	private List<String> generateAllParethesis(int n) {
		List<String> validParenthesis = new ArrayList<>();
		generateValidParenthesis(n, 0, 0, validParenthesis, "");
		return validParenthesis;
	}

	private void generateValidParenthesis(int n, int opening, int closing, List<String> validParenthesis, String str) {
		if (closing > opening) {

			return;
		}

		if (opening == closing && closing == n) {
			validParenthesis.add(str);
		}

		if (opening < n) {
			generateValidParenthesis(n, opening + 1, closing, validParenthesis, str + "(");
		}
		if (opening > closing) {
			generateValidParenthesis(n, opening, closing + 1, validParenthesis, str + ")");
		}
	}

	public static void main(String[] args) {

		GenerateValidParenthesis obj = new GenerateValidParenthesis();
		int N = 3;

		List<String> resultList = obj.generateAllParethesis(N);

		System.out.println(resultList);
	}

}
