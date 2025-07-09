/**
 * @author Shweta Kumari
 *2025-07-09
 */
package kumari.shweta.array;

import java.util.Arrays;

/**
 * Given N array elements find Max value of (A[i]-A[j])+(i-j); input
 * arr[]={8,2,7,4,-2} --> Output -> 7
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

	public static void main(String[] args) {

		int arr[] = { 8, 2, 7, 4, -2 };
		int result = findMaxValue(arr);
		System.out.println(result);
	}

}
