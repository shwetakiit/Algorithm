/**
 * @author Shweta Kumari
 *2024-06-12
 */
package kumari.shweta.LinkedList;


/*Problem Description
  Merge two sorted linked lists, A and B, and return it as a new list.
  The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
  
  Problem Constraints
  0 <= |A|, |B| <= 105

*/

public class MergeTwoSortedList {

	public Node mergeTwoSortedNode(Node node1, Node node2) {
		
		Node head = null;
		Node tail = null;
		Node h1 = node1;
		Node h2 = node2;
		Node t1 = null;
		Node t2 = null;
		
		if (h1 == null) { //If first list is empty return complete second list
			return h2;
		}
		if (h2 == null) { //If second list is empty return complete first list
			return h1;
		}

		if (h1.data < h2.data) { //If first node of node1 is less than node2 then head will point to first list.

			head = h1;
			tail = h1;
			t1 = h1.next;
			t2 = h2;

		} else {               //If first node of second list is less than first node of first list then head will point to second list
			head = h2;
			tail = h2;
			t1 = h1;
			t2 = h2.next;
		}

		while (t1 != null && t2 != null) {//After first node picked for head we need to iterate both list and break the link in either of list as per condition and add to the head and move head forward 
			if (t1.data <= t2.data) {
				tail.next = t1;
				t1 = t1.next;
				tail = tail.next;
			} else {

				tail.next = t2;
				t2 = t2.next;
				tail = tail.next;

			}
		}

		if (t1 == null) {//If first list iteration completed and still we have nodes in second list then simply merge the remaining node of second list .
			tail.next = t2;
		}
		if (t2 == null) {//If second  list iteration completed and still we have nodes in  first list then simply merge the remaining node of first list .
			tail.next = t1;
		}

		return head;
	}

	public void traversal(Node head) {

		Node tNode = head;
		if (tNode == null) {
			System.out.println("Empty List \n");
		}
		while (tNode != null) {
			System.out.println(tNode.data);
			tNode = tNode.next;
		}
	}

	public static void main(String[] args) {

		MergeTwoSortedList obj = new MergeTwoSortedList();
		Node head1 = new Node(2);
		head1.next = new Node(6);
		head1.next.next = new Node(10);
		head1.next.next.next = new Node(14);
		head1.next.next.next.next = new Node(19);

		Node head2 = new Node(3);
		head2.next = new Node(5);
		head2.next.next = new Node(9);
		head2.next.next.next = new Node(11);

		Node finalNode = obj.mergeTwoSortedNode(head1, head2);
		System.out.println("Merged node is " + finalNode);
		obj.traversal(finalNode);
	}

}
