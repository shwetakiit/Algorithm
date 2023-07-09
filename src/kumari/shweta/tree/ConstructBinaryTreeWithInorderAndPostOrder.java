/**
 *@author Shweta Kumari
 *2023-07-09
 */
package kumari.shweta.tree;

import java.util.Arrays;
import java.util.List;

/*Convert in Binary tree from given inOrder and postOrder array
 * inOrder[] ={4,2,7,5,1,3,8,6,9}
 * postOrder[]={4,7,5,2,8,9,6,3,1}
 * Created binary tree preOrder result is {1  2	 4	5	7	3	6	8	9}
 * 
 */
public class ConstructBinaryTreeWithInorderAndPostOrder {
	public TreeNode buildTree(List<Integer> inorderList, List<Integer> postOrderList) {

		/*
		 * sti-> start index of inorder list ei-> end index of inorder list; 
		 * stp->start index of post order 
		 * ep -> end index of post order
		 */

		int sti = 0, ei = inorderList.size() - 1, stp = 0, ep = postOrderList.size() - 1;

		if (inorderList.isEmpty() || inorderList.isEmpty()) {
			return null;
		}
		TreeNode root;
		root = construct(inorderList, postOrderList, sti, ei, stp, ep);
		return root;
	}

	public TreeNode construct(List<Integer> inorderList, List<Integer> postOrderList, int sti, int ei, int stp,
			int ep) {
		if (sti > ei) {
			return null;
		}
		TreeNode root = new TreeNode(postOrderList.get(ep));
		int idx = -1;
		for (int i = sti; i <= ei; i++) {
			if (inorderList.get(i) == root.data) {
				idx = i;
				break;
			}
		}
		int countl = idx - sti;
		int countr = ei - idx;
		root.left = construct(inorderList, postOrderList, sti, idx - 1, stp, stp + countl - 1);
		root.right = construct(inorderList, postOrderList, idx + 1, ei, stp + countl, ep - 1);
		return root;
	}

	public void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + "\t");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static void main(String[] args) {

		List<Integer> inorderList = Arrays.asList(4, 2, 7, 5, 1, 3, 8, 6, 9);
		List<Integer> postOrderList = Arrays.asList(4, 7, 5, 2, 8, 9, 6, 3, 1);

		ConstructBinaryTreeWithInorderAndPostOrder obj = new ConstructBinaryTreeWithInorderAndPostOrder();
		TreeNode treeNode = obj.buildTree(inorderList, postOrderList);

		// Traverse Created binary tree in post order

		obj.preOrderTraversal(treeNode);
	}
}
