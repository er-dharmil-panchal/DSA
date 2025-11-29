package Array.Problems.leetcode.Medium;

/*
 * 
 * leetcode - # 53 - Maximum subarray
 * 
 */
public class MaximumSubArray {
     public static void main(String[] args) {
          int arr[] = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };

          System.out.println(brute(arr));
          System.out.println(better(arr));

          // leetcode
          System.out.println(leetcode(arr));
          printArray(arr);
     }

     /*
      * TC - O(N^2) (nearly)
      * SC - O(1)
      */
     public static int brute(int arr[]) {
          int max = Integer.MIN_VALUE;
          for (int i = 0; i < arr.length; i++) {
               for (int j = i; j < arr.length; j++) {
                    int sum = 0;
                    for (int k = i; k <= j; k++) {
                         sum += arr[k];
                    }
                    max = Math.max(max, sum);
               }
          }
          return max;
     }

     /*
      * TC - O(N^3) (nearly)
      * SC - O(1)
      */
     public static int better(int arr[]) {
          int max = Integer.MIN_VALUE;
          for (int i = 0; i < arr.length; i++) {
               int sum = 0;
               for (int j = i; j < arr.length; j++) {
                    sum += arr[j];
                    max = Math.max(max, sum);
               }
          }
          return max;
     }

     // Kadane's algo
     /*
      * 
      * TC - O(N)
      * SC - O(1)
      */
     public static int leetcode(int arr[]) {
          int sum = 0;
          int max = Integer.MIN_VALUE;
          for (int i = 0; i < arr.length; i++) {
               if (sum < 0)
                    sum = 0;
               sum += arr[i];
               if (sum > max)
                    max = sum;
          }
          return max;
     }

     public static void printArray(int arr[]) {
          int sum = 0;
          int max = Integer.MIN_VALUE;
          int tempStart = -1;
          int start = -1;
          int end = -1;
          for (int i = 0; i < arr.length; i++) {
               if (sum < 0){
                    sum = 0;
                    tempStart = i;
               }
               sum += arr[i];
               if (sum > max) {
                    max = sum;
                    start = tempStart;
                    end = i;
               }
          }
          System.out.println("Max Sum: " + max);
          System.out.print("Subarray: [");
          for (int i = start; i <= end; i++) {
               System.out.print(arr[i] + (i == end ? "" : ", "));
          }
          System.out.println("]");
     }
}
