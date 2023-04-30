/**
 * @author Shweta Kumari
 *2023-04-30
 */
package kumari.shweta.subsequence.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Given a set of distinct integers A, return all possible subsets.
NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX
Ex input A = [1, 2, 3] output [[]  [1]  [1, 2] [1, 2, 3] [1, 3][2] [2, 3]  [3]]*/

public class FindAllSubsets {

	public static List<List<Integer>> subsets(List<Integer> A) {
		int range = (int) Math.pow(2, A.size());

		List<List<Integer>> result = new ArrayList<>();
		Collections.sort(A);
		for (int i = 0; i < range; i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < A.size(); j++) {
				if ((i & (1 << j)) != 0) {
					subset.add(A.get(j));
				}
			}

			Collections.sort(subset);
			result.add(subset);

		}

		Collections.sort(result, (List<Integer> first, List<Integer> second) -> {
			for (int i = 0; i < first.size() && i < second.size(); i++) {
				if (first.get(i) < second.get(i))
					return -1;
				if (first.get(i) > second.get(i))
					return 1;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});

		return result;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(9, -20, -11, -8, -4, 2, -12, 14, 1, -18);
		List<List<Integer>> result = subsets(list);
		System.out.println(result);
	}
}
