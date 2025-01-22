package in.purna.array;

import java.util.Scanner;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1st array size: ");
		int size1=sc.nextInt();
		int[] arr1= new int[size1];
		
		for(int i=0;i<size1;i++) {
			arr1[i]=sc.nextInt();
		}
		
		System.out.print("Enter 2nd array size: ");
		int size2=sc.nextInt();
		int[] arr2= new int[size2];
		
		for(int i=0;i<size2;i++) {
			arr2[i]=sc.nextInt();
		}
		
		//Array has to be in Ascending order
		String message=hasToBeAscSort(arr1,arr2,size1,size2);
		boolean isAsc=message.contains("OOPS");
		if(isAsc) {
			System.out.println("Arrays merged...");
			/*we are taking different array size, so if one array finished then the larger array will be simply pasted to new array, when the short array ends
			 * we keep checking on each iteration whether the array has reached till end, if yes then break the loop and set the flag to track */
			mergeSortedArrays(arr1,arr2,size1,size2);
		}
		else
			System.out.println(message);
		
	}

	private static String hasToBeAscSort(int[] arr1, int[] arr2, int size1, int size2) {
		int start=0,end=size1-1,flag=1;
		for(int i=0;i<size1;i++) {
			if(arr1[start]<=arr1[end]) {
				start++; end--;
			}else {
				flag=-1;
				break;
			}
			
		}
		start=0;end=size2-1;
		for(int i=0;i<size2;i++) {
			if(arr2[start]<=arr2[end]) {
				start++; end--;
			}else {
				flag=-1;
				break;
			}
			
		}
		if (flag>0)
			return "Both Arrays are sorted order";
		else
			return "OOPS! seems like array is not sorted in Ascending order.";
	}

	private static void mergeSortedArrays(int[] arr1, int[] arr2, int size1, int size2) {
		
		int start1=0,start2=0,p=0,flag=0;
		int[] arr = new int[size1+size2];
		
		while(start1<size1 || start2<size2) {
			
			if(arr1[start1]<arr2[start2]) {
				arr[p]=arr1[start1];
				p++;
				start1++;
			}
			else if(arr1[start1]==arr2[start2]){
				arr[p]=arr1[start1];
				p++;
				arr[p]=arr1[start1];
				p++;
				
				start1++; start2++;
			}
			else {
				arr[p]=arr2[start2];
				start2++;
				p++;
			}
			if(start1==size1) {
				flag=1;
				break;
			}
			if(start2==size2) {
				flag=2;
				break;
			}
		}
		if(flag==1) {
			while(start2<size2) {
			arr[p]=arr2[start2];
			start2++;
			p++;
			}
		}
		if(flag==2) {
			while(start1<size1) {
			arr[p]=arr1[start1];
			start1++;
			p++;
			}
		}
		//System.out.println(Array.toString(arr));
		for(int j=0;j<arr.length;j++)
			System.out.println(arr[j]);
		
	}

}
