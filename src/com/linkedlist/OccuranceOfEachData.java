/*
 Author: PURNA SAHU
 Date: 30-Apr-2024
 Sub: Occurance of a data and Occurance of each data in the list, we will keep independent functions to operate with this 
 */

package in.purna;

import java.util.HashMap;

import in.purna.Delete_N_Nodes_After_M_Nodes.Node;

public class OccuranceOfEachData {
	Node head=null, tail=null;
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	private void push(int value) {
		Node newNode = new Node(value);
		if (head==null) {
			head=newNode;
			tail=head;
		}
		else {
			newNode.next=head;
			head=newNode;
		}
		System.out.println("head pointing to:"+head.data+" and tail pointing to:"+tail.data);
	}
	
	void display() {
		Node temp=head;
		while (temp!=null) {
			System.out.print("=>"+temp.data);
			temp=temp.next;
		}
		System.out.println("\n========================printed successfully...");
	}
	
	private int OccuranceOfItem(int item){
		
		int count=0;
		Node temp=head;
		while(temp!=null) {
			if(temp.data==item)
				++count;
			temp=temp.next;
		}
		return count;
	}
	
	private void OccuranceOfEachItem() {
		HashMap<Integer,Integer> itemCount = new HashMap<>();
		Node temp=head;
		while (temp!=null) {
			if (itemCount.containsKey(temp.data)) {
				itemCount.put(temp.data, itemCount.get(temp.data)+1);
			}
			else {
				itemCount.put(temp.data, 1);
			}
			temp=temp.next;
		}
		System.out.println(itemCount);
	}
	
	public static void main(String[] args) {
		//Node head=null;
		OccuranceOfEachData od = new OccuranceOfEachData();
		
		od.push(21); 
		od.push(8); 
		od.push(74); 
		od.push(56);
		od.push(12); 
		od.push(12); 
		od.push(12);
		
		od.display();
		System.out.println("The Item occured "+od.OccuranceOfItem(12)+" times in the list");
		
		od.OccuranceOfEachItem();
	}

}
