package interview.alibaba;

import java.util.Stack;

public class findMinOfBst {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
    int res = 0;
    public int findMinK(TreeNode node, int k){
        TreeNode cur = node;
        Stack<TreeNode> stack =new Stack();
        while(cur!=null || !stack.empty()){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.pop();
                k--;
                if (k == 0){
                    return temp.val;
                }
                if (temp.right!=null){
                    cur = temp.right;
                }
            }
        }
        return -1;
    }
}
