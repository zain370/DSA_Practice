
class PriorityQueueUsingLL {
    class Node {
        int data;
        int priority;
        Node next;

        public Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }
    private Node front;

    public PriorityQueueUsingLL() {
        front = null;
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return (front == null);
    }

    // Method to insert an element into the priority queue
    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

        if (isEmpty() || priority < front.priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node current = front;
            while (current.next != null && priority >= current.next.priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Method to remove and return the element with the highest priority
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }

        int data = front.data;
        front = front.next;
        return data;
    }

    // Method to print the elements of the priority queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
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
            PriorityQueueUsingLL pq = new PriorityQueueUsingLL();

            pq.enqueue(10, 1);
            pq.enqueue(20, 3);
            pq.enqueue(30, 2);
            pq.enqueue(40, 4);

            System.out.print("Priority Queue: ");
            pq.display();

            int removedItem = pq.dequeue();
            System.out.println("Removed item: " + removedItem);

            System.out.print("Priority Queue after removal: ");
            pq.display();
        }
    }


}

// Main class to test the Priority Queue implementation
