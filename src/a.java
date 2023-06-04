import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;

import java.util.Deque;

public class a {
/*

<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< STACK >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Stack<Integer> stack = new Stack<>();

push(E item)
This method pushes an item onto the top of the stack.
Usage: stack.push(item);

pop()
This method removes and returns the item at the top of the stack.
Usage: E item = stack.pop();

peek()
This method returns the item at the top of the stack without removing it.
Usage: E item = stack.peek();

empty()
This method checks if the stack is empty.
Usage: boolean isEmpty = stack.empty();

search(Object o)
This method searches for the specified object in the stack and returns its position as a 1-based index. If the object is not found, it returns -1.
Usage: int position = stack.search(o);




<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< QUEUE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Queue<Integer> queue = new LinkedList<>();
Queue<String> queue = new PriorityQueue<>();

boolean add(E element)
This method adds the specified element to the queue.
Example: queue.add(element);

boolean offer(E element)
This method adds the specified element to the queue.
It returns true if the element was successfully added, or false if the element cannot be added.
Example: boolean added = queue.offer(element);

remove()
This method removes and returns the head of the queue.
It throws a NoSuchElementException if the queue is empty.
Example: E element = queue.remove();

poll()
This method removes and returns the head of the queue.
It returns null if the queue is empty.
Example: E element = queue.poll();

element()
This method returns the head of the queue without removing it.
It throws a NoSuchElementException if the queue is empty.
Example: E element = queue.element();

peek()
This method returns the head of the queue without removing it.
It returns null if the queue is empty.
Example: E element = queue.peek();





<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PRIORITY QUEUE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
PriorityQueue<Integer> pq = new PriorityQueue<>();

add(E element) / offer(E element): Adds the specified element to the priority queue.
pq.add(5);

remove() / poll(): Retrieves and removes the head of the priority queue, or returns null if the queue is empty.
pq.add(5);
int head = pq.poll();

element() / peek(): Retrieves, but does not remove, the head of the priority queue, or returns null if the queue is empty.
pq.add(5);
int head = pq.peek();

size(): Returns the number of elements in the priority queue.
pq.add(5);
int size = pq.size();

isEmpty(): Returns true if the priority queue is empty, false otherwise.
boolean empty = pq.isEmpty();

clear(): Removes all elements from the priority queue.
pq.add(5);
pq.clear();

contains(Object o): Returns true if the priority queue contains the specified element, false otherwise.
pq.add(5);
boolean contains = pq.contains(5);

toArray(): Returns an array containing all the elements in the priority queue.
pq.add(5);
Object[] array = pq.toArray();




<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< DEQUE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Deque<Integer> deque = new LinkedList<>();

boolean add(E element)
Adds the specified element to the end of the deque.
Example: deque.add(10);

void addFirst(E element)
Inserts the specified element at the front of the deque.
Example: deque.addFirst(5);

void addLast(E element)
Inserts the specified element at the end of the deque.
Example: deque.addLast(15);

boolean offer(E element)
Adds the specified element to the end of the deque if possible.
Returns true if the element was added successfully, or false if not.
Example: deque.offer(20);

boolean offerFirst(E element)
Inserts the specified element at the front of the deque if possible.
Returns true if the element was inserted successfully, or false if not.
Example: deque.offerFirst(2);

boolean offerLast(E element)
Inserts the specified element at the end of the deque if possible.
Returns true if the element was inserted successfully, or false if not.
Example: deque.offerLast(25);

E remove()
Retrieves and removes the first element of the deque.
Example: E element = deque.remove();

E removeFirst()
Retrieves and removes the first element of the deque.
Example: E element = deque.removeFirst();

E removeLast()
Retrieves and removes the last element of the deque.
Example: E element = deque.removeLast();

E poll()
Retrieves and removes the first element of the deque if it is not empty.
Returns null if the deque is empty.
Example: E element = deque.poll();

E pollFirst()
Retrieves and removes the first element of the deque if it is not empty.
Returns null if the deque is empty.
Example: E element = deque.pollFirst();

E pollLast()
Retrieves and removes the last element of the deque if it is not empty.
Returns null if the deque is empty.
Example: E element = deque.pollLast();




<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< LINKED LIST >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
LinkedList<String> linkedList = new LinkedList<>();

add(E element)
Adds the specified element to the end of the list.
Example: myLinkedList.add("Hello");

add(int index, E element)
Inserts the specified element at the specified position in the list.
Example: myLinkedList.add(0, "World");

remove(int index)
Removes the element at the specified position in the list.
Example: myLinkedList.remove(2);

get(int index)
Returns the element at the specified position in the list.
Example: String element = myLinkedList.get(1);

size()
Returns the number of elements in the list.
Example: int size = myLinkedList.size();

isEmpty()
Returns true if the list is empty, false otherwise.
Example: boolean empty = myLinkedList.isEmpty();

contains(Object o)
Returns true if the list contains the specified element, false otherwise.
Example: boolean contains = myLinkedList.contains("Hello");

clear()
Removes all elements from the list.
Example: myLinkedList.clear();

indexOf(Object o)
Returns the index of the first occurrence of the specified element in the list, or -1 if it is not present.
Example: int index = myLinkedList.indexOf("World");

lastIndexOf(Object o)
Returns the index of the last occurrence of the specified element in the list, or -1 if it is not present.
Example: int lastIndex = myLinkedList.lastIndexOf("Hello");






*/

}
