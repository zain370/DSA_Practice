import java.util.Arrays;

public class Stack {
    public int []stack;
    public int top;
    public int size;


    Stack(int size){
        stack = new int[size];
        this.size = size;
        top = -1;
    }



    public static void main(String[] args) {

        Stack stack = new Stack(5);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }

    public void push(int x){
        if(isFull()){
            System.out.println("Stack Overflow");
            System.exit(0);
        }
        else{
            top++;
            stack[top] = x;
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            System.exit(0);
        }

        return stack[top--];
    }

    public boolean isFull(){
        return top == size - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void printStack(){
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i]  );
        }
    }


}