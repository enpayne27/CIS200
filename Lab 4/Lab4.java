import java.util.*;

public class Lab4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();

		char[][] board = new char[5][5]; 
		//sets entire board to 'e' --> empty 
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j < 5; j++) {
				board[i][j] = 'e';
			}
		} 

		int spot, row, col; 

		//randomly place three pits ('p' --> pit)
		//if random value is duplicated, there may be fewer than three pits.That's OK.
		for (int i = 0; i < 3; i++) {
			spot = r.nextInt(24)+1; 
			row = spot / 5; 
			col = spot % 5; 
			board[row][col] = 'p'; 
		}

		//randomly place two Wumpii ('w' --> Wumpus) 
		//if random value is duplicated, there may be just one Wumpus. That's OK.
		for (int i = 0; i < 3; i++) {
			spot = r.nextInt(24)+1; row = spot / 5; 
			col = spot % 5; 
			board[row][col] = 'w'; 
		}

		//randomly places one gold spot ('g' --> gold) 
		//spot will be from 1-24 -- we don't want 0 because that's where user will start
		spot = r.nextInt(24)+1;
		row = spot / 5; 
		col = spot % 5; 
		board[row][col] = 'g';

		//start user at spot (0,0)
		row = 0;
		col = 0;
		//cur keeps track of what is at the current row/col.
		//it will be either 'e', 'g', 'p', or 'w' 
		char cur = board[row][col];

		//while the user hasn't hit gold, pit, or wampus
		while (cur == 'e') {
			cur = board[row][col];
			for (int i = 0; i < 5; i++) { 
				for (int j = 0; j < 5; j++) {
					/*if(i==row && j==col){	
						System.out.print("O");	//Prints character
					}
					else{
						System.out.print(board[i][j]);
					}*/
				}
				//System.out.println();
			}

			//System.out.println();
			System.out.println("Current position: " + row + "," + col);	//Prints current position

			//Determines if player has won, lost or continues.
			switch(cur){
			case 'g': System.out.print("You win.");
			break;

			case 'w':
			case 'p': System.out.print("You lose.");
			break;
			default:
				char[] adj = new char [4];

				if(row > 0) adj[0] = board[row-1][col];	//Checks above
				else adj[0] = 'e';

				if(row < 4) adj[1] = board[row+1][col];	//Checks below
				else adj[1] = 'e';

				if(col > 0) adj[2] = board[row][col-1];	//Checks left
				else adj[2] = 'e';

				if(col < 4) adj[3] = board[row][col+1];	//Checks right
				else adj[3] = 'e';

				for(int i = 0; i < 4; i++){
					switch(adj[i]){

					case 'g':
						System.out.println("I see a glitter.");	//if an adjacent cell has a 'g' (gold) 
						break;

					case 'p':
						System.out.println("I feel a breeze.");	//if an adjacent cell has a 'p' (pit)
						break;

					case 'w':
						System.out.println("I smell a stench."); //if an adjacent cell has a 'w' (Wumpus) 
						break;
					}

				}

				System.out.print("\nEnter (u)p, (d)own, (l)eft, (r)ight: ");

				switch(s.nextLine().charAt(0)){
				case 'u':
					if(row > 0)row--;
					break;
				case 'd':
					if(row < 4)row++;
					break;
				case 'l':
					if(col > 0)col--;
					break;
				case 'r':
					if(col < 4)col++;
					break;
				}
			}
		}

	}

}
