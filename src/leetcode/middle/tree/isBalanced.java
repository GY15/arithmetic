package leetcode.middle.tree;

public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        return isBalance(root) != -1;
    }
    public int isBalance(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = isBalance(root.left);
        int right = isBalance(root.right);
        if (left == -1 || right == -1){
            return -1;
        }
        if (left >= right){
             if (left-right > 1){
                 return  -1;
             }else{
                 return left+1;
             }
        } else {
            if (right - left > 1){
                return  -1;
            } else {
                return right+1;
            }
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
