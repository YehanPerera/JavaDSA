class stack {
    private int[] arr;
    private int top;
    private int size;

    public stack(int size) {
        this.size = size;
        this.top = -1;
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    void push(int item) {
        if (!isFull()) {
            top++;
            arr[top] = item;
        } else {
            throw new StackOverflowError();
        }
    }

    int pop() {
        if (!isEmpty()) {
            int temp = arr[top];
            arr[top] = 0;
            top--;
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int peak() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public int Display() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        return 0;
    }

}
class Runner{
    public static void main(String[] args) {
        stack stack = new stack(5);
        stack.push(15);
        stack.push(8);
        stack.push(10);
        //stack.Display();
        //System.out.println(stack.pop());
        stack.pop();
        System.out.println(stack.peak());
    }
}
