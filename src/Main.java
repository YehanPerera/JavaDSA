class LinkedListNode{
    int data;
    LinkedListNode next;

    LinkedListNode(int data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList {
    LinkedListNode head;

    public String toString() {
        String output = "[";
        if (head == null) {
            return output;
        } else {
            LinkedListNode temp = head;
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


    //Inserting a Node Anywhere
    public void insert(int data, int index) {
        LinkedListNode newNode = new LinkedListNode(data);

        if (index == 0) {
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        } else {
            int currindex = 0;
            LinkedListNode temp = head;

            while (temp != null && currindex < index - 1) {
                temp = temp.next;
                currindex++;
            }
            if (temp != null && currindex == index - 1) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                throw new IndexOutOfBoundsException(index);
            }

        }
    }

    //Inserting a Node at the End
    public void insert(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    //Retrieving data from a Node
    public int getData(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException(index);
        } else {
            LinkedListNode temp = head;
            int currIndex = 0;
            while (temp != null && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }
            if (temp != null && currIndex == index) {
                return temp.data;
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
            LinkedListNode temp = head;
            int currIndex = 0;
            while (temp != null && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }
            if (temp != null && currIndex == index) {
                temp.data = data;
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
            LinkedListNode temp = head;
            head = head.next;
            temp.next = null;
        } else {
            LinkedListNode temp = head;
            int currIndex = 0;
            while (temp != null && currIndex < index - 1) {
                temp = temp.next;
                currIndex++;
            }
            if (temp != null && currIndex == index - 1) {
                LinkedListNode delNode = temp.next;
                temp.next = delNode.next;
                delNode.next = null;
            } else {
                throw new IndexOutOfBoundsException(index);
            }
        }
    }

    //Delete a Node by Data
    public void delete(int data) {
        if (head != null) {
            if (head.data == data) {
                LinkedListNode temp = head;
                head = head.next;
                temp.next = null;
            } else {
                LinkedListNode temp = head;
                int currIndex = 0;
                while (temp != null && temp.next.data != data) {
                    temp = temp.next;
                    currIndex++;
                }
                if (temp != null && temp.next.data == data) {
                    LinkedListNode delNode = temp.next;
                    temp.next = delNode.next;
                    delNode.next = null;
                }
            }
        }
    }
}
class Driver{
    public static void main(String[] args) {
        LinkedList linkedList= new LinkedList();
        linkedList.insert(5);
        linkedList.insert(15);
        linkedList.insert(25);
        linkedList.insert(35);
        System.out.println(linkedList.toString());
        linkedList.insert(45);
        System.out.println(linkedList.toString());
        linkedList.update(2,20);
        System.out.println(linkedList.toString());
        System.out.println(linkedList);
        linkedList.delete(45);
        System.out.println(linkedList);
        linkedList.deleteByIndex(3);
        System.out.println(linkedList);
        linkedList.getData(1);
        System.out.println(linkedList.getData(1));

    }
}







