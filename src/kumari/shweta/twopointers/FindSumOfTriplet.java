/**
 * @author Shweta Kumari
 *2024-09-11
 */
package kumari.shweta.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
Assume that there will only be one solution.
Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108
Input Format
First argument is an integer array A of size N.
Second argument is an integer B denoting the sum you need to get close to.
Output Format
Return a single integer denoting the sum of three integers which is closest to B.
Example Input
Input 1:
A = [-1, 2, 1, -4]
B = 1
Input 2:
A = [1, 2, 3]
B = 6
Example Output
Output 1:2
Output 2:6
Example Explanation
Explanation 1:
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:
 Take all elements to get exactly 6.
 */



public class FindSumOfTriplet {
	
	int sumOfTripletWhichIsClosetToTarget(int arr[], int k) {

		// Sort Array If it is not in sorted form .
		Arrays.sort(arr);
		int ans = 0;

		List<Integer> triplet = new ArrayList<>(3);

		for (int i = 0; i < arr.length - 2; i++) {

			int fixedElement = arr[i];
			int left = i + 1;
			int right = arr.length - 1;
			int minDiff = Integer.MAX_VALUE;
			while (left < right) {

				int tripletSum = fixedElement + arr[left] + arr[right];
				int diff = Math.abs(k - tripletSum);

				if (diff == 0) {
					triplet.clear();
					triplet.add(0, fixedElement);
					triplet.add(1, arr[left]);
					triplet.add(2, arr[right]);

					System.out.println(triplet);
					return tripletSum;
				}

				if (diff <= minDiff) {

					minDiff = diff;
					triplet.clear();
					triplet.add(0, fixedElement);
					triplet.add(1, arr[left]);
					triplet.add(2, arr[right]);

					// System.out.println(triplet);

					ans = tripletSum;
				}

				if (tripletSum < k) {
					minDiff = diff;
					left++;
				} else {
					right--;
				}
			}

		}

		System.out.println(triplet);

		return ans;
	}

	public static void main(String[] args) {
		FindSumOfTriplet obj = new FindSumOfTriplet();
		// int arr[]= {-1,2,1,-4};
		// int target=1;

		// int arr[]= {1,2,3};
		// int target=6;

		int arr[] = { -4, -1, 1, 2, 3, 6, 10, 12 };
		int target = 31;
		System.out.print(obj.sumOfTripletWhichIsClosetToTarget(arr, target));

	}

}
