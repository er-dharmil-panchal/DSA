package Binary_Search.Problems.Leetcode.Easy;

/*
 * 
 * leetcode - # 704 - Binary Search
 * 
 */

//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
// You must write an algorithm with O(log n) runtime complexity.

//Example 1:

// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4

public class BinarySearch {
     public static void main(String[] args) {
          int arr[] = new int[] { -1, 0, 3, 5, 9, 12 };
          int target = 9;

          System.out.println(iterate(arr, target));
          System.out.println(recurcive(arr, target, 0, arr.length - 1));
     }

     /*
      * TC = O(LogN)
      * SC - O(1)
      */
     public static int iterate(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] == target)
                    return mid;
               else if (arr[mid] > target)
                    high = mid - 1;
               else
                    low = mid + 1;
          }
          return -1;
     }

     /* 
      * TC = O(LogN)
      * SC - O(LogN) (due to recursion stakc)
      */
     public static int recurcive(int arr[], int target, int low, int high) {
          if (low > high) {
               return -1;
          }
          int mid = (low + high) / 2;
          if (arr[mid] == target) {
               return mid;
          } else if (arr[mid] < target) {
               return recurcive(arr, target, mid + 1, high);
          } else {
               return recurcive(arr, target, low, mid - 1);
          }
     }
}
