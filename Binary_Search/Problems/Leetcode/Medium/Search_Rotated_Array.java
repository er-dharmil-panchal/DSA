package Binary_Search.Problems.Leetcode.Medium;

public class Search_Rotated_Array {
     public static void main(String[] args) {
          int arr[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
          int target = 1;

          System.out.println(solution(arr, target));
     }

     public static int solution(int arr[], int target) {
          int low = 0;
          int high = arr.length - 1;
          while (low <= high) {
               int mid = (low + high) / 2;

               if(arr[mid] == target) return mid;

               if (arr[low] <= arr[mid]) {
                    if (arr[low] <= target && target < arr[mid]) {
                         high = mid - 1;
                    } else {
                         low = mid + 1;
                    }
               } else {
                    if (arr[mid] < target && target <= arr[high]) {
                         low = mid + 1;
                    } else {
                         high = mid - 1;
                    }
               }
          }

          return -1;
     }
}