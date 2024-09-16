/**
 * @author Shweta Kumari
 *2024-09-16
 */
package kumari.shweta.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.
Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9
Input Format
The only argument given is the integer array A.
Output Format
Return whether the given array contains a subarray with a sum equal to 0.
Example Input
Input 1:  A = [1, 2, 3, 4, 5]
Input 2:
 A = [4, -1, 1]
Example Output
Output 1:0
Output 2: 1
Example Explanation 
Explanation 1:  No subarray has sum 0.
Explanation 2: The subarray [-1, 1] has sum
*/
public class FindSumOfSubArrayZero {

	// Observation 1 :We know that prefix value repeat at particular index It means
	// there is sub array from index+1 of previous occurrance prefix to the index of
	// current occurance prefix .
	// Observation 2 :If we find prefix value is zero at any place it means till
	// that index there is a sub array of sum zero .
	public int solve(List<Integer> A) {

		Map<Long, Integer> map = new HashMap<>(); // Map of Key Prefix and value frequency of prefix .

		if (A.get(0) == 0) { // If first element itself is zero , It means we have one sub-array with sum =0;
			return 1;
		}

		Long prefix = A.get(0).longValue(); // Prefix value of first element of input
		map.put(prefix, 1);

		for (int i = 1; i < A.size(); i++) {

			prefix = prefix + A.get(i).longValue(); // Prefix Sum

			if (prefix == 0) { // If in middle of array prefix sum zero ,It means sum with previous element is
								// zero So there is sub array till that index where sum is zero
				return 1;
			}

			if (map.containsKey(prefix)) {
				return 1;
			} else {
				map.put(prefix, 1);
			}

		}

		return 0;
	}

	public static void main(String[] args) {
		FindSumOfSubArrayZero obj = new FindSumOfSubArrayZero();
		List<Integer> input = Arrays.asList(1, 2, -3);
		List<Integer> input1 = Arrays.asList(96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93, 5, 50, -45, 66,
				-28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80, -71, 48, -93, 62);
		int k = obj.solve(input1);
		System.out.println("Is subarray present? " + k);
	}

}
