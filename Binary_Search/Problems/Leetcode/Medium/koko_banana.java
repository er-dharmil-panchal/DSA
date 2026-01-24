package Binary_Search.Problems.Leetcode.Medium;

import java.util.*;

/*
 * 
 * leetcode - # 875 - Koko Eating Banana.
 * 
 */

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k.
// Each hour, she chooses some pile of bananas and eats k bananas from that pile.
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4

// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30

public class koko_banana {
     public static void main(String[] args) {
          int piles[] = new int[] { 3, 6, 7, 11 };
          int h = 8;

          System.out.println(solution(piles, h));
     }

     public static int solution(int arr[], int h) {
          int low = 1;
          int high = Arrays.stream(arr).max().getAsInt();

          while (low < high) {
               int mid = (low + high) / 2;
               int count = 0;
               for (int i = 0; i < arr.length; i++) {
                    count += (int) Math.ceil(((double) arr[i]) / mid);
               }
               if (count > h) {
                    low = mid + 1;
               } else {
                    high = mid;
               }

          }

          return low;
     }
}
