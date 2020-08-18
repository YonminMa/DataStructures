package com.yonmin.stack;

import java.util.Stack;

public class Calculator {

    public static void main(String[] args) {
        String expression = "112-1*12";
        // 创建两个栈，数栈和符号栈
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        // 定义相关变量
        int num1 = 0;
        int num2 = 0;
        char oper;
        int res = 0;
        char ch = ' '; // 每次扫描的结果
        //while循环扫描表达式
        for (int index = 0; index <= expression.length() - 1; index++) {
            // 依次扫描字符串中的每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断是什么
            if (CalculatorUtils.isOper(ch)) { // 是符号
                // 判断当前符号栈是否为空
                if (!operStack.isEmpty()) { // 非空
                    // 如果当前符号优先级小于或等于栈顶符号的优先级，则取出数栈顶的两个数和符号栈栈顶符号
                    // 计算后存入数栈栈顶，再将当前符号存入符号栈栈顶；
                    // 否则直接将当前符号存入符号栈栈顶。
                    if (CalculatorUtils.priority(ch) <= CalculatorUtils.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = CalculatorUtils.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else { // 空，直接入栈
                    operStack.push(ch);
                }
            } else { //数字
                index = index+1;
                String keepNum = "";
                keepNum += ch;
                while (index <= expression.length() - 1){ // 未到达最后
                    char curVal = expression.substring(index, index+1).charAt(0);
                    if (CalculatorUtils.isOper(curVal)) { // 是运算符，停止
                        break;
                    } else {
                        keepNum += curVal;
                    }
                    index++;
                }
                index = index - 1;
                numStack.push(Integer.parseInt(keepNum));
            }
        }
        // 当表达式扫描完毕，就顺序从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            if (operStack.isEmpty()) {
                break;
            } else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = CalculatorUtils.cal(num1, num2, oper);
                numStack.push(res);
            }
        }
        System.out.printf("%s = %d", expression, numStack.pop());
    }

}

class CalculatorUtils{

    /**
     * 返回符号的优先级
     * @param op 传入的符号
     * @return 数字，数字越大代表优先级越高
     */
    public static int priority(char op) {
        if (op == '*' || op == '/') {
            return 1;
        } else if (op == '+' || op == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否为符号
     * @param val 传入字符
     * @return 返回是否为符号
     */
    public static boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param op
     * @return
     */
    public static int cal(int num1, int num2, char op) {
        int res = 0;
        switch (op){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
