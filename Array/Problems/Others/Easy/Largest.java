package Array.Problems.Others.Easy;

import java.util.*;

// find largest number in the array
public class Largest {
    public static void main(String[] args) {
        int arr[] = new int[]{2,1,1,5,6,3};

        brute(arr);
        optimal(arr);
    }

    /*
     * Time complexity - O(N * logN)
     */
    public static void brute(int a[]){
        Arrays.sort(a);
        System.out.println(a[a.length - 1]);
    }

    /*
     * Time complexity - O(N)
     */
    public static void optimal(int a[]){
        int max = a[0];
        for(int i =0; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        System.out.println(max);
    }
}
