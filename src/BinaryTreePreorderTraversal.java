package leetcode;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode right;
    TreeNode left;
}

public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if(root == null)
            return res;

        helper(res, root);

        return res;
    }

    public static void helper(List<Integer> res, TreeNode root){
        if(root == null)
            return res;

        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    public static List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.right != null)
                stack.push(node.right);

            if(node.left != null)
                stack.push(node.left);

            res.add(node.val);
        }

        return res;
    }
}
