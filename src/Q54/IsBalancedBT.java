public class IsBalancedBT{
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

    // 如果依次判断每个节点是否平衡会造成大量重复遍历
    // 所以从叶节点开始判断，依次给深度加一
    public boolean IsBalanced(TreeNode root){
        return getDepth(root)!=-1;
    }

    private int getDepth(TreeNode root){
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        if (left == -1)
            return -1;
        int right = getDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left-right) > 1 ? -1 : 1+Math.max(left,right);
    }
}