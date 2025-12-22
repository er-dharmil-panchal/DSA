package Array.Problems.leetcode.Easy;

import java.util.*;

/*
 * 
 * Leetcode - # 118 - Pascal's Triangle
 * 
 */

//  Given an integer numRows, return the first numRows of Pascal's triangle.

// n Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
public class PascalTriangle {
     public static void main(String[] args) {
          int k = 5;

          // 1. provide you row and col value(starts with 1) , return the element
          int r = 5;
          int c = 2;
          System.out.println(oneBrute(r, c));
          System.out.println(oneBetter(r, c));

          // 2. give nth row of the triangle
          int n = 5;
          twoBrute(n);
          twoBetter(n);

          // 3. print entire triangle
          System.out.println(entireTriangle(k));
     }

     // using 3rd qestion's ans (entireTriangle)
     /*
      * TC - O(R^2)
      * SC - O(R^2)
      */
     public static int oneBrute(int r, int c) {
          List<List<Integer>> list = entireTriangle(r);
          List<Integer> la = list.get(r - 1);
          return la.get(c - 1);
     }

     // using nCr -> rCc (but r and c starts from 0)
     /*
      * TC - O(R)
      * Sc - O(1)
      */
     public static long oneBetter(int r, int c) {
          int N = r - 1;
          int R = c - 1;
          if (R > N) {
               return 0;
          }

          // 7C6 = 7C1
          if (R > N - R) {
               R = N - R;
          }

          long ans = 1;
          for (int i = 1; i <= R; i++) {
               ans = ans * (N - R + i) / i;
          }
          return ans;
     }

     /*
      * TC - O(N*R)
      * SC - O(1)
      */
     public static void twoBrute(int n) {
          for (int i = 1; i <= n; i++) {
               System.out.print(oneBetter(n, i) + " ");
          }
          System.out.println();
     }

     /*
      * TC - O(N)
      * SC - O(1)
      */
     public static void twoBetter(int n) {
          int ans = 1;
          System.out.print(ans + " ");

          for (int i = 1; i < n; i++) {
               ans = ans * (n - i) / i; // nCi = nC(i-1) * (n - i) / i
               System.out.print(ans + " ");
          }
          System.out.println();
     }

     /*
      * TC - O(N^2)
      * SC - O(N^2)
      */
     public static List<List<Integer>> entireTriangle(int n) {
          List<List<Integer>> list = new ArrayList<>();
          for (int i = 0; i < n; i++) {
               List<Integer> temp = new ArrayList<>();
               temp.add(1);
               if (i > 0) {
                    int j = 0;
                    List<Integer> le = list.get(i - 1);
                    while (j + 1 < i) {
                         int sum = le.get(j) + le.get(j + 1);
                         temp.add(sum);
                         j++;
                    }
                    temp.add(1);
               }
               list.add(temp);
          }

          return list;
     }
}
