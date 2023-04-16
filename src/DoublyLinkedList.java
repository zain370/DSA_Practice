public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;
        size++;
    }

    public void insertAtPosition(int data, int position) {
        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node newNode = new Node(data);

        if (position == 1) {
            insertAtStart(data);
        } else if (position == size) {
            insertAtEnd(data);
        } else {
            Node current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }

            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;

            size++;
        }
    }

    public void deleteAtStart() {
        if (isEmpty()) {
            throw new NullPointerException("List is empty");
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            throw new NullPointerException("List is empty");
        }

        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteAtPosition(int position) {
        if (isEmpty()) {
            throw new NullPointerException("List is empty");
        }

        if (position < 1 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 1) {
            deleteAtStart();
        } else if (position == size) {
            deleteAtEnd();
        } else {
            Node current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void display() {
        Node current = head;

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


        public static void main(String[] args) {
            DoublyLinkedList list = new DoublyLinkedList();

            // Insert elements
            list.insertAtStart(10);
            list.insertAtStart(20);
            list.insertAtStart(30);
            list.insertAtEnd(40);
            list.insertAtPosition(50, 2);

            // Display list
            System.out.print("List after insertions: ");
            list.display();

            // Delete elements
            list.deleteAtStart();
            list.deleteAtEnd();
            list.deleteAtPosition(1);

            // Display list
            System.out.print("List after deletions: ");
            list.display();
        }

}
