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
