package CodingDaily.LeCo;

public class SymTreeNo101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymTree(root.left, root.right);
    }
    private boolean isSymTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;
        return isSymTree(p.left, q.right) &&
                isSymTree(p.right, q.left);
    }
}
