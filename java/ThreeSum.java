import java.util.*;

public class ThreeSum {
   public static void main(String[] args) {
      Solution sol = new Solution(); 
      System.out.println(sol.getTriplets(new int[]{-1,0,1,2,-1,-4}));
   }
}

/**
 * PURPOSE: Given an integer array nums, return all the triplets 
 *    [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
 *    and nums[i] + nums[j] + nums[k] == 0.
 * PARAMETERS: 
 *    int[], nums
 * RETURN VALUES:
 *    List<List<Integer>>, a list of lists consisting the triplets.
 * CONSTRAINTS:
 *    1. 0 <= nums.length <= 3000
 *    2. -105 <= nums[i] <= 105
 * REFERENCE: 
 *    https://leetcode.com/problems/3sum/
 */
class Solution {
   public List<List<Integer>> getTriplets(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> retVal = new ArrayList<>();
      for (int i=0; i<nums.length && nums[i]<=0; i++) {
         if (i>0 && nums[i-1]==nums[i]) continue;
         int j = i+1, k=nums.length-1;
         while (j<k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum < 0) {
               j++;
            } else if (sum > 0) {
               k--;
            } else {
               retVal.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
               while (j<k && nums[j]==nums[j-1]) j++;
            }
         }
      }
      return retVal;
   }

}