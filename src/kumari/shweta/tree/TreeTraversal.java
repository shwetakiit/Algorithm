/**
 * 
 */
package kumari.shweta.tree;

/**
 * @author Shweta kumari
 *
 */
public class TreeTraversal {
	public static void preorder(Node root) {
		
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void inorder(Node  root) {
		if(root == null) {
			return;
		}
		
	inorder(root.left);
	System.out.print(root.data);
	inorder(root.right);
	
	}
	
	public static void postorder(Node root) {
		if(root == null) {
			return ;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	//Total no of node in tree .
	public static  int sizeOfTree(Node root) {
		
		if(root==null) {
			return 0;
		} 
		
		int l= sizeOfTree(root.left);
		int r= sizeOfTree(root.right);
		return l+r+1;
		
	}
	
	/*
	 * Height of longest path is no of edges between root node and leaf 
	 * node of tree is Height of tree
	 * Note :We are counting no of edges.It can be ask  no of node is height.
	 */
	
	public static int heightOfTree(Node root) {
		if(root==null) {
			return -1;
		}
		
		int heightOfLeftSubtree = heightOfTree(root.left);
		int heightOfRightSubtree = heightOfTree(root.right);
		return Math.max(heightOfLeftSubtree, heightOfRightSubtree)+1;
	}
	
	
	public static void convert_morror(Node root) {
		
		if(root==null) {
			return ;
		}
		convert_morror(root.left);
		convert_morror(root.right);
		swap(root);
	}
	
	public static void swap(Node root) {
		Node temp = root.left;
		root.left= root.right;
		root.right=temp;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.left.left=new Node(4);
		root.left.right= new Node(3);
		root.right= new Node(5);
		root.right.left=new Node(6);
		root.right.right= new Node(7);
		System.out.println("Pree order traversal");
		preorder(root);
		System.out.println("In order traversal");
		inorder(root);
		System.out.println("Post order traversal");
		postorder(root);
		System.out.println("Mirror of Tree");
		convert_morror(root);
		System.out.println("Mirror convereted then print inorder");
		preorder(root);
		
		//Size of tree 
		int sizeOfTree = sizeOfTree(root);
		System.out.println("Size of tree is  "+sizeOfTree);
		//Height of tree.
		int heightOfTree = heightOfTree(root);
		System.out.println("Height of tree is "+heightOfTree);
	}
	

}
