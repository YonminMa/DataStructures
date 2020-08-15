package com.yonmin.sparsearray;

import java.util.Arrays;

/**
 * 稀疏数值
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组11*11
        int row_num = 11;
        int column_num = 11;
        int[][] originArray = new int[row_num][column_num];
        originArray[1][2] = 1;
        originArray[2][3] = 2;
        // 输出原始二维数组
        System.out.println("原始数值为：");
        for (int[] row : originArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转换为稀疏数组
        // 1. 先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                if (originArray[i][j] != 0) {
                    sum ++;
                }
            }
        }
        // 2. 创建对应的稀疏数值
        int[][] sparseArray = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = row_num;
        sparseArray[0][1] = column_num;
        sparseArray[0][2] = sum;

        // 遍历二维数组，将非0的数据存放到稀疏数组中
        int count = 0;
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < column_num; j++) {
                if (originArray[i][j] != 0) {
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originArray[i][j];
                }
            }
        }

        System.out.println("稀疏数值为：");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",  sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        // 3. 将稀疏数值转换为原始数值
        int[][] convertArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            convertArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 输出转换后的二维数组
        System.out.println("转换后的二维数组为：");
        for (int[] row : convertArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
