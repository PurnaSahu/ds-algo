package in.purna;

public class Delete_N_Nodes_After_M_Nodes {

	Node head, tail;
	
	static class Node{
		int data; 
		Node next;
		
		Node(int data){
			this.data= data;
			this.next=null;
		}
	}
	
	void insert( int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head= newNode;
			tail=head;
		}
		else {
			tail.next= newNode;
			tail= newNode;
		}
		System.out.println("Your Head points to "+head.data+" & tail points to "+tail.data);
	}
	
	void display() {
		Node temp=head;
		while (temp!=null) {
			System.out.print("=>"+temp.data);
			temp=temp.next;
		}
		System.out.println("========================================printed successfully...");
	}
	
	void skipM_NodesThanDeleteN_Nodes(int m, int n) {
		int count;
		Node curr= head;
		
		while(curr!=null) {
			
			/*Here, we need to focus on tail of the list as well, As we inserting the node at end of the list with O(1) time
			  hence every point we check if we are reaching to the last node of the list, if yes then point the tail to end node
			 */
			// we have to skip M nodes, so we will point to M-1 node
			for (count =1;count<m && curr!=null; count++) {
				if (curr.next==null)
					tail=curr;
				curr= curr.next;
			}
			// we are confirming, whether we are at last node, if yes, then rest N nodes are not existing, means no need to proceed
			if (curr == null) {
				//throw new IllegalStateException("hi");
				//tail=curr;
				return;
			}
			//B4 start iterating nodes to delete, we need to track the last MNode we got
			Node M_Node = curr;
			for (count=1;count<=n && curr!= null ;count++) {
				if (curr.next==null)
					tail=curr;
				curr=curr.next;
			}
			if (curr == null) {
				M_Node.next=curr;
				tail=M_Node;
				return;
			}
			
				M_Node.next=curr.next;
				Node nextM_Nodes=curr.next;
				curr.next=null;
				
				if(nextM_Nodes== null || nextM_Nodes.next== null)
					tail= nextM_Nodes;
				curr=nextM_Nodes;
			
		}
	}
	
	public static void main(String[] args) {
		int m=3, n=2;
		Delete_N_Nodes_After_M_Nodes dnamn = new Delete_N_Nodes_After_M_Nodes();
		dnamn.insert(10);
		dnamn.insert(30);
		dnamn.insert(20);
		dnamn.insert(42);
		dnamn.insert(81);
		dnamn.insert(41);
		dnamn.insert(24);
		dnamn.insert(3);
		dnamn.insert(28);
		dnamn.display();
		
		dnamn.skipM_NodesThanDeleteN_Nodes(m, n);
		
		dnamn.display();
		dnamn.insert(71);
		dnamn.insert(39);
		dnamn.display();
		dnamn.insert(27);
		
		dnamn.display();
		//dnamn.insert(tail,21);
	}

}
