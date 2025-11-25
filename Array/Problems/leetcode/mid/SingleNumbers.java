package Array.Problems.leetcode.mid;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Leetcode - # 136 - Single number
 * 
 */

//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

/*
 * Input: nums = [2,2,1]
    utput: 1
 */
public class SingleNumbers {
    public static void main(String[] args) {
        int arr[] = new int[]{4,1,2,1,2};

        System.out.println(brute(arr));
        System.out.println(better(arr));

        // best(optimal)
        System.out.println(leetcode(arr));
    }


    /*
     * 
     * Time complexity - O(N^2)
     * 
     * Space complexity - O(1)
     * 
     */
    public static int brute(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == 1){
                return arr[i];
            }
        }
        return -1;
    }


    /*
     * 
     * Time complexity - O(N)
     * 
     * Space complexity - O(N/2) = O(N)
     * 
     */
    public static int better(int arr[]){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length ; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0 )+1);
        }
        for(int i: map.keySet()){
            if(map.get(i)==1){
                return i;
            }
        }
        return -1;
    }


    /*
     * 
     * Time complexity - O(N)
     * 
     * space complexity - O(1)
     * 
     */
    public static int leetcode(int arr[]){
        int xor = 0;
        for(int i : arr){
            xor ^= i;
        }
        return xor;
    }
}
