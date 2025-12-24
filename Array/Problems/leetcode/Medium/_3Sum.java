package Array.Problems.leetcode.Medium;

import java.util.*;

/*
 * 
 * leetcode - # 15 - 3Sum
 * 
 */
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
public class _3Sum {
     public static void main(String[] args) {
          int arr[] = new int[] { -1, 0, 1, 2, -1, -4 };

          System.out.println((brute(arr)));
          System.out.println(better(arr));
          System.out.println(optimal(arr));
     }

     /*
      * TC - O(N^3)
      * SC - O(N^2)
      */
     public static Set<List<Integer>> brute(int arr[]) {
          Set<List<Integer>> set = new HashSet<>();
          for (int i = 0; i < arr.length - 2; i++) {
               for (int j = i + 1; j < arr.length - 1; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                         if (arr[i] + arr[j] + arr[k] == 0) {
                              List<Integer> l1 = new ArrayList<>();
                              l1.add(arr[i]);
                              l1.add(arr[j]);
                              l1.add(arr[k]);
                              Collections.sort(l1);
                              set.add(l1);
                         }
                    }
               }
          }
          return set;
     }

     /*
      * TC - O(N2)
      * SC - O(N2)
      */
     public static Set<List<Integer>> better(int arr[]) {
          Set<List<Integer>> set = new HashSet<>();
          for (int i = 0; i < arr.length - 1; i++) {
               HashSet<Integer> h1 = new HashSet<>();
               for (int j = i + 1; j < arr.length; j++) {
                    int sum = -(arr[i] + arr[j]);
                    if (h1.contains(sum)) {
                         List<Integer> l = new ArrayList<>();
                         l.add(arr[i]);
                         l.add(arr[j]);
                         l.add(sum);
                         Collections.sort(l);
                         set.add(l);
                    }
                    h1.add(arr[j]);
               }
          }
          return set;
     }

     public static List<List<Integer>> optimal(int arr[]) {
          Arrays.sort(arr);
          List<List<Integer>> list = new ArrayList<>();
          for (int i = 0; i < arr.length; i++) {
               if (i > 0 && arr[i] == arr[i - 1])
                    continue;

               int j = i + 1;
               int k = arr.length - 1;
               while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum < 0) {
                         j++;
                    } else if (sum > 0) {
                         k--;
                    } else {
                         List<Integer> ls = new ArrayList<>();
                         ls.add(arr[i]);
                         ls.add(arr[j]);
                         ls.add(arr[k]);
                         list.add(ls);
                         j++;
                         k--;
                         while(j<k && arr[j] == arr[j-1]) j++;
                         while(j<k && arr[k] == arr[k+1]) k--;
                    }
               }
          }
          return list;
     }
}
