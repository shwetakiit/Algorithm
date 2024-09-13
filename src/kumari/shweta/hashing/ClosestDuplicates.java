/**
 * @author Shweta Kumari
 *2024-09-13
 */
package kumari.shweta.hashing;

import java.util.HashMap;
import java.util.Map;



/**
 * Given an integer array of size N .find pair(i,j) such that j>i and 
 * A[i]==A[j] and j-i is minimum.
 * 
 * Input : arr [] -> {2,4,5,6,-1,2,5,4,3,7,3,2};
 * Output 2 
 * Explanation  minimum distance between duplicate pair 2 of last index 7 and second last index 5 
 * 7-5 (j-i) ==2
 *
 */
public class ClosestDuplicates {

	public int closetDistanceBetweenDuplicatePair(int arr[]) {

		Map<Integer, Integer> map = new HashMap<>();
		int resullt = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				int lastOccurance = map.get(arr[i]);
				resullt = Math.min(resullt, i - lastOccurance);
				map.put(arr[i], i);

			}

		}

		return resullt;

	}

	public static void main(String[] args) {

		ClosestDuplicates obj = new ClosestDuplicates();
		int arr[] = { 2, 4, 5, 6, -1, 2, 5, 4, 3, 7, 3, 2 };
		int closetDistance = obj.closetDistanceBetweenDuplicatePair(arr);
		System.out.println("Closet distance is " + closetDistance);

	}
}
