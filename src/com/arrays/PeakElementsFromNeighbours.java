package in.purna.array;

import java.util.ArrayList;
import java.util.Scanner;

/************Find a peak element which is not smaller than its neighbour's************/

/*
 array[] = {10, 20, 15, 2, 23, 90, 67} given an array find the elements which has neighbours value less than its own value
 output: 20, 90
 
 Approach: peak an element (arr[i]) check its bigger than arr[i-1] and arr[i+1] if yes print it. than repeat till end
 O(N), best time complexity could be O(logN) with binarySearch implementation
 */
public class PeakElementsFromNeighbours {

	
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Please enter the array Size: ");
		int size= sc.nextInt();
		
		if(size<1) {
			System.out.println("Invalid size provided !!, hence terminating the program");
			return;
		}
		
		int[] arr = new int[size];
		System.out.println("Please provide the array values:");
		
		for (int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}

		if (size==1)
			System.out.println("The peak element is: "+arr[0]);
		else {
			findPeakElements(arr, size);
			System.out.println("The peak elements are: "+findPeakElements(arr, size));
		}
	}

	private static ArrayList<Integer> findPeakElements(int[] arr, int size) {
		
		//int index=0;
		ArrayList<Integer> peakArr= new ArrayList<>();
		
		if(arr[0]>=arr[1]) {
			peakArr.add(arr[0]);
		}
		
		if(arr[size-1]>=arr[size-2]) {
			peakArr.add(arr[size]);
		}
		
		
		for (int i=1;i<size-1;i++) {
			if(arr[i] >=arr[i-1] && arr[i]> arr[i+1]) {
				peakArr.add(arr[i]);
			}
		}
		
		return peakArr;
	}

}
