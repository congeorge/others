package org.example;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public void prepend (int i) {
        if (length == 0) {
            this.append(i);
        } else {
            Node startnode = new Node(1);
            startnode.next = head;
            head = startnode;
            length++;
        }
    }

    public void reverse () {

        Node temp = head;
        head=tail;
        tail = temp;
        Node before =null;
        Node after = temp.next;
        for (int i = 0; i < length; i++) {
            after =temp.next;
            temp.next=before;
            before=temp;
            temp=after;

        }



    }

    private class Node {
        int value;
        Node next;

        Node (int value) {
            this.value = value;
        }
    }

    public LinkedList (int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList () {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead () {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail () {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength () {
        System.out.println("Length: " + length);
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast () {
        Node returnValue = null;
        if (length == 0) {
            return returnValue;
        } else {
            Node temp = head;
            returnValue = tail;
            while (temp.next != null && temp.next != tail) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            length--;
            if (length == 0) {
                head = null;
                tail = null;
            }
        }
        return returnValue;
    }

    public Node removeFirst () {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;

    }

}


