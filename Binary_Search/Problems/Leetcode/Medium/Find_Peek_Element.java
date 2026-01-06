package Binary_Search.Problems.Leetcode.Medium;

/*
 * 
 * leetcode - # 162 -  Find Peek Element
 * 
 */

// A peak element is an element that is strictly greater than its neighbors.
// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
// You must write an algorithm that runs in O(log n) time.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

public class Find_Peek_Element {
     public static void main(String[] args) {
          int arr[] = new int[] { 1,2,3,1 };

          System.out.println(solution(arr));
     }


     public static int solution(int arr[]){
          int low = 0;
          int high = arr.length - 1;
          while(low < high){
               int mid = (low+high)/2;

               if(arr[mid] < arr[mid+1]){
                    low = mid + 1;
               } else{
                    high = mid;
               }
          }

          return low;
     }




     // never do this....


     // public static int solution(int arr[]) {
     //      int low = 0;
     //      int high = arr.length - 1;

     //      if (arr.length == 1)
     //           return 0;
     //      while (low < high) {
     //           int mid = (low + high) / 2;

     //           if (mid == 0 ) {
     //                if(arr[mid] > arr[mid + 1])
     //                     return 0;
     //                else{
     //                     return 1;
     //                }
     //           }

     //           if (mid == arr.length - 1 && arr[mid] > arr[mid - 1]) {
     //                return mid;
     //           }

     //           if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
     //                return mid;
     //           }

     //           if (arr[mid + 1] > arr[mid]) {
     //                low = mid + 1;
     //           } else if (arr[mid - 1] > arr[mid]) {
     //                high = mid - 1;
     //           }
     //      }

     //      return -1;
     // }
}
