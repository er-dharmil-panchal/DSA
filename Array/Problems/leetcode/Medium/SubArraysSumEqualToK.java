package Array.Problems.leetcode.Medium;

import java.util.*;

/*
 * 
 * leetcode - # 560 -  Subarrays sum equal to k
 * 
 */
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [1,1,1], k = 2
// Output: 2

public class SubArraysSumEqualToK {
     public static void main(String[] args) {
          int arr[] = new int[] { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
          int k = 3;
          System.out.println(brute(arr, k));
          System.out.println(leetcode(arr, k));
     }

     /*
      * TC - O(N^2)
      * SC - O(1)
      */
     public static int brute(int arr[], int k) {
          int count = 0;
          for (int i = 0; i < arr.length; i++) {
               int sum = 0;
               for (int j = i; j < arr.length; j++) {
                    sum += arr[j];
                    if (sum == k) {
                         count++;
                    }
               }
          }
          return count;
     }

     // In Two Sum we did the same kind of job, but there we stored the
     // index of the values.
     //
     // Here we store the *prefix sum* instead, because subarray means
     // *continuous part of the array* (not a subsequence).
     //
     // For every current prefix sum, we check how many times
     // (prefixSum - k) already exists in the map.
     // That count directly tells us how many subarrays ending at
     // the current index have sum = k.
     // While counting the prefix sum at each step, we check how many times
     // (prefixSum - k) is already stored in the map, because each occurrence
     // represents one valid subarray ending at the current index.

     /*
      * TC - O(N)
      * SC - O(N)
      */
     public static int leetcode(int arr[], int k) {
          Map<Integer, Integer> map = new HashMap<>();

          int preSum = 0;
          int count = 0;

          map.put(0, 1);

          for (int i = 0; i < arr.length; i++) {
               preSum += arr[i];
               int complement = preSum - k;
               if (map.containsKey(complement)) {
                    count += map.get(complement);
               }
               map.put(preSum, map.getOrDefault(preSum, 0) + 1);
          }

          return count;
     }
}
