package leetcode.middle.number;

public class addTwoNumbers {
    //***
     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          int result;
          ListNode node = null;
          ListNode last = null;
          int bit = 0;


          while (l1 != null) {
              if (l2 == null){
                  result =(l1.val + bit)%10;
                  bit = (l1.val + bit) /10;
                  l1 = l1.next;
              } else {
                  result =(l1.val + l2.val + bit)%10;
                  bit = (l1.val + l2.val + bit) /10;
                  l1 = l1.next;
                  l2 = l2.next;
              }
              if (node == null){
                  node = new ListNode(result);
                  last = node;
              }else{
                  ListNode temp = new ListNode(result);
                  last.next = temp;
                  last = temp;
              }
          }
          while (l2 != null) {
              result =(l2.val + bit)%10;
              bit = 0;
              if (node == null){
                  node = new ListNode(result);
                  last = node;
              }else{
                  ListNode temp = new ListNode(result);
                  last.next = temp;
                  last = temp;
              }
          }
          if (bit == 0){
              ListNode temp = new ListNode(1);
              last.next = temp;
          }
          return node;
     }
}
