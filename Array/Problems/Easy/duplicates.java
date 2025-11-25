package Array.Problems.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * 📌 LeetCode # 26 - Remove Duplicates from Sorted Array
 * 
 */
// remove duplicates from a sorted array
public class duplicates {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 1, 2, 2, 3, 3, 4, 4 };

        // brute
        System.out.println(brute(arr));

        // better
        System.out.println(removeDuplicates(arr));

        // optimal
        System.out.println(optimal(arr));

    }

    /*
     * 
     * Time Complexity → O(n)
     * 
     * Space Complexity → O(n)
     * 
     */
    public static int brute(int nums[]) {
        List l1 = new ArrayList<>();
        l1.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                l1.add(nums[i]);
            }
        }
        System.out.println(l1);
        return l1.size();
    }

    /*
     * 
     * Time Complexity → O(n)
     * 
     * Space Complexity → O(1)
     * 
     */
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    /*
     *
     * Slightly fewer memory reads because prev is cached, but asymptotically same.
     * 
     * Time Complexity → O(n)
     * 
     * Space Complexity → O(1)
     * 
     */
    public static int optimal(int nums[]) {
        int n = nums.length;
        if (n < 2)
            return n; // quick exit

        int k = 1;
        int prev = nums[0]; // cache last unique to avoid repeated indexing

        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            if (curr != prev) {
                nums[k++] = curr;
                prev = curr;
            }
        }

        return k;
    }
}
