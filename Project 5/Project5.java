
/**
 * (The game of Reversi (aka Othello))
 * 
 * @author (Erin Payne)
 * @version (Project 5)
 * Your lab section (Friday 7:30AM)
 */import java.util.*;
public class Project5 {
	public static void main(String[] args) {
		String[][] board = {
				{" ","1","2","3","4","5","6","7","8"}, 
				{"1"," "," "," "," "," "," "," "," "}, 
				{"2"," "," "," "," "," "," "," "," "}, 
				{"3"," "," "," "," "," "," "," "," "}, 
				{"4"," "," "," ","W","B"," "," "," "}, 
				{"5"," "," "," ","B","W"," "," "," "}, 
				{"6"," "," "," "," "," "," "," "," "}, 
				{"7"," "," "," "," "," "," "," "," "}, 
				{"8"," "," "," "," "," "," "," "," "}
		};
		Scanner keyboard = new Scanner(System.in);
		System.out.println();
		int playerMove = 0;	//Variable for determining which player's turn it is.
		char playerColor = 'B';
		char oppositeColor = 'W';
		boolean gameOver = false;
		boolean forfeit = false;
		int blackCount = 0;
		int whiteCount = 0;

		//Prints board
		while(!gameOver){
			blackCount = 0;
			whiteCount = 0;
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board.length; j++){
					if(board[i][j].equals("B")){
						blackCount++;
					}
					if(board[i][j].equals("W")){
						whiteCount++;
					}
					System.out.print(" " + board[i][j] + " |");
				}
				System.out.println();
				System.out.println("------------------------------------");
			}
			System.out.print("Black:" + blackCount);
			System.out.println("   White:" + whiteCount);
			
			String player = playerTurn(playerMove, playerColor, oppositeColor);
			System.out.print("\nEnter row, column of " + player +" move (Press enter to forfeit): ");
			playerColor = setToken(player);
			String userMove = keyboard.nextLine();
			
			//Checks forfeits
			if(userMove.equals("")){
				if(forfeit){
					gameOver = true;
				}
				else{
					forfeit = true;
					playerMove ++;
				}
			}
			else{
				forfeit = false;
				//Verifies validity of player move before allowing next player turn.
				if(moveCheck(board, userMove, playerMove, playerColor)){
					playerMove++;
				}
			}
		}
		//Prints final Game Over output
		System.out.println("Game Over");
		System.out.println("Black:" + blackCount);
		System.out.println("White:" + whiteCount);
		if(blackCount > whiteCount){
			System.out.print("Winner: Black");
		}
		else if(whiteCount > blackCount){
			System.out.print("Winner: White");
		}
		else{
			System.out.print("Winner: Tie");
		}
	}

	//Method checks for black or white turn.
	public static String playerTurn(int playerMove, char playerColor, char oppositeColor){
		if(playerMove % 2 == 0){
			playerColor = 'B';
			oppositeColor = 'W';
			return "black";
		}
		else{
			playerColor = 'W';
			oppositeColor = 'B';
			return "white";
		}
	}
	
	//Sets player turn
	public static char setToken(String player) {
		if (player.equals("black")) return 'B';
		else return 'W';
	}

	//Method for checking that user inputed move is on the board.
	public static boolean moveCheck(String[][] board, String userMove, int playerMove, char playerColor){
		StringTokenizer input = new StringTokenizer(userMove, ",");
		int userRow = Integer.parseInt(input.nextToken());
		int userColumn = Integer.parseInt(input.nextToken());

		//Checks that inputed move from user is within board's bounds.
		if((userRow > 0 && userColumn > 0) && (userRow < 9 && userColumn < 9)){
			//Checks if blank space on board.
			if(blankSpot(board, userRow, userColumn)){
				//Checks adjacent cells.
				if(adjacentCheckLoop(board, userRow, userColumn, playerColor) > 0){
					if(playerMove % 2 == 0){
						board[userRow][userColumn] = "B";
					}else{
						board[userRow][userColumn] = "W";
					}
					return true;
				}else{
					System.out.println("Invalid move. Please chose adjacent cell.");
					return false;
				}
			}else{
				System.out.println("Invalid move. Please chose a blank space.");
				return false;
			}
		}else{
			System.out.print("Invalid move, must choose a position inside the board.");
			return false;
		}
	}

	//Checks that inputed move from user is a blank spot.
	public static boolean blankSpot(String[][]board, int userRow, int userColumn){
		if(board[userRow][userColumn].equals(" ")){
			return true;
		}
		else{
			return false;
		}
	}
	//Checks that inputed move is adjacent to a currently placed piece.
	public static int adjacentCheck(String[][]board, int rowNext, int colNext, int userRow, int userColumn, char oppositeColor, char playerColor){
		//If adjacent spot is not same color...
		int flip = 0;
		if((board[userRow + rowNext][userColumn + colNext]).charAt(0) == oppositeColor){		
			int originalRow = userRow;
			int originalColumn = userColumn;
			userRow = userRow + rowNext;
			userColumn = userColumn + colNext;
			flip = 1;
			boolean flipCheck = false;
			
			//While next position is within the board, not blank, and the opposite color...
			while(((userRow) > 0 && (userColumn) > 0) && ((userRow) < 9 && (userColumn) < 9) && !blankSpot(board, userRow, userColumn) && !flipCheck ){
				if((board[userRow][userColumn]).charAt(0) == playerColor){
					flipCheck = true;
				}
				else{
					flip++;
					userRow = userRow + rowNext;
					userColumn = userColumn + colNext;
				}
			}
			//Checks next position until reaches position of same color.
			if(flipCheck){
				for(int i = 1; i <= flip; i++){
					userRow = userRow - rowNext;
					userColumn = userColumn - colNext;
					board[userRow][userColumn] = Character.toString(playerColor);
				}
				userRow = originalRow;
				userColumn = originalColumn;
				//System.out.println("flipTrue: " + flip);
				return flip;
			}
			else{
				userRow = originalRow;
				userColumn = originalColumn;
				//System.out.println("flipFalse: " + flip);
				return 0;
			}
		}
		else{
			return 0;
		}

	}

	//Checks surround 8 adjacent cells to current position.
	public static int adjacentCheckLoop(String[][]board, int userRow, int userColumn, char playerColor){
		char oppositeColor = ' ';
		if (playerColor == 'B') oppositeColor = 'W';
		else oppositeColor = 'B';
		int flip = 0;
		flip += (adjacentCheck(board, -1, -1, userRow, userColumn, oppositeColor, playerColor));
		flip += (adjacentCheck(board, -1, 0, userRow, userColumn, oppositeColor, playerColor));
		flip += (adjacentCheck(board, -1, 1, userRow, userColumn, oppositeColor, playerColor));
		flip += (adjacentCheck(board,  0, -1, userRow, userColumn, oppositeColor, playerColor));
		flip += (adjacentCheck(board,  0, 1, userRow, userColumn, oppositeColor, playerColor));
		flip += (adjacentCheck(board,  1, -1, userRow, userColumn, oppositeColor, playerColor));
		flip += (adjacentCheck(board,  1, 0, userRow, userColumn, oppositeColor, playerColor));
		flip += (adjacentCheck(board,  1, 1, userRow, userColumn, oppositeColor, playerColor));
		if(flip == 0){
			System.out.println("Invalid move. No capture.");
		}
		return flip;
	}

}