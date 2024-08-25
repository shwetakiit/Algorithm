/**
 * @author Shweta Kumari
 *2023-05-20
 */
package kumari.shweta.stack;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
/*For given array find nearest smaller  element in left hand side . Eg arr[]={4, 6, 10, 11, 7, 6, 3, 5}
 *If  there is no nearest smaller element in left hand side use default value -1
 *Output --> [-1, 4, 6, 10, 6, 4, -1, 3]
 *
 *Find nearest smaller element in right hand side [7,9,3,5,8,11,6]
 *Output -->[3,3,-1,-1,6,6,-1]
 */

public class NearestSmallerElement {
	/*
	 * Brute force approach TC-> O(N^2) SC-> O(1)
	 */
	public static List<Integer> prevSmallerBF(List<Integer> input) {

		List<Integer> result = new ArrayList<>(input.size());
		result.add(-1);
		for (int i = 1; i < input.size(); i++) {
			boolean found = false;
			for (int j = i - 1; j >= 0; j--) {
				if (input.get(j) < input.get(i)) {
					result.add(input.get(j));
					found = true;
					break;
				}
			}
			if (!found) {
				result.add(-1);
			}
		}

		return result;
	}
	
	//TC ->O(n) SC -> O(n)
	public static List<Integer> prevSmaller(List<Integer> input) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>(input.size());

		for (int i = 0; i < input.size(); i++) {
			// Pop all greater than equal element from stack
			while (!stack.isEmpty() && (stack.peek() >= input.get(i))) {
				stack.pop();
			}
			// Update result
			if (stack.isEmpty() == true) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			//Push element in stack
			stack.push(input.get(i));
		}
		return result;
	}

	public static List<Integer> NextSmaller(List<Integer> input) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> result = new ArrayList<>(input.size());
		//Iterate from right to left for smaller element in right hand side 

		for (int i = input.size()-1; i>=0;i --) {
			// Pop all greater than equal element from stack
			while (!stack.isEmpty() && (stack.peek() >= input.get(i))) {
				stack.pop();
			}
			// Update result
			if (stack.isEmpty() == true) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			//Push element in stack
			stack.push(input.get(i));
		}
		//Reverse result to maintain order corresponding to input list
		Collections.reverse(result);
		return result;
	}
	
	//Brute force approach for next smaller element. TC O(N^2) SC ->O(1)
	
	public static List<Integer> nextSmaller(List<Integer> input){
		
		List<Integer> result= new ArrayList<>(input.size());

		for(int i=input.size()-1;i>=0;i--) {
			boolean found=false;
			for(int j=i+1;j<=input.size()-1;j++) {
				if(input.get(i)>input.get(j)) {
					result.add(input.get(j));
					found=true;
					break;
				}
			}
			if(!found) {
				result.add(-1);
			}
		}
		
		Collections.reverse(result); 
		
		return result;
	}

	
	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(4, 6, 10, 11, 7, 6, 3, 5);
		List<Integer> result = prevSmaller(input);
		System.out.println("Smaller left side  nearest element for each element " + result);
		List<Integer> bfResult = prevSmallerBF(input);
		System.out.println("Smaller left side  element for each element  "+bfResult);
		List<Integer> rSmaller = NextSmaller(input);
		System.out.println("Smaller right hadn side nearest element"+rSmaller);
		
		List<Integer> rsmallerBF = nextSmaller(input);
		System.out.println("Next smaller using BF approach"+rsmallerBF);
	}
}
