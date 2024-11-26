package chapter17;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
public class Exercise17_01_2 {

	public static void main(String[] args) throws FileNotFoundException {
		// Generate text file
		File txtFile = new File("Exercise17-01.txt");
		
		// Create PrintWriter OBJ
		PrintWriter output = new PrintWriter(txtFile);
		
		// Create Random OBJ for random number generation
		Random random = new Random();
		int randomInt;
		
		//Write to the file
		for (int i = 0; i < 101; i++) {
			randomInt = random.nextInt(10);
			// Note: Writes as a hex value 
			output.print(randomInt + " ");
			System.out.print(randomInt + " ");
		}
		
		// Close the file
		output.close();
	}

}
