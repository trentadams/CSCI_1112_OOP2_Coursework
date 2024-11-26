package chapter17;
import java.io.File;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataOutputStream.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
public class Exercise17_03 {

	public static void main(String[] args) throws FileNotFoundException {
		// Generate text file
		File datFile = new File("Exercise17_03.dat");
		
		//Create Fileout + Dataout OBJ
		FileOutputStream fileOut = new FileOutputStream(datFile);
		DataOutputStream dataOut = new DataOutputStream(fileOut);
		
		// Create Random OBJ for random number generation
		Random random = new Random();
		int randomInt;
	
		//Write to the file =
		for (int i = 0; i < 101; i++) {
			randomInt = random.nextInt(10);
			
			try {
				//Writes as hex values
				dataOut.writeInt(randomInt);
				dataOut.writeChars(" ");
				System.out.print(randomInt + " ");
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		System.out.println("Numbers Generated");
		//Close the files
		try {
			dataOut.close();
			fileOut.close();
			System.out.println("Datastreams closed");
			//Find the sum
			int sum = sumIntegersFromFile(datFile);
			System.out.println("The sum is: " + sum);
			

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	public static int sumIntegersFromFile(File filename) throws FileNotFoundException {
	        // Initialize the sum to 0
	        int sum = 0;
	        
	        // Create a scanner to read the file
	        Scanner scanner = new Scanner(filename);
	        
	        // Loop through the numbers in the file and add them to the sum
	        while (scanner.hasNextInt()) {
	            sum += scanner.nextInt();
	        }
	        
	        return sum;
	    }
}
