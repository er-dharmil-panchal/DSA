package Array.Problems.Others.Medium;

import java.util.*;

// Given an array of integers nums and an integer k, return the length of the longest subarrays whose sum equals to k.
public class subArraySum {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        // int arr[] = new int[]{1, 2, -1, 2};
        int k = 3;
        System.out.println(brute(arr, k));
        System.out.println(better(arr, k));
        System.out.println(optimal(arr, k));
    }

    /*
     * 
     * Time complexity - O(N^2)
     * 
     * Space complexity - O(1 )
     * 
     */
    public static int brute(int arr[], int k) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    /*
     *
     * BETTER FOR THE POSITIVE NUMBERS ONLY
     * AND OPTIMAL FOR BOTH NEGATIVE AND POSITIVE BOTH.
     * 
     * start from the index 0, and considering first 0 then 0,1 then 0,1,2 and so on
     * as a subarray. and counting the sum of them and store it in a hashmap with
     * index number.
     * 
     * now if any index we find sum = 8 and we need 3 so 8-3 is 5 and we have
     * recorded 5 in our map
     * so from that sum = 5'th index to current index is a subarray we need
     * 
     * so we will do basic subtraction from current index to the complement sum's
     * index,
     * in a len variable and find the maximum.
     * 
     * example :-
     * arr[1,2,3]
     * 
     * sum will be 1,3,6
     * 
     * so for k = 3 at sum = 6 we already store the 6-3 = 3 while summing 1+2 in
     * erlier step
     * then subtract the 2 index and find one of the length.
     * 
     */

    /*
     * 
     * TC - O(N)
     * 
     * SC - O(N)
     * 
     */
    public static int better(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (map.getOrDefault(rem, -1) != -1) {
                maxLen = Math.max(maxLen, i - map.get(rem));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int optimal(int arr[], int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int len = 0;
        while (j < arr.length) {
            if (sum == k) {
                len = Math.max(len, j - i);
                j++;
            }
            else  if (sum < k) {
                sum += arr[j];
                j++;
            } else {
                sum -= arr[i];
                i++;
            }
        }
        return len;
    }
}
