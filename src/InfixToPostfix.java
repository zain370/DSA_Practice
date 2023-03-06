/*
import java.util.Stack;

public class InfixToPostfix {

    public int precedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    public String infixToPostfix(String s){
        Stack<Character> myStack = new Stack<>();

        char  []res = new char[s.length()];
        char[] stringToChar = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i))){
                res[i] =stringToChar[i];

            }

            else if(stringToChar[i] == '('){
                myStack.push((stringToChar[i]));
            }

            else if(stringToChar[i] == ')'){
                while (!myStack.isEmpty() && myStack.peek()!='('){
                    res[i] =myStack.peek();
                    myStack.pop();
                }
                if(myStack.isEmpty()){
                    myStack.pop();
                }
                else {
                    while (!myStack.isEmpty() && precedence() )
                }
            }


        }
    }}


*/