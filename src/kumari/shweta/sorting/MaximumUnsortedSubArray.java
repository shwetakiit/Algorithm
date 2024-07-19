/**
 * @author Shweta Kumari
 *2024-07-19
 */
package kumari.shweta.sorting;

import java.util.Arrays;

/*
Problem Description
Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
Note :
Follow 0-based indexing, while returning the sub-array's starting and ending indexes.
Problem Constraints
1 <= N <= 106
1 <= A[i] <= 106
Input Format
First and only argument is an array of non-negative integers of size N.
Output Format
Return an array of length two where,
the first element denotes the starting index(0-based) and
the second element denotes the ending index(0-based) of the sub-array.
If the array is already sorted, return an array containing only one element i.e. -1.
*/
public class MaximumUnsortedSubArray {

	public static int[] findUnsortedSubArray(int arr[]) {

		int result[] = { -1, -1 };

		int prev[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			prev[i] = arr[i];
		}
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;

		while (i < arr.length && j >= 0) {
			if (arr[i] != prev[i]) {
				if (result[0] == -1)
					result[0] = i;

			}
			if (arr[j] != prev[j]) {
				if (result[1] == -1)
					result[1] = j;

			}

			i++;
			j--;
		}
		if (result[0] == -1 || result[1] == -1) {
			result = new int[1];
			result[0] = -1;
		}
		return result;
	}

	public static void main(String[] args) {

		// int arr[]= {2,5,20,13,17,17,15,25,30,31};
		int arr[] = { 1, 2, 3, 4 };

		int result[] = findUnsortedSubArray(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println(" " + result[i]);
		}

	}

}
