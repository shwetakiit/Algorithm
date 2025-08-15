/**
 * @author Shweta Kumari
 *2025-08-15
 */
package kumari.shweta.bit_manipulations;

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

	public static void main(String[] args) {

		int N = 13;
		int ithBit = 3;

		System.out.println("0 for unset 1 for set  " + checkBitSetOrUnset(N, ithBit));
		System.out.println("0 for unset 1 for set " + checkBitSetOrUnsetWithRightShift(N, ithBit));

		N = 22;
		System.out.println("Set ith bit and return in decimal " + setIthBitAndReturnResult(N, ithBit));
		System.out.println("Toggle ith bit and return in decimal " + toggleIthBit(N, ithBit));
	}

}
