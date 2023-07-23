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

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		int found = findNodeInBinaryTree(root, 10);
		if (found == 1) {
			System.out.println("Given element is found in BST");

		} else {
			System.out.println("Given element is not found in BST");
		}
	}

}
