package in.purna;

import java.util.HashSet;

/*Detect a loop in LL
Date: 23-Apr-2024
Author: Purna Sahu
*/

public class DetectLoop {
	Node head;
	HashSet<Node> nodeAddress;
;
	public DetectLoop() {
		head=null;
		nodeAddress= new HashSet<Node>();
	}

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void insert(int value) {
		Node newNode= new Node(value);
		if(head== null)
			head=newNode;
		else {
			newNode.next=head;
			head=newNode;
		}
		//System.out.print("Inserted successfully");
	}
	long start = System.currentTimeMillis();
	long end = start + 30 * 1000;
	
	
	/*
	 * public void dispaly() { Node temp = head; while (System.currentTimeMillis() <
	 * end) { System.out.print("=>started"); while (temp != null) {
	 * System.out.print("=>" + temp.data); temp = temp.next; } } }
	 */
	
	public Node detectLoops() {
		Node temp=head;
		while (temp!= null) {
			if(nodeAddress.contains(temp))
				return temp;
			//all the visited nodes will be kept inside the set,and if found again then will consider as loop
			nodeAddress.add(temp);
			temp=temp.next;
		}
		return null;
	}
	
	/*
	 * private void display() { Node temp = head; long startTime =
	 * System.currentTimeMillis(); // Record the start time
	 * 
	 * while (true) { long currentTime = System.currentTimeMillis(); if (currentTime
	 * - startTime >= 3000) { // Check if 3 seconds have elapsed break; // Exit the
	 * loop if 3 seconds have passed }
	 * 
	 * System.out.print("=>started"); while (temp != null) { System.out.print("=>" +
	 * temp.data); temp = temp.next; }
	 * 
	 * // Reset temp to head for next iteration temp = head; } }
	 */

	public static void main(String[] args) {
		DetectLoop dl=new DetectLoop();
		dl.insert(10);
		dl.insert(80);
		dl.insert(20);
		dl.insert(60);
		dl.insert(50);
		dl.insert(70);
		dl.insert(90);
		
		//creating loop intentionally
		dl.head.next.next.next.next.next.next.next=dl.head.next.next.next;
		//dl.display();
		Node tem=dl.detectLoops();
		System.out.println("The exact memory address of the Node is:"+System.identityHashCode(tem));
		System.out.println("loop started from the Node with value:"+tem.data);

	}

}
