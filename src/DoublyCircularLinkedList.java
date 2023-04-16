public class DoublyCircularLinkedList {
    private Node head;
    private int size;

    private class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyCircularLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
        size++;
    }

    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            insertAtStart(data);
        } else if (position == size) {
            insertAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    public void deleteAtStart() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next;
        }
        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }
        size--;
    }

    public void deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            deleteAtStart();
        } else if (position == size - 1) {
            deleteAtEnd();
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            current.next.prev = current;
            size--;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);

        }
    }

        public static void main(String[] args) {
            DoublyCircularLinkedList list = new DoublyCircularLinkedList();

            // Insert elements into the list
            list.insertAtEnd(10);
            list.insertAtEnd(20);
            list.insertAtEnd(30);
            list.insertAtStart(5);
            list.insertAtPosition(15, 2);

            // Display the list
            System.out.print("List: ");
            list.display();
            System.out.println("Size: " + list.getSize());

            // Delete elements from the list
            list.deleteAtStart();
            list.deleteAtEnd();
            list.deleteAtPosition(1);

            // Display the list
            System.out.print("List: ");
            list.display();
            System.out.println("Size: " + list.getSize());
        }
}