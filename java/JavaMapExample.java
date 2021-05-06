import java.util.*;

/* This example illustrates the use of Generics (Java 1.5 and on) as 
  it applies to Map interface, which can be used only with a class, 
  namely HashMap, that implements this interface.
*/
class JavaMapExample {
  public static void main(String[] args) {

    // default initialization of a map
    Map<Integer, String> hashmap = new HashMap<>();
    hashmap.put(1, "Data");
    hashmap.put(2, "Structure");
    System.out.println(hashmap);

    // Generic initialization of a map
    Map<Integer, String> hashmap1 = new HashMap<Integer, String>();
    hashmap1.put(new Integer(1), "Data");
    hashmap1.put(new Integer(2), "Structure");
    System.out.println(hashmap1);
  }
}