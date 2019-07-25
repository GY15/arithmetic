package leetcode.middle.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

    //中序和后序
    public static int n = 0;
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0){
            return null;
        }
        if (inorder.length == 1){
            TreeNode head = new TreeNode(inorder[0]);
            return head;
        }
        n = postorder.length-1;
        return buildTree1(inorder,postorder,0,postorder.length);
    }
    public TreeNode buildTree1(int[] inorder, int[] postorder,int begin, int end) {
        if (begin==end){
            return null;
        }
        TreeNode head = new TreeNode(postorder[n]);
        n--;
        for (int i = begin;i < end; i++){
            if (inorder[i] == head.val){

                head.right = buildTree1(inorder,postorder,i+1,end);
                head.left = buildTree1(inorder,postorder,begin,i);
            }
        }
        return head;
    }

    //前序和中序
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (inorder.length == 0){
            return null;
        }
        TreeNode head = new TreeNode(inorder[0]);
        if (inorder.length == 1){
            return head;
        }
        int[] cur = new int[]{0};
        return  buildTree2(inorder,preorder,0,preorder.length,cur);
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder,int begin, int end,int[] cur){
        if (begin==end){
            return null;
        }
        TreeNode head = new TreeNode(inorder[cur[0]]);
        cur[0]++;
        for (int i = begin; i < end;i++){
            if (preorder[i]==head.val){
                head.left = buildTree2(preorder,inorder,begin,i,cur);
                head.right = buildTree2(preorder,inorder,i+1,end,cur);
            }
        }
        return head;
    }
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
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
            int[] preorder = stringToIntegerArray(line);
            line = in.readLine();
            int[] inorder = stringToIntegerArray(line);

            TreeNode ret = new BuildTree().buildTree1(preorder, inorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
