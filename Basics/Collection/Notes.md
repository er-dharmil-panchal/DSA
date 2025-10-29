# 🧩 Java Collections — Quick Notes

---

## ⚙️ Collection Interface – Common Methods
`add()`, `addAll()`, `clear()`, `contains()`, `isEmpty()`, `iterator()`, `remove()`, `size()`, `toArray()`

---

## 🧺 List Implementations

### 🔹 ArrayList
- Dynamic array  
- Fast random access, slow insertion/deletion  
- Allows duplicates  
- Methods: `add`, `add(index, val)`, `clear`, `get`, `set`, `isEmpty`, `indexOf`, `lastIndexOf`, `remove`, `sort`, `size`  
- Can pre-set capacity (`ensureCapacity`)  
- Created via `Arrays.asList()`

---

### 🔹 LinkedList
- Doubly linked list  
- Fast insertion/deletion, slow access  
- Allows duplicates  
- Methods: `add`, `addFirst`, `addLast`, `remove`, `removeFirst`, `removeLast`, `clear`, `contains`, `get`, `getFirst`, `getLast`, `iterator`  
- Supports queue/deque behavior  

---

### 🔹 Stack
- LIFO (Last In, First Out)  
- Extends `Vector`  
- Methods: `push`, `pop`, `peek`, `isEmpty`, `size`, `search`

---

### 🔹 Vector
- Dynamic array (synchronized)  
- Legacy but thread-safe  
- Methods: `add`, `add(index, val)`, `remove`, `get`, `size`, `isEmpty`, `clear`, `clone`, `equals`, `elementAt`

---

## 🧺 Set Implementations

### 🔹 HashSet
- Implements `Set` interface using **Hash Table**
- **Does not maintain order**
- **No duplicates**, allows **one null**
- **Not synchronized**
- Average **Time Complexity:**
  - Add → O(1)
  - Remove → O(1)
  - Contains → O(1)
- **Best for:** Fast lookup, ensuring uniqueness
- **Methods:** `add`, `remove`, `contains`, `isEmpty`, `size`, `clear`, `iterator`

---

### 🔹 LinkedHashSet
- Extends `HashSet`, uses **Linked List + Hash Table**
- **Maintains insertion order**
- **No duplicates**, allows **one null**
- **Not synchronized**
- Average **Time Complexity:**
  - Add → O(1)
  - Remove → O(1)
  - Contains → O(1)
- **Best for:** Unique + ordered elements
- **Methods:** `add`, `remove`, `contains`, `iterator`, `size`, `clear`, `equals`

---

### 🔹 TreeSet
- Implements `NavigableSet` (extends `SortedSet`)
- Based on **Red-Black Tree (balanced BST)**
- **Maintains sorted order**
- **No duplicates**, **does not allow null**
- **Not synchronized**
- **Time Complexity:**
  - Add → O(log n)
  - Remove → O(log n)
  - Contains → O(log n)
- **Best for:** Sorted unique data
- **Methods:** `add`, `remove`, `contains`, `first`, `last`, `headSet`, `tailSet`, `subSet`, `iterator`

---

## 🧺 Queue / Deque Implementations

### 🔹 ArrayDeque
- Implements both **Queue** and **Deque**
- Based on **Resizable Circular Array**
- **No null elements**, allows duplicates
- **Maintains insertion order**
- **Not synchronized**
- **Time Complexity:**
  - Add / Offer → O(1)
  - Remove / Poll → O(1)
  - Peek → O(1)
- **Best for:** Stack & Queue operations (faster than LinkedList)
- **Methods:** `offer`, `poll`, `peek`, `addFirst`, `addLast`, `removeFirst`, `removeLast`, `peekFirst`, `peekLast`

---

### 🔹 LinkedList (as Queue / Deque)
- Implements **List**, **Queue**, and **Deque**
- Based on **Doubly Linked List**
- **Maintains insertion order**, allows duplicates & nulls
- **Not synchronized**
- **Time Complexity:**
  - Add / Remove (ends) → O(1)
  - Contains → O(n)
  - Peek / Get (ends) → O(1)
- **Best for:** Frequent insertions/removals at both ends
- **Methods:** `offer`, `poll`, `peek`, `addFirst`, `addLast`, `removeFirst`, `removeLast`

---

### 🔹 PriorityQueue
- Implements **Queue** interface
- Based on **Binary Heap (Min-Heap by default)**
- **Orders by priority**, not insertion
- **No nulls**, allows duplicates
- **Not synchronized**
- **Time Complexity:**
  - Add / Offer → O(log n)
  - Remove / Poll → O(log n)
  - Peek → O(1)
  - Contains → O(n)
- **Best for:** Problems needing smallest/largest elements (heaps)
- **Methods:** `offer`, `poll`, `peek`, `remove`, `clear`, `contains`

---

🧠 **Summary**
| Category | Implementation | Structure | Order | Null | Duplicates | Add | Remove | Contains | Peek | Best For |
|------------|----------------|------------|--------|------|-------------|------|----------|-----------|--------|------------|
| Set | HashSet | Hash Table | ❌ No | ✅ 1 | ❌ | O(1) | O(1) | O(1) | – | Unique fast lookup |
| Set | LinkedHashSet | Hash Table + Linked List | ✅ Insertion | ✅ 1 | ❌ | O(1) | O(1) | O(1) | – | Unique + ordered |
| Set | TreeSet | Red-Black Tree | ✅ Sorted | ❌ | ❌ | O(log n) | O(log n) | O(log n) | – | Sorted unique |
| Queue | ArrayDeque | Resizable Array | ✅ Insertion | ❌ | ✅ | O(1) | O(1) | O(n) | O(1) | Stack + Queue |
| Queue | LinkedList | Doubly Linked List | ✅ Insertion | ✅ | ✅ | O(1) | O(1) | O(n) | O(1) | Both-end ops |
| Queue | PriorityQueue | Binary Heap | ❌ Priority | ❌ | ✅ | O(log n) | O(log n) | O(n) | O(1) | Min/Max elements |

---

# 🧠 Java Collections Framework – Summary Table
*(Reference Summary inspired by **Take U Forward DSA Sheet**)*  

| **Interface / Family** | **Common Implementations** | **Order** | **Duplicates** | **Null Support*** | **Typical Use-Cases** | **Performance Notes** | **Key APIs / Tips** |
|--------------------------|-----------------------------|-------------|------------------|--------------------|------------------------|----------------------|---------------------|
| **List** | `ArrayList`, `LinkedList`, `Vector` | Maintains insertion order (index-based) | ✅ Allowed | ✅ Yes (elements) | Ordered data, stacks/queues (LinkedList), indexed reads | ArrayList: O(1) get/add-end, O(n) mid insert/remove; LinkedList: O(1) add/remove ends, O(n) random access | `get`, `set`, `add`, `remove`, `indexOf`, `subList` |
| **Set** | `HashSet`, `LinkedHashSet`, `TreeSet` | HashSet: no order; LinkedHashSet: insertion order; TreeSet: sorted | ❌ Not allowed | HashSet/LinkedHashSet: 1 null; TreeSet: none (unless comparator handles) | Unique elements, de-duplication, membership tests | HashSet: O(1) avg add/contains; TreeSet: O(log n) add/contains | `add`, `contains`, `remove`, `iterator` |
| **Queue / Deque** | `ArrayDeque`, `LinkedList`, `PriorityQueue` | Queue: FIFO; Deque: both ends; PriorityQueue: heap-ordered | ✅ Allowed | Null discouraged; PriorityQueue disallows | Task scheduling, BFS, buffering, order-based processing | ArrayDeque: O(1) add/remove ends; PriorityQueue: O(log n) add/poll | `offer`, `poll`, `peek`, `addFirst`, `pollLast` |
| **Map** | `HashMap`, `LinkedHashMap`, `TreeMap` | HashMap: no order; LinkedHashMap: insertion/LRU order; TreeMap: sorted | Keys unique, values can duplicate | HashMap/LinkedHashMap: 1 null key, many null values; TreeMap: none (unless comparator handles) | Key-value mapping, lookups, frequency counting | HashMap: O(1) avg get/put; TreeMap: O(log n) get/put | `get`, `put`, `containsKey`, `remove`, `keySet`, `values`, `entrySet` |
| **Concurrent** | `ConcurrentHashMap`, `CopyOnWriteArrayList`, `ConcurrentLinkedQueue` | Depends on implementation | Based on type | Often disallows nulls | Thread-safe collections for multi-threaded use | Better throughput than synchronized wrappers | Prefer over `Collections.synchronizedXxx()` |
| **Utilities** | `Collections` (class), `Arrays` (class) | — | — | — | Sorting, shuffling, unmodifiable/mutable conversions | — | `sort`, `reverse`, `shuffle`, `unmodifiableList/Set/Map` |
