package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shweta Kumari 
 * 2023-02-25
 */

class TreeNode {
	int data;
	TreeNode left, right;

	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}

	public boolean isLeaf() {
		if (left == null) {
			if (right == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}
}

public class TreeTraversalWithoutRecursion {

	static int sum(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return sum(node.left) + sum(node.right) + node.data;
		}
	}

	/*
	 * Sum of All nodes value of Binary tree
	 */
	static int sumOfAllNode(TreeNode node) {
		return sum(node);
	}

	/*
	 * Calculate total size of Binary tree ->Size of left sub tree+ Size of right
	 * subtree+1
	 */
	static int sizeOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftSubTree = sizeOfTree(root.left);
			int rightSubTree = sizeOfTree(root.right);
			return leftSubTree + rightSubTree + 1;
		}
	}

	/*
	 * Height of Binary tree --> Maximum length between root and deepest node of
	 * binary tree
	 */
	static int heightOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lh = heightOfTree(root.left);
			int rh = heightOfTree(root.right);
			return Math.max(lh, rh) + 1;
		}
	}

	/*
	 * Post order traversal of Binary tree --> Left Right Node
	 */
	public static List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode current = stack.peek();
			if (current.isLeaf()) {
				TreeNode node = stack.pop();
				result.add(node.data);
			} else {
				if (current.right != null) {
					stack.push(current.right);
					current.right = null;
				}
				if (current.left != null) {
					stack.push(current.left);
					current.left = null;
				}
			}
		}
		return result;
	}

	/*
	 * Preorder Traversal without using recusrion --> Node,Left,Right
	 */
	static List<Integer> preorderTraversal(TreeNode A) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack();
		stack.push(A);
		while (!stack.isEmpty()) {
			TreeNode currentNode = stack.pop();
			result.add(currentNode.data);
			if (currentNode.right != null) {
				stack.push(currentNode.right);
			}
			if (currentNode.left != null) {
				stack.push(currentNode.left);
			}

		}
		return result;
	}

	/*
	 * InOrder traversal without using recursion
	 */
	static List<Integer> inorderTraversal(TreeNode A) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = A;
		while (!stack.isEmpty() || currentNode != null) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				TreeNode node = stack.pop();
				result.add(node.data);
				currentNode = node.right;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(7);
		node.left = new TreeNode(8);
		node.right = new TreeNode(11);
		node.left.left = new TreeNode(9);
		node.left.right = new TreeNode(15);
		node.left.right.left = new TreeNode(19);
		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(16);
		node.right.right.left = new TreeNode(20);
		node.right.right.right = new TreeNode(17);
		List<Integer> preOrder = preorderTraversal(node);
		System.out.println("PreOrder " + preOrder);
		List<Integer> inOrder = inorderTraversal(node);
		System.out.println("InOrder " + inOrder);
		List<Integer> resuList = postOrderTraversal(node);
		System.out.println("Post order " + resuList);

		// System.out.println("height of first tree"+heightOfTree(node));
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println("Height of tree is " + heightOfTree(root));
		System.out.println("Size of binary tree is " + sizeOfTree(root));
		System.out.println("Sum of all nodes of Binary tree is " + sumOfAllNode(root));
	}

}
