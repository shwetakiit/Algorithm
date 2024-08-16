/**
 * @author Shweta Kumari
 *2024-08-15
 */
package kumari.shweta.searching;

import java.util.Arrays;

/*

Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 3
Input 2:
A = [1, 2]
B = 2
Example Output
Output 1:
 2
Output 2:
 1
Example Explanation
Explanation 1:
John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
Explanation 2:
The minimum distance will be 1.
 */

public class LargestMinimumDistance {

	public int findLargestMinimumDistance(int arr[], int noOfCow) {

		// Note :Location of install in arr will be in sorted order so that we can find  first and last corner.
		Arrays.sort(arr);

		long left = 1;
		long right = arr[arr.length - 1] - arr[0];
		long ans = 0;
		if (noOfCow == 2) { // If only two cow so both will stand on last corner
			return (int) right;
		}
		while (left <= right) {
			long mid = (left + right) / 2;

			if (check(arr, mid, noOfCow)) {

				ans = mid;
				left = mid + 1;

			} else {
				right = mid - 1;
			}
		}
		return (int) ans;

	}

	/**
	 * @param arr
	 * @param mid
	 * @param noOfCow
	 * @return
	 */
	private boolean check(int[] arr, long mid, long noOfCow) {
		long last_pos = arr[0];
		long cow = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - last_pos >= mid) {
				cow++;
				last_pos = arr[i];
				if (cow == noOfCow) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

		LargestMinimumDistance obj = new LargestMinimumDistance();

		int noOfCow = 4;
		int arr[] = { 2, 6, 11, 14, 19, 25, 30, 39, 43 };
		int result = obj.findLargestMinimumDistance(arr, noOfCow);
		System.out.println("Find largest minimum distance " + result);

	}

}
