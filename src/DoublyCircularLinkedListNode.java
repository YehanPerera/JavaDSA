public class DoublyCircularLinkedListNode {
    int data;
    DoublyCircularLinkedListNode next;
    DoublyCircularLinkedListNode prev;

    DoublyCircularLinkedListNode (int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class DoublyCircularLinkedList{
    DoublyCircularLinkedListNode head;
    public void insert(int data){
        DoublyCircularLinkedListNode newNode=new DoublyCircularLinkedListNode(data);
        if(head==null){
            head=newNode;
            newNode.next=head;
            newNode.prev=head;
        }
        else{
            DoublyCircularLinkedListNode temp=head;
            while (temp.next!=head){
                temp=temp.next;
            }
            newNode.next=head;
            newNode.prev=temp;
            temp.next=newNode;
            head.prev=newNode;

        }
    }
    //Inserting a Node Anywhere
    public void insert(int data, int index) {
        DoublyCircularLinkedListNode newNode = new DoublyCircularLinkedListNode(data);

        if (index == 0) {
            if (head == null) {
                head=newNode;
                newNode.next=head;
                newNode.prev=head;
            } else {
                DoublyCircularLinkedListNode temp=head;
                while (temp.next!=head){
                    temp=temp.next;
                }
                newNode.next=head;
                newNode.prev=temp;
                temp.next=newNode;
                head.prev=newNode;
                head=newNode;
            }
        } else {
            int currindex = 0;
            DoublyCircularLinkedListNode temp = head;

            while (temp.next != head && currindex < index - 1) {
                temp = temp.next;
                currindex++;
            }
            if (temp.next != head && currindex == index - 1) {
                newNode.next = temp.next;
                newNode.prev=temp;
                temp.next.prev=newNode;
                temp.next = newNode;
            } else if (temp.next==head) {
                newNode.next=head;
                newNode.prev=temp;
                temp.next=newNode;
                head.prev=newNode;


            } else {
                throw new IndexOutOfBoundsException(index);
            }

        }
    }
    //Update a Node
    public void update(int index, int data) {
        if (head == null) {
            throw new IndexOutOfBoundsException(index);
        } else {
            DoublyCircularLinkedListNode temp = head;
            int currIndex = 0;
            while (temp.next != head && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }
            if ( currIndex == index) {
                temp.data = data;
            } else {
                throw new IndexOutOfBoundsException(index);
            }


        }
    }
    //Retrieving data from a Node
    public int getData(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException(index);
        } else {
            DoublyCircularLinkedListNode temp = head;
            int currIndex = 0;
            while (temp.next != head && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }
            if ( currIndex == index) {
                return temp.data;
            } else {
                throw new IndexOutOfBoundsException(index);
            }
        }
    }
    public void deleteByIndex(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            DoublyCircularLinkedListNode temp = head;
            DoublyCircularLinkedListNode delNode=head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next=head;
            head.prev=temp;
            delNode.next = null;
            delNode.prev=null;
        } else {
            DoublyCircularLinkedListNode temp = head;
            int currIndex = 0;
            while (temp.next != head && currIndex < index - 1) {
                temp = temp.next;
                currIndex++;
            }
            if (temp.next != head && currIndex == index - 1) {
                DoublyCircularLinkedListNode delNode = temp.next;
                temp.next = delNode.next;
                temp.next.prev=temp;
                delNode.next = null;
                delNode.prev=null;
            } else if (temp.next.next==head) {
                DoublyCircularLinkedListNode delNode = temp.next;
                temp.next=head;
                head.prev=temp;
                delNode.next=null;
                delNode.prev=null;

            } else {
                throw new IndexOutOfBoundsException(index);
            }
        }
    }
    public void delete(int data) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (head.data==data) {
            DoublyCircularLinkedListNode temp = head;
            DoublyCircularLinkedListNode delNode=head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next=head;
            head.prev=temp;
            delNode.next = null;
            delNode.prev=null;
        } else {
            DoublyCircularLinkedListNode temp = head;

            while (temp.next != head && temp.next.data!=data) {
                temp = temp.next;

            }
            if (temp.next != head && temp.next.data==data) {
                DoublyCircularLinkedListNode delNode = temp.next;
                temp.next = delNode.next;
                temp.next.prev=temp;
                delNode.next = null;
                delNode.prev=null;
            } else if (temp.next.data==data && temp.next.next == head ) {
                DoublyCircularLinkedListNode delNode = temp.next;
                temp.next=head;
                head.prev=temp;
                delNode.next=null;
                delNode.prev=null;

            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    @Override
    public String toString() {

        String output = "[";
        DoublyCircularLinkedListNode temp = head;
        do {
            if (temp.next != head) {
                output = output + temp.data;
                output = output + ", ";
                temp = temp.next;
            } else {
                output = output + temp.data;
                temp = temp.next;
            }
        } while (temp != head);

        output += "]";

        return output;
    }


}
class DCDriver{
    public static void main(String[] args) {
        DoublyCircularLinkedList circularDoublyLinkedList = new DoublyCircularLinkedList();
        circularDoublyLinkedList.insert(12);
        circularDoublyLinkedList.insert(23);
        circularDoublyLinkedList.insert(13);
        System.out.println(circularDoublyLinkedList.toString());
        circularDoublyLinkedList.insert(107, 3);
        //circularDoublyLinkedList.insert(79, 1);
       // circularDoublyLinkedList.insert(11, 0);
        System.out.println(circularDoublyLinkedList.toString());
        //circularDoublyLinkedList.deleteByIndex(0);
        //circularDoublyLinkedList.deleteByIndex(2);
        circularDoublyLinkedList.delete(12);
        circularDoublyLinkedList.delete(107);
        System.out.println(circularDoublyLinkedList.toString());
    }
}
