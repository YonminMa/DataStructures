package com.yonmin.linkedlist;

import jdk.nashorn.internal.objects.annotations.Where;
import sun.awt.windows.ThemeReader;

public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addNode(5);
        circleSingleLinkedList.showNode();
        circleSingleLinkedList.countNode(1, 2, 5);
    }
}

// 创建一个环形单向链表
class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private ListNode first = new ListNode(-1);

    /**
     * 添加节点，构建成一个环形链表
     * @param nums
     */
    public void addNode(int nums) {
        // 数据校验
        if (nums < 1) {
            System.out.println("传入的值不正确");
        } else {
            ListNode curNode = null; // 辅助指针，帮助构建环形链表
            // 创建环形链表
            for (int i = 1; i <= nums ; i++) {
                // 根据编号创建节点
                ListNode node = new ListNode(i);
                // 如果是第一个节点，特殊情况
                if (i == 1) {
                    first = node;
                    first.next = first; // 形成环状链表
                } else {
                    curNode.next = node;
                    node.next = first;
                }
                curNode = node;
            }
        }
    }

    /**
     * 打印环形链表中的所有节点
     */
    public void showNode() {
        if (first == null) {
            // 空链表
            System.out.println("链表为空");
        } else {
            // first节点不能动，需要一个辅助节点
            ListNode node = first;
            while (node.next != first) {
                System.out.println(node);
                node = node.next;
            }
            System.out.println(node);
        }
    }

    /**
     * 根据用户的输入，输出节点的出圈顺序
     * @param startNo 表示从第几个节点数
     * @param countNum 表示每次数几下
     * @param nums 表示最初有多少节点
     */
    public void countNode(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        // 将first节点移动到起始位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
        }
        // 创建一个辅助指针，使其指向first节点的上一个节点
        ListNode helper = first;
        while (helper.next != first) {
            helper = helper.next;
        }
        // 当helper和first指向同一个节点的时候，链表中只有一个节点，循环结束
        while (helper != first) {
            // 让helper和first同时移动 countNum - 1 次
            for (int i = 0; i < countNum - 1; i++) {
                helper = helper.next;
                first = first.next;
            }
            // 这时first指向的节点就是要出圈的节点
            System.out.printf("节点%d出圈\n", first.id);
            // 删除first指向的节点
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后留在圈中的节点编号为%d\n", first.id);
     }
}

// 创建节点类
class ListNode {
    public int id; // 编号
    public ListNode next; // 指向下一个节点，默认为null
    public ListNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "id=" + id +
                '}';
    }
}