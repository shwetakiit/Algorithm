/**
 * @author Shweta Kumari
 *2024-01-02
 */
package kumari.shweta.dynamicprogramming;
/**
 *N different denomination , find total no of ways to pay a given amount. 
 *eg denom [7,4,9,6,10,13,14,11] Amount =22
 *Output :3 
 *Explanation : We have three way to pay that amount choose [7,4,11],[7,9,6],[9,13]
 *
 */

public class CoinChange {
	
	public int totalWayToPay(int denom[],int amount) {
		int N=denom.length;
		int dp[][] = new int[N+1][amount+1];
		
	   for(int i=0;i<denom.length;i++) { //Fill first column with 1 because only one way to pay zero amount
		   dp[i][0]=1;
	   }
	   for(int j=1;j<amount;j++) { //Fill all column of first row with 0 because If no coin then way to pay any amount is zero
		   dp[0][j]=0;
	   }
		
	   for(int i =1;i<=N;i++) {
		   for(int j=1;j<=amount;j++) {
			   if(denom[i-1]<=j) { //If denomination value is less than equal to amount then we have two choice select and don't select 
				   dp[i][j]= dp[i-1][j]/* If we don't select */+dp[i-1][j-denom[i-1]]/*If we select */;
			   } else { //If denomination value is greater than amount to be paid then  we have  one choice not to select.
				   dp[i][j]=dp[i-1][j];
			   }
		   }
	   }
		
		return dp[N][amount];
	}
	
	/**
	 * If Unbounded knapsack algorithm -- Means each coin we can take multiple times to pay the amount.
	 * There is minor difference in logic .
	 */
	
	public int totalWayToPayUnboundedKnapSack(int denom[], int amount) {
		int N = denom.length;
		int dp[][] = new int[N + 1][amount + 1];

		for (int i = 0; i < denom.length; i++) { // Fill first column with 1 because only one way to pay zero amount by paying nothing
			dp[i][0] = 1;
		}
		for (int j = 1; j < amount; j++) { // Fill all column of first row with 0 because If no coin then way to pay any amount is zero
			dp[0][j] = 0;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= amount; j++) {
				if (denom[i - 1] <= j) { // If denomination value is less than equal to amount then we have two choice
											// select and don't select
					dp[i][j] = dp[i - 1][j]/* If we don't select */
							   + dp[i][j- denom[i - 1]]/* If we select same coin multiple time */;
				} else { // If denomination value is greater than amount to be paid then we have one choice not to select.
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[N][amount];
	}
	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		int denom[] = {2,3,5,7};
		int amount=10;
		int totalWay =obj.totalWayToPay(denom, amount);
		System.out.println("Total way to pay the given amount is "+totalWay);
		
		// Second approach with unbounded knapsack
		int total = obj.totalWayToPayUnboundedKnapSack(denom, amount);
		System.out.println("Total way to pay the given amount if same coin we can take multiple times " + total);

		}
     }
