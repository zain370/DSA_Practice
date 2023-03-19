public class ConcatLinkedList{

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node concat(Node list1, Node list2) {
        Node newHead = null;
        Node tail = null;

        while (list1 != null) {
            Node newNode = new Node(list1.data);
            if (newHead == null) {
                newHead = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            list1 = list1.next;
        }

        while (list2 != null) {
            Node newNode = new Node(list2.data);
            if (newHead == null) {
                newHead = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            list2 = list2.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node list1 = new Node("10");
        list1.next = new Node("20");
        list1.next.next = new Node("30");

        Node list2 = new Node("40");
        list2.next = new Node("50");

        Node newHead = concat(list1, list2);

        System.out.println("First Linked List:");
        printLinkedList(list1);

        System.out.println("Second Linked List:");
        printLinkedList(list2);

        System.out.println("Concatenated Linked List:");
        printLinkedList(newHead);
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
