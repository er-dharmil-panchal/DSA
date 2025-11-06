package Sorting.Implementation;

import java.util.*;

/**
 * * Bubble Sort *
 * 
 * 
 * Time Complexity,
 *      Best case (With boolean flag) = O(n);
 *      Worst case = O(n^2);
 *      Avg case = O(n^2);
 * 
 * Space Complexity = O(1)
 */
public class Bubble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bubble Sorting Algorithms Implementation");
        System.out.println("Enter the length of the array ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " element : ");
            arr[i] = sc.nextInt();
        }
        bubble_sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble_sort(int arr[], int n) {
        for (int i = n - 1; i >= 1; i--) {
            boolean swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
            System.out.println("Runs");
        }
    }
}