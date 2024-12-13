package chapter19;
import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    
    // Call the sort method
    sort(list);
    
    // Print the sorted list
    System.out.print(list);
  }

  // Generic method to sort the ArrayList
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size() - 1 - i; j++) {
        if (list.get(j).compareTo(list.get(j + 1)) > 0) {
          // Swap elements if they are in the wrong order
          E temp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, temp);
        }
      }
    }
  }
}