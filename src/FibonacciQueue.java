public class FibonacciQueue {

    public static void fibonacci(int n) {
        Queue q = new Queue(n);
        int a = 0;
        int b = 1;
        int c;
        q.enqueue(a);
        q.enqueue(b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            q.enqueue(c);
            a = b;
            b = c;
        }
        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }
    }


}


