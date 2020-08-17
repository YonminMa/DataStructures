package com.yonmin.linkedlist;

/**
 * 定义一个单向链表，保存水浒传英雄的编号、姓名和绰号
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 创建节点
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode newhero3 = new DoubleHeroNode(3, "YonminMa", "智多星");

        // 创建链表
        DoubleLinkedList linkedList = new DoubleLinkedList();

        // 将节点加入链表中
//        linkedList.add(hero1);
//        linkedList.add(hero2);
//        linkedList.add(hero3);

        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);
        linkedList.update(newhero3);
        linkedList.delete(2);

        // 显示链表
        linkedList.list();
    }
}

// 定义SingleLinkedList管理英雄
class DoubleLinkedList {
    // 初始化头节点，头节点位置不变，不存放具体数据
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    public DoubleHeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    public void add(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = head;

        // 遍历链表，找到链表最后
        while (true) {
            // 找到最后，退出循环
            if (temp.next == null) {
                break;
            } else {
                // 如果没有找到最后，将temp后移
                temp = temp.next;
            }
        }
        // 退出while循环时，temp就指向了最后的节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 按照num的顺序添加
     * @param heroNode
     */
    public void addByOrder(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.num > heroNode.num) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                heroNode.pre = heroNode.next.pre;
                heroNode.next.pre = heroNode;
                return;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改节点，根据新传入的节点的num修改
    public void update(DoubleHeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        } else {
            // 遍历
            DoubleHeroNode temp = head.next;
            while (true) {
                if (temp == null) {
                    System.out.println("没有找到要修改的节点");
                    break;
                } else if (temp.num == newHeroNode.num) {
                    temp.realName = newHeroNode.realName;
                    temp.nickName = newHeroNode.nickName;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * 删除节点
     * @param number 要删除节点的num值
     */
    public void delete(int number) {
        // 遍历
        DoubleHeroNode temp = head;
        while (true) {
            if (temp == null) {
                System.out.println("没有找到要删除的节点");
                break;
            } else if (temp.num == number) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }

    // 显示链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        } else {
            DoubleHeroNode temp = head.next;
            while (true) {
                // 判断是否到达最后
                if (temp == null) {
                    // 到达最后退出循环
                    break;
                } else {
                    // 否则输出节点信息
                    System.out.println(temp);
                    // 将temp后移
                    temp = temp.next;
                }
            }
        }
    }

}


// 定义HeroNode，每个HeroNode对象就是一个节点
class DoubleHeroNode {
    public int num;
    public String realName;
    public String nickName;
    public DoubleHeroNode pre; // 指向上一个节点
    public DoubleHeroNode next; // 指向下一个节点

    // 构造器
    public DoubleHeroNode(int hNum, String hRealName, String hNickName) {
        this.num = hNum;
        this.realName = hRealName;
        this.nickName = hNickName;
    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "num=" + num +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}