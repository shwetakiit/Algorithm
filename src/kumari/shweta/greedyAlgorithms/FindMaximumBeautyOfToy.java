/**
 *@author Shweta Kumari
 *2023-10-01
 */
package kumari.shweta.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kumari.shweta.tree.HeapDataStructureHelper;

/* 
 * There is a limited time sale going on for toys
   A[i] ->sale end time for ith toy
   B[i]-> Beauty of ith toy
   Time starts with T ->0 it take 1 unit of time to
   buy one toy and  toy can only be bought if T<A[i]
   Buy toy such that sum of beauty of toys is maximized
   
   Note :
   Input --Assume given A[i] --in ascending order If It is not in ascending order sorted form sort A[i] in Ascending order 
   and shift B[i] corresponding position of A[i]
   I assumed that I am providing input of A[i] and B[i] Where A[i] is already in sorted order.
   
   Example : A[i] -->[3 1 3 2 3 ]  B[i] -->[6 5 3 1 9 ]
   
   With greedy approach we are going to select  B->(5,9,6) -- so output is 20
   **/

public class FindMaximumBeautyOfToy {
	public int findMaximizedBeautyOfToy(List<Integer> saleEndTime, List<Integer> beautyOfToy) {

		HeapDataStructureHelper helper = new HeapDataStructureHelper();
		List<Integer> minHeap = new ArrayList<>();
		int T = 0;
		for (int i = 0; i < saleEndTime.size(); i++) {
			if (T < saleEndTime.get(i)) {
				helper.insert(minHeap, beautyOfToy.get(i));
				T++;
			} else {
				if (beautyOfToy.get(i) <= minHeap.get(0)) {
					continue;
				} else {
					helper.deleteSamllest(minHeap);
					helper.insert(minHeap, beautyOfToy.get(i));

				}
			}
		}
		// Some of collected toys by greedy approach which provides maximize beauty of toys.
		int sum = minHeap.stream().reduce((x, y) -> x + y).get();
		return sum;
	}

	public static void main(String[] args) {

		FindMaximumBeautyOfToy obj = new FindMaximumBeautyOfToy();
		List<Integer> A = Arrays.asList(1, 3, 3, 3, 5, 5, 5, 8); // Assume sale end time is given in sorted ascending order.
		List<Integer> B = Arrays.asList(5, 2, 7, 1, 4, 3, 8, 1);
		List<Integer> saleEndTime = new ArrayList<>(A);
		List<Integer> beautyOfToy = new ArrayList<>(B);
		int maximizedBeauty = obj.findMaximizedBeautyOfToy(saleEndTime, beautyOfToy);
		System.out.println("Sum of maximized beauty of toy is " + maximizedBeauty);
	}
}
