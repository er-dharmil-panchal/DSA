package Array.Problems.Others.Medium;

import java.util.*;

public class intersectionArray {
    public static void main(String[] args) {
        int arr1[] = new int[] { 1, 2, 2, 3, 4, 5, 5 };
        int arr2[] = new int[] { 2, 2, 3, 5, 6, 7, 8, 9, 10 };

        List ans = brute(arr1, arr2);
        System.out.println(ans.toString());

        // List ans1 = optimal(arr1, arr2);
        // System.out.println(ans1.toString());
    }


    /*
     * 
     * Time complexity - O(n1 x n2)
     * 
     * Space complexity - O(n2)
     * 
     */
    public static List brute(int []arr1,int []arr2){
        int arr3[] = new int[arr2.length];
        ArrayList a1 = new ArrayList<>();
        for(int i = 0; i<arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(arr1[i] == arr2[j] && arr3[j] == 0){
                    a1.add(arr1[i]);
                    arr3[j] = 1;
                    break;
                }
                if(arr1[i] < arr2[j]) break;
            }
        }

        return a1;
    }


    /*
     * 
     * Time complexity - O(n1 + n2)
     * 
     * Space complexity - O(k) (for answer use only, Otherwise O(1))
     * 
     */
    public static List optimal(int arr1[], int arr2[]){
        ArrayList a1 = new ArrayList();
        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                if(arr1[i] == arr2[j]){
                    a1.add(arr1[i]);
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }
            else{
                j++;
            }
        }

        return a1;
    }
}
