import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FactorialWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        for (int i = 1; i <= n; i++) {
            int factorialSoFar = queue.remove();
            factorialSoFar *= i;
            queue.add(factorialSoFar);
        }
        System.out.println(n + "! = " + queue.remove());
    }
}
