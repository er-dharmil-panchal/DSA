# Binary Search 

## Content
- Real life example
- Coding problem example
- Iterative code
- Recursive code
- Time complexity
- Overflow case

---

### Real life example
- For Dictionary i have to find 'Dharmil'.
- **Linear search** - open first page then next and so on till i find it.
- **Binary search** - open near N/2 page, find words starting with 'J', i know that 'D' < 'J', i will go to left side's N/2, found 'B' so 'D' > 'B' , go to right ...

### Code problem example
> array - [3, 4, 6, 7, 9, 12, 16, 17], Target = 6   
> low = 0 (index)    
> high = 7 (index)  
> mid = (0+7)/2 = 3
- is array[mid] == target, (No, 7 > 6)
- so high = mid - 1;

> Search area [3, 4, 6]  
>low = 0  
>high = 2  
> mid = 1
- array[mid] == target, (No, 4 < 6)
- low = mid + 1;
> search area [6]  
> low = 2  
> high = 2  
> mid = 2
- array[mid] = target , (yes, 6 == 6)

### Iterative Code
```java
public int fun(int arr[], int target){
     int low = 0;
     int high = arr.length - 1;
     while(low <= high){
          int mid = (low+high)/2;
          if(arr[mid] == target){
               return mid;
          } else if(arr[mid] > target){
               high = mid-1;
          }
          else{
               low = mid+1;
          }
     }
     return -1;
}
```

### Recursive code

```java
public static int recurcive(int arr[], int target, int low, int high) {
          if (low > high) {
               return -1;
          }
          int mid = (low + high) / 2;
          if (arr[mid] == target) {
               return mid;
          } else if (arr[mid] < target) {
               return recurcive(arr, target, mid + 1, high);
          } else {
               return recurcive(arr, target, low, mid - 1);
          }
     }
```

### Time Complexity
- in each step we are reducing the search area by N/2 or slightly lesser then N/2.
- Imagine a array with 32, in worst case we go to,
- 32 -> 16 -> 8 -> 4 -> 2 -> 1
- which is 6 step 2^6.
>TC = LogN (Base 2).