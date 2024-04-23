package in.purna;

import in.purna.DeleteLastOccurence.Node;

//import in.purna.DeleteLastOccurence.Node;

public class FindAndDeleteMiddleOfLL {
	
	Node head;
	Node tail;
	
	
	
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=next;
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
	
	public Node pushAtEnd(Node last, int value) {
		// Here, insertion at end of LL is done with constant time complexity
		Node newNode= new Node(value);
		if (last == null) {
			last= newNode;
			head=last;
		}
		else {
		last.next = newNode;
		last=newNode; // Update last to point to the new node
		}
		return last;
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
	
	/*
	 * Here, Floyd's Cycle finding Algorith (Hare & Tortoise Algo) implemented 
	 * fast pointer will point to last node, incase of odd length LL and will point to null in case of even length LL
	 * our focus is not to go till last node or till it becomes NULL, our focus should travel to the Node, in such a way, when loop ends either fastPtr
	 * will be NULL or fastPtr.next is NULL
	 */
	private Node findMiddleNode() {
		Node fastPtr = head, slowPtr = head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next; // will move by 2 nodes
			slowPtr = slowPtr.next;
		}
		// when this loop ends, either fastPtr points to last node or null, in both case
		// slowPtr will point to middle Node
		return slowPtr;
	}
	
	private void deleteMiddleNode(Node nodeToDelete) {
		Node temp= nodeToDelete.next;
		nodeToDelete.data = temp.data;
		nodeToDelete.next = temp.next;
		temp.next=null;
	}
	
	public static void main(String[] args) {
		
		FindAndDeleteMiddleOfLL mll = new FindAndDeleteMiddleOfLL();
		
		mll.tail=mll.pushAtEnd(mll.tail, 10);
		mll.tail=mll.pushAtEnd(mll.tail, 20);
		mll.tail=mll.pushAtEnd(mll.tail, 60);
		mll.tail=mll.pushAtEnd(mll.tail, 30);
		mll.tail=mll.pushAtEnd(mll.tail, 25);
		mll.tail=mll.pushAtEnd(mll.tail, 58);
		
		mll.dispaly();
		
		Node middleNodePointer = mll.findMiddleNode();
		System.out.println("The middle node holds data: "+middleNodePointer.data);
		
		mll.deleteMiddleNode(middleNodePointer);
		
		mll.dispaly();
	}

}
