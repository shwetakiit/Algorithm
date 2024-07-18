/**
 * @author Shweta Kumari
 *2024-07-18
 */
package kumari.shweta.sorting;

public class SumOfTheDifferences {

	public static int findSumOfDifferences(int arr[]) {

		int result = 0;

		for (int i = 0; i < arr.length; i++) {

			result += arr[i] * (Math.pow(2, arr.length - i - 1) - Math.pow(2, i));
		}

		return result;
	}

	public static void main(String[] args) {

		int arr[] = { 3, 1, -4 };

		int result = findSumOfDifferences(arr);
		System.out.println("Sum of differences of max and min of all subsets " + result);
	}

}
