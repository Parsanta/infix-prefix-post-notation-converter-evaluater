/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Armaan
 */
public class Functions {
    public static int prec_check(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '^') {
            return 3;
        }
        return -1;
    }
    public static boolean isOperator(char a) {

        if(a == '*' || a == '^'|| a == '+'|| a == '-'|| a == '/'){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isNumber(char a){
        if(a >= '0' && a <= '9'){
            return true;
        }
        else{
            return false;
        }
    }
    public static int operators(char a, int op1, int op2) {
        if (a == '*') {
            return op1 * op2;
        } else if (a == '+') {
            return op1 + op2;
        } else if (a == '/') {
            return op2 / op1;
        } else if (a == '-') {
            return op2 - op1;
        } else {
            return (int) Math.pow(op2, op1);
        }
    }

    public static String infix_to_postfix(String infix) {
        String postfix = "";
        char[] arr = infix.toCharArray();
        Stack s = new Stack(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (isNumber(arr[i])) {
                postfix += arr[i];
            } else if (arr[i] == '(') {
                s.Push(arr[i]);
            } else if (arr[i] == ')') {
                while (s.Peek() != '(') {
                    postfix += s.Pop();
                }
                s.Pop();
            } else {
                while (s.Peek() != '$' && prec_check(arr[i]) <= prec_check(s.Peek())) {
                    postfix += s.Pop();
                }
                s.Push(arr[i]);
            }
        }
        while (s.Peek() != '$') {
            postfix += s.Pop();
        }
        return postfix;

    }

    public static String infix_to_prefix(String infix) {

        return postfix_to_prefix(infix_to_postfix(infix)); 
    }

    public static int infix_to_evaluate(String infix) {
        return postfix_to_evaluate(infix_to_postfix(infix));
    }

    public static int postfix_to_evaluate(String postfix) {
        char[] arr = postfix.toCharArray();
        Stack ss = new Stack(arr.length, 1);
        for (int i = 0; i < arr.length; i++) {
            if (isNumber(arr[i])) {
                ss.Push(Character.getNumericValue(arr[i]));
            } else {
                int a = ss.Pop(true);
                int b = ss.Pop(true);
                ss.Push(operators(arr[i], a, b));
            }
        }
        return ss.Pop(true);
    }
    
    public static String postfix_to_prefix(String postfix){
        char[] arr = postfix.toCharArray();
        Stack s1 = new Stack(arr.length,true);
        for (int i = 0; i < arr.length; i++) {
            if (isNumber(arr[i])) {
                s1.Push(String.valueOf(arr[i]));
                // System.out.println(s1.Peek()); 
            }
            else if (isOperator(arr[i])) {
                String op1 = s1.Pop(0);
                String op2 = s1.Pop(0);
                String temp = arr[i]+op2+op1;
                s1.Push(temp);
            }
        }
        
        return s1.Pop(0);
    }

    public static String prefix_to_postfix(String prefix) {
        char[] arr = prefix.toCharArray();
        Stack s1 = new Stack(arr.length,true);
        for (int i = arr.length-1; i >= 0; i--) {
            if (isOperator(arr[i])) {
                String op1 = s1.Pop(0);
                String op2 = s1.Pop(0);

                String temp = op1 + op2 + arr[i];
                s1.Push(temp);
            }
            else{
                s1.Push(String.valueOf(arr[i]));
            }
        }
        return s1.Pop(0);
    }
    
    public static String postfix_to_infix(String infix) {
        char [] arr = infix.toCharArray();
        Stack s1 = new Stack(arr.length,true);
        for (int i = 0; i < arr.length; i++) {
            if(isNumber(arr[i])){
                s1.Push(String.valueOf(arr[i]));
            }
            else{
                String op1 = s1.Pop(0);
                String op2 = s1.Pop(0);
                s1.Push("("+op2+arr[i]+op1+")");

            }
        }
        return s1.Pop(0);
    }

    public static String prefix_to_infix(String prefix) {
        return postfix_to_infix(prefix_to_postfix(prefix));
    }

    public static int prefix_to_evaluate(String prefix) {
        return postfix_to_evaluate(prefix_to_postfix(prefix));
    }
}
