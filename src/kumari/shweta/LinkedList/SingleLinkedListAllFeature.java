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
	
	// Insert Node at beginning . TC--O(1) SC ->O(1) 

	public void insertAtBeginning(int element) {
		Node node = new Node(element);
		node.next = head;
		head = node;
	}
	// Insert Node at end  TC -->O(N)  SC -->O(1)
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
	 * TC -->O(position)
	 * SC ->O(1)
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

	//Delete first node  TC -O(1) SC -O(1)
	public void deleteFirstNode() {
		boolean isDeleted;
		if(head == null ) {
			System.out.println("Empty LinkedList");
		} else {
			head=head.next;
		}
	}
	
	//Delete node at End TC ->O(N) SC ->O(1) 
	public void deleteAtEnd() {

		if (head == null) { // If List is empty
			System.out.println("List is empty");
			return;
		} else if (head.next == null) { // If there is only one element so we can't find second last node

			head = null;
			return;
		} else {
			Node last = head;
			while (last.next.next != null) { // Find second last node
				last = last.next;
			}
			last.next = null;
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
		
		//If list is empty
		if(head==null) {
		   System.out.println("List is empty.....");
		   return;
		} 
		
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
	

	/**
	 * Consider Position start from 0th, 1st,2nd 3rd,etc..
	 */
	public void deleteAtGivenPosition(int position) {

	
		
		//If list is empty
		if(head==null) {
		   System.out.println("List is empty.....");
		   return;
		}
		Node temp;
		temp = head;
		 if(position==0) { //If first node to be deleted .
			
			 head=temp.next;
			return;
		}
		
			int index=0;
			while(index<position-1 && temp!=null) {
				
				temp=temp.next;
				index++;
			}
			
			if(temp==null|| temp.next==null) { //If position exceed the length of list.
				System.out.println("Invalid position which is beyond the length of List");
				return ;
			} else {
				temp.next=temp.next.next;
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
	
	private void reverse() {
		
		if(head==null) {
			return;
			
		}
		
	   Node prev = null;
	   Node current = head;
	   Node temp = null;
	   while(current != null) {
		   
		   temp = current.next;
		   current.next= prev;
		   prev= current;
		   current=temp;
	   }
	   head= prev;
	}
	
	
	/**
	 * Find Middle node of linked list Find (l-1)/2 node If length of linked list is
	 * l.
	 * 
	 * @param head
	 * @return
	 */
	Node findMiddleNodeOfList() {

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
		for (int i = 0; i <=5; i++) {
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
		//linkedList.deleteAtPosition(4);
		linkedList.deleteAtGivenPosition(4);
		linkedList.traversal();
		System.out.println("Delete Node at End ");
		linkedList.deleteAtEnd();
		linkedList.traversal();
		//System.out.println("Reverse linked list using recursion");
		//linkedList.reverseLinkedList();
	   // System.out.println();
		System.out.println("Reverse linked list using iterative approach");
		linkedList.reverse();
		linkedList.traversal();
		System.out.println("Search element linked list");
		
		// Find middle node of Linked List

		Node middleNode = linkedList.findMiddleNodeOfList();
		System.out.println("Middle node of linked list is" + middleNode.data);

		int element=100;
		boolean isFound=linkedList.search(element);
		if(isFound) {
			System.out.println(element+" is found in linked list");
		}else {
			System.out.println(element+" not found in linked list");
		}
		
		
		
	}
}
