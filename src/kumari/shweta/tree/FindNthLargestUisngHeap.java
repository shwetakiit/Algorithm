/**
 * @author Shweta Kumari
 *2023-09-24
 */
package kumari.shweta.tree;

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

	public static void main(String[] args) {

		FindNthLargestUisngHeap obj = new FindNthLargestUisngHeap();
		List<Integer> list = Arrays.asList(8, 5, 1, 2, 4, 9, 7);
		int k = 3;
		int kthLargestNode = obj.findNthLargestNode(list, k);
		System.out.println("Kth largest element is " + kthLargestNode);
	}
}
