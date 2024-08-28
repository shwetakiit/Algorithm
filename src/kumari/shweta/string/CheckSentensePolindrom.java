/**
 * @author Shweta Kumari
 *2024-08-26
 */
package kumari.shweta.string;

/**
 * Check sentence is polindrom or not .You can ignore white spaces and other character 
 * to consider string polindrom.
 *
 */

public class CheckSentensePolindrom {
	
	
	public  static boolean checkPolindrom(String str) {
		
		str=str.toLowerCase();
		int l=0;
		int r=str.length()-1;
		while(l<=r) {
			
			if(!(str.charAt(l)>='a' && str.charAt(l)<='z')) { //Ignore white space and other character apart from alphabet.
				l++;
			} else if(!(str.charAt(r)>='a' && str.charAt(r)<='z')) {
				r--;
			}
			else if(str.charAt(l)==str.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		String string="Too hot to hoot";
		System.out.println("Is is polindrom ?"+checkPolindrom(string));
		
		
	}

}
