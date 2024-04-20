package com.stack;

public class StaticStack {

	private int[] array;
	private int top;
	private int capacity;

	public StaticStack(int capacity) {
		// when this constructor executes a dummy stack created with size given
		this.capacity = capacity;
		array = new int[capacity];
		top = -1;
	}

	public static void main(String[] args) {
		//System.out.println("inside main");
		StaticStack stack = new StaticStack(5);
		stack.push(1);
		stack.push(1);
		stack.push(1);
		stack.push(4);
		stack.push(8);
		stack.push(42);
		//stack.peek();
		System.out.println("top element is: " + stack.peek());
		System.out.println("Poped element is: " + stack.pop());
		System.out.println("top element is: " + stack.peek()+" & current size of stack is: "+stack.size());
	}

	public void push(int data) {
		//System.out.println("inside push");
		if (top == capacity - 1) {
			System.out.println("Stack Overflow");
			return;
		}
		array[++top] = data;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return array[top--];
	}

	public int peek() {
		if (top == -1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return array[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

}
