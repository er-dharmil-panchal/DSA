package Array.Problems.Easy;

import java.util.Arrays;

/*
 * 
 * 📌 LeetCode # 189 - Rotate Array
 * 
 */
public class rotateArray {
    public static void main(String[] args) {
        // left rotaion (for one place) -> [1,2,3,4,5] will be [2,3,4,5,1]
        // right rotation (for one place) -> [1,2,3,4,5] will be [5,1,2,3,4]

        /* Left rotation */
        int arr[] = new int[]{1,2,3,4,5};
        int k = 8;

        leftBrute(arr,k);
        System.out.println(Arrays.toString(arr));

        int arr1[] = new int[]{1,2,3,4,5};
        leftOptimal(arr1, k);
        System.out.println(Arrays.toString(arr1));

        /* Leetcode 189 - Right rotate  */
        int arr2[] = new int[]{1,2,3,4,5};
        leetcode(arr2, k);
        System.out.println(Arrays.toString(arr2));
    }

    /*
     * 
     * Time complexity = O(k) + O(n-k) + O(k) = O(n+k) 
     * equivalent to O(n)
     * 
     * Space complexity = O(k)
     * 
     */
    public static void leftBrute(int arr[], int k) {
        int n = arr.length;
        k = k % n;
        int temp[] = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - (n - k)];
        }
    }


    /*
     * 
     * Time complexity = O(k) + O(n-k) + O(n) = O(2n)
     * equivelent to O(n)
     * 
     * Space complexity = O(1)
     * 
     */
    public static void leftOptimal(int arr[], int k){
        int n = arr.length;
        k = k % n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
    }

    public static void reverse(int arr[],int start, int end){
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }


    // Leetcode - from right = (left rotate but k will be n-k)
    public static void leetcode(int arr[], int k){
        int n = arr.length;
        k = k % n;
        reverse(arr,0,n-k-1);
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-1); 
    }
}
