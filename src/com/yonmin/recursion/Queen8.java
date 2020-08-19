package com.yonmin.recursion;

public class Queen8 {

    // 定义一个max表示共有多少个皇后
    int max = 8;
    static int count = 0;
    static int judgeCount = 0;
    // 定义数组array，保存皇后放置位置的结果。例如：arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("共判断是否冲突%d次\n", judgeCount);
    }

    private void check(int n) {
        if (n == max) { // n = max，所有皇后都已经放好
            print();
        } else {
            // 依次放入皇后，并判断是否冲突
            for (int i = 0; i < max; i++) {
                // 把皇后n放到该行的第i列
                array[n] = i;
                if (judge(n)) { // 不冲突，递归
                    check(n+1);
                }
                // 否则循环将皇后放入下一列
            }
        }
    }

    /**
     * 判断是否和其它的皇后冲突
     * @param n 表示第几个皇后，也表示第一行
     * @return 如果冲突，返回false；否则返回true
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 1. array[i] == array[n] 判断是否在一列
            // 2. Math.abs(n - i) == Math.abs(array[n] - array[i]) 判断是否在同一斜线
            // 3. 不需要单独判断是否在同一行，行数由数组决定
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d", array[i]);
        }
        System.out.println();
    }
}
