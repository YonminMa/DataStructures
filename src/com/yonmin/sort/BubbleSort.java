package com.yonmin.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5,1,2,3,5,6,62,3};
        bubbleSort(array);

    }

    /**
     * 冒泡排序，时间复杂度为 O(n^2)
     * @param array 需要排序的数组
     */
    public static void bubbleSort(int[] array) {
        int temp = 0;
        // 第i轮
        for (int i = 1; i < array.length; i++) {
            boolean flag = false; // 标识变量，表示是否进行过交换
            // 第i轮不需要到已经是最大值的位置
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.printf("第%d轮交换后的数组", i);
            System.out.println(Arrays.toString(array));
            // 如果在某一轮中没有交换过位置，说明已经排序完成，则提前结束
            if (!flag) { // 说明在一轮排序中，一次交换都没有发生过
                break;
            }
        }
        System.out.print("排序后的数组");
        System.out.println(Arrays.toString(array));
    }
}
