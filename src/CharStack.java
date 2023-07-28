public class CharStack {
    private static char[] arr;
    private static int top;
    private static int size;

    public CharStack(int size) {
        this.size = size;
        this.top = -1;
        this.arr = new char[size];
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    public static boolean isFull() {
        return top == size - 1;
    }

    static void push(char item) {
        if (!isFull()) {
            top++;
            arr[top] = item;
        } else {
            throw new StackOverflowError();
        }
    }

    static char pop() {
        if (!isEmpty()) {
            char temp = arr[top];
            arr[top] = 0;
            top--;
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static char peak() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public static int Display() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        return 0;
    }

}
class CharRunner{
    public static boolean isPalindrome(String word){
        CharStack charStack=new CharStack(word.length());
        String reverseWord="";
        for (char i : word.toCharArray()){
            charStack.push(i);
        }
        while (!charStack.isEmpty()){
            reverseWord=reverseWord + charStack.pop();
        }
        return word.equals(reverseWord);
    }
    public static boolean isBalancedParanthesis(String expression){
        CharStack bracketStack = new CharStack(expression.length());
        for (char i:expression.toCharArray()){
            if (i=='{' || i=='(' || i=='['){
                bracketStack.push(i);
            } else if (i=='}' || i==')' || i==']') {
                if (bracketStack.isEmpty()){
                    return false;
                }else {
                    char temp = bracketStack.pop();
                    if (i == '}' && temp != '{') {
                        return false;
                    } else if (i == ')' && temp != '(') {
                        return false;
                    } else if (i == ']' && temp != '[') {
                        return false;

                    }
                }

            }
        }
        if (bracketStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
//public static boolean brackets(String expression) {
//
//    CharStack bracketStack = new CharStack(expression.length());
//
//    for (char i : expression.toCharArray()) {
//        if (i == '(' || i == '[' || i == '{') {
//            bracketStack.push(i);
//        } else if (i == ')' || i == ']' || i == '}') {
//            if (bracketStack.isEmpty()) {
//                return false;
//            } else {
//
//                char temp = bracketStack.pop();
//
//                if (i == ')' && temp != '(') {
//                    return false;
//                } else if (i == ']' && temp != '[') {
//                    return false;
//                } else if (i == '}' && temp != '{') {
//                    return false;
//                }
//            }
//        }
//    }
//
//    if (bracketStack.isEmpty()) {
//        return true;
//    } else {
//        return false;
//    }
//
//}



    public static void main(String[] args) {
        //CharStack CharStack = new CharStack(4);
        //CharStack.push('A');
        //CharStack.push('B');
        //CharStack.push('C');
        //CharStack.Display();
        //System.out.println(CharStack.pop());
        //CharStack.pop();
        //System.out.println(CharStack.peak());
        //System.out.println(isPalindrome("DOFG"));
        System.out.println(isBalancedParanthesis("{(jkl)}"));
    }
}

