/**
 * @author Shweta Kumari
 *2023-08-13
 */
package kumari.shweta.tree;


import java.util.ArrayList;
import java.util.List;


/**
 * Tree traversal without using recursion ,without using stack to optimize 
 * space complexity O(1) using morris alogirthm
 * 
 * So optimize space complexity  we will apply do the link and break the link concept.
 * TC O(N) SC O(1)
 */


/*class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data=data;
		left=right=null;
	}
}*/
public class MorrisTraversal {

	public static List<Integer> morrisInorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		TreeNode current = root;
		while (current != null) {
			if (current.left == null) {
				result.add(current.data);
				current = current.right;
			} else {
				TreeNode temp = current.left;
				while (temp.right != null && temp.right != current) {
					temp = temp.right;
				}
				if (temp.right == null) { // If temp has no right child the do the link between temp and current because
											// if we do the inorder traversal after temp reach to last node where no
											// right child then It will take next node which is current in inOrder
											// traversal technique.

					// Create connection and go to the left.
					temp.right = current;
					current = current.left;

				} else if (temp.right == current) {// This situation comes if we do second time traversal after linking
													// done in first traversal.
					// Break the connection
					temp.right = null;
					result.add(current.data);
					current = current.right;
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {

		TreeNode node = new TreeNode(6);
		node.right = new TreeNode(8);
		node.right.right = new TreeNode(29);
		TreeNode leftChild = node.right.right.left = new TreeNode(20);
		TreeNode rightChild = node.right.right.right = new TreeNode(32);

		leftChild.left = new TreeNode(47);
		leftChild.right = new TreeNode(23);
		leftChild.left.left = new TreeNode(9);
		leftChild.left.left.right = new TreeNode(10);
		leftChild.right.right = new TreeNode(25);
		leftChild.left.right = new TreeNode(17);
		leftChild.left.right = new TreeNode(19);

		rightChild.left = new TreeNode(30);
		rightChild.right = new TreeNode(35);
		rightChild.right.left = new TreeNode(33);
		rightChild.right.right = new TreeNode(90);

		// BinarySearchTree.inOrderTraversal(node);

		// Morris inorder traversal
		List<Integer> result = morrisInorderTraversal(node);
		System.out.println("Morris inorder traversal");
		result.stream().forEach(i -> System.out.print(" " + i));
	 
	    
	
	
	}

}
