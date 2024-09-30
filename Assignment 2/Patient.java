/*
 * Class: CMSC 203
 * Instructor: Ahmed Tarek
 * Description: This is the Patient Class. This class contains various fields for patient information
 * including name, address, phone number, and emergency contacts. By Assignment 2 requirements, 
 * this class has constructors, accessors, mutators, and various methods.
 * Due: 10/02/24
 * Platform/Compiler: Windows Platform, Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Abigail Dulay
 */
public class Patient 
{
	//Create the fields for patient information.
	private String firstName;
	private String  middleName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private String patientNumber;
	
	//Creating fields for emergency contact information.
	private String emergencyName;
	private String emergencyNumber;
	
	//The required no-arg constructor --- Constructor 1
	public Patient() {
		}
	
	//The parameterized constructor that initializes the fields for the patient name. --- Constructor 2
	public Patient (String firstName, String middleName, String lastName)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	//The parameterized constructor, initializing all attributes of the patient to given values. --- Constructor 3
		public Patient (String fName, String mName, String lName, String addr, String cit, String st, int zip, String number, String emergName, String emergNum)
		{
			firstName = fName;
			middleName = mName;
			lastName = lName;
			patientNumber = number;
			address = addr;
			city = cit;
			state = st;
			zipCode = zip;
			emergencyName = emergName;
			emergencyNumber = emergNum;
		}
	
	//The mutator/setter methods for the Patient Info.
	//I utilize the this keyword to differentiate between instance variables.
	public void setFirstName (String firstName)
		{
			this.firstName = firstName;
		}
	public void setMiddleName (String middleName)
		{
			this.middleName = middleName;
		}
	public void setLastName (String lastName)
		{
			this.lastName = lastName;
		}
	public void setAddress (String address)
		{
			this.address = address;
		}
	public void setCity (String city)
		{
			this.city = city;
		}
	public void setState (String state)
		{
			this.state = state;
		}
	public void setZipCode (int zipCode)
		{
			this.zipCode = zipCode;
		}
	public void setPatientNumber (String patientNumber)
		{
			this.patientNumber = patientNumber;
		}
	public void setEmergencyName (String emergencyName)
		{
			this.emergencyName = emergencyName;
		}
	public void setEmergencyNumber (String emergencyNumber)
		{
			this.emergencyNumber = emergencyNumber;
		}
	
	//The accessor/getter methods for Patient Info.
		public String getFirstName()
		{
			return firstName;
		}
		public String getMiddleName()
		{
			return middleName;
		}
		public String getLastName()
		{
			return lastName;
		}
		public String getAddress()
		{
			return address;
		}
		public String getCity()
		{
			return city;
		}
		public String getState()
		{
			return state;
		}
		public int getZipCode()
		{
			return zipCode;
		}
		public String getPatientNumber()
		{
			return patientNumber;
		}
		public String getEmergencyName()
		{
			return emergencyName;
		}
		public String getEmergencyNumber()
		{
			return emergencyNumber;
		}
		
	//Now, creating the buildFullName method to build the Patient's full name. Also includes the patient's phone number.
		public String buildFullName ()
		{
			return (firstName +  " " + middleName + " " + lastName + " " + patientNumber); //returns concatenation of name fields.
		}
	
	//Now, creating the buildAddress method to build the Patient's full address.
		public String buildAddress()
		{
			return (address + " " + city + " " + state + " " + zipCode);
		}
	
	//Now, creating the buildEmergencyContact method to build the Patient's emergency contact info.
		public String buildEmergencyContact()
		{
			return (emergencyName + " " + emergencyNumber);
		}
			
	//Now, creating the toString method to print all of the Patient Information on screen.
		public String toString()
		{
			return ("Name: " + buildFullName() +  "\nAddress: " + buildAddress() + "\nEmergency Contact: " + buildEmergencyContact());
		}
}
