/**
 * @author Shweta Kumari
 *2024-06-16
 */
package kumari.shweta.LinkedList;

public class PolindromInLinkedList {

	public boolean checkPolindrom(Node head) {

		if (head == null || head.next == null) {
			return true;
		}

		// Find middle node of linked list to divide list in two part.
		Node middleNode = findMiddleNode(head);

		Node head2 = middleNode.next; // Second half list start point.
		middleNode.next = null; // First half break till mid node .

		// Now we have two list first half start is head and second half start is head2

		Node reversedHead2 = reverseList(head2);

		// Now compare two list head and head2 w.r.t. node value

		Node t1 = head;
		Node t2 = reversedHead2;
		boolean isPolindrom = true;
		while (t1 != null && t2 != null) {
			if (t1.data != t2.data) {
				isPolindrom = false;
				break;
			}
			t1 = t1.next;
			t2 = t2.next;
		}

		return isPolindrom;
	}

	/**
	 * @param head2
	 */
	private Node reverseList(Node head2) {

		if (head2 == null || head2.next == null) {
			return head2;
		}

		Node current = head2;
		Node prev = null;
		while (current != null) {
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		head2 = prev;
		return head2;
	}

	/**
	 * @param head
	 * @param slow
	 * @param fast
	 * @return
	 */
	private Node findMiddleNode(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {

		// 1->2->3->-4->5->3->2->1

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);

		PolindromInLinkedList obj = new PolindromInLinkedList();
		System.out.println("Is list polindrom " + obj.checkPolindrom(head));

		// 1->2->3->->3->2->1
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(3);
		head2.next.next.next.next = new Node(2);
		head2.next.next.next.next.next = new Node(1);
		System.out.println("Is list2 polindrom " + obj.checkPolindrom(head2));
	}
}
