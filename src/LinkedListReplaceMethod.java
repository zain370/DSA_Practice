public class LinkedListReplaceMethod {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void replace(Node head, int i, int x) {
        Node temp = head;
        int count = 0;

        while (temp != null && count < i) {
            temp = temp.next;
            count++;
        }

        if (temp != null) {
            temp.data = x;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        replace(head, 2, 10);
        System.out.println(" ");
        System.out.println("Replacing node 2 with value 10");

        System.out.println("Linked List after replacement:");
        printLinkedList(head);
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

}

