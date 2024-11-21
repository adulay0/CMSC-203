/*
 * Class: CMSC 203 - CRN 20932
 * Instructor: Ahmed Tarek
 * Description: This class has a large quantity of methods that manipulates and performs 
 * calculations on a two dimensional ragged array. This class will also be able to read
 * and write data from to an input and from an output file to populate the array.
 * Due: 11/20/24
 * Platform/Compiler: Windows 10 OS, Eclipse IDE
 * I pledge that I have completed the programming assignment independently. I have not 
 * copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Abigail Dulay
 */

public class HolidayBonus {

	//Creating required constants.
	
	
	//Creating the calculateHolidayBonus method.
	public static double[] calculateHolidayBonus(double[][] data) {
		//Setting the values for holiday bonus values
		final double high, low, other;
		high = 5000.0;
		low = 1000.0;
		other = 2000.0;
		
		//Creating another 2D double array, this time to hold bonus values corresponding to each store and sales category.
		double[][] holidayBonuses = new double[data.length][];
		for (int row = 0; row < data.length; row++) {
			holidayBonuses[row] = new double[data[row].length];
		}	
		
		//Go through the data array and determine the highest and lowest values across columns.
		//This will determine the bonus amount to be given.
		for (int row = 0; row < holidayBonuses.length; row++) {
			for (int col = 0; col < holidayBonuses[row].length; col++) {
				int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
				int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
				holidayBonuses[highBonusIndex][col] = high;
				holidayBonuses[lowBonusIndex][col] = low;
				
				//If the current row is does not contain an index for a high or low bonus, categorize it as other.
				if (row != highBonusIndex && row != lowBonusIndex)
					holidayBonuses[row][col] = other;
			}		
		}
		
		//Now create a 1D double array to return the holiday bonuses for each store.
		double[] storeHolidayBonus = new double [data.length]; //Size is the same number of rows in data[][] since the stores go down the columns.
		
		for (int row = 0; row < holidayBonuses.length; row++) {
			for (int col = 0; col < holidayBonuses[row].length; col++) {
				storeHolidayBonus[row] += holidayBonuses[row][col];
			}
		}
		
		return storeHolidayBonus;
	}

	
	//Creating the calculateTotalHolidayBonus method.
	public static double calculateTotalHolidayBonus(double[][] data) {
		
		final double high, low, other;
		high = 5000.0;
		low = 1000.0;
		other = 2000.0;
		
		double totalBonus = 0.0;
		
		//This first part is the same code as the calculateHolidayBonus method. 
		//For each store (each row), it must be determined first if any of the elements in the column are the highest or lowest value.
		//This will then be necessary in calculating the total holiday bonus amounts from the store.
		double[][] holidayBonuses = new double[data.length][];
		
		for (int row = 0; row < data.length; row++) {
			holidayBonuses[row] = new double[data[row].length];
		}
		
		for (int row = 0; row < holidayBonuses.length; row++) {
			for (int col = 0; col < holidayBonuses[row].length; col++) {
				int highBonusIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
				int lowBonusIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
				holidayBonuses[highBonusIndex][col] = high;
				holidayBonuses[lowBonusIndex][col] = low;
				
				//If the current row is does not contain an index for a high or low bonus, categorize it as other.
				if (row != highBonusIndex && row != lowBonusIndex)
					holidayBonuses[row][col] = other;
			}		
		}
		
		//Now, simply go through the holiday bonuses array and sum the bonuses.
		for (int row = 0; row < holidayBonuses.length; row++) {
			for (int col = 0; col < holidayBonuses[row].length; col++) {
				totalBonus += holidayBonuses[row][col];
			}
		}
		
		return totalBonus;
	}
}
