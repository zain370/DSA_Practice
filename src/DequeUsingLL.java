class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DequeUsingLL {
    private Node front;
    private Node rear;

    public DequeUsingLL() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void insertFront(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public void insertRear(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return -1;
        }

        int data = front.data;
        front = front.next;

        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }

        return data;
    }

    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return -1;
        }

        int data = rear.data;
        rear = rear.prev;

        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }

        return data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return;
        }

        Node current = front;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }


    public class Main {
        public static void main(String[] args) {
            DequeUsingLL deque = new DequeUsingLL();

            deque.insertFront(2);
            deque.insertFront(1);
            deque.insertRear(3);

            deque.display(); // Output: 1 2 3

            deque.deleteFront();
            deque.deleteRear();

            deque.display(); // Output: 2
        }
    }

}


