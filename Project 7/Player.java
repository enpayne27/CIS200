/**
 * This class tracks the player's current state.
 * 
 * @author Erin Payne
 * @version Project 7
 * Friday 7:30
 */

public class Player {
	private boolean goldCount;
	private boolean arrowCount;
	private int curRow;
	private int curCol;
	
	/**
	 * This is the class' main constructor method.
	 *
	 * @param Takes in player's row.
	 * @param Takes in player's column.
	 */
	public Player(int r, int c){
		goldCount = false;
		arrowCount = true;
		curRow = r;
		curCol = c;
	}

	/**
	 * Player set method.
	 *
	 * @param Takes in player's gold and arrow values.
	 * @param Determines condition of whether player has gold or arrow.
	 */
	public void Set(char input, boolean condition){
		switch(input){
		case 'g': goldCount = condition;
		break;

		case 'a': arrowCount = condition;
		break;
		}
	}
	
	/**
	 * Player position set method.
	 *
	 * @param Takes in player's current row.
	 * @param Takes in player's current column.
	 */
	public void SetPosition(char input, int position){
		switch(input){
		case 'r': curRow = position;
		break;

		case 'c': curCol = position;
		break;
		}
	}
	
	/**
	 * Player get method.
	 *
	 * @param Takes in player's gold and arrow values.
	 * @return Returns boolean value of whether player has gold or arrow.
	 */
	public boolean Get(char input){
		switch(input){
		case 'g': return goldCount;
		case 'a': return arrowCount;
		default : return false;
		}
	}
	
	/**
	 * Player get position method.
	 *
	 * @param Takes in which position value to return.
	 * @return Returns current row or column.
	 */
	public int getPosition(char input){
		switch(input){
		case 'r': return curRow;
		case 'c': return curCol;
		default : return 0;
		}
	}
	
}
