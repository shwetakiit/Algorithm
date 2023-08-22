/**
 * @author Shweta Kumari
 *2023-08-14
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTree {
	
	static int time=0;
	static Map<Integer,List<Integer>> nodeInOutTimeMap = new HashMap<>();

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
	
	/**
	 * Find path from root node to the searched element in Binary tree .
	 * Example search 25 in given Binary tree so path of 25 from root is  [6, 8, 29, 20, 23, 25]
	 * @param root
	 * @param element
	 * @param result
	 * @return
	 */
	public static boolean findPathOfSearchingElement(TreeNode root, int element, List<Integer> result) {

		if (root == null) {
			return false;
		}
		if (root.data == element) {
			result.add(root.data);
			return true;
		}
		boolean isFound = findPathOfSearchingElement(root.left, element, result)
				|| findPathOfSearchingElement(root.right, element, result);
		if (isFound) {
			result.add(root.data);
		}
		return isFound;
	}

	/**
	 * Find Least Common Ancestor of given two elements in Binary tree
	 * Example in given binary tree  LCA(47,35) --Output is 29, 29 is least common ancestor of 47 and 35.
	 * TC -->O(N) SC -O(H) H --> height of binary tree 
	 * @param args
	 */
	public static int findCommonAncestor(TreeNode root, int B, int C) {
		int result = -1;
		List<Integer> pathA = new ArrayList<>();
		List<Integer> pathB = new ArrayList<>();
		findPath(root, B, pathA);
		findPath(root, C, pathB);
		Collections.reverse(pathA);
		Collections.reverse(pathB);
		int size = 0;
		if (pathA.size() < pathB.size()) {
			size = pathA.size();
		} else {
			size = pathB.size();
		}
		for (int i = 0; i < size; i++) {
			if (pathA.get(i).equals(pathB.get(i))) {
				result = pathA.get(i);
			} else {
				break;
			}
		}
		return result;

	}
	
	
	  static boolean findPath(TreeNode root,int element,List<Integer> pathElements){
	        if(root==null){
	            return false;
	        }
	        if(root.data==element){
	            pathElements.add(root.data);
	            return true;
	        }
	        boolean isFound=findPath(root.left,element,pathElements)||findPath(root.right,element,pathElements);
	        if(isFound){
	            pathElements.add(root.data);
	        }
	        return isFound;
	    }
	
	  
	    /**
		 * Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.
         *Note 1 :- It is guaranteed that the nodes B and C exist.
         *Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
		 * Note3:- All node in BST are distinct 
		 * LCA(12,50) --> Out put is 15 
		 * TC --> O(H) , SC--> O(1)
		 * @param root
		 * @param B
		 * @param C
		 * @return
		 */
		public static int findCommonAncestorInBST(TreeNode root,int B,int C) {
			
			TreeNode current = root;
			while(true) {
				
				if(B>current.data && C>current.data) {//A and B are greater than root node go right of BST
					
					current = current.right;
				} else if(B<current.data && C<current.data) {//A and B are less than root node got left of BST 
					
					current = current.left;
				} else {// If A is greater than root but B is less than root and vice versa
					
					break;
				}
			}
			return current.data;
			
		}
		
		/**
		 * Find common ancestor in Binary tree with optimized approach using 
		 * In-Time and Out-Time concept 
		 * TC -> O(N+Q.H)   SC-> O(N) 
		 * @param args
		 */
		
		public static int findCommonAncestorOfBT(TreeNode root, int x, int y) {

			// Calculate InTime and OutTime for each node of tree.
			calculateInTimeOutTime(root);

			TreeNode current = root;
			while (true) {

				boolean currentLeftX = isAncestor(current.left.data, x);
				boolean currentLeftY = isAncestor(current.left.data, y);

				boolean currentRightX = isAncestor(current.right.data, x);
				boolean currentRightY = isAncestor(current.right.data, y);
				if (currentLeftX && currentLeftY) {
					current = current.left;

				} else if (currentRightX && currentRightY) {
					current = current.right;
				} else {
					break;
				}

			}

			return current.data;

		}

		//Pre-processing to calculate inTime and outTime for each node in tree.
		public static void calculateInTimeOutTime(TreeNode root) {

			List<Integer> inOutTime = new ArrayList<>();
			if (root == null) {
				return;
			}
			int in_Time = time++;
			inOutTime.add(in_Time);
			nodeInOutTimeMap.put(root.data, inOutTime);
			calculateInTimeOutTime(root.left);
			calculateInTimeOutTime(root.right);
			int out_time = time++;
			if (nodeInOutTimeMap.containsKey(root.data)) {
				List<Integer> inoutList = nodeInOutTimeMap.get(root.data);
				inoutList.add(out_time);
			}

		}

		static boolean isAncestor(int x, int y) {

			int intTimeX = nodeInOutTimeMap.get(x).get(0);
			int inTimeY = nodeInOutTimeMap.get(y).get(0);
			int outTimeX = nodeInOutTimeMap.get(x).get(1);
			int outTimeY = nodeInOutTimeMap.get(y).get(1);
			if ((intTimeX < inTimeY) && (outTimeX > outTimeY)) {
				return true;
			}
			return false;

		}
		/**
		 * Invert binary tree --> Convert  binary tree in mirror image form
		 * @param root
		 * @return
		 */
		public static void invertBinaryTree(Node root) {
			Node result = invert(root);
			System.out.println("\nInverted binary tree");
			TreeTraversal.inorder(result);

		}

		/**
		 * @param root
		 * @return
		 */
		private static Node invert(Node root) {

			if (root == null) {
				return null;
			}
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			root.left = invert(root.left);
			root.right = invert(root.right);
			return root;
		}

		/**
		 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
		 * such that adding up all the values along the path equals the given sum.
		 * Example in order of binary tree 7,11,2,4,5,13,8,4,1 K=22 Out put is true
		 * because path from root node to leaf node is [5,4,11,2]
		 * TC ->O(N) SC->O(H)
		 * @param args
		 */
		public static boolean checkPathSum(Node root, int element) {

			if (root == null) { // This base case for node which is null(For example left of node 4 is null so
								// left of node 4 will return simply false ) or root node it self null
				return false;
			}
			if (root.left == null && root.right == null) { // Left node which has left and right child null
				return (root.data == element);
			}

			return checkPathSum(root.left, element - root.data) || checkPathSum(root.right, element - root.data);

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
		
		List<Integer> result = new ArrayList<>();
		findPathOfSearchingElement(node, 25, result);
		// Reverse the list to get path of searched element from root Node
		Collections.reverse(result);
		System.out.println("Path of searched element is  " + result);
		// Find common ancestor of given two node in Binary tree
		int commonAncestor = findCommonAncestor(node, 47, 35);
		System.out.println("Common ancestor is " + commonAncestor);
		// Find common ancestor of given two node in Binary search tree

		TreeNode root = new TreeNode(11);
		root.left = new TreeNode(8);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(9);
		root.left.left.left = new TreeNode(-1);
		root.right.left = new TreeNode(13);
		TreeNode secondRight = root.right.right = new TreeNode(19);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(14);
		secondRight.right = new TreeNode(25);
		secondRight.right.right = new TreeNode(50);

		int bstCommonAncestor = findCommonAncestorInBST(root, 12, 50);
		System.out.println("Least common ancestor in BST is " + bstCommonAncestor);
	    
		//Find common ancestor of Binary tree using in_time and out_time approach
		
		TreeNode node2= new TreeNode(1);
		node2.left= new TreeNode(2);
		node2.right = new TreeNode(3);
		node2.left.left= new TreeNode(4);
		node2.right.left= new TreeNode(5);
		node2.right.left.left= new TreeNode(7);
		node2.right.right= new TreeNode(6);
		node2.right.right.left= new TreeNode(8);
		node2.right.right.right=new TreeNode(9);
		
	    int btCommonAncestor= findCommonAncestorOfBT(node2,6,7);
	    System.out.println("Least common ancestor in BT using intime and outtime approach "+btCommonAncestor);
	    
		// Invert Binary tree
		Node node3 = new Node(1);
		node3.left = new Node(2);
		node3.right = new Node(3);
		node3.left.left = new Node(4);
		node3.left.right = new Node(5);
		node3.right.right = new Node(6);
		node3.right.right.left = new Node(7);
		node3.right.right.right = new Node(8);
		TreeTraversal.inorder(node3);
		invertBinaryTree(node3);
		
		// is path sum from root node to leaf node is equal to given element ?
		
		boolean isPathVailable= checkPathSum(node3, 17);
	   if(isPathVailable) {
		   System.out.println("\nPath is available from root node to leaf node of sum equal to given element");
	   }else {
		   System.out.println("\nPath is not available from root node to leaf node of sum equal to given element");
	   }
		
	}
}
