package Array.Problems.Others.Easy;

import java.util.*;

public class LeadersInArray {
     public static void main(String[] args) {
          int arr[] = new int[] { 10, 22, 12, 3, 0, 6 };

          brute(arr);
          optimal(arr);
     }

     /*
      * TC - O(N^2)
      * SC - O(N) (Just for the ans)
      */
     public static void brute(int arr[]) {
          ArrayList<Integer> al = new ArrayList<>();
          for (int i = 0; i < arr.length; i++) {
               boolean leader = true;
               for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] < arr[j]) {
                         leader = false;
                    }
               }
               if (leader) {
                    al.add(arr[i]);
               }
          }

          System.out.println(al);
     }

     
     /*
      * TC - O(N)
      * SC - O(N) (Just for the ans)
      */
     public static void optimal(int arr[]) {
          ArrayList<Integer> al = new ArrayList<>();
          int max = Integer.MIN_VALUE;
          for (int i = arr.length - 1; i >= 0; i--) {
               if (arr[i] > max) {
                    max = arr[i];
                    al.add(max);
               }
          }
          System.out.println(al);
     }
}
