/**
 * @author Shweta Kumari
 *2024-10-02
 */
package kumari.shweta.stringpattern;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Shweta Kumari
 *
 */

/*

Problem Description

You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
A boring substring has the following properties:
Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
Problem Constraints

1 <= |A| <= 105
Input Format
The only argument given is a string A.
Output Format
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
Example Input
Input 1: A = "abcd"
Input 2: A = "aab"
Example Output
Output 1: 1
Output 2: 0
Example Explanation
Explanation 1:  String A can be rearranged into "cadb" or "bdac" 
Explanation 2: No arrangement of string A can make it free of boring substrings.
 */
public class BoringSubString {
	
	 boolean checkRearrangement(String str) {
		  
      int smallestEven=Integer.MAX_VALUE;
      int largestEven=Integer.MIN_VALUE;
      
      int smallestOdd=Integer.MAX_VALUE;
      int largestOdd=Integer.MIN_VALUE;
		 
		 
       for(int i =0;i<str.length();i++) {
    	   
    	   if(str.charAt(i)%2==0) {
    		   if(str.charAt(i)<smallestEven) {
    			   smallestEven=str.charAt(i);
    		   }
    		   if(str.charAt(i)>largestEven) {
    			   largestEven=str.charAt(i);
    		   }
    	   } else {
    		   
    		   if(str.charAt(i)<smallestOdd) {
    			   smallestOdd=str.charAt(i);
    		   } 
    		   if(str.charAt(i)>largestOdd) {
    			   largestOdd=str.charAt(i);
    		   }
    		   
    	   }
    	   
       }
	
       
       if(smallestEven+1!=smallestOdd &&smallestEven-1!=smallestOdd ) {
    	  
    	   return true;
       }  else if(smallestEven+1!=largestOdd && smallestEven-1!=largestOdd) {
    	   return true;
       } else if(largestEven+1!=smallestOdd && largestEven-1!=smallestOdd) {
    	   return true;
       } else if(largestEven+1!=largestOdd && largestEven-1!=largestOdd ) {
    	   return true;
       }
	
	     
		
		 return false;
		 
	 }
	
	
	public static void main(String[] args) {
		
		BoringSubString obj = new BoringSubString();
		String input="abcd";
		
		  System.out.println(obj.checkRearrangement(input));;
		
		
	}

}
