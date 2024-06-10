package kumari.shweta.LinkedList;

class RandomListNode {
	int data;
	RandomListNode next;
	RandomListNode random;

	RandomListNode(int data) {
		this.data = data;
		next = null;
	}
}

public class CopyList {
	RandomListNode head;
	RandomListNode cloneHead;

	/**
	 * TC --O(N^2) SC -O(1)
	 * 
	 * @param node
	 * @return
	 */
	public RandomListNode copyRadomListNode(RandomListNode node) {

		// Prepare CloneNode with existing List.

		RandomListNode cloneHead = clonedList(node);
		RandomListNode curr1 = node;
		RandomListNode curr2 = cloneHead;

		while (curr1 != null) {
			RandomListNode randomNode = curr1.random;
			int index = 0;
			RandomListNode temp1 = node;
			while (temp1 != null) {
				if (temp1 == randomNode) {
					break;
				}
				index++;
				temp1 = temp1.next;
			}

			RandomListNode temp2 = cloneHead;
			for (int i = 1; i <= index; i++) {
				temp2 = temp2.next;
			}
			curr2.random = temp2;
			curr1 = curr1.next;
			curr2 = curr2.next;

		}

		return cloneHead;
	}

	/**
	 * TC -> O(N) SC -O(1)
	 * @param head
	 * @return
	 */
	public RandomListNode cloneRandomListNode(RandomListNode head) {

		RandomListNode temp = head;
		// Insert Cloned node in original linked list.
		while (temp != null) {
			RandomListNode newNode = new RandomListNode(temp.data);
			newNode.next = temp.next;
			temp.next = newNode;
			temp = temp.next.next;

		}

		// Set the random pointer of the cloned node.
		temp = head;
		while (temp != null) {
			if (temp.random == null) {
				temp.next.random = null;
				temp = temp.next.next;
				continue;
			}
			if (temp.next != null) {
				temp.next.random = temp.random.next;
				temp = temp.next.next;
			}

		}

		// Break the fake connection and keep real connection.
		RandomListNode head2 = head.next;
		RandomListNode t1 = head;
		RandomListNode t2 = head2;

		while (t2.next != null) {
			t1.next = t1.next.next;
			t2.next = t2.next.next;
			t1 = t1.next;
			t2 = t2.next;

		}
		t1.next = null;
		return head2;

	}

	private RandomListNode clonedList(RandomListNode node) {

		RandomListNode temp = node;
		RandomListNode clonedNode;
		if (node == null) {
			return null;
		}

		clonedNode = new RandomListNode(temp.data);
		RandomListNode tempClone = clonedNode;
		temp = temp.next;

		while (temp != null) {
			tempClone.next = new RandomListNode(temp.data);
			tempClone = tempClone.next;
			temp = temp.next;
		}
		return clonedNode;
	}

	public void traversal(RandomListNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + "(" + head.random.data + ")");

		RandomListNode temp = head.next;

		while (temp != null) {
			if (temp.random == null) {
				System.out.print("->" + temp.data + "(" + null + ")");
			} else {
				System.out.print("->" + temp.data + "(" + temp.random.data + ")");
			}

			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		RandomListNode head = new RandomListNode(10);
		head.next = new RandomListNode(3);
		head.next.next = new RandomListNode(7);
		head.next.next.next = new RandomListNode(9);
		head.next.next.next.next = new RandomListNode(5);
		head.random = head.next.next.next;
		head.next.random = head.next.next.next.next;
		head.next.next.random = head.next.next.next;

		CopyList obj = new CopyList();

		//Clone node with TC (N^2)
		System.out.println("Original linked list hasCode " + head.hashCode());
		RandomListNode clonedList = obj.copyRadomListNode(head);
		System.out.println("Clone Linked list hascode " + clonedList.hashCode());
		obj.traversal(clonedList);

		// Clone the node with TC(N) 
		System.out.println("Original linked list hasCode " + head.hashCode());
		RandomListNode clonedNode = obj.cloneRandomListNode(head);
		obj.traversal(clonedNode);
		System.out.println("Clone Linked list hascode " + clonedNode.hashCode());
	}
}
