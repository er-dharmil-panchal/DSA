package Binary_Search.Problems.Leetcode.Medium;

/*
 * 
 * leetcode - # 81 - Search in Rotated sorted array II.
 * 
 */

// There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
// Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
// Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
// You must decrease the overall operation steps as much as possible.

// Example 1:
// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true

public class II_Search_Rotated_Array {
     public static void main(String[] args) {
          int arr[] = new int[] { 2, 5, 6, 0, 0, 1, 2 };
          // int arr[] = new int[] { 1, 1, 3, 1 };
          int target = 6;

          System.out.println(solution(arr, target));
     }

     /*
      * TC - In worst case like [3,3,1,3,3,3] - shrinking can go upto near (N/2)
      * 
      * Best/AVG - O(LogN)
      * Worst - O(N/2) = O(N)
      */
     public static boolean solution(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          while (low <= high) {
               int mid = (low + high) / 2;

               if (arr[mid] == target)
                    return true;

               // duplicates block sorted-side detection
               if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                    low++;
                    high--;
                    continue;
               }

               if (arr[low] <= arr[mid]) {
                    if (arr[low] <= target && target < arr[mid]) {
                         high = mid - 1;
                    } else {
                         low = mid + 1;
                    }
               } else {
                    if (arr[mid] < target && target <= arr[high]) {
                         low = mid + 1;
                    } else {
                         high = mid - 1;
                    }
               }
          }
          return false;
     }
}
