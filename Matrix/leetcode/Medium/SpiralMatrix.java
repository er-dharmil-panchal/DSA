package Matrix.leetcode.Medium;

import java.util.*;

/*
 * 
 * leetcode - # 54 - Spiral matrix
 * 
 */

// Given an m x n matrix, return all elements of the matrix in spiral order.
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
public class SpiralMatrix {
     public static void main(String[] args) {
          int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

          System.out.println(leetcode(arr));
     }

     /*
      * TC - O(N x M)
      * SC - o(1)
      */
     public static List<Integer> leetcode(int arr[][]) {

          List<Integer> a1 = new ArrayList<>();
          int left = 0;
          int top = 0;
          int right = arr[0].length - 1;
          int bottom = arr.length - 1;

          while (left <= right && top <= bottom) {
               for (int i = left; i <= right; i++) {
                    a1.add(arr[top][i]);
                    // remember to change the constant in the index for this printing
               }
               top++;
               for (int i = top; i <= bottom; i++) {
                    a1.add(arr[i][right]);
                    // emember to change the constant in the index for this printing
               }
               right--;
               if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                         a1.add(arr[bottom][i]);
                    }
                    bottom--;
               }
               if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                         a1.add(arr[i][left]);
                    }
                    left++;
               }
          }
          return a1;
     }
}
