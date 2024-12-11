abstract class Beverage {
	
	//Creating constants for base price values.
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	
	//Creating class fields.
	private String name;
	private TYPE type;
	private SIZE size;
	
	public Beverage (String name, TYPE type, SIZE size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	//Getters and setters.
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	public double getSizePrice() {
		return SIZE_PRICE;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getBevName() {
		return name;
	}
	
	public void setType (TYPE type) {
		this.type = type;
	}
	
	public TYPE getType() {
		return type;
	}
	
	public void setSize (SIZE size) {
		this.size = size;
	}
	
	public SIZE getSize() {
		return size;
	}
	
	public double addSizePrice() {
		double sizePrice = 0.0;
		
		if(size == SIZE.MEDIUM)
			sizePrice = SIZE_PRICE;
		else if (size == SIZE.LARGE)
			sizePrice = (2 * SIZE_PRICE);
		
		return sizePrice;
	}
	
	//Abstract calcPrice method.
	public abstract double calcPrice();
	
	//Overriden toString and equals methods.
	@Override
	public String toString() {
		return ("Beverage Name: " + name + ", Size: " + size + "\n");
	}
	
	public boolean equals(Beverage b) {
		if(name.equals(b.getBevName()) && type == (b.getType()) && size == (b.getSize()))
			return true;
		else
			return false;
	}

}