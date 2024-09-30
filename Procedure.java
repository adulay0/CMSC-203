/*
 * Class: CMSC 203
 * Instructor: Ahmed Tarek
 * Description: This is the Procedure Class. This class contains various fields for procedure information including
 * procedure name, date, and charges, as well as the practitioner name. This class has 3 constructors,
 * accessor and mutator methods for each attribute, and a toString method that will be used
 * to display procedure information.
 * Due: 10/02/24
 * Platform/Compiler: Windows Platform, Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Abigail Dulay
 */

public class Procedure 
{
		//Creating the fields required for the procedure information.
		private String procedureName;
		private String procedureDate;
		private String practitionerName;
		private double procedureCharges;
		
		//The required no-arg constructor --- Constructor 1
		public Procedure (){
		}
		
		//The parameterized constructor that initializes procedure name and date. ---Constructor 2
		public Procedure (String procName, String procDate)
		{
			procedureName = procName;
			procedureDate = procDate;
		}
		
		//The parameterized constructor that initializes all procedure attributes. --- Constructor 3
		public Procedure (String procName, String procDate, String practitioner, double charges)
		{
			procedureName = procName;
			procedureDate = procDate;
			practitionerName = practitioner;
			procedureCharges = charges;
		}
		
		//The mutators/setter methods for each attribute.
		public void setProcedureName(String procedureName)
		{
			this.procedureName = procedureName;
		}
		public void setProcedureDate (String procedureDate)
		{
			this.procedureDate = procedureDate;
		}
		public void setPractitionerName(String practitionerName)
		{
			this.practitionerName = practitionerName;
		}
		public void setProcedureCharges (double procedureCharges)
		{
			this.procedureCharges = procedureCharges;
		}
		
		//The accessor/getter methods for each attribute.
		public String getProcedureName()
		{
			return procedureName;
		}
		public String getProcedureDate()
		{
			return procedureDate;
		}
		public String getPractitionerName()
		{
			return practitionerName;
		}
		public double getCharges()
		{
			return procedureCharges;
		}
		
		//The toString method to display all the procedure information.
		public String toString()
		{
			return ("\t\tProcedure: " + procedureName +
							"\n\t\tProcedure Date: " + procedureDate +
							"\n\t\tPractitioner: " + practitionerName + 
							"\n\t\tCharge: " + procedureCharges + "\n");
		}
		
		
}
