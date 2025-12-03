package Array.Problems.leetcode.Easy;

import java.util.HashSet;

/*
 * 
 * Leetcode - # 217 - Contains Duplicates.
 * 
 */
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Input: nums = [1,2,3,1]
// Output: true

public class containsDuplicate {
     public static void main(String[] args) {
          int arr[] = new int[] { 1, 2, 1, 3 };
          System.out.println(containsDuplicate(arr));
     }

     /*
      * TC - O(N)
      * SC - O(N)
      * 
      * HashSet give more faster result then the HashMap,
      * Because HashSet stores only keys (no values), does fewer operations, and uses
      * less memory than HashMap — so it runs slightly faster.
      */
     public static boolean containsDuplicate(int[] nums) {
          HashSet<Integer> set = new HashSet<>();

          for (int i : nums) {
               if (!set.add(i)) {
                    return true;
               }
          }

          return false;
     }
}
