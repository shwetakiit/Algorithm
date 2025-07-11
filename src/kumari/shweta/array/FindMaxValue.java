/**
 * @author Shweta Kumari
 *2025-07-09
 */
package kumari.shweta.array;

import java.util.Arrays;

/**
 * 1 )Given N array elements find Max value of (A[i]-A[j])+(i-j); input
 * arr[]={8,2,7,4,-2} --> Output -> 7
 * 
 * 2)Given N array elements find max value of (A[i]-A[j])+(j-i)
 * 3)Given N elements find max value of |A[i]-A[j]|+|i-j|
 *    here max {
 *               A[i]-A[j]+i-j ,  ( A[i]+i) -(A[j]+j)//1 and 4 equations are same 
 *               A[i]-A[J]+j-i      (A[i]-i)-(A[j]-j) // 2 and 3 equations are same 
 *               A[j]-A[i]+i-j,    (A[j]-j)-(A[i]-i)
 *                A[j]-A[i]+j-i
 *               }
 *  
 */
public class FindMaxValue {

	// Question1
	// TC->O(N) sc ->O(1)
	public static int findMaxValue(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + i;
		}

		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();
		return max - min;
	}

	// Question2
	// TC-> O(N) sc -> O(1)

	private static int findMaxValueOfGivenExpression(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] - i;

		}
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		return max - min;

	}

	// Question 3
	// TC->O(N) SC ->O(1)
	public static int findMaxValueOfModExpression(int arr[]) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] + i > max) {
				max = arr[i] + i;
			}
			if (arr[i] + i < min) {
				min = arr[i] + i;
			}

		}
		result = Math.max(result, max - min);

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] - i > max) {
				max = arr[i] - i;
			}
			if (arr[i] - i < min) {
				min = arr[i] - i;
			}
		}

		result = Math.max(result, max - min);

		return result;

	}

	public static void main(String[] args) {

		int arr[] = { 8, 2, 7, 4, -2 };
		int result = findMaxValue(arr);
		System.out.println(result);
		int value = findMaxValueOfGivenExpression(arr);
		System.out.println("Max value of expression (A[i]-A[j])+(j-i) is " + value);
		int expValue = findMaxValueOfModExpression(arr);
		System.out.println("Max value of expression |A[i]-A[j]|+|i-j|" + expValue);

	}
}
