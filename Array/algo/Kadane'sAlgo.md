# Kadane’s Algorithm (Explanation)

Kadane’s Algorithm is used to find the **Maximum Subarray Sum** in an array.  
A subarray means **continuous** elements.

The goal is to find the **largest possible sum** of any continuous subarray in **O(n)** time.

---

## Why do we need Kadane’s Algorithm?

The brute force approach checks all subarrays → **O(n²)** or **O(n³)**.  
Kadane improves this to **O(n)** by using a smart running sum mechanism.

---

## Core Idea

We maintain two variables:

- **currentSum** → sum of the current subarray  
- **maxSum** → best (maximum) subarray sum seen so far

Rules while traversing:

1. Add current element to currentSum  
2. If currentSum becomes **negative**, reset it to 0  
3. Update maxSum with the maximum value seen  
4. Finally **maxSum** is the answer

---

## 🔥 Intuition

> **If your running sum becomes negative, keeping it will **reduce** future subarrays.  
So we drop it (reset to 0) and start fresh.**

Example:

[ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]

The maximum subarray is: 4 + (-1) + 2 + 1 = 6


---
> Always compare the currentSum with the max before doing sum = 0 in negatives

## Step-by-Step Table

| Index | Element | currentSum | Action | maxSum |
|-------|---------|------------|--------|--------|
| 0 | -2 | -2 → reset to 0 | negative | -2 |
| 1 | 1 | 1 | update | 1 |
| 2 | -3 | -2 → reset to 0 | negative | 1 |
| 3 | 4 | 4 | update | 4 |
| 4 | -1 | 3 | keep | 4 |
| 5 | 2 | 5 | update | 5 |
| 6 | 1 | 6 | update | 6 |
| 7 | -5 | 1 | keep | 6 |
| 8 | 4 | 5 | keep | 6 |

Final **maxSum = 6**

---

## Time & Space Complexity

- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

## What this achieves

- Finds the maximum subarray sum in a single pass  
- Handles negative numbers correctly  
- Very efficient and used in many interview questions 

---

# Problems
- **Maximum Subarray – LeetCode 53**
- Variants:  
  - Maximum circular subarray  
  - Maximum product subarray  
  - Print the actual subarray  
  - Kadane for 2D arrays  

---


