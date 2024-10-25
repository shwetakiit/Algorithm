/**
 * @author Shweta Kumari
 *2024-10-25
 */
package kumari.shweta.string;
/*

Problem Description
You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.

Problem Constraints  1 <= N <= 10^5    A[i] ∈ ['a'-'z', 'A'-'Z']
Input Format
First and only argument is a character string A.
Output Format
Return a character string.
Example Input Input 1:  A = "Hello" 
Input 2: A = "tHiSiSaStRiNg" 
Example Output Output 1: hELLO 
Output 2: ThIsIsAsTrInG 
Example Explanation
Explanation 1:

 'H' changes to 'h'
 'e' changes to 'E'
 'l' changes to 'L'
 'l' changes to 'L'
 'o' changes to 'O'
Explanation 2:  "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
 
 */
public class ToggleCase {
	
	public String toggleCase(String string) {
		StringBuilder sbBuilder = new StringBuilder(string);
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)>='a' && string.charAt(i)<='z') {
				sbBuilder.setCharAt(i, (char) (string.charAt(i)-32));
			} else {
				sbBuilder.setCharAt(i, (char) (string.charAt(i)+32));
			}
		}
		System.out.println(sbBuilder.toString());
		
		return sbBuilder.toString();
	}
	public static void main(String[] args) {
		String string="tHiSiSaStRiNg";
		ToggleCase obj = new ToggleCase();
		obj.toggleCase(string);
		
	}

}
