/**
 * Given the user entered bounds, this code will produce Pascal's triangle with 
 * it's equivalent binomial expansion
 * 
 * @author (Erin Payne)
 * @version (Project 3)
 * Your lab section (F 7:30AM)
 */
import java.util.*;

public class Project3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int i = 0; 	//Integer for row
		int j = 0; 	//Integer for column
		int n;	//Integer for user entered bound
		int x = 0; 	//Integer for middle numbers of pascal's
		int z;	//Subtracting factor from factorial
		int iFactorial = 0;
		int jFactorial = 0;
		int ijFactorial = 0;
		int xcoeff = 0;
	
		System.out.print("Enter a positive integer bound: ");
		n = keyboard.nextInt();		//Reads in bound from user
		
		System.out.println("Pascal's Triangle:");
		System.out.println();
		
		for(i = 0; i <= n; i++){	//Creates number of rows
			for(j = 0; j <= i; j++){	//Creates number of columns
				if(j == 0 || j == i){
					System.out.print("1 ");
				}
				else{
					//Calculates factorial of i
					int a = 1;
					for(z = 0; z < i; z++){
						iFactorial = a * (i-z);
						a = iFactorial;
					}
					//Calculates factorial of j
					int b = 1;
					for(z = 0; z < j; z++){
						jFactorial = b * (j-z); 
						b = jFactorial;
					}
					//Calculates factorial of i-j
					int k = 1;
					for(z = 0; z < (i-j); z++){
						ijFactorial = k * ((i - j) - z);
						k = ijFactorial;
					}
					x = iFactorial / (jFactorial * ijFactorial);
					System.out.print(x + " ");			
				}					
			}//End of columns
			System.out.println();		
		}//End of rows
		
		System.out.println("\nBionomial Expansions:");
		
		for(i = 0; i <= n; i++){	//Creates number of rows
			System.out.print("(x + y)^" + i + " = ");
			int xpow = i;
			int ypow = 0;
			for(j = 0; j <= i; j++){	//Creates number of columns
				//Calculates factorial of i
				int a = 1;
				for(z = 0; z < i; z++){
					iFactorial = a * (i-z);
					a = iFactorial;
				}
				//Calculates factorial of j
				int b = 1;
				for(z = 0; z < j; z++){
					jFactorial = b * (j-z); 
					b = jFactorial;
				}
				//Calculates factorial of i-j
				int k = 1;
				for(z = 0; z < (i-j); z++){
					ijFactorial = k * ((i - j) - z);
					k = ijFactorial;
				}
				x = iFactorial / (jFactorial * ijFactorial);
				xcoeff = x;
				
				if(i == 0){
					System.out.print("1");
				}
				else if(i == 1 && j != 0){
					System.out.print("x + y");
				}
				else if (i > 1){
					if(xcoeff > 1){
						System.out.print(xcoeff + "x^" + xpow + "y^" + ypow );
						if(ypow < i){
						System.out.print(" + ");
						}
					}
					else if (xcoeff <= 1){
						System.out.print("x^" + xpow + "y^" + ypow );
						if(ypow < i){
						System.out.print(" + ");
						}
					}
				}
				xpow--;
				ypow++;
			
			}//End of columns
			System.out.println();
		}//End of rows
	}
}
