public class PriorityQueueUsingArray {
    private int[] queue;
    private int size;
    private int capacity;

    public PriorityQueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    public void enqueue(int item) {
        if (size == capacity) {
            System.out.println("Priority queue is full. Cannot enqueue item: " + item);
            return;
        }

        if (size == 0) {
            queue[size++] = item;
        } else {
            int i;
            for (i = size - 1; i >= 0; i--) {
                if (item > queue[i]) {
                    queue[i + 1] = queue[i];
                } else {
                    break;
                }
            }
            queue[i + 1] = item;
            size++;
        }
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Priority queue is empty. Cannot dequeue item.");
            return -1;
        }

        int item = queue[size - 1];
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        PriorityQueueUsingArray pq = new PriorityQueueUsingArray(5);
        pq.enqueue(3);
        pq.enqueue(1);
        pq.enqueue(4);
        pq.enqueue(2);
        pq.enqueue(5);

        while (!pq.isEmpty()) {
            System.out.println("Dequeued item: " + pq.dequeue());
        }
    }
}
