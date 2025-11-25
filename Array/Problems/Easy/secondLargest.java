package Array.Problems.Easy;

import java.util.Arrays;

// Find second largest/smallest element from the given array;
public class secondLargest {
    public static void main(String[] args) {
        int a[] = new int[] {1,2,4,7,7,5};
        // largest
        brute(a);
        better(a);
        optimal(a);

        // smallest
        int a1[] = new int[] {7,6,2,5,5,3};
        optimalSmallest(a1);
    }

    /*
     * Time complexity - O(N logN)
     */
    public static void brute(int a[]) {
        Arrays.sort(a);
        int larg = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] != larg) {
                System.out.println(a[i]);
                break;
            }
        }
    }

    /*
     * Time complexity - O(2 N)
     */
    public static void better(int a[]) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int sec = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= sec && a[i] < max) {
                sec = a[i];
            }
        }
        System.out.println(sec);
    }

    /*
     * Time complexity - O(N)
     */
    public static void optimal(int a[]) {
        int sec = Integer.MIN_VALUE;
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i] == max) continue;
            else if (a[i] > max) {
                sec = max;
                max = a[i];
            }
            else if(a[i] > sec){
                sec = a[i];
            }
        }
        if (sec == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sec);
        }
    }

    public static void optimalSmallest(int a[]){
        int min = a[0];
        int sec = Integer.MAX_VALUE;

        for(int i = 0; i < a.length; i++){
            if(a[i] == min) continue;
            else if(a[i] < min){
                sec = min;
                min = a[i];
            }
            else if(a[i] < sec){
                sec = a[i];
            }
        }
        System.out.println(sec);
    }
}
