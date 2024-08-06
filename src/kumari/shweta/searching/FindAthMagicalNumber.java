/**
 * @author Shweta Kumari
 * 2024-08-06
 */
package kumari.shweta.searching;

/*Problem Description
You are given three positive integers, A, B, and C.
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
Note: Ensure to prevent integer overflow while calculating.
Problem Constraints
1 <= A <= 109
2 <= B, C <= 40000
Input Format
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.
Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
*/
public class FindAthMagicalNumber {
	
	int findAthMagicalNumber(int A,int B,int C) {
		
 		int left=1; //We can take left=Min(B,C) 
		int right=A*(Math.min(B,C));
		int ans=0;
		while(left<=right) {
			
			int mid=(left+right)/2;
			int count=countOfMagincalNumber(B,C,mid);
			if(count==A) {
				ans=mid; //If we found the Magical count we should  go left side to find first occurance  of magical count.
				right=mid-1;  //Move left to find better answer 
			} else if(count>A) {
				right=mid-1;
			} else {
				left=mid+1;
			}
		}
		return ans;
	}
	

	private int countOfMagincalNumber(int b, int c, int mid) {
		int lcm= findLCM(b,c);
		int count= (mid/b)+(mid/c)-(mid/lcm);
		return count;
	}

	private int findLCM(int b, int c) {
		
		int dvd=c;
		int div=b;
		while(dvd%div!=0) {
		  int	rem=dvd%div;
		  dvd=div;
		  div=rem;
		}
		int gcd=div;
		int lcm=(b*c)/gcd;
		return lcm;
	}


	public static void main(String[] args) {
		
		int B=5;
		int C=7;
		int A=3;
		
		FindAthMagicalNumber obj = new FindAthMagicalNumber();
		
		int result=obj.findAthMagicalNumber(A,B,C);
		System.out.println(A+"th Magical number is "+result);
	}
}
