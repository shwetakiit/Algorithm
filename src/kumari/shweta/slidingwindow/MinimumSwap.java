/**
 * @author Shweta Kumari
 *2023-03-22 12:45:13 pm
 */
package kumari.shweta.slidingwindow;

import java.util.Arrays;
import java.util.List;

/* 1 Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
   2 Note: It is possible to swap any two elements, not necessarily consecutive.
   3  1 <= length of the array <= 100000   -109 <= A[i], B <= 109
   
   Return the minimum number of swaps.
   A = [1, 12, 10, 3, 14, 10, 5]  B = 8    output -2
   A = [5, 17, 100, 11]           B = 20   output -1
*/
public class MinimumSwap {
	static int minimumSwap(List<Integer> A, int B) {
		int k = 0, count = 0, ans = Integer.MIN_VALUE;
		// Calculate size of sub array
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) <= B) {
				k++;
			}
		}
		// Count of bad element for first sub array ->Let's consider this as answer
		for (int i = 0; i < k; i++) {
			if (A.get(i) > B) {
				count++;
			}
		}
		ans = count;
		// Remaining sub array using sliding window concept
		int s = 1, e = k; // s=0+1 e=K-1+1 moving to next slide after considering first sub array in above code
		while (e < A.size() || s <= A.size() - k) {
			if (A.get(e) > B) { // If bad element coming in this sliding window
				count++;
			}
			if (A.get(s - 1) > B) { // Bad element going out from this sliding window
				count--;
			}
			ans = Math.min(ans, count);
			s++;
			e++;
		}
		return ans;
	}
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 12, 10, 3, 14, 10, 5);
		int result=minimumSwap(list, 8);
		System.out.println("Minimum swap for all elements less than <B bring together in array is? "+ result);
		}
	}
