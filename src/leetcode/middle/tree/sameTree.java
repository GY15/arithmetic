package leetcode.middle.tree;

import java.util.Stack;

public class sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode p1 = p;
        TreeNode q1 = q;
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        while(!ps.empty() || (p1!=null&&q1!=null)){
            if ((p1==null&&q1!=null) || (q1==null&&p1!=null)){
                return false;
            }
            if( p1!=null&&q1!=null &&p1.val!=q1.val){
                return false;
            }
            if (p1!=null){
                ps.add(p1);
                qs.add(q1);
                p1 = p1.left;
                q1 = q1.left;
            }else{
                TreeNode t1 = ps.pop();
                TreeNode t2 = qs.pop();
                p1 = t1.right;
                q1 = t2.right;
            }
        }
        return true;
    }
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}
