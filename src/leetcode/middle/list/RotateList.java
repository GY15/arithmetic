package leetcode.middle.list;

public class RotateList {
    /*
    * 把倒数第n个数作为list的头
    * */
    public ListNode rotateRight(ListNode head, int k) {
        int i = k;
        ListNode temp2 = null;
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            i--;
            if (i == 0) {
                temp2 = head;
            } else if (i < 0){
                temp2 = temp2.next;
            }
        }
        i--;
        if (temp2!=null){
            temp.next = head;
            head = temp2.next;
            temp2.next = null;
            return head;
        }else {
            i = k%(k-i);
            return rotateRight(head,i);
        }
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        ListNode head2= new ListNode(2);
        ListNode head3= new ListNode(3);
        ListNode head4= new ListNode(4);
        ListNode head5= new ListNode(5);
        head.next = head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        head5.next=null;
        new RotateList().rotateRight(head,8);
    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


}
