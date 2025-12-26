package Array.Problems.leetcode.Medium;

import java.util.*;

/*
 * 
 * 
 * leetcode - # 128 -  Longest consicutive sequance
 * 
 * 
 */
// You are given an unsorted integer array nums.

// Your task is to find the length of the longest sequence of consecutive integers that can be formed from the array.
// A consecutive sequence means numbers that follow each other in order with a difference of 1.

// The numbers do not need to be adjacent in the array.
// You must solve this problem in O(n) time complexity.

// input:
// nums = [100, 4, 200, 1, 3, 2]
// Output: 4

// Explanation:
// The longest consecutive sequence is:
// [1, 2, 3, 4]
// Length = 4

public class LongestConsicutiveSequance {
     public static void main(String[] args) {
          int arr[] = new int[] { 102, 4, 100, 1, 101, 3, 2, 1, 1 };

          System.out.println(better(arr));
          System.out.println(optimal(arr));
     }

     /*
      * TC - O(N * N LogN) = O(N LogN)
      * SC - O(1)
      */
     public static int better(int arr[]) {
          int len = 1;
          int max = Integer.MIN_VALUE;
          int lastSmall = Integer.MIN_VALUE;
          Arrays.sort(arr);

          for (int i = 0; i < arr.length; i++) {
               if (arr[i] == lastSmall + 1) {
                    len++;
                    lastSmall = arr[i];
               } else if (arr[i] != lastSmall) {
                    max = Math.max(max, len);
                    len = 1;
                    lastSmall = arr[i];
               }
          }
          return max;
     }

     public static int optimal(int arr[]){
          HashSet<Integer> h = new HashSet<>();
          for(int i : arr){
               h.add(i);
          }
          int max = Integer.MIN_VALUE;
          for(int i : h){
               if(!h.contains(i-1)){
                    int len = 1;
                    int x = i;
                    while(h.contains(x+1)){
                         len++;
                         x++;
                    }
                    max = Math.max(len, max);
               }
          }
          return max;
     }
}
