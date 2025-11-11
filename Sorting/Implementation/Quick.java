package Sorting.Implementation;

import java.util.*;


/*
 * 
 * Time complexity - (same as merge sort)
 * {best, avg, worst} -> O(N log N)
 * 
 * space complexity - O(1)
 * (Much better than merge sort)
 * 
 */

 
public class Quick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insertion Sorting Algorithms Implementation");
        System.out.println("Enter the length of the array ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            // System.out.println("Enter " + (i + 1) + " element : ");
            arr[i] = sc.nextInt();
        }
        quick_sort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick_sort(int arr[], int low, int high){
        if(low > high) return;
        int partition = part(arr,low,high);
        quick_sort(arr, low, partition-1);
        quick_sort(arr, partition+1, high);
    }

    public static int part(int arr[], int low, int high){
        int i = low;
        int j = high;
        int pivot = arr[low];
        while (i<j){
            while (arr[i] < pivot && i <= high) i++;
            while (arr[j] > pivot && j >= low) j--; 
            if(i < j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = pivot;
        pivot = temp;
    return j; 
    }



/* Mine version with often give O(N^2) , best case O(N log N) */

//     public static void quick_sort(int arr[], int low, int high){
//         if(low > high) return;
//         int i = low;
//         int j = high;
//         int pivot = low;
//         while (i<j){
//             if(arr[i] > arr[pivot]){
//                 if(arr[j] < arr[pivot]){
//                     int temp = arr[j];
//                     arr[j] = arr[i];
//                     arr[i] = temp;
//                 }
//                 else {
//                     j--;
//                 }
//             }
//             else{
//                 i++;
//             }
//         }
//         int temp = arr[j];
//         arr[j] = arr[pivot];
//         arr[pivot] = temp;

//         quick_sort(arr, low, j-1);
//         quick_sort(arr, j+1, high);
//     }
}
