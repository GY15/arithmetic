package leetcode.middle.list;

import java.util.List;

public class ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list = new ListNode(0);
        while(slow!=null){
            ListNode temp= slow.next;
            slow.next = list.next;
            list.next = slow;
            slow = temp;
        }
        list = list.next;

        ListNode node = head;
        while(list.next!=null){
            ListNode temp = list.next;
            list.next = node.next;
            node.next = list;
            list = temp;
            node = node.next.next;
        }
        list = null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        new ReorderList().reorderList(n1);
    }
}
