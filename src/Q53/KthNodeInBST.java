public class KthNodeInBST{
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

    private int index = 0;
    public TreeNode getKthNode(TreeNode pRoot, int k){
        if (pRoot == null || k <= 0)
            return null;
        TreeNode pNode =
        return pNode;
    }

    private TreeNode KthNode(TreeNode pRoot, int k){
        TreeNode kthNode = null;
        if (pRoot.left != null)
            kthNode = KthNode(pRoot.left, k);
        if (kthNode == null){
            index++;
            if (k == index){
                kthNode = pRoot;
                return kthNode;
            }
        }
        if (pRoot.right != null)
            kthNode = KthNode(pRoot.right, k);
        return null;
    }
}