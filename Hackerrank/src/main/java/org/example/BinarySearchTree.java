package org.example;

public class BinarySearchTree {

    public boolean contains (int i) {
        if(root==null)
            return false;
        Node temp = root;
        while(temp!=null)
        {
            if(i < temp.value)
            {
                temp =temp.left;
            }
            else if (i > temp.value)
            {
                temp =temp.right;
            }
            else return true;
       }
        return false;


    }

    class Node
    {
        int value;
        Node left;
        Node right;
        public Node(int v)
        {
            this.value=v;
        }

    }
    public Node root;

    public BinarySearchTree () {
        root=null;
    }


    public boolean insert (int i) {
        Node newNode = new Node(i);
        if(root==null)
        {
            root=newNode;
            return true;

        }
        else
        {
               Node temp = root;
               while(true) {
                    if (temp.value == newNode.value)
                        return false;
                    if (newNode.value < temp.value)
                    {
                        if(temp.left == null)
                        {
                            temp.left = newNode;
                            return true;
                        }
                        else
                            temp = temp.left;
                    }
                    else
                    {
                        if(temp.right == null)
                        {
                            temp.right = newNode;
                            return true;
                        }
                        else
                            temp = temp.right;
                    }


                }



        }
    }

}
