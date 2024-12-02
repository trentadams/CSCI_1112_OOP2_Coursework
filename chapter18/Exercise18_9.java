package chapter18;

public class Exercise18_9 {

    public static void main(String[] args) {
        reverseDisplay("I Love Software Development");
    }

    public static void reverseDisplay(String value) {
        // Base case: If the string is empty, stop the recursion
        if (value.isEmpty()) {
            return;
        } else {
            // Recursively call reverseDisplay with the substring excluding the first character
            reverseDisplay(value.substring(1));
            
            // Print the first character after the recursive call
            System.out.print(value.charAt(0));
        }
    }
}
