package com.linkedlist;

import java.util.Scanner;

public class ManualDLL {
	Node head;
	Node tail;
	//int  size=0;
	
	class Node {
		int value;
		Node next;
		Node prev;
		Node(int value){
			this.prev=null;
			this.value= value;
			this.next= null;
		}
	}
	
	public void insertAtEnd(int value) {
		Node newNode = new Node(value);
		/*if the DLL is empty, than the newnode will be pointed by both head and tail, as new nodes will be appended, taill will keep moving 
		 * and will refer to the end point of the DLL, where head will act as a root reference of DLL*/
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			/* there's no need for a while loop in the else part to traverse to end of the list. We only need to perform a constant number 
			 * of operations to insert a node at the end of a doubly linked list. Here, tail is already refering to end of the list, 
			 * we just need to update it.*/
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}

	}

	private void insertAtBegin(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} /*
			 * else { newNode.next=head.next; newNode.prev=head; head=newNode; }
			 * this approch insert after 1st node and b4 its successor, and newNode pointing back to head node by skipping 1 node, kind of graph
			 */
		else {
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
		}
	}

	private void insertAtIndex(int data, int index) {
		Node newNode = new Node(data);
		int count = -1;
		Node current = head;
		while (current != null) {
			++count;
			if (count + 1 == index) {
				newNode.next = current.next;
				newNode.prev = current;
				current.next = newNode;
				break; // simply return from loop, once our job done
			}
			current = current.next;
		}
	}
	public void display() {
		Node temp= head;
		if (temp== null)
			System.out.println("the list is Empty");
		//while (head != tail), we can also check like this, only when we are sure that our tail points to last node
		while (temp!=null) {
			System.out.print("->"+temp.value);
			temp=temp.next;
			//size++; this way everytime we call dispaly(), our size also updated unnecesarily, we will get garbage data
		}
		System.out.println();
		//printMessage("display");
	}
	public int size() {
		Node temp= head;
		int size=0;
		while (temp!=null) {
			temp=temp.next;
			size++;
		}
		return size;
	}
	
	public void printMessage(String callerMethod) {
		/*
		System.out.println(callerMethod== "insert" ? "newNode inserted successfully" : "OOPS!! Problem occured while inserting the Node");
		System.out.println(callerMethod== "display" ? "The list has been displayed succesfully" : "OOPS!! Problem occured while displaying the list");
		*/
		switch (callerMethod) {
		case "insert" : System.out.println(" -> inserted successfully");
		break;
		case "display" : System.out.println("The list has been displayed succesfully");
		break;
		default : System.out.println("OOPS!! some Problem occured");
		break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Please select your option: \t"+"1. insertion 2. display 3.Terminate");
		ManualDLL l = new ManualDLL();
		int option = 0;
	    while (option != 3) {
	        System.out.println("Please select your option: ");
	        System.out.println("1. Insertion at End of List");
	        System.out.println("2. Display");
	        System.out.println("3. Terminate");
	        System.out.println("4. length od LL");
	        System.out.println("5. Search an element");
	        System.out.println("6. find max & min element in the list");
	        System.out.println("7. Insert at begining of the list");
	        System.out.println("8. Insert in a specific position of the list");
	        System.out.println("9. Delete at begining of the list");
	        System.out.println("10. Delete at end of the list");
	        System.out.println("11. Delete the specific index of the list");

	        option = sc.nextInt();

	        switch (option) {
	            case 1:
	                System.out.print("Please provide the data you want to insert: ");
	                int value = sc.nextInt();
	                l.insertAtEnd(value);
	                break;
	            case 2:
	                l.display();
	                break;
	            case 3:
	                System.out.println("Terminated...");
	                System.exit(0);
	                break;
	            case 4:
	            	System.out.println("Length of LL is: "+l.size());
	            	break;
	            case 5:
	            	System.out.print("Please provide the data you want to search: ");
	                int data = sc.nextInt();
	                int position = l.search(data);
	                System.out.println(position== -1 ? "Element not found in list" : "element found at position: "+position);
	                break;
	            case 6:
	            	l.Max_Min();
	            	break;
	            case 7:
	                System.out.print("Please provide the data you want to insert: ");
	                int InsertData = sc.nextInt();
	                l.insertAtBegin(InsertData);
	                break;
	            case 8:
	                System.out.print("Please provide the data you want to insert: ");
	                int InsertDataInMiddle = sc.nextInt();
	                System.out.print("Please specify the position to insert: ");
	                int index = sc.nextInt();
	                if (index<= l.size()-1) {
	                	if(index==0 || index==l.size()-1)
	                		System.out.println("seems like you want to insert the node either at 1st or lat position, in that case refer other options");
	                	else
	                		l.insertAtIndex(InsertDataInMiddle, index);
	                }
	                else
	                	System.out.println("Oops!! indexOutOfBoundException... entered position not available");
	                break;
	            case 9:
	            	l.deleteFromBegin();
	            	break;
	            case 10:
	            	l.deleteFromEnd();
	            	break;
	            case 11:
	                System.out.print("Please specify the position to delete: ");
	                int location = sc.nextInt();
	                if (location==0)
	                	System.out.println("seems like you want to delete the first node, so please choose option 9");
	                else if (location== l.size()-1)
	                	System.out.println("seems like you want to delete the last node, so please choose option 10");
	                else 
	                	l.deleteNodeAtIndex(location);
	            	break;
	            default:
	                System.out.println("Invalid option. Please select a valid option.");
	                break;
	        }
	    }
	    sc.close();
	}

	private int search(int data) {
		int index = -1;
		Node current = head;
		while (current != null) {
			if (current.value == data) {
				return ++index;
			}
			++index;
			current = current.next;
		}
		return -1;
	}

	private void Max_Min() {
		/*
		 * int max=0; int min=0;
		 * 
		 * we can not implement this, coz min value is 0, so it will printhe min element
		 * is 0 only, no value from list can be minimum then that
		 */
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Node current = head;
		while (current != null) {
			if (current.value >= max)
				max = current.value;
			if (current.value <= min)
				min = current.value;

			current = current.next;
		}
		System.out.println("Max value in list is: " + max + " & the mmin value in the list is: " + min);
	}

	private void deleteFromEnd() {
		Node temp = head;
		if (temp != null && temp.next != null) {
			// checking the underflow condition, here temp.next=null then imediately we can
			// delete the node in constant time
			while (temp.next.next != null) {
				temp = temp.next;
			}
		}
		temp.next = null;
		System.out.println("Node deleted successfully...");
	}

	private void deleteNodeAtIndex(int index) {
		int count = -1;
		Node temp = head;
		/*
		 * with for loop we can traverse this way // Traverse the list to find the node
		 * at the specified position 
		 * 
		 * Node current = head; 
		 * for (int i = 0; i < position && current != null; i++) 
		 * { current = current.next; }
		 */
		while (temp != null) {
			count++;
			if (count + 1 == index) {
				Node garbage = temp.next;
				garbage.next.prev = temp;
				temp.next = temp.next.next;
				garbage.prev = null;
				garbage.next = null;
				break;
			}
			temp = temp.next;
		}
	}

	private void deleteFromBegin() {
		Node garbageNode = head;
		// If there is only one node in the list
		if (head == tail) {
			head = null;
			tail = null;
		} else if (garbageNode != null) {
			// checking the underflow condition
			head = head.next;
			head.prev = null;
			garbageNode.next = null;
			garbageNode.prev = null;
		} else
			System.out.println("Ooops!! you are trying to delete a node from empty list");
		System.out.println("Node deleted successfully...");
	}
}
