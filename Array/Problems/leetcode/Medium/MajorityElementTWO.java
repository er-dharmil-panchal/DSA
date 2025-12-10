package Array.Problems.leetcode.Medium;

import java.util.*;

/*
 * 
 * leetcode - # 229 - Majority Element II
 * 
 * Simmiler to Majority Element (leetcode - 169)
 * 
 */
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
public class MajorityElementTWO {
     public static void main(String[] args) {
          int arr[] = new int[] { 3, 2, 3 };
          // int arr[] = new int[] {2,1};
          // int arr[] = new int[] {1};

          int ans[] = leetcode(arr);
          System.out.println(Arrays.toString(ans));
     }

     /*
      * TC - O(2N) = O(N)
      * SC - O(1)
      */
     public static int[] leetcode(int arr[]) {
          int el1 = -1, el2 = -1;
          int c1 = 0, c2 = 0;

          for (int i = 0; i < arr.length; i++) {
               if (arr[i] == el1) {
                    c1++;
               } else if (arr[i] == el2) {
                    c2++;
               } else if (c1 == 0) {
                    el1 = arr[i];
                    c1++;
               } else if (c2 == 0) {
                    el2 = arr[i];
                    c2++;
               }
               // if element neither el1 nor el2
               else {
                    c1--;
                    c2--;
               }
          }

          c1 = 0;
          c2 = 0;
          for (int i = 0; i < arr.length; i++) {
               if (arr[i] == el1) {
                    c1++;
               } else if (arr[i] == el2) {
                    c2++;
               }
          }
          int ans[] = new int[2];
          if (c1 > arr.length / 3) {
               ans[0] = el1;
          }
          if (c2 > arr.length / 3) {
               ans[1] = el2;
          }

          return ans;
     }
}
