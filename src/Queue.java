public class Queue {
    static int arr[];
    static int size;
    static int rear = -1;

    public Queue(int size) {
        arr = new int[size];
        this.size = size;
    }

    public static boolean isEmpty(){
        return rear == -1;
    }

    public static void add(int x){
        if(rear == size - 1){
            System.out.println("Queue is full");
            System.exit(0);
        }
        rear++;                     // rear++ means that index of last element will be incremented when a new element will be added to the queue/
        arr[rear] = x;
    }

    public static int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i+1];
        }
        rear--;                     // rear-- means that index of last element will be decremented when first element will be removed from the queue
        return front;
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        while (!queue.isEmpty()){
            System.out.println("Element "+peek()+" is removed from Queue");
            queue.remove();
        }

    }

}
