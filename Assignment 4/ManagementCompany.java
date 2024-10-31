public class ManagementCompany {

	//Creating class level constants.
	static final int MAX_PROPERTY = 5; //This is the max number of properties the company can have.
	static final int MGMT_WIDTH = 10; //Width of company's plot.
	static final int MGMT_DEPTH = 10; //Depth of the company's plot.
	
	//Creating instance variables to hold company name, tax ID, and fee information.
	private String companyName;
	private String taxID;
	private double mgmFee;
	
	//Creating instance array variable to hold the properties of the company.
	private Property[] properties;
	
	//Creating an instance variable for the company plot.
	private Plot plot;
	
	//Creating an instance variable to hold the number of properties the company has.
	private int numberOfProperties; //Initialized to 0.
	
	//Creating the ManagementCompany class constructors.
	//Default, no-arg constructor. Creates object with empty strings and default plot with max dimensions.
	public ManagementCompany() {
		this.companyName = "";
		this.taxID = "";
		this.mgmFee = 0.0;
		
		//Initializing the properties array.
		this.properties = new Property[MAX_PROPERTY];
		
		//Create a default plot.
		this.plot = new Plot (0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	//1st Parameterized Constructor
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.companyName = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot (0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	//2nd Parameterized Constructor
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.companyName = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot (x, y, width, depth);
	}

	//3rd Parameterized Constructor - Copy Constructor
	public ManagementCompany(ManagementCompany otherCompany) {
		this.companyName = otherCompany.companyName;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = otherCompany.plot;
	}
	
	//Creating the getter methods according to JavaDoc notes for ManagementCompany class.

	//Getters.
	public String getName() {
		return this.companyName;
	}
	public String getTaxID() {
		return this.taxID;
	}
	public Property[] getProperties() {
		return this.properties;
	}
	public double getMgmFeePer() {
		return this.mgmFee;
	}
	public Plot getPlot() {
		return this.plot;
	}
	
	//Now creating the overloaded addProperty methods.
	//Creating the  1st addProperty method.
	public int addProperty (Property property) {
		if (this.isPropertiesFull()) {
			return -1;
		} 
		
		if (property == null) {
			return -2;
		} 
		
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		//Must check if any property's plot overlaps another property's plot and return -4.
		//Can go through properties array and check using the overlaps method of the plot class.
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		
		//Now, increment the numberOfProperties variable and add the new property to the properties array.
		properties[numberOfProperties] = new Property(property);
		numberOfProperties++;
		
		//Returns the index value of the recently added property.
		return (numberOfProperties - 1);
	}
	
	//Creating the 2nd addProperty method.
	public int addProperty(String name, String city, double rent, String ownerName) {
		Property property = new Property(name, city, rent, ownerName);
		return (addProperty(property));
	}
	
	//Creating the 3rd addProperty method.
	public int addProperty(String name, String city, double rent, String ownerName, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, ownerName, x, y, width, depth);
		return (addProperty(property));
	}
	
	//Creating the getTotalRent method.
	public double getTotalRent() {
		double totalRent = 0.0;
		
		//Go through the properties array and create a running total of the rent amounts of each property.
		for (int i = 0; i < numberOfProperties; i++) {
			totalRent += properties[i].getRentAmount();
		}
		
		//Return the total rent amount of all the properties.
		return totalRent;
	}
	
	//Creating the getHighestRentProperty method.
	public Property getHighestRentProperty() {
		Property highest = properties[0];
		
		//Simply scan through the array, comparing the rent values of each property object element.
		for (int i = 1; i < numberOfProperties; i++) {
			if (properties[i].getRentAmount() > highest.getRentAmount()) {
				highest = properties[i];
			}
		}
		
		//Now, return the property with the highest rent and its index in the properties array.
		return highest;
	}
	
	//Creating the removeLastProperty method.
	public void removeLastProperty() {
		properties[numberOfProperties - 1] = null;
	}
	
	//Creating the isPropertiesFull method.
	public boolean isPropertiesFull() {
		//Simply, check if the number of properties counter is equal to the maximum allowed number of properties.
		return (numberOfProperties == MAX_PROPERTY);
	}
	
	//Creating the getPropertiesCount method.
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	//Creating the isManagementFeeValid method.
	public boolean isManagementFeeValid() {
		if (mgmFee >= 0 && mgmFee <= 100) {
			return true;
		} else {
			return false;
		}
	}
	
	//Creating the toString method to return all company properties information.
	public String toString() {
		
		//Instead of writing a long return statement, can utilize the StrinBuilder class append method to
		//easily construct the information list needed to be returned.
		
		StringBuilder propertyInfo = new StringBuilder("List of properties for " + companyName + ", TaxID: " + taxID);
		propertyInfo.append("\n");
		propertyInfo.append("________________________________________").append("\n");
		
		//Now, I can go through the properties in the properties array and call the toString method for each.
		//Which I can then append to the end of the StringBuilder object.
		
		for (int i = 0; i < numberOfProperties; i++) {
			propertyInfo.append(properties[i].toString());
			propertyInfo.append("\n");
		}
		propertyInfo.append("________________________________________").append("\n");
		
		//propertyInfo.append(isManagementFeeValid())
		propertyInfo.append("Total Management Fee: " + mgmFee);
		
		//Now, call the explicitly use the toString method and return the newly constructed property information.
		return propertyInfo.toString();
	}
}
