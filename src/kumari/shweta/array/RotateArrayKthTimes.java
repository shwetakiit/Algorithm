/**
 * @author Shweta Kumari
 *2026-11-02
 */
package kumari.shweta.array;

/**
 *1 ) Given the array of Size N .Rotate your array k times clockwise arr
 * [-1,2,3,6,5,4,8} 
 * K=1 [8,-1,2,3,6,5,4] 
 * K=2 [4,8,-1,2,3,6,5] 
 * K=3 [5,4,8,-1,2,3,6]
 * 
 * Output --> [5,4,8,-1,2,3,6]
 * 
 * 2) Given Array of Size N .Rotate your array K time anti clockwise
 *  arr =[-1,2,3,6,5,4,8]
 *  k=1 [2,3,6,5,4,8,-1]
 *  k=2 [3,6,5,4,8,-1,2]
 *  k=3 [6,5,4,8,-1,2,3]  
 *  
 *   Output --[6,5,4,8,-1,2,3]  
 *   
 *   3) Given array of SIZE N  rotate  Kth  time  eg K > no size of array 
 *       Rotate above array 20 time 
 *    
 *       15%7 --> Rotate 1 time 
 *       K=1 Rotation equal to K =15 Rotation
 * 
 *
 */
public class RotateArrayKthTimes {
	// SC --O(1) TC -> O(N)
	private static void rotateClockWise(int arr[], int K) {
		
		
		int N = arr.length;
		K=K%N;
		arr = reverseArrayWithoutUsingExtraSpace(arr, 0, N - 1); // TC O(N/2)
		arr = reverseArrayWithoutUsingExtraSpace(arr, 0, K - 1); // TC O(K/2)
        arr = reverseArrayWithoutUsingExtraSpace(arr, K, N - 1); // TC O(N-K/2)

		System.out.println("Rotate clock wise "+K+" times ");
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * @param arr
	 * @param k
	 */
	private static void rotateAntiClockWise(int[] arr, int k) {
		
		int N=arr.length;
		k=k%N;
		arr=reverseArrayWithoutUsingExtraSpace(arr, 0,k-1);
		arr=reverseArrayWithoutUsingExtraSpace(arr, k, N-1);
		arr=reverseArrayWithoutUsingExtraSpace(arr, 0, N-1);
		System.out.println("Rotate anti-clockwise, "+ k +" time ");
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	

	/**
	 * @param arr
	 * @param startIdx
	 * @param endIdx
	 */
	private static int[] reverseArrayWithoutUsingExtraSpace(int[] arr, int i, int j) {

		while (i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

		return arr;
	}

	public static void main(String[] args) {

	    int arr[] = { -1, 2, 3, 6, 5, 4, 8 };
		int k = 15;
		rotateClockWise(arr, k);
		int arr1[]={ -1, 2, 3, 6, 5, 4, 8 };
	    rotateAntiClockWise(arr1,k);
	}
}
