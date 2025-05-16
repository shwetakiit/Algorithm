/**
 * @author Shweta Kumari
 *2025-05-13
 */
package kumari.shweta.tree;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;



/*
Problem Description
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.
Problem Constraints
1 <= total number of elements in given linked lists <= 100000
Input Format
The first and only argument is a list containing N head pointers.
Output Format
Return a pointer to the head of the sorted linked list after merging all the given linked lists.
Example Input
Input 1:
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:
10 -> 12
13
5 -> 6
Example Output
Output 1:
 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2:
 5 -> 6 -> 10 -> 12 ->13
Example Explanation
Explanation 1:
The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
Explanation 2:
The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
*/

class ListNode{
	
	int data ;
	ListNode next;
	ListNode(int data){
		this.data=data;
		next=null;
	}
	
}


class NodeComparator implements Comparator<ListNode>{

	@Override
	public int compare(ListNode node1, ListNode node2) {
	    return node1.data-node2.data;
	}
	
	
	
	
}

public class MergeKsortedList {
	

	/**
	 * @param list
	 */
	private static ListNode mergeKsortedList(ArrayList<ListNode> list) {
	    
   PriorityQueue<ListNode> pq= new PriorityQueue<ListNode>( new NodeComparator());
     for(int i =0;i<list.size();i++) {
    	 pq.add(list.get(i));
     }
     
  
     
     ListNode head=pq.peek();
     ListNode prev=null;
     
     while(!pq.isEmpty()) {
    	 ListNode current=pq.poll();
    	 if(current.next!=null) {
    		 pq.add(current.next);
    	 }
    	 if(prev!=null) {
    		 prev.next=current;
    		 prev=prev.next;
    	 } else {
    		 prev=current;
    	 }
     }
     return head;
		
	}

	
	public static void main(String[] args) {
		
		ArrayList<ListNode> list= new ArrayList<>();
		
		//1 -> 10 -> 20
		//4 -> 11 -> 13
		//3 -> 8 -> 9
		
		ListNode root1= new ListNode(1);
		root1.next=new ListNode(10);
		root1.next.next=new ListNode(20);
		
		ListNode root2= new ListNode(4);
		root2.next=new ListNode(11);
		root2.next.next=new ListNode(13);
		
		ListNode root3=new ListNode(3);
		root3.next=new ListNode(8);
		root3.next.next= new ListNode(9);
		
		list.add(root2);
        list.add(root1);
		list.add(root3);
		
		ListNode head=	mergeKsortedList(list);
		while(head!=null) {
			System.out.print(head.data+"\t");
			head=head.next;
		}

		
		
		
		
		
	}

	
}
