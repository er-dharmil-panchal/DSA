package Binary_Search.Problems.Others.Easy;

// Example 1:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
// Result: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.
public class Floor_ceil {
     public static void main(String[] args) {
          int arr[] = new int[] { 10, 20, 30, 40, 50 };
          int target = 60;

          System.out.println(floor(arr, target));
          System.out.println(ceil(arr, target));
     }

     /*
      * TC - O(LogN)
      * SC - O(1)
      */
     public static int floor(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          int ans = arr.length;

          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] > target) {
                    high = mid - 1;
               } else {
                    ans = mid;
                    low = mid + 1;
               }
          }
          return ans == arr.length ? -1 : arr[ans];
     }

     /*
      * TC - O(LogN)
      * SC - O(1)
      */
     public static int ceil(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          int ans = arr.length;
          while (low <= high) {
               int mid = (low + high) / 2;
               if (arr[mid] >= target) {
                    ans = mid;
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return ans == arr.length ? -1 : arr[ans];
     }
}
