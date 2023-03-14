package com.george.accounts.model;

public class Random {
    public static  int numconst;
    public Random()
    {
        numconst=9;
    }
    protected static int generator()
    {
      return 2;
    }

}

class Random2 extends Random{
    public static  int numconst;
    public Random2()
    {
        numconst=9;
    }
     protected static int generator()
    {
        return 4;
    }

    public static void main(String[] args) {
        Random r = new Random2();
        System.out.println(Random2.generator());
    }

}
