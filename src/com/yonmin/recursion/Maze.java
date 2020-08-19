package com.yonmin.recursion;

public class Maze {

    public static void main(String[] args) {
        // 创建一个二维数组，模拟迷宫。
        int[][] map = new int[8][7];
        // 1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][0] = 1;

        System.out.println("迷宫地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println("路径");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归返回迷宫路径。1为墙；2为通路；3为已经走过但是走不通
     * @param map 地图
     * @param i 起点横坐标
     * @param j 起点纵坐标
     * @return 如果找到通路，返回true；否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 说明通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { // 当前点还没走过
                // 按照策略【下->右->上->左】走
                map[i][j] = 2; // 假设可以走通
                if (setWay(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else { // map[i][j] != 0，可能为1，2，3
                return false;
            }
        }
    }
}
