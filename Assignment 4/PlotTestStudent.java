import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	Plot plot1, plot2, plot3;
	
	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot();
		plot2 = new Plot(2, 2, 4, 5);
		plot3 = new Plot(3, 4, 1, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = plot3 = null;
	}

	@Test
	void testPlot() {
		assertEquals(0, plot1.getX());
		assertEquals(0, plot1.getY());
		assertEquals(1, plot1.getWidth());
		assertEquals(1, plot1.getDepth());
	}

	@Test
	void testPlotIntIntIntInt() {
		assertEquals(2, plot2.getX());
		assertEquals(2, plot2.getY());
		assertEquals(4, plot2.getWidth());
		assertEquals(5, plot2.getDepth());
	}

	@Test
	void testPlotPlot() {
		Plot constructorTest3 = new Plot(plot3);
		assertEquals(3, constructorTest3.getX());
		assertEquals(4, constructorTest3.getY());
		assertEquals(1, constructorTest3.getWidth());
		assertEquals(1, constructorTest3.getDepth());
	}

	@Test
	void testSetX() {
		assertTrue(plot1.getX() == 0);
		plot1.setX(1);
		assertTrue(plot1.getX() == 1);
		
		assertTrue(plot2.getX() == 2);
		plot2.setX(4);
		assertTrue(plot2.getX() == 4);
		
		assertTrue(plot3.getX() == 3);
		plot3.setX(2);
		assertTrue(plot3.getX() == 2);
	}

	@Test
	void testGetX() {
		assertTrue(plot1.getX() == 0);
		assertTrue(plot2.getX() == 2);
		assertTrue(plot3.getX() == 3);
	}

	@Test
	void testSetY() {
		assertTrue(plot1.getY() == 0);
		plot1.setY(1);
		assertTrue(plot1.getY() == 1);
		
		assertTrue(plot2.getY() == 2);
		plot2.setY(1);
		assertTrue(plot2.getY() == 1);
		
		assertTrue(plot3.getY() == 4);
		plot3.setY(1);
		assertTrue(plot3.getY() == 1);
	}

	@Test
	void testGetY() {
		assertTrue(plot1.getY() == 0);
		assertTrue(plot2.getY() == 2);
		assertTrue(plot3.getY() == 4);
	}

	@Test
	void testSetDepth() {
		assertTrue(plot1.getDepth() == 1);
		plot1.setDepth(2);
		assertTrue(plot1.getDepth() == 2);

		assertTrue(plot2.getDepth() == 5);
		plot2.setDepth(2);
		assertTrue(plot2.getDepth() == 2);
		
		assertTrue(plot3.getDepth() == 1);
		plot3.setDepth(2);
		assertTrue(plot3.getDepth() == 2);
	}

	@Test
	void testGetDepth() {
		assertTrue(plot1.getDepth() == 1);
		assertTrue(plot2.getDepth() == 5);
		assertTrue(plot3.getDepth() == 1);
	}

	@Test
	void testSetWidth() {
		assertTrue(plot1.getWidth() == 1);
		plot1.setWidth(2);
		assertTrue(plot1.getWidth() == 2);
		
		assertTrue(plot2.getWidth() == 4);
		plot2.setWidth(2);
		assertTrue(plot2.getWidth() == 2);
		
		assertTrue(plot3.getWidth() == 1);
		plot3.setWidth(2);
		assertTrue(plot3.getWidth() == 2);
	}

	@Test
	void testGetWidth() {
		assertTrue(plot1.getWidth() == 1);
		assertTrue(plot2.getWidth() == 4);
		assertTrue(plot3.getWidth() == 1);
	}

	@Test
	void testOverlaps() {
		assertTrue(plot2.overlaps(plot3));
	}

	@Test
	void testToString() {
		assertEquals("0,0,1,1", plot1.toString());
		assertEquals("2,2,4,5", plot2.toString());
		assertEquals("3,4,1,1", plot3.toString());
	}

}
