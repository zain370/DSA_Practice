import java.util.Stack;
public class QueueUsingStack {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public QueueUsingStack() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void enqueue(int data) {
        inputStack.push(data);
    }

    public int dequeue() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        if (!outputStack.isEmpty()) {
            return outputStack.pop();
        }
        return -1; // return -1 if queue is empty
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // output: 1
        System.out.println(queue.dequeue()); // output: 2
        System.out.println(queue.isEmpty()); // output: false
        System.out.println(queue.dequeue()); // output: 3
        System.out.println(queue.isEmpty()); // output: true
    }
}
