/**
 * This class sets up the main game board.
 * 
 * @author Erin Payne
 * @version Project 7
 * Friday 7:30
 */

import java.util.*;

public class Board {
	private Cell[][] cellBoard;
	private View v;
	private int spot, row, col;
	private int rowSize;
	private int colSize;
	private Player Player1;
	private boolean wumpusKill;
	private boolean goldCount;
	
	/**
	 * This is the class' main method.
	 *
	 */
	public Board(){
		Player1 = new Player(rowSize-1,0);
		Random r = new Random();
		v = new View();
		
		
		//Set board array
		//Chooses random array size between 4-6
		rowSize = r.nextInt(3) + 4;
		colSize = r.nextInt(3) + 4;
		int boardSize = rowSize * colSize;
		cellBoard = new Cell[rowSize][colSize];
		//char[][] board = new char[rowSize][colSize];

		//Sets entire board to 'e'mpty
		for (int i = 0; i < rowSize; i++) { 
			for (int j = 0; j < colSize; j++) {
				cellBoard[i][j] = new Cell();
				//board[i][j] = 'e';
			}
		}

		//randomly place three 'p'its
		for (int i = 0; i < 3; i++) {
			spot = r.nextInt(boardSize); 
			row = spot / rowSize; 
			col = spot % colSize; 
			cellBoard[row][col].Set('p', true);
			//board[row][col] = 'p';
		}

		//randomly places one Wumpus spot
		//we don't want 0 because that's where user will start
		do{
		spot = r.nextInt(boardSize);
		row = spot / rowSize; 
		col = spot % colSize; 
		}while (row < rowSize && col < colSize && cellBoard[row][col].Get('g'));
		cellBoard[row][col].Set('w', true);
		//board[row][col] = 'w';
		
		//randomly places one gold spot ('g' --> gold) 
		//spot will be from 1-24 -- we don't want 0 because that's where user will start
		do{
		spot = r.nextInt(boardSize);
		row = spot / rowSize; 
		col = spot % colSize; 
		}while (row < rowSize && col < colSize && (cellBoard[row][col].Get('w') || cellBoard[row][col].Get('p')));
		cellBoard[row][col].Set('g', true);
		//board[row][col] = 'g';
		row = rowSize -1;
		col = 0;
		
		//char cur = board[row][col];
		
		/*while (cur == 'e') {
			//cur = board[row][col];
			for (int i = 0; i < rowSize; i++) { 
				for (int j = 0; j < colSize; j++) {
					if(i==row && j==col){	
						System.out.print("O");	//Prints character
					}
					else{
						System.out.print(board[i][j]);
					}
				}
				System.out.println();
			}*/
		
	}
	
	/**
	 * Checks adjacent cells to determine which print method to use.
	 *
	 */
	public void effects() {
		char[] adj = new char [4];

		//Checks above
		if(row > 0) {
			if (cellBoard[row-1][col].Get('w')) {
				adj[0] = 'w';
			}
			if (cellBoard[row-1][col].Get('p')) {
				adj[0] = 'p';
			}
		}
		else adj[0] = 'e';

		//Checks below
		if(row < rowSize-1) {
			if (cellBoard[row+1][col].Get('w')) {
				adj[1] = 'w';
			}
			if (cellBoard[row+1][col].Get('p')) {
				adj[1] = 'p';
			}
		}
		else adj[1] = 'e';

		//Checks left
		if(col > 0) {
			if (cellBoard[row][col-1].Get('w')) {
				adj[2] = 'w';
			}
			if (cellBoard[row][col-1].Get('p')) {
				adj[2] = 'p';
			}
		}
		else adj[2] = 'e';

		//Checks right
		if(col < colSize-1) {
			if (cellBoard[row][col+1].Get('w')) {
				adj[3] = 'w';
			}
			if (cellBoard[row][col+1].Get('p')) {
				adj[3] = 'p';
			}
		}
		else adj[3] = 'e';
		
		for(int i = 0; i < 4; i++){
			switch(adj[i]){
			case 'p':
				v.AdjacentPit();
				break;

			case 'w':
				v.AdjacentWumpus();
				break;
			}
		}
		if (cellBoard[row][col].Get('g')) {
			v.Gold();
		}
	}
	
	/**
	 * Move method function.
	 *
	 * @param Takes in what user move direction is (left, right, up, down).
	 * @return Returns boolean value if move is in or out of bounds.
	 */
	public boolean Move(char input){
		switch(input){
		case 'U':
		case 'u':
			if(row > 0) {
				row--;
				Player1.SetPosition('r', row);
				return true;
			}
			else {
				v.Wall();
				return false;
			}

		case 'D':
		case 'd':
			if(row < rowSize-1) {
				row++;
				Player1.SetPosition('r', row);
				return true;
			}
			else {
				v.Wall();
				return false;
			}
			
		case 'L':
		case 'l':
			if(col > 0){
				col--;
				Player1.SetPosition('c', col);
				return true;
			}
			else {
				v.Wall();
				return false;
			}

		case 'R':
		case 'r':
			if(col < colSize-1){
				col++;
				Player1.SetPosition('c', col);
				return true;
			}
			else {
				v.Wall();
				return false;
			}
		default: return false;
		}
	}
	
	/**
	 * Shoot method function.
	 *
	 * @param Takes in user's selected direction to shoot.
	 */
	public void Shoot(char input){
		switch(input){
		case 'U':
		case 'u':
			for(int i = row; i > 0; i--) {
				if(cellBoard[i][col].Get('w')){
					v.Scream(true);
					wumpusKill = true;
					cellBoard[i][col].Set('w', false);
				}
			}

		case 'D':
		case 'd':
			for(int i = row; i < rowSize; i++) {
				if(cellBoard[i][col].Get('w')){
					v.Scream(true);
					wumpusKill = true;
					cellBoard[i][col].Set('w', false);
				}
			}
			
		case 'L':
		case 'l':
			for(int i = col; i > 0; i--) {
				if(cellBoard[i][col].Get('w')){
					v.Scream(true);
					wumpusKill = true;
					cellBoard[i][col].Set('w', false);
				}
			}

		case 'R':
		case 'r':
			for(int i = col; i < colSize; i++) {
				if(cellBoard[i][col].Get('w')){
					v.Scream(true);
					wumpusKill = true;
					cellBoard[i][col].Set('w', false);
				}
			}
		}
		Player1.Set('a', false);
	}
	
	/**
	 * Grab function method.
	 *
	 * @return Returns if player has successfully grabbed the gold.
	 */
	public void Grab(){
		if (cellBoard[row][col].Get('g')) {
			cellBoard[row][col].Set('g', false);
			v.Grab(true);
			goldCount = true;
			Player1.Set('g', true);
		}
	}
	
	/**
	 * Climb function method
	 *
	 * @return Returns boolean of whether player can climb out or not.
	 */
	public boolean Climb(){
		if(row == rowSize-1 && col == 0) {
			v.Climb(true);
			if(wumpusKill == true && goldCount == true){
				v.Win();
			}
			else if(wumpusKill == false && goldCount == true){
				v.noWumpus();
			}
			else if(wumpusKill == true && goldCount == false){
				v.noGold();
			}
			return false;
		}
		else {
			v.Climb(false);
			return true;
		}
	}
	
	/**
	 * Gets row size
	 *
	 * @return Returns row array size
	 */
	public int getRow() {
		return rowSize;
	}
	
	/**
	 * Gets column size
	 *
	 * @return Returns column array size
	 */
	public int getCol() {
		return colSize;
	}
	
	/**
	 * Gets current row position.
	 *
	 * @return Returns current row position.
	 */
	public int getCurRow() {
		return Player1.getPosition('r');
	}
	
	/**
	 * Gets current column position. 
	 *
	 * @return Returns current column position.
	 */
	public int getCurCol() {
		return Player1.getPosition('c');
	}
	
	/**
	 * Checks if the player has lost.
	 *
	 * @return Returns boolean of whether game ends or continues.
	 */
	public boolean checkDead(){
		if(cellBoard[row][col].Get('p') == true){
			v.Pit();
			return true;
		}
		if(cellBoard[row][col].Get('w') == true){
			v.Wumpus();
			return true;
		}
		else return false;
	}

}