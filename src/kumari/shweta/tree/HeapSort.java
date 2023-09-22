/**
 * @author Shweta Kumari
 *2023-09-21
 */
package kumari.shweta.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HeapSort {

	
	/** 
	 * Heap sort in descending order -- Need to create maxHeap 
	 * Heap sort in Ascending order -- Need to create minHeap
	 * @param maxHeap
	 * @return
	 */
	
	/* TC N+(NlogN) --No of iteration + heapify --> TC O(NlogN)
	 * SC -->O(1)
	 **/

	public List<Integer> heapSortAscending(List<Integer> minHeap) {

		List<Integer> result = new ArrayList<>();
		while (minHeap.size() > 0) {
			swap(minHeap, 0, minHeap.size() - 1); // Swap root element to the leaf node of heap
			int node = minHeap.remove(minHeap.size() - 1); // Removed leaf element of min heap
			result.add(node); // Add removed node in result list
			minHeapify(minHeap, 0); // After swap of root and leaf node BT is not in min heap form so call heapify to convert in minHeap
		}
		return result;

	}

	/**
	 * @param minHeap
	 * @param i
	 */
	private void minHeapify(List<Integer> minHeap, int i) {
		int N = minHeap.size();  // Total no of node in heap.
		while (2 * i + 1 < N) {  // Until index of last left node less than total no of node in heap.We can't
								 // take right node for this condition because in complete binary tree right node
								 // can be null.

			int parent = minHeap.get(i);
			int left = minHeap.get(2 * i + 1);
			int right = Integer.MAX_VALUE;

			if ((2 * i + 2) < N) {
				right = minHeap.get(2 * i + 2);

			}

			int minNode = minimum(parent, left, right);
			if (minNode == parent) { // If minimum between left , right and parent is parent node then no more swap needed tree is in minHeap form
									
				break;
			} else if (minNode == left) {

				swap(minHeap, i, 2 * i + 1);// Swap left node with parent node
				i = 2 * i + 1;
			} else if (minNode == right) {
				swap(minHeap, i, 2 * i + 2); // Swap right node with parent node
				i = 2 * i + 2;
			}

		}
	}
	
	
	private int minimum(int parent, int left, int right) {
		int temp = (left<right)?left:right;
		int minNode=(parent<temp)?parent:temp;
		return minNode;

	}

	/**
	 * @param maxHeap
	 * @param i
	 * @param j
	 */
	private void swap(List<Integer> maxHeap, int pi, int i) {
		int temp = maxHeap.get(pi);
		maxHeap.set(pi, maxHeap.get(i));
		maxHeap.set(i, temp);

	}

	private void maxHeapify(List<Integer> maxHeap, int i) {
		int N = maxHeap.size(); // Total no of node in heap.
		while (2 * i + 1 < N) { // Until index of last left node less than total no of node in heap.We can't
								// take right node for this condition because in complete binary tree right node
								// can be null.

			int parent = maxHeap.get(i);
			int left = maxHeap.get(2 * i + 1);
			int right = Integer.MIN_VALUE;

			if ((2 * i + 2) > N) {
				right = maxHeap.get(2 * i + 2);

			}

			int maxNode = maximum(parent, left, right);
			if (maxNode == parent) { // If minimum between left , right and parent is parent node then no more swap
										// needed tree is in minHeap form
				break;
			} else if (maxNode == left) {

				swap(maxHeap, i, 2 * i + 1);// Swap left node with parent node
				i = 2 * i + 1;
			} else if (maxNode == right) {
				swap(maxHeap, i, 2 * i + 2); // Swap right node with parent node
				i = 2 * i + 2;
			}

		}

	}
	
	/**
	 * @param parent
	 * @param left
	 * @param right
	 * @return
	 */
	private int maximum(int parent, int left, int right) {

		int temp = (left > right) ? left : right;
		int maxNode = (parent > temp) ? parent : temp;
		return maxNode;
	}

	public static void main(String[] args) {

		HeapSort obj = new HeapSort();
		List<Integer> list = Arrays.asList(5, 12, 22, 20, 13, 25, 24, 35);
		List<Integer> maxHeap = new ArrayList<>(list);
		List<Integer> result = obj.heapSortAscending(maxHeap);
		System.out.println("Heap sort in ascending order" + result);
	}
}
