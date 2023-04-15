
    public class StackUsingLinkedList {

        private Node top;
        private int size;

        public StackUsingLinkedList() {
            this.top = null;
            this.size = 0;
        }

        private class Node {
            private int data;
            private Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size++;
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            int data = top.data;
            top = top.next;
            size--;
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public static void main(String[] args) {
            StackUsingLinkedList stack = new StackUsingLinkedList();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println("Size of stack: " + stack.size());
            System.out.println("Top element of stack: " + stack.peek());
            System.out.println("Pop element from stack: " + stack.pop());
            System.out.println("Pop element from stack: " + stack.pop());
            System.out.println("Pop element from stack: " + stack.pop());
            System.out.println("Is stack empty? " + stack.isEmpty());
        }

    }

