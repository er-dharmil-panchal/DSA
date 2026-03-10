package Binary_Search.Problems.Others.Hard;

import java.util.Arrays;

/*
 * 
 *  Aggressive Cows
 * 
 */

// Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls.
//   You are also given an integer 'k' which denotes the number of aggressive cows.
// You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
//  Find the maximum possible minimum distance.

// Example 1:
// Input Format: N = 6, k = 4, arr[] = {0,3,4,7,10,9}
// Result: 3
// Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}.
//  Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

// Example 2:
// Input Format:  N = 5, k = 2, arr[] = {4,2,1,3,6}
// Result: 5
// Explanation: The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}. 

public class Aggressive_cows {
     public static void main(String[] args) {
          int arr[] = new int[] { 0, 3, 4, 7, 10, 9 };
          int cows = 4;

          System.out.println(brute(arr, cows));
          System.out.println(optimal(arr, cows));
     }

     /*
      * TC = O(max - min) x O(n)
      * SC = O(1)
      */
     public static int brute(int arr[], int cows) {
          Arrays.sort(arr); // sorting the array for better calcultion
          int maxDistance = arr[arr.length - 1] - arr[0]; // upper limit for the distance
          int ans = -1; // minimum distance's max possible ans

          // the range for the gap must be betweeen 1 to (max - min)
          for (int i = 1; i <= maxDistance; i++) {
               if (canPlace(arr, i, cows)) {
                    ans = i;
               } else {
                    break;
               }
          }

          return ans;
     }

     public static boolean canPlace(int arr[], int dist, int cows) {
          int cowCount = 1; // we put 1st cow in 0th index always
          int lastCow = arr[0];

          for (int i = 1; i < arr.length; i++) {
               if (arr[i] - lastCow >= dist) {
                    lastCow = arr[i];
                    cowCount++;
               }
               if (cowCount >= cows) {
                    return true;
               }
          }
          return false;
     }

     // just change the for loop into a binary search apporoch...
     /*
      * TC - O(N LogN)
      * SC - O(1)
      */
     public static int optimal(int arr[], int cows) {
          Arrays.sort(arr);
          int high = arr[arr.length - 1];
          int low = arr[0];
          int ans = -1;

          while (low <= high) {
               int mid = (low + high) / 2;
               // we are taking mid as a ans for the maximum of minimum distance of stalls.
               if (canPlace(arr, mid, cows)) {
                    low = mid + 1;
                    ans = mid;
               } else {
                    high = mid - 1;
               }
          }

          return ans;
     }
}
