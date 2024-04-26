package in.purna.array;

import java.util.Arrays;

public class RotateArray {
	
	static void rotateClockWise (int arr[]) {
		int size = arr.length -1;
		int numberToRotate = arr[0];
		for (int i=1; i<=size; i++) {
			arr[i-1] = arr[i];
		}
		arr[size]= numberToRotate;
	}
	/*
	  we can also do this with O(1) space complexity but time complexity will be O(K * N), by simply doing the rotateClockwise operation k times
	 static void rotateClockWise (int arr[]) {
	 
		int size = arr.length -1;
		while(k!=0){
		int numberToRotate = arr[0];
		for (int i=1; i<=size; i++) {
			arr[i-1] = arr[i];
		}
		arr[size]= numberToRotate;
		k--;
		}
	}
	 */
	/*
	 The below implementation takes O(K + N) time complexity (optimal approch) with space complexity O(K) 
	 */
	static void rotateClockwise_k_Positons(int arr[], int position) {
		
		int size= arr.length-1;
		int k = position % size;
		
		int temp[] = new int[k];
		
		for (int i=0; i<k;i++) {
			temp[i]=arr[i];
		}
		System.out.println("temp array"+Arrays.toString(temp));
		int initial=0;
		for (int j=k; j<=size; j++) {
			arr[initial] = arr[j];
			initial++;
		}
		System.out.println("The array after shifting, pointing to index:"+initial);
		System.out.println("partially rotated array"+Arrays.toString(arr));
		for (int p=initial,q=0; k<=size && q<temp.length;p++, q++) {
			arr[p]=temp[q];
		}
	}
	
	static void AnticlockwiseRotation (int arr[]) {
		int size= arr.length-1;
		int numberToRotate=arr[size];
		
		for (int j=size-1; j>=0; j--) {
			arr[j+1] = arr[j];
		}
		arr[0]=numberToRotate;
	}
	
	static void AnticlockwiseRotation_k_positions(int arr[], int position) {
		int size = arr.length - 1;
		
		int k= position % size;
		while (k != 0) {
			int numberToRotate = arr[size];
			for (int j = size - 1; j >= 0; j--) {
				arr[j + 1] = arr[j];
			}
			arr[0] = numberToRotate;
			k--;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {21,32,63,5,9,75,64,89,2};
		System.out.println("The array without any Rotation: "+Arrays.toString(arr));
		
		rotateClockWise(arr);
		rotateClockWise(arr);
		System.out.println("The array after ClockWise Rotation: "+Arrays.toString(arr));
		
		AnticlockwiseRotation(arr);
		
		System.out.println("The array after AntiClockWise Rotation: "+Arrays.toString(arr));
		
		rotateClockwise_k_Positons(arr, 3);
		System.out.println("The array after ClockWise Rotation by 3 places: "+Arrays.toString(arr));
		
		AnticlockwiseRotation_k_positions(arr, 4);
		System.out.println("The array after AntiClockWise Rotation by 4 places: "+Arrays.toString(arr));
	}

}
