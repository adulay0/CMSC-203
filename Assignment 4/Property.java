public class Property {

	//Creating instance variables for property name, city, rental amount, owner and plot.
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	//Default, no-arg constructor. Creates a Property object with empty strings.
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.rentAmount = 0.0;
		this.owner = "";
		this.plot = new Plot();
	}
	
	//1st Parameterized Constructor
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
		
	}
	
	//2nd Parameterized Constructor
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	//3rd Parameterized Copy Constructor. Copies given property object.
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot);
	}
	//Creating the getters and setters for each instance variable
	
//	//Setters.
//	public void setPropertyName(String propertyName) {
//		this.propertyName = propertyName;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public void setRentAmount(double rentAmount) {
//		this.rentAmount = rentAmount;
//	}
//	public void setOwner(String owner) {
//		this.owner = owner;
//	}
//	
//	public void setPlot(Plot plot) {
//		this.plot = plot;
//	}
	
	//Getters.
	public String getPropertyName() {
		return this.propertyName;
	}
	public String getCity() {
		return this.city;
	}
	public double getRentAmount() {
		return this.rentAmount;
	}
	public String getOwner() {
		return this.owner;
	}
	public Plot getPlot() {
		return this.plot;
	}
	
	//Creating a toString method to display property information.
	@Override
	public String toString() {
		return (propertyName + "," + city + "," + owner + "," + rentAmount);
	}
}
