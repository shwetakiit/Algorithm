/**
 * 
 */
package kumari.shweta.LinkedList;

/**
 * @author Shweta Kumari
 * @Email id shwetakumarikiit0729@gmail.com
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
	 * Case 1 :If Linked List is Empty Case 2: If Linked Lit is not Empty
	 */
	public void insertAtBeginning(int data) {
		DoublyNode node = new DoublyNode(data);
		node.next = head;
		node.prev = null; // Just for code reading easy not required by default node prev value is null
		if (head != null) {
			head.prev = node;
		}
		head = node;
	}

	// Insert Node at End
	/*
	 * Case 1: If Linked List is Empty Case 2: If Linked List is not Empty
	 */
	public void insertNodeAtEnd(int data) {
		DoublyNode node = new DoublyNode(data);

		if (head == null) {
			head = node;
			// node.next=null; //Not Required ,When We create oject of node next prev value
			// is null
			// node.prev=null;
		} else {
			DoublyNode temp = head;
			while (temp.next != null) {

				temp = temp.next;
			}
			temp.next = node;
			node.next = null;
			node.prev = temp;
		}

	}

	// Insert Node after a item
	/*
	 * Three Cases need to handle 1.If Linked List is Empy 2. If we are adding in
	 * between linked list 3 If it is going to be last element of Linked List
	 */
	public void insertAfterANode(int data, int item) {
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
					temp.next.prev = node;
					temp.next = node;
					isFlag = true;

				}
				temp = temp.next;

			}
			if (!isFlag) {
				System.out.println("Item not found");
			}
		}

	}

	// Insert Node before a Item
	/*
	 * Three cases need to be handle Case 1:If Linked List is Empty Case 2:If
	 * LinkedList has only one Node and Case 3:If Linked List has multiple node and
	 * adding in between node
	 */

	public void insertNodeBeforeItem(int data, int item) {
		boolean itemFound = false;
		DoublyNode node = new DoublyNode(data);
		DoublyNode temp = head;

		if (head == null) {
			System.out.println("Empty Linked List");
		} else if (temp.data == item) {
			node.next = head;
			node.prev = null;
			head.prev = node;
			head = node;
			itemFound = true;

		} else {
			while (temp != null) {

				if (temp.data == item) {

					node.prev = temp.prev;
					node.next = temp;
					temp.prev.next = node;
					temp.prev = node;
					itemFound = true;

				}
				temp = temp.next;
			}

		}
		if (!itemFound) {
			System.out.println("Item not found ");
		}

	}

	// Delete node from begnning
	public void deleteFirstNode() {

		if (head == null) {

			System.out.println("Empty Linked List");
		} else {
			DoublyNode temp = head;
			head = head.next;
			head.prev = temp.prev;
		}

	}

	public void deleteNodeAtEnd() {
		boolean isDeleted=false;
		if (head == null) {

			System.out.println("Empty Linked List");
		}else if(head.next==null) {
			head=head.next;
			isDeleted= true;
		}
		else{
			DoublyNode temp = head;
			while (temp.next != null) {
				temp = temp.next;

			}
			temp.prev.next = temp.next;
			isDeleted=true;

		}
		
      if(isDeleted ) {
    	 System.out.println("Node delted "); 
      }
	}
	
	public void deleteGivenItem(int item) {
		boolean isDeleted=false;
		DoublyNode temp=head;
		
		if(head ==null ) {
			System.out.println("List is empty");
		} else if(temp.data==item) {
		   
			head=temp.next;
			head.prev=temp.prev;
			isDeleted=true;
			
		} else { 
			
			while(temp.next!=null) {
				
				if(temp.data==item) {
					temp.prev.next=temp.next;
					temp.next.prev=temp.prev;
					isDeleted=true;
					
				}
				temp=temp.next;
			}
			
			
		}
		if(!isDeleted) {
			
			System.out.println("Item not found on Linked List");
			
		}

		
	}
	
	//Delete Item at given position 
 public void deleteNoteAtGivenPosition(int position) {
   DoublyNode temp=head;
   boolean isDeleted=false;
   if(head == null) {
	   System.out.println("List is Empty");
   } else if(position<=0 ) {
	   System.out.println("Please inter valid position eg from 1 onwards ..");
   } else if(position==1){
	  temp=temp.next;
	  temp.prev=null;
	  head=temp;
	  isDeleted=true;
	} else {
	  try {
	  for(int i =0;temp!=null&&i<position-1;i++) {
		     temp=temp.next;
		}
		temp.prev.next=temp.next;
		temp.next=temp.prev;
		 isDeleted=true;
		 } catch(Exception e) {
				System.out.println("Position is out of range");
		 }
	  
  }
  

	 
		
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

	public static void main(String[] args) {

		DoublyLinkedList linkedList = new DoublyLinkedList();
		for (int i = 0; i < 5; i++) {
			linkedList.insertAtBeginning(i);
		}
		linkedList.traversal();
		/*System.out.println("Add node at end ....");
		linkedList.insertNodeAtEnd(99);
		linkedList.traversal();
		System.out.println("Insert Node after given Item");
		linkedList.insertAfterANode(100, 1);
		linkedList.traversal();
		System.out.println("Insert Node before given Item");
		linkedList.insertNodeBeforeItem(1000, 4);
		linkedList.traversal();
		System.out.println("Delete first Node ");
		linkedList.deleteFirstNode();
		linkedList.insertAtBeginning(100);
		linkedList.traversal();
		System.out.println("Delete last node ");
		linkedList.deleteNodeAtEnd();
		linkedList.traversal();
		System.out.println("Delete given item");
		linkedList.deleteGivenItem(4);
		linkedList.traversal();*/
		System.out.println("Delete item at given position");
		linkedList.deleteNoteAtGivenPosition(6);
		linkedList.traversal();

	}

}
