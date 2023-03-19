/**
 * @author Shweta Kumari
 *2023-03-19 11:58:59 pm
 */
package kumari.shweta.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array A of length N. Also given are integers B and C.
  Return 1 if there exists a subarray with length B having sum C and 0 otherwise
  
  First argument A is an array of integers.
  The remaining arguments B and C are integers
  Return 1 if such a subarray exist and 0 otherwise
  Input -> A = [4, 3, 2, 6, 1] B = 3 C = 11 Output -> 1
  Input ->A = [4, 2, 2, 5, 1] B = 4 C = 6 Output ->0
  */
 
public class CheckSubArrayExistwithSum {
	public static int checksumOfSubArray(List<Integer> A, int B, int C) {
		List<Integer> prefixSum = new ArrayList<>();
		prefixSum.add(A.get(0));
		for (int i = 1; i < A.size(); i++) {
			prefixSum.add(prefixSum.get(i - 1) + A.get(i));

		}
		for (int i = 0; i <= A.size() - B; i++) {
			int s = i;
			int e = i + B - 1;
			int sum = 0;
			if (s == 0) {
				sum = prefixSum.get(e);
			} else {
				sum = prefixSum.get(e) - prefixSum.get(s - 1);
			}
			if (sum == C) {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(4, 3, 2, 6, 1);
		System.out.println("is sum of subarray equal to C ? " + checksumOfSubArray(list1, 3, 11));
		List<Integer> list2 = Arrays.asList(4, 2, 2, 5, 1);
		System.out.println("is sum of subarray equal to C ? " + checksumOfSubArray(list2, 4, 6));
	}
}
