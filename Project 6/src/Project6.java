/**
 * This project allows a user to input a sentence to be corrected, provides the user with
 * possible corrected words, the option to ignore the error, or the option to add a word
 * to the user's dictionary.
 * 
 * @author Erin Payne
 * @version Project 6
 * Friday 7:30AM
 */
import java.io.*;
import java.util.*;

public class Project6 {
	/**
	 * This is the main method to guide the program through each of it's steps
	 *
	 * @param Input file
	 */
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		String inputFile = "lexicon.txt";
		SpellChecker sc = new SpellChecker("lexicon.txt");
		String sentence = " ";
		boolean addWord = false;
		
		while(!sentence.isEmpty()){
			System.out.print("Enter a sentence (press enter to quit): ");
			sentence = keyboard.nextLine();
			System.out.println();
			ArrayList<String> userInput = new ArrayList<String>();
			
			if(sentence.equals("")){
				sentence = keyboard.nextLine();
				addWord = true;
			}
			else{
				System.out.println("");
				StringTokenizer st = new StringTokenizer(sentence, " ,.;:()-?!/&", true);
				
				while(st.hasMoreTokens()){
						String token = st.nextToken();
						userInput.add(token);
				}
				
				for(int i = 0; i < userInput.size(); i++){
					String[] corrections = sc.findCorrections(userInput.get(i));
					String test = userInput.get(i);
					
					if((int)test.charAt(0) >= 65 && (int)test.charAt(0) <= 122){
						if(corrections != null){
							System.out.println("I don't have an entry for " + userInput.get(i) + ".");
							System.out.println("Did you mean one of these words?");
							System.out.println("");
							
							for(int j = 0; j < corrections.length + 2; j++){
								if(j < corrections.length){
									System.out.println("(" + (j + 1) +") " + corrections[j]);
								}
								else if(j == corrections.length){
									System.out.println("(" + (j + 1) +") " + "Ignore word");
								}
								else if(j == corrections.length + 1){
									System.out.println("(" + (j + 1) +") " + "Add to dictionary");
								}
							}
							System.out.println("");
							System.out.print("Enter the line number of the correction: ");
							int lineNumber = keyboard.nextInt() - 1;
							System.out.println("");
							if(lineNumber < corrections.length){
								userInput.set(i, corrections[lineNumber]);
							}
							else if(lineNumber == corrections.length + 1){
								sc.dict.add(userInput.get(i));
								addWord = true;
							}
						}
					}
				}
				System.out.println("Spell checked: ");
				
				for(int i = 0; i < userInput.size(); i++){
					System.out.print(userInput.get(i));
				}
				System.out.println("\n");
			}
		}
		if(addWord == true){
			System.out.print("\nDo you want to update the file " + inputFile + " to add your new " + "words? (y/n): ");
			String userInput = keyboard.nextLine();
			
			if(userInput.toLowerCase().equals("y")){
				sc.printFile(inputFile);
				sc.add(userInput);
			}
			System.out.println("");
		}
		keyboard.close();
		System.exit(0);
	}
}
