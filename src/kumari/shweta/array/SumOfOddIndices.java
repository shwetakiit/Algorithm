/**
 * @author Shweta Kumari
 *2024-10-09
 */
package kumari.shweta.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Problem Description

You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to calculate the sum of all odd indices in the range A[B[i][0]…B[i][1]].

Note : Use 0-based indexing

Problem Constraints

1 <= N <= 105
1 <= Q <= 105
1 <= A[i] <= 100
0 <= B[i][0] <= B[i][1] < N

Input Format
First argument A is an array of integers.
Second argument B is a 2D array of integers.
Output Format
Return an array of integers.
Example Input

Input 1:
A = [1, 2, 3, 4, 5]  B = [   [0,2]  [1,4]   ]
Input 2: A = [2, 1, 8, 3, 9] B = [   [0,3] [2,4]   ]

Example Output Output 1:
[2, 6]
Output 2:
[4, 3]


Example Explanation

For Input 1:
The subarray for the first query is [1, 2, 3] whose sum of odd indices is 2.
The subarray for the second query is [2, 3, 4, 5] whose sum of odd indices is 6.
For Input 2:
The subarray for the first query is [2, 1, 8, 3] whose sum of odd indices is 4.
The subarray for the second query is [8, 3, 9] whose sum of odd indices is 3.

*/


public class SumOfOddIndices {

	/**
	 * @param list
	 * @param queries
	 * @return
	 */

	// TC --> O(N+Q) --N --No of element in list Q no of queries SC --> O(1)
	private List<Integer> sumOfOddIndicesForGivenQuery(List<Integer> list, List<List<Integer>> queries) {

		List<Integer> prefixOdd = new ArrayList<>();
		List<Integer> sumOfOddIndices = new ArrayList<>();

		prefixOdd.add(0);// Add 0.value at index 0 which is even/

		for (int i = 1; i < list.size(); i++) {

			if (i % 2 == 0) {
				prefixOdd.add(prefixOdd.get(i - 1));
			} else {
				prefixOdd.add(prefixOdd.get(i - 1) + list.get(i));
			}

		}

		System.out.println("Prefix indices" + prefixOdd);

		for (List<Integer> query : queries) {

			int startIdx = query.get(0);
			int endIdx = query.get(1);
			if (startIdx > 0) {
				sumOfOddIndices.add(prefixOdd.get(endIdx) - prefixOdd.get(startIdx - 1));
			} else {
				sumOfOddIndices.add(prefixOdd.get(endIdx));
			}

		}

		return sumOfOddIndices;

	}

	public static void main(String[] args) {

		List<Integer> list = Stream.of(-3, 4, -2, 5, 3, -2, 8, 2, -1, -4).collect(Collectors.toList());
		List<List<Integer>> queries = Arrays.asList(Arrays.asList(2, 6), Arrays.asList(3, 9), Arrays.asList(0, 5));

		SumOfOddIndices obj = new SumOfOddIndices();
		List<Integer> result = obj.sumOfOddIndicesForGivenQuery(list, queries);

		System.out.println("Sum of odd indices for given Queries ");
		System.out.println(result);

	}

}
