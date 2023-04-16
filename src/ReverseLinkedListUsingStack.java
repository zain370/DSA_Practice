import java.util.Stack;
public class ReverseLinkedListUsingStack {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        Node newHead = stack.pop();
        Node node = newHead;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return newHead;
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original linked list:");
        printLinkedList(head);

        Node newHead = reverseLinkedList(head);

        System.out.println("Reversed linked list:");
        printLinkedList(newHead);
    }
}
