public class Coffee extends Beverage{
	
	//Creaing constants for extra shot and extra syrup prices.
	private final double SHOT_PRICE = 0.50;
	private final double SYRUP_PRICE = 0.50;
	
	//Creating class fields.
	private boolean extraShot;
	private boolean extraSyrup;
	
	public Coffee (String name, SIZE size, boolean extraShot, boolean extraSyrup) {
		super(name, TYPE.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	//Getters and setters.
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	//Creating overriden methods.
	@Override
	public double calcPrice() {
		double coffeePrice = super.getBasePrice();
		
		//Check if the coffee has additional coffee shots or syrup.
		if(extraShot) 
			coffeePrice += SHOT_PRICE;
		if(extraSyrup) 
			coffeePrice += SYRUP_PRICE;
		
		//Check if the beverage size is bigger than a small.
		coffeePrice += super.addSizePrice();
			
		return coffeePrice;
	}
	
	@Override
	public String toString() {
		String bevInfo = ("Beverage: " + getBevName() + ", " + getSize());
		
		if (extraShot) {
			bevInfo += ", Extra Shot";
		}
		
		if (extraSyrup) {
			bevInfo += ", Extra Syrup";
		}
		
		//Adding the price of the coffee.
		bevInfo += (", $" + calcPrice());
		
		return bevInfo;
	}
	
	public boolean equals(Coffee c) {
		if(super.equals(c) && extraShot == c.getExtraShot()
			 && extraSyrup == c.getExtraSyrup())
			return true;
		else
			return false;
	}
}
