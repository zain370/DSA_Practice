/*public class  CircularQueueUsingLL {

     private Node rear;
     private int size;

     private class Node {
         int data;
         Node next;
         public Node(int data) {
             this.data = data;
             this.next = null;
         }
     }

     public  CircularQueueUsingLL() {
         rear = null;
         size = 0;
     }

     public void enqueue(int data) {
         Node newNode = new Node(data);
         if (rear == null) {
             rear = newNode;
             rear.next = rear;
         } else {
             newNode.next = rear.next;
             rear.next = newNode;
             rear = newNode;
         }
         size++;
     }

     public int dequeue() {
         if (rear == null) {
             throw new IllegalStateException("Queue is empty");
         }
         int data = rear.next.data;
         if (rear.next == rear) {
             rear = null;
         } else {
             rear.next = rear.next.next;
         }
         size--;
         return data;
     }

    public void reverse() {
        Node prev = null;
        Node current = front;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        rear = front;
        front = prev;
    }


    public int front() {
         if (rear == null) {
             throw new IllegalStateException("Queue is empty");
         }
         return rear.next.data;
     }




    public int size() {
         return size;
     }

     public boolean isEmpty() {
         return rear == null;
     }

     public void printQueue() {
         if (rear == null) {
             System.out.println("Queue is empty");
             return;
         }
         Node temp = rear.next;
         while (temp != rear) {
             System.out.print(temp.data + " ");
             temp = temp.next;
         }
         System.out.println(rear.data);
     }

     public static void main(String[] args) {
          CircularQueueUsingLL queue = new  CircularQueueUsingLL();
         queue.enqueue(1);
         queue.enqueue(2);
         queue.enqueue(3);
         queue.enqueue(4);
         queue.enqueue(5);
         queue.printQueue();

         System.out.println("5 4 3 2 1");
     }
 }


/*/