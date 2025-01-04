/**
 * @author Shweta Kumari
 *2025-01-05
 */
package kumari.shweta.array;
/*
Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples: 

Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.
Explanation: 1 is at index 0 and 2 is at index 1, so the distance is 1



Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.
Explanation: 3 is at index 0 and 5 is at index 2, so the distance is 2



Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3},  x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.
Explanation: 3 is at index 0 and 6 is at index 4, so the distance is 4



Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.
Explanation: 3 is at index 7 and 2 is at index 6, so the distance is 1
*/
public class MinimumDistanceOfTwoElements {
	
	/**
	 * @param arr
	 * @param x
	 * @param y
	 * @return
	 */
	
	//TC -->O(N) sc -> O(1);
	private static int findMinDistance(int[] arr, int x, int y) {
		int min_dist=Integer.MAX_VALUE;
		int indx_X=-1;
		int indx_Y=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==x) {
				indx_X=i;
			}
			if(arr[i]==y) {
				indx_Y=i;
			}
			
			if(indx_X!=-1 && indx_Y!=-1) {
				min_dist=Math.min(min_dist,Math.abs(indx_X-indx_Y));
			}
		}
		if(indx_X==-1||indx_Y==-1) {
			return -1;
		}
		return min_dist;
	}
	public static void main(String[] args) {
		
		int arr[]= {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		int x = 3, y = 6;
	   int min_distance=findMinDistance(arr,x,y);
	   System.out.println("Minimum distance is "+min_distance);
	}
}
