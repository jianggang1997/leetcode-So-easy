package com.learn.arithemtic.simple;

import lombok.Data;


/**
 * @author jianggang
 * @Date 2019/3/14 10:50:29
 * @Description
 * 合并K个排序列表，并返回合并后的列表 ----->运行未通过，可能是使用成员变量
 *
 * 输入：
 *  [
 *      1->4->5,
 *      1->3->4,
 *      2->6
 *  ]
 *
 * 输出：1->1->2->3->4->4->5->6
 *
 */
public class mergeKLinked {
    private static boolean flag = true;
    private static ListNode head = null;
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next=node5;
        node5.next=node6;
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next=node8;
        ListNode[] lists = {node1,node4,node7};
        solution(lists);
        while (head != null){
            System.out.print("---->"+head.val);
            head  = head.next;
        }
    }

    public static ListNode solution(ListNode[] lists){
         if(lists == null || lists.length < 1){
            return null;
         }
         ListNode head = null;
         minNode(lists,lists[0]);
         return head;
    }


    /**
     * 找出最小的node
     * @param lists
     * @return
     */
    public static void minNode(ListNode[] lists,ListNode end){
        ListNode first = null;
        int index = -1;
        for(int i = 0 , len = lists.length; i<len ; i++){
            if(lists[i] != null){
                first = lists[i];
                index = i;
            }
        }
        if(first == null){
            return;
        }
        for(int i = 0 , len = lists.length; i<len ; i++){
            if(lists[i]!=null && first.val>lists[i].val){
                first = lists[i];
                index = i;
            }
        }
        lists[index] = lists[index].next;
        if(flag){
            flag = false;
            head = first;
            end = first;
        }else {
            end.next = first;
            end = first;
        }
        minNode(lists,end);
    }



    @Data
    static class ListNode{
        int val;

        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }
}
