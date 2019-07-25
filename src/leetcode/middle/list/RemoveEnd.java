package leetcode.middle.list;

public class RemoveEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null || n==1){
            return null;
        }
        ListNode next = head;
        ListNode needDelete = head;
        while(next.next!=null){
            next = next.next;
            if(n>0){
                n--;
            }else{
                needDelete = needDelete.next;
            }
        }

        needDelete.next = needDelete.next.next;
        return head;
    }

     // Definition for singly-linked list.
      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode head2 = new ListNode(1);
        head.next = head2;
        removeNthFromEnd(head,1);
    }
}
