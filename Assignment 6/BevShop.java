import java.util.*;

public class BevShop implements BevShopInterfce {
	
	//Creating class fields.
	private int alcoholDrinks;
	public ArrayList<Order> orders = new ArrayList<>();
	
	//This field will be used when adding beverages to an order.
	private int currentOrder;
	
	//BevShop Constructor.
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	//Implementing the methods from the BevShopInterface and JavaDoc
	public boolean validTime(int time) {
		if(time < MIN_TIME || time > MAX_TIME)
			return false;
		else
			return true;
	}
	
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits > MAX_FRUIT)
			return true;
		else
			return false;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public boolean eligibleForMore() {
		if (alcoholDrinks < MAX_ORDER_FOR_ALCOHOL)
			return true;
		else
			return false;
	}
	
	public int getNumOfAlcoholDrink() {
		return alcoholDrinks;
	}
	
	public boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL)
			return true;
		else 
			return false;
	}
	
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer (customerName, customerAge);
		Order order = new Order (time, day, customer);
		
		//Add the new order to the list of orders and get the current index.
		orders.add(order);
		currentOrder = orders.indexOf(order);
		
		//Reset the number of alcohol drinks for this new order.
		alcoholDrinks = 0;
		
	}
	
	//Order processing methods.
	public void processCoffeeOrder(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
		
		//Adding a new coffee beverage to the current order.
		orders.get(currentOrder).addNewBeverage(name, size, extraShot, extraSyrup);
	}
	
	public void processSmoothieOrder(String name, SIZE size, int numOfFruits, boolean addProtein) {
		
		//Adding a new smoothie beverage to the current order.
		orders.get(currentOrder).addNewBeverage(name, size, numOfFruits, addProtein);
	}
	
	public void processAlcoholOrder(String name, SIZE size) {
		
		//Adding a new alcohol beverage to the current order.
		orders.get(currentOrder).addNewBeverage(name, size);
	
		//Keep count of the number of alcohol drinks for the order.
		alcoholDrinks++;
	}
	
	//Implementing array list analyzing methods.
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo)
				return i;
		}
		
		//If not found:
		return -1;
	}
	
	public double totalOrderPrice(int orderNo) {
		double orderTotal = 0.0;
		
		//Step through the order list and find the order with the matching order #.
		for (Order o : orders) {
			if(o.getOrderNo() == orderNo) {
				//Now, simply call the calcOrderTotal() method.
				
				orderTotal += o.calcOrderTotal();
			}
		}
		
		return orderTotal;
		
	}
	
	public double totalMonthlySale() {
		double totalShopSales = 0.0;
		
		//Go through the list of orders, and sum the order total prices.
		for (Order o : orders)
			totalShopSales += o.calcOrderTotal();
		
		return totalShopSales;
	}
	
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public Order getCurrentOrder() {
		//Shallow copy of the current order.
		Order o = orders.get(currentOrder);
		
		return o;
	}
	
	public Order getOrderAtIndex (int index) {
		//Shallow copy of the order object at the specified index.
		Order o = orders.get(index);
		
		return o;
	}
	
	public void sortOrders() {
		//First, set an element to be initialized to the minimum element of the array list.
		for(int i = 0; i < orders.size(); i++) {
			int minIndex = i;
			
			//Now go through the orders list and compare the order number of the minimum element to the next element and swap
			//if the next element is smaller than the current minimum element.
			
			for(int j = i + 1; j < orders.size(); j++) {
				if(orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo())
					minIndex = j;
			}
			
			//Now, swap the current element and minimum element using a temp variable.
			Order temp = orders.get(minIndex);
			orders.set(minIndex, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	//Overriden toString method.
	@Override
	public String toString() {
		StringBuilder shopInfo = new StringBuilder("Monthly Orders:\n");
		
		//Go through the list of orders and append the order information to the StringBuilder object.
		for (Order o : orders) 
			shopInfo.append(o.toString()).append("\n");
		
		//Now, append the total monthly sale value.
		shopInfo.append("Total Sale: ").append(totalMonthlySale());
		
		return shopInfo.toString();
	}
}
