package Array.Problems.leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 * Leetcode # 283 (Easy) - Move Zeroes
 * 
 */
// move zeroes to the end of the array
public class ZeroEnd {
    public static void main(String[] args) {

        int arr[] = new int[] { 0, 1, 2, 0, 3, 0 };
        brute(arr);
        System.out.println(Arrays.toString(arr));

        int arr1[] = new int[] { 0, 1, 2, 0, 3, 0 };
        better(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    /*
     * Time complexity - O(N)
     * 
     * space complexity - O(N)
     */
    public static void brute(int arr[]) {
        ArrayList<Integer> a1 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                a1.add(arr[i]);
            }
        }
        for (int i = 0; i < a1.size(); i++) {
            arr[i] = (int) a1.get(i);
        }
        for (int i = a1.size(); i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    /*
     * 
     * Time complexity - O(N) (but do more swaps)
     * space complexity - O(1)
     */
    public static void better(int arr[]) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    /*
     * Leetcode - solution
     * 
     * Time complexity - O(n) (i feel this is more reliable)
     * space complexity - O(1)
     */
    public static void optimal(int arr[]) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }

        for (int i = count; i < n; i++) {
            arr[i] = 0;
        }
    }
}
