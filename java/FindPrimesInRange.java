import java.util.*;

public class FindPrimesInRange {
   public static void main(String[] args) {
      Solution sol = new Solution(); 
      try {
         System.out.println(sol.findAllPrimes(3, 2));
      } catch (Exception e) {
         System.out.println("error");
      }
   
   }
}

/**
 * PURPOSE:
 * PARAMETERS: 
 * RETURN VALUES:
 * CONSTRAINTS:
 * REFERENCE: 
 *
 */
class Solution {

   public List<Integer> findAllPrimes(int start, int end) throws Exception {
      List<Integer> listOfPrimes = new ArrayList<Integer>();
      if (end < start) {
         return listOfPrimes;
      }
      if (start > 0) listOfPrimes.add(1); 

      for (int i=start; i<=end; i++) {
         if (isPrime(i)==true) {
            listOfPrimes.add(i);
         }   
      }
      return listOfPrimes;
   }

   // prime is only divisible by itself, and 1
   private boolean isPrime(int number) {
      boolean isNotPrime = false; 
      if (number!=2 &&number%2==0) return isNotPrime;
      for (int i=3; i*i<=number; i+=2) {
         if (number%i==0) {
            isNotPrime = true;
            break;
         }
      }
      return !isNotPrime;
   }

}