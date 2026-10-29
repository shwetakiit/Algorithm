/**
 * @author Shweta Kumari
 *2026-10-29
 */

/**
 * Given the array of Size N .Find count of elements which has at least one greater element 
 * than itself
 * 
 * Eg [-3,-2,6,8,4,8,5]    -- -3 <-2, -2<4  4<5 5< 6 6<8   output --5 
 *                                  
 */

package kumari.shweta.array;

public class CountElement {

	private static int countElement(int arr[]) {
		int max = arr[0]; // We can take arr[0] or INT_MIN both will work

		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max == arr[i]) {
				count++;
			}

		}
		return arr.length - count;
	}

	public static void main(String[] args) {
		int arr[] = { -3, -2, 6, 8, 4, 8, 5 };
		System.out.println("No of elemenet which has at least of greater element" + countElement(arr));
	}

}
