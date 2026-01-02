package Binary_Search.Problems.Leetcode.Medium;

/*
 * 
 * leetcode - # 33 - Search in rotated sorted array.
 * 
 */

//  There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

// Example:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
public class Search_Rotated_Array {
     public static void main(String[] args) {
          int arr[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
          int target = 1;

          System.out.println(solution(arr, target));
     }

     public static int solution(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          while (low <= high) {
               int mid = (low + high) / 2;

               if (arr[mid] == target)
                    return mid;

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

          return -1;
     }
}