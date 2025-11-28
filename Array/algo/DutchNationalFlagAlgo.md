# Dutch National Flag Algorithm (Explanation)

The Dutch National Flag algorithm is used to sort an array that contains only three distinct values:  
**0, 1, and 2**.  
The aim is to sort the entire array **in one single traversal** using **constant space**.

---

## Why is it called the Dutch National Flag Algorithm?

The Dutch national flag has **three colors**, and similarly this algorithm divides the array into **three regions**:
- 0 → left region  
- 1 → middle region  
- 2 → right region  

So, the algorithm rearranges elements just like arranging the three colors of a flag.

---

## Core Idea

We use **three pointers**:

- **low** → boundary for region of 0s  
- **mid** → the current element being checked  
- **high** → boundary for region of 2s  

---

## Rules (while mid <= high)

1. **If arr[mid] == 0**  
   - Swap arr[low] and arr[mid]  
   - low++, mid++

2. **If arr[mid] == 1**  
   - Just mid++ (already in correct region)

3. **If arr[mid] == 2**  
   - Swap arr[mid] and arr[high]  
   - high-- (do NOT increase mid because swapped element must be checked again)

---

## Time and Space Complexity

- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

## What this achieves

After the process:
- All **0s** are grouped at the beginning  
- All **1s** in the middle  
- All **2s** at the end  
All done in **a single pass** without extra memory.


# Arrow Representation of low, mid, high (Un-Sorted Array)

Array:  
[0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 2, 1, 2, 2, 2, 2] 

intially:
> low at 4 index  
> mid at 9 index  
> high at 12 index

---
RULES:
> 0 to Low-1 } 0  
> Low to Mid-1 } 1  
> High+1 to n-1} 2

# Problems
- sort colors - leetcode 75
- also for any 3 element sorting. 