package Basics.Hashing;
import java.util.*;

public class Basics {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // numberHasing();
        // charHashing();
        
        /* hashing using HashMap */

        numberHasingUsingHashMap();
        charHashingUsingHashMap();

    }
    
    public static void numberHasing(){
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        // precomputing frequency of each element
        int hash[] = new int[13]; 
        for(int i = 0; i < n; i++){
            hash[arr[i]]++;
        } 

        System.out.println("Enter number of queries:");
        int q = sc.nextInt();
        while (q-- > 0) {
            System.out.println("Enter element to search: <1-12>");
            int x = sc.nextInt();
            System.out.println("Frequency of " + x + " is: " + hash[x]);
        }
    }

    public static void charHashing(){
        System.out.println("Enter string:");
        String n = sc.next().toLowerCase();

        // precomputing frequency of each character
        // int hash[] = new int[26];        for a to z
        int hash[] = new int[256];       // for extended ASCII

        for(int i = 0; i < n.length(); i++){
            hash[n.charAt(i)]++;
        }

        System.out.println("Enter number of queries:");
        int q = sc.nextInt();
        while (q-- > 0) {
            System.out.println("Enter character to search:");
            char x = sc.next().toLowerCase().charAt(0);
            System.out.println("Frequency of " + x + " is: " + hash[x]);
        }
    }

    public static void numberHasingUsingHashMap(){
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            arr[i] = sc.nextInt();
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        // precomputing frequency of each element using HashMap
        // HashMap<Integer, Integer> hashMap = new HashMap<>();
        // for(int i = 0; i < n; i++){
            // hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        // } 

        System.out.println("Enter number of queries:");
        int q = sc.nextInt();
        while (q-- > 0) {
            System.out.println("Enter element to search:");
            int x = sc.nextInt();
            System.out.println("Frequency of " + x + " is: " + hashMap.getOrDefault(x, 0));
        }
    }

    public static void charHashingUsingHashMap(){
        System.out.println("Enter string:");
        String n = sc.next().toLowerCase();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < n.length(); i++){
            char ch = n.charAt(i);
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        // precomputing frequency of each character using HashMap
        // HashMap<Character, Integer> hashMap = new HashMap<>();
        // for(int i = 0; i < n.length(); i++){
            // char ch = n.charAt(i);
            // hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        // }

        System.out.println("Enter number of queries:");
        int q = sc.nextInt();
        while (q-- > 0) {
            System.out.println("Enter character to search:");
            char x = sc.next().toLowerCase().charAt(0);
            System.out.println("Frequency of " + x + " is: " + hashMap.getOrDefault(x, 0));
        }
    }
}
