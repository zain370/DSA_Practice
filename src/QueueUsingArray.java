public class QueueUsingArray {
    private int maxSize; // Maximum size of the queue
    private int[] queueArray; // Array to store queue elements
    private int front; // Front of the queue
    private int rear; // Rear of the queue
    private int currentSize; // Current number of elements in the queue

    // Constructor
    public QueueUsingArray(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Get the number of elements in the queue
    public int size() {
        return currentSize;
    }

    // Insert an element at the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }

        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
    }

    // Remove and return the element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        int dequeuedElement = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return dequeuedElement;
    }

    // Get the element from the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }

        return queueArray[front];
    }

    public class Main {
        public static void main(String[] args) {
            QueueUsingArray queue = new QueueUsingArray(5);
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40);

            System.out.println("Front element: " + queue.peek());
            System.out.println("Queue size: " + queue.size());

            System.out.println("Dequeued element: " + queue.dequeue());
            System.out.println("Dequeued element: " + queue.dequeue());

            queue.enqueue(50);
            queue.enqueue(60);

            System.out.println("Front element: " + queue.peek());
            System.out.println("Queue size: " + queue.size());

            while (!queue.isEmpty()) {
                System.out.println("Dequeued element: " + queue.dequeue());
            }
        }
    }


}
