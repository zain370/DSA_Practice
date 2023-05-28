class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class HeapPriorityQueue {
    private ListNode head;

    public HeapPriorityQueue() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int value) {
        ListNode newNode = new ListNode(value);

        if (head == null || value < head.val) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null && curr.next.val <= value) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    public int removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }

        int minValue = head.val;
        head = head.next;
        return minValue;
    }

    public void printQueue() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapPriorityQueue pq = new HeapPriorityQueue();

        pq.insert(10);
        pq.insert(20);
        pq.insert(30);
        pq.insert(40);
        pq.insert(50);
        pq.insert(60);
        pq.insert(70);

        System.out.println("Priority Queue elements:");
        pq.printQueue();

        System.out.println("Removing elements from the Priority Queue:");
        while (!pq.isEmpty()) {
            int min = pq.removeMin();
            System.out.println("Removed: " + min);
        }

        System.out.println("Priority Queue elements:");
        pq.printQueue();
    }
}
