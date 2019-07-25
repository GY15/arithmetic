package leetcode.hard;

public class reverseKGroupList {
    public ListNode reverseKGroup(ListNode head,int k) {
        ListNode curStart = new ListNode(0);
        curStart.next =head;
        ListNode res = curStart;
        ListNode lastEnd =null;

        int k2 = k;
        while (curStart.next != null){

            if (k2==k) {
                ListNode temp = curStart;
                for (int i = 0; i < k; i++) {
                    temp = temp.next;
                    if (temp == null){
                        break;
                    }
                }
                if (temp==null){
                    return res.next;
                }

                lastEnd = curStart;
                curStart = curStart.next;
            }else {
                ListNode temp = curStart.next;
                ListNode n = lastEnd.next;
                curStart.next = temp.next;
                temp.next = n;
                lastEnd.next = temp;
            }

            k2--;
            if (k2 == 0){
               k2=k;
               lastEnd = curStart;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        new reverseKGroupList().reverseKGroup(node, 3);
    }
     // Definition for singly-linked list.
      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


}
