/**
 * @author Shweta Kumari
 *2024-07-10
 */
package kumari.shweta.Queue;

import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
  Given an integer A, you have to find the Ath Perfect Number.
 A Perfect Number has the following properties:
 It comprises only 1 and 2.
 The number of digits in a Perfect number is even.
 It is a palindrome number.
 For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000
*/

public class FindPerfectNumberUsingQueue {

	// TC->O(N) SC->O(N)

	public String findNthPerfectNumber(int N) {

		String nthPerfectNum = "";
		if (N == 1) {
			return "11";
		}
		if (N == 2) {
			return "22";
		}

		Queue<String> queue = new LinkedList<>();
		int count = 2;
		queue.offer("1");
		queue.offer("2");
		String num = "";
		while (true) {

			num = queue.peek();
			queue.poll();
			queue.offer(num + "1");
			count++;
			if (count == N) {
				nthPerfectNum = num + "1";
				break;
			}
			queue.offer(num + "2");
			count++;
			if (count == N) {
				nthPerfectNum = num + "2";
				break;
			}

		}

		StringBuffer sBuffer = new StringBuffer(nthPerfectNum).reverse();
		return nthPerfectNum + sBuffer.toString();

	}

	public static void main(String[] args) {

		FindPerfectNumberUsingQueue obj = new FindPerfectNumberUsingQueue();
		String nthPerfectNum = obj.findNthPerfectNumber(9);
		System.out.println("Nth perfect number is" + nthPerfectNum);

	}

}
