package Array.Problems.leetcode.Easy;

import java.util.*;

/*
 * 
 * Leetcode - # 169 - Majority Element
 * 
 */

// Given an array nums of size n, return the majority element.

//  The majority element is the element that appears more than ⌊n / 2⌋ times. 
//   You may assume that the majority element always exists in the array.

/*
 *   Input: nums = [2,2,1,1,1,2,2]
     Output: 2
 */

/*
* Moore's Voting Algorithm
* ------------------------
* Goal: Find the element that appears more than n/2 times (majority element).
*
* Step 1: Find a candidate
*   - Keep a counter.
*   - If counter = 0, choose current element as candidate.
*   - If element == candidate → counter++
*     else → counter--
*
* Step 2: Verify the candidate
*   - Count how many times candidate appears.
*   - If count > n/2 → return candidate
*     else → no majority element
*
* Time: O(n)
* Space: O(1)
*/

public class majorityElement {
     public static void main(String[] args) {
          int arr[] = new int[] { 2, 2, 1, 1, 3, 2, 2, 2, 3 };

          System.out.println(brute(arr));
          System.out.println(better(arr));

          // leetcode
          System.out.println(leetcode(arr));
     }

     /*
      * 
      * TC - O(N^2)
      *
      * SC - O(1)
      *
      */
     public static int brute(int arr[]) {
          for (int i = 0; i < arr.length; i++) {
               int count = 0;
               for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                         count++;
                    }
               }
               if (count > arr.length / 2) {
                    return arr[i];
               }
          }

          return -1;
     }

     /*
      * 
      * TC - O(2N) = O(N)
      *
      * SC - O(N)
      *
      */
     public static int better(int arr[]) {
          Map<Integer, Integer> map = new HashMap<>();
          for (int i = 0; i < arr.length; i++) {
               map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
          }
          for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
               if (entry.getValue() > arr.length / 2) {
                    return entry.getKey();
               }
          }
          return -1;
     }

     // Moore's Voting Algo
     /*
      *
      * TC - O(2N) = O(N)
      *
      * SC - O(1)
      * 
      */
     public static int leetcode(int arr[]) {
          int count = 0;
          int element = -1;

          for (int i = 0; i < arr.length; i++) {
               if (count == 0) {
                    element = arr[i];
                    count++;
               }
               count += (arr[i] == element) ? 1 : -1;
          }
          count = 0;
          for (int i = 0; i < arr.length; i++) {
               if (arr[i] == element) {
                    count++;
               }
          }

          return (count > arr.length / 2) ? element : -1;
     }
}
