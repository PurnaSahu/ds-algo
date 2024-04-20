package com.linkedlist;

import java.util.Scanner;

/*we are going to find min and max element in an SLL, with O(1) time & space complexity
 * 
 * we can separately keep max & min variable and everytime we insert a node we can compare and update these 2 variables but the problem 
 * here is , its logically working only in case of insertion, but we keep doing deletion and alteration in LL, then those variables wont keep 
 * accurate value
 * Here we are going to keep the Header at top & all insertion & deletion will be done at begin of LL, bcoz it will give us easy access to our
 * result on constant time, it will be indirectly act as LIFO(stack pattern design), indirectly we building up a stack only using SLL.
 * */

/*simillarly we can add size in LL, and reduce / increase by 1, based delete() / Insert() method executed*/
public class Min_MaxInLL {

	Node head;
	private static class Node {
		int data;
		int max;
		int min;
		Node next;
		
		Node(int value) {
			this.data=value;
			this.min=value;
			this.max=value;
			this.next=null;
		}
	}
	private void insertAtBegin(int value) {
		Node newNode = new Node(value);
		if (head==null) {
			head=newNode;
		}
		if(head.max>newNode.max) {
			newNode.max= head.max;
		}
		if(head.min<newNode.min)
			newNode.min=head.min;
		//head.max>newNode.max ?  newNode.max= head.max :
		newNode.next=head;
		head=newNode;
	}
	private void findMaxMin(){
		System.out.println("the max value in the list is: "+head.max+" the Min value in the list is: "+head.min);
	}
	public static void main(String[] args) {
		Min_MaxInLL mm = new Min_MaxInLL();
		System.out.print("Please provide the value you want to insert: ");
		Scanner sc = new Scanner(System.in);
		int data= sc.nextInt();
		mm.insertAtBegin(data);
		mm.insertAtBegin(20);
		mm.insertAtBegin(31);
		mm.insertAtBegin(21);
		mm.findMaxMin();
		sc.close();
	}

}
