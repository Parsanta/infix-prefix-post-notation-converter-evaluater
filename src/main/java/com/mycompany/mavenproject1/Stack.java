/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Armaan
 */
public class Stack {
    int top;
    char[] char_arr;
    int[] int_arr;
    String[] str_arr;
    int size;

    public Stack(int size) {
        this.size = size;
        top = -1;
        char_arr = new char[size];
    }

    public Stack(int size, int type) {
        this.size = size;
        top = -1;
        int_arr = new int[size];
    }
    public Stack(int size, Boolean type) {
        this.size = size;
        top = -1;
        str_arr = new String[size];
    }

    public void Push(char val) {
        if (top == size - 1) {
           return;
        } else {
            char_arr[++top] = val;
        }
    }
    public void Push(String val) {
        if (top == size - 1) {
            return;
        } else {
            str_arr[++top] = val;
        }
    }

    public void Push(int val) {
        if (top == size - 1) {
            return;
        } else {
            int_arr[++top] = val;
        }
    }

    public char Pop() {
        if (top == -1) {
            return '$';
        } else {
            return char_arr[top--];
        }
    }

    public int Pop(boolean a) {
        if (top == -1) {
            return -1;
        } else {
            return int_arr[top--];
        }
    }
    public String Pop(int a) {
        if (top == -1) {
            return "$";
        } else {
            return str_arr[top--];
        }
    }

    public char Peek() {
        if (top == -1) {
            return '$';
        } else {
            return char_arr[top];
        }
    }

    public int Peek(boolean a) {
        if (top == -1) {
            return -1;
        } else {
            return int_arr[top];
        }
    }
    public String Peek(int a) {
        if (top == -1) {
            return "$";
        } else {
            return str_arr[top];
        }
    }
}
