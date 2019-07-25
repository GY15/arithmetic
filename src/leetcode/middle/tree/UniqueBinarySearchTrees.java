package leetcode.middle.tree;

public class UniqueBinarySearchTrees {
    public class TreeNode {
        int val;
        inorderTraversal.TreeNode left;
        inorderTraversal.TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int numTrees(int n) {
        if(n==0){
            return 0;

        }
        return genTreeList(1,n);
    }

    private int genTreeList (int start, int end) {
        int res = 0;
        if (start > end) {
            return 1;
        }
        for(int idx = start; idx <= end; idx++) {
            int leftList = genTreeList(start, idx - 1);
            int rightList = genTreeList(idx + 1, end);
            res += leftList*rightList;
        }
        return res;
    }
    //递归会超时
    //下面是别人的解法，既吧递归的每一次值保存下来直接取用
    public int numTrees2(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }
}
