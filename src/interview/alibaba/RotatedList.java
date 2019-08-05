package interview.alibaba;


public class RotatedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /*
    * 问题：如何实现一个高效的单向链表逆序输出？
    */
    public ListNode rotated(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode h = new ListNode(0);
        while(head!=null){
            ListNode temp = head;
            head = head.next;
            temp.next = h.next;
            h.next = temp;
        }
        while(h.next!=null){
            System.out.println(h.next.val);
            h= h.next;
        }
        return h.next;
    }

}
