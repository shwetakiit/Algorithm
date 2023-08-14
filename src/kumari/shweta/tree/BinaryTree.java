/**
 * @author Shweta Kumari
 *2023-08-14
 */
package kumari.shweta.tree;

public class BinaryTree {

	public static boolean findNodeInBinaryTree(TreeNode root, int element) {
		if (root == null) {
			return false;
		}
		if (root.data == element) {
			return true;
		}
		// First it check in left side of || ,If element found it return true and If
		// doesn't found  then only It check right  part of ||
		return findNodeInBinaryTree(root.left, element) || findNodeInBinaryTree(root.right, element);

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

		boolean isElementFound = findNodeInBinaryTree(node, 25);
		if (isElementFound) {
			System.out.println("Element is found in binary tree");
		} else {
			System.out.println("Element is not found in binary tree");
		}
	}
}
