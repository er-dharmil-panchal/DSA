package Binary_Search.Problems.Leetcode.Hard;

/*
 * 
 * leetcode - # 4 - Median of Two Sorted Arrays.
 * 
 */

// Given two sorted arrays nums1 and nums2 of size m and n respectively,
//  return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000 
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

public class Median_Of_Two_Sorted_Arrays {
     public static void main(String[] args) {
          int nums1[] = new int[] { 1, 3 };
          int nums2[] = new int[] { 2 };

          System.out.println(brute(nums1, nums2));
          System.out.println(optimal(nums1, nums2));
     }

     public static double brute(int arr1[], int arr2[]) {
          int ans[] = new int[arr1.length + arr2.length];

          int i = 0;
          int j = 0;
          int count = 0;

          while (i < arr1.length && j < arr2.length) {
               if (arr1[i] <= arr2[j])
                    ans[count++] = arr1[i++];
               else
                    ans[count++] = arr2[j++];
          }
          while (i < arr1.length) {
               ans[count++] = arr1[i++];
          }
          while (j < arr2.length) {
               ans[count++] = arr1[j++];
          }

          int n = arr1.length + arr2.length;
          if (n % 2 == 1) {
               return ans[n / 2];
          }

          return (double) (ans[n / 2] + ans[n / 2 - 1]) / 2.0;
     }

     public static double optimal(int a[], int b[]) {
          int i = 0;
          int j = 0;
          int count = 0;
          int n1 = a.length;
          int n2 = b.length;
          int n = n1 + n2;
          int ind1 = n / 2;
          int ind2 = ind1 - 1;
          int ind1el = -1;
          int ind2el = -1;

          while (i < n1 && j < n2) {
               if (a[i] < b[j]) {
                    if (count == ind1)
                         ind1el = a[i];
                    if (count == ind2)
                         ind2el = a[i];
                    count++;
                    i++;
               } else {
                    if (count == ind1)
                         ind1el = b[j];
                    if (count == ind2)
                         ind2el = b[j];
                    count++;
                    j++;
               }
          }

          while(i<n1){
               if(count == ind1) ind1el = a[i];
               if(count == ind2) ind2el = a[i];
               count++;
               i++;
          }
          while(j<n2){
               if(count == ind1) ind1el = b[j];
               if(count == ind2) ind2el = b[j];
               count++;
               i++;
          }

          if(n%2 == 1) return (double) ind1el;

          return (double) ((double) (ind1el + ind2el)) / 2.0;
     }

}