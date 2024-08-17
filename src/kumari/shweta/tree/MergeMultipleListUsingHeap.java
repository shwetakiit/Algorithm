/**
 * @author Shweta Kumari
 *2023-09-18
 */
package kumari.shweta.tree;



/* class ListNode{
	
	public int data;
	public ListNode next;
	public ListNode(int x) {
	   this.data=x;
	   this.next=null;
	}
	
}*/
public class MergeMultipleListUsingHeap {
	
	//Prepare Linked List 

	
	//Insert data at begining in linked list
	ListNode head;
	public ListNode insertAtBeginning(int element) {
		
	
		ListNode node= new ListNode(element);
		if(head==null) {
			head=node;
		} else {
		node.next=head;
		head=node;
		}
    return head;
	}
	
	public void traversal(ListNode head) {

		ListNode tNode = head;
		if(tNode==null) {
			System.out.println("Empty List \n");
		}
		while (tNode != null) {
			System.out.println(tNode.data);
			tNode = tNode.next;
		}
	}
	public static void main(String[] args) {
		
		MergeMultipleListUsingHeap obj = new MergeMultipleListUsingHeap();
		ListNode head1 = null;
		for (int i = 0; i <10; i=i+2) {
			head1=
			obj.insertAtBeginning(i);
		}
		
		/*
		 * obj.traversal(head1); System.out.println("Second list");
		 */
	    
	    MergeMultipleListUsingHeap obj2 = new MergeMultipleListUsingHeap();
		ListNode head2 = null;
		for (int i = 1; i <=7; i=i++) {
			head2=
			obj2.insertAtBeginning(i);
		}
		
		
	  //  obj2.traversal(head2);
		
		System.out.println(""+head1.toString()+""+head2.toString());
		
	}

}
