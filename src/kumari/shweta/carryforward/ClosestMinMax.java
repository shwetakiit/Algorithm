/**
 * @author Shweta Kumari
 *2023-03-12
 */
package kumari.shweta.carryforward;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
and at least one occurrence of the minimum value of the array.
Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
Input [1,2,3,1,3,4,6,4,6,3] output--4
*/
public class ClosestMinMax {
	static int minimumLengthOfSubArrayWithMaxMin(List<Integer> A) {
		int max = Collections.max(A);
		int min = Collections.min(A);
		int result = A.size();

		int c_min = -1;
		int c_max = -1;
		if (min == max) {
			return 1;
		}
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == min) {
				c_min = i;
				if (c_max != -1) {
					result = Math.min(result, i - c_max + 1);

				}
			} else if (A.get(i) == max) {
				c_max = i;
				if (c_min != -1) {
					result = Math.min(result, i - c_min + 1);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(1,2,3,1,3,4,6,4,6,3);
		int subarrayLength=minimumLengthOfSubArrayWithMaxMin(list);
		System.out.println("Minimum length of subarray which inclue max and min element of Array is "+subarrayLength);
		}
}
