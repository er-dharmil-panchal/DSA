package Matrix.leetcode.Medium;

import java.util.Arrays;

/*
 * 
 * leetcode - # 73 - Set Matrix Zeroes
 * 
 */
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
public class SetMatrixZeroes {
     public static void main(String[] args) {
          // int arr[][] = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
          // int arr[][] = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
          // int arr[][] = new int[][] { {1,0,3}, { 3, 4, 5}, { 1, 3, 1} };
          int arr[][] = new int[][] { { 0, 1, 2 },
                    { 3, 4, 0 },
                    { 5, 6, 7 } };

          // brute(arr);
          // better(arr);
          optimal(arr);
     }

     /*
      * TC - O(N x M) x O(N + M) + O(N x M)
      * TC - O(N^3)
      * SC - O(1)
      */
     public static void brute(int arr[][]) {
          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 0) {
                         // rows
                         for (int k = 0; k < arr[i].length; k++) {
                              if (arr[i][k] != 0) {
                                   arr[i][k] = -1;
                              }
                         }
                         // colums
                         for (int k = 0; k < arr.length; k++) {
                              if (arr[k][j] != 0) {
                                   arr[k][j] = -1;
                              }

                         }
                    }
               }
          }

          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == -1) {
                         arr[i][j] = 0;
                    }
               }
          }

          for (int[] i : arr) {
               for (int j : i) {
                    System.out.print(j + " ");
               }
               System.out.println();
          }
     }

     /*
      * TC - O(N × M)
      * SC - O(N + M)
      */
     public static void better(int arr[][]) {
          int col[] = new int[arr[0].length];
          int row[] = new int[arr.length];
          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 0) {
                         row[i] = 1;
                         col[j] = 1;
                    }
               }
          }

          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr[i].length; j++) {
                    if (row[i] == 1 || col[j] == 1) {
                         arr[i][j] = 0;
                    }
               }
          }

          for (int[] i : arr) {
               for (int j : i) {
                    System.out.print(j + " ");
               }
               System.out.println();
          }
     }

     /*
      * TC - O(N * M)
      * SC - O(1)
      */
     public static void optimal(int arr[][]) {
          int arr1 = arr[0][0];

          for (int i = 0; i < arr.length; i++) {
               for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == 0) {
                         if (j == 0) {
                              arr1 = 0;
                         } else {
                              arr[0][j] = 0;
                              arr[i][0] = 0;
                         }
                    }
               }
          }

          // from 1,1 to end of the arrays, because we cant change the notation row and
          // columns
          for (int i = 1; i < arr.length; i++) {
               for (int j = 1; j < arr[i].length; j++) {
                    if (arr[0][j] == 0 || arr[i][0] == 0) {
                         arr[i][j] = 0;
                    }
               }
          }

          // first we are sorting the row then come to col , Why?, because row depend on
          // the first element of the column
          // starting from 1, because , if we change 0,0 to 0 -> then the entire first row
          // will be 0

          // for row
          if (arr[0].length == 1 && arr1 == 0) {
               arr[0][0] = 0;

          } else {
               for (int i = 1; i < arr[0].length; i++) {
                    if (arr[0][0] != 0) {
                         break;
                    } else {
                         arr[0][i] = 0;
                    }
               }
          }

          // for column
          for (int i = 0; i < arr.length; i++) {
               if (arr1 != 0) {
                    break;
               } else {
                    arr[i][0] = 0;
               }
          }

          // for (int[] i : arr) {
          // for (int j : i) {
          // System.out.print(j + " ");
          // }
          // System.out.println();
          // }
     }
}
