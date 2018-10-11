import java.util.*;
import java.io.*;

public class Lab_6 {

	public static void main (String[] args)throws IOException{
		FileReader fl = new FileReader("lab6nums.txt");
		int Total = 0;
		String line = "";
		String[] answer;
		try (BufferedReader br = new BufferedReader(new FileReader("lab6nums.txt"))){
			while((line = br.readLine()) !=null) {
				answer = line.split(" ");
				int something[] = printArray(answer);
				int myline = sumNumbers(something);
				
				System.out.println("Line Sum: " + myline + " Range Sum: " + Range(something));
				Total += myline;
			}
		}catch(IOException e){
			
		}
		String line = s.nextLine();
		
		printArray(line, answer);
		
	}
	
	public static int[] printArray (String[] line2){
		int[] numbers = new int [line2.length];
		
		for (int i = 0; i < line2.length; i++){
			numbers[i] = Integer.parseInt(line2[i]);
		}
		return numbers;
	}
	
	public static int sumNumbers(int[] n) {
		int sum = 0;
		//Scanner keyboard = new Scanner(System.in);
		
		for(int i = 0; i < n.length; i++){
			//System.out.print("Enter an integer: ");
			sum = sum + n[i];
		}
		return sum;
	}
	
	public static int rangeNumbers(int[] n) {
		int max = 0;
		int min = n[0];
		int range = 0;
		
		for (int i = 0; i < n.length; i++) {
			if (n[i] < min) {
				min = n[i];
			}
			else if (n[i] > max) {
				max = n[i];
			}
		}
		range = max - min;
		return range;
	}
}
