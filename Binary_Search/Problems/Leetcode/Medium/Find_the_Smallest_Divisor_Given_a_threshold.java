package Binary_Search.Problems.Leetcode.Medium;

/*
 * 
 * leetcode - 1283 - Find_the_Smallest_Divisor_Given_a_threshold
 * 
 */

// Given an array of integers nums and an integer threshold,
// we will choose a positive integer divisor,divide all the array by it,
// and sum the division'sresult.Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

// Each result of the division is rounded to the nearest integer greater than or equal to that element.(For example:7/3=3 and 10/2=5).

// The test cases are generated so that there will be an answer.

// Example :

// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

// Input: nums = [44,22,33,11,1], threshold = 5
// Output: 44

public class Find_the_Smallest_Divisor_Given_a_threshold {
     public static void main(String[] args) {
          int arr[] = new int[] { 44, 22, 33, 11, 1 };
          int thr = 5;

          System.out.println(solution(arr, thr));
     }

     /*
      * TC - O(n * Log M)
      * n = length of the array
      * M = maximum value in the array (search range for divisor)
      * 
      */
     public static int solution(int arr[], int thr) {
          int low = 1;
          int high = 0;

          // use manual way increase the TC instead of using Math.max and Arrays.stream...
          for (int i = 0; i < arr.length; i++) {
               if (arr[i] > high)
                    high = arr[i];
          }
          int ans = -1;

          while (low <= high) {
               int mid = (low + high) / 2;
               int sum = 0;

               // 🔥 Key point
               for (int i : arr) {
                    sum += ((i + mid - 1) / mid);
               } 

               if (sum > thr) {
                    low = mid + 1;
               } else {
                    ans = mid;
                    high = mid - 1;
               }
          }

          return ans;
     }
}
