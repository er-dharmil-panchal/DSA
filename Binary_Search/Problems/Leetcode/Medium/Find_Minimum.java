package Binary_Search.Problems.Leetcode.Medium;

/*
 * 
 * leetcode - # 153 - Find Minimum in Rotated Sorted Array
 * 
 */

// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
// You must write an algorithm that runs in O(log n) time.

// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

public class Find_Minimum {
     public static void main(String[] args) {
          // int arr[] = new int[]{3,4,5,1,2};
          int arr[] = new int[] { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 };

          System.out.println(solution1(arr));

          // better and easy
          System.out.println(solution2(arr));
     }

     /*
      * TC - O(LogN)
      */
     public static int solution1(int arr[]) {
          int low = 0;
          int high = arr.length - 1;
          int ans = Integer.MAX_VALUE;
          while (low <= high) {
               int mid = (low + high) / 2;
               int min = Math.min(arr[low], arr[high]);
               ans = Math.min(ans, arr[mid]);

               if (arr[high] == min && arr[mid] > arr[high]) {
                    low = mid + 1;
               } else {
                    high = mid - 1;
               }
          }

          return ans;
     }

     // 🔥 Clean and Better
     /*
      * TC - O(LogN)
      */
     public static int solution2(int arr[]) {
          int low = 0;
          int high = arr.length - 1;
          while (low < high) {
               int mid = (low + high) / 2;
               if (arr[mid] > arr[high]) {
                    low = mid + 1;
               } else {
                    high = mid;
               }
          }
          return arr[low];
     }
}
