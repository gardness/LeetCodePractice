import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = res.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();

                if(cur.left != null)
                    queue.offer(cur.left);

                if(cur.right != null)
                    queue.offer(cur.right);

                list.add(cur.val);
            }

            res.add(list);
        }

        return res;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;

        helper(res, root, 0);

        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int level){
        if(root == null)
            return;

        if(level >= res.size()){
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
