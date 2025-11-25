package Array.Problems.Others.Easy;


// find first occurense of given number in a array
public class linearSearch {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,32,4,5,2,32};
        int num = 32;

        int ans = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                ans = i;
                break;
            }
        }
        if(ans != -1) System.out.println(ans);
    }
}
