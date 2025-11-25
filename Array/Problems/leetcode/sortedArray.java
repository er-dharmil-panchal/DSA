package Array.Problems.leetcode;

/*
 * 
 * 📌 LeetCode # 1752 - Check if the array is sorted and rotated.
 * 
 */

// Check if the array is sorted and rotated. 
public class sortedArray {
    public static void main(String[] args) {

        /* Normal sorted checking */

        int a[] = new int[] { Integer.MIN_VALUE, -100, 0, 100, Integer.MAX_VALUE };
        // int a[] = new int[] {Integer.MAX_VALUE, 100, 0, -100, Integer.MIN_VALUE};
        System.out.println(optimal(a));

        /* 🔥 Check if the array is sorted and rotated */

        // int a1[] = new int[] {2, 2, 3, 3, 4, 4, 9, 9, 1, 1, 2, 2, 3, 5, 5, 5, 1, 2};
        int a1[] = new int[] { 1, 2, 3, 1, 1, 2 };

        // better
        System.out.println(rotate(a1));

        // optimal
        System.out.println(rotateOptimal(a1));
    }

    public static boolean optimal(int a[]) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /*
     * 🔥
     * Time complexity - O(2N) ~ O(N)
     */
    public static boolean rotate(int a[]) {
        int min = a[0];
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
        }

        for (int i = ((index + 1) % a.length); i != index; i = (i + 1) % a.length) {
            int a1 = i - 1;
            if (i == 0)
                a1 = a.length - 1;
            if (a[i] < a[(a1)]) {
                return false;
            }
        }
        return true;
    }

    /*
     * 🔥
     * Time comlexity - O(N)
     */
    public static boolean rotateOptimal(int a[]) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > a[(i + 1) % n]) {
                count++;
            }
        }

        if (count > 1)
            return false;
        return true;
    }
}