public class Plot {

	//Creating required instance variables.
	private int x;
	private int y;
	private int depth;
	private int width;
	
	//Creating the constructors for the Plot class.
	//Default, no-arg constructor. Creates a default plot with width and depth of 1.
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.depth = 1;
		this.width = 1;
	}
	
	//1st Parameterized Constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//Copy Constructor. Creates new plot given another plot.
	public Plot (Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	//Creating the getter and setter methods for the instance variables.
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	//Creating the overlaps method.
	public boolean overlaps (Plot plot) {
		
		//The statements inside of the return statement below are essentially checking each corner/edge of the 
		//plots and comparing their Java coordinate locations. OR is used because for overlapping, you only need
		//to each if at least one corner or side is overlapping another.
		return (x < plot.x + plot.width) && (x + width > plot.x) && (y < plot.y + plot.depth) && (y + width > plot.y);
	}
		
	//Creating the encompasses method.
	public boolean encompasses (Plot plot) {
		
		//This return statement must use the AND logical operator to check if a plot
		//completely resides within another.
		return (x <= plot.x && y <= plot.y && 
				(x + width) >= (plot.x + plot.width) &&
				(y + depth) >= (plot.y + plot.depth));
	}
	
	//Creating the toString method to print plot information.
	@Override
	public String toString() {
		return (x + "," + y + "," + width + "," + depth);
	}
}
