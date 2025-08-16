/**
 * @author Shweta Kumari
 *2025-08-15
 */
package kumari.shweta.bit_manipulations;

import kumari.shweta.string.FirstDayOfSequence;

public class BitOpeartion {

	// Check bit set or unset using left shift operation
	
	/**
	 * N=13 -->  00001101 & 00001000  -> 3rd bit  1 
	 */
	public static int checkBitSetOrUnset(int N, int ithBit) {
		if ((N & (1 << ithBit)) != 0) {
			return 1;
		}
		return 0;

	}

	// Check bit set or unset using right shift operation on N

	public static int checkBitSetOrUnsetWithRightShift(int N, int ithBit) {
		if ((1 & (N >> ithBit)) != 0) {
			return 1;
		} else {
			return 0;
		}
	}

	// Set Ith Bit and resturn Decimal value of that number.
	public static int setIthBitAndReturnResult(int N, int ithBit) {

		int result = N | (1 << ithBit);
		return result;
	}

	public static int toggleIthBit(int N, int ithBit) {
		N = N ^ (1 << ithBit);

		return N;
	}
	
	// Brute force approach since N is int take 32 bit TC --> O(No of bit)
	public static int countSetBit(int N) {

		int count = 0;

		for (int i = 0; i < 32; i++) {
			if ((N & (1 << i)) != 0) {

				count++;

			}
		}

		return count;
	}

	// Optimized approach to count set bit  --> TC --> O(logN)

	public static int countSetBits(int N) {

		int temp = N;
		int count = 0;

		while (temp != 0) {
			if ((temp & 1) == 1) {
				count++;
			}
			temp = temp >> 1;
		}

		return count;
	}

	public static void main(String[] args) {

		int N = 13;
		int ithBit = 3;

		System.out.println("0 for unset 1 for set  " + checkBitSetOrUnset(N, ithBit));
		System.out.println("0 for unset 1 for set " + checkBitSetOrUnsetWithRightShift(N, ithBit));

		N = 22;
		System.out.println("Set ith bit and return in decimal " + setIthBitAndReturnResult(N, ithBit));
		System.out.println("Toggle ith bit and return in decimal " + toggleIthBit(N, ithBit));
		
		N=27;
		
		System.out.println("Count set bit "+countSetBit(N));
		System.out.println("Count set bit using optimized approach"+countSetBits(N));
		
		
	}

}
