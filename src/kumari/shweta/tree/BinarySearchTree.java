/**
 * @author Shweta Kumari
 *2023-07-24
 */
package kumari.shweta.tree;

import java.util.Arrays;
import java.util.List;

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
	 boolean isBST;
	TreeNode prev=null;
	TreeNode current=null;

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

	/**
	 * Delete node from Binary search tree
	 * 
	 * @param root
	 */
	public static TreeNode deleteNodeFromBST(TreeNode node, int element) {

		if (node == null) { // If root node is null
			return null;
		}

		if (node.data == element) { // If targeted element is root node
			TreeNode sucessorNode = deleteNodeHasBothChild(node);
			return sucessorNode;

		} else {
			// Find parent node of node of targeted node
			TreeNode parentNode = findNodeInBST(node, element);
			TreeNode temp;

			// Find targeted node which we have to delete from parent node
			if ((parentNode.left != null) && parentNode.left.data == element) {
				temp = parentNode.left;

			} else if ((parentNode.right != null) && parentNode.right.data == element) {
				temp = parentNode.right;
			} else {
				temp = parentNode;
			}

			// Now delete targeted node
			if (temp.left == null && temp.right == null) { // If targeted node is leaf node
				if (parentNode.left == temp) {
					parentNode.left = null;
				} else {
					parentNode.right = null;
				}
			} else if (temp.left == null && temp.right != null) { // If targeted node has right child but no left child

				if (parentNode.left == temp) {
					parentNode.left = temp.right;
				} else {
					parentNode.right = temp.right;
				}
			} else if (temp.left != null && temp.right == null) {// If targeted node has left child but on right child
				if (parentNode.left == temp) {
					parentNode.left = temp.left;
				} else {
					parentNode.right = temp.left;
				}
			} else { // If targeted node has both left and right child and that is not root node
				TreeNode successor = deleteNodeHasBothChild(temp);
				parentNode.right = successor;
				return parentNode;
			}
			return node;
		}
	}

	/**
	 * Delete node which has both child
	 */
	public static TreeNode deleteNodeHasBothChild(TreeNode temp) {
		TreeNode successorParent = temp; // temp is target node , which will be deleted
		TreeNode successor = temp.left;
		// Find max element of left subtree of targeted node
		while (successor.right != null) {
			successorParent = successor;
			successor = successor.right;
		}
		if (successorParent != temp) {
			successorParent.right = successor.left; // We know that right child of successor is null every time so only
													// we have to think about left child
			successor.left = temp.left;
		}
		successor.right = temp.right;
		return successor;

	}

	// Return parent node of node which we want to delete
	public static TreeNode findNodeInBST(TreeNode node, int element) {

		TreeNode temp = node;
		TreeNode parentNode = null;
		while (temp != null) {
			if (temp.data != element) { // Parent Node can't me targeted node
				parentNode = temp;
			}
			if (temp.data == element) {
				return parentNode;
			} else if (temp.data < element) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return parentNode;
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print("\t" + root.data);
		inOrderTraversal(root.right);
	}
	/**
	 * Validate binary search tree
	 * @param root
	 */
	public  void  validateBST(TreeNode root) {
	   isBST=true;
       checkBST(root);
       if(isBST) {
    	   System.out.println("Tree is binary search tree");
       } else {
    	   System.out.println("Tree is not binary search tree");
       }
		
		
	}
	public void checkBST(TreeNode A){ //Inorder traversal LNR
		 if(A==null){
		     return ;
		 }
		  checkBST(A.left);//Left Node
		  prev=current;
		  current=A;
		  if(prev!=null && current!=null && prev.data>=current.data){
		      isBST=false;
		  }
		  checkBST(A.right);  //Right Node

		}

		/**Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
         *Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
		 * 
		 * @param args
		 */
		private static TreeNode buildBST(List<Integer> sortedList) {
			TreeNode rootNode = createHeightBalancedTree(sortedList, 0, sortedList.size() - 1);
			return rootNode;

		}

		private static TreeNode createHeightBalancedTree(List<Integer> sortedList, int startIndex, int endIndex) {

			if (startIndex > endIndex) { // Base case
				return null;
			}
			if (startIndex == endIndex) { // If only one node is available
				TreeNode root = new TreeNode(sortedList.get(startIndex));
				return root;
			}
			int mid = (startIndex + endIndex) / 2;

			TreeNode root = new TreeNode(sortedList.get(mid));
			root.left = createHeightBalancedTree(sortedList, startIndex, mid - 1);
			root.right = createHeightBalancedTree(sortedList, mid + 1, endIndex);
			return root;
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

		// Delete Node
		TreeNode node = new TreeNode(8);
		node.left = new TreeNode(4);
		node.right = new TreeNode(13);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(7);
		node.left.right.left = new TreeNode(6);

		node.right = new TreeNode(13);
		node.right.left = new TreeNode(10);
		node.right.left.left = new TreeNode(9);
		node.right.left.right = new TreeNode(11);
		node.right.right = new TreeNode(15);
		node.right.right.right = new TreeNode(17);

		System.out.println("\n Before deletion of node in BST");
		inOrderTraversal(node);
		TreeNode resuNode = deleteNodeFromBST(node, 13);
		System.out.println("\n After deletion of node from BST tree in inorder is ");
		inOrderTraversal(resuNode);
		
		//Validate BST tree 
		 BinarySearchTree obj = new BinarySearchTree();
		 obj.validateBST(node);
		 TreeNode node1= new TreeNode(1);
		 node1.left = new TreeNode(2);
		 node1.right = new TreeNode(3);
		 obj.validateBST(node1);
		 
		 //Created Height Balanced Tree 
		 
		 List<Integer> sortedList = Arrays.asList(1,2,3,4,5);
		 TreeNode rootNode= buildBST(sortedList);
		 System.out.println("Root node if created height balanced tree is "+rootNode.data);
	}

}
