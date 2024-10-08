/**
 * @author Shweta Kumari
 *2024-10-07
 */
package kumari.shweta.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.StyledEditorKit.ForegroundAction;



/*

Problem Description

You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].

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
A = [1, 2, 3, 4, 5]
B = [   [0,2] 
        [1,4]   ]
Input 2:
A = [2, 1, 8, 3, 9]
B = [   [0,3] 
        [2,4]   ]


Example Output

Output 1:
[4, 8]
Output 2:
[10, 17]


Example Explanation

For Input 1:
The subarray for the first query is [1, 2, 3] whose sum of even indices is 4.
The subarray for the second query is [2, 3, 4, 5] whose sum of even indices is 8.
For Input 2:
The subarray for the first query is [2, 1, 8, 3] whose sum of even indices is 10.
The subarray for the second query is [8, 3, 9] whose sum of even indices is 17.

*/
public class SumOfEvenIndices {
	
	
	//Brute force approach  TC --> O(Q*N) SC ->O(1)
	public void sumOfIndicesBF(List<Integer> list, List<ArrayList<Integer>> queries) {
		List<Integer> result = new ArrayList<>();

		for (ArrayList<Integer> query : queries) {

			int startIdx = query.get(0);
			int endIdx = query.get(1);

			int sumOfEvenIdx = 0;
			for (int i = startIdx; i <= endIdx; i++) {

				if (i % 2 == 0) {

					sumOfEvenIdx = sumOfEvenIdx + list.get(i);
				}
			}

			result.add(sumOfEvenIdx);

		}

		System.out.println("Sum of even indices for given query using Brute force approach");
		System.out.println(result);
	}
	
	
	
	//TC -> O(Q+N)  Q --no of queries N --> No of element in list 
	   public List<Integer> sumOfEvenIndicesForGivenQuery(List<Integer> list, List<List<Integer>> queries) {

		List<Integer> prefixEven = new ArrayList<>();
		List<Integer> sumOfEvenIndices = new ArrayList<>();

		prefixEven.add(list.get(0));

		for (int i = 1; i < list.size(); i++) {

			prefixEven.add(prefixEven.get(i - 1)); // If odd index keep the previous prefix value.
			if (i % 2 == 0) { // If even index keep previous prefix value plus element of index i of list to
								// calculate prefix
				prefixEven.set(i, prefixEven.get(i) + list.get(i));
			}
		}

		for (List<Integer> query : queries) {

			int startIdx = query.get(0);
			int endIdx = query.get(1);
			if (startIdx > 0) {
				sumOfEvenIndices.add(prefixEven.get(endIdx) - prefixEven.get(startIdx - 1));
			} else {
				sumOfEvenIndices.add(prefixEven.get(endIdx));
			}

		}

		System.out.println("Sum of even in");
		System.out.println(sumOfEvenIndices);

		return sumOfEvenIndices;
	}

	public static void main(String[] args) {
		List<Integer> list = Stream.of(-3, 4, -2, 5, 3, -2, 8, 2, -1, -4).collect(Collectors.toList());
		List<List<Integer>> queries = Arrays.asList(Arrays.asList(2, 6), Arrays.asList(3, 9), Arrays.asList(0, 5));

		SumOfEvenIndices obj = new SumOfEvenIndices();
		List<Integer> result = obj.sumOfEvenIndicesForGivenQuery(list, queries);

		System.out.println("Sum of even indices for given Queries ");
		System.out.println(result);
	}

}
