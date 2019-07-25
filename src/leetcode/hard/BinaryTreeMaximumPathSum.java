package leetcode.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        int n = getMaxTree(root,res);

        return Math.max(n,res[0]);

    }
    public int getMaxTree(TreeNode node, int[] res){
        if (node.left != null){
            int left = getMaxTree(node.left,res);
            res[0] = Math.max(left,res[0]);
            if (node.right != null){
                int right = getMaxTree(node.right,res);
                res[0] = Math.max(right,res[0]);

                if (left<0){
                    if (right<0){
                        return node.val;
                    }else{
                        return node.val + right;
                    }
                }else{
                    if (right<0){
                        return node.val + left;
                    }else{
                        res[0] = Math.max(node.val + left + right,res[0]);
                        return node.val + Math.max(left,right);
                    }
                }
            }

            if (left<0){
                return node.val;
            }else{
                return node.val + left;
            }

        }
        if (node.right != null){
            int right = getMaxTree(node.right,res);
            res[0] = Math.max(right,res[0]);
            if (right<0){
                return node.val;
            }else{
               return  node.val + right;
            }
        }
        return node.val;

    }
   public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new BinaryTreeMaximumPathSum().maxPathSum(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
