/**
 * @author Shweta Kumari
 *2023-10-07
 */
package kumari.shweta.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;





public class Permutations {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<ArrayList<Character>> answer = new ArrayList<>();

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
	
	/*
	 * Find all permutation ,If Given list has duplicate elements TC O(N!), SC
	 * ->O(N)
	 */
	public ArrayList<ArrayList<Character>> findPermutations(ArrayList<Character> inpuList) {

		Map<Character, Integer> freqency = new HashMap<>();
		ArrayList<Character> result = new ArrayList<>(3);

		for (int i = 0; i < inpuList.size(); i++) {

			if (freqency.containsKey(inpuList.get(i))) {
				int freq = freqency.get(inpuList.get(i));
				freq = freq + 1;
				freqency.put(inpuList.get(i), freq);
			} else {
				freqency.put(inpuList.get(i), 1);
			}
		}

		calPermutation(freqency, inpuList.size(), result, 0);
		return answer;

	}

	/**
	 * @param freqency
	 * @param size
	 * @param result
	 * @param i
	 */
	private void calPermutation(Map<Character, Integer> freqency, int size, ArrayList<Character> result, int idx) {

		if (idx == size) {
			answer.add(new ArrayList<>(result));
			return;
		}

		for (Character c : freqency.keySet()) {

			int value = freqency.get(c);
			if (value > 0) {
				int freq = value;
				freq = freq - 1;
				freqency.put(c, freq);
				result.add(idx, c);
				calPermutation(freqency, size, result, idx + 1);
				result.remove(result.size() - 1);
				freqency.put(c, ++freq);
			}

		}
	}
	public static void main(String[] args) {
		Permutations obj = new Permutations();
		ArrayList<Integer> inputList = new ArrayList<>();
		inputList.add(1);inputList.add(2);inputList.add(3);
		ArrayList<ArrayList<Integer>> result = obj.findAllPermutations(inputList);
		System.out.println("All permutation list" + result);

		ArrayList<Character> charList = new ArrayList<>();
		charList.add('a');charList.add('b');charList.add('a');
		ArrayList<ArrayList<Character>> resList = obj.findPermutations(charList);
		System.out.println("Find all permutations" + resList);
		
	}
}
