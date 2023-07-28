public class SinglyCircularLinkedListNode {
    int data;
    SinglyCircularLinkedListNode next;

    SinglyCircularLinkedListNode(int data){
        this.data=data;
        this.next=null;
    }
}
class SinglyCircularLinkedList{
    SinglyCircularLinkedListNode head;
    public void insert(int data){
        SinglyCircularLinkedListNode newNode=new SinglyCircularLinkedListNode(data);
        if(head==null){
            head=newNode;
            newNode.next=head;
        }
        else{
            SinglyCircularLinkedListNode temp=head;
            while (temp.next!=head){
                temp=temp.next;
            }
            newNode.next=head;
            temp.next=newNode;

        }
    }
    //Inserting a Node Anywhere
    public void insert(int data, int index) {
        SinglyCircularLinkedListNode newNode = new SinglyCircularLinkedListNode(data);

        if (index == 0) {
            if (head == null) {
                head = newNode;
                newNode.next=head;
            } else {
                SinglyCircularLinkedListNode temp=head;
                while (temp.next!=head){
                    temp=temp.next;
                }
                newNode.next=head;
                temp.next=newNode;
                head=newNode;
            }
        } else {
            int currindex = 0;
            SinglyCircularLinkedListNode temp = head;

            while (temp.next != head && currindex < index - 1) {
                temp = temp.next;
                currindex++;
            }
            if (temp.next != head && currindex == index - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else if (temp.next==head) {
                newNode.next=head;
                temp.next=newNode;

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
            SinglyCircularLinkedListNode temp = head;
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
            SinglyCircularLinkedListNode temp = head;
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
    //Delete a Node by Index
    public void deleteByIndex(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            SinglyCircularLinkedListNode temp = head;
            SinglyCircularLinkedListNode delNode=head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next=head;
            delNode.next = null;
        } else {
            SinglyCircularLinkedListNode temp = head;
            int currIndex = 0;
            while (temp.next != head && currIndex < index - 1) {
                temp = temp.next;
                currIndex++;
            }
            if (temp.next != head && currIndex == index - 1) {
                SinglyCircularLinkedListNode delNode = temp.next;
                temp.next = delNode.next;
                delNode.next = null;
            } else if (temp.next.next==head) {
                SinglyCircularLinkedListNode delNode = temp.next;
                temp.next=head;
                delNode.next=null;

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
            SinglyCircularLinkedListNode temp = head;
            SinglyCircularLinkedListNode delNode=head;
            while (temp.next != head) {
                temp = temp.next;
            }
            head = head.next;
            temp.next=head;
            delNode.next = null;
        } else {
            SinglyCircularLinkedListNode temp = head;

            while (temp.next != head && temp.next.data!=data) {
                temp = temp.next;

            }
            if (temp.next != head && temp.next.data==data) {
                SinglyCircularLinkedListNode delNode = temp.next;
                temp.next = delNode.next;
                delNode.next = null;
            } else if (temp.next.data==data && temp.next.next == head ) {
                SinglyCircularLinkedListNode delNode = temp.next;
                temp.next=head;
                delNode.next=null;

            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
    @Override
    public String toString() {

        String output = "[";
        SinglyCircularLinkedListNode temp = head;
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
class SCDriver{
    public static void main(String[] args) {
        SinglyCircularLinkedList circularLinkedList = new SinglyCircularLinkedList();
        circularLinkedList.insert(5);
        circularLinkedList.insert(23);
        circularLinkedList.insert(13);
        System.out.println(circularLinkedList.toString());

        circularLinkedList.insert(107, 0);
        circularLinkedList.insert(79, 1);
        circularLinkedList.insert(11, 5);
        circularLinkedList.deleteByIndex(0);
        //circularLinkedList.delete(107);
        circularLinkedList.update(0,9);
        System.out.println(circularLinkedList.getData(0));
        System.out.println(circularLinkedList.toString());
    }
}
