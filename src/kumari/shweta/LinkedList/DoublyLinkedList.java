
package kumari.shweta.LinkedList;



/**
 * @author Shweta Kumari
 *
 */
class DoublyNode {
	DoublyNode next;
	int data;
	DoublyNode prev;
	DoublyNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class DoublyLinkedList {
	DoublyNode head;

	// Insert not at beginning
	/*
	 * Case 1 :If Linked List is Empty 
	 * Case 2: If Linked List is not Empty
	 */
	public DoublyNode insertAtBeginning(int data) {
		DoublyNode node = new DoublyNode(data);
		
		if(head==null) {
			head=node;
			return head;
		}
		DoublyNode temp=head;
		node.next = temp;
		node.prev = null; // Just for code reading easy not required by default node prev value is null
		temp.prev=node;
		
		head = node;
		return head;
	}

	// Insert Node at End
	/*
	 * Case 1: If Linked List is Empty 
	 * Case 2: If Linked List is not Empty
	 */
	public DoublyNode insertNodeAtEnd(int data) {
		DoublyNode node = new DoublyNode(data);

		if (head == null) {
			head = node;
			// node.next=null; //Not Required ,When We create oject of node next prev value
			// is null
			// node.prev=null;
			
			return head;
			
		} else {
			DoublyNode temp = head;
			while (temp.next != null) {

				temp = temp.next;
			}
			temp.next = node;
			node.next = null;
			node.prev = temp;
			
			
		}
		return head;
	}

	// Insert Node after a item
	/*
	 * Three Cases need to handle 
	 * 1.If Linked List is Empty 
	 * 
	 * 2. If we are adding in between linked list 
	 * 3 If it is going to be last element of Linked List
	 */
	public DoublyNode insertAfterANode(int data, int item) {
		boolean isFlag = false;
		if (head == null) {
			System.out.println("Empty Linked List");
		} else {

			DoublyNode node = new DoublyNode(data);
			DoublyNode temp = head;
			while (temp != null) {
				if (temp.data == item) {
					node.next = temp.next;
					node.prev = temp;
					
					if(temp.next!=null) { //If temp is last node then temp.next is null
					temp.next.prev = node;
                    }    
					temp.next = node;
					isFlag = true;
					return head;
				}
				temp = temp.next;

			}
			if (!isFlag) {
				System.out.println("Item not found");
			}
		}
		return head;

	}

	// Insert Node before a Item
	/*
	 * Three cases need to be handle 
	 * Case 1:If Linked List is Empty
	 * Case 2:If LinkedList has only one Node 
	 * Case 3:If Linked List has multiple node and
	 * adding in between node
	 */

	public DoublyNode insertNodeBeforeItem(int data, int item) {
		boolean itemFound = false;
		DoublyNode node = new DoublyNode(data);
	

		if (head == null) {
			
			System.out.println("Empty Linked List");
			return head;
			
		} else if (head.data == item) { //If single node 
			
			DoublyNode temp = head;
			node.next =temp;
			node.prev = null;
			temp.prev = node;
			head = node;
			itemFound = true;
            return head;
            
		} else {
			DoublyNode temp = head;
			while (temp != null) {
				if (temp.data == item) {

					node.prev = temp.prev;
					node.next = temp;
					temp.prev.next = node;
					temp.prev = node;
					itemFound = true;
					return head;

				}
				temp = temp.next;
			}
		}
		if (!itemFound) {
			System.out.println("Item not found ");
		}
		return head;
	}

	public DoublyNode insertNodeAtGivenPosition(int data, int position) {

		DoublyNode node = new DoublyNode(data);
		if (position <= 0) {
			DoublyNode temp = head;
			node.next = temp;
			node.prev = null;

			if (temp != null) { // If head is null
				temp.prev = node;
			}

			head = node;
			return head;
		} else {
			int index = 0;
			DoublyNode temp = head;
			while (index != position - 1 && temp.next != null) {
				temp = temp.next;
				index++;
			}
			if (position - 1 > index) { // If position crossed the list length of list. Add it at end

				node.prev = temp;
				node.next = null;
				temp.next = node;

			} else {

				node.next = temp.next;
				node.prev = temp;

				if (temp.next != null) { // If it is last node then temp.next is null;
					temp.next.prev = node;
				}

				temp.next = node;

			}
			return head;
		}
	}

	// Delete node from begnning
	public DoublyNode deleteFirstNode() {
		if (head == null) {

			System.out.println("Empty Linked List");
		} else {
			DoublyNode temp = head;
			temp = temp.next;
			temp.prev = null;
			head=temp;
		
		}
		return head;
	}

	public DoublyNode deleteNodeAtEnd() {
		boolean isDeleted = false;
		if (head == null) {

			System.out.println("Empty Linked List");
		} else if (head.next == null) {
			head = head.next;
			isDeleted = true;
		} else {
			DoublyNode temp = head;
			while (temp.next != null) {
				temp = temp.next;

			}
			temp.prev.next = temp.next;
			isDeleted = true;

		}

		if (isDeleted) {
			System.out.println("Node delted ");
		}
		
		return head;
	}

	
	public void deleteGivenItem(int item) {
		boolean isDeleted = false;
		

		if (head == null) {
			System.out.println("List is empty");
		} else if (head.data == item) { //If single node in list

			DoublyNode temp = head;
			head = temp.next;
			head.prev = temp.prev;
			isDeleted = true;

		} else {
			DoublyNode temp = head;
			while (temp!= null) {

				if (temp.data == item) {
					temp.prev.next = temp.next;
					if(temp.next!=null) { //If it is last node so temp.next is null
					temp.next.prev = temp.prev;
					}
					isDeleted = true;
					break;

				}
				temp = temp.next;
			}
		}
		if (!isDeleted) {

			System.out.println("Item not found on Linked List");

		}

	}

	// Delete Item at given position
	public DoublyNode deleteNoteAtGivenPosition(int position) {
	
		if (head == null) {
			System.out.println("List is Empty");
		} else if (position <= 0) {
			System.out.println("Please inter valid position eg from 1 onwards ..");
		} else if (position == 1) {
			DoublyNode temp = head;
			temp = temp.next;
			temp.prev = null;
			head = temp;
			
		} else {
			DoublyNode temp = head;
			   int index=0;
			   
			   while(index<position-1 && temp.next!=null) {
				   temp = temp.next;
				   index++;
			   }
				
		
			   if(position-1>index) { //Delete last node If delete position cross the length of list.
				   System.out.println("Inavlid position .It is beyond the length of list");
				   
				  } else {
				     temp.prev.next=temp.next;
				     if(temp.next!=null) { //If temp is last node so temp.next  is null
					 temp.next.prev=temp.prev;
				     }
				   
			   }
			 }
            return head;
		}

	// Traverse Node
	public void traversal() {

		if (head == null) {
			System.out.println("Empty Linked List");
		}
		DoublyNode temp = head;
		while (temp != null) {

			System.out.println(temp.data);
			temp = temp.next;

		}

	}

	public void traversalNode(DoublyNode headNode) {

		if (headNode == null) {
			System.out.println("Empty Linked List");
		}
		DoublyNode temp = headNode;
		while (temp != null) {

			System.out.println(temp.data);
			temp = temp.next;

		}

	}
	public static void main(String[] args) {

		DoublyLinkedList linkedList = new DoublyLinkedList();
		for (int i = 0; i < 5; i++) {
			linkedList.insertAtBeginning(i);
		}
		linkedList.traversal();

		System.out.println("Add node at end ....");
		DoublyNode headNode = linkedList.insertNodeAtEnd(99);
		linkedList.traversalNode(headNode);

		System.out.println("Insert Node after given Item");
		DoublyNode headNode2 = linkedList.insertAfterANode(100, 99);
		linkedList.traversalNode(headNode2);

		System.out.println("Insert Node before given Item");
		DoublyNode headNode3 = linkedList.insertNodeBeforeItem(1000, 99);
		linkedList.traversalNode(headNode3);

		System.out.println("Insert node at given position");
		DoublyNode headNode4 = linkedList.insertNodeAtGivenPosition(999, 8);
		linkedList.traversalNode(headNode4);

		System.out.println("Delete first Node ");
		linkedList.deleteFirstNode();
		linkedList.traversal();

		System.out.println("Delete last node ");
		linkedList.deleteNodeAtEnd();
		linkedList.traversal();

		System.out.println("Delete given item");
		linkedList.deleteGivenItem(100);
		linkedList.traversal();

		System.out.println("Delete item at given position");
		linkedList.deleteNoteAtGivenPosition(3);
		linkedList.traversal();

	}

}
