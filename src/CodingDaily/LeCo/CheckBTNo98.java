package CodingDaily.LeCo;

public class CheckBTNo98 {
    private long temp = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (root.val > temp)
            temp = root.val;
        else
            return false;
        if (!isValidBST(root.right))
            return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        CheckBTNo98 demo = new CheckBTNo98();
        boolean ans = demo.isValidBST(node1);
        System.out.println(ans);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
