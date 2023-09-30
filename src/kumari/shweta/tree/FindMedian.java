/**
 * @author Shweta Kumari
 *2023-09-30
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*Given an infinite stream of integer .Find the median of current set of elements 
 * For example Input 
 * stream                                    median
   [1]                                        1
   [1, 2]          (1+2)/2                    1
   [1, 2, 5]                                  2
   [1, 2, 5, 4] -->[1,2,4,5] ->(2+4)/2        3
   [1, 2, 5, 4, 3]-->[1,2,3,4,5]              3
 * 
 * Output ->[1,1,2,3,3]
 */
public class FindMedian {

	public List<Integer> findMedianOfElements(List<Integer> input) {

		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());// Created maxHeap using priority queue
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();// Created minHeap using Priority Queue
		maxHeap.add(input.get(0)); // Assume we insert first element in (h1) in maxHeap
		result.add(input.get(0)); // Median for single element is same no itself

		for (int i = 1; i < input.size(); i++) {

			int data = input.get(i);
			if (data <= maxHeap.peek()) {

				maxHeap.add(data);

			} else {
				minHeap.add(data);
			}

			int diff = Math.abs(minHeap.size() - maxHeap.size());
			if (diff > 1) {
				balance(maxHeap, minHeap);
			}

			if (maxHeap.size() > minHeap.size()) {
				result.add(maxHeap.peek());
			} else if (maxHeap.size() < minHeap.size()) {
				result.add(minHeap.peek());
			} else {
				int avg = (maxHeap.peek() + minHeap.peek()) / 2;
				result.add(avg);
			}
		}

		return result;
	}

	/**
	 * @param maxHeap
	 * @param minHeap
	 */
	private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {

		if (maxHeap.size() > minHeap.size()) {
			int removedNode = maxHeap.poll();// Remove largest element from maxHeap and add it in minHeap
			minHeap.add(removedNode);
		} else {

			int removedNode = minHeap.poll(); // Remove smallest element from minHeap and add it in maxHeap
			maxHeap.add(removedNode);
		}
	}

	public static void main(String[] args) {

		FindMedian obj = new FindMedian();
		List<Integer> input = Arrays.asList(6, 3, 8, 11, 20, 2, 10, 8, 13, 50);
		List<Integer> result = obj.findMedianOfElements(input);
		System.out.println("Median of each element in array is " + result);
	}
}
