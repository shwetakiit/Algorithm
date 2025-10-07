/**
 * @author Shweta Kumari
 *2025-10-07
 */
package kumari.shweta.carryforward;

/**
 * Given String in lower case  english alphabet .Find the count of pair (i,j)
 * such that i<j and arr[i]='a' and arr[j]='g' 
 */
public class CarryForwardPOC {
	
	
	/**
	 * @param str
	 * 
	 * TC ->O(N)
	 * SC ->O(1)
	 */
	private static int findCountPairs(String str) {
		char[] ch = str.toCharArray();
		int ans = 0, count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] == 'a') {
				count++;
			} else if (ch[i] == 'g') {
				ans = ans + count;
			}
		}

		return ans;
	}

	/**
	 * TC -> O(N^2) SC -> O(N)
	 * 
	 * @param str
	 */
	private static int findCountPairBruteForce(String str) {
		int count = 0;
		char ch[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] != 'a') {
				continue;
			}
			for (int j = i + 1; j < str.length(); j++) {
				if (ch[j] == 'g') {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String str = "abegag";
		String string="acgdgag";
		
		System.out.println("Total pair count of 'a' and 'g' are " +findCountPairs(str));
		System.out.println("Total pair count of 'a' and 'g' are " + findCountPairBruteForce(str));

	}
}
