public class TreeDepth{
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int TreeDepth(TreeNode root){
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left+1, right+1);
    }
}