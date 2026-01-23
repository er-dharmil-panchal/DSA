package Binary_Search.Problems.Others.Medium;

// You are given a positive integer n. Your task is to find and return its square root.
//  If ‘n’ is not a perfect square, then return the floor value of sqrt(n).

// Input: N = 36
// Output: 6
// Explanation: Square root of 36 is 6. 

// Input: N = 28
// Output: 5
// Explanation: Square root of 28 is approximately 5.292. So, the floor value will be 5. 

public class SQRT {
     public static void main(String[] args) {
          int n = 35;

          System.out.println(brute(n));
          System.out.println(BS(n));
     }

     // brute approch (dont do this ever!)
     /*
      * TC - O(N)
      */
     public static int brute(int n) {
          int ans = 1;
          for (int i = 1; i <= n; i++) {
               if (i * i <= n) {
                    ans = i;
               } else {
                    break;
               }
          }

          return ans;
     }

     // better ! do this.
     /*
      * TC - O(LogN)
      */
     public static int BS(int n) {
          if(n == 0) return 0;
          int low = 1;
          int high = n;
          int ans = 1;

          while (low <= high) {
               int mid = low + (high - low) / 2;
               long sq = (long) mid * mid;
               if (sq <= n) {
                    ans = mid;
                    low = mid + 1;
               } else {
                    high = mid - 1;
               }
          }

          return ans;
     }
}
