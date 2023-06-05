/**
 * @author Shweta Kumari
 *2023-06-06
 */
package kumari.shweta.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* Find the nearest  day on which Stock price was smaller than today's stock price 
 * index is days for  stock price example 0th , 1st , 2nd day etc 
 * input stock price arr[4,6,10,11,7,6,3,5] output in array for days on which stock price was lesser than current stock price 
 * Output [-1,0,1,2,1,0,-1,6]
 */
public class StockPrice {
	public static List<Integer> stockPrice(List<Integer> input) {
		List<Integer> result = new ArrayList<>();

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < input.size(); i++) {
			while (!stack.isEmpty() && (input.get(stack.peek()) >= input.get(i))) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			stack.push(i);
		}
		return result;
	}
 
	public static void main(String arg[]) {
		List<Integer> input = Arrays.asList(4, 6, 10, 11, 7, 6, 3, 5);
		List<Integer> output = stockPrice(input);
		System.out.println("Stock price " + output);
	}
}
