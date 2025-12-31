package Binary_Search.Problems.Leetcode.Medium;

import java.util.Arrays;
import Binary_Search.Problems.Leetcode.Easy.LowerBound;

/*
 * 
 * leetcode - # 34 - Find First and Last Posistion of Element in Sorted Array.
 * 
 */

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
public class first_and_last_occurrences {
     public static void main(String[] args) {
          int arr[] = new int[] { 5, 7, 7, 8, 8, 10 };
          int target = 8;

          brute(arr, target);
          better(arr, target);

          // pure binary search without using any lower,upper bound.
          pure(arr, target);
     }

     // DO not use this......
     /*
      * TC - O(N)
      * SC - O(1) or O(N)
      */
     public static void brute(int arr[], int target) {
          int start = -1;
          int end = -1;
          for (int i = 0; i < arr.length; i++) {
               if (arr[i] == target) {
                    if (start == -1) {
                         start = i;
                    }
                    end = i;
               }
          }

          System.out.println(Arrays.asList(start, end));
     }

     // 🔥 Using Lower Bound + Upper Bound.
     /*
      * TC - O(LogN)
      * SC - O(1) or O(N)
      */
     public static void better(int arr[], int target) {
          int start = LowerBound.lowerBound(arr, target);
          int end = LowerBound.upperBound(arr, target) - 1;

          // Validate
          if (start == arr.length || arr[start] != target) {
               start = -1;
               end = -1;
          }

          System.out.println(Arrays.asList(start, end));
     }

     // PURE
     /*
      * TC - O(LogN)
      * SC - O(1) or O(N)
      */
     public static void pure(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          int start = -1;
          int end = -1;
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] == target) {
                    start = mid;
                    high = mid - 1;
               } else if (arr[mid] > target)
                    high = mid - 1;
               else
                    low = mid + 1;
          }
          low = 0;
          high = arr.length - 1;
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] == target) {
                    end = mid;
                    low = mid + 1;
               } else if (arr[mid] > target)
                    high = mid - 1;
               else
                    low = mid + 1;
          }

          System.out.println(Arrays.asList(start, end));
     }
}
