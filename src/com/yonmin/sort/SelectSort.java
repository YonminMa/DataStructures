package com.yonmin.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        selectSort(array);
    }

    /**
     * 冒泡排序，时间复杂度为 O(n^2)
     * @param array 需要排序的数组
     */
    public static void selectSort(int[] array) {
        // 第i轮
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // 每一轮最小值的位置
            int min = array[i]; // 假设当前值是最小值
            for (int j = i+1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j]; // 重置最小值
                    minIndex = j; // 重置最小值的位置
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
            System.out.printf("第%d轮交换后的数组", i+1);
            System.out.println(Arrays.toString(array));
        }
        System.out.print("排序后的数组");
        System.out.println(Arrays.toString(array));
    }
}
