
//  FA21-BCS-046
//  MUHAMMAD ZAIN



import java.util.Scanner;

public class CircularQueue {

    static int arr[];
    static int size;
    static int back = -1;
    static int front = -1;

    public CircularQueue(int size) {
        arr = new int[size];
        this.size = size;
    }

    public static boolean isEmpty(){
        return back == -1 && front == -1;
    }

    public static boolean isFull(){
        return (back+1) % size == front;
    }

    public static void enqueue(int x){
        if(isFull()){
            System.out.println("Queue is full");
            System.exit(0);
        }
        if(front == -1){
            front = 0;
        }
        back = (back+1) % size;
        arr[back] = x;
    }

    public static int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int result = arr[front];
        if(back == front){
            back = front = -1;
        }else {
            front = (front + 1) % size;
        }
            return result;
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return front;
    }

    public void printCircularQueue(){
        int i;
      for ( i = front; i != back; i=(i+1)% size){
          System.out.println(arr[i]);
      }
        System.out.println(arr[i]);
    }


    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(6);

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 for Enqueue");
        System.out.println("Press 2 for Dnqueue");
        System.out.println("Press 3 for Printing Circular Queue");
        System.out.println("Press 4 to EXIT ");



        do{
            System.out.print("Enter your choice ----->  ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                {
                    System.out.println("enter element to em");
                    int x = sc.nextInt();
                    cq.enqueue(x);
                    break;}

                case 2:
                {cq.dequeue();
                    break;}

                case 3:
                {cq.printCircularQueue();
                    break;}
            }

        } while (choice != 4);
    }

}
