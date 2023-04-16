import java.util.Scanner;
import java.util.Stack;

public class FactorialWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        scanner.close();

        if (n < 0) {
            System.out.println("Error: input must be a positive integer");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        for (int i = 2; i <= n; i++) {
            stack.push(stack.peek() * i);
        }

        System.out.println(n + "! = " + stack.pop());
    }
}
