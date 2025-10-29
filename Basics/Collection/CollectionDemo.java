package Basics.Collection;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {

        /*
         * Methods of Collection Interface will used by all the classes
         * implementing Collection Interface. like ArrayList, LinkedList, HashSet, etc.
         * 
         * Methods:
         * add()
         * addAll()
         * clear()
         * contains()
         * isEmpty()
         * iterator()
         * remove()
         * size()
         * toArray()
         */

        /* List Interface Implementations */
        // arrayListExample();
        // linkedListExample();
        // stackExample();
        // vectorExample();

        /* Set Interface Implementations */
        // hashSetExample();
        // linkedHashSetExample();
        // treeSetExample();

        /* Queue/deque Interface Implementations */
        // arrayDequeExample();
        priorityQueueExample();
    }

    private static void arrayListExample() {
        // add
        ArrayList<Object> a1 = new ArrayList<>();
        a1.add("Hello");
        a1.add('B');// char
        a1.add(10.5);// double
        a1.add(11.5f);// float
        a1.add(25l);// long
        System.out.println("After adding elements: " + a1);

        // add with index
        a1.add(1, "World");
        System.out.println("After adding element at index 1: " + a1);

        // clear
        a1.clear();
        System.out.println("After clearing: " + a1);

        // ensureCapacity - It is used to enhance the capacity of an ArrayList instance.
        a1.ensureCapacity(12);

        // get - It is used to fetch the element from the particular position of the
        // list.
        a1.add("Hello");
        a1.add("World");
        System.out.println("Element at index 1: " + a1.get(1));

        // set - It is used to update the element at the specified position in the list.
        System.out.println("Previous element at index 1: " + a1.set(1, "Java"));
        System.out.println("After setting element at index 1: " + a1);

        // isEmpty - It is used to check whether the list is empty or not.
        System.out.println("Is ArrayList empty? " + a1.isEmpty());

        // indexOf - It is used to search for the first occurrence of the given element
        // in the list.
        System.out.println("First Index of 'Java': " + a1.indexOf("Java"));

        // lastIndexOf - It is used to search for the last occurrence of the given
        // element in the list.
        a1.add("Hello");
        System.out.println("Last Index of 'Hello': " + a1.lastIndexOf("Hello"));

        // remove - It is used to remove the element from the specified position in the
        // list.
        System.out.println(a1.remove(2));
        System.out.println("After removing element at index 2: " + a1);

        // sort - It is used to sort the elements of the list in ascending order.
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(5);
        a2.add(1);
        a2.add(3);
        a2.add(2);
        a2.add(4);
        System.out.println("Before Sorting: " + a2);
        a2.sort(Comparator.naturalOrder());
        System.out.println("After Sorting: " + a2);
        a2.sort(Comparator.reverseOrder());
        System.out.println("After Reverse Sorting: " + a2);

        // size - It is used to get the number of elements present in the list.
        System.out.println("Size of ArrayList: " + a2.size());

        // adding multiple elements in ArrayList
        ArrayList<String> a3 = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println("ArrayList with multiple elements: " + a3);
    }

    public static void linkedListExample() {
        LinkedList<Object> list = new LinkedList<>();

        // add
        list.add("Hello");
        list.add(10);
        list.add(20.5);
        System.out.println("After adding elements: " + list);

        // add with index
        list.add(1, "World");
        System.out.println("After adding element at index 1: " + list);

        // addAll
        LinkedList<Object> anotherList = new LinkedList<>();
        anotherList.add("Java");
        anotherList.add(30);
        list.addAll(anotherList);
        System.out.println("After adding all elements from another list: " + list);
        // -> with index
        LinkedList<Object> indexList = new LinkedList<>();
        indexList.add("Start");
        list.addAll(1, indexList);
        System.out.println("After adding all elements at index 1: " + list);

        // addFirst
        list.addFirst("First Element");
        System.out.println("After adding first element: " + list);
        // addLast
        list.addLast("Last Element");
        System.out.println("After adding last element: " + list);

        // remove
        list.remove("World");
        System.out.println("After removing 'World': " + list);

        // removeFirst
        list.removeFirst();
        System.out.println("After removing first element: " + list);

        // removeLast
        list.removeLast();
        System.out.println("After removing last element: " + list);

        // clear
        list.clear();
        System.out.println("After clearing the list: " + list);

        // contains
        list.add("Hello");
        list.add(10);
        System.out.println("List contains 'Hello': " + list.contains("Hello"));
        System.out.println("List contains 20: " + list.contains(20));

        // get
        System.out.println("Element at index 1: " + list.get(1));

        // getFirst
        System.out.println("First element: " + list.getFirst());

        // getLast
        System.out.println("Last element: " + list.getLast());

        // iterator to print elements
        System.out.print("Elements in the list: ");
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void stackExample() {
        Stack<Integer> stack = new Stack<>();

        // push
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("After pushing elements: " + stack);

        // pop
        System.out.println("Popped element: " + stack.pop());
        System.out.println("After popping an element: " + stack);

        // peek
        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Stack after peek: " + stack);

        // isEmpty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // size
        System.out.println("Size of stack: " + stack.size());

        // search
        System.out.println("Position of 10 in stack: " + stack.search(10));
        System.out.println("Position of 40 in stack: " + stack.search(40));
    }

    public static void vectorExample() {
        Vector<String> vector = new Vector<>();

        // add
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");
        System.out.println("After adding elements: " + vector);

        // add with index
        vector.add(1, "Mango");
        System.out.println("After adding element at index 1: " + vector);

        // remove
        vector.remove("Banana");
        System.out.println("After removing 'Banana': " + vector);

        // get
        System.out.println("Element at index 2: " + vector.get(2));

        // size
        System.out.println("Size of vector: " + vector.size());

        // isEmpty
        System.out.println("Is vector empty? " + vector.isEmpty());

        // clear
        vector.clear();
        System.out.println("After clearing the vector: " + vector);

        // clone
        vector.add("Grapes");
        vector.add("Orange");
        Vector<String> clonedVector = (Vector<String>) vector.clone();
        System.out.println("Cloned vector: " + clonedVector);

        // equals
        System.out.println("Vector equals cloned vector? " + vector.equals(clonedVector));

        // elementAt
        System.out.println("Element at index 0: " + vector.elementAt(0));
    }

    public static void hashSetExample() {
        HashSet<Integer> set = new HashSet<>();

        // add
        set.add(null);
        set.add(10);
        set.add(20);
        set.add(30);
        System.out.println("After adding elements: " + set);
        // duplicate add
        set.add(20);
        System.out.println("After adding duplicate element 20: " + set);

        // remove
        set.remove(20);
        System.out.println("After removing 20: " + set);

        // contains
        System.out.println("Set contains 10: " + set.contains(10));
        System.out.println("Set contains 20: " + set.contains(20));

        // size
        System.out.println("Size of set: " + set.size());

        // isEmpty
        System.out.println("Is set empty? " + set.isEmpty());

        // clear
        set.clear();
        System.out.println("After clearing the set: " + set);
    }

    public static void LinkedHashSetExample() {
        LinkedHashSet<String> linkedSet = new LinkedHashSet<>();

        // add
        linkedSet.add("Apple");
        linkedSet.add("Banana");
        linkedSet.add("Cherry");
        System.out.println("After adding elements: " + linkedSet);

        // remove
        linkedSet.remove("Banana");
        System.out.println("After removing 'Banana': " + linkedSet);

        // contains
        System.out.println("LinkedHashSet contains 'Apple': " + linkedSet.contains("Apple"));
        System.out.println("LinkedHashSet contains 'Banana': " + linkedSet.contains("Banana"));

        // size
        System.out.println("Size of LinkedHashSet: " + linkedSet.size());

        // isEmpty
        System.out.println("Is LinkedHashSet empty? " + linkedSet.isEmpty());

        // clear
        linkedSet.clear();
        System.out.println("After clearing the LinkedHashSet: " + linkedSet);
    }

    public static void treeSetExample() {
        TreeSet<Integer> treeSet = new TreeSet<>();

        // add
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);
        System.out.println("After adding elements: " + treeSet);

        // remove
        treeSet.remove(20);
        System.out.println("After removing 20: " + treeSet);

        // contains
        System.out.println("TreeSet contains 10: " + treeSet.contains(10));
        System.out.println("TreeSet contains 20: " + treeSet.contains(20));

        // size
        System.out.println("Size of TreeSet: " + treeSet.size());

        // isEmpty
        System.out.println("Is TreeSet empty? " + treeSet.isEmpty());

        // clear
        treeSet.clear();
        System.out.println("After clearing the TreeSet: " + treeSet);

        // tailSet and headSet
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("HeadSet (elements < 20): " + treeSet.headSet(20));
        System.out.println("TailSet (elements >= 20): " + treeSet.tailSet(20));
        // rangeSet using tailSet
        System.out.println("SubSet (elements from 10 to 30): " + treeSet.subSet(10, 30));

        // reverse order
        System.out.println("TreeSet in reverse order: " + treeSet.descendingSet());
    }

    public static void arrayDequeExample() {
        ArrayDeque<String> deque = new ArrayDeque<>();

        // addFirst and offerFirst
        deque.addFirst("Apple");
        deque.offerFirst("Banana");
        System.out.println("After adding elements at the front: " + deque);

        // add, offer, addLast and offerLast
        deque.add("Cherry");
        deque.offer("Date");
        deque.addLast("Elderberry");
        deque.offerLast("Fig");
        System.out.println("After adding elements at the end: " + deque);

        // peek, peekFirst and peekLast
        System.out.println("First element (peek): " + deque.peek());
        System.out.println("First element (peekFirst): " + deque.peekFirst());
        System.out.println("Last element (peekLast): " + deque.peekLast());

        // remove and removeFirst
        deque.remove();
        System.out.println("After removing first element: " + deque);
        deque.removeFirst();
        System.out.println("After removing first element again: " + deque);

        // removeLast and remove(Object o)
        deque.removeLast();
        System.out.println("After removing last element: " + deque);
        deque.remove("Fig");
        System.out.println("After removing 'Fig': " + deque);

        // poll and pollFirst and pollLast
        System.out.println("Polled first element: " + deque.poll());
        System.out.println("After polling first element: " + deque);
        System.out.println("Polled first element (pollFirst): " + deque.pollFirst());
        System.out.println("After polling first element (pollFirst): " + deque);
        System.out.println("Polled last element (pollLast): " + deque.pollLast());
        System.out.println("After polling last element (pollLast): " + deque);

        // size
        System.out.println("Size of deque: " + deque.size());

        // isEmpty
        System.out.println("Is deque empty? " + deque.isEmpty());

        // clear
        deque.clear();
        System.out.println("After clearing the deque: " + deque);
    }

    public static void priorityQueueExample() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // add & offer
        priorityQueue.offer(12);
        priorityQueue.add(13);
        priorityQueue.add(16);
        priorityQueue.add(15);
        priorityQueue.add(14);
        System.out.println("After adding elements: " + priorityQueue);

        // peek
        System.out.println("Head element (peek): " + priorityQueue.peek());

        // poll
        System.out.println("Polled element: " + priorityQueue.poll());
        System.out.println("After polling an element: " + priorityQueue);

        // size
        System.out.println("Size of priority queue: " + priorityQueue.size());

        // isEmpty
        System.out.println("Is priority queue empty? " + priorityQueue.isEmpty());

        // clear
        priorityQueue.clear();
        System.out.println("After clearing the priority queue: " + priorityQueue);
    }
}
