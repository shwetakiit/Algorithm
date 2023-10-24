/**
 * @author Shweta Kumari
 *2023-10-24
 */
package kumari.shweta.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Description
Given a set of distinct integers A, return all possible subsets.
NOTE:

 1 Elements in a subset must be in non-descending order.
 2 The solution set must not contain duplicate subsets.
 3 Also, the subsets should be sorted in ascending ( lexicographic ) order.
 4 The initial list is not necessarily sorted.
 **/

public class AllSubsets {
	List<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

	public List<ArrayList<Integer>> finaAllSubsets(List<Integer> input) {
		Collections.sort(input);
		ArrayList<Integer> result = new ArrayList<Integer>();
		subSet(input, 0, result);
		Collections.sort(ans, ((l1, l2) -> resultNonDescendingOrder(l1, l2)));
		return ans;

	}

	/**
	 * @param input
	 * @param i
	 * @param result
	 */
	private void subSet(List<Integer> input, int idx, ArrayList<Integer> result) {
		if (idx == input.size()) { // Base case
			ans.add(new ArrayList<>(result));
			return;
		}
		subSet(input, idx + 1, result); // Ignore the element
		result.add(input.get(idx));
		subSet(input, idx + 1, result); // Select the element
		result.remove(result.size() - 1);

	}

	/**
	 * Sort the subsets in lexicographic order
	 */
	public static int resultNonDescendingOrder(List<Integer> l1, List<Integer> l2) {
		for (int i = 0; i < l1.size() && i < l2.size(); i++) {
			if (l1.get(i) < l2.get(i)) {
				return -1;
			}
			if (l1.get(i) > l2.get(i)) {
				return 1;
			}
		}
		if (l1.size() < l2.size()) {
			return -1;
		} else {
			return 1;
		}

	}

	public static void main(String[] args) {

		AllSubsets obj = new AllSubsets();
		List<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(3);
		List<ArrayList<Integer>> resList = obj.finaAllSubsets(input);
		System.out.println(resList);
	}
}
