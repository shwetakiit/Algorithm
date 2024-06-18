/**
 * @author Shweta Kumari
 *2024-06-16
 */
package kumari.shweta.LinkedList;


/*
Problem Description
You are using Google Maps to help you find your way around a new place. But, you get lost and end up walking in a circle. Google Maps has a way to keep track of where you've been with the help of special sensors.These sensors notice that you're walking in a loop, and now, Google wants to create a new feature to help you figure out exactly where you started going in circles.

Here's how we can describe the challenge in simpler terms: You have a Linked List A that shows each step of your journey, like a chain of events. Some of these steps have accidentally led you back to a place you've already been, making you walk in a loop. The goal is to find out the exact point where you first started walking in this loop, and then you want to break the loop by not going in the circle just before this point.

Problem Constraints
1 <= number of nodes <= 1000

*/

public class BreakLoopInLinkedList {

	public Node BreakLoopInPath(Node head) {

		Node slow = head;
		Node fast = head;
		boolean isCycle = false;

		// Move slow by one step and fast by two step If there is loop both will meet at
		// some point.

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				isCycle = true;
				break;
			}
		}

		// Now Reset slow on head and move slow and fast one -one step to find start
		// point of loop then break the loop from start point.

		if (isCycle) {
			slow = head;
			while (true) {

				if (slow == fast) {
					break;
				}
				slow = slow.next;
				fast = fast.next;

			}

			// Now slow and fast on start point where loop start . Now Break the loop.
			Node start = slow;
			Node last = slow;
			while (last.next != start) {
				last = last.next;
			}
			last.next = null;
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

		// Test case 1:
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = head1;

		BreakLoopInLinkedList obj = new BreakLoopInLinkedList();
		Node afterRemovedLoopNode = obj.BreakLoopInPath(head1);
		obj.traversal(afterRemovedLoopNode);

		// Test case 2:
		Node head = new Node(3);
		head.next = new Node(2);
		Node temp = head.next.next = new Node(4);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(6);
		head.next.next.next.next.next = temp;

		System.out.println("Second List");
		Node withoutLoop = obj.BreakLoopInPath(head);
		obj.traversal(withoutLoop);

	}

}
