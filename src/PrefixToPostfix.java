import java.util.Scanner;
import java.util.Stack;

public class PrefixToPostfix {
    public static String convert(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperand(c)) {
                stack.push(String.valueOf(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(op1 + op2 + c);
            }
        }
        return stack.pop();
    }

    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prefix expression: ");
        String prefix = scanner.nextLine();
        String postfix = convert(prefix);
        System.out.println("Postfix expression: " + postfix);
    }
}
