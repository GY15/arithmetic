package leetcode.middle.list;

public class RemoveDuplicates {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode start = new ListNode(-1000000);
            start.next = head;
            ListNode last = start;
            ListNode cur = start;
            while(cur.next!=null){
                cur = cur.next;
                if (cur.next!=null&&cur.next.val ==cur.val){
                    while(cur.next!=null && cur.next.val == cur.val) {
                        cur = cur.next;
                    }
                    last.next = cur.next;
                }else{
                    last = cur;
                }
            }
            return start.next;
        }
        public ListNode deleteDuplicates2(ListNode head) {
            ListNode start = new ListNode(-1000000);
            start.next = head;
            ListNode last = start;
            ListNode cur = start;
            while(cur.next!=null){
                cur = cur.next;
                if (cur.val == last.val){
                    last.next = cur.next;
                }else{
                    last = cur;
                }
            }
            return start.next;
        }
        public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
        }
    }
}
