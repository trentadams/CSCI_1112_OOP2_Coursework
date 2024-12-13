package chapter19;

public class Exercise19_05 {
	  public static void main(String[] args) {
	    Integer[] numbers = {1, 2, 3};
	    System.out.println("Max in numbers: " + maxElement(numbers));
	    
	    String[] words = {"red", "green", "blue"};
	    System.out.println("Max in words: " + maxElement(words));
	    
	    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
	    System.out.println("Max in circles: " + maxElement(circles));
	  }

	  // Generic method to find the max element
	  public static <T extends Comparable<T>> T maxElement(T[] array) {
	    T max = array[0];  // Assume the first element is the max initially
	    for (int i = 1; i < array.length; i++) {
	      if (array[i].compareTo(max) > 0) {
	        max = array[i];  // Update max if current element is greater
	      }
	    }
	    return max;
	  }

	  // Circle class implementing Comparable to compare based on radius
	  static class Circle implements Comparable<Circle> {
	    double radius;

	    public Circle(double radius) {
	      this.radius = radius;
	    }

	    @Override
	    public int compareTo(Circle c) {
	      if (radius < c.radius)
	        return -1;
	      else if (radius == c.radius)
	        return 0;
	      else
	        return 1;
	    }

	    @Override
	    public String toString() {
	      return "Circle radius: " + radius;
	    }
	  }
	}