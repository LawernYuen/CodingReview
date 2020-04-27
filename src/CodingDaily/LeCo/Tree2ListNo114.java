package CodingDaily.LeCo;

public class Tree2ListNo114 {
    public void flatten(TreeNode root) {
        while (root != null){
            if (root.left == null)
                root = root.right;
            else {
                TreeNode left = root.left;
                while (left.right != null)
                    left = left.right;
                left.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        Tree2ListNo114 demo = new Tree2ListNo114();
        demo.flatten(node1);
    }
}
