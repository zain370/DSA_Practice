import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {

    private static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // convert character to integer and push to stack
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '^':
                        stack.push((int) Math.pow(operand1, operand2));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String expression = scanner.nextLine();
        int result = evaluatePostfix(expression);
        System.out.println("Result: " + result);
    }
}