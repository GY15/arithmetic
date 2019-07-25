package leetcode.middle.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RecoverTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n3.left=n1;
        n4.left=n2;
        n3.right=n4;
//        n2.left=n1;
//        n2.right=n3;
        new RecoverTree().recoverTree(n3);
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        int n = 0;
        int temp = 0;
        while (!stack.empty()||cur!=null){
            if (cur!=null){
                stack.add(cur);
                cur =cur.left;
            }else{
                TreeNode p = stack.pop();
                list.add(p);
                temp++;
                if (pre != null && p.val <= pre.val) {
                    n = temp;
                }
                pre = p;
                cur = p.right;
            }
        }
        int val = list.get(n-1).val;
        for (int i = n-2;i>=0;i--){
            if (list.get(i).val > val && (i-1<0||list.get(i - 1).val < val)) {
                list.get(n - 1).val = list.get(i).val;
                list.get(i).val = val;
                break;
            }
        }
    }

}
