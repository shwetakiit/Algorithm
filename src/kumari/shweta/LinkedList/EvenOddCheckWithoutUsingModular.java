/**
 * 
 */
package kumari.shweta.LinkedList;

import java.util.Scanner;
/**
 * @author skumari
 *
 */
public class EvenOddCheckWithoutUsingModular {
	

	public static void main(String[] args) {
	boolean isEven=true;
	System.out.println("Enter number \n");
	Scanner sc = new Scanner(System.in);
	int number = sc.nextInt();
		
		
		for(int i =1;i<=number;i++) {
			 
			 isEven=!isEven;
			 
		 }
		 if(isEven)
		 System.out.println("Not odd number");
		 else {
			 System.out.println("Odd Number");
		 }
				
		if((number/2)*2==number) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}
		
 
		
	}
	
}
