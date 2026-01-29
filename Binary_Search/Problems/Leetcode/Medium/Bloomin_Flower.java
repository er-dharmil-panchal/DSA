package Binary_Search.Problems.Leetcode.Medium;

import java.util.Arrays;

/*
 * 
 * leetcode - # 1482 - Minimum Number of Days to Make m Bouquets
 * 
 */

// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

/*
 * My Explenation -
 * 
 * we are given a time (days) to grow up the flowers in array
 * we also given that how many adjecent flower required to make a bouquets
 * and we have to find minimum days count to complete given number of bouquets.
 */

// Example - 1
// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

// Example - 2
// Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
// Output: -1

// Example - 3
// Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
// Output: 12

public class Bloomin_Flower {
     public static void main(String[] args) {
          int arr[] = new int[] { 7, 7, 7, 7, 12, 7, 7 };
          int m = 2; // number of bouquets
          int k = 3; // adjecent

          System.out.println(solution(arr, m, k));
     }

     /*
      * Time Complexity (TC): O(n log M)
      * n = number of flowers
      * M = maximum bloom day
      */
     public static int solution(int arr[], int m, int k) {

          // With micro-optimization i gain the TC from 34% to 91%
          long needed = (long) m * k;
          if (needed > arr.length) {
               return -1;
          }

          int low = 1;
          int high = 0;
          // use manual way increase the TC instead of using Math.max and Arrays.stream...
          for (int i = 0; i < arr.length; i++) {
               if (arr[i] > high)
                    high = arr[i];
          }

          int ans = -1;

          while (low <= high) {
               int mid = (low + high) / 2;
               int count = 0;
               int num = 0;
               for (int i : arr) {
                    if (mid >= i) {
                         count++;
                         if (count == k) {
                              num++;
                              count = 0;
                         }
                    } else {
                         count = 0;
                    }

               }
               if (m <= num) {
                    ans = mid;
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return ans;
     }
}
