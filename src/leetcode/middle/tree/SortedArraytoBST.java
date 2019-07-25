package leetcode.middle.tree;

public class SortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return convertTree(nums,0,nums.length);
    }

    private TreeNode convertTree(int[] nums, int begin, int end) {
        if (begin==end){
            return null;
        }
        TreeNode head = new TreeNode(nums[(begin+end)/2]);
        head.left = convertTree(nums, begin,(begin+end)/2);
        head.right = convertTree(nums,(begin+end)/2+1,end);
        return head;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
