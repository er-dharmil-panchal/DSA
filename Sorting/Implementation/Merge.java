package Sorting.Implementation;

import java.util.*;


/*
 * 
 * Time complexity is best among all the sorting algo.
 * 
 * best, avg, worst --> O(N log N) (base - 2)
 * 
 * space complexity --> O(N)
 * 
 */
public class Merge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insertion Sorting Algorithms Implementation");
        System.out.println("Enter the length of the array ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " element : ");
            arr[i] = sc.nextInt();
        }
        merge_sort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge_sort(int arr[], int low, int high) {
        // base condition
        if (low >= high) {
            return;
        }

        int mid = (int) (low + high) / 2;

        // left portion (low to mid)
        merge_sort(arr, low, mid);

        // right portion (mid+1 to high)
        merge_sort(arr, mid+1, high);

        merging(arr, low, mid, high);
    }

    public static void  merging(int arr[], int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid +1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                System.out.println("hii");
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) temp.add(arr[left++]);
        while (right<=high) temp.add(arr[right++]);

        // use low for right side of the part, for avoiding miss-replacement 
        for (int i = 0; i < temp.size(); i++) {
            arr[low + i] = temp.get(i);
        }

        // for(int i = low; i <= high; i++){
        //     arr[i] = temp.get(i-low);
        // }
    }
}
