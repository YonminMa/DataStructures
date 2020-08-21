package com.yonmin.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] array1 = {5,4,3,2,1};
        shellSort1(array1);
        int[] array2 = {5,4,3,2,1};
        shellSort2(array2);
    }

    /**
     * 希尔排序，交换法。速度较插入排序更慢
     * @param array 需要排序的数组
     */
    public static void shellSort1(int[] array) {
        int count = 0;
        int temp;
        for (int gap = array.length; gap > 0; gap /= 2) { // 一共分为gap组
            for (int i = gap; i < array.length; i++) {
                // 遍历各组中所有的元素（共gap组），步长为gap
                for (int j = i - gap; j >= 0; j-=gap) {
                    // 如果当前元素大于加上步长后的那个元素，则交换
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            System.out.printf("第%d轮交换后的数组", ++count);
            System.out.println(Arrays.toString(array));
        }
        System.out.print("排序后的数组");
        System.out.println(Arrays.toString(array));
    }


    /**
     * 希尔排序，移动法，速度较插入排序有大幅度提升
     * @param array 需要排序的数组
     */
    public static void shellSort2(int[] array) {
        int count = 0;
        int insertIndex;
        int insertVal;
        // 增量gap，并逐步的缩小增量
        for (int gap = array.length; gap > 0; gap/=2) {
            // 对每一组进行插入排序
            for (int i = gap; i < array.length; i++) {
                insertIndex = i;
                insertVal = array[insertIndex];
                if (array[insertIndex] < array[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertVal < array[insertIndex - gap]) {
                        // 移动
                        array[insertIndex] = array[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    // 当退出循环后就找到了插入的位置
                    array[insertIndex] = insertVal;
                }
            }
            System.out.printf("第%d轮交换后的数组", ++count);
            System.out.println(Arrays.toString(array));
        }
        System.out.print("排序后的数组");
        System.out.println(Arrays.toString(array));
    }
}
