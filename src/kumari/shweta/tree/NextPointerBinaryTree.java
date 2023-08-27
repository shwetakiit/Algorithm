/**
 * @author Shweta Kumari
 * 2023-08-27
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.List;

class TreeLinkedNode {

	TreeLinkedNode left, right, next;
	int data;

	public TreeLinkedNode(int data) {
		this.data = data;
	}

}

public class NextPointerBinaryTree {

	public static List<Integer> connectNode(TreeLinkedNode root) {

		TreeLinkedNode dummy = new TreeLinkedNode(-1);
		TreeLinkedNode temp;
		temp = dummy;
		List<Integer> connectedList = new ArrayList<>();

		while (root != null) {
			if (root.left != null) {
				temp.next = root.left;
				temp = temp.next;
				//System.out.println("Next element is "+temp.data);
				connectedList.add(temp.data);
			}
			if (root.right != null) {
				temp.next = root.right;
				temp = temp.next;
				//System.out.println("Next element is "+temp.data);
				connectedList.add(temp.data);
			}
			root = root.next;
			if (root == null) {
				root = dummy.next;
				dummy.next = null;
				temp = dummy;
			}
		}
		return connectedList;
	}

	public static void main(String[] args) {

		TreeLinkedNode node = new TreeLinkedNode(10);
		node.left = new TreeLinkedNode(5);
		node.right = new TreeLinkedNode(20);
		node.left.left = new TreeLinkedNode(2);
		TreeLinkedNode temp = node.left.right = new TreeLinkedNode(7);
		TreeLinkedNode temp1 = node.right.right = new TreeLinkedNode(22);
		node.left.left.left = new TreeLinkedNode(8);
		temp.left = new TreeLinkedNode(6);
		temp.left.left = new TreeLinkedNode(100);
		temp1.left = new TreeLinkedNode(21);
		temp1.right = new TreeLinkedNode(50);
		temp1.left.right = new TreeLinkedNode(200);
	    List<Integer> resList =connectNode(node);
	    System.out.println("Result of connected node is "+resList);
	}
}
