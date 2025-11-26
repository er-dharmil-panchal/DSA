package Array.Problems.Others.Medium;

import java.util.*;

// union of 2 sorted array.
// [1,2,2,3,4,5,5] and [2,2,3,5] = [1,2,3,4,5]
public class unionArray {
    public static void main(String[] args) {
        int arr1[] = new int[] { 1, 2, 2, 3, 4, 5, 5 };
        int arr2[] = new int[] { 2, 2, 3, 5, 6, 7, 8, 9, 10 };

        int ans[] = brute(arr1, arr2);
        System.out.println(Arrays.toString(ans));

        List ans1 = optimal(arr1, arr2);
        System.out.println(ans1.toString());
    }

    /*
     * 
     * Time complexity - O(n1 + n2 + (n1+n2)) = O(n1+n2)
     * 
     * space complexity - O(2(n1+n2)) = O(n1 + n2)
     * 
     */
    public static int[] brute(int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        int ans[] = new int[set.size()];
        int index = 0;
        for (int num : set) {
            ans[index++] = num;
        }
        return ans;
    }

 

    /*
     * 
     * Time complexity = O(n1 + n2)
     * 
     * space complexity = O(n1 + n2) (for ans use only, otherwise O(1))
     * 
     */
    public static List optimal(int arr1[], int arr2[]) {
        ArrayList a1 = new ArrayList<>();
        int i = 0;
        int j = 0;
        int prev = -1;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (arr1[i] != prev) {
                    a1.add(arr1[i]);
                    prev = arr1[i];
                }
                i++;
            } else {
                if (arr2[j] != prev) {
                    a1.add(arr2[j]);
                    prev = arr2[j];
                }
                j++;
            }
        }

        while (j < arr2.length) {
            if (prev != arr2[j]) {
                a1.add(arr2[j]);
                prev = arr2[j];
            }
            j++;
        }

        while (i < arr1.length) {
            if (prev != arr1[j]) {
                a1.add(arr1[i]);
                prev = arr1[i];
            }
            i++;
        }
        return a1;
    }
}
