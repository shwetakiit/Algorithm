/**
 * @author Shweta Kumari
 *2025-07-13
 */
package kumari.shweta.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description

There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.
Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
Problem Constraints

1 <= A <= 2 * 105
1 <= L <= R <= A
1 <= P <= 103
0 <= len(B) <= 105

Input Format
The first argument is a single integer A.
The second argument is a 2D integer array B.

Output Format
Return an array(0 based indexing) that stores the total number of coins in each beggars pot.
Example Input

Input 1:-
A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
Example Output
Output 1:-
10 55 45 25 25
Example Explanation

Explanation 1:-
First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
*/
public class ContinuousSumQuery {

	public static void findFinalAmountOfEachBegger(int A, List<List<Integer>> devotees) {

		ArrayList<Integer> result = new ArrayList<>(A);
		for (int i = 0; i < A; i++) {
			result.add(0);
		}
		for (List<Integer> devotee : devotees) {

			for (int i = devotee.get(0); i <= devotee.get(1); i++) {
				if (result.get(i - 1) != null) {
					result.set(i - 1, result.get(i - 1) + devotee.get(2));
				} else {
					result.set(i - 1, devotee.get(2));
				}
			}
		}
		System.out.println(result);
	}

	/**
	 * @param a
	 * @param arr
	 */
	private static int[] findFinalState(int A, int[][] arr) {

		int[] result = new int[A];
		int a[] = new int[A]; // Storage to change value at start index for applying prefix sum
		for (int i = 0; i < arr.length; i++) {
			int startIndx = arr[i][0] - 1;
			int endIdx = arr[i][1] - 1;
			int value = arr[i][2];
			a[startIndx] = a[startIndx] + value; // Update only value on start index till end index apply prefix sum.
			if (endIdx + 1 < A) {
				a[endIdx + 1] = a[endIdx + 1] - value;
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}

		// Now appply prefix sum from index after startIndx to endIdx
		int sum = 0;
		for (int i = 0; i < A; i++) {
			sum = sum + a[i];
			result[i] = sum;
		}

		return result;

	}

	public static void main(String[] args) {

		int A = 5;
		List<Integer> donatedList1 = Arrays.asList(1, 2, 10);
		List<Integer> donatedList2 = Arrays.asList(2, 3, 20);
		List<Integer> donatedList3 = Arrays.asList(2, 5, 25);
		List<List<Integer>> denotee = new ArrayList<>();
		denotee.add(donatedList1);
		denotee.add(donatedList2);
		denotee.add(donatedList3);
		findFinalAmountOfEachBegger(A, denotee);

		// Optimized way
		int arr[][] = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
		int result[] = findFinalState(A, arr);

		System.out.println("Final state  of collected amount is ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}

	}
}
