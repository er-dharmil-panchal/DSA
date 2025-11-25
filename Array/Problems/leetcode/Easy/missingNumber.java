package Array.Problems.leetcode.Easy;

import java.util.Arrays;

/*
 * 
 * Leetcode - # 268 - Missing number
 * 
 */

/*
Input: nums = [3,0,1]

Output: 2

Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums. 
 */

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
public class missingNumber {
    public static void main(String[] args) {

        int arr[] = new int[] { 3, 5, 1, 2, 4,0 };
        System.out.println(brute(arr));
        
        // leetcode
        System.out.println(leetcode1(arr));
        System.out.println(leetcode2(arr));
    }

    public static int brute(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    /*
     * 
     * Time complexity - O(N) + O(N) = O(N)
     * 
     * space complexity - O(N)
     * 
     */
    public static int better(int arr[]) {
        int hash[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[i] = 1;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /*
     * 
     * Time complexity - O(N) + O(N) = O(N)
     * 
     * space complexity - O(1)
     * 
     */
    public static int leetcode1(int arr[]) {
        int n = arr.length;
        int sum1 = 0;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
        }
        return sum - sum1;
    }

    /*
     * 
     * Same, but better
     * 
     */
    public static int leetcode2(int arr[]) {
        int xor = 0;
        for (int i = 0; i <= arr.length; i++) {
            xor ^= i;
        }

        for (int num : arr) {
            xor ^= num;
        }

        return xor;
    }
}
