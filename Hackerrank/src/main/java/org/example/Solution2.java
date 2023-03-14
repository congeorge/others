package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution2 {

    static String revereString(String input)
    {
        char[] a = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
        }

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty())
        {
            result.append((stack.pop()));
        }

        return new String(result);



    }

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine().trim();

        String[] inputs=input.split(" ");
        List<String> operators = Arrays.asList("+","/","-");
        char[] items = input.toCharArray();
        Stack<Character> stack= new Stack<>();
        for(char a : items)
        {
            stack.push(a);
        }
        int a , b, result ;
        while(!stack.empty())
        {
            a=stack.pop();
            b=stack.pop();



        }



    }


        //((4+(13/5));



}
