/**
 * 
 */
package kumari.shweta.LinkedList;

import java.util.HashSet;

import com.sun.source.tree.WhileLoopTree;

/**
 * @author Shweta Kumari
 * @Email id shwetakumarikiit0729@gmail.com
 *
 */

class Node1 {

	int data;
	Node1 next;

	Node1(int data) {
		this.data = data;
		next = null;
	}
}

public class InterSectionPointOfLinkedList {

	public void print(Node1 Node1) {

		while (Node1 != null) {
			System.out.println(Node1.data);
			Node1 = Node1.next;
		}
	}

	public void findPointOfIntersection(Node1 Node11, Node1 Node12) {

		HashSet<Node1> nodelist = new HashSet<Node1>();
		while (Node11 != null) {
			nodelist.add(Node11);
			Node11 = Node11.next;
		}
		while (Node12 != null) {
			if (nodelist.contains(Node12)) {
				System.out.println("Point of intersection at " + Node12.data);

				break;
			}
			Node12 = Node12.next;

		}
	}

	public static int findPointOfIntersectionSecond(Node1 Node11, Node1 Node12) {
		int pointofIntersection = 0;
		while (Node11 != null) {

			Node1 secondNode = Node12;
			while (secondNode != null) {
				if (secondNode.data == Node11.data) {

					pointofIntersection = secondNode.data;

					return secondNode.data;

				} else {
					secondNode = secondNode.next;
				}
			}

			Node11 = Node11.next;
		}
		return pointofIntersection;
	}

	public static void main(String[] args) {
		InterSectionPointOfLinkedList linkedList = new InterSectionPointOfLinkedList();
		Node1 Node11 = new Node1(3);
		Node11.next = new Node1(6);
		Node11.next.next = new Node1(9);
		Node11.next.next.next = new Node1(15);
		Node11.next.next.next.next = new Node1(30);
		Node1 Node12 = new Node1(10);
		Node12.next = Node11.next.next.next;
		Node12.next.next = Node11.next.next.next.next;

		System.out.println("Node11 list elements are ");
		linkedList.print(Node11);
		System.out.println("Node12 list elements are ");
		linkedList.print(Node12);
		linkedList.findPointOfIntersection(Node11, Node12);
		int intesrNode1 = InterSectionPointOfLinkedList.findPointOfIntersectionSecond(Node11, Node12);
		System.out.println("Point of intersection is " + intesrNode1);
	}

}
