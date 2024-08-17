/**
 * @author Shweta Kumari
 *2024-07-29
 */
package kumari.shweta.searching;
/* Problem Description
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).
Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^5
1 <= B <= 10^5
Input Format
The first argument is an integer array A of size N.
The second argument is an integer B.
Output Format
Return an integer denoting the index of target value.
Example Input
Input 1: A = [1, 3, 5, 6] B = 5 
Input 2: A = [1, 4, 9] B = 3
Example Output Output 1: 2 
Output 2: 1
Example Explanation
Explanation 1:
The target value is present at index 2. 
Explanation 2:
The target value should be inserted at index 1.
*/
public class SortedInsertPosition {
	
	private static int findIndexOfSearchInsert(int arr[] , int element){
	
		int left=0;
		int right=arr.length-1;
		
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==element) {
				return mid;
			} else if(arr[mid]<element) {
				left=mid+1;
			} else {
				right=mid-1;
			}
		}
		return left;
		
	}
	public static void main(String[] args) {
		
		int arr[]= {1,1,2,3,3,6,6,8,8,9};
		int key=4;
		int idxOfKey=   findIndexOfSearchInsert(arr,key);
		System.out.println("Index of key found at or Need to insert at "+idxOfKey);
	}

}
