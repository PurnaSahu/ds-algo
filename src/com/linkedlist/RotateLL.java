package in.purna;

import java.util.Scanner;

//import in.purna.FindAndDeleteMiddleOfLL.Node;

/*
 Author: Purna Sahu
 Date 23-Apr-2024
 Rotate LL 
 */
public class RotateLL {
	
	Node head;
	Node tail;
	
	private static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=next;
		}
	}
	
	private Node insertAtEnd (Node tail, int value) {
		Node newNode = new Node(value);
		if (tail == null) {
			head= newNode;
			tail=head;
		}
		else {
			tail.next= newNode;
			tail= newNode;
		}
		System.out.println("new tail1:"+tail.data+" & next contains:"+tail.next);
		return tail;
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
	
	private void anticlockwiseRotation(int k) {
		int tempo =k;
		Node temp = head, breakPoint = head;
		while (k!=1) {
			temp=temp.next;
			k--;
		}
		breakPoint=temp;
		while (temp.next!=null)
			temp = temp.next;
		temp.next=head;
		head=breakPoint.next;
		breakPoint.next=null;
		tail=breakPoint;
		System.out.println("LinkedList Rotated anti clockwise by "+tempo+" positions and the Break point data is: "+tail.data);
	}
	private int size() {
		Node temp=head;
		int count=0;
		while(temp!=null) {
			++count;
			temp=temp.next;
		}
		return count;
	}
	private void clockwiseRotation(int k) {
		Node temp= head, last=tail;
		int length= size();
		
		int garbage=length-k;
		
		while (garbage != 1) {
			temp=temp.next;
			garbage--;
		}
		//System.out.println("new tail0:"+tail.data);
		Node newHead= temp.next;
		temp.next=null;
		tail.next=head;
		
		head=newHead;
		tail=temp;
		System.out.println("Clockwise rotated "+k+" nodes successfully...");
	}
	
	public static void main(String[] args) {
		
		RotateLL rll = new RotateLL();
		/*
		 * rll.insertAtEnd(rll.tail, 11); rll.insertAtEnd(rll.tail, 21);
		 * rll.insertAtEnd(rll.tail, 55);
		 */
		
		rll.insertAtEnd(rll.insertAtEnd(rll.insertAtEnd(rll.insertAtEnd(rll.insertAtEnd(rll.insertAtEnd(rll.insertAtEnd(rll.insertAtEnd(rll.tail, 43), 5), 74), 36), 21), 11), 31), 56);
		//System.out.println(rll.tail.data);
		rll.dispaly();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("The number of nodes, you want to rotate: ");
		int k= sc.nextInt();
		sc.close();
		
		rll.anticlockwiseRotation(k);
		System.out.println(rll.tail.data);
		rll.dispaly();
		rll.tail=rll.insertAtEnd(rll.tail, 20);
		//System.out.println("in main the tail data is:"+rll.tail.data);
		rll.dispaly();
		rll.clockwiseRotation(3);
		rll.dispaly();
		rll.tail=rll.insertAtEnd(rll.tail, 51);
		rll.dispaly();
		rll.clockwiseRotation(6);
		rll.dispaly();
	}

}
