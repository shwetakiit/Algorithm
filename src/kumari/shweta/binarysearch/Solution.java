/**
 * @author Shweta Kumari
 *2024-08-08
 */
package kumari.shweta.binarysearch;

public class Solution {
    private static final int MODULOUS = 1000000007;
    private static int getHcf(int A, int B){
        if(B == 0) return A;
        return getHcf(B, A % B);
    }
    public int solve(int A, int B, int C) {
        // A -> th magical number [X/B + X/C - X/(LCM of B,C)]
        final long lcm = (B * C) / getHcf(B, C);
        long low = Math.min(B, C);
        long high = low * A;
        long answer = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long calcTarget = (mid / B) + (mid / C) - (mid / lcm);
            if (calcTarget > A){
                high = mid - 1;
            }else if (calcTarget < A){
                low = mid + 1;
            }else{
                answer = mid;
                high = mid - 1;
            }
        }
        return (int) (answer %= MODULOUS);
    }
    
    public static void main(String[] args) {
		
          	int A=807414236;
    		int B=3788;
    		int  C=38141;
    		
    		Solution obj = new Solution();
    		
    		int result=obj.solve(A,B,C);
    		System.out.println(A+"th Magical number is "+result);
    	
	}
}