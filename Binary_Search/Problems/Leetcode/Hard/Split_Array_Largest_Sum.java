package Binary_Search.Problems.Leetcode.Hard;

import java.util.Arrays;

/*
 * 
 * Leetcode - # 410 - Split Array Largest Sum 
 * 
 */


// Given an integer array nums and an integer k,
// split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.


// Example 2:
// Input: nums = [1,2,3,4,5], k = 2
// Output: 9
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

public class Split_Array_Largest_Sum {
     public static void main(String[] args) {
          int arr[] = new int[]{7,2,5,10,8};
          int k = 3;

          System.out.println(solution(arr, k));
     }

     public static int solution(int arr[], int k){
          // we have to find the maximum sub-array's sum 
          // if there is same number of k as the elements in the array, then the maximum number will be ans
          // if there is just k = 1, then the ans is sum of all elements.
          // so our range is [max -> sum]

          int high = Arrays.stream(arr).sum();
          int low = Arrays.stream(arr).max().getAsInt();
          int ans = -1;
          if (k > arr.length) return -1;

          while(low <= high){
               int mid = (low + high)/2;

               if(canPlace(arr, mid, k)){
                    high = mid - 1;
                    ans = mid;
               } else{
                    low = mid + 1;
               }
          }
          return ans;
     }

     public static boolean canPlace(int arr[], int mid, int k){
          int count = 1;
          int sum = 0;
          for(int i : arr){
               if(sum + i <= mid){
                    sum += i;
               } else{
                    count++;
                    sum = i;
               }
          }
          return count <= k;
     }
}
