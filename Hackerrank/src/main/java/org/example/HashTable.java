package org.example;

public class HashTable {

    public static final int size=7;
    public Node[] map;

          public void printTable () {
              for (int i = 0; i < map.length; i++) {
                  System.out.println(i + ":");
                  Node temp = map[i];
                  while (temp != null) {
                      System.out.println("   {" + temp.key + "= " + temp.value + "}");
                      temp = temp.next;
                  }
              }

    }

    public int hash (String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % map.length;
        }
        return hash;
    }

    public void set (String key, int value) {
              Node newnode = new Node(key,value);
              int index=hash(key);
              Node temp = map[index];
              if(temp==null)
                  map[index]=newnode;
              else
              {
                  while(temp.next!=null)
                  {
                      temp= temp.next;
                  }
                  temp.next=newnode;
              }




    }

    public int get (String key){
              int index = hash(key);
              Node node =map[index];
              while(node!=null)
              {
                  if(node.key==key)
                   return node.value;
                  node=node.next;
                }
              return 0;
    }


    class Node
    {
        String key;
        int value;
        Node next;

        public Node(String key, int value)
        {
            this.key=key;
            this.value=value;
        }


    }
    public HashTable()
    {
        map = new Node[size];
    }





}
