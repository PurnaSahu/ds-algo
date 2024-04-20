package com.arrays;

import java.util.Scanner;

public class StringLength {

	public static void main(String[] args) {
		System.out.println("enter string");
		Scanner sc =new Scanner (System.in);
		String obj= sc.nextLine();
		
		System.out.println("string is: "+obj+" - & its length: "+obj.length());
		int counter=0;
		for (char c : obj.toCharArray()) {
			//System.out.println(c);
			counter++;
		}
		/*
		 * in java this logic wont work, In Java, the null character \0 is not used in the same 
		 * way as it might be in some other programming languages. Instead, Java strings are 
		 * internally terminated by the null character, but you don't need to explicitly check for it 
		 * in your code.
		while(obj.charAt(counter) != '/0') {
			++counter;
		}
		*/
		System.out.println("String length without inbuilt function: "+counter);
		sc.close();
	}

}
