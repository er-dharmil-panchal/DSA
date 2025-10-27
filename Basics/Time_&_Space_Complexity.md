# 🧠 **Time and Space Complexity (Basic)**

---

## ⏱️ **Time Complexity**

### 🔹 What is Time Complexity?
> Time Complexity is the rate at which the **execution time** of an algorithm increases with respect to the **input size (N)**.

⚠️ **Note:**  
> **Time Complexity ≠ Actual Time Taken**  
> It tells us how the runtime **grows** as the input size increases — not the actual time in seconds.

---

### 🔹 Notation — **Big O**
We use **Big O Notation (O)** to describe the **upper bound (worst-case growth rate)** of an algorithm’s growth rate.  
It helps us compare algorithms regardless of hardware or language.

📘 **Quick Summary of Notations:**
- **Big-O (O)** → Upper Bound → *Worst Case*
- **Theta (Θ)** → Tight Bound → *Average Case*
- **Omega (Ω)** → Lower Bound → *Best Case*
---

### 🔹 Rules to Remember

#### 🧩 1. Always consider the **worst-case scenario**
Compute time complexity for the most time-consuming input.

Example:
```java
if (marks < 20) {
    System.out.println("D");
}
else if (marks < 45) {
    System.out.println("C");
}
else if (marks < 65) {
    System.out.println("B");
}
else {
    System.out.println("A");
}
```
> **Best Case:** `marks = 10` → Executes only the first condition → **O(1)**  
> **Worst Case:** `marks = 70` → Checks all conditions one by one → **O(4)** → Simplifies to **O(1)** ✅  
> Because constants are ignored in time complexity (explained below).

---

### 🧩 2 & 3. Ignore Constants & Focus on the Dominant Term
- When we calculate time complexity, constant factors don’t matter.
- Only the term that grows the fastest (highest power of `N`) is considered.

Example: **O(3N³ + 2N² + 8) → O(N³)**


✅ **Why?**  
Because as `N` becomes large, the impact of smaller terms and constants becomes negligible.

---

### 💡 Common Examples

| Code Snippet | Time Complexity | Explanation |
|---------------|-----------------|--------------|
| `for (int i = 0; i < N; i++)` | **O(N)** | Runs N times |
| Two nested loops (`for` inside `for`) | **O(N²)** | N × N iterations |
| Constant statements (no loops) | **O(1)** | Executes once |

---
---
---

## 🧮 **Space Complexity**

---

### 🔹 What is Space Complexity?

> Space Complexity is the **total memory space** your program requires during execution.

It also follows **Big-O notation**, just like Time Complexity.

---

### 🔹 Definition

> **Space Complexity = Auxiliary Space + Input Space**

| Term | Meaning |
|------|----------|
| **Auxiliary Space** | The extra or temporary space used to solve the problem (e.g., variables, recursion stack). |
| **Input Space** | The memory required to store the input data itself. |

---

### 🧩 Examples

#### ✅ Example 1:
```java
int a, b, c;
c = a + b;
```
➡️ Uses only fixed number of variables → **O(1)** space (constant).

---

#### ✅ Example 2:
```java
int arr[] = new int[n];
```
➡️ Creates an array of size `n` → **O(n)** space (linear).

---

### 🧠 Notes
- Space complexity measures **memory**, not **speed**.  
- Just like time complexity, we **ignore constants** and focus on **dominant terms**.  
- Recursive functions also take **extra stack space** depending on the depth of recursion.

---

### 💡 Common Space Complexities

| Code / Structure | Space Complexity | Description |
|------------------|------------------|--------------|
| Simple variables | **O(1)** | Constant memory |
| Array of size N | **O(N)** | Linear memory |
| 2D matrix (N×N) | **O(N²)** | Quadratic memory |
| Recursive call depth N | **O(N)** | Stack space usage |

---

### ⚖️ **Time vs Space Complexity**

| Aspect | Time Complexity | Space Complexity |
|---------|------------------|------------------|
| **Meaning** | Measures how fast the program runs | Measures how much memory it uses |
| **Goal** | Reduce number of operations | Reduce extra memory usage |
| **Notation** | Big-O (O), Theta (Θ), Omega (Ω) | Big-O (O), Theta (Θ), Omega (Ω) |
| **Example** | `for` loop → O(N) | array[N] → O(N) |
| **Trade-off** | Often faster algorithms use more space | Memory-efficient algorithms may run slower |

---

✅ **Key Takeaway:**  
> Space Complexity = Memory used to **store input + solve the problem**  
> Always aim for minimal **auxiliary space** while balancing **time efficiency**.

