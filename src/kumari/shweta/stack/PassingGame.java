/**
 * @author Shweta Kumari
 *2023-05-14
 */
package kumari.shweta.stack;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 10^6.
Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player who possessed the ball after exactly A passes.
There are two kinds of passes: 1) ID 2) 0
For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.
For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.
In the second kind of pass "0" just means Back Pass.
Return the ID of the player who currently possesses the ball. 
Problem Constraints 1 <= A <= 100000 1 <= B <= 100000 |C| = A
Input A = 10 B = 23 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]
Output :63

The first argument of the input contains the number A (size of list which contains ID/0)
The second argument of the input contains the number B ( id of the player possessing the ball in the very beginning).
The third argument is an array C of size A having (ID/0)
*/

public class PassingGame {

	public static int findId(int A, int B, List<Integer> C) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(B);
		if (A == 1) {
			return C.get(0);
		} else {
			for (int i = 0; i < C.size(); i++) {
				if (C.get(i) != 0) {
					stack.push(C.get(i));
				} else {
					stack.pop();
				}
			}
		}
		return stack.peek();
	}
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(86, 63, 60, 0, 47, 0, 99, 9, 0, 0);
		int id = findId(10, 23, list);
		System.out.println("Id of player who possessed the ball after exactly A passes " + id);
	}

}
