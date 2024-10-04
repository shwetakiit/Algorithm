/**
 * @author Shweta Kumari
 *2024-10-04
 */
package kumari.shweta.array;

/**
 * @author Shweta Kumari
 *
 */

/*

Problem Description
You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
Problem Constraints

1 <= N <= 10^3
1 <= A[i] <= 10^9
Input Format
First argument A is an array of integers.
Output Format
Return an integer.
Example Input
Input 1: A = [1, 2, 4, 3]
Input 2: A = [2, 1, 2, 3]

Example Output Output 1: 2 Output 2: 1
Example Explanation
For Input 1:
The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
For Input 2:
 The triplet that satisfy the conditions is [1, 2, 3].

*/
public class CountIncreasingTriplet {

	// Brute force approach TC -O(N^2)
	public int countTriplet(int arr[]) {

		int N = arr.length;
		int countTriplet = 0;

		for (int i = 0; i < N; i++) {

			for (int j = i + 1; j < N; j++) {

				if (arr[j] < arr[i]) {

					continue;
				}

				for (int k = j + 1; k < N; k++) {
					if (arr[j] < arr[k]) {

						countTriplet++;

					}
				}
			}
		}
		return countTriplet;

	}

	// Optimized approach TC -O(N^2)

	public int tripletCount(int arr[]) {
		int N = arr.length;
		int tripletCount = 0;
		for (int j = 1; j < N; j++) {

			int smaller = 0;
			int larger = 0;
			for (int i = j - 1; i >= 0; i--) {
				if (arr[i] < arr[j]) {
					smaller++;
				}
			}

			for (int k = j + 1; k < N; k++) {
				if (arr[k] > arr[j]) {
					larger++;
				}

			}
			tripletCount = tripletCount + (smaller * larger);

		}
		return tripletCount;
	}

	public static void main(String[] args) {

		int arr[] = { 4, 1, 2, 6, 9, 7 };
		CountIncreasingTriplet obj = new CountIncreasingTriplet();
		int result = obj.countTriplet(arr);
		System.out.println("Count of triplet is " + result);

		int tripletCount = obj.tripletCount(arr);
		System.out.println("Triplet count is " + tripletCount);

	}
}
