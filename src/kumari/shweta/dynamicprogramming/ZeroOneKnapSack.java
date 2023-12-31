/**
 * @author Shweta Kumari
 *2023-12-29
 */
package kumari.shweta.dynamicprogramming;
/**
 * 0/1 Knapsack problem.
 * Given N toys with their happiness and weight .Find max total happiness that can be kept in a bag with 
 * capacity W .[toy can't be divided]
 * 
 * Input : happiness []={4,1,5,7} Weight[]={3,2,4,5} ,NoOfToys =4 ,Capacity= 7
 * Output 9 
 * Explanation If we pick  happiness {4,5} with Weight {3,4}  Which gives us maximum happiness 9 
 *
 */

public class ZeroOneKnapSack {

	//Top down approach 
	public int findMaxHappiness(int h[], int wt[], int W) {

		int noOfToys = h.length;
		int dp[][] = new int[noOfToys][W];

		for (int i = 0; i < noOfToys; i++) {
			for (int j = 0; j < W; j++) {
				dp[i][j] = -1;
			}
		}
		int maxHappiness = maxHappiness(h, wt, noOfToys, W, dp);
		return maxHappiness;
	}

	private int maxHappiness(int[] h, int[] wt, int i, int j, int[][] dp) {
		if (i == 0 || j == 0) {//Either happiness is zero or weight is zero.
			return 0;
		}
		if (dp[i - 1][j - 1] != -1) { //If solution is already exist 
			return dp[i - 1][j - 1];
		}

		if (wt[i - 1] <= j) { //If weight of toy is within Capacity then find maximum of select toy and not select toy 
			dp[i - 1][j - 1] = Math.max(0 + maxHappiness(h, wt, i - 1, j, dp)/*If not select toy */,
					h[i - 1] + maxHappiness(h, wt, i - 1, j - wt[i - 1], dp)/*If select toy*/);
		} else { //If weight of toy is more than capacity so don't select toy.

			dp[i - 1][j - 1] = 0 + maxHappiness(h, wt, i - 1, j, dp);
		}

		return dp[i - 1][j - 1];
	}

	//Bottom up approach
	
	public int findHappinessBottomUp(int h[],int wt[],int W) {
		int noOfToys =h.length;
		int dp[][] = new int[noOfToys+1][W+1];
		
		//Intialize row and column with zero.
		for(int i =0;i<=noOfToys;i++) {
			for(int j=0;j<=W;j++) {
				dp[i][j]=0;
			}
		}
		for(int i =1;i<=noOfToys;i++) {
			for(int j=1;j<=W;j++) {
				dp[i][j]=dp[i-1][j];
				if(i<wt.length && j-wt[i-1]>=0) {  //Note i <should be less than wt.length 
					dp[i][j]=Math.max(0+dp[i-1][j],h[i-1]+dp[i-1][j-wt[i-1]]);
					
				}
			}
		}
		
		return dp[noOfToys][W]; //Last element of dp grid 
	}
	public static void main(String[] args) {
		ZeroOneKnapSack obj = new ZeroOneKnapSack();
		
		//Case 1:
		
		 //int h[] = { 4, 1, 5, 7 }; 
		 //int wt[] = { 3, 2, 4, 5 }; 
		 //int W = 7; 
		 //int maxHappiness =  obj.findMaxHappiness(h, wt, W); 
		 //System.out.println("Maximum toys" + maxHappiness);
		 
		
		//Case 2:
	
		int h[] = { 60, 100, 120 };
		int wt[] = {10,20,30};
		int W = 50;
		int maxHappiness = obj.findMaxHappiness(h, wt, W);
		System.out.println("Maximum happiness is " + maxHappiness);
		
		//Bottom up approach.
		int ht[]= {12,20,15,6,10};
		int weight[]= {3,6,5,2,4};
		int capacity=8;
	    maxHappiness= obj.findHappinessBottomUp(ht, weight, capacity);
	    System.out.println("Maximum happiness with bottom up approach "+maxHappiness);
		}
	}
