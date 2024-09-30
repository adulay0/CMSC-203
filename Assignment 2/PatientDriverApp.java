/*
 * Class: CMSC 203
 * Instructor: Ahmed Tarek
 * Description: This is the Patient Driver App Class. This class creates instances of the Patient and Procedure Classes.
 * It will initialize each class with sample data (self-inputted). It also creates and calls various methods
 * to display patient information, procedure information, and calculate the total charge.
 * Due: 10/02/24
 * Platform/Compiler: Windows Platform, Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Abigail Dulay
 */

public class PatientDriverApp 
{	
	public static void main (String[] args)
	{
		//Creating an instance of the Patient Class.
		//Initializing with random sample data.
			Patient patient = new Patient("Yuki", "M.", "Bao",  "2422 World Ave", "Rockville", "MD", 20851, "301-501-5701", "Aiko Bao", "240-888-0824");
		
		//Now, creating 3 instances of the Procedure class.
		//This will initialize 3 instances of the Procedure class with sample data.
			Procedure procedure1 = new Procedure("Blood Test", "5/22/2024", "Dr. Miles", 350.65);
			Procedure procedure2  = new Procedure("Blood Transfusion", "7/15/2024", "Dr. Sabo", 5450.0);
			Procedure procedure3 = new Procedure("Check-Up", "7/25/2024", "Dr. Reyes", 100.25);
		
		//Call the displayPatient method to print the Patient's information.
			displayPatient(patient); //Passing a patient object to the method.
		
		//Call the displayProcedure method to print 3 procedure's information.
			displayProcedure(procedure1); 
			displayProcedure(procedure2);
			displayProcedure(procedure3);
		
		//Next, call the calculateTotalCharges method to calculate the total charge of the 3 procedures and return the value to be printed.
			double totalCharge = calculateTotalCharges(procedure1, procedure2, procedure3);
		
		//After calculating, display the total charge. (Formatted: Comma separated with two decimal places.
			System.out.printf("\nTotal Charges: $%,.2f.", totalCharge);
		
		//Print student name, M#, and Assignment Due Date to end the program.
			System.out.println("\nStudent Name: Abigail Dulay");
			System.out.println("MC#: M21171921");
			System.out.println("Due Date: 10/2/2024");
			
		//Terminate the background running thread.
			System.exit(0);
	}
	
		//The displayPatient method that will display patient information.
		public static void displayPatient (Patient patientObj)
		{
			System.out.println(patientObj.toString());
		}
		//The displayProcedure method that will display the three instances of the procedure.
		public static void displayProcedure(Procedure proObj)
		{
			System.out.print("\n" + proObj.toString()); //Displays the passed procedure object information.
		}
		//The calculateTotalCharges method that will add the charges of all procedures and display the total.
		public static double calculateTotalCharges(Procedure obj1, Procedure obj2, Procedure obj3)
		{
			double totalCharge;
			totalCharge = obj1.getCharges() + obj2.getCharges() + obj3.getCharges();
			return totalCharge;
		}
}
