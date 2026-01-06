package Binary_Search.Problems.Leetcode.Medium;

/*
 * 
 * leetcode - # 540 - Single Element in Sorted Array
 * 
 */

// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
public class Single_Element {
     public static void main(String[] args) {
          // int arr[] = new int[]{1,1,2,2,3,3,4,8,8};
          int arr[] = new int[] { 3, 3, 4, 4, 8 };

          // real solution
          System.out.println(solution(arr));

          // recall of Array problem which have TC - O(N)
          // System.out.println(array_solution(arr));
     }

     public static int solution(int arr[]){
          int low = 0;
          int high = arr.length - 1;
          while(low < high){
               int mid = (low+high)/2;

               if(mid % 2 == 1){
                    mid--;
               }

               if(arr[mid] == arr[mid+1]){
                    low = mid+2;
               }else{
                    high = mid;
               }
          }

          return arr[low];
     }
     
}
