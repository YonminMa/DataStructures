package com.yonmin.stack;

import java.util.LinkedList;

public class SingleLinkedStackDemo {

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.list();
        try {
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stack.list();
    }

}

// 定义一个LinkedStack，表示栈
class LinkedStack {
    private StackNode head = new StackNode(0);

    public boolean isEmpty() {
        return head.next == null;
    }

    public void push(int id) {
        StackNode node = new StackNode(id);
        StackNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，不能退栈");
        } else {
            StackNode temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            System.out.println(temp + "出栈");
            return temp.id;
        }
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空，没有数据");
        } else {
            StackNode temp = head.next;
            int count = 0;
            while (temp.next != null) {
                System.out.printf("stack[%d]=%d\n", count, temp.id);
                temp = temp.next;
                count++;
            }
        }
    }
}

class StackNode {
    public int id;
    public StackNode next;

    public StackNode(int id) {
        this.id =id;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "id=" + id +
                '}';
    }
}