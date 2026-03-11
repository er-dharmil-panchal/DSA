package Binary_Search.Problems.Others.Hard;

import java.util.Arrays;

/*
 * 
 * Allocate Minimum Number of Pages
 * 
 */

// Problem Statement:
// Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
// Allocate books in such a way that:

// Each student gets at least one book.
// Each book should be allocated to only one student.
// Book allocation should be in a contiguous manner.
// You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1


// Example 1:
// Input Format: n = 4, m = 2, arr[] = {12, 34, 67, 90}
// Result: 113
// Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.


// Example 2:
// Input Format: n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
// Result: 71
// Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.


public class Allocate_Minimum_Number_of_Pages {

     public static void main(String[] args) {
          int arr[] = new int[]{12, 34, 67, 90};
          int m = 2;

          System.out.println(solution(arr, m));
     }

     public static int solution(int arr[], int m){
          int high = Arrays.stream(arr).sum();
          int low = Arrays.stream(arr).max().getAsInt();
          int ans = -1;

          if (m > arr.length) return -1;

          while(low <= high){
               int mid = (low + high)/2;

               // we have to find the minimum so , if it can place we have to go on the lower side of the range.
               if(canPlace(arr, mid, m)){
                    high = mid - 1;
                    ans = mid;
               } else{
                    low = mid + 1;
               }
          }
          return ans;
     }

     public static boolean canPlace(int arr[], int max, int m){
          int studentCount = 1; // because 1st stundent always on the 0th index of the array.
          int sum = arr[0];
          for(int i = 1; i < arr.length; i++){
               if(arr[i] + sum <= max){
                    sum += arr[i];
               } else{
                    studentCount++;
                    sum = arr[i];
               }

          }
          if(studentCount <= m){
               return true;
          }

          return false;
     }

}
