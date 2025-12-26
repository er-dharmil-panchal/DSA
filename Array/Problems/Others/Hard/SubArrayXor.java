package Array.Problems.Others.Hard;

import java.util.HashMap;
import java.util.Map;

//Input: A = [4, 2, 2, 6, 4] , k = 6
// Output: 4
// Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

public class SubArrayXor {
     public static void main(String[] args) {
          int arr[] = new int[] { 4, 2, 2, 6, 4 };
          int k = 6;

          System.out.println(brute(arr, k));
          System.out.println(better(arr, k));
          System.out.println(optimal(arr, k));  
     }

     /*
      * TC - O(N^3)
      * SC - o(1)
      */
     public static int brute(int arr[], int k) {
          int count = 0;
          for (int i = 0; i < arr.length; i++) {
               for (int j = i; j < arr.length; j++) {
                    int xor = 0;
                    for (int k1 = i; k1 <= j; k1++) {
                         xor ^= arr[k1];
                    }
                    if (xor == k) {
                         count++;
                    }
               }
          }

          return count;
     }


     /*
      * TC - O(N^2)
      * SC - o(1)
      */
     public static int better(int arr[], int k){
          int count = 0;
          for (int i = 0; i < arr.length; i++) {
               int xor = 0;
               for (int j = i; j < arr.length; j++) {
                    xor^=arr[j];
                    if(xor == k){
                         count++;
                    }
               }
          }
          return count;
     }

     /*
      * TC - O(N)
      * SC - O(N)
      */
     public static int optimal(int arr[], int k) {
          Map<Integer, Integer> map = new HashMap<>();
          int preXor = 0;
          int count = 0;
          map.put(0, 1);
          for (int i = 0; i < arr.length; i++) {
               preXor ^= arr[i];
               if (map.containsKey(preXor ^ k)) {
                    count += map.get(preXor ^ k);
               }
               map.put(preXor, map.getOrDefault(preXor, 0) + 1);
          }
          return count;
     }
}
