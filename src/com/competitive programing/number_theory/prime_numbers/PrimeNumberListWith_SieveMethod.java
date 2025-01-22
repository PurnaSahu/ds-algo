package in.purna.primeNumbers;

/*******************find all prime numbers present, in less than or equal to N. using sieve methodology)***********************/

import java.util.Scanner;

public class PrimeNumberListWith_SieveMethod {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("provide the upper limit: ");
		int n = sc.nextInt();
		sc.close();
		sieveSolution(n);
		
	}

	private static void sieveSolution(int n) {
		
		//create a n length boolean array and consider all indexes as a number and assume all numbers are prime initially
		boolean[] prime = new boolean[n+1]; //-> as its global array so initially all indexes will be false
		
		// we will make all numbers as true, means assume all are prime initially, this procedure will take O(n) time complexity and space also
		for(int i=2;i<=n;i++) {
			prime[i]=true;
		}
		
		/*
		  the next number which is marked as true will be always a prime number
		  the external loop will check 2 is true initially and pass it to internal loop to mark all its multiples as not prime
		  once internal loop ends, i will increment to 3, and 3 also true, so again will do the same thing
		  
		  now, i++ will be 4 in external loop, which is already marked as false,so keep moving until we get next true index and that will be our prime number
		  
		  rather than keeping the external loop like this we can optimize it
		  for(int i=2;i<=n;i++) -> assume n=25, so external loop no need to run till i<=n, it need to run til i<=sqrt(n)
		  i=2-> 4,6,8,10,12,14,16,18,20,22,24
		  i=3-> 9,12,15,18,21
		  i=5-> 25, here internal loop will start from i*i, coz 5*4, 5*3,5*2 will be covered as multiples of 4,3,2 respectively
		  i=6-> no need coz internal loop will start from i*i=36 which is >n
		 */
		for(int i=2;i*i<=n;i++) {
			if(prime[i]==true) {
				/*
				 	if a number is marked as true means, its a prime, hence all its multiplications will be marked as false, 
				 	coz they r definitely not prime
				 	if index-2 is prime-> true
				 		2-> 4,6,8,10,12,14,16,18,20,22,24 till n=25, all will be marked as not prime
				 */
				for (int j=i*i;j<=n;j+=i) {
					prime[j]=false;
				}
			}
		}
		printPrimeNubers(prime,n);
	}

	private static void printPrimeNubers(boolean[] prime, int size) {
		//int size= prime.length;
		System.out.println("prime numbers in the range of number "+size+" is as below:\n");
		for(int i=0;i<=size;i++) {
			System.out.print(i+"->"+prime[i]+" ");
		}
		System.out.println("\n====================================");
		for(int i=0;i<=size;i++) {
			if(prime[i]==true)
				System.out.print(i+" ");
		}
	}

}
