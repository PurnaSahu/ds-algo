package com.stack;

import java.util.ArrayList;

public class ManualStackWithAL {
	//first we will take global reference of DS (declaration of DS reference)
	private ArrayList<Integer> items;

	public ManualStackWithAL() {
		//Initialization of dummy DS
		items = new ArrayList<>();
	}

	public void push(int data) {
		items.add(data);
		System.out.println(data + " inserted successfully at position " + items.indexOf(data));
	}

	public Integer pop() {
		
		/*here , we will remove top element of stack, which means last element of arrayList and remove method will delete the element from
		 * ArrayList and return the the element deleted*/
		if (!items.isEmpty()) {
			return items.remove(items.size() - 1);
		}
		System.out.println("Stack Underflow");
		return null;
	}

	/*
	 * the return type of the pop() method is declared as int, which is a primitive
	 * data type in Java. Primitives cannot have a value of null, as null is
	 * reserved for objects. Therefore, returning null in a method with a return
	 * type of int results in a compilation error.
	 * 
	 * but if, the return type of the pop() method is declared as Integer, which is
	 * an object wrapper class for the primitive type int. Objects can have a value
	 * of null, so returning null in a method with a return type of Integer is valid
	 * and does not result in a compilation error.
	 * 
	 * or we can also handle like this public int pop() throws IllegalStateException
	 * { if (!items.isEmpty()) { return items.remove(items.size() - 1); } else {
	 * throw new IllegalStateException("Stack Underflow"); } }
	 */
	public Integer peek() {
		if (!items.isEmpty()) {
			return items.get(items.size() - 1);
		}
		//System.out.println("Stack Underflow");
		return null;
	}
	
	public Integer search(int element) {
		if (items.isEmpty()) {
			return null;
		}
		if (items.contains(element)) {
			return items.lastIndexOf(element);
		}
		return null;	
	}

	public static void main(String[] args) {
		//System.out.println("inside main");
		ManualStackWithAL stack = new ManualStackWithAL();
		stack.push(1);
		stack.push(2);
		stack.push(31);
		//stack.search(31);
		System.out.println("Top Element: " + stack.peek());
		System.out.println("Element poped from stack is: " + stack.pop());
		System.out.println("Top Element: " + stack.peek());
		System.out.println("Element " + stack.search(5)+" not found in stack");
		/*(stack.search(5) == null ) ? System.out.print("Element " + stack.search(5)+" not found in stack"); : 
			System.out.print("Element " + stack.search(5)+" found in stack"); */
		System.out.println((stack.search(1) == null) ? "Element not found in stack" : "Element found in stack at position "+stack.search(1));

	}

}
