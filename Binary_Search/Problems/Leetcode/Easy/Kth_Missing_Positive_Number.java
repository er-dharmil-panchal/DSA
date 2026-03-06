package Binary_Search.Problems.Leetcode.Easy;

import java.util.Arrays;

/*
 * 
 * leetcode - # 1539 - Kth Missing Positive Number  
 * 
 */

// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.

// Example 1:

// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

// Example 2:

// Input: arr = [1,2,3,4], k = 2
// Output: 6
// Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

public class Kth_Missing_Positive_Number {
     public static void main(String[] args) {
          int arr[] = { 2, 3, 4, 7, 11 };
          int target = 5;

          System.out.println(solution(arr, target));
     }

     /*
      * 
      * TC - O(N)
      * SC - O(1)
      */
     public static int brute(int arr[], int target) {
          for (int i : arr) {
               if (i <= target) {
                    target++;
               } else {
                    break;
               }
          }
          return target;
     }

     /*
      * 
      * TC - O(Log N)
      * SC - O(1)
      */
     public static int solution(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;

          while (low <= high) {
               int mid = (low + high) / 2;

               int expected = arr[mid] - (mid + 1);

               if (expected < target) {
                    low = mid + 1;
               } else {
                    high = mid - 1;
               }
          }
          // arr[high] + more = arr[high] + k - missing = 7 + 5 - 3
          // arr[high] + target - (arr[high] - (high + 1))
          // target + high + 1
          return (target + high + 1);
     }

     public static int solutio1n(int arr[], int target) {
          int low = 1;
          int high = Arrays.stream(arr).max().getAsInt();

          while (low <= high) {
               int count = 0;
               int mid = (low + high) / 2;
               for (int i = 0; i < arr.length; i++) {
                    if (arr[i] >= mid) {
                         if (arr[i] == mid) {
                              count = 0;
                         }
                         break;
                    }

                    if (arr[i] < mid) {
                         count++;
                    }
               }

               int expected = (mid - count);
               if (count == 0) {
                    expected = 0;
               }
               if (expected == target) {
                    return mid;
               }

               if (expected < target || count == 0) {
                    low = mid + 1;
               } else {
                    high = mid - 1;
               }
          }

          return high + target;
     }
}
