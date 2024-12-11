import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	
	//Creating class fields.
	private int orderNumber;
	private int orderTime;
	private DAY day;
	private Customer customer;
	public ArrayList<Beverage> beverages;
	
	public Order(int orderTime, DAY day, Customer customer) {
		//Creating a new order object.
		orderNumber = generateOrder();
		this.orderTime = orderTime;
		this.day = day;
		this.customer = customer;
		
		//Create a new beverage list for each new order.
		beverages = new ArrayList<>();
	}
	
	//Getters and setters.
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public int getOrderNo() {
		return orderNumber;
	}
	
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public void setOrderDay (DAY day) {
		this.day = day;
	}
	
	public DAY getOrderDay() {
		return day;
	}
	
	public void setCustomer (Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		
		//copy of a customer object.
		return (new Customer(customer));
	}
	
	public boolean isWeekend() {
		return (day == DAY.SATURDAY || this.day == DAY.SUNDAY);
	}
	
	//Creating a method to generate a random number between 10000 - 90000
	public int generateOrder() {
		
		//Setting constant values for upper and lower bounds of the number generation.
		final int MAX = 90000;
		final int MIN = 10000;
		
		Random r = new Random();
		
		int n = r.nextInt(MAX + 1);
		int orderNum = (n % (MAX - MIN + 1) + MIN);
		
		return orderNum;
	}
	
	//Creating overloaded addNewBeverage methods to add coffee, smoothie, or alcohol to order.
	//Adding a coffee beverage.
	public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(name, size, extraShot, extraSyrup);
		
		//Add the new coffee object to the beverages array list.
		beverages.add(c);
	}
	
	//Adding a smoothie beverage.
	public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean addProtein) {
		Smoothie s = new Smoothie(name, size, numOfFruits, addProtein);
		
		//Add the new smoothie object to the beverages array list.
		beverages.add(s);
	}
	
	//Adding an alcohol beverage.
	public void addNewBeverage(String name, SIZE size) {
		Alcohol a = new Alcohol(name, size, isWeekend());
		
		//Add the new alcohol object to the beverages array list.
		beverages.add(a);
	}
	
	//Implementing other Javadoc methods.
	public Beverage getBeverage (int itemNo) {
		if(beverages.get(itemNo) == null)
			return null;
		
		//Creating a shallow copy of the beverage at the specified index.
		Beverage b = beverages.get(itemNo);
		
		return b;
		
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	
	public double calcOrderTotal() {
		double orderTotal = 0.0;
		
		//Enhanced for loop to go through the list of beverages and sum up each of their prices.
		for(Beverage b : beverages)
			orderTotal += b.calcPrice();
		
		return orderTotal;
	}
	
	public int findNumOfBeveType(TYPE type) {
		int bevTypeCounter = 0;
		
		//Go through the list of beverages and count how many of the specified type there are.
		for(Beverage b : beverages) {
			if(b.getType() == type)
				bevTypeCounter++;
		}
		
		return bevTypeCounter;
	}
	
	
	
	//Overriden toString method.
	@Override
	public String toString() {
		return ("Order #" + orderNumber + ", " + orderTime + 
				"\n" + customer.toString() + beverages.toString() + "Total: " + calcOrderTotal());
	}
	
	//Overriden compareTo method
	public int compareTo (Order anotherOrder) {
		if (orderNumber == anotherOrder.getOrderNo())
			return 0;
		else if (orderNumber > anotherOrder.getOrderNo())
			return 1;
		
		return -1;
	}
}
