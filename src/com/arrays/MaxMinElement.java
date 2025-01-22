package com.arrays;
//import java.util.Scanner;
public class MaxMinElement {
	public static void findMaxMinInt(int[] array) {
        int[] result = new int[2]; // result[0] will store max, result[1] will store min

        // Check if the array is not empty
        if (array.length > 0) {
            result[0] = array[0]; // Initialize max
            result[1] = array[0]; // Initialize min

            // Iterate through the array to find max and min
            for (int i = 1; i < array.length; i++) {
                if (array[i] > result[0]) {
                    result[0] = array[i]; // Update max
                } else if (array[i] < result[1]) {
                    result[1] = array[i]; // Update min
                }
            }
        }
        System.out.println("Maximum element: " + result[0]);
        System.out.println("Minimum element: " + result[1]);
        //return result;
    }
	public static void findMaxMinFloat(float[] array) {
		float[] result = new float[2];
		
		if(array.length>0) {
			result[0]=array[0];
			result[1]=array[0];
			for(int j=0;j<array.length; j++) {
				if (array[j] > result[0]) {
                    result[0] = array[j]; // Update max
                } else if (array[j] < result[1]) {
                    result[1] = array[j]; // Update min
                }
			}
		}
		System.out.println("Maximum element: " + result[0]);
        System.out.println("Minimum element: " + result[1]);
		//return result;
	}
	public static void findMaxMinChar(char[] array) {
		char[] result = new char[2];
		
		if(array.length>0) {
			result[0]=array[0];
			result[1]=array[0];
			for(int j=0;j<array.length; j++) {
				if (array[j] > result[0]) {
                    result[0] = array[j]; // Update max
                } else if (array[j] < result[1]) {
                    result[1] = array[j]; // Update min
                }
			}
		}
		System.out.println("Maximum element: " + result[0]);
        System.out.println("Minimum element: " + result[1]);
		//return result;
	}
}
