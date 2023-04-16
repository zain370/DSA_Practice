import java.util.Stack;
import java.util.Scanner;

public class PrefixToInfix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prefix expression: ");
        String prefix = scanner.nextLine();
        String infix = convertToInfix(prefix);
        System.out.println("Infix expression: " + infix);
    }

    public static String convertToInfix(String prefix) {
        Stack<String> stack = new Stack<String>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperand(c)) {
                stack.push(Character.toString(c));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op1 + c + op2 + ")");
            }
        }
        return stack.pop();
    }

    public static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

}
