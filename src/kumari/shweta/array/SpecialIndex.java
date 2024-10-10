/**
 * @author Shweta Kumari
 *2024-10-10
 */
package kumari.shweta.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
Problem Constraints

1 <= N <= 10^5
-105 <= A[i] <= 10^5
Sum of all elements of A <= 10^9
Input Format
First argument contains an array A of integers of size N
Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
Example Input
Input 1:
A = [2, 1, 6, 4]  Input 2: A = [1, 1, 1]
Example Output
Output 1: 1
Output 2: 3

Example Explanation

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.

*/

public class SpecialIndex {

	public int countOfSpecialIndex(List<Integer> list) {

		List<Integer> evenPrefix = findEvenPrefix(list);
		List<Integer> oddPrefix = findOddPrefix(list);

		System.out.println("Odd" + oddPrefix);
		System.out.println("Even" + evenPrefix);
		int N = list.size();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {

			int teven = 0;
			int todd = 0;
			if (i > 0) {

				teven = evenPrefix.get(i - 1);
				todd = oddPrefix.get(i - 1);
			}
			teven = teven + (oddPrefix.get(N - 1) - oddPrefix.get(i));
			todd = todd + (evenPrefix.get(N - 1) - evenPrefix.get(i));

			if (teven == todd) {
				count++;
			}

		}
		return count;
	}

	/**
	 * @param list
	 * @return
	 */
	private List<Integer> findOddPrefix(List<Integer> list) {
		List<Integer> oddPrefix = new ArrayList<>();
		oddPrefix.add(0);
		for (int i = 1; i < list.size(); i++) {
			if (i % 2 == 0) {
				oddPrefix.add(oddPrefix.get(i - 1));
			} else {
				oddPrefix.add(oddPrefix.get(i - 1) + list.get(i));
			}
		}

		return oddPrefix;
	}

	/**
	 * @param list
	 * @return
	 */
	private List<Integer> findEvenPrefix(List<Integer> list) {

		List<Integer> prefixEven = new ArrayList<>();
		prefixEven.add(list.get(0));

		for (int i = 1; i < list.size(); i++) {

			prefixEven.add(prefixEven.get(i - 1));
			if (i % 2 == 0) {
				prefixEven.set(i, prefixEven.get(i) + list.get(i));
			}
		}

		return prefixEven;
	}

	public static void main(String[] args) {

		List<Integer> input = Stream.of(4, 3, 2, 7, 6, -2).collect(Collectors.toList());
		SpecialIndex obj = new SpecialIndex();
		int prefixCount = obj.countOfSpecialIndex(input);
		System.out.println("Prefix count is" + prefixCount);

	}

}
