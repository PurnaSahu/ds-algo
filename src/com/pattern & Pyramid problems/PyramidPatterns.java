package in.purna.pattern;


public class PyramidPatterns {

/*
 	print the below pattern
 *			i=0, j=0
 * *		i=1, j=0 to 1
 * * *
 * * * *
 * * * * *
 */
	private static void rightHalfPyramid() {
		for(int i=0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	/*
	 * * * * *	int i=5, j=5 or int i=0; j= 0 to <5-0
	 * * * *	int i=4, j=4 or int i=1; j= 0 to <5-i
	 * * *
	 * *
	 * 
	 */
	private static void reverseRightHalfPyramid() {
		for (int i=5;i>0;--i) {
			for (int j=1; j<=i;j++) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}
	}
	
	/*
	      *		i=1,  j=1, k=o to 5-i
	    * *		i=2; j=1 to 2, k=5-i
	  * * *
	* * * *
  * * * * *
	 */
	private static void leftHalfPyramid() {
		for (int i=1;i<=5;i++) {
			for (int k=0;k<5-i;k++) {
				System.out.print("  ");
			}
			for (int j=1; j<=i;j++) {
				System.out.print(" *");
			}
			System.out.print("\n");
		}
	}
	
	/*
	 *
    * *
   * * *
  * * * *
 * * * * *
	 */
	private static void printTriangle() {
		for (int i=1;i<=5;i++) {
			for (int k=0;k<5-i;k++) {
				System.out.print(" ");
			}
			for (int j=1; j<=i;j++) {
				System.out.print(" *");
			}
			System.out.print("\n");
		}
	}
	
	private static void reverseTriangle() {
		for (int i=5;i>=1;--i) {
			for (int k=0;k<5-i;k++) {
				System.out.print(" ");
			}
			for (int j=1; j<=i;j++) {
				System.out.print(" *");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("print right half pyramid");
		rightHalfPyramid();
		
		System.out.println("print reverse right half pyramid");
		reverseRightHalfPyramid();
		
		System.out.println("print left half pyramid");
		leftHalfPyramid();
		
		System.out.println("print triangle pyramid");
		printTriangle();
		
		System.out.println("print reverse triangle pyramid");
		reverseTriangle();
	}

}
