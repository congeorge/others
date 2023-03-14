package org.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Pair
{
    public Pair (Character character) {
        this.character = character;
        this.count=1;
    }

    public Character getCharacter () {
        return character;
    }

    public void setCharacter (Character character) {
        this.character = character;
    }

    public int getCount () {
        return count;
    }

    public void setCount (int count) {
        this.count = count;
    }

    Character character;
    int count;
}

class Result2 {



    public static boolean issorted(int[] a, int n){
        if (n==0 || n==1)
            return true;
        if(a[0] > a[1])
            return false;
        else
        {
            return issorted(  Arrays.copyOfRange(a,1,n),n-1);
        }
    }
    public static int sum(int[] a, int n){
        if (n==0)
            return 0;
        if (n==1)
            return a[0];
        int sum = a[0]+sum(Arrays.copyOfRange(a,1,n),n-1);
        return sum;

    }

    public static boolean ispresent(int[] a, int n){
        int length = a.length;
         if(length==1)
             return (a[0]==n);
         if(a[0]==n)
         return true;
         else
         return  ispresent(Arrays.copyOfRange(a,1,length),n);


    }


    public static int firstindex(int[] a, int n){
        int length = a.length;
        if(length==1)
        {
            if(a[0] == n);
            return 1;
        }
        if(a[0] == n)
            return 1;
        else
            return 1+ firstindex(Arrays.copyOfRange(a,1,length),n);


    }


    public static int lastindex(int[] a, int n){
        int length = a.length;
        if(length==1)
        {
            if(a[0] == n)
            return 1;
            else
                return 0;
        }
        if(a[length-1] == n)
            return length;
        else
            return  lastindex(Arrays.copyOfRange(a,0,length-1),n);


    }

    public static void printallposition(int[] a, int n,int index){
        int length = a.length;
        if(length==1)
        {
            if(a[0]==n) {
                System.out.println("Position: " + index);
                return;
            }
        }

        if(a[0]==n)
            System.out.println("Position: " + index);
       printallposition(Arrays.copyOfRange(a,1,length),n,index+1);


    }


    public static int countallposition(int[] a, int n,int count){
        int length = a.length;
        if(length==1)
        {
            if(a[0]==n) {
                return ++count;
            }
            else
                return count;
        }

        if(a[0]==n)
            count++;
        return countallposition(Arrays.copyOfRange(a,1,length),n,count);


    }

    public static void print(int[] a){
        int length = a.length;
        if(length==1) {
            System.out.print(a[0]);
            return;
        }
        System.out.print(a[0]);
        print(Arrays.copyOfRange(a,1,length));
         return;
    }

    public static void printReverse2(int[] a){
        int length = a.length;
        if(length==1) {
            System.out.print(a[0]);
            return;
        }
        System.out.print(a[length-1]);
        printReverse2(Arrays.copyOfRange(a,0,length-1));
        return;
    }

    public static int findLength(int[] a, int index){

        if(Integer.valueOf(a[index])==null)
            return 0;
        else if (Integer.valueOf(a[index])!=null)
            ++index;
        return findLength(a,index)+1;


    }
    public static void replace(char[] a, char from , char to,int index){
        if(index==a.length-1)
            return;

        if(a[index]==from)
        {
            a[index]=to;
        }

        replace(a,from, to,++index);

   }

    public static void remove(char[] a, char from ,char[] b, int index){
        if(index==a.length-1)
        {
            if(a[index]!=from)
            {
                b[index]=a[index];
            }
            return;
        }


        if(a[index]!=from)
        {
            b[index]=a[index];
        }
        ++index;

        remove(a,from,b,index);

    }




}

public class Solution {
    public static void main(String[] args) throws IOException {
        char[] a= new char[]{'a','b','a','c','d','a','b'};
//        Result2.replace(a,'a','x',0);
//        System.out.println(a);


        char [] b= new char[7];
        Result2.remove(a,'a',b,0);
        System.out.println(b);
   //  Result2.printallposition(new int[]{1,2,3,6,3,4,3,3,3,3,3},3,0);
 //       System.out.println(  Result2.countallposition(new int[]{1,2,3,6,3,4,3,3,3,3,3,6},6,0));
  //      Result2.findExcelValue("abcd",3);
    /*  System.out.println(Result2.findExcelValue("Malayalam"));
        System.out.println(Result2.findExcelValue("BufferedReader(new InputStreamReader(System.in)"));*/
    }

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int blacklisted_ipsCount = Integer.parseInt(bufferedReader.readLine().trim());


        List<String> blacklisted_ips = IntStream.range(0, blacklisted_ipsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int requestsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> requests = IntStream.range(0, requestsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result.validateRequests(blacklisted_ips, requests);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }*/
}
