package Sorting.Problems;

import java.util.HashMap;

/*
 * Time complexity -  O(n)
 * Space complexity - O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> numToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(numToIndex.containsKey(target - nums[i])){
                return new int[]{numToIndex.get(target-nums[i]),i};
            }
            numToIndex.put(nums[i],i);
        }
        return new int[]{};
    }
}