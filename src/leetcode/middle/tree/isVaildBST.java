package leetcode.middle.tree;

import java.util.Stack;

public class isVaildBST {
    /**
     * Definition for a binary tree node.
     *
     * 要看到 二叉搜索树的本质 ，z型排列大小
     *
     */


        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
        public static void main(String[] args) {
            TreeNode n1 = new TreeNode(1);
            TreeNode n2 = new TreeNode(2);
            TreeNode n3 = new TreeNode(3);
            TreeNode n4 = new TreeNode(4);
            TreeNode n5 = new TreeNode(5);
            TreeNode n6 = new TreeNode(6);
            n5.left=n4;
            n4.left=n2;
            n4.right=n6;
            n2.left=n1;
            n2.right=n3;
            new isVaildBST().isValidBST(n5);
        }
    public boolean isValidBST (TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root ;
        TreeNode pre = null ;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left ;
            } else {
                TreeNode p = stack.pop() ;
                if (pre != null && p.val <= pre.val) {
                    return false ;
                }
                pre = p ;
                cur = p.right ;
            }
        }
        return true ;
    }
}
