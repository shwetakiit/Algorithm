/**
 * @author Shweta Kumari
 *2025-05-19
 */
package kumari.shweta.tree;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindNthSmallestUsingHeap {
	

	//Using Inbuild function. TC -> O(K+(N-K)logK)
	
	public int findKthSmallest(List<Integer> list, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Build max heap . Priority queue by default
																			// It build min heap.

		for (int i = 0; i < k; i++) {
			pq.add(list.get(i));
		}

		for (int i = k; i < list.size(); i++) {
			int root = pq.peek();
			if (list.get(i) < root) {
				pq.poll();
				pq.add(list.get(i));
			}
		}
		return pq.peek();

	}

	public static void main(String[] args) {
		
		FindNthSmallestUsingHeap obj = new FindNthSmallestUsingHeap();
		List<Integer> list=Arrays.asList(8, 5, 1, 2, 4, 9, 7);
		int k=3;
		int kthSmallest=obj.findKthSmallest(list, k);
		System.out.println("Find kth smallest element"+kthSmallest);
		
		
		
	}
}
