package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class rightVisionOfTreeNo199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        int curCount = 0;
        int nexCount = 1;
        List<Integer> list = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            curCount = nexCount;
            nexCount = 0;
            for (int i = 0; i < curCount; i++) {
                TreeNode node = queue.remove(0);
                if (i == curCount-1)
                    list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    nexCount++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    nexCount++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;
        rightVisionOfTreeNo199 demo = new rightVisionOfTreeNo199();
        List<Integer> list = demo.rightSideView(node1);
        System.out.println(list);
    }
}
