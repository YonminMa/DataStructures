package com.yonmin.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归
            mergeSort(array, left, mid, temp);
            // 向右递归
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }


    /**
     *
     * @param array 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left; // 左边有序序列的初始索引
        int j = mid + 1; // 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        /*
         * 一、
         * 先把左右两边的有序序列按照规则填充到temp数组中
         * 直到左右两边的有序序列，有一边处理完为止
         */
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[t] = array[i];
                i++;
            } else {
                temp[t] = array[j];
                j++;
            }
            t++;
        }

        /*
         * 二、
         * 把剩余的数据填充到temp中
         */
        while (i <= mid) {// 左边剩余
            temp[t] = array[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = array[j];
            t++;
            j++;
        }

        /*
         * 三、
         * 将temp数组的元素拷贝到array
         * 注意，并不是每次都拷贝所有
         */
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }


}
