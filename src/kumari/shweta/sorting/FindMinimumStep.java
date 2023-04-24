/**
 * @author Shweta Kumari
 *2023-04-24
 */
package kumari.shweta.sorting;

import java.util.Arrays;

/*
You are given an array A of N elements. You have to make all elements unique.
To do so, in one step you can increase any number by one.
Find the minimum number of steps.
example input arr[]{3,8,5,5,5,4,4,4}  -
output =>14 
arr[]={3,4,4,4,5,5,5,8}-->{3,4,4+1,4+2,5+2,5+3,5+4,8+2}  total step 1+2+2+3+4+2 => 14 
*/
 
public class FindMinimumStep {
	static int findSteps(int arr[]) {
		int ans = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] <= arr[i]) {
				ans += arr[i] + 1 - arr[i + 1];
				arr[i + 1] = arr[i] + 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 4, 4, 5, 5, 5, 8 };
		int minSteps = findSteps(arr);
		System.out.println("No of steps is " + minSteps);
	}
}
