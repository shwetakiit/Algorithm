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

	int findAthMagicalNumber(int A, int B, int C) {

		long MOD = 1000000007;
		long lcm = findLCM(B, C);
		long left = 1; // We can take left=Min(B,C)
		long minNum = (Math.min(B, C));
		long right = A * minNum; // Here was issue due to mathematical operation was not correct
		long ans = right;
		while (left <= right) {
			long mid = (left + right) / 2;
			long count = countOfMagincalNumber(B, C, mid, lcm);

			if (count == A) {
				ans = mid;
				right = mid - 1;
			} else if (count > A) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int) (ans % MOD);
	}

	private long countOfMagincalNumber(long b, long c, long mid, long lcm) {

		long count = (mid / b) + (mid / c) - (mid / lcm);
		return count;
	}

	private long findLCM(long b, long c) {

		long dvd = c;
		long div = b;
		while (dvd % div != 0) {
			long rem = dvd % div;
			dvd = div;
			div = rem;
		}
		long gcd = div;
		long lcm = (b * c) / gcd;
		return lcm;
	}

	public static void main(String[] args) {

		// Test1
		// int B=5;
		// int C=7;
		// int A=3;

		// Test2 with huge data
		int A = 807414236;
		int B = 3788;
		int C = 38141;

		FindAthMagicalNumber obj = new FindAthMagicalNumber();
		int result = obj.findAthMagicalNumber(A, B, C);
		System.out.println(A + "th Magical number is " + result);
	}
}
