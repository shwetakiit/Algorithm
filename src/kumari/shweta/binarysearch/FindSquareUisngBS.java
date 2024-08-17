/**
 * @author Shweta Kumari
 *2024-07-29
 */
package kumari.shweta.binarysearch;

public class FindSquareUisngBS {
	
	public static int findSquareRootWithBS(int n) {
		
		int left=1;
		int right=n;
		int ans=1;
		while(left<=right) {
			
			int mid=(left+right)/2;
			if(mid*mid==n) {
				return mid;
			
			} else if(mid*mid<n) {
				ans=mid;
				left=mid+1;
			} else {
				right=mid-1;
				
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int num=29;
		int squareRootAns=
		findSquareRootWithBS(num);
		System.out.println("Square root answer is"+squareRootAns);
	}
}
