package Binary_Search.Problems.Others.Easy;

// Count occurrences.

// 🔥 Can do with Lowerbound + Upperbound
// 🔥 Can do with pure binary search as did in leetcode(34).(First and last occurrences)

public class countOccurrence {
     public static void main(String[] args) {
          int arr[] = new int[] { 5, 7, 7, 8, 8, 10 };
          int target = 8;

          System.out.println(occurrences(arr, target));
     }

     /*
      * TC - O(LogN)
      * SC - O(1)
      */
     public static int occurrences(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          int start = -1;
          int end = -1;
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] == target) {
                    start = mid;
                    high = mid - 1;
               } else if (arr[mid] > target) {
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          if (start == -1) return 0;
          low = 0;
          high = arr.length - 1;
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] == target) {
                    end = mid;
                    low = mid + 1;
               } else if (arr[mid] > target) {
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }

          return end - start + 1;
     }
}
