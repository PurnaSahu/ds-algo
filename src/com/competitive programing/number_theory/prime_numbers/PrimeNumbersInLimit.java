package in.purna.primeNumbers;
/*******************find all prime numbers present, in less than or equal to N***********************/
/*
 constraints: 1<=N<=10^6
 the below approach will take n elements and check the primilarity of each, which will take O(sqrt(n)) time,
 so total time= O(Nsqrt(N))
 			= O(N^3/2)
 			= so, in that case, worst case when N=10^6, than time will be: O(10^6*3/2) = O(10^9) -> TLE issue will come and all test cases wont pass
 	we cant follow the traditional approach in competitive coding
  */
import java.util.Scanner;

public class PrimeNumbersInLimit {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the upper limit");
		int num=sc.nextInt();
		sc.close();
		/*the below approch is traditional approch where time complexity will be O(NSqrt(n))*/
		if (num>1) {
			printListOfPrimeNumbers(num); 
		}
		else {
			System.out.println("not eligible to perform the operation");
		}
	}

	private static void printListOfPrimeNumbers(int num) {
		int i=2;
		//index=0;
		System.out.println("printing the list");
		while(i<=num) {
			if(isPrime(i)=="yes") {
				System.out.print(i+" ");
			}
			i+=1;
		}
	}

	/********the below method will take O(sqrt(N)) time complexity********/
	private static String isPrime(int n) {
		if(n==2)
			return "yes";
		//else if(n==1)
		//	return "no";
		
		int sqrtNum= (int)Math.sqrt(n);
		
		int i=2;
		while(i<=sqrtNum) {
			if(n%i==0) {
				return "no";
			}
			i++;
		}
		return "yes";
	}
}
