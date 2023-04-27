/**
 * @author Shweta Kumari
 *2023-04-27
 */
package kumari.shweta.sorting;

import java.util.HashMap;
import java.util.Map;

/*
 *Given N array elements where all the elements are in the range[1-4] .Sort the array
 *For example input [3,1,4,4,2,4,2,3,1,2] output-
 *
 */
public class CountSortProblem {

	// Count sort using frequency map
	private static void sortbyFreqMap(int arr[]) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (freqMap.containsKey(arr[i])) {
				freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
			} else {
				freqMap.put(arr[i], 1);
			}
		}
		for (int i = 1; i <= 4; i++) {
			int freq = freqMap.get(i);
			for (int j = 0; j < freq; j++) {
				System.out.print(i + " ");
			}
		}

	}

	// Count sort using frequency of array

	private static void sortbyFreq(int arr[]) {
		int freq[] = new int[5];
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i];
			freq[index] = freq[index] + 1;
		}
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= freq[i]; j++) {
				System.out.print(i + " ");
			}
		}

	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 4, 2, 4, 2, 3, 1, 2 };
		sortbyFreq(arr);
		System.out.println();
		sortbyFreqMap(arr);
    }
}
