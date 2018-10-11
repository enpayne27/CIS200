/**
 * This class displays all corresponding print statements.
 * 
 * @author Erin Payne
 * @version Project 7
 * Friday 7:30
 */

import java.util.*;

public class View {
	private Scanner keyboard;
	
	/**
	 * This is the class' main constructor method.
	 */
	public View(){
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Prints statement of player's choices for their turn.
	 *
	 * @return Returns char of which choice user chooses (move, shoot, grab, climb).
	 */
	public char Turn(){
		System.out.print("\nEnter (m)ove, (s)hoot, (g)rab, or (c)limb: ");
		char input = keyboard.nextLine().charAt(0);
		return input;
	}
	
	/**
	 * Prints statement if player chooses to move.
	 *
	 * @return Returns char of the direction in which the player chooses to move.
	 */
	public char Move(){
		System.out.print("Enter (u)p, (d)own, (l)eft, (r)ight: ");
		char input = keyboard.nextLine().charAt(0);
		return input;
	}
	
	/**
	 * Prints statement if player hits a wall of the cave.
	 */
	public void Wall(){
		System.out.println("There is a wall there. Try again");
	}
	
	/**
	 * Prints statement if player chooses to shoot.
	 *
	 * @return Returns a char of the direction in which the user wants to shoot.
	 */
	public char Shoot(){
		System.out.print("Enter (u)p, (d)own, (l)eft, (r)ight: ");
		char input = keyboard.nextLine().charAt(0);
		return input;
	}
	
	/**
	 * Prints statement if player chooses to shoot without any arrows left.
	 */
	public void NoArrows(){
		System.out.println("You have no more arrows. Choose new command.");
	}
	
	/**
	 * Prints statement if player chooses to shoot and kills the wumpus.
	 *
	 * @param Takes in boolean value if the user kills the wumpus.
	 */
	public void Scream(boolean killWumpus){
		if(killWumpus == true){
			System.out.println("You hear a scream.");
		}
	}
	
	/**
	 * Prints statement if player chooses to grab the gold.
	 *
	 * @param Takes in boolean value if the player has hit the gold.
	 */
	public void Grab(boolean hasGold){
		if(hasGold == true){
			System.out.println("You picked up the gold.");
		}
	}
	
	/**
	 * Prints statement if player chooses climb method
	 *
	 * @param Takes in if player is at the cave entrance.
	 */
	public void Climb(boolean entrance){
		if(entrance == true){
			System.out.print("You leave the cave with the ");
		}
		else{
			System.out.println("Error. You have not reached the cave entrance. Try again.");
		}
	}
	
	/**
	 * Prints statement if player is near a pit.
	 */
	public void AdjacentPit(){
		System.out.println("You feel a breeze.");
	}
	
	/**
	 * Prints statement if player is near the wumpus.
	 */
	public void AdjacentWumpus(){
		System.out.println("You smell a stench.");
	}
	
	/**
	 * Prints statement if player has hit the gold.
	 */
	public void Gold(){
		System.out.println("You see a glitter.");
	}
	
	/**
	 * Prints statement if player has hit a wumpus.
	 */
	public void Wumpus(){
		System.out.print("You have been eaten by a Wumpus! You lose.");
	}
	
	/**
	 * Prints statement if player has hit a pit.
	 */
	public void Pit(){
		System.out.print("You have fallen into a pit! You lose.");
	}
	
	/**
	 * Prints statement loss if player has left the cave with the gold but without killing the wumpus.
	 */
	public void noWumpus(){
		System.out.print("gold, but the Wumpus is still alive. You lose.");
	}
	
	/**
	 * Prints statement loss if player has left the cave with the wumpus killed, but without the gold.
	 */
	public void noGold(){
		System.out.print("Wumpus dead, but the gold was not found. You lose.");
	}
	
	/**
	 * Prints statement if player has won.
	 */
	public void Win(){
		System.out.print("gold! The Wumpus is dead. You win!");
	}
}
