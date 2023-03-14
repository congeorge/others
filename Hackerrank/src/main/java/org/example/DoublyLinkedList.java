package org.example;

public class DoublyLinkedList {

    public Node removeLast () {
        if(length==0)
        return null;
        if(length==1)
        {
            Node temp = head;
            head=null;
            tail=null;
            return temp;
        }

        Node temp = tail;
        Node newlast = tail.prev;
        temp.next=null;
        temp.prev=null;
        newlast.next=null;
        tail = newlast;
        length--;
        return temp;

    }

    public void prepend (int i) {
        Node newNode = new Node(i);
        if(length==0)
        {
            head=newNode;
            tail=newNode;

        }
        else
        {
            Node currentHead = head;
            currentHead.prev=newNode;
            newNode.next=currentHead;
            head=newNode;

        }

        length++;

    }

    public Node removeFirst () {
        Node chead=null;
        if(length==0)
            return chead;
        if(length==1) {
            chead=head;
            head=null;
            tail=null;
            return chead;
        }
        else
        {
            chead = head;
            Node nhead = head.next;
            nhead.prev=null;
            chead.next=null;
            head=nhead;


        }

        length--;
        return chead;
    }

    public void set (int i, int i1) {
        Node temp = head;
        if( i< 0 || i>=length)
        {
            System.out.println("Node doesnt exisit");
        }
        for (int j = 0; j < i; j++) {
            temp=temp.next;

        }
        temp.value=i1;

    }

    public void insert (int i, int i1) {
        if(i==0)
        {
          prepend(i1);
        }
       else  if(i==length)
        {
            append(i1);
        }
        else {
            Node newnode = new Node(i1);
            Node cnode=get(i) ;
            Node prenode=get(i-1);
            prenode.next=newnode;
            newnode.prev=prenode;
            newnode.next=cnode;
            cnode.prev=newnode;
            length++;


        }
        }

    class Node
    {
        int value;
        Node prev;
        Node next;
        public Node(int value)
        {
            this.value=value;
        }

    }
    Node head;
    Node tail;
    int length;

    public void getLength () {
        System.out.println("Length: " + length);
    }

    public void getTail () {
        if(length==0)
        System.out.println("Tail: null");
        else
            System.out.println("Tail: " + tail.value);
    }

    public void getHead () {
        if(length==0)
            System.out.println("Head: null");
        else
            System.out.println("Head: " + head.value);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public Node get(int index)
    {

         if( index <0 || index >=length)
        {
            return null;
        }
        else
        {
            int n = index;
            Node node=head;
            for (int i = 0; i <n ; i++) {
                node=node.next;
            }
            return node;
        }

    }


    public DoublyLinkedList(int value)
    {
        Node node= new Node(value);
        head=node;
        tail=node;
        length=1;

    }


    public void append(int value)
    {
        Node newNode = new Node(value);
        if(length==0) {
            head = newNode;
            tail = newNode;
        }
        else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

        }
        length++;

    }


}
