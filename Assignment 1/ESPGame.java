/*
 * Class: CMSC 203
 * Instructor: Ahmed Tarek
 * Description: This is an Assignment 1 - ESP Game program. The public class ESPGame will display an interface, asking user to input
 * data. The game consists simply of the program generating a random color, in which the user must guess the color from a list of choices.
 * Due 9/18/24
 * Platform/Compiler: Windows Platform, Eclipse IDE
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have
 * not given my code to any student.
 * Print your name here: Abigail Dulay
 */

//To be able to use Scanner and Random Objects in program.
import java.util.Scanner;
import java.util.Random;

public class ESPGame {
    public static void main(String[] args) {
//Creating String literals in order to hold color names (constants).
    	final String RED = "Red";
    	final String YELLOW = "Yellow";
    	final String BLUE = "Blue";
    	final String PINK = "Pink";
    	final String PURPLE = "Purple";
//Creating variables to hold user information, user guess input, and # of correct guesses. Also a variable to hold a randomized color.
    	String userName, userInfo, dueDate, userGuess;
    	int correctGuesses = 0; //Initialized to 0.
    	String randColor = null;
//Now, creating a new scanner object that will read user input.
    	Scanner input = new Scanner(System.in);
//Start by asking the user to input their name, self-description, and due date of the assignment.
    	System.out.print("Enter your name: ");
    	userName = input.nextLine();
    	System.out.print("Describe yourself: ");
    	userInfo = input.nextLine();
    	System.out.print("Due Date: ");
    	dueDate = input.nextLine();
//Now, start the ESP Game rounds. Display the round number, generate a random color, and prompt the user to enter their guess.
    	System.out.println("CMSC 203 Assignment 1: Test Your ESP Skills\n");
//Creating a for loop in order to repeat the ESP Game Program for 11 Rounds.
    	for (int i = 0; i < 11 ; i++) {
    		//Display the Round # to the user.
    		System.out.println("Round " + (i+1));
        	//Create a new random object to generate a random number.
        	Random num = new Random();
        	int randNum = num.nextInt(5);
        	//Use a switch case to assign the randomized number to a color. This essentially becomes a random color generator.
        	     switch (randNum) {
        	     case 0: randColor = RED;
        	     break;
        	     case 1: randColor = YELLOW;
        	     break;
        	     case 2: randColor = BLUE;
        	     break;
        	     case 3: randColor = PINK;
        	     break;
        	     case 4: randColor = PURPLE;
        	     break;
        	     }
            //Prompt the user to enter their color guess amongst the given color options.
            System.out.println("I am thinking of a color.");
            System.out.println("Is it Red, Yellow, Blue, Pink, or Purple?");
            System.out.print("Enter your guess: ");
            userGuess = input.nextLine();
        	//Input Validation. Compare the user's guess to the options given to check for colors that were unlisted.
            while (!userGuess.equalsIgnoreCase(RED) && !userGuess.equalsIgnoreCase(YELLOW) && 
            !userGuess.equalsIgnoreCase(BLUE) && !userGuess.equalsIgnoreCase(PINK) && !userGuess.equalsIgnoreCase(PURPLE)) {
            	System.out.println("You entered an incorrect color. Is it Red, Yellow, Blue, Pink, or Purple?");
            	System.out.print("Enter your guess again: ");
            	userGuess = input.nextLine();
            }
            //If user's guess is correct, add to their score of correct guesses.
            if (userGuess.equalsIgnoreCase(randColor)) {
            	correctGuesses += 1;
            }
            System.out.println("I was thinking of " + randColor + ".\n");
             
    	}
//Finish program by displaying the user's # of correct guesses, and the information put in at the start of the program.
    	System.out.println("Game Over\n");
    	System.out.println("You guessed " + correctGuesses + " out of 10 colors correctly.");
    	System.out.println("Student Name: " + userName);
    	System.out.println("User Description: " + userInfo);
    	System.out.println("Due Date: " + dueDate);
    }
}
