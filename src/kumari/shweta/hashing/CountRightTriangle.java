/**
 * @author Shweta Kumari
 *2024-09-19
 */
package kumari.shweta.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.TableView.TableCell;

/*Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
NOTE: The answer may be large so return the answer modulo (10^9 + 7).

Problem Constraints
1 <= N <= 105   0 <= A[i], B[i] <= 109
Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.
Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).
Example Input
Input 1: A = [1, 1, 2]   B = [1, 2, 1]
Input 2: A = [1, 1, 2, 3, 3] B = [1, 2, 1, 2, 1]
Example Output Output 1: 1  Output 2:  6

Example Explanation
Explanation 1:
All three points make a right angled triangle. So return 1.
Explanation 2: 6 triplets which make a right angled triangle are:   
                                                       (1, 1), (1, 2), (2, 1)
                                                       (1, 1), (3, 1), (1, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)
 **
 */
public class CountRightTriangle {

	// TC -> O(N) SC -> O(N)
	int countTriangle(List<Integer> A, List<Integer> B) {

		Map<Integer, Integer> xPointFreq = new HashMap<>();
		Map<Integer, Integer> yPointFreq = new HashMap<>();
		int ans = 0;
		int mod = 1000000007;
		for (Integer x : A) {
			if (xPointFreq.containsKey(x)) {
				xPointFreq.put(x, xPointFreq.get(x) + 1);
			} else {
				xPointFreq.put(x, 1);
			}
		}

		for (Integer y : B) {

			if (yPointFreq.containsKey(y)) {
				yPointFreq.put(y, yPointFreq.get(y) + 1);
			} else {
				yPointFreq.put(y, 1);
			}
		}

		for (int i = 0; i < A.size(); i++) {
			int xPoints = xPointFreq.get(A.get(i)) - 1;
			int yPoints = yPointFreq.get(B.get(i)) - 1;
			ans = ans + (xPoints * yPoints);

		}

		return ans % mod;

	}

	public static void main(String[] args) {

		CountRightTriangle obj = new CountRightTriangle();
		List<Integer> xPoints = Arrays.asList(1, 1, 2);
		List<Integer> yPoints = Arrays.asList(1, 2, 1);
        System.out.println("No of traingle is " + obj.countTriangle(xPoints, yPoints));

	}

}
