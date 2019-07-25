package leetcode.middle.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class pathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.empty() || cur!= null){
            if (cur!=null) {
                if (sum < cur.val){
                    cur = null;
                    continue;
                }
                sum -= cur.val;
                stack.add(cur);
                list.add(cur.val);
                if (cur.left==null && cur.right == null && sum == 0){
                    lists.add(new ArrayList<>(list));
                }
                cur = cur.left ;
            } else {
                TreeNode temp = stack.peek();
                if (temp.right!=null){
                    cur = temp.right;
                    temp.right = null;
                }else {
                    stack.pop();
                    sum += temp.val;
                    list.remove(list.size() - 1);
                    cur = temp.right;
                }
            }
        }
        return lists;
    }

    public boolean pathSum2(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        List<List<Integer>> res = new ArrayList();
        List<TreeNode> lists = new ArrayList();
        lists.add(root);
        int height = 0;
        while(lists.size()!=0){
            int n = lists.size();
            height++;
            for(int i = lists.size()-1; i >= 0;i--){
                if(lists.get(i).left==null&&lists.get(i).right==null&&lists.get(i).val == sum){

                }

                if(lists.get(i).left!=null){
                    lists.get(i).left.val+=lists.get(i).val;
                    lists.add(lists.get(i).left);
                }
                if(lists.get(i).right!=null){
                    lists.get(i).right.val+=lists.get(i).val;
                    lists.add(lists.get(i).right);
                }
                lists.remove(i);
            }
        }
        return false;
    }
    public  static class TreeNode {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);

            List<List<Integer>> ret = new pathSum().pathSum(root, sum);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}
