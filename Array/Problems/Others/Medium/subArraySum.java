package Array.Problems.Others.Medium;

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
public class subArraySum {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        // int arr[] = new int[]{1, 2, -1, 2};
        int k = 3;
        System.out.println(brute(arr, k));
    }

    public static int brute(int arr[], int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; i < arr.length ; j++) {
                if(sum == k){
                    count++;
                    break;
                }
                else if(sum < k){
                    sum += arr[j];
                }
                else{
                    break;
                }
            }
        }
        return count;
    }

    // public static int brute(int arr[], int k){
    // int count = 0;
    // int sum = 0;
    // for(int i = 0; i < arr.length; i++){
    // sum += arr[i];
    // if(sum == k){
    // count++;
    // sum = 0;
    // // because subarray A's last and B's first can be the same element;
    // }
    // else if(sum > k){
    // sum=0;
    // }
    // }
    // return count;
    // }
}
