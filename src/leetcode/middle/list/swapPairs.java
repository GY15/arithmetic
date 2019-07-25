package leetcode.middle.list;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode temp = start;
        start.next = head;
        while(start.next != null && start.next.next!=null){
            ListNode node = start.next;
            start.next = node.next;
            node.next = node.next.next;
            start.next.next = node;
        }
        return temp;
    }

     // Definition for singly-linked list.
      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


}
