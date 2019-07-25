package leetcode.middle.tree;

public class maxdepth {
    public static void main(String[] args) {
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return getMaxLength(root);
    }
    int getMaxLength(TreeNode root){
        if (root.left == null && root.right == null){
            return 1;
        }
        int left = -1;
        int right = -1;
        if (root.left != null){
            left = getMaxLength(root.left);
        }
        if (root.right != null){
            right = getMaxLength(root.right);
        }
                return left>right? 1+left:1+right;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
