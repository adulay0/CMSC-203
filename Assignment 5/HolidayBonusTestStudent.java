import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {

	//Creating a 2D ragged array to test methods.
	private double[][] dataTest = { {4, 9, 2, 3},
						   			{5, 7, 14},
						   			{8, 6, 1, 10}};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		try {
			double[] bonuses = HolidayBonus.calculateHolidayBonus(dataTest);
			
			assertEquals(9000.0, bonuses[0], .001);
			assertEquals(9000.0, bonuses[1], .001);
			assertEquals(12000.0, bonuses[2], .001);
			
		} catch (Exception e) {
			fail("This test failed.");
		}
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(30000.0, HolidayBonus.calculateTotalHolidayBonus(dataTest), .001);
	}

}
