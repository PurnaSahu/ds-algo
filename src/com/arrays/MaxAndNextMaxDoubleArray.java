package com.arrays;

import java.util.Scanner;

public class MaxAndNextMaxDoubleArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create an array to store the elements
        double[] array = new double[size];

        // Input elements of the array from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }

        // Call the method to find max and next max
        findMaxAndNextMax(array);

        scanner.close();
    }

    // Method to find and print the maximum and next maximum elements in a double array
    public static void findMaxAndNextMax(double[] array) {
        double max = Double.MIN_VALUE; // Initialize max to smallest possible value
        double nextMax = Double.MIN_VALUE; // Initialize nextMax to smallest possible value
/*
 * The Double.MIN_VALUE in Java represents the smallest positive finite value that 
 * can be represented by a double-precision floating-point number. It is a constant defined
 *  in the Double class and has a value of approximately 4.9E-324. This value is positive and 
 *  very close to zero.
 * */
        // Iterate through the array to find max and next max
        for (double element : array) {
            if (element > max) {
                nextMax = max;
                max = element;
            } else if (element > nextMax && element != max) {
                nextMax = element;
            }
        }

        // Display the results
        if (max != Double.MIN_VALUE && nextMax != Double.MIN_VALUE) {
            System.out.println("Maximum element: " + max);
            System.out.println("Next maximum element: " + nextMax);
        } else {
            System.out.println("Insufficient elements to find max and next max.");
        }
    }
}

