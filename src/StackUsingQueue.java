import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        queue1.add(value);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int result = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return result;
    }

    public int peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int result = queue1.remove();
        queue2.add(result);
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return result;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // output: 3
        System.out.println(stack.pop()); // output: 2
        System.out.println(stack.peek()); // output: 1
        System.out.println(stack.isEmpty()); // output: false
        System.out.println(stack.size()); // output: 1
    }
}
