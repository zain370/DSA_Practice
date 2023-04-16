public class RotateLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    

    public void rotate(int d) {
        if (d <= 0 || head == null) {
            return; // no rotation needed
        }
        int count = 1;
        Node current = head;
        while (count < d && current != null) {
            current = current.next;
            count++;
        }
        if (current == null) {
            return; // d is greater than the length of the list
        }
        Node temp = current;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head = current.next;
        current.next = null;
    }

    public static void printLinkedList(Node list) {
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
        System.out.println();
    }


    // Sample test
    public static void main(String[] args) {

        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);

        printLinkedList(list);





    }


}
