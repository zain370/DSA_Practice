public class QueueUsingLinkList {

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    public QueueUsingLinkList() {
        this.front = null;
        this.rear  = null;
    }

    public boolean isEmpty(){
        return front  == rear;
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(rear == null){
            front = rear = newNode;
            return;
        }
        else {
            rear.next = newNode;
            rear      = newNode;
        }
    }

    public int dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        else {
            Node temp = front;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return temp.data;
        }
    }

    public int peek(){
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


        public static void main(String[] args) {

            QueueUsingLinkList queue = new QueueUsingLinkList();

            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            queue.display();

            System.out.println("Dequeued element: " + queue.dequeue());

            queue.display();

            System.out.println("Front element: " + queue.peek());

            queue.enqueue(40);

            queue.display();

    }
}
