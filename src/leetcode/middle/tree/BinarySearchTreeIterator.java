package leetcode.middle.tree;

import java.util.Stack;

public class BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur;
    public BinarySearchTreeIterator(TreeNode root) {
        cur = root;
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode temp = stack.pop();
        if (temp.right != null){
            cur = temp.right;
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return temp.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.empty();
    }
}
