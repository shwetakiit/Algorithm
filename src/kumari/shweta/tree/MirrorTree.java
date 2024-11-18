/**
 *@author Shweta Kumari
 *2024-11-18
 */
package kumari.shweta.tree;

public class MirrorTree {
	public static Node mirrorOfTree(Node root) {
		if (root == null) {
			return null;

		}

		Node leftNode = mirrorOfTree(root.left);
		Node rightNode = mirrorOfTree(root.right);
		root.left = rightNode;
		root.right = leftNode;
		return root;
	}

	private static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		System.out.print(" " + root.data);
		inorderTraversal(root.right);
	}

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		// Original tree in-order traversal
		inorderTraversal(root);
		System.out.println();
		System.out.println("Mirror tree");
		Node mirroedTree = mirrorOfTree(root);
		inorderTraversal(mirroedTree);

	}

}
