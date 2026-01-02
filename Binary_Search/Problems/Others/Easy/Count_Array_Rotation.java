package Binary_Search.Problems.Others.Easy;

// Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find how many times the array has been rotated.

// Input : arr = [4,5,6,7,0,1,2,3]
// Result: 4
// Explanation: The original array should be [0,1,2,3,4,5,6,7]. So, we can notice that the array has been rotated 4 times.
public class Count_Array_Rotation {
     public static void main(String[] args) {
          int arr[] = new int[]{4,5,6,7,0,1,2,3};

          System.out.println(solution(arr));
     }


     public static int solution(int arr[]){
          int low = 0;
          int high = arr.length - 1;
          while(low < high){
               int mid = (low + high)/2;
               if(arr[mid] > arr[high]){
                    low = mid + 1;
               } else{
                    high = mid;
               }
          }
          return low;
     }
}
