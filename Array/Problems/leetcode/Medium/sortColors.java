package Array.Problems.leetcode.Medium;

import java.util.Arrays;

/*
 * 
 * Leetcode - # 75 - Sort Colors
 * 
 */
/*
 * 
    Given an array nums with n objects colored red, white, or blue, 
    sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem ""without using the library's sort function.""
 */

/*
 * Input: nums = [2,0,2,1,1,0]
   Output: [0,0,1,1,2,2]
 */


/*
 * Dutch National Flag Algo
 * 
 * Rules - i) 0 to low - 1 ] -> 0
 *        ii) low to mid - 1 ] -> 1
 *       iii) high + 1 to n - 1 ] -> 2
 * 
 * its like , 00001111....2222
 *  low is 4 index, mid is 8, high is 11 index.
 * 
 * we have to now do for unsorted portion which is from mid to high 
 * 
 * case 1) if a[mid] == 0 -> has to swap it in left portion of the array
 *  so swap(a[mid], a[low]) and increase low++. (because low represent to first 1)
 * we will definatly get a 0 on mid after swap so do a mid++.
 * 
 * case 2) if a[mid] == 1 , remain same , mid++
 * 
 * case 3) if a[mid] == 2, has to swap it in right portion of the array
 *  so swap(a[mid], a[high]) and decrease high (high--)
 * because high+1 represent to the first 2.
 * we will get a random value in swap with high so dont do mid++.
 *  
 * 
 */
public class sortColors {
    public static void main(String[] args) {
        int arr[] = new int[]{2,0,2,1,1,0};
        brute(arr);
        int arr1[] = new int[]{2,0,2,1,1,0};
        better(arr1);

        // Leetcode
        int arr2[] = new int[]{2,0,2,1,1,0};
        leetcode(arr2);
    }


    /*
     * 
     * TC - O(N LogN)
     * 
     * SC - O(N)
     * 
     */
    public static void brute(int arr[]){
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }



    /*
     * 
     * TC - O(2N) = O(N)
     * 
     * SC - O(1) because we have to modify the given array , otherwise it will be actually O(N)
     * 
     */
    public static void better(int arr[]){
      int zero = 0;
      int one = 0;
      int two = 0;
      for(int i : arr){
        if(i == 0){
          zero++;
        }
        else if(i==1){
          one++;
        }
        else if(i==2){
          two++;
        }
      }

      for(int i = 0; i < zero; i++){
        arr[i] = 0;
      }
      for(int i = zero; i < one+zero; i++){
        arr[i] = 1;
      }
      for(int i = one + zero; i < arr.length ; i++){
        arr[i] = 2;
      }

      System.out.println(Arrays.toString(arr));
    }



    /*
     * Dutch national flag algo
     * 
     * TC - O(N)
     *    mid go from 0 to N
     *    high go from N to 0
     * its look like its O(2N), but at both the itteration the loop shrink
     * so its like complement, if mid move then high will not, same for high
     * so at the end the loop iterate only N times.
     * 
     * 
     * SC - O(1)
     * 
     * 
     */
    public static void leetcode(int arr[]){
      int low = 0;
      int mid = 0;
      int n = arr.length;
      int high = n-1;

      while(mid<=high){
        if(arr[mid] == 0){
          // swap(arr[mid], arr[low]);
          int temp = arr[mid];
          arr[mid] = arr[low];
          arr[low] = temp;
          mid++;
          low++;
        }
        else if(arr[mid] == 1){
          mid++;
        }
        else if(arr[mid] == 2){
          // swap(arr[mid], arr[high]);
          int temp = arr[mid];
          arr[mid] = arr[high];
          arr[high] = temp;
          high--;
        }
      }
      System.out.println(Arrays.toString(arr));
    }
}
