
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Shweta Kumari
 *
 */


/*
 * You are given an array A of integers that represent the lengths of ropes.
 * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
 * Find and return the minimum cost to connect these ropes into one rope.
 * 
 * Return an integer denoting the minimum cost to connect these ropes into one rope.
 * 
 * Given input length of ropes [`2,5,2,6,3] --> 2+2  [5,6,3,4]--> 3+4 [5,6,7] -->5+6 [7,11] --> 7+11 [18] --> 18
 * Total cost 4+7+11+18 -->40
 */
public class MiniumCostOfRopesUsingHeap {

	public Integer findMiniumCostForRope(List<Integer> ropesLength) {
		int totalCost = 0;
		// Build minHeap with given list of ropes length
		List<Integer> minHeap = buildHeap(ropesLength);
		// System.out.println("Build minHeap is "+minHeap);

		while (minHeap.size() > 1) { // This loop will execute until list size becomes one i.e. all ropes get
										// connected and provide only single rope

			// Extract first smallest node of minHeap i.e rootNode
			Integer n1 = extractRootElement(minHeap);
			// After extracting node tree is not in minHeap form . Build in minHeap
			buildHeap(minHeap);

			// Extract second smallest node from minHeap i.e root node
			Integer n2 = extractRootElement(minHeap);

			// After extracting node ,tree is not in minHeap form . Build in minHeap
			buildHeap(minHeap);
			

			// Assemble two rope which has minimum cost
			Integer cost = n1 + n2;
			

			// Add in total cost
			totalCost = totalCost + cost;

			// Now Insert assembled rope in given heap and build minHeap
			minHeap = insert(minHeap, cost);

		}
		
		return totalCost;
	}

	public List<Integer> buildHeap(List<Integer> list) {
		int N = list.size() - 1;

		for (int i = (N - 2) / 2; i >= 0; i--) {
			heapify(list, i);
		}
		return list;
	}
	
	private void heapify(List<Integer> minHeap, int i) {
		int N = minHeap.size();
		while (2 * i + 1 < N) {

			int parent = minHeap.get(i);
			int left = minHeap.get(2 * i + 1);
			int right = Integer.MAX_VALUE;

			if ((2 * i + 2) < N) {
				right = minHeap.get(2 * i + 2);

			}

			int minNode = minimum(parent, left, right);
			if (minNode == parent) {

				break;
			} else if (minNode == left) {

				swap(minHeap, i, 2 * i + 1);
				i = 2 * i + 1;
			} else if (minNode == right) {
				swap(minHeap, i, 2 * i + 2);
				i = 2 * i + 2;
			}
		}
	}

	private void swap(List<Integer> minHeap, int pi, int i) {
		int temp = minHeap.get(pi);
		minHeap.set(pi, minHeap.get(i));
		minHeap.set(i, temp);
	}

	private int minimum(int parent, int left, int right) {

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

	public Integer extractRootElement(List<Integer> minHeap) {

		swap(minHeap, 0, minHeap.size() - 1); // Swap root element to the leaf node of heap
		Integer root = minHeap.remove(minHeap.size() - 1); // Removed root element of min heap
		heapify(minHeap, 0);
		return root;
	}

	public List<Integer> insert(List<Integer> list, int elemenet) {

		// Build minHeap using given list
		List<Integer> minHeap = buildHeap(list);
		System.out.println("Created minHeap" + minHeap);

		minHeap.add(elemenet);
		System.out.println("Inserted node in last index of minHeap " + minHeap);

		int i = minHeap.size() - 1;
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

	/**
	 * In previous approach created minHeap for list of size n so creating minHeap TC O(nlogn)
	 * For list of size n  is n2logn --Which is not efficient for large input and we get Time limit exceeded error .
	 * TC O(n2logn) which is not efficient for large input 
	 * @param A
	 * @return
	 */
	//Second approach 
	public int findMinimumCostOfRope(List<Integer> A) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < A.size(); i++) {
			queue.add(A.get(i));
		}
		int cost = 0;
		while (queue.size() > 1) {
			int min1 = queue.remove();
			int min2 = queue.remove();
			int sum = min1 + min2;
			cost = cost + sum;
			if (queue.size() != 0) {
				queue.add(sum);
			}
		}

		return cost;
	}
	public static void main(String[] args) {

		MiniumCostOfRopesUsingHeap obj = new MiniumCostOfRopesUsingHeap();

		// Find minimum cost of rope --Given length of pieces of rope in list

		List<Integer> ropes = Arrays.asList(14,6,10,8,12,15);
		List<Integer> ropeLenght = new ArrayList<>(ropes);

		List<Integer> buildMap = obj.buildHeap(ropeLenght);
		System.out.println("Built minHeap " + buildMap);
		System.out.println("--------------------------------");
		int minimumCost = obj.findMiniumCostForRope(ropeLenght);
		
		System.out.println("Minium cost for assembling piece of ropes is " + minimumCost);
	}

}
