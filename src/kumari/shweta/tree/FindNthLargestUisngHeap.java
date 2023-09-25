/**
 * @author Shweta Kumari
 *2023-09-24
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNthLargestUisngHeap {

	/**
	 * Find nth largest element using minHeap
	 * 
	 * @param list --> given List
	 * @param k    -->find Kth Largest element
	 * @return
	 */
	private int findNthLargestNode(List<Integer> list, int k) {
		HeapDataStructureHelper obj = new HeapDataStructureHelper();

		// Convert for first k-1 element of list in minHeap
		List<Integer> minHeap = obj.buildHeap(list.subList(0, 3));

		// Compare minHeap with next Kth to list.size()-1

		for (int i = k; i < list.size(); i++) {
			int root = minHeap.get(0);
			if (root < list.get(i)) {
				minHeap.set(0, list.get(i));
				obj.heapify(minHeap, 0);
			}
		}

		return minHeap.get(0);
	}

/**
  * Problem Description Given an integer array B of size N.You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
  * NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
  * 
  *Problem Constraints 1 <= N <= 100000 1 <= A <= N 1 <= B[i] <= INT_MAX
  *Input Format -->The first argument is an integer A. The second argument is an integer array B of size N.
  *  
  * Output Format --> Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].
  * 
  * Input A = 4   B[1 2 3 4 5 6]   Output --> [-1, -1, -1, 1, 2, 3]
**/
	
	private List<Integer > findNthLargestUsingMaxHeap(List<Integer> list, int k){
		
		HeapDataStructureHelper obj = new HeapDataStructureHelper();
		List<Integer> minHeap = obj.buildHeap(list.subList(0, 3));
		List<Integer> result = new ArrayList<>();
        list.forEach(i->result.add(-1));
        result.set(k-1, minHeap.get(0));
		
		for (int i = k; i < list.size(); i++) {
			int root = minHeap.get(0);
			if (root < list.get(i)) {
				minHeap.set(0, list.get(i));
				obj.heapify(minHeap, 0);
				result.set(i,minHeap.get(0));
			} else {
				result.set(i,minHeap.get(0));
			}
		}
		
	return result; 
		
		
		
	}
	public static void main(String[] args) {

		FindNthLargestUisngHeap obj = new FindNthLargestUisngHeap();
		List<Integer> list = Arrays.asList(8, 5, 1, 2, 4, 9, 7);
		int k = 3;
		int kthLargestNode = obj.findNthLargestNode(list, k);
		System.out.println("Kth largest element is " + kthLargestNode);

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> list2 = Arrays.asList(15, 20, 99, 1);

		List<Integer> output1 = obj.findNthLargestUsingMaxHeap(list2, 2);
		System.out.println(output1);

		List<Integer> output2 = obj.findNthLargestUsingMaxHeap(list1, 3);
		System.out.println(output2);
		}
	}
