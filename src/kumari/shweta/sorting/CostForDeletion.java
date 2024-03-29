/**
 * @author Shweta Kumari
 *2023-02-28
 */
package kumari.shweta.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.
Find the minimum cost to remove all elements from the array.
0 <= N <= 1000
1 <= A[i] <= 10^3

Return an integer denoting the total cost of removing all elements from the array.
 Example Input
Input 1:
 A = [2, 1]
Input 2:

 A = [5]

Example Output
Output 1:

 4
Output 2:

 5
Example Explanation
Explanation 1:

 Given array A = [2, 1]
 Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
 Remove 1 from the array => []. Cost of this operation is (1) = 1.
 So, total cost is = 3 + 1 = 4.
Explanation 2:

 There is only one element in the array. So, cost of removing is 5.
 */
public class CostForDeletion {
	  public static  int solve(List<Integer> A) {
		  
		     Collections.sort(A,Collections.reverseOrder());
		     int cost=0;
		     for(int i=0;i<A.size();i++){
		         cost+=A.get(i)*(i+1);
		         }
		     return cost;

		    }
public static void main(String[] args) {
	List<Integer> list= Arrays.asList(6,-1,-2,-3,-4);
	int totalDeletionCost=solve(list);
	System.out.println("Total const for deleting all element from list is"+totalDeletionCost);
 }
}
