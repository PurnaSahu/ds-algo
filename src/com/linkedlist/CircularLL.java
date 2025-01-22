package in.purna;

public class CircularLL {
	Node head,tail;
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data= data;
			this.next= null;
		}
	}
	
	private void pushAtEnd(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		if (head == null) {
			head = newNode;
			newNode.next = head;
			tail=newNode;
		} else {
			while (temp.next != head) {

				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = head;
			tail=newNode;
		}
	}
	
	private void pushAtBegin(int data) {
		Node newNode = new Node(data);
		//Node temp = head;
		if (head == null) {
			head = newNode;
			newNode.next = head;
			tail=newNode;
		} else {
			newNode.next = head;
			head= newNode;
			tail.next=head;
		}
	}
	
	private void traverseCLL() {
		Node temp = head;
		while(temp.next!= head) {
			System.out.print("=>"+temp.data);
			temp= temp.next;
		}
		System.out.print("=>"+temp.data);
		System.out.println("\nTraversed successfully");
	}
	
	public static void main(String[] args) {
		
		CircularLL cll = new CircularLL();
		cll.pushAtBegin(10);
		cll.pushAtBegin(20);
		cll.pushAtBegin(30);
		cll.pushAtBegin(40);
		
		cll.traverseCLL();
		
		
		cll.pushAtEnd(70);
		cll.pushAtEnd(80);
		cll.pushAtEnd(90);
		cll.pushAtEnd(50);
		cll.pushAtBegin(5);
		
		cll.traverseCLL();
	}

}
