package Array.Problems.leetcode.Easy;


/*
 * 
 * Leetcode - # 485 - Maximum consecutive ones
 * 
 */
// Given a binary array nums, return the maximum number of consecutive 1's in the array.

/*
 * Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 */
public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,0,1,1,1};

        System.out.println(leetcode(arr));
    }

    public static int leetcode(int arr[]){
        int max = -1;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                count++;
                max = (count > max)? count: max;
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}
