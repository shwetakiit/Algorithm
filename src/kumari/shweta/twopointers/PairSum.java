/**
 * @author Shweta Kumari
 *2024-08-16
 */
package kumari.shweta.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 * Given arr[N] with sorted distinct elements .Count all the pairs (i,j) such
 * that arr[i]+arr[j]=k and i!=j
 *
 *
 *Input -{ -3, 0, 1, 3, 6, 8, 11, 14, 18, 25 } K=17
 *Output {6,11}{3,14} ans =2;
 *
 */
public class PairSum {
	
	
	//Idea 1:
	
	
	
	
	
	//Idea 2: Using two pointer approach

	public int countPair(int arr[], int K) {
		int i = 0;
		int count = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] == K) {
				count++;
				i++;
				j--;
			} else if (arr[i] + arr[j] < K) {
				i++;
			} else {
				j--;
			}
		}

		return count;

	}
	
	
	/* Idea 3: using hashShset 
	 * a+b=k   b=k-a;
	 * Insert all array element in set and search  
	 * Fix one element one by one and check corresponding pair (k-a) in hash set.
	 * TC ->O(N) SC-O(N) (Taking extra space)
	 * */
	
	public int countPairWthHashSet(int arr[], int k) {

		Set<Integer> set = new HashSet();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			Integer num = k - arr[i];
			if (set.contains(num)) {
				count++;
			}
		}
		return count / 2; // Count repeating for same pair so /2

	}
	
	
	

	public static void main(String[] args) {

		int arr[] = { -3, 0, 1, 3, 6, 8, 9,11,11, 14, 18, 25, };
		int k = 17;
		PairSum obj = new PairSum();
		int count = obj.countPair(arr, k);
		System.out.println("No of pairs is " + count);
		
		int countPair= obj.countPairWthHashSet(arr, k);
		System.out.println("Count of pairs using hashset "+countPair);
	}
}
