package leetcode.middle.tree;

public class FlattenBinaryTreetoLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        if(root.right!=null){
            flatten(root.right);
        }
        if(root.left!=null){
            TreeNode left = root.left;
            flatten(root.left);
            root.left= null;
            TreeNode last = left;
            while (last.right != null){
                last = last.right;
            }
            last.right = root.right;
            root.right = left;
        }
    }
}
