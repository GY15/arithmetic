package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size()!=0){
            rightView.add(list.peekLast().val);
            for (int i = 0; i < list.size();i++){
                TreeNode temp = list.remove(i);
                i--;
                if (temp.left != null){
                    list.add(i+1, temp.left);
                    i++;
                }
                if (temp.right != null){
                    list.add(i+1, temp.right);
                    i++;
                }
            }
        }
        return rightView;
    }
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
}
