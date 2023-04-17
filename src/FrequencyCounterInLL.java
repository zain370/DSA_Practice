import java.util.Scanner;

public class FrequencyCounterInLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node head;

    FrequencyCounterInLL() {
        head = null;
    }

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    int count(int num) {
        int frequency = 0;
        Node current = head;
        while (current != null) {
            if (current.data == num) {
                frequency++;
            }
            current = current.next;
        }
        return frequency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FrequencyCounterInLL list = new FrequencyCounterInLL();
        System.out.print("Enter the number of integers you want to add to the linked list: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer #" + (i + 1) + ": ");
            int num = scanner.nextInt();
            list.add(num);
        }
        System.out.print("Enter the integer you want to count: ");
        int num = scanner.nextInt();
        int frequency = list.count(num);
        System.out.println(num + " occurs " + frequency + " times in the linked list.");
    }
    
}
