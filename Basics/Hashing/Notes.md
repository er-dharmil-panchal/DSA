# Basic Hashing — DSA Notes


## Overview

Hashing uses a hash function to map keys to indices for near-constant-time lookup, insert, and delete on average. In DSA, `HashSet`, `HashMap` (Java) or `set`, `dict` (Python) are the primary tools.

**Use when:** you need membership tests, frequency counting, deduplication, index lookup by key, or to implement fast sliding windows.

---

## Key Concepts

* **Hash table**: array + hash function + collision resolution (chaining or open addressing).
* **Load factor**: ratio `n / capacity`. Higher load factor → more collisions → slower.
* **Collision resolution**:

  * *Chaining*: each bucket stores a list of entries.
  * *Open addressing*: probe for next free slot (linear, quadratic, double hashing).
* **Average complexity**: O(1) for lookup/insert/delete (amortized). Worst-case O(n) (rare if hash good).

---

## Common Patterns & Problems

### 1) Frequency map

Count occurrences of elements.

**Java**

```java
Map<Integer,Integer> freq = new HashMap<>();
for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);
```

**Python**

```py
from collections import Counter
freq = Counter(arr)
# or
freq = {}
for x in arr:
    freq[x] = freq.get(x, 0) + 1
```

### 2) Two-sum (target = x)

Use a hashset or map to check complement quickly.

**Java**

```java
Set<Integer> seen = new HashSet<>();
for (int num : arr) {
    int need = target - num;
    if (seen.contains(need)) return true; // or return indices using a map
    seen.add(num);
}
return false;
```

### 3) Count distinct in window (sliding window)

Use a hashmap to maintain counts inside window.

### 4) Longest subarray with sum = k (with negatives)

Use prefix-sum + hashmap storing earliest index of a prefix-sum value.

### 5) Anagrams grouping

Hash by sorted string or by frequency signature (26-length vector mapped to string/key).

---

## Typical Code Snippets

### Java — prefix-sum index map (longest subarray sum = k)

```java
public int longestSubarrayWithSumK(int[] a, int k) {
    Map<Integer,Integer> firstIndex = new HashMap<>();
    int sum = 0, best = 0;
    firstIndex.put(0, -1);
    for (int i = 0; i < a.length; i++) {
        sum += a[i];
        if (!firstIndex.containsKey(sum)) firstIndex.put(sum, i);
        if (firstIndex.containsKey(sum - k)) {
            best = Math.max(best, i - firstIndex.get(sum - k));
        }
    }
    return best;
}
```

### Python — group anagrams

```py
from collections import defaultdict
groups = defaultdict(list)
for s in strs:
    key = ''.join(sorted(s))
    groups[key].append(s)
return list(groups.values())
```

---

## Complexity Summary

* **Hash insert/lookup/delete (avg)**: O(1) amortized.
* **Hash insert/lookup/delete (worst)**: O(n) if many collisions (rare with good hashes).
* **Space**: O(n) extra for the hash structure.

---

## Pitfalls & Tips

* Beware of using mutable objects as keys (their hash can change).
* In Java, use `long` keys cautiously when hashing large values — native `hashCode()` of `Long` is fine but watch boxing/unboxing cost.
* For custom objects, always implement `equals()` and `hashCode()` correctly in Java.
* Avoid using hash for ordering — hashes are unordered.
* When asked for index pairs (like two-sum indices), use `Map<value, index>` and be careful with duplicates.
* For strings that need a compact signature (anagram problems), prefer frequency-signature over sorting when strings are long and alphabet small.

---

## Practice Questions

1. Two Sum (return true / indices)
2. Group Anagrams
3. Longest substring without repeating characters (sliding window + set/map)
4. Longest subarray with sum = k (prefix-sum + map)
5. Subarray sum equals K count (prefix-sum + map counting occurrences)
6. Top K frequent elements (use map + bucket sort or min-heap)
7. Valid Sudoku (use sets per row/col/box)

---

## Quick Cheatsheet

* Use `HashSet` / `set` for membership/deduplication.
* Use `HashMap` / `dict` for value → info mapping (counts, index storage).
* Combine with prefix-sum for sum-subarray problems.
* Combine with sliding-window for fixed/variable window distinctness problems.

---
