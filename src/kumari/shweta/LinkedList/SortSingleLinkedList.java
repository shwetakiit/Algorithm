/**
 * @author Shweta Kumari
 *2024-06-13
 */
package kumari.shweta.LinkedList;

/*
Sort a linked list, A in O(n log n) time.
Problem Constraints
0 <= |A| = 105
*/



public class SortSingleLinkedList {
	
	
	/**
	 * TC -O(NlogN+N) , SC O(logN)  
	 * @param node
	 * @return
	 */

	public Node mergeSortLinkedList(Node node) {

		Node head = node;
		if (head == null || head.next == null) {
			return head;
		}

		Node midNode = getMiddleNode(head);
		Node head2 = midNode.next; // Created new head for second half list
		midNode.next = null;
		head = mergeSortLinkedList(head); // Apply mergeSort on first half list;
		head2 = mergeSortLinkedList(head2);

		return mergedSortedLinkedList(head, head2);
	}

	/**
	 * Merge the two sorted linked list.
	 * 
	 * @param head
	 * @param head2
	 * @return
	 */
	private Node mergedSortedLinkedList(Node head, Node head2) {

		return MergeTwoSortedList.mergeTwoSortedNode(head, head2);
	}

	/**
	 * @param head
	 * @return
	 */
	public Node getMiddleNode(Node head) {

		if (head == null) { // If node is null
			return null;
		}
		if (head.next == null) { // If Only one node (1-1)/2 0th Index node
			return head;
		}
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {

		// 10->3->7->9->5->4->->11
		Node head = new Node(10);
		head.next = new Node(3);
		head.next.next = new Node(7);
		head.next.next.next = new Node(9);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(11);

		SortSingleLinkedList obj = new SortSingleLinkedList();
		Node sortedNode = obj.mergeSortLinkedList(head);

		// Traverse sorted node
		MergeTwoSortedList.traversal(sortedNode);

	}

}
