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
import java.io.FileNotFoundException;
import java.io.*;

public final class TwoDimRaggedArrayUtility {

	//Creating the readFile method.
	public static double[][] readFile(File f) throws FileNotFoundException, IOException {
		final int stores = 6; //Rows can be instantiated because it is known there are 6 stores in District 5.
		double[][] data = new double[stores][];
		
		String line;
		
		try {
			int row = 0;
			
			//Creating a BufferedReader object to read the file and input data into the 2D-ragged array.
			BufferedReader read = new BufferedReader(new FileReader(f));
			
			while ((line = read.readLine()) != null && row < stores) {
				String[] split = line.split(" ");
				
				//The length of the String[] will determine how many columns/elements are in each row.
				int colNums = split.length;
				
				data[row] = new double[colNums];
				
				//Now, convert the array of Strings into an array of doubles.
				for (int col = 0; col < colNums; col++) {
					data[row][col] = Double.parseDouble(split[col]); 
				}
				
				row++; //Iterate to the next row until the file is done being read.
			}
			
			read.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	//Creating the writeToFile method.
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException, IOException {
		PrintWriter pw = new PrintWriter(outputFile);
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				pw.println(data[row][col] + " ");
			}
		System.out.println();
		}
	pw.close();
	}
	
	//Creating the getTotal method.
	public static double getTotal(double[][] data) {
		double total = 0.0;
		
		//Now, go through each of the elements in the two-dim array and calculate the total.
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}
	
	//Creating the getAverage method.
	public static double getAverage(double[][] data) {
		
		//To get the average value of the data array, first the total collected (can call getTotal method).
		//Then, a counter must also be implemented to keep track of the elements in the array.
		double total = 0.0;
		int elementCounter = 0;
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data.length; col++) {
				total += data[row][col];
				elementCounter += 1;
			}
		}
		
		//Now calculate the average value of the data array.
		double average = total / ((double) elementCounter);
		
		return average;
	}
	
	//Creating the getRowTotal method.
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0.0;
		
		for (int col = 0; col < data[row].length; col++) {
			rowTotal += data[row][col];
		}
		
		return rowTotal;
	}
	
	//Creating the getColumnTotal method.
	public static double getColumnTotal(double[][] data, int col) {
		double colTotal = 0.0;
		
		for(int row = 0; row < data.length; row++) {
			if (col <= data[row].length - 1) { //This makes sure we do not index out of bounds for shorter rows.
				colTotal += data[row][col];
			}
		}
		
		return colTotal;
	}
	
	//Creating the getHighestInRow method.
	public static double getHighestInRow(double[][] data, int row) {
		//First need to initialize a highest value.
		double rowHighest = data[row][0];
		
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] > rowHighest) 
				rowHighest = data[row][col];
		}
		
		return rowHighest;
	}
	
	//Creating the getHighestInRowIndex method.
	public static int getHighestInRowIndex(double[][] data, int row) {
		int maxRowIndex = 0;
		
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] > data[row][maxRowIndex]) {
				maxRowIndex = col;
			}
		}
		
		return maxRowIndex;
	}
	
	//Creating the getLowestInRow method.
	public static double getLowestInRow(double[][] data, int row) {
		double rowLowest = data[row][0];
		
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < rowLowest)
				rowLowest = data[row][col];
		}
		
		return rowLowest;
	}
	
	//Creating the getLowestInRowIndex method.
	public static int getLowestInRowIndex(double[][] data, int row) {
		int minRowIndex = 0;
		
		for (int col = 0; col < data[row].length; col++) {
			if (data[row][col] < data[row][minRowIndex])
				minRowIndex = col;
		}
		
		return minRowIndex;
	}
	
	//Creating the getHighestInColumn method.
	public static double getHighestInColumn(double[][] data, int col) {
		double columnHighest = data[0][col];
		
		for (int row = 0; row < data.length; row++) {
			if (col <= data[row].length - 1) { //To make sure we do not get index out of bounds error.
				if (data[row][col] > columnHighest)
					columnHighest = data[row][col];
			}
		}
		
		return columnHighest;
	}
	
	//Creating the getHighestInColumnIndex method.
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int maxColIndex = 0;
		
		for (int row = 0; row < data.length; row++) {
			if (data[row].length > col) {
				if (data[row][col] > data[maxColIndex][col])
					maxColIndex = row;
			}
		}
		
		return maxColIndex;
	}
	
	//Creating the getLowestInColumn method.
	public static double getLowestInColumn(double[][] data, int col) {
		double colLowest = data[0][col];
		
		for (int row = 0; row < data.length; row++) {
			if (col <= data[row].length - 1) {
				if (data[row][col] < colLowest)
					colLowest = data[row][col];
			}
		}
		
		return colLowest;
	}
	
	//Creating the getLowestInColumnIndex method.
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int minColIndex = 0;
		
		for (int row = 0; row < data.length; row++) {
			if (data[row].length > col) {
				if (data[row][col] < data[minColIndex][col])
					minColIndex = row;
			}
		}
		
		return minColIndex;
	}
	
	//Creating the getHighestInArray method.
	public static double getHighestInArray(double[][] data) {
		double arrayMax = data[0][0];
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > arrayMax)
					arrayMax = data[row][col];
			}
		}
		
		return arrayMax;
	}
	
	//Creating the getLowestInArray method.
	public static double getLowestInArray (double[][] data) {
		double arrayMin = data[0][0];
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] < arrayMin)
					arrayMin = data[row][col];
			}
		}
		
		return arrayMin;
	}
}
