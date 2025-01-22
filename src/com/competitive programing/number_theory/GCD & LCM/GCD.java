/*Greatest common divisior (GCD) or Highest Common Factor (HCF) both are same thing
 	GCD (12, 18)-> it means find the highest number which divides both 12 & 18, which is 6
 	we will do prime factorization of both the numbers 12= 2^2 * 3^1 & 18= 3^2 * 2^1, so, GCD= we will take the minimum power-> 2^1 * 3^1=6
 	
 How to find GCD of two numbers?
 	few properties;
 	GCD (a, 1)= GCD (1, b)= 1
 	GCD (a, 0)= a, a>0
 	GCD (a, b)<= min (a, b) -> this property is going to help in making the logic
 	GCD (a, a)= a 
 	
 	a. Pduedo Code:
 		GCD(a,b) -> assume a>b, so i'm taking the minimum from both & start iterating downward from the minimum nuber
 		for (int i=b to 1){
 			we will find the number which divides both a & b, whenver we find that number, stop there, thats our biggest number which divides both a&b
 			if (a%i==0 && b%i==0){
 				gcd= i;
 				break;
 			}
 		}
 		Time Complexity = O(min(a, b))
 	
 	b. another property: This algorithm is called Eucledian Algorithm
 		GCD(a,b)= GCD (a-b, b) where a>=b
 */
package in.purna;

public class GCD {

	public static void main(String[] args) {
		

	}

}
