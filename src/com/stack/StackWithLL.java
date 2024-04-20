package com.stack;

import java.util.LinkedList;
public class StackWithLL {
	
	private LinkedList<Integer> ll;
	
	public StackWithLL() {
		ll = new LinkedList<>();
	}
	
	public void push(int value) {
		ll.add(value);
		System.out.println("value "+value+" added in stack successfully");
	}
	
	public Integer pop() {
		if (!ll.isEmpty())
			return ll.remove(ll.size()-1);
		return null;
	}
	
	public Integer peek() {
		if (!ll.isEmpty()) 
			return ll.getLast();
		return null;
	}
	public static void main(String[] args) {
		
		StackWithLL sll = new StackWithLL();
		sll.push(10);
		sll.push(30);
		sll.push(500);
		sll.push(100);

		System.out.println("Poped Element is: "+sll.pop());
		System.out.println("top Element is: "+sll.peek());
	}

}
