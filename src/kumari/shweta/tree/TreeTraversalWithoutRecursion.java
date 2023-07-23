package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

class Pair{
	public int level;
	public TreeNode treeNode;
	public Pair(TreeNode treeNode,int level) {
		this.level = level;
		this.treeNode = treeNode;
	}
}
public class TreeTraversalWithoutRecursion {
	
	 public static int isBalanced =1; //Let's assume tree is balanced tree
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
	//Approach1
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
   //Approach 2
	static List<Integer> preorderIterativeTraversal(TreeNode A){
		
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = A;
		while(!stack.isEmpty() || currentNode!=null  ) {
			while(currentNode!=null) {
		     	result.add(currentNode.data);
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			TreeNode popNode = stack.pop();
			currentNode = popNode.right;
			
		}
		return result;
	}
	
	
	/*
	 * InOrder traversal without using recursion
	 */
     //Approach1
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
	
   //Approach 2
	static List<Integer> inorderIterativeTraversal(TreeNode A){
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = A; //Intialize current node with root Node
		while(!stack.isEmpty()|| currentNode!=null) {
			while(currentNode!=null) {
				stack.push(currentNode);
				currentNode=currentNode.left;
			}
			TreeNode popNode=stack.pop();
			result.add(popNode.data);
			currentNode=popNode.right;
		}
		return result;
	}
	
	//Level Order Traversal
	public static List<List<Integer>> levelOrderTraversal(TreeNode A) {

		Queue<TreeNode> queue = new LinkedList<>();
		// Create 2D array list to store all elements of each level
		List<List<Integer>> result = new ArrayList<>();
		// Add root node in queue
		queue.offer(A);
		while (!queue.isEmpty()) {

			List<Integer> levelNote = new ArrayList<>();
			int queueSize = queue.size();
			/**
			 *  Remove node from queue add in result list and add left and right node of removed element in queue
			 */
			for (int i = 0; i < queueSize; i++) {
				TreeNode removedNode = queue.poll();
				levelNote.add(removedNode.data);
				if (removedNode.left != null) {
					queue.offer(removedNode.left);
				}
				if (removedNode.right != null) {
					queue.offer(removedNode.right);
				}
			}
			result.add(levelNote);
		}
		return result;
	}
	/*Find right view of binary tree ,for example given level order 1,2,3,4,5,6,7,8
	 * Out put 1,3,7,8
	 */
	public static ArrayList<Integer> rightViewOfBinaryTree(TreeNode A) {

		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		queue.offer(A);
		while (!queue.isEmpty()) {

			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				TreeNode removedNode = queue.poll();
				if (i == queueSize - 1) {
					result.add(removedNode.data);
				}
				if (removedNode.left != null) {
					queue.offer(removedNode.left);
				}
				if (removedNode.right != null) {
					queue.offer(removedNode.right);
				}
			}
		}
		return result;
	}

	/*Find left view of binary tree ,for example given level order 1,2,3,4,5,6,7,8
	 * Out put 1,3,7,8
	 */
	 public static ArrayList<Integer> leftViewOfBinaryTree(TreeNode A) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        ArrayList<Integer> result= new ArrayList<>();
	        queue.offer(A); 
	        while(!queue.isEmpty()){
	           
	            int queueSize = queue.size();
	            for(int i =0;i<queueSize;i++){
	                TreeNode removedNode = queue.poll();
	                if(i==0){
	                result.add(removedNode.data);
	                }
	                if(removedNode.left!=null){
	                    queue.offer(removedNode.left);
	                } 
	                if(removedNode.right!=null){
	                    queue.offer(removedNode.right);
	                }
	            }

	        }
	       return result;
	 }
	 /**
	  * Find vertical order traversal of binary tree 
	  * Input given preorder --> 1,2,5,6,14,15,16,8,3,10,9,7,13,4,12,11
	  * Out put  -- 6 , 5 14, 2 9 15 , 1 8 10 12 16, 3 7 4 , 13 11
	  */
	 public static List<List<Integer>> verticalOrderTraversal(TreeNode A){
		 List<List<Integer>> result = new ArrayList<>();
		 Queue<Pair> queue = new LinkedList<>();
		 Pair rooPair = new Pair(A,0);
		 Map<Integer, List<Integer>> map = new HashMap<>();
		 int min=0 ,max=0;
		 queue.offer(rooPair);
		 while(!queue.isEmpty()) {
			 
			 //Remove root node from queue
			 Pair removePair = queue.poll();
			 
			 // Map keep record for printing data of vertical traversal -Key- level value --> list of data at same level
			 if(map.containsKey(removePair.level)) {
				List<Integer> list  = map.get(removePair.level);
				list.add(removePair.treeNode.data);
			 } else {
				List<Integer> list = new  ArrayList<>();
				list.add(removePair.treeNode.data);
				map.put(removePair.level, list);
			 }
			
			 min=Math.min(min,removePair.level);
			 max=Math.max(max,removePair.level);
			 
			 //Add left Node in Queue 
			 if(removePair.treeNode.left!=null) {
				 Pair leftNode = new Pair(removePair.treeNode.left,removePair.level-1);
				 queue.offer(leftNode);
			 }
			 //Add right Node in Queue 
			 if(removePair.treeNode.right!=null) {
				 Pair rightNode = new Pair(removePair.treeNode.right,removePair.level+1);
				 queue.offer(rightNode);
			 }
			
		 }
		 for(int i=min;i<=max;i++) {
			List<Integer> list = map.get(i);
			result.add(list);
			
		 }
		 
		 return result;
	 }
	 /**
	  * Find top view of binary tree 
	  * Input given preorder --> 1,2,5,6,14,15,16,8,3,10,9,7,13,4,12,11
	  * Output  -- 6,5,2,1,3,13,20
	  * @param A
	  * @return
	  */
	 public static List<Integer> topViewOfBinaryTree(TreeNode A){
		 List<Integer> result = new ArrayList<>();
		 Queue<Pair> queue = new LinkedList<>();
		 Pair rooPair = new Pair(A,0);
		 Map<Integer, List<Integer>> map = new HashMap<>();
		 int min=0 ,max=0;
		 queue.offer(rooPair);
		 while(!queue.isEmpty()) {
			 
			 //Remove root node from queue
			 Pair removePair = queue.poll();
			 
			 // Map keep record for printing data of vertical traversal -Key- level value --> list of data at same level
			 if(map.containsKey(removePair.level)) {
				List<Integer> list  = map.get(removePair.level);
				list.add(removePair.treeNode.data);
			 } else {
				List<Integer> list = new  ArrayList<>();
				list.add(removePair.treeNode.data);
				map.put(removePair.level, list);
			 }
			
			 min=Math.min(min,removePair.level);
			 max=Math.max(max,removePair.level);
			 
			 //Add left Node in Queue 
			 if(removePair.treeNode.left!=null) {
				 Pair leftNode = new Pair(removePair.treeNode.left,removePair.level-1);
				 queue.offer(leftNode);
			 }
			 //Add right Node in Queue 
			 if(removePair.treeNode.right!=null) {
				 Pair rightNode = new Pair(removePair.treeNode.right,removePair.level+1);
				 queue.offer(rightNode);
			 }
			
		 }
		 //Find first element of list which has stored in map of key as level[-3,-2,-1,0,1,2] and value is list of element at same level
		 for(int i=min;i<=max;i++) {
			List<Integer> list = map.get(i);
			result.add(list.get(0));
			
		 }
		 
		 return result;
	 }
	 
	 public static List<Integer> bottomViewOfBinaryTree(TreeNode A){
		 List<Integer> result = new ArrayList<>();
		 Queue<Pair> queue = new LinkedList<>();
		 Pair rooPair = new Pair(A,0);
		 Map<Integer, List<Integer>> map = new HashMap<>();
		 int min=0 ,max=0;
		 queue.offer(rooPair);
		 while(!queue.isEmpty()) {
			 
			 //Remove root node from queue
			 Pair removePair = queue.poll();
			 
			 // Map keep record for printing data of vertical traversal -Key- level value --> list of data at same level
			 if(map.containsKey(removePair.level)) {
				List<Integer> list  = map.get(removePair.level);
				list.add(removePair.treeNode.data);
			 } else {
				List<Integer> list = new  ArrayList<>();
				list.add(removePair.treeNode.data);
				map.put(removePair.level, list);
			 }
			
			 min=Math.min(min,removePair.level);
			 max=Math.max(max,removePair.level);
			 
			 //Add left Node in Queue 
			 if(removePair.treeNode.left!=null) {
				 Pair leftNode = new Pair(removePair.treeNode.left,removePair.level-1);
				 queue.offer(leftNode);
			 }
			 //Add right Node in Queue 
			 if(removePair.treeNode.right!=null) {
				 Pair rightNode = new Pair(removePair.treeNode.right,removePair.level+1);
				 queue.offer(rightNode);
			 }
			
		 }
		 /**
		  * Find last element of list which has stored in map of key as level[-3,-2,-1,0,1,2] and value is list of
		  * element at same level for bottom view .
		  */
		 for(int i=min;i<=max;i++) {
			List<Integer> list = map.get(i);
			result.add(list.get(list.size()-1));
			
		 }
		 
		 return result;
	 }
	 /**
	  * Check tree is balanced  tree or not ,If tree is balanced tree return 1 otherwise return 0.
	  * @param args
	  */
	 public static int checkBalanceTree(TreeNode node) {
	    heightOfBinaryTree(node);
		 return isBalanced;
	 }
	 
	/**
	 * @param node
	 */
	private static int heightOfBinaryTree(TreeNode node) {
		if(node== null) {
			return -1;
		}
		int lh= heightOfBinaryTree(node.left);
		int rh= heightOfBinaryTree(node.right);
		if(Math.abs(lh-rh)>1) {
			isBalanced=0;
		}
		return Math.max(lh, rh)+1;
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
		List<Integer> preOrderList = preorderIterativeTraversal(node);
		System.out.println("PreOrder Iterative"+preOrder);
		List<Integer> inOrder = inorderTraversal(node);
		System.out.println("InOrder " + inOrder);
		List<Integer> inOrderList = inorderIterativeTraversal(node);
		System.out.println("InOrder Iterative"+inOrder);
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
		//Level Order traversal 
		List<List<Integer>> levelOrder = levelOrderTraversal(root);
		System.out.println("Level order traversal"+levelOrder);
		
		//Right view of binary tree
		List<Integer> rightView = rightViewOfBinaryTree(root);
		System.out.println("Right view of binary tree is "+rightView);
		//Left view of binary tree
		List<Integer> leftView = leftViewOfBinaryTree(root);
		System.out.println("Left view of binary tree is "+leftView);
		
		//Vertical traversal of Binary tree
		TreeNode node2 = new TreeNode(1);
		node2.left = new TreeNode(2);
		node2.left.left = new TreeNode(5);
        node2.left.left.left = new TreeNode(6);
	    node2.left.left.left.right = new TreeNode(14);
	    node2.left.left.left.right.right = new TreeNode(15);
	    node2.left.left.left.right.right.right = new TreeNode(16);
	    node2.left.right = new TreeNode(8);
	     
	     node2.right= new TreeNode(3);
	     node2.right.left = new TreeNode(10);
	     node2.right.left.left = new TreeNode(9);
	     node2.right.left.right= new TreeNode(7);
	     
	     node2.right.right = new TreeNode(13);
	     node2.right.right.left = new TreeNode(4);
	     node2.right.right.left.left= new TreeNode(12);
	     node2.right.right.left.right = new TreeNode(11);	
		 List<List<Integer>> verticalTrList = verticalOrderTraversal(node2);
		 System.out.println("Vertical order trvaersal "+verticalTrList);
		 
		 //Top view of binary tree
		 List<Integer> topViewList = topViewOfBinaryTree(node2);
		 System.out.println("Top view elements of binary tree"+topViewList);
		 
		 //Bottom view of binary tree
		 List<Integer> bottomViewList = bottomViewOfBinaryTree(node2);
		 System.out.println("Bottom view elements of binary tree"+bottomViewList);
		
		 //Check tree is balanced tree or not		
		 int isBalancedTree= checkBalanceTree(node2);
		 if(isBalancedTree==1) {
			 System.out.println("Tree is balanced tree");
		 } else {
			 System.out.println("Tree is not balanced tree");
		 }
		
	  }
}
