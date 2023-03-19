public class DuplicateLinkedList{

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node duplicateLinkedList(Node head) {
        Node duplicateHead = null;
        Node duplicateTail = null;

        while (head != null) {
            Node newNode = new Node(head.data);
            if (duplicateHead == null) {
                duplicateHead = newNode;
                duplicateTail = newNode;
            } else {
                duplicateTail.next = newNode;
                duplicateTail = newNode;
            }
            head = head.next;
        }
        return duplicateHead;
    }

    public static void main(String[] args) {
        Node originalHead = new Node("apple");
        originalHead.next = new Node("banana");
        originalHead.next.next = new Node("orange");

        Node duplicateHead = duplicateLinkedList(originalHead);

        // Modify the original linked list
        originalHead.next.next.data = "grape";

        System.out.println("Original Linked List:");
        printLinkedList(originalHead);

        System.out.println("Duplicate Linked List:");
        printLinkedList(duplicateHead);
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
