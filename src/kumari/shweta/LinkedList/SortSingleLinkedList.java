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
	 * 
	 * @param node
	 * @return
	 */

	Node sortList(Node node) {

		if (node == null || node.next == null) { //Base case 
			return node;
		}

		// Find middle node to break the list in two part for applying merge sort .
		Node middleNode = getMiddleNode(node);

		Node head1 = node;
		Node head2 = middleNode.next;
		middleNode.next = null; // Now head1 is one list till middle node and head2 is second list after middle
								// node till last .
		Node h1 = sortList(head1);
		Node h2 = sortList(head2);
		return mergeSortedList(h1, h2);
	}

	/**
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Node mergeSortedList(Node node1, Node node2) {

		Node head = null;
		Node t1 = null;
		Node t2 = null;
		Node h1 = node1;
		Node h2 = node2;
		Node tail = null;

		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h2;
		}

		if (h1.data < h2.data) {

			head = h1;
			tail = h1;
			t1 = h1.next;
			t2 = h2;

		} else {
			head = h2;
			tail = h2;
			t2 = h2.next;
			t1 = h1;
		}

		while (t1 != null && t2 != null) {

			if (t1.data < t2.data) {
				tail.next = t1;
				t1 = t1.next;
				tail = tail.next;
			} else {
				tail.next = t2;
				t2 = t2.next;
				tail = tail.next;

			}
		}

		if (t1 == null) {
			tail.next = t2;
		}
		if (t2 == null) {
			tail.next = t1;
		}

		return head;
	}

	public void traversal(Node head) {
		Node tNode = head;
		if (tNode == null) {
			System.out.println("Empty list");
		}
		while (tNode != null) {
			System.out.println(tNode.data);
			tNode = tNode.next;
		}
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
		Node node = obj.sortList(head);
		obj.traversal(node);

	}

}
