public class Smoothie extends Beverage{
	
	//Creating constants for extra protein and fruit prices.
	private final double PROTEIN_PRICE = 1.50;
	private final double PRICEPER_FRUIT = 0.50;
	
	//Creating class fields.
	private int numFruits;
	private boolean addProtein;
	
	public Smoothie (String name, SIZE size, int numFruits, boolean addProtein) {
		super(name, TYPE.SMOOTHIE, size);
		this.numFruits = numFruits;
		this.addProtein = addProtein;
	}
	
	//Getters and setters.
	public void setNumOfFruits(int numFruits) {
		this.numFruits = numFruits;
	}
	
	public int getNumOfFruits() {
		return numFruits;
	}
	
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	//Creating overriden methods.
	@Override
	public double calcPrice() {
		double smoothiePrice = super.getBasePrice();
		
		//Check if the smoothie has additional protein and number of fruits.
		if(addProtein)
			smoothiePrice += PROTEIN_PRICE;
		
		smoothiePrice += (numFruits * PRICEPER_FRUIT);
		
		//Check if the beverage size is bigger than a small.
		smoothiePrice += super.addSizePrice();
		
		return smoothiePrice;
	}
	
	@Override
	public String toString() {
		String bevInfo = super.toString();
		
		if(addProtein)
			bevInfo += ", Protein Powder";
		
		bevInfo += (", Number of Fruits: " + getNumOfFruits());
		bevInfo += (", $" + calcPrice());
		
		return bevInfo;
	}
	
	public boolean equals(Smoothie s) {
		if(super.equals(s) && addProtein == s.getAddProtein()
			&& numFruits == s.getNumOfFruits())
			return true;
		else
			return false;
	}
}
