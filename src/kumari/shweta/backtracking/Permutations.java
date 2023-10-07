/**
 * @author Shweta Kumari
 *2023-10-07
 */
package kumari.shweta.backtracking;

import java.util.ArrayList;

public class Permutations {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> findAllPermutations(ArrayList<Integer> inpuList) {

		ArrayList<Integer> result = new ArrayList<>(3);

		boolean[] visit = new boolean[inpuList.size()];

		for (int i = 0; i < inpuList.size(); i++) {
			visit[i] = false;
		}
		calculatePermutation(inpuList, 0, result, visit);
		return ans;
	}

	/**
	 * @param inpuList
	 * @param result
	 * @return
	 */
	private void calculatePermutation(ArrayList<Integer> inpuList, int idx, ArrayList<Integer> result,
			boolean[] visit) {

		// Base case
		if (idx == inpuList.size()) {
			ans.add(new ArrayList<>(result));
			return;
		}
		for (int i = 0; i < inpuList.size(); i++) {

			if (visit[i] == false) {
				visit[i] = true;
				result.add(idx, inpuList.get(i));
				calculatePermutation(inpuList, idx + 1, result, visit);
				result.remove(result.size() - 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Permutations obj = new Permutations();
		ArrayList<Integer> inputList = new ArrayList<>();
		inputList.add(1);inputList.add(2);inputList.add(3);
		ArrayList<ArrayList<Integer>> result = obj.findAllPermutations(inputList);
		System.out.println("All permutation list" + result);
	}
}
