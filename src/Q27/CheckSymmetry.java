public class CheckSymmetry{
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

    public boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
        if (pRoot1 == null && pRoot2 == null)
            return true;
        if (pRoot1 == null || pRoot2 == null)
            return false;
        return pRoot1.val == pRoot2.val
                && isSymmetrical(pRoot1.left, pRoot2.right)
                && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}