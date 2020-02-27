public class ConstructBinaryTree{
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if (pre == null || in == null || pre.length != in.length || pre.length <= 0)
            throw new RuntimeException("Wrong Arguments!");
        return construct(pre, in, 0, pre.length-1, 0, in.length-1);
    }

    public TreeNode construct(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd){
        TreeNode root = new TreeNode(pre[pStart]);
        if (pStart == pEnd && iStart == iEnd){
            if (pre[pStart] != in[iStart])
                throw new RuntimeException("Wrong Arguments!");
            return root;
        }
        int index = iStart;
        while (root.val != in[index] && index <= iEnd)
            index++;
        int leftLength = index - iStart;
        if (leftLength > 0)
            root.left = construct(pre, in, pStart+1, pStart+leftLength, iStart, index-1);
        if (leftLength < iEnd - iStart)
            root.right = construct(pre, in, pStart+leftLength+1, pEnd, index+1, iEnd);
        return root;
    }

    private void preOrderTraverse(TreeNode node){
        if (node == null)
            return;
        System.out.print(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    private void inOrderTraverse(TreeNode node){
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val);
        inOrderTraverse(node.right);
    }
}