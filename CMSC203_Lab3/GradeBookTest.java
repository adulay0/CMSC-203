import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook g1, g2;
	
	@BeforeEach
	void setUp() throws Exception {
		//Creating new objects for JUnit testing.
		g1 = new GradeBook(3);
		g2 = new GradeBook(4);
		
		//Calling the addSCore method for each of the GradeBook objects.
		g1.addScore(89.3);
		g1.addScore(94.7);
		g1.addScore(74.9);
		
		g2.addScore(69.3);
		g2.addScore(89.9);
		g2.addScore(98.2);
		g2.addScore(88.3);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = null;
	}

	@Test
	void testAddScore() {
		assertEquals("89.3 94.7 74.9 ", g1.toString());
		assertEquals("69.3 89.9 98.2 88.3 ", g2.toString());
		assertTrue(g1.getScoreSize() == 3);
		assertTrue(g2.getScoreSize() == 4);
	}

	@Test
	void testSum() {
		assertEquals(258.9, g1.sum(), 0.001);
		assertEquals(345.7, g2.sum(), 0.001);
	}

	@Test
	void testMinimum() {
		assertTrue(g1.minimum() == 74.9);
		assertTrue(g2.minimum() == 69.3);
	}

	@Test
	void testFinalScore() {
		assertEquals(184.0, g1.finalScore());
		assertEquals(276.4, g2.finalScore());
	}

	@Test
	void testToString() {
	}

}
