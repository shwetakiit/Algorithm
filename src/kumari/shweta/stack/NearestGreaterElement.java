/**
 * @author Shweta Kumari
 *2023-05-21
 */
package kumari.shweta.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*For given array find nearest greater  element in left hand side . Eg arr[]={9,7,3,5,4,2,6,1,8}
*If  there is no nearest greater element in left hand side use default value -1
*Output --> [-1,9,7,7,5,4,7,6,9]
*/
public class NearestGreaterElement {
	
	//Nearest greater element left hand side 
	public static List<Integer> nearestGreaterElement(List<Integer> input) {

		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < input.size(); i++) {
			// Pop all less than equal to elements
			while (!stack.isEmpty() && stack.peek() <= input.get(i)) {
				stack.pop();
			}
			// update result
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

	/*
	 * Nearest greater element right hand side -- Traverse from right to left to get
	 * right hand side greater element
	 */
	public static List<Integer> nearestGreaterElementRightSide(List<Integer> input){
		List<Integer> result = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i= input.size()-1;i>=0;i--) {
			//Pop all less than equal to elements 
	      while(!stack.isEmpty()&& stack.peek()<=input.get(i)) {
	    	  stack.pop();
	      }
	      //update result
	      if(stack.isEmpty()==true) {
	    	  result.add(-1);
	      } else {
	    	  result.add(stack.peek());
	      }
	      //Push element in stack 
	      stack.push(input.get(i));
		}
		//Reverse result to traverse element from left to right
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(9, 7, 3, 5, 4, 2, 6, 1, 8);
		List<Integer> result = nearestGreaterElement(input);
		System.out.println("Nearest greater elements in lhs for given input" + result);
		List<Integer> rightGreater = nearestGreaterElementRightSide(input);
		System.out.println("Nearest greater element in rhs for given input"+rightGreater);
		}
}
