public class SubstructureInTree{
    private class TreeNode{
        double val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 == null)
            return false;
        return doesTree1HaveTree2(root1, root2)
                || hasSubtree(root1.left, root2)
                || hasSubtree(root1.right, root2);
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return equal(root1.val, root2.val)
                && doesTree1HaveTree2(root1.left, root2.left)
                && doesTree1HaveTree2(root1.right, root2.right);
    }

    private boolean equal(double num1, double num2){
        if (math.abs(num1 - num2) < 1e-6)
            return true;
        return false;
    }
}