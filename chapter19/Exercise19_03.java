package chapter19;
import java.util.ArrayList;
import java.util.HashSet;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = removeDuplicates(list);
    
    System.out.print(newList);
  }

  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    // Convert ArrayList to HashSet to remove duplicates
    HashSet<Integer> set = new HashSet<>(list);

    // Convert the HashSet back to an ArrayList
    ArrayList<Integer> newList = new ArrayList<>(set);
    
    return newList;
  }
}