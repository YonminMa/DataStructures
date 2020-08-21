package com.yonmin.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        insertSort(array);
    }

    /**
     * 插入排序，时间复杂度为 O(n^2)
     * @param array 需要排序的数组
     */
    public static void insertSort(int[] array) {
        int insertVal; // 待插入的数
        int insertIndex; // 应该插入的位置
        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex]; // 将在插入点之后的数后移
                insertIndex--;
            }
            array[insertIndex + 1] = insertVal;
            System.out.printf("第%d轮交换后的数组", i);
            System.out.println(Arrays.toString(array));
        }
        System.out.print("排序后的数组");
        System.out.println(Arrays.toString(array));
    }
}
