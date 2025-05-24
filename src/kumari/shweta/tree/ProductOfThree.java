/**
 * @author Shweta Kumari
 *2025-05-23
 */
package kumari.shweta.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*Problem Description
Given an integer array A of size N.
You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103
Input Format
First and only argument is an integer array A.
Output Format
Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [10, 2, 13, 4]
Example Output
Output 1:
 [-1, -1, 6, 24, 60]
Output 2:
 [-1, -1, 260, 520]
Example Explanation
Explanation 1:
 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60
 So, the output is [-1, -1, 6, 24, 60].
 Explanation 2:
 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520
So, the output is [-1, -1, 260, 520].
 */

public class ProductOfThree {

	static void productOfThree(List<Integer> input) {

		List<Integer> result = new ArrayList<>();
		result.add(-1);
		result.add(-1);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < input.size(); i++) {

			if (pq.size() < 3) {
				pq.add(input.get(i));
			} else if (pq.peek() < input.get(i)) {
				pq.poll();
				pq.add(input.get(i));
			}

			if (pq.size() == 3) {

				int num1 = pq.poll();
				int num2 = pq.poll();
				result.add((pq.peek() * num1 * num2));
				pq.add(num1);
				pq.add(num2);
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {

		List<Integer> input = Arrays.asList(10, 2, 13, 4);
		productOfThree(input);
		}
	}
