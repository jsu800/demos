import java.util.*;

public class OrphanSingleParentNodes {
   public static void main(String[] args) {
      int[][] parentChildPairs = new int[][] {
         {1,3}, {2,3}, {3,6}, {5,6}, {15,9},
         {5,7}, {4,5}, {4,8}, {4,9}, {9,11}
      };
      Solution sol = new Solution();
      ArrayList[] lists = sol.findPairs(parentChildPairs);
      System.out.println(lists[0]);
      System.out.println(lists[1]);
   }
}

/**
 * PURPOSE: Find a list of zero-parent nodes (orphans) and a list of single-parent nodes from a 
 *    undirected acyclic graph.
 * PARAMETERS: 
 *    int[][], an array of pairs of parent and child nodes in a graph.
 * RETURN VALUES:
 *    ArrayList<Integer>[], an array of lists. The first list contains a list of orphans, whereas
 *    the 2nd list contains a list of single-parent nodes from the input graph.
 */
class Solution {
   public ArrayList<Integer>[] findPairs(int[][] pairs) {

      ArrayList<Integer>[] retVal = new ArrayList[2];

      Map<Integer, Integer> childCountByParent = new HashMap<>();
      Map<Integer, Integer> parentCountByChild = new HashMap<>();

      for (int i = 0; i < pairs.length; i++) {
         childCountByParent.put(pairs[i][0], 
         childCountByParent.getOrDefault(pairs[i][0], 0)+1);
         parentCountByChild.put(pairs[i][1], 
            parentCountByChild.getOrDefault(pairs[i][1], 0)+1);
      }
      if (childCountByParent.isEmpty())
         retVal[0] = new ArrayList<Integer>();
      else {
         ArrayList<Integer> list = new ArrayList<Integer>();
         Iterator it = childCountByParent.entrySet().iterator();
         while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            // this parent node cannot be a child node elsewhere 
            if (parentCountByChild.get((int)pair.getKey())==null) {
               list.add((int)pair.getKey());
            }
         }
         retVal[0] = list;
      }

      if (parentCountByChild.isEmpty())
         retVal[1] = new ArrayList<Integer>();
      else {
         ArrayList<Integer> list = new ArrayList<Integer>();
         Iterator it = parentCountByChild.entrySet().iterator();
         while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            // this child node cannot have more than 1 parents in the counts
            if ((int)pair.getValue() == 1) {
               list.add((int)pair.getKey());
            }
         }
         retVal[1] = list;
      }
      return retVal;
   }

}