/**
 * @author Shweta Kumari
 *2023-09-11
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapDataStructureHelper {

	// Insert node in min heap TC O(height of tree) -->O(logN)

	public List<Integer> insert(List<Integer> list, int elemenet) {

		// Build minHeap using given list
		List<Integer> minHeap = buildHeap(list);

		System.out.println("Created minHeap" + minHeap);

		// Now insert element in minHeap
		minHeap.add(elemenet); // Add element on last index of array

		System.out.println("Inserted node in last index of minHeap "+minHeap);
		int i = minHeap.size() - 1;// We insert element at last index of heap array
		while (i > 0) {

			int pi = (i - 1) / 2;
			if (minHeap.get(pi) > minHeap.get(i)) {
				swap(minHeap, pi, i);
				i = pi;
			} else {
				break;
			}
		}
		return minHeap;
	}

	// Delete element from heap data structure
	public List<Integer> deleteSamllest(List<Integer> minHeap) {

		swap(minHeap, 0, minHeap.size() - 1); // Swap root element to the leaf node of heap
		System.out.println("Swapped root node at last leaf node "+minHeap);

		minHeap.remove(minHeap.size() - 1); // Removed root element of min heap
		heapify(minHeap, 0);
		return minHeap;
	}
	
	
	/**
	 * Covert in minHeap 
	 * @param minHeap
	 * @param i
	 */
	public void heapify(List<Integer> minHeap, int i) {
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

	/*
	 * Build minHeap from given list of data 
	 */
	// TC -->O(N)
	public List<Integer> buildHeap(List<Integer> list) {
		int N = list.size() - 1;

		for (int i = (N - 2) / 2; i >= 0; i--) {
			heapify(list, i);
		}
		return list;
	}

	/**
	 * @param parent
	 * @param left
	 * @param right
	 * @return
	 */
	public int minimum(int parent, int left, int right) {
		int temp = 0;
		if (left < right) {
			temp = left;
		} else {
			temp = right;
		}
		if (parent > temp) {
			return temp;
		} else {
			return parent;
		}

	}

	/**
	 * @param minHeap
	 * @param pi
	 * @param i
	 */
	public void swap(List<Integer> minHeap, int pi, int i) {
		int temp = minHeap.get(pi);
		minHeap.set(pi, minHeap.get(i));
		minHeap.set(i, temp);
	}

	
	public static void main(String[] args) {

		HeapDataStructureHelper obj = new HeapDataStructureHelper();
		
		  List<Integer> list = Arrays.asList(12, 5, 25, 20, 13, 22, 24, 35);
		  List<Integer> minHeap = new ArrayList<>(list);
		  
		  // Insert element in minHeap
		  List<Integer> result = obj.insert(minHeap, 10);
		  System.out.println("After inserting node in minHeap"+result); 
		  List<Integer> resIntegers =
		  obj.deleteSamllest(minHeap);
		  System.out.println("After extracting smallest elemnt from minHeap is " +
		  resIntegers);
		 
		

	}
}
