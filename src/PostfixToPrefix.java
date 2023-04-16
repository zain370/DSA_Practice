import java.util.Scanner;
import java.util.Stack;

public class PostfixToPrefix {
    public static String convert(String postfix) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperand(c)) {
                stack.push(String.valueOf(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(c + op2 + op1);
            }
        }
        return stack.pop();
    }

    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a postfix expression: ");
        String postfix = scanner.nextLine();
        String prefix = convert(postfix);
        System.out.println("Postfix expression: " + postfix);
        System.out.println("Prefix expression: " + prefix);
    }
}
