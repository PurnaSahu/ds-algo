package com.linkedlist;

import java.util.Scanner;

class Node {
	int value;
	Node next;
	
	Node(int value){
		this.value= value;
		this.next= null;
	}
}
public class ManualLL {
	Node root;
	//int  size=0;
	/*
	 * no need of constructor here, coz we dont need to initialize anything specifically. but we have constructor for Node class, coz we need 
	 * to set some value B4 creating the node.
	 
	public ManualLL() {
		this.root=null;
	}
	*/
	public void insertAtEnd(int value) {
		Node newNode = new Node(value);
		if (root==null) {
				root=newNode; }
		else {
			Node temp= root;
			while(temp.next!= null) {
				temp=temp.next;
			}
			temp.next= newNode;
		}
		//printMessage("insert");
	}
	private void insertAtBegin(int value) {
		Node newNode = new Node(value);
		if (root==null) {
				root=newNode; }
		else {
			newNode.next= root;
			root=newNode;
		}
	}
	private boolean insertAtIndex(int data,int index) {
		Node newNode = new Node(data);
		int count=-1;
		if (index!=0 && index>0) {
			Node current=root;
			while(current!=null) {
				++count;
				if (count+1 == index) {
					newNode.next=current.next;
					current.next=newNode;
					return true;
				}
				current=current.next;
			}
		}
		else
			System.out.println("seems like you want to insert at the begin of the list, Please choose option 7");
		return false;
		
	}
	public void display() {
		Node temp= root;
		if (temp== null)
			System.out.println("the list is Empty");
		while (temp!=null) {
			System.out.print("->"+temp.value);
			temp=temp.next;
			//size++; this way everytime we call dispaly(), our size also updated unnecesarily, we will get garbage data
		}
		System.out.println();
		//printMessage("display");
	}
	public int size() {
		Node temp= root;
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
		ManualLL l = new ManualLL();
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
	                if (index< l.size()-1)
	                	System.out.println(l.insertAtIndex(InsertDataInMiddle, index)== true ? "newNode inserted successfully at position: "+index : "OOPS!! Problem occured while inserting the Node");
	                else if(index== l.size()-1)
	                	System.out.println("seems like you want to insert at end of the list, hence recommended to use option-1");
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
		int index=-1;
		Node current = root;
		while (current!=null) {
			if(current.value== data) {
				return ++index;
			}
			++index;
			current=current.next;
		}
		return -1;
	}
	private void Max_Min() {
		/*
		int max=0;
		int min=0;
		
		we can not implement this, coz min value is 0, so it will printhe min element is 0 only, no value from list can be minimum then that
		*/
		int min= Integer.MAX_VALUE;
		int max= Integer.MIN_VALUE;
		Node current=root;
		while (current != null) {
			if (current.value>= max)
				max=current.value;
			if(current.value<= min)
				min = current.value;
			
			current=current.next;
		}
		System.out.println("Max value in list is: "+max+ " & the mmin value in the list is: "+min);
	}
	private void deleteFromEnd() {
		Node temp=root;
		if (temp!=null && temp.next!=null) {
			//checking the underflow condition
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		}
		temp.next=null;
		System.out.println("Node deleted successfully...");
	}
	private void deleteNodeAtIndex(int index) {
		int count=-1;
		Node temp=root;
		while(temp!=null) {
			count++;
			if (count+1 == index) {
				temp.next=temp.next.next;
			}
			temp=temp.next;
		}
	}
	private void deleteFromBegin() {
		Node garbageNode= root;
		if (garbageNode!=null) {
			//checking the underflow condition
		root =root.next;
		garbageNode.next=null;
		}
		System.out.println("Node deleted successfully...");
	}

}
