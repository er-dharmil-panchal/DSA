# Moore’s Voting Algorithm (Explanation)

Moore’s Voting Algorithm is used to find the **majority element** in an array.  
A majority element is the element that appears **more than n/2 times**.

The algorithm is extremely efficient and works in **O(n) time** and **O(1) space**.

---

## Why does it work?

Moore’s idea is simple:

- Pair **different elements** with each other → they cancel each other out.
- The element that remains at the end **might** be the majority.
- Then we **verify** if it actually appears more than n/2 times.

---

## Core Idea

We maintain:

- **candidate** → the assumed majority element  
- **count** → balance value

Rules while iterating:

1. If **count becomes 0**, choose the current element as the new **candidate**.  
2. If current element == candidate → **count++**  
3. Else → **count--**

After the loop ends → `candidate` *may be* the majority.  
We perform **one more scan** to confirm it.

---

## Steps (Traversal Logic)

Given array:

[2, 2, 1, 1, 1, 2, 2]


We move left to right:

| Index | Element | Action | Candidate | Count |
|-------|---------|--------|-----------|-------|
| 0     | 2       | count=0 → set candidate=2 | 2 | 1 |
| 1     | 2       | same → count++             | 2 | 2 |
| 2     | 1       | different → count--        | 2 | 1 |
| 3     | 1       | different → count--        | 2 | 0 |
| 4     | 1       | count=0 → new candidate=1  | 1 | 1 |
| 5     | 2       | different → count--        | 1 | 0 |
| 6     | 2       | count=0 → new candidate=2  | 2 | 1 |

Final candidate = **2**

Then we re-count occurrences of 2 in the array → appears 4 times → **majority**.

---

## Time and Space Complexity

- **Time Complexity:** O(n)  
- **Extra Space:** O(1)

---

## What this achieves

- Efficiently finds the **majority element**.  
- Only **one useful candidate** survives after all cancellations.  
- Requires a **final pass** to verify.

---

# Problems
- **Majority Element – LeetCode 169**
- Can be extended for **n/3 majority** (Boyer–Moore Majority Vote II)

---