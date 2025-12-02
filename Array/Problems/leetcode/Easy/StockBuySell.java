package Array.Problems.leetcode.Easy;

/*
 * 
 * Leetcode - # 121 - Best time to buy and sell stock
 * 
 */
/*
 * 
     You are given an array prices where prices[i] is the price of a given stock on the ith day.

     You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     
     Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

//   Input: prices = [7,1,5,3,6,4]
//   Output: 5
//   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//   Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

public class StockBuySell {
     public static void main(String[] args) {
          int arr[] = new int[] { 7, 1, 5, 3, 6, 4 };

          System.out.println(optimal(arr));
     }

     // Simmiler concept of kadane's algo
     /*
      * the buying of the stock must be at low value
      * so check the buy value is min from previous or not.
      * then if next value is grater then the buy , then find the difference and max
      * it
      * we will get the max profit at the end of the array.
      * 
      * 
      * TC - O(N)
      * SC - O(1)
      */
     public static int optimal(int arr[]) {
          int max = 0;
          int buy = Integer.MAX_VALUE;
          int prof = 0;

          for (int i = 0; i < arr.length; i++) {
               if (arr[i] < buy) {
                    buy = arr[i];
                    continue;
               }
               if (arr[i] > buy) {
                    prof = arr[i] - buy;
                    max = Math.max(max, prof);
               }
          }
          return max;
     }
}
