/**
 * @author Shweta Kumari
 *2023-03-05
 */
package kumari.shweta.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Integer called nobel integer if count of element which is less that array element is 
 * equal no  element of array
 * example : -1,-5,3,5,-10,4 
 * result is 3 
 * Noble integer is 3,5,4 
 * 
 * example : -10,1,1,2,4,4,4,8,10
 * noble integer 1,1,4,4,4, 
 * result 5
 * 
 * 
 */
public class NobleInteger {
	public static int bruteForce(List<Integer> list) {
		int result=0;
		//Sort in ascending order 
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			int count=0;
			for(int j=0;j<list.size();j++) {
				if(list.get(i)>list.get(j)) {
					count++;
				}
			}
			if(count==list.get(i)) {
				result++;
			}
		}
		return result;
	}
	
	public static int optimizedApproach(List<Integer> list) {
		int result=0;
		int count=0;
		Collections.sort(list);
		if(list.get(0)==0) {
			 result++;
		}
		for(int i=1;i<list.size();i++) {
			if(list.get(i)!=list.get(i-1)) {
				count=i;
			}
			if(count==list.get(i)) {
				 result++;
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(-10,1,1,2,4,4,4,8,10);
		int noOfNobleElement=bruteForce(list);
		System.out.println("No of noble element is "+noOfNobleElement);
		
		int noOfNobleElement1=optimizedApproach(list);
		System.out.println("No of noble Element in optimized way"+noOfNobleElement1);
		
	}

}
