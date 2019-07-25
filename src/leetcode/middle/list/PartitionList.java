package leetcode.middle.list;

public class PartitionList {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(7);
        l1.next =l2;
        l2.next =l3;
        l3.next =l4;
        l4.next =l5;
        l5.next =l6;
        new PartitionList().partition(l1,3);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftLast = left;
        ListNode rightLast = right;
        while(head.next!=null){
            ListNode temp =head.next;
            if (head.val <x){
                leftLast.next = head;
                leftLast =leftLast.next;
            }else{
                rightLast.next = head;
                rightLast = rightLast.next;
            }
            head = temp;
        }
        if (head.val <x){
            leftLast.next = head;
            rightLast.next = null;
            leftLast.next.next = right.next;
        }else{
            rightLast.next = head;
            leftLast.next = right.next;
        }
        return left.next;
    }
    //  2 3 4 1 1 2 3 4
}
