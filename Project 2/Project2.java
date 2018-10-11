/**
 * This project demonstrates a simplified blackjack game with both user and dealer
 * playing to a total of 21.
 * 
 * @ErinPayne
 * @Project_2
 * Lab E 13228 - F 7:30AM
 */
import java.util.Random;
import java.util.Scanner;

public class Project_2 {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner keyboard = new Scanner(System.in);	
		
		System.out.println("Welcome to the game of Blackjack!");
		System.out.println("Let's begin!");
		System.out.print("\n");								// Prints spacing line
		System.out.println("Now drawing your cards...");
		System.out.print("\n");								// Prints spacing line
		
		int cardCount = 1;
		int dealerTotal = 0;
		int userTotal = 0;
		char decision;
		int userAce = 0;
		int dealerAce = 0;
		
		System.out.println("Dealer has:");
		
		while (cardCount <= 2)
		{
			int suite = r.nextInt(4)+1;
			int card = r.nextInt(13)+1;
			
			switch (card)
			{
            	case 1:
            		System.out.print("\tAce of ");
            		dealerTotal = dealerTotal + 11;
            		dealerAce = dealerAce + 11;
            		if (dealerAce > 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 2:
            		System.out.print("\t2 of ");
            		dealerTotal = dealerTotal + 2;
            		break;
            	case 3:
            		System.out.print("\t3 of ");
            		dealerTotal = dealerTotal + 3;
            		break;
            	case 4:
            		System.out.print("\t4 of ");
            		dealerTotal = dealerTotal + 4;
            		break;
            	case 5:
            		System.out.print("\t5 of ");
            		dealerTotal = dealerTotal + 5;
            		break;
            	case 6:
            		System.out.print("\t6 of ");
            		dealerTotal = dealerTotal + 6;
            		break;
            	case 7:
            		System.out.print("\t7 of ");
            		dealerTotal = dealerTotal + 7;
            		break;
            	case 8:
            		System.out.print("\t8 of ");
            		dealerTotal = dealerTotal + 8;
            		break;
            	case 9:
            		System.out.print("\t9 of ");
            		dealerTotal = dealerTotal + 9;
            		break;
            	case 10:
            		System.out.print("\t10 of ");
            		dealerTotal = dealerTotal + 10;
            		break;
            	case 11:
            		System.out.print("\tJack of ");
            		dealerTotal = dealerTotal + 10;
            		break;
            	case 12:
            		System.out.print("\tQueen of ");
            		dealerTotal = dealerTotal + 10;
            		break;
            	case 13:
            		System.out.print("\tKing of ");
            		dealerTotal = dealerTotal + 10;
            		break;
			}
		
			switch (suite)
			{
				case 1:
					System.out.println("Spades");
					break;
				case 2:
					System.out.println("Clubs");
					break;
				case 3:
					System.out.println("Hearts");
					break;
				case 4:
					System.out.println("Diamonds");
					break;
			}
			cardCount ++;
		}
		System.out.println("Dealer total: " + dealerTotal);
		
		System.out.print("\n");	
		cardCount = 1;
		System.out.println("You have:");
		
		while (cardCount <= 2)
		{
			int suite = r.nextInt(4)+1;
			int card = r.nextInt(13)+1;
			
			switch (card)
			{
            	case 1:
            		System.out.print("\tAce of ");
            		userTotal = userTotal + 11;
            		userAce = userAce + 11;
            		if (userAce > 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 2:
            		System.out.print("\t2 of ");
            		userTotal = userTotal + 2;
            		break;
            	case 3:
            		System.out.print("\t3 of ");
            		userTotal = userTotal + 3;
            		break;
            	case 4:
            		System.out.print("\t4 of ");
            		userTotal = userTotal + 4;
            		break;
            	case 5:
            		System.out.print("\t5 of ");
            		userTotal = userTotal + 5;
            		break;
            	case 6:
            		System.out.print("\t6 of ");
            		userTotal = userTotal + 6;
            		break;
            	case 7:
            		System.out.print("\t7 of ");
            		userTotal = userTotal + 7;
            		break;
            	case 8:
            		System.out.print("\t8 of ");
            		userTotal = userTotal + 8;
            		break;
            	case 9:
            		System.out.print("\t9 of ");
            		userTotal = userTotal + 9;
            		break;
            	case 10:
            		System.out.print("\t10 of ");
            		userTotal = userTotal + 10;
            		break;
            	case 11:
            		System.out.print("\tJack of ");
            		userTotal = userTotal + 10;
            		break;
            	case 12:
            		System.out.print("\tQueen of ");
            		userTotal = userTotal + 10;
            		break;
            	case 13:
            		System.out.print("\tKing of ");
            		userTotal = userTotal + 10;
            		break;
			}
		
			switch (suite)
			{
				case 1:
					System.out.println("Spades");
					break;
				case 2:
					System.out.println("Clubs");
					break;
				case 3:
					System.out.println("Hearts");
					break;
				case 4:
					System.out.println("Diamonds");
					break;
			}
			cardCount ++;
			}
		System.out.println("User total: " + userTotal);
		
		System.out.print("\nEnter (h)it or (s)tay: ");
		decision = keyboard.next().charAt(0);
		
		if (decision == 'h' || decision == 'H'){
			
			System.out.print("\nYou drew: ");
			
			int suite = r.nextInt(4)+1;
			int card = r.nextInt(13)+1;
			
			switch (card)
			{
            	case 1:
            		System.out.print("Ace of ");
            		userTotal = userTotal + 11;
            		userAce = 11;
            		if (userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 2:
            		System.out.print("2 of ");
            		userTotal = userTotal + 2;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 3:
            		System.out.print("3 of ");
            		userTotal = userTotal + 3;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 4:
            		System.out.print("4 of ");
            		userTotal = userTotal + 4;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 5:
            		System.out.print("5 of ");
            		userTotal = userTotal + 5;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 6:
            		System.out.print("6 of ");
            		userTotal = userTotal + 6;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 7:
            		System.out.print("7 of ");
            		userTotal = userTotal + 7;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 8:
            		System.out.print("8 of ");
            		userTotal = userTotal + 8;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 9:
            		System.out.print("9 of ");
            		userTotal = userTotal + 9;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 10:
            		System.out.print("10 of ");
            		userTotal = userTotal + 10;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 11:
            		System.out.print("Jack of ");
            		userTotal = userTotal + 10;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 12:
            		System.out.print("Queen of ");
            		userTotal = userTotal + 10;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
            	case 13:
            		System.out.print("King of ");
            		userTotal = userTotal + 10;
            		if (userTotal > 21 && userAce >= 11)
            		{
            			userTotal = ((userTotal - 11) + 1);
            		}
            		break;
			}
		
			switch (suite)
			{
				case 1:
					System.out.println("Spades");
					break;
				case 2:
					System.out.println("Clubs");
					break;
				case 3:
					System.out.println("Hearts");
					break;
				case 4:
					System.out.println("Diamonds");
					break;
			}
		}
		else if (decision == 's' || decision == 'S')
		{
			System.out.println("\nYou chose to stay.");
		}
		/*// Prints error statement if user types invalid character.
		 * else {
			System.out.println("ERROR. Plese type either \"h\" for hit or \"s\" for stay.");
			System.out.print("\nEnter (h)it or (s)tay: ");
			decision = keyboard.next().charAt(0);
			}
		*/
		
		if (dealerTotal < 17)
		{
			
			System.out.print("Dealer drew: ");
			
			int suite = r.nextInt(4)+1;
			int card = r.nextInt(13)+1;
			
			switch (card)
			{
            	case 1:
            		System.out.print("Ace of ");
            		dealerTotal = dealerTotal + 11;
            		dealerAce = 11;
            		if (dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 2:
            		System.out.print("2 of ");
            		dealerTotal = dealerTotal + 2;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 3:
            		System.out.print("3 of ");
            		dealerTotal = dealerTotal + 3;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 4:
            		System.out.print("4 of ");
            		dealerTotal = dealerTotal + 4;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 5:
            		System.out.print("5 of ");
            		dealerTotal = dealerTotal + 5;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 6:
            		System.out.print("6 of ");
            		dealerTotal = dealerTotal + 6;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 7:
            		System.out.print("7 of ");
            		dealerTotal = dealerTotal + 7;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 8:
            		System.out.print("8 of ");
            		dealerTotal = dealerTotal + 8;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 9:
            		System.out.print("9 of ");
            		dealerTotal = dealerTotal + 9;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 10:
            		System.out.print("10 of ");
            		dealerTotal = dealerTotal + 10;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 11:
            		System.out.print("Jack of ");
            		dealerTotal = dealerTotal + 10;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 12:
            		System.out.print("Queen of ");
            		dealerTotal = dealerTotal + 10;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
            	case 13:
            		System.out.print("King of ");
            		dealerTotal = dealerTotal + 10;
            		if (dealerTotal > 21 && dealerAce >= 11)
            		{
            			dealerTotal = ((dealerTotal - 11) + 1);
            		}
            		break;
			}
		
			switch (suite)
			{
				case 1:
					System.out.println("Spades");
					break;
				case 2:
					System.out.println("Clubs");
					break;
				case 3:
					System.out.println("Hearts");
					break;
				case 4:
					System.out.println("Diamonds");
					break;
			}
		}
		else if (dealerTotal >= 17)
		{
			System.out.println("Dealer stays.");
		}

			System.out.println("\nYour total: " + userTotal);
			System.out.println("Dealer total: " + dealerTotal);
		
		if ((dealerTotal > userTotal && dealerTotal <= 21) || (userTotal > 21 && dealerTotal <= 21))
		{
			System.out.print("\nDealer wins.");
		}
		else if ((userTotal > dealerTotal && userTotal <= 21) || (dealerTotal > 21 && userTotal <= 21))
		{
			System.out.print("\nYou win!");
		}
		else if (userTotal == dealerTotal && userTotal <= 21)
		{
			System.out.print("\nYou win!");
		}
		else if (userTotal > 21 && dealerTotal > 21)
		{
			System.out.print("\nNo winner. :(");
		}
		else
		{
			System.out.print("\nERROR");
		}
	}
}