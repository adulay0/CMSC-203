import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	ManagementCompany m1, m2, m3;
	
	@BeforeEach
	void setUp() throws Exception {
		m1 = new ManagementCompany();
		m2 = new ManagementCompany("M2", "2222", 20.0);
		m3 = new ManagementCompany("M3", "3333", 30.0, 4, 5, 6, 7);
	}

	@AfterEach
	void tearDown() throws Exception {
		m1 = m2 = m3 = null;
	}

	@Test
	void testManagementCompany() {
		assertEquals("", m1.getName());
		assertEquals("", m1.getTaxID());
		assertEquals(0.0, m1.getMgmFeePer());
	}

	@Test
	void testManagementCompanyStringStringDouble() {
		assertEquals("M2", m2.getName());
		assertEquals("2222", m2.getTaxID());
		assertEquals(20.0, m2.getMgmFeePer());
	}

	@Test
	void testManagementCompanyStringStringDoubleIntIntIntInt() {
		assertEquals("M3", m3.getName());
		assertEquals("3333", m3.getTaxID());
		assertEquals(30.0, m3.getMgmFeePer());
		assertEquals("4,5,6,7", m3.getPlot().toString());
	}

	@Test
	void testManagementCompanyManagementCompany() {
		ManagementCompany copyConstructorTest = new ManagementCompany(m2);
		assertEquals("M2", copyConstructorTest.getName());
		assertEquals("2222", copyConstructorTest.getTaxID());
		assertEquals(20.0, copyConstructorTest.getMgmFeePer());
	}

	@Test
	void testGetName() {
		assertTrue(m1.getName() == "");
		assertTrue(m2.getName() == "M2");
		assertTrue(m3.getName() == "M3");
	}

	@Test
	void testGetTaxID() {
		assertTrue(m1.getTaxID() == "");
		assertTrue(m2.getTaxID() == "2222");
		assertTrue(m3.getTaxID() == "3333");
	}

	@Test
	void testGetMgmFeePer() {
		assertTrue(m1.getMgmFeePer() == 0.0);
		assertTrue(m2.getMgmFeePer() == 20.0);
		assertTrue(m3.getMgmFeePer() == 30.0);
	}

	@Test
	void testGetPlot() {
		assertEquals("0,0,10,10", m1.getPlot().toString());
		assertEquals("0,0,10,10", m2.getPlot().toString());
		assertEquals("4,5,6,7", m3.getPlot().toString());
	}

	@Test
	void testAddPropertyProperty() {
		Property sample = new Property("Sample Property", "Sample City", 4560.0, "Sample Owner", 2, 3, 4, 5);
		assertEquals(m2.addProperty(sample), 0, 0);
	}

	@Test
	void testGetPropertiesCount() {
		Property sample = new Property("Sample Property", "Sample City", 4560.0, "Sample Owner", 2, 3, 4, 5);
		assertEquals(m2.addProperty(sample), 0, 0);
		assertEquals(m2.getPropertiesCount(), 1);
	}

	@Test
	void testIsManagementFeeValid() {
		assertTrue(m1.isManagementFeeValid() == true);
		assertTrue(m2.isManagementFeeValid() == true);
		assertTrue(m3.isManagementFeeValid() == true);
	}

	@Test
	void testToString() {
		assertEquals("List of properties for , TaxID: \n________________________________________\n________________________________________\nTotal Management Fee: 0.0", m1.toString());
		assertEquals("List of properties for M2, TaxID: 2222\n________________________________________\n________________________________________\nTotal Management Fee: 20.0", m2.toString());
		assertEquals("List of properties for M3, TaxID: 3333\n________________________________________\n________________________________________\nTotal Management Fee: 30.0", m3.toString());
	}

}
