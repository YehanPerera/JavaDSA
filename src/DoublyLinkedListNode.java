public class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode (int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }

}
class DoublyLinkedList{
    DoublyLinkedListNode head;
    public void insert(int data){
        DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
        if(head==null){
            head=newNode;
        }
        else{
            DoublyLinkedListNode temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;

        }
    }
    public void insert(int data, int index){
        DoublyLinkedListNode newNode=new DoublyLinkedListNode(data);
        if(index==0){
            if(head==null){
                head=newNode;
            }
            else{
                newNode.next=head;
                head=newNode;
                newNode.next.prev=newNode;
            }
        }
        else {
            DoublyLinkedListNode temp=head;
            int currIndex=0;
            while (temp!=null && currIndex<index-1){
                temp=temp.next;
                currIndex++;
            }
            if(temp!=null && currIndex==index-1){
                newNode.next=temp.next;
                newNode.prev=temp;
                temp.next.prev=newNode;
                temp.next=newNode;
            }
            else{
                throw new IndexOutOfBoundsException(index);
            }
        }

    }
    public int getData(int index){
        if(head==null){
            throw new IndexOutOfBoundsException(index);
        }
        else {
            DoublyLinkedListNode temp=head;
            int currIndex=0;
            while (temp!=null && currIndex<index){
                temp=temp.next;
                currIndex++;

            }
            if (currIndex==index && temp!=null){
                return temp.data;
            }
            else {
                throw new IndexOutOfBoundsException(index);
            }
        }
    }
    public void update(int data ,int index){
        if(head==null){
            throw new IndexOutOfBoundsException(index);
        }
        else {
            DoublyLinkedListNode temp=head;
            int currIndex=0;
            while (temp!=null && currIndex<index){
                temp=temp.next;
                currIndex++;

            }
            if (currIndex==index && temp!=null){
                temp.data=data;
            }
            else {
                throw new IndexOutOfBoundsException(index);
            }
        }
    }
    public void deleteByIndex(int index){
        if(head==null){
            throw new IndexOutOfBoundsException(index);
        }
        else {
            if(index==0){
                DoublyLinkedListNode temp=head;
                head=temp.next;
                temp.next=null;
                head.prev=null;
            }
            else {
                DoublyLinkedListNode temp=head;
                int currIndex=0;
                while (temp.next!=null && currIndex<index-1){
                    temp=temp.next;
                    currIndex++;
                }
                if (currIndex==index-1 && temp.next!=null){
                    DoublyLinkedListNode delNode=temp.next;
                    if (delNode.next == null) {
                        temp.next = null;
                        delNode.prev = null;
                    } else {
                        temp.next=delNode.next;
                        temp.next.prev=temp;//temp.next.prev=temp;
                        delNode.next=null;
                        delNode.prev=null;
                    }
                }
                else {
                    throw new IndexOutOfBoundsException(index);
                }


            }
        }
    }

public void deleteByValue(int value) {
    if (head == null) {
        throw new IndexOutOfBoundsException();
    } else {
        if (head.data == value) {
            DoublyLinkedListNode temp = head;
            head = temp.next;
            temp.next = null;
            head.prev = null;
            //deleteByIndex(0);
        } else {
            DoublyLinkedListNode temp = head;


            while (temp.next != null && temp.next.data != value) {
                temp = temp.next;
            }

            if (temp.next != null && temp.next.data == value) {
                DoublyLinkedListNode delNode = temp.next;
                if (delNode.next == null) {
                    temp.next = null;
                    delNode.prev = null;
                } else {
                    temp.next=delNode.next;
                    temp.next.prev=temp;//temp.next.prev=temp;
                    delNode.next=null;
                    delNode.prev=null;
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}





    public String toString() {
        String output = "[";
        if (head == null) {
            return output;
        } else {
            DoublyLinkedListNode temp = head;
            while (temp != null) {
                output = output + String.valueOf(temp.data);
                if (temp.next != null) {
                    output = output + ",";
                }
                temp = temp.next;
            }
            output = output + "]";
            return output;
        }
    }

}
class DLLDriver{
    public static void main(String[] args) {
        DoublyLinkedList DoublyLinkedList= new DoublyLinkedList();
        DoublyLinkedList.insert(5);
        DoublyLinkedList.insert(15);
        DoublyLinkedList.insert(25);
        DoublyLinkedList.insert(35);
        System.out.println(DoublyLinkedList.toString());
        DoublyLinkedList.insert(45);
        System.out.println(DoublyLinkedList.toString());
        DoublyLinkedList.update(20,2);
        System.out.println(DoublyLinkedList.toString());
        System.out.println(DoublyLinkedList);
        DoublyLinkedList.deleteByValue(45);
        System.out.println(DoublyLinkedList);
        DoublyLinkedList.deleteByIndex(3);
        System.out.println(DoublyLinkedList);
        System.out.println(DoublyLinkedList.getData(1));

    }
}

