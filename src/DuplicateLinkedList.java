public class DuplicateLinkedList{

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node copy(Node list) {
        Node duplicatelist = null;
        Node duplicateTail = null;

        while (list != null) {
            Node newNode = new Node(list.data);
            if (duplicatelist == null) {
                duplicatelist = newNode;
                duplicateTail = newNode;
            } else {
                duplicateTail.next = newNode;
                duplicateTail = newNode;
            }
            list = list.next;
        }
        return duplicatelist;
    }

    public static void main(String[] args) {
        Node originallist = new Node("Java");
        originallist.next = new Node("Python");
        originallist.next.next = new Node("Ruby");

        Node duplicatelist = copy(originallist);

        // Modify the original linked list
        originallist.next.next.data = "Ruby";

        System.out.println("Original Linked List:");
        printLinkedList(originallist);

        System.out.println(" ");

        System.out.println("Duplicate Linked List:");
        printLinkedList(duplicatelist);
    }

    public static void printLinkedList(Node list) {
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
        System.out.println();
    }
}
