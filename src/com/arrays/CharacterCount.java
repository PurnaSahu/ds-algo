package com.arrays;

import java.util.Scanner;

public class CharacterCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Call the method to count characters and display the result
        countCharacters(userInput);

        // Close the scanner
        scanner.close();
    }

    // Method to count characters in a string
    public static void countCharacters(String str) {
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int digitCount = 0;
        int whiteSpaceCount=0;
        int specialCharCount = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowercaseCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            }
            else if (Character.isWhitespace(ch)){
            	whiteSpaceCount++;
            }
            else {
                specialCharCount++;
            }
        }

        // Display the result
        System.out.println(str.length());
        System.out.println("Uppercase letters: " + uppercaseCount);
        System.out.println("Lowercase letters: " + lowercaseCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("whiteSpaceCount: " + digitCount);
        System.out.println("Special characters: " + specialCharCount);
    }
}

