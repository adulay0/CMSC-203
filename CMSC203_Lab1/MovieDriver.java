import java.util.Scanner;

public class MovieDriver {

	public static void main (String[] args) {
		
		//Creating the variables to hold movie info.
		String title;
		String rating;
		int soldTickets;
		char choice;
		
		//Creating a new Scanner object.
		Scanner scan = new Scanner(System.in);
		
		do {
			//Prompt the user to enter the movie title.
			System.out.println("Enter the name of a movie: ");
			title = scan.nextLine();
				
			//Prompt the user to enter the movie rating.
			System.out.println("Enter the rating of the movie: ");
			rating = scan.nextLine();
				
			//Prompt the user to enter the number of tickets sold.
			System.out.println("Enter the number of tickets sold for this movie: ");
			soldTickets = scan.nextInt();
				
			//Creating the Movie object after the initialization of data.
			Movie movie = new Movie(title, rating, soldTickets);
				
			//Print the information of the movie using the toString method in the Movie Class.
			System.out.print(movie.toString());
			
			//Ask the user if they would like to continue.
			System.out.println("\nDo you want to enter another? (y or n)");
			choice = scan.next().charAt(0);
			scan.nextLine(); //to clear whitespace.
			
			
		} while (choice == 'y' || choice == 'Y');
		
		//Print "Goodbye" if user does not choose to continue.
		System.out.println("Goodbye");
	}
}
