/**
 * @author Shweta Kumari
 *2023-04-02
 */
package kumari.shweta.recursion;
public class CalculatePowerOfNumber {

	// TC O(N)
	static long  pow(int number, int n) {
		if (n == 0) {
			return 1;
		} else {
			return pow(number, n - 1) * number;
		}
	}

	// TC O(N)
	static long powWithHalf(int number, int n) {
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return powWithHalf(number, n / 2) * powWithHalf(number, n / 2);
		} else {
			return powWithHalf(number, n / 2) * powWithHalf(number, n / 2) * number;
		}
	}

	// TC O(logN)
	static long powWithHalfOptimized(int number, int n) {
		if (n == 0) {
			return 1;
		}
		long x = powWithHalfOptimized(number, n / 2);
		if (n % 2 == 0) {
			return x * x;
		} else {
			return x * x * number;
		}
	}

	public static void main(String[] args) {
		long result1 = pow(2, 3);
		long result2 = powWithHalf(2, 3);
		long result3 = powWithHalfOptimized(2, 3);
		System.out.println("Result1" + result1 + "Result2 " + result2 + "Result3 " + result3);
	}

}
