package com.arrays;
//import com.arrays.MaxMinElement;
import java.util.Scanner;

public class MaxMinGeneric {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        // Create an array to store the elements various type
        int[] array = new int[size];
        float[] array_f = new float[size];
        char[] charArray = new char[size];
        
        System.out.print("please select your operation type: \n"+"1. for Integer Type \n"+
        "2. for Float Type\n"+"3. for Charecter Type");
        int type=scanner.nextInt();
        // Input elements of the array from the user
        System.out.println("Enter the elements of the array:");
        
        switch(type) {
        case 1:
        	 for (int i = 0; i < size; i++) {
                 System.out.print("Element " + (i + 1) + ": ");
                 array[i] = scanner.nextInt();
             }
        	 MaxMinElement.findMaxMinInt(array);
        	 break;
        case 2:
        	for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                array_f[i] = scanner.nextFloat();
            }
        	MaxMinElement.findMaxMinFloat(array_f);
       	 break;
        case 3:
        	for (int i = 0; i < size; i++) {
                System.out.print("Char Element " + (i + 1) + ": ");
                charArray[i] = scanner.next().charAt(0);
                /* we dont have nextChar() in java, but we have next() which will take input
                then we fetch charAt index0, so evenif we pass string it will fetch index0 and save,
                 but if want to take take index1 then charAt(1)
                */
            }
        	MaxMinElement.findMaxMinChar(charArray);
        	break;
        	default:
        		System.out.print("input type is unknown !!");
        }
       
     /*Display the results
        System.out.println("Maximum element: " + result[0]);
        System.out.println("Minimum element: " + result[1]);
        */
        scanner.close();
	}
}
