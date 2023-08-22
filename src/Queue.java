public class Queue {
    int[] arr;
    int  rear;
    int front;
    int size;
    public Queue(int size){
        this.size=size;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[size];
    }
    public boolean isEmpty() {
        return (front == -1 && rear== -1);
    }

    public boolean isFull() {
        return((rear == size - 1 && front == 0)||(front==rear+1));
    }
    public void enqueue(int item){
        if(!isFull()){
            if (isEmpty()){
                front++;
                rear++;
            }else {
                rear=(rear + 1) % size;
            }
            arr[rear]=item;

        }else{
            throw new IndexOutOfBoundsException(-1);
        }

    }
    public int dequeue(){
        if (!isEmpty()){
            int temp = arr[front];
            arr[front]=0;
            if (rear==front){
                rear=-1;
                front=-1;
            }else{
                front=(front + 1) % size;
            }
            return temp;

        }else {
            throw new IndexOutOfBoundsException(-1);
        }
    }

    public int Display() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        return 0;
    }


}
class QueueRunner{
    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.dequeue();
        queue.enqueue(8);
        queue.Display();
    }
}
