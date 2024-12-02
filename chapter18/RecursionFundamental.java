package chapter18;

import java.util.Scanner;

public class RecursionFundamental {

    // Recursive method to compute GCD
    public static int gcd(int m, int n) {
        
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter two integers
        System.out.print("Enter the first integer: ");
        int m = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int n = scanner.nextInt();
        
        // Call the gcd method and display the result
        int result = gcd(m, n);
        System.out.println("The Greatest Common Divisor (GCD) of " + m + " and " + n + " is: " + result);
        
        // Close the scanner
        scanner.close();
    }
}
