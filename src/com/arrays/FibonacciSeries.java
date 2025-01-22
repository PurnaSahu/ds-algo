package com.arrays;

import java.util.Scanner;

public class FibonacciSeries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of terms from the user
        System.out.print("Enter the number of Fibonacci terms to display: ");
        int numTerms = scanner.nextInt();

        // Display the Fibonacci series
        System.out.println("Fibonacci Series up to " + numTerms + " terms:");

        for (int i = 0; i < numTerms; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        scanner.close();
    }

    // Recursive method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
