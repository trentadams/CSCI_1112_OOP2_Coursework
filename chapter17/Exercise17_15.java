package chapter17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise17_15 {
	public static void main(String[] args) {
        // Create a Scanner obj
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the encrypted file name
        System.out.print("Enter the name of the encrypted file: ");
        String inputFileName = scanner.nextLine();

        // Prompt user to enter the output (decrypted) file name
        System.out.print("Enter the name of the output (decrypted) file: ");
        String outputFileName = scanner.nextLine();

        // Perform decryption
        try {
            decryptFile(inputFileName, outputFileName);
            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            System.out.println("Error during decryption: " + e.getMessage());
        }
    }

    public static void decryptFile(String inputFileName, String outputFileName) throws IOException {
        // Open the input file for reading
        FileInputStream inputFile = new FileInputStream(inputFileName);
        // Open the output file for writing
        FileOutputStream outputFile = new FileOutputStream(outputFileName);

        int byteData;
        
        // Read the encrypted file byte by byte
        while ((byteData = inputFile.read()) != -1) {
            // Decrypt the byte by subtracting 5
            byteData -= 5;
            // Write the decrypted byte to the output file
            outputFile.write(byteData);
        }

        // Close the input and output files
        inputFile.close();
        outputFile.close();
    }
}
