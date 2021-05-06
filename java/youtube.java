import java.util.*;

public class youtube {
   public static void main(String[] args) {
      Solution sol = new Solution(); 
      String[] keyNames = {"daniel","daniel","daniel","luis","luis","luis","luis"};
      String[] keyTimes = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
      System.out.println(sol.alertNames(keyNames, keyTimes));
   }
}

/**
 * PURPOSE: Find a list of employees who accessed a building for more than 3 times in an hour.
 * PARAMETERS: 
 *    String[] names, a list of employees 
 *    String[] times, a list of entry times for each employee in the above name list.
 * RETURN VALUES:
 *    List<String>, a list of employees accessing the building for more than 3 times in an hour.
 * CONSTRAINTS:
 * REFERENCE: 
 *
 */
class Solution {

   public List<String> alertNames(String[] keyName, String[] keyTime) {
      Map<String, Set<Integer>> nameToTime = new HashMap<>();
      for (int i = 0; i < keyName.length; ++i) {
          int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));  
          if (nameToTime.containsKey(keyName[i])) {
             nameToTime.get(keyName[i]).add(time);      
          } else {
             Set<Integer> set = new TreeSet<Integer>();
             set.add(time);
             nameToTime.put(keyName[i], set);
          }
      }
      TreeSet<String> names = new TreeSet<>();
      for (Map.Entry<String, Set<Integer>> e : nameToTime.entrySet()) {
          List<Integer> list = new ArrayList<>(e.getValue());
          for (int i = 2; i < list.size(); ++i) {
              if (list.get(i) - list.get(i - 2) <= 60 ) {
                  names.add(e.getKey());
                  break;
              }
          }
      }
      return new ArrayList<>(names);
  }

}