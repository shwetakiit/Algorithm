package kumari.shweta.LinkedList;
/**
 * @author Shweta Kumari
 * @Mail id : shwetakumarikiit0729@gmail.com
 *
 */
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class SingleLinkedListAllFeature {
	Node head;
	
	// Insert Node at beginning
	public void insertAtBeginning(int element) {
		Node node = new Node(element);
		node.next = head;
		head = node;
	}
	// Insert Node at end
	public void insertNodeAtEnd(int element) {

		Node node = new Node(element);
		if (head == null) {
			head = node;
		} else {
			Node last = head;
			while (last.next != null) {
				last = last.next;

			}
			last.next = node;
		}
	}

	// Insert Node in between two nodes
	// Case 1 : Insert node before a Node
	public void insertNodeBeforeAnode(int element, int item) {
		Node node = new Node(element);
		Node last = head;
		if (last == null) {
			System.out.println("Empty Linked List ");
		} else if (item == last.data) { // If only one node is available
			node.next = last;
			head = node;
		} else {
			boolean itemFound = false;
			while (last.next != null) {
				if (last.next.data == item) {
					node.next = last.next;
					last.next = node;
					itemFound = true;
					break;
				}
				last = last.next;
			}
			if (!itemFound) {
				System.out.println("Item is not available in Linked List");

			}
		}
	}

	// Case 2: Insert Node after a Node
	public void insertNodeAfterANode(int element, int item) {
		Node node = new Node(element);
		Node last = head;
		if (last == null) {
			System.out.println("Empty Linked List ");
		} else if (last.data == item) {
			last.next = node;
		} else {
			boolean itemFound = false;
			while (last.next != null) {
				if (last.data == item) {
					node.next = last.next;
					last = node;
					itemFound = true;

				}
				last = last.next;
			}
			if (!itemFound) {
				System.out.println("Item is not available in Linked List");
			}
		}
	}
	
	/*
	 * Case 3 : Insert node at given position 
	 * Notes:
	 * In case the position is more than length of linked list, simply insert the
	 * new node at the tail only. In case the position is 0, simply insert the new node
	 * at head only. Follow 0-based indexing for the node numbering.
	 */
	public void insertNodeAtGivenPosition(int element, int position) {
		Node node = new Node(element);
		Node last = head;
		if (position <= 0) { // Insert node at beginning
			node.next = last;
			head = node;
		} else {
			int index = 0;
			while ((index != position - 1) && (last.next != null)) {
				last = last.next;
				index++;
			}
			if (position - 1 > index) { // insert at end if pos is more than length of list
				last.next = node;
			} else {
				node.next = last.next;
				last.next = node;
			}
		}

	}

	public void deleteFirstNode() {
		boolean isDeleted;
		if(head == null ) {
			System.out.println("Empty LinkedList");
		} else {
			head=head.next;
		}
	}

	public void deleteGivenItem(int item) {

		Node temp = head;
		Node targetNode;
		boolean isDeleted = false;
		if (head == null) {
			System.out.println("List is empty");
		} else {
			while (temp.next != null) {
				if (temp.next.data == item) {
					targetNode = temp.next;
					temp.next = targetNode.next;
					isDeleted = true;
					break;

				}
				temp = temp.next;
			}
		}
		if (!isDeleted) {
			System.out.println("Target to be deleted item not found");
		} else {
			System.out.println(item + " Deleted Successfully");
		}
	}
	
	public void deleteAtPosition(int position) {

		Node temp;
		temp = head;
		try {
			if (position == 0) {
				head = temp.next;
			}
			for (int i = 0; temp != null && i < position - 2; i++) {
				temp = temp.next;
			}

			Node kNode = temp.next.next;
			temp.next = kNode;
		} catch (Exception e) {
			System.out.println("Position beyond range");

		}
	}
	//Reverse Linked List --> Using recusrion 
	public void reverseLinkedList() {
		Node temp = head;
		printReverse(temp);
		
	}
	
	private void printReverse(Node temp) {
		if(temp==null) { //Base case 
			return;
		}
		printReverse(temp.next);
		System.out.print(temp.data+" ");
	}
	
	// Traversing LinkedList
	public void traversal() {

		Node tNode = head;
		if(tNode==null) {
			System.out.println("Empty List \n");
		}
		while (tNode != null) {
			System.out.println(tNode.data);
			tNode = tNode.next;
		}
	}
	//Search element in linked list
	private boolean search(int element) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == element) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public static void main(String[] args) {

	SingleLinkedListAllFeature linkedList = new SingleLinkedListAllFeature();
		System.out.println("Inserting Node at beginning..");
		for (int i = 0; i < 5; i++) {
			linkedList.insertAtBeginning(i);
		}
		linkedList.traversal();
		System.out.println("After Insering node at End ...");
		linkedList.insertNodeAtEnd(5);
		linkedList.traversal();
		System.out.println("Inserting node before node ");
		linkedList.insertNodeBeforeAnode(99, 5);
		linkedList.traversal();
		System.out.println("Inserting node after node ");
		linkedList.insertNodeAfterANode(5, 100);
		linkedList.traversal();
		System.out.println("Insert node at given position");
		linkedList.insertNodeAtGivenPosition(100, 3);
		linkedList.traversal();
		System.out.println("Deleting node from begning ");
		linkedList.deleteFirstNode();
		linkedList.traversal();
		System.out.println("Delete item");
		linkedList.deleteGivenItem(5);
		linkedList.traversal();
		System.out.println("Delete Node at position ");
		linkedList.deleteAtPosition(4);
		linkedList.traversal();
		System.out.println("Reverse linked list using recursion");
		linkedList.reverseLinkedList();
		
		System.out.println("Search element linked list");
		int element=100;
		boolean isFound=linkedList.search(element);
		if(isFound) {
			System.out.println(element+" is found in linked list");
		}else {
			System.out.println(element+" not found in linked list");
		}
		
	}
}
