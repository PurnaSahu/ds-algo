package in.purna.tree;

import java.util.Scanner;

//import in.purna.tree.BinaryTree.Node;

public class HeightOf_BinaryTree {

	Node root;
	
	class Node{
		Node left,right;
		int data;
		
		Node(int value){
			this.data=value;
			this.left=null;
			this.right=null;
		}
	}
/*	
	private void insert(Scanner sc) {
		System.out.print("Please enter the root node value: ");
		int value = sc.nextInt();
		root = new Node(value);
		insert(sc, root);
	}

	private void insert(Scanner sc, Node node) {

		System.out.println("Would you like to insert on left of " + node.data);
		Boolean left = sc.nextBoolean();
		if (left) {
			System.out.print("Please insert the value: ");
			int value = sc.nextInt();
			node.left = new Node(value);
			insert(sc, node.left);
		}

		System.out.println("Would you like to insert on right of " + node.data);
		Boolean right = sc.nextBoolean();
		if (right) {
			System.out.print("Please insert the value: ");
			int value = sc.nextInt();
			node.right = new Node(value);
			insert(sc, node.right);
		}
	}
*/
	public void display() {
		display(this.root, "");
	}

	public void display(Node node, String indent) {
		
		if (node == null) {
			// to avoid processing leaf node as well as, empty Tree
			
			return;
		}
		System.out.println(indent + node.data);
		display(node.left, indent + "\t");
		display(node.right, indent + "\t");
	}
	
	private int maxHeightOfTree(Node root) {
		
		if(root==null)
			return 0;
		else {
			int lst_height = maxHeightOfTree(root.left);
			int rst_height = maxHeightOfTree(root.right);
			
			int height= lst_height>rst_height ? lst_height+1 : rst_height+1;
			return height;
		} 
		
		//return 0;
	}
	
	public static void main(String[] args) {
		
		HeightOf_BinaryTree tree= new HeightOf_BinaryTree();
		HeightOf_BinaryTree.Node root=  tree.new Node(11);
		root.left= tree.new Node(21);
		root.right= tree.new Node(10);

		root.left.left= tree.new Node(42);
		root.left.right= tree.new Node(25);
		
		root.left.right.left= tree.new Node(30);
		//root.left.right.right= tree.new Node(7);
		//System.out.print("root value"+root);
		tree.display(root, "");
		
		System.out.print("Height is:"+tree.maxHeightOfTree(root));
	}

}
