package leetcode.middle.tree;

public class isSymmetric {
    public boolean isSymmetric(RecoverTree.TreeNode root) {
        if(root==null) {
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(RecoverTree.TreeNode p, RecoverTree.TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}
