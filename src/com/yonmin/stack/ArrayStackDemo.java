package com.yonmin.stack;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.list();
        int pop = stack.pop();
        System.out.printf("%d出栈\n", pop);
        stack.list();
    }

}

// 定义一个ArrayStack，表示栈
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 用数组模拟栈
    private int top = -1; // 栈顶，初始化为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
        } else {
            top++;
            stack[top] = value;
        }
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw  new RuntimeException("栈空");
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }

    /**
     * 遍历栈
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.printf("stack[%d]=%d\n", i, stack[i]);
            }
        }
    }
}