package CodingDaily.Tests;

import java.util.LinkedList;

public class traverseLayer {
    public void traLayer(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp);
            if (root.left != null)
                queue.add(temp.left);
            if (root.right != null)
                queue.add(temp.right);
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
