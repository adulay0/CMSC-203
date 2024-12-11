public class Customer {

	//Creating class fields.
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//Copy constructor.
	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
	}
	
	//Getters and setters.
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	//Overriden toString method.
	@Override
	public String toString() {
		return("Name: " + name + ", Age: " + age);
	}
}
