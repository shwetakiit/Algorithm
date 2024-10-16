/**
 * @author Shweta Kumari
 *2024-10-16
 */
package kumari.shweta.subarray;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array
Note : The order of the subarrays in the resulting 2D array does not matter.
Problem Constraints
1 <= N <= 100
1 <= A[i] <= 10^5
Input Format
First argument A is an array of integers.
Output Format Return a 2D array of integers in any order.
Example Input Input 1: A = [1, 2, 3]
Input 2: A = [5, 2, 1, 4]
Example Output Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
Example Explanation
For Input 1:
All the subarrays of the array are returned. There are a total of 6 subarrays.
For Input 2:
All the subarrays of the array are returned. There are a total of 10 subarrays.
*/
public class GenerateAllSubArray {
	
	//TC -> O(N^2)
	List<ArrayList<Integer>>  findAllSubArrays(int arr[]){
		List<ArrayList<Integer>> subArrays = new ArrayList<>();
		
		for(int i =0;i<arr.length;i++) {
			ArrayList<Integer> subArray = new ArrayList<>();
			for(int j=i;j<arr.length;j++) {
				subArray.add(arr[j]);
				subArrays.add(new ArrayList<>(subArray));
		    }
		
		}
		
		System.out.println(subArrays);
		return subArrays;
	}
	
	public static void main(String[] args) {
		GenerateAllSubArray obj = new GenerateAllSubArray();
		int arr[]= {1, 2, 3};
		obj.findAllSubArrays(arr);
		}

}
