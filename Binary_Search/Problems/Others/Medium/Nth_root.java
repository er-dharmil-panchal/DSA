package Binary_Search.Problems.Others.Medium;

// Nth Root of a Number using Binary Search

// Problem Statement: Given two numbers N and M, find the Nth root of M.
// The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

// Input: N = 3, M = 27
// Output: 3
// Explanation: The cube root of 27 is equal to 3.

// Input : N = 4, M = 69
// Output: -1
// Explanation : The 4th root of 69 does not exist. So, the answer is -1.

public class Nth_root {
     public static void main(String[] args) {
          int n = 5;
          int m = 32;

          System.out.println(solution(n, m));
     }

     /*
      * Tc of the math.pow is O(logN)
      * 
      * TC = O(LogN x LogN)
      */
     public static int solution(int n, int m) {
          int low = 1;
          int high = m;

          while (low <= high) {
               int mid = (low + high) / 2;
               int val = (int) Math.pow(mid, n);

               if (val == m) {
                    return mid;
               } else if (val > m) {
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }

          return -1;
     }
}
