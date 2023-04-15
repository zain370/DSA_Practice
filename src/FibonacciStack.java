import java.util.Stack;
public class FibonacciStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        int limit = 10;
        int fib1 = 0, fib2 = 1;

        stack.push(fib1);
        stack.push(fib2);

        for (int i = 2; i < limit; i++) {
            int fib3 = fib1 + fib2;
            stack.push(fib3);
            fib1 = fib2;
            fib2 = fib3;
        }

        System.out.println("Fibonacci series using stack:");
        for (int i = 0; i < limit; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}