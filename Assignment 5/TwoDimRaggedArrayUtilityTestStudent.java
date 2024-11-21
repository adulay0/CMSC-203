import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	//Creating a 2D ragged array for testing.
	private double[][] dataTest = { {300, 400, 500, 600} ,
									{700, 800, 900} ,
									{1000, 1100, 1200,} };
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetTotal() {
		assertEquals(7500.0, TwoDimRaggedArrayUtility.getTotal(dataTest));
	}

	@Test
	void testGetRowTotal() {
		assertEquals(1800.0, TwoDimRaggedArrayUtility.getRowTotal(dataTest, 0), .001);
		assertEquals(2400.0, TwoDimRaggedArrayUtility.getRowTotal(dataTest, 1), .001);
		assertEquals(3300.0, TwoDimRaggedArrayUtility.getRowTotal(dataTest, 2), .001);
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(2000.0, TwoDimRaggedArrayUtility.getColumnTotal(dataTest, 0), .001);
		assertEquals(2300.0, TwoDimRaggedArrayUtility.getColumnTotal(dataTest, 1), .001);
		assertEquals(2600.0, TwoDimRaggedArrayUtility.getColumnTotal(dataTest, 2), .001);
		assertEquals(600.0, TwoDimRaggedArrayUtility.getColumnTotal(dataTest, 3), .001);
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(600.0, TwoDimRaggedArrayUtility.getHighestInRow(dataTest, 0), .001);
		assertEquals(900.0, TwoDimRaggedArrayUtility.getHighestInRow(dataTest, 1), .001);
		assertEquals(1200.0, TwoDimRaggedArrayUtility.getHighestInRow(dataTest, 2), .001);
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataTest, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataTest, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataTest, 2));
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(300.0, TwoDimRaggedArrayUtility.getLowestInRow(dataTest, 0), .001);
		assertEquals(700.0, TwoDimRaggedArrayUtility.getLowestInRow(dataTest, 1), .001);
		assertEquals(1000.0, TwoDimRaggedArrayUtility.getLowestInRow(dataTest, 2), .001);
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataTest, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataTest, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataTest, 2));
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(1000.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataTest, 0), .001);
		assertEquals(1100.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataTest, 1), .001);
		assertEquals(1200.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataTest, 2), .001);
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataTest, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataTest, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataTest, 2));
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(300.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataTest, 0), .001);
		assertEquals(400.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataTest, 1), .001);
		assertEquals(500.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataTest, 2), .001);
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataTest, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataTest, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataTest, 2));
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(1200.0, TwoDimRaggedArrayUtility.getHighestInArray(dataTest), .001);
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(300.0, TwoDimRaggedArrayUtility.getLowestInArray(dataTest), .001);
	}

}
