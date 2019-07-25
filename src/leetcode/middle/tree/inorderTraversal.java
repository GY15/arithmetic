package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {

    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
      public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> list = new ArrayList<>();
          readNode(list,root);
          return list;
      }
      public void readNode(List<Integer> list, TreeNode root){
          if (root.left != null){
              readNode(list,root.left);
          }
          list.add(root.val);
          if (root.right != null){
              readNode(list,root.right);
          }
      }
}
