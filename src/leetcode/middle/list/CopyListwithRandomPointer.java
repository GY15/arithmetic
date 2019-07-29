package leetcode.middle.list;

public class CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        Node head1 = copy(head);
        return head1;
    }
    Node copy(Node node){
        Node next =null;
        if (node.next!=null){
            next = copy(node);
            return new Node(node.val,next,node.random);
        }else{
            return new Node(node.val,null,node.random);
        }
    }
    class Node {
        public int val;
        public Node next;
        public Node random;
        public Node() {}
        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
