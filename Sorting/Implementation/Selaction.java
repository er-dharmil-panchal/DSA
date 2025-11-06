package Sorting.Implementation;

import java.util.*;

/**
 * * Selection Sort *
 * 
 * 
 * Time Complexity = O(n^2) {Best, Worst, AVG}
 * 
 * Space Complexity = O(1)
 */
public class Selaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selection Sorting Algorithms Implementation");
        System.out.println("Enter the length of the array ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " element : ");
            arr[i] = sc.nextInt();
        }
        selection_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selection_sort(int arr[]) {
        for (int i = 0; i <= arr.length - 1; i++) {
            int min = i;
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}