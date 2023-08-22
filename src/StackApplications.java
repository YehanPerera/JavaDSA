import java.util.Stack;
public class StackApplications {
    public static String infixToPostfix(String expression){
        Stack<Character> charStack = new Stack<Character>();
        String postfix = "";
        for (char element : expression.toCharArray()){
            if (element=='+' ||element=='-' ||element=='*' ||element=='/' ){
                if (charStack.isEmpty()){
                    charStack.push(element);
                } else if (element=='+' ||element=='-') {
                    while (!charStack.isEmpty() && charStack.peek() != '('){
                        postfix = postfix + charStack.pop();
                    }
                    charStack.push(element);

                } else if (element=='*' ||element=='/') {
                    while (!charStack.isEmpty() && charStack.peek() != '+'&& charStack.peek() != '-'&& charStack.peek() != '('){
                        postfix = postfix + charStack.pop();
                    }
                    charStack.push(element);
                }
            } else if (element == '(') {
                charStack.push(element);
            } else if (element == ')') {
                while (charStack.peek()!='('){
                    postfix = postfix + charStack.pop();
                }
                charStack.pop();

            }else {
                postfix = postfix + element;
            }

        }
        while (!charStack.isEmpty()){
            postfix = postfix + charStack.pop();
        }
        return postfix;
    }

    public static double evaluatePostfix(String expression){
        Stack<String> stack = new Stack<String>();
        for(char character : expression.toCharArray()){
            if (character == '+'|| character == '-' || character == '*' || character == '/' ){
                double operand2= Double.parseDouble(stack.pop());
                double operand1= Double.parseDouble(stack.pop());
                double result = 0;
                if(character == '+'){
                    result = operand1 + operand2;
                }else if(character == '-'){
                    result = operand1 - operand2;
                }else if(character == '*'){
                    result = operand1 * operand2;
                }else if(character == '/'){
                    result = operand1 / operand2;
                }
                stack.push(String.valueOf(result));
            }else {
                stack.push(String.valueOf(character));
            }
        }
        return Double.parseDouble(stack.pop());
    }


    public static void main(String[] args) {
        System.out.println(infixToPostfix("2+3*5-3/9"));
        System.out.println(evaluatePostfix("235*+39/-"));
    }

}
