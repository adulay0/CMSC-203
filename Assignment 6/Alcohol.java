public class Alcohol extends Beverage{
	
	//Creating constant for weekend drink price.
	private final double WEEKEND_PRICE = 0.60;
	
	//Creating class field.
	private boolean onWeekend;
	
	public Alcohol(String name, SIZE size, boolean onWeekend) {
		super(name, TYPE.ALCOHOL, size);
		this.onWeekend = onWeekend;
	}
	
	//Getters and setters.
	public void setOnWeekend(boolean onWeekend) {
		this.onWeekend = onWeekend;
	}
	
	public boolean getOnWeekend() {
		return onWeekend;
	}
	
	public double getWeekendPrice() {
		return WEEKEND_PRICE;
	}
	
	//Creating overriden methods.
	@Override
	public double calcPrice() {
		double alcoholPrice = super.getBasePrice();
		
		//Check if the drink is being sold on the weekend.
		if(onWeekend)
			alcoholPrice += WEEKEND_PRICE;
		
		//Use the addSizePrice() method from the super class.
		alcoholPrice += super.addSizePrice();
		
		return alcoholPrice;
	}
	
	@Override
	public String toString() {
		String bevInfo = (getBevName() + ", " + getSize());
		
		if(onWeekend)
			bevInfo += ", Offered on Weekend";
		bevInfo += (", $" + calcPrice());
		
		return bevInfo;
	}
	
	public boolean equals(Alcohol a) {
		if(super.equals(a) && onWeekend == a.getOnWeekend())
			return true;
		else
			return false;
	}
}
