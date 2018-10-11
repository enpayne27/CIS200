/**
 * (This project will input a file, identify any bit changes, 
 * correct the file to its original formatting, and then print
 * the new image with user selected characters.)
 * 
 * @author (Erin Payne)
 * @version (Project 4)
 * Your lab section (F 7:30AM)
 */
import java.util.*;
import java.io.*;

public class Project4 {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter name of input file: ");
		String fileName = keyboard.nextLine();

		Scanner file = new Scanner(new File(fileName));
		String line = file.nextLine();

		String[] a = line.split("x");
		int rows = Integer.parseInt(a[0]);
		int columns = Integer.parseInt(a[1]);

		int[][] numbers = new int[rows] [columns];
		line = file.nextLine();

		for(int r = 0; r < rows; r++){
			line = file.nextLine();
			for(int c = 0; c < columns; c++){
				numbers[r][c] = Character.getNumericValue(line.charAt(c));
			}
		}

		boolean error = true;
		int numColErrors = 0;
		int numRowErrors = 0;
		int wrongRow = 0;
		int wrongCol = 0;

		while(error == true){
			wrongRow = 0;
			wrongCol = 0;
			for(int r = 0; r <= rows - 2; r++){
				int sum = 0;
				for (int c = 0; c <= columns - 2; c++){
					sum += numbers[r][c];
				}
				sum %= 2;
				//Comparing with parity
				if( sum != numbers [r][columns - 1]){
					wrongRow = r;
					numRowErrors += 1;
				}
			}

			for(int c = 0; c <= columns - 2; c++){
				int sum = 0;
				for(int r = 0; r <= rows - 2; r++){
					sum += numbers[r][c];
				}
				sum %= 2;
				if(sum != numbers[rows - 1][c]){
					wrongCol = c;
					numColErrors += 1;
				}
			}

			if(wrongRow != 0 && wrongCol != 0){
				if(numColErrors <= 1 && numRowErrors <= 1){
					System.out.println("Position (" + wrongRow + "," + wrongCol + ") was modified...correcting");
				}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
			}
			else{
				System.out.print("File corrupted.");
				file.close();
				keyboard.close();
			}

			if(wrongRow != -1 ){
				if (numbers[wrongRow][wrongCol] == 0){
					numbers[wrongRow][wrongCol] = 1;
				}
				else if(numbers[wrongRow][wrongCol] == 1){
					numbers[wrongRow][wrongCol] = 0;
				}
				error = false;
			}
		}

		System.out.print("\nWhat character would you like to use for white? ");
		String whiteCharacter = keyboard.nextLine();

		System.out.print("\nWhat character would you like to use for black? ");
		String blackCharacter = keyboard.nextLine();

		for(int r = 0; r < rows - 1; r++){
			for(int c = 0; c < columns - 2; c++){
				if(numbers[r][c] == 1)
					System.out.print(whiteCharacter);
				else{
					System.out.print(blackCharacter);
				}
			}
			System.out.println();
		}

		file.close();
		keyboard.close();
	}
}
