package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left=t2;
        t1.right = t3;
        t2.right=t4;
        new binaryTreePaths().binaryTreePaths(t1);
    }
        public List<String> binaryTreePaths(TreeNode root) {
            if(root.left==null && root.right==null){
                List<String> temp = new ArrayList<>();
                temp.add(root.val+"");
                return temp;
            }
            List<String> list = new ArrayList<>();
            if(root.left!=null){
                List<String> temp = binaryTreePaths(root.left);
                List<String> temp2 = new ArrayList<>();
                for(int i = 0; i < temp.size();i++){
                    temp2.add(root.val+"->"+temp.get(i));
                }
                list.addAll(temp2);
            }
            if(root.right!=null){
                List<String> temp = binaryTreePaths(root.right);
                List<String> temp2 = new ArrayList<>();
                for(int i = 0; i < temp.size();i++){
                    temp2.add(root.val+"->"+temp.get(i));
                }
                list.addAll(temp2);
            }
            return list;
        }
}
