package org.example;

public class Stack
{
    public void getTop () {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
       }

    public void getHeight () {
        System.out.println("Height: " + height);
    }

    public void printStack () {
        Node temp=top;
        while(temp!=null)
        {
            System.out.println(temp.value);
            temp=temp.next;

        }

    }

    public Node pop () {
        Node temp;
        if(height==0)
           return null;
        else if(height==1)
        {
            temp = top;
            top=null;

        }
       else {

            temp = top;
            Node newtop = top.next;
            temp.next=null;
            top=newtop;


       }
       height--;
       return temp;


    }

    class Node{

        int value;
        Node next;
        public Node(int v)
        {
            this.value=v;
          }
    }
    Node top;
    int height;
     public Stack(int v)
    {
        Node newnode = new Node(v);
        top=newnode;
        height=1;
    }

    public void push(int v)
    {
        Node newNode=  new Node(v);
        if(height==0)
        {   top=newNode;     }
        else
        {

            newNode.next=top;
            top=newNode;
           }

        height++;
    }
}


