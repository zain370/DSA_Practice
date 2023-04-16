import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
    public static String convert(String infix) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c)) {
                    prefix.append(stack.pop());
                }
                stack.push(c);
            } else if (isOperand(c)) {
                prefix.append(c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }

    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = scanner.nextLine();
        String prefix = convert(infix);
        System.out.println("Prefix expression: " + prefix);
    }
}
