/**
 * @author Shweta Kumari
 *2024-09-14
 */
package kumari.shweta.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Find Longest sub-array in given array of sum is zero .
 * 
 * 
 */

public class SumOfSubArray {
	
	public int longestSubArrayWithSumZero(List<Integer> input) {

		List<Integer> prefixSum = findPrefixSum(input);

		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		int maxLength = 0;

		if (prefixSum.get(input.size() - 1) == 0) {// Edge case If last prefix is zero It means complete array sum is
													// zero which is longest sub array.
			System.out.println(input);
			return input.size();
		}

		for (int i = 0; i < input.size(); i++) {

			if (map.containsKey(prefixSum.get(i))) {

				int firsOccurance = map.get(prefixSum.get(i));
				int longestDistance = i - firsOccurance;

				if (longestDistance > maxLength) {
					result.clear();
					int startIdx = firsOccurance + 1;
					while (startIdx <= i) {
						result.add(input.get(startIdx));
						startIdx++;
					}
				}

				maxLength = Math.max(maxLength, longestDistance);

			} else {
				map.put(prefixSum.get(i), i);
			}
		}
		System.out.println(result);
		return maxLength;

	}

	/**
	 * @param integers
	 * @return
	 */
	private List<Integer> findPrefixSum(List<Integer> list) {

		List<Integer> prefixSum = new ArrayList<>(list.size());

		prefixSum.add(list.get(0));

		for (int i = 1; i < list.size(); i++) {
			prefixSum.add((prefixSum.get(i - 1) + list.get(i)));

		}
		return prefixSum;
	}

	public static void main(String[] args) {
		SumOfSubArray obj = new SumOfSubArray();
		// List<Integer> input = Arrays.asList(4,-3,-1,2,-2);
		// List<Integer> input = Arrays.asList(2, 2, 1, -3, 4, 3, 1, -8, 6, -2, -1);
		// List<Integer> input = Arrays.asList(5,17,-22,11);
		List<Integer> input = Arrays.asList(96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93, 5, 50, -45, 66,
				-28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80, -71, 48, -93, 62);

		int longestSubArrayLength = obj.longestSubArrayWithSumZero(input);
		System.out.println("Longest sub array length is " + longestSubArrayLength);

	}
}
