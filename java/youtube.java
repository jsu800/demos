import java.util.Stack;
import java.util.Arrays;

public class AsteroidCollision {
   public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(Arrays.toString(sol.asteriodCollision(new int[]{5, -10})));
      System.out.println(Arrays.toString(sol.asteriodCollision(new int[]{100,1,1,1,1,1,-10})));
   }
}

/**
 * PURPOSE: Derive the resulting aseriods traveling at the same speed after collision(s)
 * PARAMETERS: 
 *    int[], collection of asteriods traveling at the same speed in different directions.
 * RETURN VALUES:
 *    int[], the resulting asteriods after collision(s)
 */
class Solution {
   public int[] asteriodCollision(int[] asteriods) {
      Stack<Integer> stack = new Stack();
      for (int a : asteriods) {
         boolean isIntact = true;
         while (!stack.isEmpty() && a<0 && stack.peek()>0) {
            
            // Three Conditions 
            // 1: |ai| > |ai-1|, then ai-1 explodes
            // 2: |ai| == |ai-1|, then both explode
            // 3: |ai| < |ai-1|, then ai explodes

            if (stack.peek() < Math.abs(a)) {
               stack.pop(); 
               continue;
            }
            if (stack.peek() == Math.abs(a)) {
               stack.pop();               
            }
            isIntact = false;
            break;
         }
         if (isIntact == true)
            stack.push(a);
      }
      int retVal[] = new int[stack.size()];
      for (int i=retVal.length-1; i>=0; --i) {
         retVal[i] = stack.pop();
      }
      return retVal;
   }

}