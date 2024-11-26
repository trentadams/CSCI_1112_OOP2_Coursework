package chapter17;
import java.io.*;
import java.util.Scanner;

public class Exercise17_14 {

    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt for input and output file names
        System.out.print("Enter the input file name: ");
        String inputFileName = scanner.nextLine();
        
        System.out.print("Enter the output file name: ");
        String outputFileName = scanner.nextLine();
        
        // Encrypt the file
        try {
            encryptFile(inputFileName, outputFileName);
            System.out.println("File encrypted successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        scanner.close();
    }

    // Function to encrypt the file by adding 5 to each byte
    public static void encryptFile(String inputFileName, String outputFileName) throws IOException {
        // Open the input file for reading
        try (FileInputStream inputFile = new FileInputStream(inputFileName);
             FileOutputStream outputFile = new FileOutputStream(outputFileName)) {
            
            // Read and process each byte from the input file
            int byteRead;
            while ((byteRead = inputFile.read()) != -1) {
                // Add 5 to the byte value (wrapping around if necessary)
                byte encryptedByte = (byte) ((byteRead + 5) % 256);
                
                // Write the encrypted byte to the output file
                outputFile.write(encryptedByte);
            }
        }
    }
}