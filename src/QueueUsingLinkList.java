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

    public int removeSecond() {
        if (front == null || front.next == null) {
            throw new IllegalArgumentException("Queue has fewer than two elements");
        }
        Node second = front.next;
        front.next = second.next;
        if (front.next == null) {
            rear = front;
        }
        return second.data;
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

            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            System.out.print("Before removing the second element: ");
            queue.display();
            queue.removeSecond();

            System.out.print("After removing the second element:  ");


            queue.display();

            System.out.println("Dequeued element: " + queue.dequeue());

            queue.display();

            System.out.println("Front element: " + queue.peek());

            queue.enqueue(40);

            queue.display();

    }
}
