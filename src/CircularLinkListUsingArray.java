public class CircularLinkListUsingArray {
    private int[] arr;
    private int size;
    private int front;
    private int rear;

    public CircularLinkListUsingArray(int capacity) {
        arr = new int[capacity];
        size = 0;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Circular linked list is full. Cannot enqueue.");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % arr.length;
        }

        arr[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Circular linked list is empty. Cannot dequeue.");
            return -1;
        }

        int data = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }

        size--;
        return data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Circular linked list is empty.");
            return;
        }

        System.out.print("Circular Linked List: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % arr.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkListUsingArray list = new CircularLinkListUsingArray(5);
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.display(); // Output: Circular Linked List: 1 2 3
        System.out.println("Dequeued: " + list.dequeue()); // Output: Dequeued: 1
        list.display(); // Output: Circular Linked List: 2 3
        list.enqueue(4);
        list.enqueue(5);
        list.enqueue(6); // Output: Circular linked list is full. Cannot enqueue.
        list.display(); // Output: Circular Linked List: 2 3 4 5
    }
}
