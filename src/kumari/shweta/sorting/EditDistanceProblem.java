/**
 * @author Shweta Kumari
 *2024-01-29
 */
package kumari.shweta.sorting;
/**
 * Given two strings A and B, find the minimum number of steps required to convert A to B. 
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Cost of Insert is 2 Cost of Delete is 2 and Cost of replace is 3
 * TC-> O(N*M) and SC ->O(N*M) Where N is length of String S1 and M is length of String S2
 *
 */


public class EditDistanceProblem {
	
	public static final int INSERT_COST=2;
	public static final int DELETE_COST=2;
	public static final int REPLACE_COST=3;
	

	public int findminCost(String s1,String s2,int i,int j,int dp[][]) {
		
		if(i<0 && j<0) { //If s1 and s2 both are empty so 0 cost is required to convert s1 into s2
			return 0;
		} else if(i<0) { // If s1 is empty and s2 is not empty then insert all character from s2 to s1 and calculate total insert cost
			return INSERT_COST*(j+1);
			
		} else if(j<0) {//If s1 is not empty and s2 is empty then delete all character of s1 to convert in S2 and calculate total delete cost
			return DELETE_COST*(i+1);
		}
		
		if(dp[i][j]!=-1) { //If answer is pre-calculated
			return dp[i][j];
		}
		if(s1.charAt(i)==s2.charAt(j)) { // If Ith index of S element is equal to Jth index of S2 element so no change is required so 0 cost is added 
			dp[i][j]=findminCost(s1, s2, i-1, j-1, dp);
		} else {
			int insert=INSERT_COST+findminCost(s1, s2, i, j-1, dp);
			int delete= DELETE_COST+findminCost(s1, s2,i-1, j, dp);
			int replace=REPLACE_COST+findminCost(s1, s2,i-1, j-1, dp);
			dp[i][j]=Math.min(insert,Math.min(replace,delete));
			
		}
		return dp[i][j];
	}
	
	public static void main(String[] args) {
		EditDistanceProblem obj = new EditDistanceProblem();
		//String s1="abcd";
		//String s2="abe";
		
		String s1="abdxy";
		String s2="abcgx";
		int dp[][]= new int[s1.length()][s2.length()]; //Prepare DP grid of row s1 length and column s2 length.
		for(int i =0;i<s1.length();i++) { //Fill DP grid with -1
			for(int j=0;j<s2.length();j++) {
				dp[i][j]=-1;
			}
		
		}
		int minCost=obj.findminCost(s1, s2,s1.length()-1,s2.length()-1,dp);
		System.out.println("Minium cost to convert S1 to S2 is "+minCost);
		}
	}
