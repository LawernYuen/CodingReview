public class NextNodeInBinaryTrees{
    private class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null;
        TreeLinkNode(int val){
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){
            System.out.print("The node is null.");
            return null;
        }
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        while (pNode.parent != null){
            if (pNode == pNode.parent.left)
                return pNode.parent;
            pNode = pNode.parent;
        }
        return null;
    }
}