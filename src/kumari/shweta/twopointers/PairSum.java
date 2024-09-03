/**
 * @author Shweta Kumari
 *2024-08-16
 */
package kumari.shweta.twopointers;

import java.util.HashSet;
import java.util.Set;


/**
 * Question 1:
 * Given arr[N] with sorted distinct elements .Count all the pairs (i,j) such
 * that arr[i]+arr[j]=k and i!=j
 *
 *
 *Input -{ -3, 0, 1, 3, 6, 8, 11, 14, 18, 25 } K=17
 *Output {6,11}{3,14} ans =2;
 *
 */


/**
Question 2:
  Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9
Input Format
The first argument given is the integer array A.
The second argument given is integer B.
Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).
Example Input
Input 1:

A = [1, 1, 1]
B = 2

Input 2:

A = [1, 5, 7, 10]
B = 8


Example Output
Output 1: 3
Output 2: 1

Example Explanation
Explanation 1:

 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.

Explanation 2:
There is only one pair, such that i = 0, and j = 2 sums up to 8.
 */
public class PairSum {
	
	
	//Idea 1:
	
	
	
	
	
	//Idea 2: Using two pointer approach --Question 1

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
	
	
	/* Question 1
	 * Idea 3: using hashShset 
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
	
	
	//Question 2:
	public int countPairWithDuplicateElements(int arr[], int target) {
		int i = 0, j = arr.length - 1;
		long ans = 0;
        long mod = 1000000007;

		while (i < j) {
			if (arr[i] + arr[j] == target) {

				// Handle If duplicate element making pair
				if (arr[i] == arr[j]) {
					long count = j - i + 1; // Count between [a,b] IS b-a+1
					ans = ans + (count * (count - 1)) / 2;
					break;
				} else { // If arr[i] and arr[j] both are different but both have duplicates in array.

					int left = arr[i];
					int lc = 0;

					while (arr[i] == left) {
						lc++; // Count left pointer duplicate elements
						i++;
					}

					int right = arr[j];
					int rc = 0;
					while (arr[j] == right) {
						rc++;
						j--;
					}
					ans = ans + (lc * rc);
				}

			} else if (arr[i] + arr[j] < target) {
				i++;
			} else {
				j--;
			}

		}
		return (int)(ans%mod);
	}

	public static void main(String[] args) {

		int arr[] = { -3, 0, 1, 3, 6, 8, 9, 11, 11, 14, 18, 25, };
		int k = 17;
		PairSum obj = new PairSum();
		int count = obj.countPair(arr, k);
		System.out.println("No of pairs is " + count);

		int countPair = obj.countPairWthHashSet(arr, k);
		System.out.println("Count of pairs using hashset " + countPair);

		// If array has duplicate elements

		int arr1[] = { 1, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 10 };
		int target = 10;
		int pairCount = obj.countPairWithDuplicateElements(arr1, target);
		System.out.println("Count pair in array where elements are duplicate" + pairCount);

	}
}
