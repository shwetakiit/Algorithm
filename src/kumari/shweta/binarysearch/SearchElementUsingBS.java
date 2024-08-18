/**
 * @author Shweta Kumari
 *2024-07-28
 */
package kumari.shweta.binarysearch;

/*Problem Description
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).

Problem Constraints
1 <= N <= 10^6
1 <= A[i], B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].

Example Input
Input 1:
 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:
 A = [5, 17, 100, 111]
 B = 3
Example Output
Output 1:
 [3, 4]
Output 2:
 [-1, -1]

Example Explanation
Explanation 1:
The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:
 There is no occurrence of 3 in the array.
Expected Output
Enter your input as per the following guideline:
There are 2 lines in the input
*/
public class SearchElementUsingBS {

	public int[] findLeftAndRightElementOfGivenElement(int arr[], int element) {

		int result[] = { -1, -1 };

		result[0] = findIndexOfFirstOccurance(arr, element);
		result[1] = findIndexOfLastOccurance(arr, element);
		return result;
	}

	private int findIndexOfLastOccurance(int[] arr, int element) {

		int left = 0;
		int right = arr.length - 1;
		int lastOccuranceIdx = -1;

		while (left <= right) {

			int mid = (left + right) / 2;
			if (arr[mid] == element) {
				lastOccuranceIdx = mid;
				left = mid + 1;
			} else if (arr[mid] < element) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return lastOccuranceIdx;
	}

	private int findIndexOfFirstOccurance(int[] arr, int element) {

		int left = 0;
		int right = arr.length - 1;
		int lastOccuranceIdx = -1;

		while (left <= right) {

			int mid = (left + right) / 2;
			if (arr[mid] == element) {
				lastOccuranceIdx = mid;
				right = mid - 1;
			} else if (arr[mid] < element) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return lastOccuranceIdx;
	}

	public static void main(String[] args) {

		SearchElementUsingBS obj = new SearchElementUsingBS();
		int arr[] = { 5, 7, 7, 8, 8, 9 };
		int key = 8;

		int result[] = obj.findLeftAndRightElementOfGivenElement(arr, key);
		System.out.println("First occurance index" + result[0]);
		System.out.println("Last occurance index" + result[1]);
	}
}
