public class LinkList {
    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void addBackNode(int x){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addFirstNode(int x){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;

        }
    }

    public void printLinkList(){
        Node current = head;
        if(head == null){
            System.out.println("List is empty !");
            return;
        }
        else {
            System.out.println("Elements in Linked List are ");
            while (current!= null){
                System.out.println(current.data + " ");
                current = current.next;
            }
        }

    }

    public boolean search(int key) {
        Node current = head; // Start at the head of the list
        while (current != null) {
            if (current.data == key) {  // Found the key, return true
                return true;
            }
            current = current.next; // Move to the next node
        }
        return false;
    }

    public void deleteLastNode() {
        if (head == null) {
            // If the list is empty, do nothing
            return;
        } else if (head.next == null) {
            // If the list has only one node, delete it
            head = null;
            return;
        }

        // Find the second-to-last node
        Node secondToLast = head;
        while (secondToLast.next.next != null) {
            secondToLast = secondToLast.next;
        }

        // Remove the last node
        secondToLast.next = null;
    }

    public void deleteFirstNode() {
        if (head == null) {
            return;
        }
        head = head.next; // Set the head to the next node
    }

    public void insertAfterLocation(int element,int location){
        int x=0;
        Node current=head;
        Node newNode=new Node(element);
        if(head==null){
            head=newNode;
            return;
        }
        while (current.next!=null){
            if (x==location){
                newNode.next=current.next;
                current.next=newNode;
                break;
            }
            current=current.next;
            x++;
        }
    }

    public void deleteNodeAtPosition(int position) {
        if (head == null) {
            // If the list is empty, do nothing
            return;
        } else if (position == 0) {
            // If the position is 0, delete the first node
            head = head.next;
            return;
        }

        // Find the node before the one to delete
        Node previous = head;
        for (int i = 0; i < position - 1 && previous.next != null; i++) {
            previous = previous.next;
        }

        if (previous == null || previous.next == null) {
            // If the position is out of range, do nothing
            return;
        }

        // Remove the node at the specified position
        previous.next = previous.next.next;
    }


    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.addBackNode(20);
        ll.addBackNode(30);
        ll.addBackNode(40);
        ll.addBackNode(50);
        ll.printLinkList();
        System.out.println(" ");

        ll.addFirstNode(10);
        ll.addFirstNode(20);
        ll.addFirstNode(30);
        ll.addFirstNode(40);
        ll.printLinkList();

        System.out.println(ll.search(50));

        ll.deleteFirstNode();
        ll.printLinkList();

        ll.insertAfterLocation(2222,2);
        ll.printLinkList();
    }

}
