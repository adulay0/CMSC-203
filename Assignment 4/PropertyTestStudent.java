import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	Property p1, p2, p3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		p1 = new Property();
		p2 = new Property("Property 2", "City 2", 567.0, "Owner 2");
		p3 = new Property("Property 3", "City 3", 1750.0, "Owner 3", 3, 4, 5, 6);
	}

	@AfterEach
	void tearDown() throws Exception {
		p1 = p2 = p3 = null;
	}

	@Test
	void testProperty() {
		assertEquals("", p1.getPropertyName());
		assertEquals("", p1.getCity());
		assertEquals(0.0, p1.getRentAmount());
		assertEquals("", p1.getOwner());
		assertEquals("0,0,1,1", p1.getPlot().toString());
	}

	@Test
	void testPropertyStringStringDoubleString() {
		assertEquals("Property 2", p2.getPropertyName());
		assertEquals("City 2", p2.getCity());
		assertEquals(567.0, p2.getRentAmount());
		assertEquals("Owner 2", p2.getOwner());
		assertEquals("0,0,1,1", p2.getPlot().toString());
	}

	@Test
	void testPropertyStringStringDoubleStringIntIntIntInt() {
		assertEquals("Property 3", p3.getPropertyName());
		assertEquals("City 3", p3.getCity());
		assertEquals(1750.0, p3.getRentAmount());
		assertEquals("Owner 3", p3.getOwner());
		assertEquals("3,4,5,6", p3.getPlot().toString());
	}

	@Test
	void testPropertyProperty() {
		Property copyConstructorTest = new Property(p1);
		assertEquals("", copyConstructorTest.getPropertyName());
		assertEquals("", copyConstructorTest.getCity());
		assertEquals(0.0, copyConstructorTest.getRentAmount());
		assertEquals("", copyConstructorTest.getOwner());
		assertEquals("0,0,1,1", copyConstructorTest.getPlot().toString());
	}

	@Test
	void testGetPropertyName() {
		assertTrue(p1.getPropertyName() == "");
		assertTrue(p2.getPropertyName() == "Property 2");
		assertTrue(p3.getPropertyName() == "Property 3");
	}

	@Test
	void testGetCity() {
		assertTrue(p1.getCity() == "");
		assertTrue(p2.getCity() == "City 2");
		assertTrue(p3.getCity() == "City 3");
	}

	@Test
	void testGetRentAmount() {
		assertTrue(p1.getRentAmount() == 0.0);
		assertTrue(p2.getRentAmount() == 567.0);
		assertTrue(p3.getRentAmount() == 1750.0);
	}

	@Test
	void testGetOwner() {
		assertTrue(p1.getOwner() == "");
		assertTrue(p2.getOwner() == "Owner 2");
		assertTrue(p3.getOwner() == "Owner 3");
	}

	@Test
	void testGetPlot() {
		assertEquals("0,0,1,1", p1.getPlot().toString());
		assertEquals("0,0,1,1", p2.getPlot().toString());
		assertEquals("3,4,5,6", p3.getPlot().toString());
	}

	@Test
	void testToString() {
		assertEquals(",,,0.0",p1.toString());
		assertEquals("Property 2,City 2,Owner 2,567.0",p2.toString());
		assertEquals("Property 3,City 3,Owner 3,1750.0",p3.toString());
	}

}
