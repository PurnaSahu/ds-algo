package in.purna.tree;

import java.util.Scanner;

public class BinaryTree {

	Node root;

	private class Node {
		Node left;
		int data;
		Node right;

		Node(int data) {
			this.left = null;
			this.data = data;
			this.right = null;
		}
	}

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

	public void display() {
		display(this.root, "");
	}

	private void display(Node node, String indent) {
		if (node == null) {
			// to avoid processing leaf node as well as, empty Tree
			return;
		}
		System.out.println(indent + node.data);
		display(node.left, indent + "\t");
		display(node.right, indent + "\t");
	}

	public void prettyDisplay() {
		prettyDisplay(root, 0);
	}

	private void prettyDisplay(Node node, int level) {
		if (node == null) {
			return;
		}

		prettyDisplay(node.right, level + 1);

		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t\t");
			}
			System.out.println("|------->" + node.data);
		} else {
			System.out.println(node.data);
		}
		prettyDisplay(node.left, level + 1);
	}

	/*
	 Traverse the tree all the 3 ways;

		1. InOrder: print the data when visited the node for second time (Left sub tree -> root -> right sub tree)
		2. PreOrder: print the data when visited the node for first time (root -> Left sub tree -> right sub tree)
		3. PostOrder: print the data when visited the node for third time (Left sub tree -> right sub tree -> root) 
	 */
	
	private void traverseTree (Scanner sc) {
		System.out.println("How would you like to traverse the tree ? 1. Inorder 2. Preorder 3. postorder");
		int option = sc.nextInt();
		
		switch (option) {
		case 1:
			inorder ();
			break;
		case 2:
			preorder();
			break;
		case 3:
			postorder();
			break;
		default:
			System.out.println("Invalid option...");
			return;
		}
	}
	
	private void inorder() {
		inorder(this.root);
	}
	
	private void inorder(Node node) {
		if (node == null)
			return;
		
		preorder(node.left);
		System.out.print("=>"+node.data);
		preorder(node.right);
	}
	
	private void preorder() {
		//System.out.println("=>"+roo);
		preorder(this.root);
	}
	private void preorder(Node node) {
		if (node == null)
			return;
		System.out.print("=>"+node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	private void postorder() {
		postorder(this.root);
	}
	
	private void postorder(Node node) {
		if (node == null)
			return;
		
		preorder(node.left);
		preorder(node.right);
		System.out.print("=>"+node.data);
	}
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		Scanner sc= new Scanner(System.in);
		
		bt.insert(sc);
		
		bt.display();
		
		System.out.println("displaying again with more understanding way...");
		bt.prettyDisplay();
		
		System.out.println("Display the data with BT traversing methods....");
		bt.traverseTree(sc);
	}

}

/*
 Output
 =================
 
  |		|------->3
|------->89
|		|		|		|------->77
|		|		|------->11
|		|		|		|------->44
|		|------->88
10
|		|		|------->87
|		|------->54
|		|		|------->56
|------->23
|		|------->34
Display the data with BT traversing methods....
How would you like to traverse the tree ? 1. Inorder 2. Preorder 3. postorder
2
=>10=>23=>34=>54=>56=>87=>89=>88=>11=>44=>77=>3
 */
