package in.purna;

import in.purna.DetectLoop.Node;

public class DeleteLastOccurence {
	Node head;
	public DeleteLastOccurence() {
		head=null;
	}
	public static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public void push(int value) {
		Node newNode= new Node(value);
		if(head== null)
			head=newNode;
		else {
			newNode.next=head;
			head=newNode;
		}
	}
	
	public void dispaly() {
		Node temp = head;
		System.out.print("=>started");
		while (temp != null) {
			System.out.print("=>" + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}

	public void lastOccurance(int item) {
		Node temp=head, lastOccuranceNode= head;
		while(temp!=null) {
			if(temp.data == item)
				lastOccuranceNode= temp;
			temp=temp.next;
		}
		
		/*the temp now pointing to last Node and the lastOccurance Node points to the node where the item occurs last time
		 * 
		 * Now, here we need to test 2 scenario
		 * 1. where the Node we found is the last Node then deletion will be done differently
		 * 2. if the Node we found is not last Node
		 */
		//1st scenario
		if (lastOccuranceNode!= null && lastOccuranceNode.next==null) {
			temp=head;
			while(temp.next != lastOccuranceNode) {
				//temp will point to the previous Node of lastOccuranceNode
				temp=temp.next;
			}
			temp.next=null;
			lastOccuranceNode.next=null;
		}
		
		//2nd scenario
		if (lastOccuranceNode != null && lastOccuranceNode.next != null) {
			lastOccuranceNode.data= lastOccuranceNode.next.data;
			temp= lastOccuranceNode.next;
			lastOccuranceNode.next= temp.next;
			temp.next=null;
		}
		System.out.println("last occurance of item "+item+" deleted succesfully...");
	}
	public static void main(String[] args) {
		
		DeleteLastOccurence dlo=new DeleteLastOccurence();
		dlo.push(1);
		dlo.push(2);
		dlo.push(3);
		dlo.push(4);
		dlo.push(3);
		dlo.push(5);
		dlo.push(2);
		dlo.push(6);
		
		dlo.dispaly();
		
		dlo.lastOccurance(3);
		
		dlo.dispaly();

	}

}
