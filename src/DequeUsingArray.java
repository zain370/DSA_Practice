public class DequeUsingArray {
    private int maxSize;
    private int[] dequeArr;
    private int front;
    private int rear;
    private int currentSize;

    public DequeUsingArray(int size) {
        maxSize = size;
        dequeArr = new int[maxSize];
        front = -1;
        rear = 0;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public int size() {
        return currentSize;
    }

    public void insertFront(int data) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at the front.");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = maxSize - 1;
        } else {
            front--;
        }

        dequeArr[front] = data;
        currentSize++;
        System.out.println("Element " + data + " inserted at the front.");
    }

    public void insertRear(int data) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at the rear.");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == maxSize - 1) {
            rear = 0;
        } else {
            rear++;
        }

        dequeArr[rear] = data;
        currentSize++;
        System.out.println("Element " + data + " inserted at the rear.");
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the front.");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == maxSize - 1) {
            front = 0;
        } else {
            front++;
        }

        currentSize--;
        System.out.println("Element deleted from the front.");
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the rear.");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = maxSize - 1;
        } else {
            rear--;
        }

        currentSize--;
        System.out.println("Element deleted from the rear.");
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. No front element.");
            return -1;
        }

        return dequeArr[front];
    }

    public int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Deque is empty. No rear element.");
            return -1;
        }

        return dequeArr[rear];
    }

    public void display() {
        System.out.print("Elements in the deque: ");
        int i = front;

        while (i != rear) {
            System.out.print(dequeArr[i] + " ");

            if (i == maxSize - 1) {
                i = 0;
            } else {
                i++;
            }
        }

        System.out.println(dequeArr[rear]);
    }

    public static void main(String[] args) {
        DequeUsingArray deque = new DequeUsingArray(5);
        deque.insertFront(10);
        deque.insertFront(20);
        deque.insertRear(30);
        deque.insertRear(40);

        deque.display();  // Output: Elements in the deque: 20 10 30 40

        System.out.println("Front element: " + deque.getFront());  // Output: Front element: 20
        System.out.println("Rear element: " + deque.getRear());    // Output: Rear element: 40

        deque.deleteFront();
        deque.deleteRear();

        deque.display();  // Output: Elements in the deque: 10 30
    }
}
