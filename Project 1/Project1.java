/**
 *This program will ask the user for the current time
 *and a time delay value, then calculate the new time
 *with given delay.
 *
 * @author (Erin Payne)
 * @version (Project 1)
 */
import java.text.*;
import java.util.*;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);		// Scanner for holding input
		DecimalFormat df = new DecimalFormat("#00");
		
		int hour = 0;		// Holds current hours
		int minute = 0;		// Holds current minutes
		int second = 0;		// Holds current seconds
		
		int delayHour = 0;		// Holds hours to delay
		int delayMinute = 0;	// Holds minutes to delay
		int delaySecond = 0;	// Holds seconds to delay
		
		int finalHour = 0;
		int finalMinute = 0;
		int finalSecond = 0;
		
		System.out.print("Enter the current hour (1-12): ");
		hour = keyboard.nextInt();		// Reads in user hours
		while (hour < 1 || hour > 12) 	// Operates with hours other than 1-12
		{
			System.out.println("Invalid.");
			System.out.print("Enter the current hour (1-12): ");
			hour = keyboard.nextInt();		// Reads in user hours
		}
		if (hour >= 1 || hour <= 12) 	// Operates with hours 1-12
		{
			System.out.print("Enter the current minutes (0-59): ");
			minute = keyboard.nextInt();	// Read in user minutes
		}
		while (minute < 0 || minute > 59) // Operates with minutes other than 0-59
		{
			System.out.println("Invalid number.");
			System.out.print("Enter the current minutes (0-59): ");
			minute = keyboard.nextInt();	// Read in user minutes
		}
		if (minute >= 0 || minute <= 59) {
			System.out.print("Enter the current seconds (0-59): ");
			second = keyboard.nextInt();	// Reads in user seconds
		}
		while (second < 0 || second > 59) {
			System.out.println("Invalid number.");
			System.out.print("Enter the current seconds (0-59): ");
			second = keyboard.nextInt();	// Read in user seconds
		}
		if (second >= 0 || second <= 59) {
			System.out.print("\n");	// Prints spacing line
			System.out.print("Enter the number of hours to delay: ");
			delayHour = keyboard.nextInt();	// Reads in user  delayed hours
			System.out.print("Enter the number of minutes to delay: ");
			delayMinute = keyboard.nextInt();	// Reads in user delayed minutes
			System.out.print("Enter the number of seconds to delay: ");
			delaySecond = keyboard.nextInt();	// Reads in user delayed seconds
		}
		
		int newHour = hour + delayHour;			// Calculates current hour w/delay 
		int newMinute = minute + delayMinute;	// Calculates current minutes w/delay
		int newSecond = second + delaySecond;	// Calculates current seconds w/delay
		
		if (newSecond > 59){
			finalSecond = newSecond % 60;				// Gives remaining seconds
			newMinute = newMinute + (finalSecond / 60);		// Adds remaining seconds to current minute
		}
		if (newMinute > 59){
			finalMinute = newMinute % 60;				// Gives remaining minutes
			newHour = newHour + (finalMinute / 60);			// Adds remaining minutes to current hour 
		}
		if (newHour > 12){
				finalHour = newHour % 12;				// Gives remaining hours
				newHour = newHour + (finalHour / 12);		// Adds remaining hours to current hour
		}
		
		
		if (newSecond >= 60){		// If final display number reaches 60
			newMinute ++;			// Increments minutes
			newSecond = newSecond % 60;		// Returns to zero
		}	
		if (newMinute >= 60){		// If final display number reaches 60
			newHour ++;			// Increments hours
			newMinute = newMinute % 60;		// Returns to zero
		}
		if (newHour >= 12){		// If final display number reaches 60			
			newHour ++;			// Increments hours
			newHour = newHour % 12;		// Returns to zero
			
		}
		
		System.out.print("\n"); // Prints spacing line
		
		System.out.println("It is currently " + df.format(hour) + ":" + df.format(minute) + ":" + df.format(second) + ".");
		System.out.print(" A delay of " + delayHour + " hour(s), " + delayMinute + " minute(s), " + delaySecond + " second(s) will make the new time: ");
		System.out.println(df.format(newHour) + ":" + df.format(newMinute) + ":" + df.format(newSecond) + ".");
	}

}

