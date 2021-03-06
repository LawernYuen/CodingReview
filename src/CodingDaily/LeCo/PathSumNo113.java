package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.List;

public class PathSumNo113 {
    List<List<Integer>> List = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, list);
        return List;
    }
    private void pathSum(TreeNode root, int sum, List<Integer> list){
        if (root == null)
            return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            List<Integer> templist = new ArrayList<>(list);
            List.add(templist);
        }
        else {
            pathSum(root.left, sum, list);
            pathSum(root.right, sum, list);
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        PathSumNo113 demo = new PathSumNo113();
        demo.pathSum(node1, 22);
    }
}
