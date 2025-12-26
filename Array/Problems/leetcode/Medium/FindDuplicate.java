package Array.Problems.leetcode.Medium;

/*
 * 
 * leetcode - # 287 - Find The Duplicate Numbers.
 * 
 */

// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and using only constant extra space.
public class FindDuplicate {
     public static void main(String[] args) {
          int arr[] = new int[]{1,3,4,2,2};

          System.out.println(brute(arr));
     }

     public static int brute(int arr[]){
          int n = arr.length -1;
          int sumReal = n * (n+1)/2;
          int sum = 0;
          for(int i = 0; i < arr.length; i++){
               sum+=arr[i];
          }
          return sum - sumReal;
     }
}
