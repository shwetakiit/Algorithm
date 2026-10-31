/**
 * @author Shweta Kumari
 *2026-10-31
 */

package kumari.shweta.array;

import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.InvocationPluginReceiver;

/**
 * 1) Reverse array without using extra space 
 *arr[] = { -3, -2, 6, 8, 4, 8, 5 };
 *Output --> {5,8,4,8,6,-2,-3,}
 *  
 * 2) Reverse Array without using exra space for particular range 
 *  Reverse index 3 to 7
 */

public class ReverseArrayWithoutUsingExtraSpace {

	// TC-O(N) SC -> O(1)
	private static void reverse(int arr[]) {

		int i = 0, j = arr.length - 1;

		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] +" ");
		}
	}
	
	
	//TC ->O(N) ,SC -> O(1)
	
	public static void reverseInRange(int startIdx,int endIdx,int arr[]) {
		
		while(startIdx<endIdx) {
			int temp=arr[startIdx];
			 arr[startIdx]=arr[endIdx];
			 arr[endIdx]=temp;
			 startIdx++;
			 endIdx--;
			
		}
		
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] +" ");
		}
		
	}
   public static void main(String[] args) {

		int arr[] = { -3, -2, 6, 8, 4, 8, 5 };
		reverse(arr);
		
		System.out.println("Reverse in range");
		int arr1[]= { -3, -2, 6, 8, 4, 8, 5,1,9,11 };
		reverseInRange(3, 7,arr1);
		
		
		}
}
