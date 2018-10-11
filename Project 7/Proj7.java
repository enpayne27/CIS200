/**
 * This class allows the game to properly run through each step of the game.
 * 
 * @author Erin Payne
 * @version Project 7
 * Friday 7:30
 */

public class Proj7 {
	/**
	 * This is the class' main constructor method.
	 */
	public static void main(String args[]){
		View v = new View();
		Board b = new Board();
		boolean game = true;
		char[][] board = new char[b.getRow()][b.getCol()];
		while (b.checkDead() == false) {
			b.effects();
			char input = v.Turn();

			switch(input){
			case 'M':
			case 'm':
				input = v.Move();
				b.Move(input);
				break;

			case 'S':
			case 's':
				input = v.Shoot();
				b.Shoot(input);
				break;
				
			case 'G':
			case 'g':
				b.Grab();
				break;

			case 'C':
			case'c':
				game = b.Climb();
				break;
			}
		}
	}
}
