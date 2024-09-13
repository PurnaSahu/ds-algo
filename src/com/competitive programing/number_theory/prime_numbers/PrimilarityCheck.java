package in.purna.primeNumbers;

/*given a number N, check if its Prime or not?
  
  constraints: 1<= N <= 10^10 -> means N can go up to 10^10 number
  if we will implement O(N) algo for this, then it will take 10 or 100 sec to run, generally (it will give TLE (means Time limit exceeded)), we should allowed to do 10^6 or 10^7 operation, if we want
  to pass all the test cases in competitive coding
  
  so when constraints are upto 10^10, than we have to implement O(Log(N)) or O(sqrt(N))
  
  here if we will implement O(sqrt(N)) operations then it will go upto 10^5, means all test cases will be passed
   */ 
import java.lang.Math;
import java.util.Scanner;
public class PrimilarityCheck {

	/*****************************************
	 	O(n) algo will be
	 	
	 	for (i= 2 to n-1){
	 		if(n%i==0){
	 			print "not a prime"
	 			return
	 		}
	 	}
	 	print "its a prime"
	 *****************************************/
	public static void main(String[] args) {
		
		System.out.println("Provide a number to check primilarity: ");
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		if (n==1) {
			System.out.println("1 is not a prime number");
		}
		else if(n==2){
			System.out.println("2 is a prime number");
		}
		else if(n<1) {
			System.out.println(n+"is invalid number for this operation.");
		}
		else {
			int optimalNum = (int)Math.sqrt(n);
			checkPrimilarity(n, optimalNum);
			withoutMathFunction(n);
		}
		sc.close();
	}

	private static void withoutMathFunction(int n) {
		
		for (int i=2;i*i<=n;i++) {
			if (n % i==0) {
				System.out.println(n+" is not a Prime Number.");
				return;
			}
		}
		System.out.println(n+" is a Prime Number.");
	}

	private static void checkPrimilarity(int n, int optimalNum) {
		
		for (int index=2;index<=optimalNum;index++) {
			if (n % index==0) {
				//if the number n is divisible by any number between 2 to optimalNum, then that number has another divisior other than 1 and n
				System.out.println(n+" is not a Prime Number.");
				return;
			}
		}
		System.out.println(n+" is a Prime Number.");
		
	}

}
