package in.purna.array;

import java.util.HashMap;
import java.util.Scanner;

/******************search an element in 2-D array*****************/
/*******************Sum and average of all elements in 2-D array****************/
/******************sum of diagonal elements in 2-D array*****************/
public class TwoDimensionalArrayOperations {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("provide the row and column size of 2-D array");
		int row= sc.nextInt();
		int col=sc.nextInt();
		System.out.println("enter the data...");
		int [][] arr = new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=sc.nextInt();
			}
			System.out.println("row data saved...");
		}

		//printing the matrix
		for(int i=0;i<row;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("Sum of all elements in the matrix is: "+sumOfAllElements(arr,row,col));
		
		int element=sc.nextInt();
		System.out.println("element found at: "+searchElement(arr,row,col,element));
		
		if(row==col) {
			System.out.println("sum of all diagonal elements: "+sumOfDiagonalElements(arr,row,col));
		}
		else
			System.out.println("Not a valid matrix for adding all diagonal elements");
	}

	private static HashMap<Integer, String> searchElement(int[][] arr, int row, int col, int element) {
		
		HashMap<Integer,String> map= new HashMap<>();
		int key=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==element) {
					String index= String.valueOf((char)i+(char)j);
					map.put(++key, "Element found at row-"+(i+1)+" and column-"+(j+1));
					//key=Integer.parseInt(index);
					//Element found at row-"+index.substring(0, 1)+" and column-"+index.substring(1, 1)
					//Character.getNumericValue(index.charAt(1))
				}
			}
			
		}
		return map;
	}

	private static int sumOfAllElements(int[][] arr, int row, int col) {
		
		int sum=0;
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sum=sum+arr[i][j];
			}
			//System.out.println();
		}
		return sum;
	}

	private static int sumOfDiagonalElements(int[][] arr, int row, int col) {
		int sum=0;
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i==j) {
					sum=sum+ arr[i][i];
				}
				else
					continue;
			}
			//System.out.println();
		}
		return sum;
	}

}
