package Sorting.Implementation;

import java.util.*;

/**
 * * Insertion Sort *
 * 
 * 
 * Time Complexity,
 *      Best case  = O(n);
 *      Worst case = O(n^2);
 *      Avg case = O(n^2);
 * 
 * Space Complexity = O(1)
 */
public class Insertion {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Insertion Sorting Algorithms Implementation");
        System.out.println("Enter the length of the array ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " element : ");
            arr[i] = sc.nextInt();
        }
        insertion_sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    // here, the inner loop start sorting the array at the very begining, 
    // so, if the arr[j-1] < arr[j] the code will end , so best case have time complexity O(n)
    public static void insertion_sort(int arr[], int n){
        for(int i = 0; i < n; i++){
            for(int j = i; j>0 && arr[j-1] > arr[j]; j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println("run "+i);
            }
        }
    }
}
