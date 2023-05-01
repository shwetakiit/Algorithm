/**
 * @author Shweta Kumari
 *2023-05-01
 */
package kumari.shweta.subsequence.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
As the number may be large, output the number modulo 1e9 + 7 (1000000007).
NOTE: Subsequence can be non-contiguous.
Problem Constraints
1 <= N <= 10000
1<= A[i] <=1000
Input :A = [3, 5, 10] output 21 
 */
public class SubOfMaxMinSubSubsequence {
	
	static int  sumOfSubSeqence(List<Integer> list){
		
		int sum=0;
		int N=list.size();
		int range = (int) Math.pow(2,N);
		for(int i=0;i<range;i++) {
			List<Integer> subSequence = new ArrayList<Integer>();
			for(int j=0;j<N;j++) {
				if((i & (1<<j))!=0) {
					subSequence.add(list.get(j));
				}
			}
			System.out.println(subSequence);
			if(!subSequence.isEmpty()) {
			int max=Collections.max(subSequence);
			int min=Collections.min(subSequence);
			int diff=max-min;
			sum=sum+diff;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 5, 10);
		int result=sumOfSubSeqence(list);
		System.out.println("Result is "+result);
		
	}

}
