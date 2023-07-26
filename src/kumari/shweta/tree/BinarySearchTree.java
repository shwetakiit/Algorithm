/**
 * @author Shweta Kumari
 *2023-07-24
 */
package kumari.shweta.tree;

/*class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data=data;
		left=right=null;
	}
}*/
public class BinarySearchTree {

	/**
	 * Find given element in Binary search tree , if element found return 1 else
	 * return 0
	 * 
	 * @param node
	 * @param element
	 * @return
	 */
	public static int findNodeInBinaryTree(TreeNode node, int element) {
		TreeNode temp = node;
		while (temp != null) {
			if (temp.data == element) {
				return 1;
			} else if (temp.data < element) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return 0;
	}

	/**
	 * Insert node in binary search tree
	 * 
	 * @param args
	 */
	public static void insertNodeInBinarySearchTree(TreeNode node, int element) {
		TreeNode temp = node;
		TreeNode parentNode = null; // Parent node for root node is NULL;
		while (temp != null) {
			parentNode = temp;
			if (temp.data == element) { // If Node is already exist in given BST
				return;
			} else if (temp.data < element) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		if (parentNode == null) {
			node = new TreeNode(element);
		} else if (parentNode.data < element) {
			parentNode.right = new TreeNode(element);
		} else {
			parentNode.left = new TreeNode(element);
		}

		// Traverse BST after inserting node in Binary tree
		inOrderTraversal(node);

	}

	public static void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print("\t" + root.data);
		inOrderTraversal(root.right);
	}
	public static void main(String[] args) {

		// Create binary search tree
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(13);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(15);
		root.right.right.right = new TreeNode(17);

		int found = findNodeInBinaryTree(root, 13);
		if (found == 1) {
			System.out.println("Given element is found in BST");

		} else {
			System.out.println("Given element is not found in BST");
		}

		// Insert node in Binary search tree
		insertNodeInBinarySearchTree(root, 14);
	}

}
