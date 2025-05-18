/**
 * @author Shweta Kumari
 *2025-05-18
 */
package kumari.shweta.tree;

import java.util.Arrays;
import java.util.List;

public class HeapSortOptimized {

	// TC --N+NlogN --> O(NlogN)
	// SC --> O(1) Since we not using extra space here and size of list has been
	// reduced virtually .
	public void sort(List<Integer> list) {

		int lastParentNode = (list.size() - 1 - 1) / 2;

		// Prepare Max Heap first time .
		for (int i = lastParentNode; i >= 0; i--) {
			maxHeapify(i, list, list.size()); // Last parameter required to keep the last index of list after virtual
												// removal
		}

		// Sorting logic
		int j = list.size();

		while (j > 0) {
			swap(0, j - 1, list); 
			j--;
			maxHeapify(0, list, j);
		}

		list.forEach(i -> System.out.println(i));
	}

	/**
	 * @param i
	 * @param list
	 * @param size
	 */
	private void maxHeapify(int i, List<Integer> list, int size) {

		while (2 * i + 1 < size) {

			int parent = list.get(i);
			int left = list.get(2 * i + 1);
			int right = Integer.MIN_VALUE;

			if ((2 * i + 2) < size) {
				right = list.get(2 * i + 2);
			}

			int maxNode = findMaxNode(left, right, parent);
			if (maxNode == parent) {
				break;
			} else if (maxNode == left) {

				swap(i, 2 * i + 1, list);
				i = 2 * i + 1;
			} else if (maxNode == right) {
				swap(i, 2 * i + 2, list);
				i = 2 * i + 2;
			}
		}
	}

	/**
	 * @param left
	 * @param right
	 * @param parent
	 * @return
	 */
	private int findMaxNode(int left, int right, int parent) {
		int temp = (left > right) ? left : right;
		int maxNode = (parent > temp) ? parent : temp;
		return maxNode;
	}

	public void swap(int parentIndx, int targetIdx, List<Integer> list) {

		int temp = list.get(parentIndx);
		list.set(parentIndx, list.get(targetIdx));
		list.set(targetIdx, temp);

	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(9, 10, 5, 8, 4, 2, 3);
		HeapSortOptimized obj = new HeapSortOptimized();
		obj.sort(list);

	}
}
