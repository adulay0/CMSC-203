import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent { 
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsStringInBounds() {
		
		assertTrue(CryptoManager.isStringInBounds("MY FAVORITE COLOR IS BLUE AND BLACK"));
		assertTrue(CryptoManager.isStringInBounds("PAYING FOR COLLEGE COSTS A LOT OF MONEY!"));
		assertFalse(CryptoManager.isStringInBounds("These ~~~ are out of bounds!"));
		assertFalse(CryptoManager.isStringInBounds("|This is a straight line!|"));
		
	}

	@Test
	void testCaesarEncryption() {

		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("{}H N{}!", 5));
		assertEquals("[MRXIV$[MPP$FI$GSPH", CryptoManager.caesarEncryption("WINTER WILL BE COLD", 4));
		assertEquals("*^[6![/6_)6\"W(][", CryptoManager.caesarEncryption("THE KEY IS LARGE", 150));
		assertEquals("YMJ%HFJXFW%HNUMJW%NX%[JW^%HTTQ&", CryptoManager.caesarEncryption("THE CAESAR CIPHER IS VERY COOL!", 5));
	}

	@Test
	void testCaesarDecryption() {
		
		assertEquals("CATS AND DOGS ARE CUTE", CryptoManager.caesarDecryption("MK^]*KXN*NYQ]*K\\O*M_^O", 10));
		assertEquals("COMPUTER SCIENCE!", CryptoManager.caesarDecryption("JVTW\\[LY'ZJPLUJL(", 7));
		assertEquals("123456789", CryptoManager.caesarDecryption("EFGHIJKLM", 20));
		assertEquals("THERE ARE MANY FISH IN THE SEA", CryptoManager.caesarDecryption("]QN[N)J[N)VJW\")OR\\Q)RW)]QN)\\NJ", 9));
	}

	@Test
	void testBellasoEncryption() {
		
		assertEquals("GP[V!WDO4EB&N", CryptoManager.bellasoEncryption("DOGS CAN BARK", "CAT"));
		assertEquals("#SX^/T\"+P\"T^^XT", CryptoManager.bellasoEncryption("THIS IS AWESOME", "OK"));
		assertEquals("$T\"L'%0]'N%4U[WZSK5F@$\\L^4TX4_WJ Q%X7YX$UW&\"", CryptoManager.bellasoEncryption("PETER PIPER PICKED A PECK OF PICKLED PEPPERS", "TONGUE TWISTER"));
		assertEquals("&UH#-W!RZT[[/$P[Y'(\\\\/UH%RF", CryptoManager.bellasoEncryption("WHAT PRESENT WILL YOU HAVE?", "OMG"));
	}

	@Test
	void testBellasoDecryption() {
		
		assertEquals("BELLASO DECRYPTION TEST", CryptoManager.bellasoDecryption("ER_OD \"#GRVU\\]'LR[3WH '", "CMSC"));
		assertEquals("PERFECT PURPLE PLUMS", CryptoManager.bellasoDecryption(" Q'SUO)- !']\\Q5]\\!\" ", "PLUM"));
		assertEquals("DRUM THE RHYTHM", CryptoManager.bellasoDecryption("H'\"Q5!LZ-V]&X]Z", "DUM"));
		assertEquals("WATER IS ESSENTIAL", CryptoManager.bellasoDecryption("[S]S]@ T4J%WWW\"T!#", "DRINK WATER"));
	}

}
