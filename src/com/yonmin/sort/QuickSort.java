package com.yonmin.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {5,4,3,2,1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int index = partition(array, start, end);
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    public static int partition(int[] array, int start, int end) { // 分区操作
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left <= end && array[left] <= pivot) {
                left++;
            }
            while (right >= start && array[right] > pivot) {
                right--;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, start, right);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
