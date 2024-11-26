package chapter17;
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        File datFile = new File("exercise17_07.dat");

        // Writing Loan objects to the file
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(datFile))) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } catch (IOException ex) {
            System.out.println("File could not be opened: " + ex.getMessage());
        }

        // Call the outputData function to read and calculate the total loan amount
        outputData(datFile);
    }

    public static void outputData(File datFile) {
        double totalLoanAmount = 0;

        // Reading Loan objects from the file
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(datFile))) {
            while (true) {
                Loan loan = (Loan) input.readObject();
                totalLoanAmount += loan.getLoanAmount();
            }
        } catch (EOFException ex) {
            // End of file reached, we can stop reading
            System.out.println("End of file reached.");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }

        // Output the total loan amount
        System.out.println("Total loan amount: $" + totalLoanAmount);
    }
}
