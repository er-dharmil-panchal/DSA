package Matrix.leetcode.Medium;

/*
 * 
 * leetcode - # 48 - Rotate Image
 * 
 */

// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
public class RotateImage {
     public static void main(String[] args) {
          int arr[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
          brute(arr);
          optimal(arr);
     }

     /*
      * TC - O(N^2)
      * SC - O(N^2)
      */
     public static void brute(int arr[][]) {
          int ans[][] = new int[arr.length][arr.length];

          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr.length; j++) {
                    ans[j][arr.length - 1 - i] = arr[i][j];
               }
          }

          // printing

          // for (int i[] : ans) {
          // for (int j : i) {
          // System.out.print(j + " ");
          // }
          // System.out.println();
          // }
     }

     /*
      * TC - O(N^2)
      * SC - O(1)
      */
     public static void optimal(int arr[][]) {

          // trans of arr
          for (int i = 0; i < arr.length; i++) {
               for (int j = i + 1; j < arr.length; j++) {
                    if (i != j) {
                         int temp = arr[i][j];
                         arr[i][j] = arr[j][i];
                         arr[j][i] = temp;
                    }
               }
          }

          /*
           * 1 4 7
           * 2 5 8
           * 3 6 9
           */

          // just reverse of individual row's columns
          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr.length / 2; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[i][arr.length - 1 - j];
                    arr[i][arr.length - 1 - j] = temp;
               }
          }

          /*
           * 7 4 1
           * 8 5 2
           * 9 6 3
           */

          // printing

          // for (int i[] : arr) {
          // for (int j : i) {
          // System.out.print(j + " ");
          // }
          // System.out.println();
          // }
     }
}
