import java.util.LinkedList;

public class HeapPriorityQueue {
    private LinkedList<Integer> heap;

    public HeapPriorityQueue() {
        heap = new LinkedList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void insert(int value) {
        int index = 0;
        while (index < heap.size() && value > heap.get(index)) {
            index++;
        }
        heap.add(index, value);
    }

    public int removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        return heap.removeFirst();
    }

    public void printQueue() {
        for (int value : heap) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapPriorityQueue pq = new HeapPriorityQueue();

        pq.insert(15);
        pq.insert(25);
        pq.insert(35);
        pq.insert(45);
        pq.insert(55);


        System.out.print("Priority Queue elements: ");
        pq.printQueue();

        System.out.println( "");
        System.out.println("Removing elements from the Priority Queue:");
        while (!pq.isEmpty()) {
            int min = pq.removeMin();
            System.out.println("Element " + min + " is removed");
        }
    }
}
