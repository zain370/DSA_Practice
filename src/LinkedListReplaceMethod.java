public class LinkedListReplaceMethod {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void replace(Node list, int i, int x) {
        Node temp = list;
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
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printLinkedList(list);

        replace(list, 2, 10);
        System.out.println(" ");
        System.out.println("Replacing node 2 with value 10");

        System.out.println("Linked List after replacement:");
        printLinkedList(list);
    }

    public static void printLinkedList(Node list) {
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
        System.out.println();
    }

}

