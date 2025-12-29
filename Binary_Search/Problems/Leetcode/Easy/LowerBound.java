package Binary_Search.Problems.Leetcode.Easy;

/*
 * 
 * leetcode - # 35 - Search insert position
 * 
 */

// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

// 🔥 Lower bound
// The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to a given key.

// Example 1:
// nput Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
// Result: 3
// Explanation: Index 3 is the smallest index such that arr[3] >= x.

// 🔥 Upper bound

// The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key.

// Example 1:
// Input Format: N = 6, arr[] = {3,5,8,9,15,19}, x = 9
// Result: 4
// Explanation: Index 4 is the smallest index such that arr[4] > x.
public class LowerBound {
     public static void main(String[] args) {
          int arr[] = new int[] { 1, 3, 5, 5, 5, 7 };
          int target = 5;

          // Search insert postion (same as lower bound) (leetcode - 35)
          System.out.println(lowerBound(arr, target));

          // Upper bound
          System.out.println(upperBound(arr, target));
     }

     /*
      * TC - O(LogN)
      * SC - O(1)
      */
     public static int lowerBound(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          int ans = arr.length;
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] >= target) {
                    ans = mid;
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return ans;
     }

     /*
      * TC - O(LogN)
      * SC - O(1)
      */
     public static int upperBound(int[] arr, int target) {
          int low = 0, high = arr.length - 1;
          int ans = arr.length;

          while (low <= high) {
               int mid = low + (high - low) / 2;

               if (arr[mid] > target) { // ONLY difference
                    ans = mid;
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return ans;
     }
}
