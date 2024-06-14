/**
 * @author Shweta Kumari
 *2024-06-13
 */
package kumari.shweta.LinkedList;

/**
 * 1)Find check is there loop found in List.
 * 2)Find the start point of loop
 *
 */
public class CheckIfLoopInList {

	public boolean findLoopInList(Node head) {
		Node slow = head;
		Node fast = head;
		boolean isCycle = false;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {

				isCycle = true;

				break;
			}
		}
		return isCycle;
	}

	public Node findStartPointOfLoop(Node head) {
		Node slow = head;
		Node fast = head;

		boolean isCycle = false;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {

				isCycle = true;

				break;
			}
		}

		if (isCycle) {
			slow = head; // Reset slow point to start and traverse one one step slow and fast
			while (true) {
				if (slow == fast) {// If loop found then slow and fast must be meet at a point and that point will
									// be start of loop.
					return fast;
				}
				slow = slow.next;
				fast = fast.next;
			}
		} else {
			return null;
		}
	}

	public static void main(String[] args) {

		// Input Loop at 96

		Node head = new Node(3);
		head.next = new Node(9);
		head.next.next = new Node(7);
		head.next.next.next = new Node(2);

		Node temp = head.next.next.next.next = new Node(8);
		temp.next = new Node(4);
		temp.next.next = new Node(16);
		temp.next.next.next = new Node(26);
		temp.next.next.next.next = new Node(96);
		temp.next.next.next.next.next = new Node(94);

		Node temp1 = temp.next.next.next.next.next.next = new Node(400);
		temp1.next = new Node(400);
		temp1.next.next = new Node(200);
		temp1.next.next.next = new Node(213);
		temp1.next.next.next.next = new Node(100);
		temp1.next.next.next.next.next = new Node(500);

		Node temp2 = temp1.next.next.next.next.next.next = new Node(250);
		temp2.next = new Node(75);
		temp2.next.next = new Node(32);
		temp2.next.next.next = temp.next.next.next.next;

		CheckIfLoopInList obj = new CheckIfLoopInList();

		boolean isLoopFound = obj.findLoopInList(head);
		System.out.println("Is loop found in list ?" + isLoopFound);

		Node startLoop = obj.findStartPointOfLoop(head);
		if (startLoop != null) {
			System.out.println("Loop start node " + startLoop.data);
		} else {
			System.out.println("There is no loop in list");
		}

	}
}
