class DynamicStack {
    private Node top;
    private int size;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    DynamicStack() {
        this.top = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return top.value;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        DynamicStack stack = new DynamicStack();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.print();

        stack.pop();
        stack.print();


    }


}
