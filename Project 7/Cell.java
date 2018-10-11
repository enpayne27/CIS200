/**
 * This class determines the value of each cell.
 * 
 * @author Erin Payne
 * @version Project 7
 * Friday 7:30
 */

public class Cell {
	private boolean wumpus;
	private boolean pit;
	private boolean gold;

	/**
	 * This is the class' main constructor method.
	 *
	 */
	public Cell(){
		wumpus = false;
		pit = false;
		gold = false;
	}

	/**
	 * Cell setter method
	 *
	 * @param Takes in what value is placed in the cell.
	 * @param Determines which value is true for that cell.
	 */
	public void Set(char input, boolean condition){
		switch(input){
		case 'w': wumpus = condition;
		break;

		case 'p': pit = condition;
		break;
		
		case 'g': gold = condition;
		break;
		}
	}
	
	/**
	 * Cell getter method
	 *
	 * @param Takes in what value is placed in the cell.
	 * @return Returns boolean value of which value is true for that cell.
	 */
	public boolean Get(char input){
		switch(input){
		case 'w': return wumpus;
		case 'p': return pit;
		case 'g': return gold;
		default : return false;
		}
	}
}
