/**
 * @author Shweta Kumari
 *2023-03-07
 */
package kumari.shweta.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindFirstMissingNumber {
	
	//Time complexity O(n^2)  Space complexity O(1)
 public static int bruteForceAppraoch(List<Integer> list) {
	for(int i=1;i<=list.size();i++) {
		boolean missingNumber=true;
		for(int j=0;j<list.size();j++) {
			if(list.get(j)==i) {
				missingNumber=false;
				break;
			}
		}
		if(missingNumber) {
			return i;
		}
	}
	return list.size()+1;
	}
 
 //Time complexity O(N) but we are using here extra space that is HashSet Sapce complexity O(N)
 
 public static int missingFirstNaturalNo(List<Integer> list) {
	Set<Integer> nNaturalNo = new HashSet<Integer>(list);
	 for(int i=1;i<=list.size();i++) {
		 if(!nNaturalNo.contains(i)) {
			 return i;
		 }
	 }
	return list.size()+1;
 }
 
 //Keep the element in correct position TC -O(n)
	public static int swapElementOnCorrectPos(List<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			while (A.get(i) > 0 && A.get(i) <= A.size() && (A.get(i) != i + 1)) {
				int val = A.get(i);
				if (A.get(i) == A.get(val - 1))// Handle if duplicate element is present to avoid infinite loop
					break;

				int tmp = A.get(i);
				A.set(i, A.get(val - 1));
				A.set(val - 1, tmp);

			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) != i + 1)
				return i + 1;
		}
		return A.size() + 1;
	}
	

	public static void main(String[] args) {
	  List<Integer> list1 = Arrays.asList(-8,0,1,2,3,4);
	  List<Integer> list2=Arrays.asList(2,3,4,5);
	  List<Integer> list3=Arrays.asList(1,2,3,4,5);
	 System.out.println("First Missing Natural no in list1 "+bruteForceAppraoch(list1));
	 System.out.println("First Missing Natural no in list2 "+bruteForceAppraoch(list2));
	 System.out.println("First Missing Natural no in list3 "+bruteForceAppraoch(list3));
	 
	 System.out.println("Second approach ...");
	 System.out.println("First Missing Natural no in list1 "+missingFirstNaturalNo(list1));
	 System.out.println("First Missing Natural no in list2 "+missingFirstNaturalNo(list2));
	 System.out.println("First Missing Natural no in list3 "+missingFirstNaturalNo(list3));
	 System.out.println("Third approach...");
	 
	 System.out.println("First Missing Natural no in list1 "+swapElementOnCorrectPos(list1));
	 System.out.println("First Missing Natural no in list2 "+swapElementOnCorrectPos(list2));
	 System.out.println("First Missing Natural no in list3 "+swapElementOnCorrectPos(list3));
	 
	}

}
