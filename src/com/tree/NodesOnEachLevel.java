package in.purna.tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class NodesOnEachLevel {

	
	
	public static void printNodesAtEachLevel(TreeNode root) {
	    if (root == null) {
	        return;
	    }

	    int level=0;
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);

	    while (!queue.isEmpty()) {
	    	/*B4 we proceed for number of nodes to add in Queue, we first print number nodes currently available in Q
	    	 everytime we come out of the for loop we will check number of nodes available in Q, that will tell us number of 
	    	 nodes available in each level 
	    	 */
	        int levelSize = queue.size(); // Number of nodes at the current level
	        
	        System.out.println("Number of nodes at level-"+(++level)+" is: " + levelSize);

	        /*
	          we will pull each node from Q and include its child nodes in the Q, if exists.
	          So, at any moment at end of loops, we will print the Q, it will five nodes available on a particular level,
	          we can fetch nodes from Q and do neccessary operations on nodes at a particular level (like printing data, fetching max height at that level)
	         */
	        
	        for (int i = 0; i < levelSize; i++) { // Iterate over all nodes at the current level
	            TreeNode currentNode = queue.poll();

	            // Enqueue child nodes of the current node
	            if (currentNode.left != null) {
	                queue.add(currentNode.left);
	            }
	            if (currentNode.right != null) {
	                queue.add(currentNode.right);
	            }
	        }
	    }
	}


	public static void main(String[] args) {
        // Creating a simple binary tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(20);
        
        root.right.right.left = new TreeNode(63);

        printNodesAtEachLevel(root);
    }
	
}
