import java.io.*;
import java.util.Scanner;

public class SpellChecker {
	ResizeableArray dict = new ResizeableArray();
	public String inputFile;
	
	public SpellChecker(String file) throws IOException{
		Scanner keyboard = new Scanner(System.in);
		Scanner File = new Scanner(new File("lexicon.txt"));
		String userWord;	//User entered word
		String dictionaryWord;	//Comparing word in dictionary

		//Reads in words from file to dictionary.
		while(File.hasNext()){
			String line = File.nextLine();
			if (!(line.equals("")))dict.add(line);
		}
		File.close();
	}
	
	public int distance(String userWord, String dictionaryWord){
		int cost;
		int min;
		int x;
		int y;
		int z;
		int[][]d = new int[userWord.length() + 1][dictionaryWord.length() + 1];
		for(int i = 0; i <= userWord.length(); i++){
			d[i][0] = i;
			for(int j = 0; j <= dictionaryWord.length(); j++){
				if(i == 0) d[0][j] = j;
			}
		}

		for(int i = 1; i <= userWord.length(); i++){
			for(int j = 1; j <= dictionaryWord.length(); j++){
				if(userWord.charAt(i-1) == dictionaryWord.charAt(j-1)){
					cost = 0;
				}
				else{
					cost = 1;
				}

				if((d[i-1][j]+1 <= d[i][j-1]+1) && (d[i-1][j]+1 <= d[i-1][j-1]+cost)) min = d[i-1][j]+1;
				else if(d[i][j-1]+1 <= d[i-1][j-1]+cost) min = d[i][j-1]+1;
				else min = d[i-1][j-1]+cost;

				d[i][j] = min;
			}
		}
		int distance = d[userWord.length()][dictionaryWord.length()];
		return distance;
	}

	public String[] findCorrections(String input){
		int maxErrors = 1 + (input.length() / 5);
		ResizeableArray correctedSentence = new ResizeableArray();
		boolean wordExists = false;

		for(int i = 0; i < dict.size(); i++){
			String dictionaryWord = dict.get(i);
			int distance = distance(input, dictionaryWord);

			if(distance == 0){
				wordExists = true;
			}

			if(distance != 0 && distance <= maxErrors){
				correctedSentence.add(dictionaryWord);
			}
		}

		if(wordExists != true){
			String[] correctedOptions = new String[correctedSentence.size()];

			for(int i = 0; i < correctedOptions.length; i++){
				correctedOptions[i] = correctedSentence.get(i);
			}
			return correctedOptions;
		}
		else{
			return null;
		}
	}

	public void printFile(String inputFile) throws IOException{
		File filename = new File(inputFile);
		FileWriter fw = new FileWriter(inputFile);
		PrintWriter pw = new PrintWriter(fw);
		

		for(int i = 0; i < dict.size(); i++){
			pw.println(dict.get(i));
		}
	}
	
	public void add(String user){
	dict.add(user);
	}
}
