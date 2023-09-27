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

	public List<Integer> heapSortDecending(List<Integer> maxHeap) {

		List<Integer> result = new ArrayList<>();
		while (maxHeap.size() > 0) {
			swap(maxHeap, 0, maxHeap.size() - 1); // Swap root element to the leaf node of heap
			int node = maxHeap.remove(maxHeap.size() - 1); // Removed leaf element of min heap
			result.add(node); // Add removed node in result list
			maxHeapify(maxHeap, 0); // After swap of root and leaf node BT is not in min heap form so call heapify
									// to convert in minHeap
		}
		return result;
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

			if ((2 * i + 2) < N) { //This condition need to check in case right node is null and this situation happen in CBT of just before one level of leaf node which has no right child and left child of that node is last node of CBT .
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

	/**
	 * Problem Description   
	 * N people having different priorities are standing in a queue.The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
	 * Your task is to sort the queue in the increasing order of priorities.
	 * NOTE:
	 * 1. No two persons can have the same priority  
	 * 2. Use the property of the queue to sort the queue with complexity O(NlogB).
	 * 
	 * Problem Constraints  -->1 <= N <= 100000    0 <= B <= N
	 * Input Format  :--
	 * The first argument is an integer array A representing the priorities and initial order of N persons.
	 * The second argument is an integer B.
	 * Output Format :--
	 * Return an integer array representing the sorted queue.
	 * Example Input  --> A = [1, 40, 2, 3]  B = 2
	 * Output -->[1, 2, 3, 40]
	 * 
	 * TC --O(K+NlogK) SC --O(K)
	 */
	
	public List<Integer> sortedQueueInIncreasingOfPriorities(List<Integer> priorities, int k) {
		List<Integer> result = new ArrayList<>();
		HeapDataStructureHelper helper = new HeapDataStructureHelper();
		
        List<Integer> subList = new ArrayList<>(priorities.subList(0, k + 1)); 
        
        // Build minHeap for k+1 element extract root and store in result.
		List<Integer> buildMinHeap = helper.buildHeap(subList);

		// Remove smallest element and insert next element from priorities
		
		for (int i = k+1; i < priorities.size(); i++) {
			int smallest = helper.extractMin(buildMinHeap);
			result.add(smallest);
			buildMinHeap.add(priorities.get(i));
			minHeapify(buildMinHeap, 0);

		}
		// After inserting all element from priorities remove smallest element one by one and store in result .
		while (buildMinHeap.size() > 0) {
			int smallest = helper.extractMin(buildMinHeap);
			result.add(smallest);
		}
		return result;
	}
	public static void main(String[] args) {

		HeapSort obj = new HeapSort();
		List<Integer> list = Arrays.asList(5, 12, 22, 20, 13, 25, 24, 35);
		List<Integer> minHeap = new ArrayList<>(list);
		List<Integer> result = obj.heapSortAscending(minHeap);
		System.out.println("Heap sort in ascending order" + result);
		
		List<Integer> list1= Arrays.asList(14,13,10,7,6,8,5,2,1,3);
		List<Integer> maxHeap = new ArrayList<>(list1);
		List<Integer> sortedList = obj.heapSortDecending(maxHeap);
		System.out.println("Sorted in decending order"+sortedList);
		
		/* Sort the queue in the increasing order of priorities. */
		List<Integer> prioritiesList  = Arrays.asList(11,13,20,22,31,45,48,50,60);
		List<Integer> priorities = new ArrayList<>(prioritiesList);
		List<Integer> sortedQueue = obj.sortedQueueInIncreasingOfPriorities(priorities, 4);
		System.out.println("Sorted queue in increaing order of Priority is "+sortedQueue);
		
		
	}
}
