package com.yonmin.linkedlist;

import java.util.Arrays;
import java.util.Stack;

/**
 * 定义一个单向链表，保存水浒传英雄的编号、姓名和绰号
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode newhero3 = new HeroNode(3, "YonminMa", "智多星");

        // 创建链表
        SingleLinkedList linkedList = new SingleLinkedList();

        // 将节点加入链表中
//        linkedList.add(hero1);
//        linkedList.add(hero2);
//        linkedList.add(hero3);

        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);
        linkedList.update(newhero3);
        linkedList.delete(2);

        SingleLinkedListDemo.reverse(linkedList.getHead());

        // 显示链表
        linkedList.list();
    }

    public static void reverse(HeroNode head) {
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode cur = head.getNext();
        HeroNode next;
        while (cur != null) {
            // 保存当前节点的下一个节点
            next = cur.getNext();
            // 将当前节点插入到头结点和头结点后的节点之间
            cur.setNext(reverseHead.getNext());
            reverseHead.setNext(cur);
            // 将cur后移
            cur = next;
        }
        head.setNext(reverseHead.getNext());
    }

    public static int[] reversePrint(HeroNode head) {
        if(head == null) {
            return new int[0];
        }
        HeroNode temp = head;
        int count = 0;
        while(temp != null) {
            count ++;
            temp = temp.getNext();
        }
        int[] NodeArray = new int[count];
        temp = head;
        for(int i = count - 1; i >= 0; --i) {
            NodeArray[i] = temp.getNum();
            temp = temp.getNext();
        }
        return NodeArray;
    }

}

// 定义SingleLinkedList管理英雄
class SingleLinkedList {
    // 初始化头节点，头节点位置不变，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    public void add(HeroNode heroNode) {
        HeroNode temp = head;

        // 遍历链表，找到链表最后
        while (true) {
            // 找到最后，退出循环
            if (temp.getNext() == null) {
                break;
            } else {
                // 如果没有找到最后，将temp后移
                temp = temp.getNext();
            }
        }
        // 退出while循环时，temp就指向了最后的节点
        temp.setNext(heroNode);
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; // 标志英雄添加的编号是否存在，默认为false
        while (true) {
            if (temp.getNext() == null) {
                break;
            } else {
                if (temp.getNext().getNum() > heroNode.getNum()) {
                    // 说明找到位置，在temp后面添加
                    break;
                } else  if (temp.getNext().getNum() == heroNode.getNum()) {
                    // 说明编号存在
                    flag = true;
                    break;
                }
                // temp后移
                temp = temp.getNext();
            }
        }
        // 判断flag的值
        if (flag) { // 说明编号存在，不能添加
            System.out.printf("添加的英雄编号%d已经存在，不能添加\n", heroNode.getNum());
        } else {
            // 插入到链表中
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    // 修改节点，根据新传入的节点的num修改
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
        } else {
            // 遍历
            HeroNode temp = head.getNext();
            while (true) {
                if (temp == null) {
                    System.out.println("没有找到要修改的节点");
                    break;
                } else if (temp.getNum() == newHeroNode.getNum()) {
                    temp.setRealName(newHeroNode.getRealName());
                    temp.setNickName(newHeroNode.getNickName());
                    break;
                }
                temp = temp.getNext();
            }
        }
    }

    /**
     * 删除节点
     * @param number 要删除节点的num值
     */
    public void delete(int number) {
        // 遍历
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                System.out.println("没有找到要删除的节点");
                break;
            } else if (temp.getNext().getNum() == number) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }

    // 显示链表
    public void list() {
        // 判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        } else {
            HeroNode temp = head.getNext();
            while (true) {
                // 判断是否到达最后
                if (temp == null) {
                    // 到达最后退出循环
                    break;
                } else {
                    // 否则输出节点信息
                    System.out.println(temp);
                    // 将temp后移
                    temp = temp.getNext();
                }
            }
        }
    }

}



// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    private int num;
    private String realName;
    private String nickName;
    private HeroNode next; // 指向下一个节点
    // 构造器
    public HeroNode(int hNum, String hRealName, String hNickName) {
        this.num = hNum;
        this.realName = hRealName;
        this.nickName = hNickName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}