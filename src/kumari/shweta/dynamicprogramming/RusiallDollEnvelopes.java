/**
 * @author Shweta Kumari
 *2024-02-09
 */
package kumari.shweta.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
*Problem Description
*Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
*One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
*Find the maximum number of envelopes you can put one inside other.
**/

public class RusiallDollEnvelopes {
	
	 class Pair{
		
		int height;
		int width;
		
		public Pair(int height,int width) {
			this.height=height;
			this.width=width;
		}
		
		@Override
		public String toString() {
			
			return "["+height+","+width+"]";
		}
	}
	
	public int findMaximumEnvelopes(int arr[][]) {
		
		List<Pair> list = new ArrayList<>(arr.length);
		
		for(int i =0;i<arr[0].length;i++) {
		int h=arr[0][i]; 
		int w=arr[1][i];
		Pair pair = new Pair(h, w);
		list.add(pair);
		}
		
		Collections.sort(list,(p1,p2)->p1.height-p2.height); //Sort with height in increasing order
		//System.out.println(list);
		
		//Find Longest Increasing subsequence for Weight  //LIS for width
		int dp[] = new int[arr[0].length];
		int ans=1;
		Arrays.fill(dp, -1);
		for(int i =0;i<arr[0].length;i++) {
			ans= Math.max(ans, findLis(list, i, dp));
		}
		return ans;
	}
	/**
	 * @param arr
	 * @param i
	 * @param dp
	 * @return
	 */
	private int findLis(List<Pair> list, int i, int[] dp) {
		int maxiumSub = 0;
		if (dp[i] != -1) {
			return dp[i];
		}
		for (int j = 0; j < i; j++) {
			if (list.get(j).width<list.get(i).width && list.get(j).height!=list.get(i).height) { //Height can't be same for two envelopes to put one in another
				maxiumSub = Math.max(maxiumSub, findLis(list, j, dp));
			}
		}
		dp[i] = maxiumSub + 1;
		return maxiumSub + 1;
	}
	public static void main(String[] args) {
		RusiallDollEnvelopes obj = new RusiallDollEnvelopes();
		
		//Test case 1
		int arr[][]= {{9,5,10,3,4,2},{3,4,8,2,3,7}};
		int result=obj.findMaximumEnvelopes(arr);
		System.out.println("Maximum count of envelopes that can be put in a single envelope"+result);
		//Test case 2
		int arr1[][]= {{5,6,6,4},{6,4,7,3}};
		int result1=obj.findMaximumEnvelopes(arr1);
		System.out.println("Maximum count of envelopes that can be put in a single envelope"+result1);
		}
	}


