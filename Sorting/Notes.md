# Sorting

> Divided into 2 parts
> - 📌 Sorting - I
>   - Selection sort
>   - Bubble sort
>   - Insertion sort
> - 📌 Sorting - II
---
## 📌 **Sortin - I**

### ☞ **Selection sort**
> **Selection sort** - Select Min & Swap
- The algo, first assume that 0th index is min then travel in the array and compare to each element.
- if find any minimum than swap the both element 
- now the smallest will be at index - 0 so , algo will repeat all step but start with index - 1.

> 13,46,24,52,20,9  (Initially)  
> ***9***,46,24,52,20,13  (Step - 1)   
> ***9***,***13***,24,52,20,46  (Step - 2)  
> ***9***,***13***,***20***,52,24,46  (Step - 3)  
> ***9***,***13***,***20***,***24***,52,46  (Step - 4)  
> ***9***,***13***,***20***,***24***,***46***,***52***  (Step - 5)

```Java
for (int i = 0; i <= arr.length - 1; i++) {
            int min = i;
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
```

#### > **Time Complexity** - ***O(N^2)*** for all cases

---
---
### ☞ **Bubble sort**
> **Bubble sort** - Push the max to the last by **Adjcent swaps**

- this algo first check index - 0 and 1 , if arr[0] > arr[1] then swap.
- Repeat with 1,2,3 ... n.

> 13,46,24,52,20,9  (Initially)  
---
> (S-1)  
> 13,24,46,52,20,9   (24 -> 46)  
> 13,24,46,20,52,9  (20 -> 52)  
> 13,24,46,20,9,***52*** (9 -> 52)  

--- Simillerly  
> 13,24,20,9,***46***,***52*** (S-2)  
> 13,20,9,***24***,***46***,***52*** (S-3)  
> 13,9,***20***,***24***,***46***,***52*** (S-4)  
> ***9***,***13***,***20***,***24***,***46***,***52*** (S-4)  

```Java
for (int i = n - 1; i >= 1; i--) {
            boolean swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
            System.out.println("Runs");
        }
```

> **Time Complexity**  - Here at any iteration of i, if swap will not happens, that means the array is sorted (using **boolean flag**) 
- Best case - O(N)
- Worst & AVG - O(N^2)

---
---
### ☞ **Insertion sort**
> **Insertion sort** - Take element and place it in its currect order

- first check the index 0, index 0 will always be sorted as a individual array.
- now for 0 and 1st index, try to sort by swapping.
- same again till the end of the array.

> 14,9,8,15,12,6,13 (Initially)  
> **14**,9,8,15,12,6,8,13   (index - 0)
> **9**,**14**,8,15,12,6,13 (index -0,1) ***9->14***
>**8**,**9**,**14**,15,12,6,13 (index - 0,1,2) ***8->14->9***
>**8**,**9**,**14**,**15**,12,6,13
>**8**,**9**,**12**,**14**,**15**,6,13
>**6**,**8**,**9**,**12**,**14**,**15**,13
> **6**,**8**,**9**,**12**,**13**,**14**,**15**

> we hae to reach the end point of the each individual steps array and go till the back doing swapping or if currect order.
```java
for(int i=0; i <n; i++){
    int j = i;
    while(j>0 && a[j-1] > a[j]){
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = temp;
    }
}
```

> **Time complexity**  
> Worst - Avg = O(n^2)  
> **Best** - O(n) (***Due to inner loop condition**)
