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
 *  
 */
public class FindMaxValue {

	public static int findMaxValue(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + i;
		}

		int min = Arrays.stream(arr).min().getAsInt();
		int max = Arrays.stream(arr).max().getAsInt();
		return max - min;
	}


	private static int findMaxValueOfGivenExpression(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] - i;

		}
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		return max - min;

	}
	public static void main(String[] args) {

		int arr[] = { 8, 2, 7, 4, -2 };
		int result = findMaxValue(arr);
		System.out.println(result);
		int value=findMaxValueOfGivenExpression(arr);
		System.out.println("Max value of expression (A[i]-A[j])+(j-i) is "+value);
	}
}
