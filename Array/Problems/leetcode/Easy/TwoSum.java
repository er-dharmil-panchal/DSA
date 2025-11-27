package Array.Problems.leetcode.Easy;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 
 * Leetcode - # 1 - TwoSum
 * 
 */

/*
 Input: nums = [2,7,11,15], target = 9
   Output: [0,1]
   Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

// it can done by two pointer, but for that we have to sort the array which take 
// O(n logn) time complexity and it only return "yes" or "no", because index will be not remain same.
// unless you create a datastructure to just store the index order, but it will increase the space complexity and time complexity.
class Solution {

    public static void main(String[] args) {
        int arr[] = new int[] { 2, 7, 11, 15 };
        int k = 9;

        int ans[] = brute(arr, k);
        System.out.println(Arrays.toString(ans));

        int ans1[] = optimal(arr, k);
        System.out.println(Arrays.toString(ans1));

        System.out.println(twoPointer(arr, k));
    }

    /*
     * 
     * TC - O(N^2)
     * SC - O(1)
     * 
     */
    public static int[] brute(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if (sum == k) {
                    return new int[] { i, j };
                    // return "yes";
                }
            }
        }
        return null;
    }

    /*
     * 
     * TC - O(N)
     * SC - O(N)
     * 
     */
    public static int[] optimal(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] { numToIndex.get(target - nums[i]), i };
                // return "yes";
            }
            numToIndex.put(nums[i], i);
        }
        return null;
    }

    /*
     * With sorting , and returning yes or no
     * 
     * TC - O(n logn)
     * SC - O(1) or O(N) because we change the real given array.
     * 
     */

    public static String twoPointer(int arr[], int k) {
        int i = 0;
        int j = arr.length - 1;
        Arrays.sort(arr);
        while (i < j) {
            if (arr[i] + arr[j] == k) {
                return "yes";
            } else if (arr[i] + arr[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return "no";
    }
}