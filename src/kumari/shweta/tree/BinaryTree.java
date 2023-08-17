/**
 * @author Shweta Kumari
 *2023-08-14
 */
package kumari.shweta.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		// Find common ancestor of given two node
		int commonAncestor = findCommonAncestor(node, 47, 35);
		System.out.println("Common ancestor is " + commonAncestor);
		
		
	}
}
