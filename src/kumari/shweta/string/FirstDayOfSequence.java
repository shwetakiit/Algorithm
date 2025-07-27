/**
 * @author Shweta Kumari
 *2025-07-26
 */
package kumari.shweta.string;



/**
 * Bob has string S and  Alice has String T .Each day bob takes his String  S and appends it to final String 
 * K .for example If S is "ab" then K also be an "ab" ,(on the first day) then on the second day K becomes "abab"
 * on the third day K becomes "ababab" and so on .
 * 
 * Your task is to help Alice find and return integer value , representing the day when the String K 
 * Contains T as subsequence for the first time .
 * 
 * Note : 
 * A subsequence is a sequence that can be derived from another sequence by deleting some or  no element 
 * without changing the order of the remaining element. 
 * 
 * Don't alter the order of the string  while choosing a subsequence.
 * 
 * Input specification :
 * Input 1: A string value S, representing the String Bob has 
 * Input 2: A string value T , representing the String Alice has.
 * 
 * 
 * Output Specification :
 * Return an Integer value , representing the day when string K contains T  as a subseqeunce for the first time.
 * 
 * example Input1: mtle 
 *         Input 2: mettl 
 *         
 *         
 *  Explanation : 
 *  Given the intial String "mtle" , We can find the day when the String "mettl" appears as a subseqeunce in the 
 *  following way.
 *  1) On the first day , the String K is "mtle" and doesn't contains the subsequence "mettl"
 *  
 *  2) On the second day , the String K becomes "mtlemtle" .However the String still doesn't contain 
 *  the sequence "mettl"
 *  
 *  3) On the third day , the String K becomes "mtlemtle"+"mtle"="mtlemtlemtle".
 *  Now the String K contains the subseqeunce "mettl" for the first time .
 *  
 *  Therefore , a minimum of 3 days is required for String K to contains the subsequence "mettl" .Hence
 *  3 is returned as the output.
 * 
 */


/**
 * @author Shweta Kumari
 *
 */
public class FirstDayOfSequence {

	/**
	 * @param string
	 * @param string2
	 * @return
	 */
	private static int minDaysToFormSubsequence(String input1, String input2) {

		StringBuilder current = new StringBuilder(input1);
		int days = 1;

		while (!isSubsequence(current.toString(), input2)) {
			current.append(input1);
			days++;
		}

		return days;
	}

	/**
	 * @param string
	 * @param input2
	 * @return
	 */
	private static boolean isSubsequence(String source, String target) {
		int i = 0, j = 0;

		while (i < source.length() && j < target.length()) {
			if (source.charAt(i) == target.charAt(j)) {
				j++;
			}
			i++;
		}

		return j == target.length();
	}

	public static void main(String[] args) {
		System.out.println(minDaysToFormSubsequence("mtle", "mettl"));

	}
}
