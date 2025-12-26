package Array.Problems.leetcode.Medium;

import java.util.*;

/*
 * 
 * leetcode - # 18 - 4Sum
 * 
 */

// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
// Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

// Example 2:
// Input: nums = [2,2,2,2,2], target = 8
// Output: [[2,2,2,2]]
public class _4Sum {
     public static void main(String[] args) {
          int arr[] = new int[] { 1, 0, -1, 0, -2, 2 };
          int target = 0;

          System.out.println(brute(arr, target));
          System.out.println(better(arr, target));
          System.out.println(leetcode(arr, target));
     }

     /*
      * TC - O(N^4)
      * SC - O(K)
      */
     public static Set<List<Integer>> brute(int arr[], int target) {
          Set<List<Integer>> set = new HashSet<>();
          for (int i = 0; i < arr.length - 3; i++) {
               for (int j = i + 1; j < arr.length - 2; j++) {
                    for (int k = j + 1; k < arr.length - 1; k++) {
                         for (int l = k + 1; l < arr.length; l++) {
                              if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                                   List<Integer> ls = new ArrayList<>();
                                   ls.add(arr[i]);
                                   ls.add(arr[j]);
                                   ls.add(arr[k]);
                                   ls.add(arr[l]);
                                   Collections.sort(ls);
                                   set.add(ls);
                              }
                         }
                    }
               }
          }

          return set;
     }

     public static Set<List<Integer>> better(int arr[], int target) {
          Set<List<Integer>> set = new HashSet<>();
          for (int i = 0; i < arr.length - 2; i++) {
               for (int j = i + 1; j < arr.length - 1; j++) {
                    Set<Integer> h1 = new HashSet<>();
                    for (int k = j + 1; k < arr.length; k++) {
                         int forth = target - (arr[i] + arr[j] + arr[k]);
                         if (h1.contains(forth)) {
                              List<Integer> ls = new ArrayList<>();
                              ls.add(arr[i]);
                              ls.add(arr[j]);
                              ls.add(arr[k]);
                              ls.add(forth);
                              Collections.sort(ls);
                              set.add(ls);
                         }
                         h1.add(arr[k]);
                    }
               }
          }
          return set;
     }

     public static List<List<Integer>> leetcode(int arr[], int target) {
          Arrays.sort(arr);
          List<List<Integer>> ls = new ArrayList<>();
          for (int i = 0; i < arr.length - 3; i++) {
               if (i > 0 && arr[i] == arr[i - 1])
                    continue;
               for (int j = i + 1; j < arr.length - 2; j++) {
                    if (j > i + 1 && arr[j] == arr[j - 1])
                         continue;
                    int k = j + 1;
                    int l = arr.length - 1;
                    while (k < l) {
                         long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                         if (sum > target) {
                              l--;
                         } else if (sum < target) {
                              k++;
                         } else {
                              List<Integer> list = new ArrayList<>();
                              list.add(arr[i]);
                              list.add(arr[j]);
                              list.add(arr[k]);
                              list.add(arr[l]);
                              ls.add(list);
                              k++;
                              l--;
                              while (k < l && arr[k] == arr[k - 1])
                                   k++;
                              while (k < l && arr[l] == arr[l + 1])
                                   l--;
                         }
                    }
               }
          }

          return ls;
     }
}
