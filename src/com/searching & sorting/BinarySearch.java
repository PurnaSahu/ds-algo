package in.purna.searchAndSort;

/*
  Binary search can be implemented only on sorted array/DS, either it could be ascending or descending.
  best case: O(1)
  Worst Case: O(LogN)
  here it takes O(1) space complexity, but if we try recursively(rather writting while() loop, keep calling the same method) 
  than space complexity will be O(logN)
  
   To find whether an array is sorted in Ascending or Descending and then apply binary search algorithm based on the sorting order called
   "Order-agnostic BS"
   
   for Ascending sort
   ==================
   target< mid_element _. then search on left part of the mid element and repeat until we found the element or until we get a single element
   target> mid_element _. then search on right part of the mid element and repeat until we found the element or until we get a single element
   arr ={10,20,23,31,56,59,96,98,99} -> start=0, end=8, mid=0+8/2
   for Descending sort
   ==================
   target< mid_element _. then search on right part of the mid element and repeat until we found the element or until we get a single element
   target> mid_element _. then search on left part of the mid element and repeat until we found the element or until we get a single element

 */

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr= {10,20,23,31,56,59,96,98,99};
		int[] arr1= {98,65,61,54,32,21,19,8,5,3};
		int target = 5;

		int size=arr.length;
		
		//binarySearch(arr,size,target);
		System.out.println("the element found at index: "+binarySearch(arr1,size,target));
	}

	//return index value of the element, if found
	//return -1, if element not exist
	private static int binarySearch(int[] arr, int size, int target) {
		
		// find the sorting type of the array
		boolean isAsc = arr[0]<arr[size-1];
		int start=0, end=size-1;
		
		while(start<=end) {
			
			int mid= (start+end)/2;
			if(arr[mid]==target)
				return mid;
			
			if(isAsc) {
				if(target<arr[mid]) {
					//means target element available left of mid element
					end=mid-1;
				}else {
					//means target element available right of mid element
					start = mid+1;
				}
			}else {
				if(target<arr[mid]) {
					//means target element available right of mid element
					start = mid+1;
				}else {
					//means target element available left of mid element
					end=mid-1;
				}
			}
			
		}
		return -1;
	}

}
