package in.purna.array;

import java.util.Scanner;

/****************WAP to check whether the given array is sorted or not? *******************/
public class SortedArrOrNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the array size: ");
		int size=sc.nextInt();
		
		int[] arr = new int[size];
		int i=0;
		while(i<size) {
			arr[i]=sc.nextInt();
			i++;
		}
		
		System.out.println(checkSortedArrayOrNot(arr, size));

	}

	private static String checkSortedArrayOrNot(int[] arr, int size) {
		boolean isAsc=isAscending(arr,size);
		boolean isDesc=isDescending(arr, size);
		
		if(isAsc)
			return "Yes, given array is sorted in Ascending order.";
		if(isDesc)
			return "Yes, given array is sorted in Descennding order.";
		return "The array is not sorted.";
	}

	private static boolean isAscending(int[] arr, int size) {
		int start=0,end=size-1;
		while(start<end) {
			if(arr[start]<=arr[end] && arr[start]<=arr[start+1] && arr[end]>=arr[end-1]) {
				start++;
				end--;
			}
			else 
				return false;
		}
		return true;
		
	}
	
	private static boolean isDescending(int[] arr, int size) {
		int start=0,end=size-1;
		while(start<end) {
			if(arr[start]>=arr[end] && arr[start]>=arr[start+1] && arr[end]<=arr[end-1]) {
				start++;
				end--;
			}
			else 
				return false;
		}
		return true;
		
	}

}
