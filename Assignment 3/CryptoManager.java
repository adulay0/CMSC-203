/*
 * Class: CMSC 203
 * Instructor: Ahmed Tarek
 * Description: This CryptoManager class will create methods that will, given a user-entered String, encrypt messages
 * using the Caesar and Bellaso Cipher methods. This class will check for message that are in or out of bounds, and also 
 * return the decrypted (original) message back to the user.
 * Due: 10/16/24
 * Platform/Compiler: Windows 10 Eclipse IDE
 * I pledge that I have completed the programming assignment independently. I have not copied the code
 * from a student or any source. I have not given my code to any student.
 * Print your Name here: Abigail Dulay
 */

public class CryptoManager {

	//Establishing the LOWER and UPPER bound constants.
	//Also, creating a range constant to be used in the Caesar Cipher for large keys.
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	
	//Implementing the isStringInBounds method.
	public static boolean isStringInBounds(String plainText) {
		
		//Using the toCharArray method from the String class to convert the user's String to a character array.
		//An enhanced for loop to step through, read, and test the characters in the array.
		for (char i : plainText.toCharArray()) {
			if (i < LOWER_RANGE || i > UPPER_RANGE) {
				return false;
			}
		}
	return true; // If the scanned characters are within range, return true.
	}
	
	//Implementing the caesarEncryption method.
	public static String caesarEncryption(String plainText, int key) {
		
		//If plainText is outside of required bounds, have the user re-enter a message again.
		if (isStringInBounds(plainText) == false) {
			return "The selected string is not in bounds, Try again.";
		}
		
		//To form encrypted message after changing the current chars with the key.
		StringBuilder caesarEncrypt = new StringBuilder();
		
		for (char i : plainText.toCharArray()) { //Convert the message to a char array and step through the elements.
			
			//Check if offset by key is within range.
			int charOffset = i + key;
			while (charOffset > UPPER_RANGE) {
				charOffset -= RANGE; //Subtract range until key is within desired bounds.
			}
			
			//Convert the offset char int value into a char. This gives the Caesar encrypted char.
			char encryptedChar = (char)charOffset;
			caesarEncrypt.append(encryptedChar); //Append method of the StringBuilder class to form char sequence.
		}
		return caesarEncrypt.toString(); //Convert char sequence into a string, which is then returned.
	}
	
	//Implementing the caesarDecryption method.
	public static String caesarDecryption(String encryptedText, int key) {
		
		StringBuilder caesarDecrypt = new StringBuilder();
		
		for(char i : encryptedText.toCharArray()) {
			//Check if decrypted values are within range.
			int charReset = i - key;
			while (charReset < LOWER_RANGE) {
				charReset += RANGE; //Add range until decryption value is within desired bounds.
			}
			
			//Convert reset char int value back into a char. 
			char decryptedChar = (char)charReset;
			caesarDecrypt.append(decryptedChar);
		}
		return caesarDecrypt.toString();
	}
	
	//Implementing the bellasoDecryption method.
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		
		//Check if the entered plainText String is out of bounds.
		if (isStringInBounds(plainText) == false) {
			return "The entered string is not in bounds. Try Again.";
		}
		
		StringBuilder bellasoEncrypt = new StringBuilder();
		
		//Getting the length of both the message and bellaso string/key.
		int messageLength = plainText.length();
		int bellasoLength = bellasoStr.length();
		
		//Creating a for loop that will extend the Bellaso String and offset values by corresponding key.
		for (int k = 0; k < messageLength; k++) {
			
			char messageChar = plainText.charAt(k);
			
			//Checks if the index, when modded w/ the length of the Bellaso string has a remainder.
			//Then, extend the bellaso string with its corresponding index/remainder char
			//until it is the length of the message to be encrypted.
			char bellasoChar = bellasoStr.charAt(k % bellasoLength);
			
			//Now, offset the characters to be encrypted.
			int charOffset = messageChar + bellasoChar; 
			
			//Like the Caesar cipher, make sure that the offset value is within range.
			while (charOffset > UPPER_RANGE) {
				charOffset -= RANGE;
			}
			
			//Convert the charOffset int value into a char. This gives the Bellaso encrypted char.
			char encryptedChar = (char)charOffset;
			bellasoEncrypt.append(encryptedChar);
		}
		
		return bellasoEncrypt.toString();
	}
	
	//Implementing the bellasoDecryption method.
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		
		StringBuilder bellasoDecrypt = new StringBuilder(); 
		
		//Get the length of the encrypted message and the bellaso string/key.
		int encryptLength = encryptedText.length();
		int bellasoLength = bellasoStr.length();
		
		//Same for loop as bellasoEncryption method. However, encrypted string will be offset to original message.
		for (int j = 0; j < encryptLength; j++) {
			
			char encryptedChar = encryptedText.charAt(j);
			char bellasoChar = bellasoStr.charAt(j % bellasoLength);
			
			//Reset the encrypted characters.
			int charReset = encryptedChar - bellasoChar;
			
			//Check if the reset characters are within range.
			while (charReset < LOWER_RANGE) {
				charReset += RANGE;
			}
			
			//Convert the charReset int value back into a char.
			char decryptedChar = (char)charReset;
			bellasoDecrypt.append(decryptedChar);
		}
		return bellasoDecrypt.toString();
	}
	
}
