package CodingDaily.LeCo;

public class PreInBuildTreeNo105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode node = new TreeNode(preorder[0]);
        if (preorder.length == 1 && inorder.length == 1)
            return node;
        int cut = 0;
        while (inorder[cut] != preorder[0])
            cut++;
        int leftsize = cut;
        int rightsize = inorder.length - (cut+1);
        int[] preleft = new int[leftsize];
        int[] inleft = new int[leftsize];
        int[] preright = new int[rightsize];
        int[] inright = new int[rightsize];
        for (int i = 0; i < leftsize; i++){
            preleft[i] = preorder[i+1];
            inleft[i] = inorder[i];
        }
        for (int i = 0; i < rightsize; i++){
            preright[i] = preorder[leftsize+1+i];
            inright[i] = inorder[leftsize+1+i];
        }
        node.left = buildTree(preleft, inleft);
        node.right = buildTree(preright, inright);
        return node;
    }
}
