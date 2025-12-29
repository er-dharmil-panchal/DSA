package Binary_Search.Problems.Leetcode.Easy;

/*
 * 
 * leetcode - # 744 - Smallest Letter Greater Than Target
 * 
 */
// same as upper bound

// Input: letters = ["c","f","j"], target = "c"
// Output: "f"
// Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
public class SmallestLetterGreaterThanTarget {
     public static void main(String[] args) {
          char arr[] = new char[] { 'c', 'f', 'j' };

          System.out.println(nextGreatestLetter(arr, 'c'));
     }

     /*
      * TC - O(LogN)
      * SC - O(1)
      */
     public static char nextGreatestLetter(char arr[], char target) {
          int low = 0, high = arr.length - 1;
          int ans = arr.length;

          while (low <= high) {
               int mid = low + (high - low) / 2;

               if (arr[mid] > target) { // ONLY difference
                    ans = mid;
                    high = mid - 1;
               } else {
                    low = mid + 1;
               }
          }
          return ans == arr.length ? arr[0] : arr[ans]; // wrap for oveflow
     }
}
