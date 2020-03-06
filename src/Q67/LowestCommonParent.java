public class LowestCommonParent{
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

    public TreeNode getLCPinBST(TreeNode root, TreeNode node1, TreeNode node2){
        while (true) {
            if (root == null)
                return root;
            if (root.val < node1.val && root.val < node2.val)
                root = root.right;
            else if (root.val > node1.val && root.val > node2.val)
                root = root.left;
            else
                return root;
        }
    }

    public TreeNode getLCPinCommonTree(TreeNode root, TreeNode node1, TreeNode node2){
        if (root == null || root == node1 || root == node2)
            return root;
        TreeNode left = getLCPinCommonTree(root.left, node1, node2);
        TreeNode right = getLCPinCommonTree(root.right, node1, node2);
        return left==null ? right : right==null ? left : root;
    }
}