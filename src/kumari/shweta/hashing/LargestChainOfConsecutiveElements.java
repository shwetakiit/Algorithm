/**
 * @author Shweta Kumari
 *2024-09-14
 */
package kumari.shweta.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Problem Description
Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from array A.
Problem Constraints
1 <= N <= 106
-106 <= A[i] <= 106
Input Format
First argument is an integer array A of size N.
Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.
Example Input
Input 1:
A = [100, 4, 200, 1, 3, 2]
Input 2:
A = [2, 1]
Example Output
Output 1: 4
Output 2: 2
Example Explanation
Explanation 1:
The set of consecutive elements will be [1, 2, 3, 4].
Explanation 2:
The set of consecutive elements will be [1, 2].
*/
public class LargestChainOfConsecutiveElements {

	public int longestConsecutive(List<Integer> input) {

		Set<Integer> set = new HashSet<>(input);
		List<Integer> result = new ArrayList<>();
		int ans = 0;

		for (Integer element : input) {

			if (!set.contains(element - 1)) {
				List<Integer> longestChain = new ArrayList<>();
				int chain = 1;
				int y = element + 1;
				longestChain.add(element);
				while (set.contains(y)) {
					longestChain.add(y);
					y++;
					chain++;

				}

				if (chain > ans) {
					result.clear();
					result.addAll(longestChain);
				}
				ans = Math.max(ans, chain);

			}
		}

		System.out.println("Longest sequence" + result);

		return ans;

	}

	// If duplicate element in array we need to consider same start point with n
	// time if there is n time duplication to avoid this use set for iteration .

	public int longestConsecutiveIfDuplicate(List<Integer> input) {

		Set<Integer> set = new HashSet<>(input);
		List<Integer> result = new ArrayList<>();
		int ans = 0;

		for (Integer element : input) { // Iterate on set to avoid unnecessary duplicates starting point

			if (!set.contains(element - 1)) {
				List<Integer> longestChain = new ArrayList<>();
				int chain = 1;
				int y = element + 1;
				longestChain.add(element);
				while (set.contains(y)) {
					longestChain.add(y);
					y++;
					chain++;

				}

				if (chain > ans) {
					result.clear();
					result.addAll(longestChain);
				}
				ans = Math.max(ans, chain);

			}
		}

		System.out.println("Longest sequence" + result);

		return ans;

	}

	public static void main(String[] args) {

		LargestChainOfConsecutiveElements obj = new LargestChainOfConsecutiveElements();
		List<Integer> input1 = Arrays.asList(-1, 8, 5, 2, 3, 7, 1, 4, 9);
		List<Integer> input2 = Arrays.asList(6, 6, 6, 6, 6, 6, 6, 7, 8, 9, 9, 9);
		int longestSequence = obj.longestConsecutive(input1);
		System.out.println("Longest sequence is " + longestSequence);
		int result = obj.longestConsecutiveIfDuplicate(input2);
		System.out.println("Longest sequence with duplicate is" + result);
	}
}
