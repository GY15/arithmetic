package leetcode.middle.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class lowestCommonAncestor {
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

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            TreeNode p = stringToTreeNode(line);
            line = in.readLine();
            TreeNode q = stringToTreeNode(line);

            TreeNode ret = new lowestCommonAncestor().lowestCommonAncestor(root, p, q);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode cur = root,last = null;
        Stack<TreeNode> res = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean hasFind = false;
        while((!res.empty()&&!stack.empty()) || cur!=null){
            if(cur != null){
                if(hasFind){
                    stack.push(cur);
                }else{
                    res.push(cur);
                }
                if(cur.val == p.val || cur.val == q.val){
                    if(hasFind){
                        return last;
                    }
                    hasFind =true;
                    last = cur;
                }
                cur = cur.left;
                continue;
            }
            if(!stack.empty()){
                cur = stack.pop();
            }else{
                cur = res.pop();
                if(hasFind) {
                    last = cur;
                }
            }
            cur = cur.right;
        }
        return null;
    }
}
