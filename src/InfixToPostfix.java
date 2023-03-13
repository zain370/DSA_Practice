import java.util.Stack;

public class InfixToPostfix {


    public String infixToPostfix(String infix) {

        String postfixExp = "";
        Stack<Character> stack = new Stack<>();
        stack.push('(');

        postfixExp = postfixExp.concat(String.valueOf(')'));

        for (int i = 0; i < infix.length(); i++) {
            char Chrac = infix.charAt(i);
            if (Character.isAlphabetic(Chrac) || Character.isDigit(Chrac)) {
                postfixExp = postfixExp.concat(String.valueOf(Chrac));
            } else if (Chrac=='('){
                stack.push(Chrac);
            } else if(isOperator(Chrac)){
                while (!stack.empty()){

                    if(precedence(stack.peek())>=precedence(Chrac)){
                        postfixExp=postfixExp.concat(String.valueOf(stack.pop()));

                    }
                    else{
                        stack.push(Chrac);
                        break;
                    }

                }
            }
            else if(Chrac==')'){
                while(!stack.empty())
                {
                    if(stack.peek()!='('){
                        postfixExp=postfixExp.concat(String.valueOf(stack.pop()));
                    }
                    else{
                        stack.pop();
                        break;
                    }
                }

            }



        }

        return postfixExp;
    }
        boolean isOperator(char x){
            boolean response=false;

            switch(x){
                case '/':
                case'^':
                case '+':
                case'-':
                case'*':
                    response = true;

            }
            return response;
        }

        int precedence(char x ){
            int response=0;

            switch (x)
            {
                case'^':
                    response=3;
                    break;
                case'/':
                case'*':
                    response=2;
                    break;
                case'+':
                case'-':
                    response=1;
                    break;
            }
                    return response;

        }








    public static void main(String[] args) {
        InfixToPostfix ip=new InfixToPostfix();
        String infix="A*B/D";
        System.out.println(ip.infixToPostfix(infix));
    }

}