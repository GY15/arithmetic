package leetcode.middle.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeNSortedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = null;
        listNodes[1] = new ListNode(1);
        new MergeNSortedList().mergeKLists(listNodes);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (int i = 0; i < lists.length;i++)
            if (lists[i]!=null)
                queue.add(lists[i]);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
