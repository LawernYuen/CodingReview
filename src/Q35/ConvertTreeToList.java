public class ConvertTreeToList{
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

    public TreeNode convert(TreeNode head){
        if (head == null)
            return head;
        TreeNode lastNode = null;
        lastNode = convertCore(head, lastNode);
        TreeNode firstNode = lastNode;
        while (firstNode != null)
            firstNode = firstNode.left;
        return firstNode;
    }

    private TreeNode convertCore(TreeNode node, TreeNode lastNode){
        // left
        if (node.left != null)
            lastNode = convertCore(node.left, lastNode);
        // last node in list and root
        node.left = lastNode;
        if (lastNode != null)
            lastNode.right = node;
        // right
        lastNode = node;
        if (node.right != null)
            lastNode = convertCore(node.right, lastNode);
        return lastNode;
    }
}