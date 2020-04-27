package CodingDaily.LeCo;

public class MaxDepthNo104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
