package Binary_Search.Problems.Leetcode.Medium;

import Array.Problems.Others.Medium.intersectionArray;

/*
 * 
 * leetcode - # 1011 - Capacity_To_Ship_Packages_Within_D_Days
 * 
 */

// A conveyor belt has packages that must be shipped from one port to another within days days.

// The ith package on the conveyor belt has a weight of weights[i].Each day,
// we load the ship with packages on the conveyor belt(in the order given by weights).
// We may not load more weight than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

// Example :

// ===================
// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

// ===================
// Input: weights = [3,2,2,4,1,4], days = 3
// Output: 6
// Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
// 1st day: 3, 2
// 2nd day: 2, 4
// 3rd day: 1, 4

public class Capacity_To_Ship_Packages_Within_D_Days {
     public static void main(String[] args) {
          int arr[] = new int[] { 3,2,2,4,1,4 };
          int days = 3;

          System.out.println(solution(arr, days));
     }

     public static int solution(int arr[], int days) {
          int low = 1;
          int high = 0;
          int ans = -1;

          for (int i : arr) {
               high += i;
          }

          while (low <= high) {
               int mid = (low + high) / 2;
               int totalDay = 1;
               int sum = 0;
               for (int i : arr) {
                    if (sum + i <= mid) {
                         sum += i;
                    } else {
                         sum = i;
                         totalDay++;
                    }
               }
               if (sum != 0 ){
                    totalDay++;
               }

               if (totalDay <= days) {
                    if (totalDay == days) {
                         ans = mid;
                    }
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }

          return ans;
     }
}
