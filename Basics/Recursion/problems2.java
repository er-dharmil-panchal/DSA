package Basics.Recursion;

public class problems2 {
    public static void main(String[] args) {

        // 👉🏻 reverse an array using recursion
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length - 1);
        System.out.print("Reversed array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // 👉🏻 String is palindrom or not
        // String s = "Hello, My name is Dharmil!";
        String s = "NAYAN";
        System.out.println("\n\n"+palindrom(0,s));
    }

    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }

    public static boolean palindrom(int i,String s){
        if(i>=s.length()/2){
            return true;
        }
        if (s.charAt(i)!=s.charAt(s.length()-i-1)){
            return false;
        }
        return palindrom(i+1, s);
    }
}


